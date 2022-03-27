package com.alphasense.rc.api;

import com.alphasense.rc.baseTest.BaseApiTest;
import io.qameta.allure.AllureId;
import org.junit.jupiter.api.*;
import com.alphasense.rc.pojo.RcResponse;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ApiTests extends BaseApiTest {

    Search search = new Search();
    RcResponse response;

    @Test
    @DisplayName("API test: Searching text \"test\" in document")
    @AllureId("121")
    void searchNotExistingTextApiTest() {
        response = search.searchInText("test");

        assertThat(response.getTopics().get(0).getSolrTopicTag(), equalTo("ᛁᛁdiagnosticᛁᛁ"));
        assertThat(response.getTopics().get(0).getPos(), equalTo(0));
        assertThat(response.getTopics().get(0).getLength(), equalTo(4));
        assertThat(response.getSearchResults().getOriginalStatementCount(), equalTo(0));
        assertThat(response.getSearchResults().getStatements().isEmpty(), equalTo(true));
    }

    @Test
    @DisplayName("API test: Searching text \"AlphaSense\" in document")
    @AllureId("122")
    void searchValidTextApiTest() {
        response = search.searchInText("AlphaSense");

        assertThat(response.getTopics().isEmpty(), equalTo(true));
        assertThat(response.getSearchResults().getOriginalStatementCount(), equalTo(17));
        assertThat(response.getSearchResults().getStatements().size(), equalTo(17));
    }

    @Test
    @DisplayName("API invalid test: Searching text \"test\" in document")
    @AllureId("123")
    void searchValidTextWrongApiTest() {
        response = search.searchInText("test");

        assertThat(response.getTopics().get(0).getSolrTopicTag(), equalTo("ᛁᛁdiagnosticᛁᛁ"));
        assertThat(response.getTopics().get(0).getPos(), equalTo(1));
        assertThat(response.getTopics().get(0).getLength(), equalTo(5));
        assertThat(response.getSearchResults().getOriginalStatementCount(), equalTo(0));
        assertThat(response.getSearchResults().getStatements().isEmpty(), equalTo(false));
    }
}

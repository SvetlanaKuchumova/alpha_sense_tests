package api;

import baseTest.BaseApiTest;
import io.qameta.allure.AllureId;
import org.junit.jupiter.api.*;
import pojo.RcResponse;

import static enums.Documents.ALPHA_SENSE_DOC_API;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ApiTests extends BaseApiTest {

    @Test
    @DisplayName("API test: Searching text \"test\" in document")
    @AllureId("121")
    void searchNotExistingTextApiTest() {
        RcResponse response = given()
                .when()
                .queryParam("keyword", "test")
                .get(ALPHA_SENSE_DOC_API.getValue())
                .as(RcResponse.class);

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
        RcResponse response = given()
                .when()
                .queryParam("keyword", "AlphaSense")
                .get(ALPHA_SENSE_DOC_API.getValue())
                .as(RcResponse.class);

        assertThat(response.getTopics().isEmpty(), equalTo(true));
        assertThat(response.getSearchResults().getOriginalStatementCount(), equalTo(17));
        assertThat(response.getSearchResults().getStatements().size(), equalTo(17));
    }

    @Test
    @DisplayName("API invalid test: Searching text \"test\" in document")
    @AllureId("123")
    void searchValidTextWrongApiTest() {
        RcResponse response = given()
                .when()
                .queryParam("keyword", "test")
                .get(ALPHA_SENSE_DOC_API.getValue())
                .as(RcResponse.class);

        assertThat(response.getTopics().get(0).getSolrTopicTag(), equalTo("ᛁᛁdiagnosticᛁᛁ"));
        assertThat(response.getTopics().get(0).getPos(), equalTo(1));
        assertThat(response.getTopics().get(0).getLength(), equalTo(5));
        assertThat(response.getSearchResults().getOriginalStatementCount(), equalTo(0));
        assertThat(response.getSearchResults().getStatements().isEmpty(), equalTo(false));
    }
}

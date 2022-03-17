package ui;

import baseTest.BaseTest;
import io.qameta.allure.AllureId;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pageObject.SearchInDocPage;
import static com.codeborne.selenide.Selenide.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static enums.Documents.ALPHA_SENSE_DOC;

@DisplayName("Searching Tests")
public class SearchTests extends BaseTest {

    public static SearchInDocPage searchInDocPage = new SearchInDocPage();

    @Test
    @DisplayName("Searching text in document")
    @AllureId("120")
    public void searchTest() {
        searchInDocPage.openRcUrl(ALPHA_SENSE_DOC.getValue());
        searchInDocPage.enterTextInDocSearchField("AlphaSense");
        searchInDocPage.scrollToEndSearch();
        searchInDocPage.clickLastResultSearch();
        searchInDocPage.checkHighlightedStatement();
    }
}

package ui;

import baseTest.BaseTest;
import io.qameta.allure.AllureId;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pageObject.SearchInDocPage;
import static enums.Documents.ALPHA_SENSE_DOC_UI;

@DisplayName("Searching Tests")
public class SearchTests extends BaseTest {

    public static SearchInDocPage searchInDocPage = new SearchInDocPage();

    @Test
    @DisplayName("UI test: Searching text in document")
    @AllureId("120")
    public void searchTextUiTest() {
        searchInDocPage.openRcUrl(ALPHA_SENSE_DOC_UI.getValue());
        searchInDocPage.enterTextInDocSearchField("AlphaSense"); // hidden element
        searchInDocPage.scrollToEndSearch();
        searchInDocPage.clickLastResultSearch();
        searchInDocPage.checkHighlightedStatement();
    }
}

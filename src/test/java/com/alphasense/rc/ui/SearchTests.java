package com.alphasense.rc.ui;

import com.alphasense.rc.baseTest.BaseTest;
import io.qameta.allure.AllureId;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.alphasense.rc.pageObject.SearchInDocPage;
import static com.alphasense.rc.enums.Documents.ALPHA_SENSE_DOC_UI;

@DisplayName("Searching Tests")
public class SearchTests extends BaseTest {

    public static SearchInDocPage searchInDocPage = new SearchInDocPage();

    @Test
    @DisplayName("UI test: Searching text in document")
    @AllureId("120")
    public void searchTextUiTest() {
        searchInDocPage.openRcUrl(ALPHA_SENSE_DOC_UI.getValue())
                .enterTextInDocSearchField("AlphaSense")// hidden element
                .scrollToEndSearch()
                .clickLastResultSearch()
                .checkHighlightedStatement();
    }
}

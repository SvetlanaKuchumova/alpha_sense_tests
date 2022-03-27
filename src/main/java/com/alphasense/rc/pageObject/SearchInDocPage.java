package com.alphasense.rc.pageObject;

import com.alphasense.rc.allure.AllureLogging;
import com.codeborne.selenide.SelenideElement;
import com.alphasense.rc.config.WebConfig;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class SearchInDocPage {

    static final WebConfig config = ConfigFactory.create(WebConfig.class, System.getProperties());
    private static String rcUrl = config.rcUrl();
    private final String HIGHLIGHTEDCOLOR = "rgba(255, 190, 0, 1)";
    AllureLogging allure = new AllureLogging();

    private SelenideElement emailField = $(By.id("Email"));
    private SelenideElement searchTextField = $(By.xpath("//textarea[@autocorrect='off']"));
    private SelenideElement middleSearchResultList = $(By.xpath("(//div[@class='snippetItem-wrapper'])[5]"));
    private SelenideElement endSearchResultList = $(By.xpath("(//div[@class='snippetItem-wrapper'])[9]"));
    private SelenideElement lastSearchResult = $(By.xpath("//span[text()='Logo - ']"));
    private SelenideElement statement = $(By.xpath("//span[text()='https://mma.prnewswire.com/media/947841/AlphaSense_Logo.jpg']"));

    @Step("Open page with document")
    public SearchInDocPage openRcUrl(String doc) {
        open(rcUrl + doc);
        return this;
    }

    @Step("Enter email")
    public SearchInDocPage enterEmail(String email) {
        emailField.val(email);
        return this;
    }

    @Step("Enter text in document search field")
    public SearchInDocPage enterTextInDocSearchField(String text) {
        searchTextField.val(text);
        return this;
    }

    @Step("Scroll to end of searching")
    public SearchInDocPage scrollToEndSearch() {
        middleSearchResultList.scrollIntoView(true);
        endSearchResultList.scrollIntoView(true);
        return this;
    }

    @Step("Click on last result")
    public SearchInDocPage clickLastResultSearch() {
        lastSearchResult.click();
        return this;
    }

    @Step("Check Highlighted Statement")
    public SearchInDocPage checkHighlightedStatement() {
        String colorStatement = statement.getCssValue("background-color");
        assertThat(colorStatement, allure.logMatcherWithText("Checking background-color",
                equalTo(HIGHLIGHTEDCOLOR)));
    return this;
    }
}

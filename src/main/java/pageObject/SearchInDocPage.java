package pageObject;

import com.codeborne.selenide.SelenideElement;
import config.WebConfig;
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

    private SelenideElement emailField= $(By.id("Email"));
    private SelenideElement searchTextField= $(By.xpath("//textarea[@autocorrect='off']"));
    private SelenideElement middleSearchResultList = $(By.xpath("(//div[@class='snippetItem-wrapper'])[5]"));
    private SelenideElement endSearchResultList = $(By.xpath("(//div[@class='snippetItem-wrapper'])[9]"));
    private SelenideElement lastSearchResult = $(By.xpath("//span[text()='Logo - ']"));
    private SelenideElement statement = $(By.xpath("//span[text()='https://mma.prnewswire.com/media/947841/AlphaSense_Logo.jpg']"));

    @Step ("Open page with document")
    public static void openRcUrl(String doc) {
        open(rcUrl + doc);
    }

    @Step ("Enter email")
    public void enterEmail(String email) {
        emailField.val(email);
    }

    @Step ("Enter text in document search field")
    public void enterTextInDocSearchField(String text) {
        searchTextField.val(text);
    }

    @Step ("Scroll to end of searching")
    public void scrollToEndSearch() {
        middleSearchResultList.scrollIntoView(true);
        endSearchResultList.scrollIntoView(true);
    }
    @Step ("Click on last result")
    public void clickLastResultSearch() {
        lastSearchResult.click();
    }

    @Step ("Check Highlighted Statement")
    public void checkHighlightedStatement() {
        String colorstatement = statement.getCssValue("background-color");
        assertThat(colorstatement, equalTo(HIGHLIGHTEDCOLOR));
    }
}

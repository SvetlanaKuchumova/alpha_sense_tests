package baseTest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.WebConfig;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeEach;
import org.slf4j.bridge.SLF4JBridgeHandler;

public class BaseTest {

    @BeforeAll
    public static void setUp() {
        getConfig();
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
        setSelenideConfiguration();
        System.setProperty("java.util.logging.SimpleFormatter.format", "%1$tT %4$s %5$s%6$s%n");
        SLF4JBridgeHandler.removeHandlersForRootLogger();
        SLF4JBridgeHandler.install();
    }

    @BeforeEach
    public void clean1() {
        Selenide.closeWebDriver();
    }

    @AfterEach
    public void clean() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        Selenide.closeWebDriver();
    }

    private static void setSelenideConfiguration() {
        Configuration.pageLoadTimeout = 1000 * 120;
        Configuration.timeout = 30 * 1000;
    }

    private static WebConfig getConfig() {
        if (System.getProperty("environment") == null) System.setProperty("environment", "prod");
        return ConfigFactory.newInstance().create(WebConfig.class, System.getProperties());
    }
}

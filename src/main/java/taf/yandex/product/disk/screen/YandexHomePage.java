package taf.yandex.product.disk.screen;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import taf.framework.loger.Log;
import taf.framework.ui.Browser;

public class YandexHomePage {

    private By loginButtonLocator = By.xpath("//a[contains(@class, 'desk-notif-card__login-enter-expanded')]");

    private static final String START_URL = "https://www.yandex.ru";

    private String tabYandex;

    public YandexHomePage() {
        PageFactory.initElements(Browser.getInstance().getWrappedDriver(), this);
    }

    public YandexLogInAccountPage loginToYandex() {

        Browser.getInstance().getWrappedDriver().get(START_URL);
        Log.info("Starting page of the test is: " + START_URL);

        tabYandex = Browser.getInstance().getWrappedDriver().getWindowHandle();

        Browser.getInstance().click(loginButtonLocator);

        return new YandexLogInAccountPage();
    }

    public String getTabYandexHome() {
        return tabYandex;
    }

}

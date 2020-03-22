package taf.yandex.product.disk.screen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import taf.framework.ui.Browser;

public class YandexLogInAccountPage {

    private WebElement loginName;

    private By loginLocator = By.xpath("//input[@id='passp-field-login']");

    public YandexLogInAccountPage() {

        PageFactory.initElements(Browser.getInstance().getWrappedDriver(), this);
    }

    public YandexLogInPasswordPage loginToAccound(String login) {

        Browser.getInstance().type(loginLocator, login);
        loginName = Browser.getInstance().getWrappedDriver().findElement(loginLocator);
        loginName.submit();

        return new YandexLogInPasswordPage();
    }

}

package taf.yandex.product.disk.screen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import taf.framework.loger.Log;
import taf.framework.ui.Browser;

public class YandexLogInPasswordPage {

    private By loginPasswordLocator = By.xpath("//input[@id='passp-field-passwd']");

    public YandexLogInPasswordPage() {
        PageFactory.initElements(Browser.getInstance().getWrappedDriver(), this);
    }

    public YandexAccountPage loginPasswordAccount(String password) {

        Browser.getInstance().type(loginPasswordLocator, password);
        WebElement loginPassword = Browser.getInstance().getWrappedDriver().findElement(loginPasswordLocator);
        loginPassword.submit();

        Log.info("The password was submitted");
        return new YandexAccountPage();
    }
}

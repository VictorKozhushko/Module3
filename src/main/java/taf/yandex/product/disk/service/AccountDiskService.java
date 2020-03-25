package taf.yandex.product.disk.service;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import taf.framework.ui.Browser;
import taf.yandex.product.disk.screen.YandexAccountPage;
import taf.yandex.product.disk.screen.YandexDiskPage;
import taf.yandex.product.disk.screen.YandexWordPage;

import java.util.ArrayList;

public class AccountDiskService {

    public static YandexWordPage switchToDiskPage(YandexAccountPage yandexAccountPage) {

        ArrayList<String> yandexTabs = new ArrayList<>(Browser.getInstance().getWrappedDriver().getWindowHandles());

        YandexDiskPage yandexDiskPage = yandexAccountPage.switchToDisk();

        ArrayList<String> tabs = new ArrayList<>(Browser.getInstance().getWrappedDriver().getWindowHandles());

        tabs.remove(yandexTabs);

        String yandexDriver = tabs.get(2);

        Browser.getInstance().getWrappedDriver().switchTo().window(yandexDriver);

        String yandexWordTab;

        YandexWordPage yandexWordPage = yandexDiskPage.createFile();
        tabs = new ArrayList<>(Browser.getInstance().getWrappedDriver().getWindowHandles());

        yandexWordTab = tabs.get(3);

        Browser.getInstance().getWrappedDriver().switchTo().window(yandexWordTab);

        By frame = By.tagName("iframe");
        new WebDriverWait(Browser.getInstance().getWrappedDriver(), 5)
                .until(ExpectedConditions.visibilityOfElementLocated(frame));

        Browser.getInstance().getWrappedDriver().switchTo().frame(0);

        return yandexWordPage;
    }
}

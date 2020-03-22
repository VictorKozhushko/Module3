package taf.yandex.product.disk.screen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import taf.framework.ui.Browser;

import java.util.List;

public class YandexAccountPage {

    private WebElement disk;

    private List<WebElement> advertisment;

    private By diskButton = By.xpath("//a[@data-id='disk']");

    public YandexAccountPage() {
        PageFactory.initElements(Browser.getInstance().getWrappedDriver(), this);
    }

    public YandexDiskPage switchToDisk() {

        Browser.getInstance().click(diskButton);

        By advertismentWindow = By.xpath("//button[contains(@class, 'button2_view_classic')]");
        advertisment = Browser.getInstance().getWrappedDriver().findElements(advertismentWindow);
        if (advertisment.size() != 0) {
            advertisment.get(0).click();
        }

        return new YandexDiskPage();
    }

}

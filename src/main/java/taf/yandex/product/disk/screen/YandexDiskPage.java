package taf.yandex.product.disk.screen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import taf.framework.loger.Log;
import taf.framework.ui.Browser;

public class YandexDiskPage {

    private WebElement createFile;

    private By buttonLocator = By.xpath("//button[contains(@class, 'button2_tone_default')]");

    private By textDocument = By.xpath("//span[contains(text(), 'документ')]");

    public YandexDiskPage() {
        super();
        PageFactory.initElements(Browser.getInstance().getWrappedDriver(), this);
    }

    public YandexWordPage createFile() {

        Browser.getInstance().getWrappedDriver().manage().window().maximize();

        Browser.getInstance().click(buttonLocator);

        Browser.getInstance().click(textDocument);

        return new YandexWordPage();
    }

    public YandexDiskPage deleteFile(String filename) {
        Log.info("Check file with name" + filename);
        By document = By.xpath("//span[contains(text(), '" + filename + "')]");
        WebElement doc = Browser.getInstance().getWrappedDriver().findElement(document);
        Browser.getInstance().highlightElement(doc);
        doc.click();
        Log.info("Deleting file " + filename);
        By deleteItem = By.xpath("//button[contains(@class, 'groupable-buttons__visible-button_name_delete')]");
        WebElement delete = Browser.getInstance().getWrappedDriver().findElement(deleteItem);
        Browser.getInstance().highlightElement(delete);
        Log.info("Deleting document ");
        delete.click();
        return this;
    }
}

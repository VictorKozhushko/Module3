package taf.yandex.product.disk.screen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import taf.framework.loger.Log;
import taf.framework.ui.Browser;

public class YandexWordPage {

    private By paragraph = By.xpath("//p[@class='Paragraph']");

    public YandexWordPage() {
        super();
        PageFactory.initElements(Browser.getInstance().getWrappedDriver(), this);
    }

    public WebElement waitYandexWordPage(By by) {
        return new WebDriverWait(Browser.getInstance().getWrappedDriver(), 6)
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public YandexWordPage sendText(String string) {

        Browser.getInstance().type(paragraph, string);
        return this;
    }

    public YandexWordPage waitSavingOfDocument() {
        By titleSaved = By.xpath("//span[@id='BreadcrumbSaveStatus']");
        new WebDriverWait(Browser.getInstance().getWrappedDriver(), 12)
                .until(ExpectedConditions.visibilityOfElementLocated(titleSaved));
        WebElement saved = Browser.getInstance().getWrappedDriver().findElement(titleSaved);
        Browser.getInstance().highlightElement(saved);
        Log.info("Saving of the Document");
        String stringSaved = saved.getText();
        while (!stringSaved.equals("Сохранено в Yandex")) {
            stringSaved = saved.getText();
        }
        return this;
    }

    public String getDocumentName() {
        By titleDocument = By.xpath("//div[@id='BreadcrumbTitle']");
        Log.info("Getting name of Document");
        WebElement title = Browser.getInstance().getWrappedDriver().findElement(titleDocument);
        Browser.getInstance().highlightElement(title);
        String titleString = title.getText();
        return titleString;
    }

}

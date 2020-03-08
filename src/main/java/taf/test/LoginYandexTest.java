package taf.test;

import org.testng.annotations.Test;
import taf.framework.bo.AccountFactory;
import taf.yandex.product.disk.screen.YandexAccountPage;
import taf.yandex.product.disk.screen.YandexWordPage;
import taf.yandex.product.disk.service.AccountDiskService;
import taf.yandex.product.disk.service.AccountService;

public class LoginYandexTest {
    private YandexAccountPage yandexAccountPage;

    @Test(description = "Test Yandex Login")
    public void testYandexLogingPage() {
        yandexAccountPage = new AccountService()
                .signIn(AccountFactory.defaultAccount());
    }

    @Test(dependsOnMethods = {"testYandexLogingPage"})
    public void testYandexDisk() {
        YandexWordPage yandexWordPage = AccountDiskService.switchToDiskPage(yandexAccountPage);

        yandexWordPage
                .sendText("Hello world!")
                .waitSavingOfDocument();
        String documentName = yandexWordPage.getDocumentName();
    }

}

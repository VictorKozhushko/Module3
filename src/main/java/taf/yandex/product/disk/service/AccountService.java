package taf.yandex.product.disk.service;

import taf.framework.bo.Account;
import taf.framework.ui.Browser;
import taf.yandex.product.disk.screen.YandexAccountPage;
import taf.yandex.product.disk.screen.YandexHomePage;
import taf.yandex.product.disk.screen.YandexLogInAccountPage;

import java.util.ArrayList;

public class AccountService {
    public YandexAccountPage signIn(Account account) {
        YandexHomePage yandexHomePage = new YandexHomePage();
         YandexLogInAccountPage yandexLogInAccountPage = yandexHomePage
                .loginToYandex();

        ArrayList<String> tabs = new ArrayList<>(Browser.getInstance().getWrappedDriver().getWindowHandles());


        tabs.remove(yandexHomePage.getTabYandexHome());
        String yandexDriver = tabs.get(0);

        Browser.getInstance().getWrappedDriver().switchTo().window(yandexDriver);

        return yandexLogInAccountPage
                .loginToAccound(account.getLogin())
                .loginPasswordAccount(account.getPassword());
     }
}

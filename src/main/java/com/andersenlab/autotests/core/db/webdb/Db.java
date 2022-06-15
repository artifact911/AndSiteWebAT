package com.andersenlab.autotests.core.db.webdb;

import com.andersenlab.autotests.core.utils.PropertiesReader;
import com.andersenlab.autotests.site.utility.Logger;
import com.andersenlab.autotests.site.utility.Warp;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.Keys;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.getFocusedElement;
import static com.codeborne.selenide.Selenide.open;

@Getter
public class Db implements DbLocators {
    private DbElements dbElements = new DbElements();
    private final int QUERY_FREQUENCY = 30; //seconds
    private DbElements el = new DbElements();

    final String LOGIN;
    final String PASSWORD;
    final String PHP_MY_ADMIN_LINK = "https://sql-stage.andersenlab.com/tbl_sql.php?db=andersenlab_dev&table=form_data";

    public Db() {
        LOGIN = PropertiesReader.get("application.db.login");
        PASSWORD = PropertiesReader.get("application.db.password");
        prepare();
    }

    public Db(String login, String pass) {
        LOGIN = login;
        PASSWORD = pass;
        prepare();
    }

    private void prepare() {
        open(PHP_MY_ADMIN_LINK);
        //если не просят залогиниться, то и настаивать не будем (поскольку тесты бегут в одной сессии драйвера, то 2-3-ий заход в базу без логина)
        if(Warp.isElementPresent(INPUT_LOGIN)) {
            this.getDbElements().getLoginField().sendKeys(LOGIN);
            this.getDbElements().getPassField().sendKeys(PASSWORD);
            this.getDbElements().getLoginButton().click();
        }
    }

    private boolean sendQuery(String query) {
        try {
            dbElements.getSqlTab().click();
            delay(4);
            for (int i = 0; i < 40; i++) {
                getFocusedElement().sendKeys(Keys.BACK_SPACE);
            }
            delay(4);
            getFocusedElement().sendKeys(query);
            for (int i = 0; i < 40; i++) {
                getFocusedElement().sendKeys(Keys.DELETE);
            }
            dbElements.getSubmitQuery().click();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean responseIsEmpty() {
        return dbElements.getResponse().getAttribute("innerText").contains("MySQL вернула пустой результат");
    }

    private void delay(int delay) {
        try {
            Thread.sleep(delay * 1000);
        } catch (InterruptedException ignored) {}
    }

    public boolean recordIsPresent(String query, int timeoutS) {
        int times = timeoutS / QUERY_FREQUENCY;
        for (int i = 0; i < times; i++) {
            Logger.getLogger().log("DB search: " + i + " iteration");
            if (!sendQuery(query)) return false;
            if (!responseIsEmpty()) return true;
            delay(QUERY_FREQUENCY);
        }
        return false;
    }

    public boolean recordsIsPresent(List<String> namesGiven, String mail, int timeoutS) {
        int quantity = namesGiven.size();
        int limit = quantity + 5;
        final String nameLast = namesGiven.get(namesGiven.size() - 1);
        String queryNameLast = "SELECT `name` FROM `form_data` WHERE `email` = '" + mail + "' AND `name` = '" + nameLast + "' ORDER BY `id` DESC LIMIT " + limit;
        if (!recordIsPresent(queryNameLast, timeoutS)) {
            return false;
        }//ждем пока последнее имя не упало в базу, если время вышло, то вернуть ложь.
        String queryNames = "SELECT `name` FROM `form_data` WHERE `email` = '" + mail + "' AND `name` LIKE '%" + nameLast.substring(0, 4) + "%'  AND `message` LIKE '%NDA - on%' ORDER BY `id` DESC LIMIT " + limit;
        if (!sendQuery(queryNames)) {
            return false;
        }//если запрос был неудачным
        if (responseIsEmpty()) {
            return false;
        }//если ответ пустой
        List<String> namesResponse = new ArrayList<>();
        List<SelenideElement> listElements = el.getResponseMultiple();
        for (SelenideElement element : listElements) {
            String curName = element.getAttribute("innerText");
            namesResponse.add(curName);
        }
        Logger.getLogger().log("\n-----------------------------------------------Response Names:");
        for (String name : namesResponse) {
            System.out.println(name);
        }
        if (quantity > namesResponse.size()) {
            Logger.getLogger().log("-----------------------------------------------Names quantity not equals");
            return false;
        }
        for (String name : namesGiven) {
            if (!namesResponse.contains(name)) {
                Logger.getLogger().log("-----------------------------------------------Not all names present");
                return false;
            }
        }
        return true;
    }


}

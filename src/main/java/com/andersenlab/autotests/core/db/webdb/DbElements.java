package com.andersenlab.autotests.core.db.webdb;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

@Getter
public class DbElements implements DbLocators{
    //авторизация
    private SelenideElement loginField = Selenide.$(INPUT_LOGIN);
    private SelenideElement passField = Selenide.$(INPUT_PASS);
    private SelenideElement loginButton = Selenide.$(BUTTON_FORWARD);
    //запрос
    private SelenideElement sqlTab = Selenide.$(SQL_TAB);
    private SelenideElement inputQuery = Selenide.$(INPUT_QUERY);
    private SelenideElement clearQuery = Selenide.$(CLEAR_QUERY);
    private SelenideElement submitQuery = Selenide.$(SUBMIT_QUERY);
    private SelenideElement response = Selenide.$(RESPONSE);
    private ElementsCollection responseMultiple = Selenide.$$(RESPONSE_MULTIPLE);
}

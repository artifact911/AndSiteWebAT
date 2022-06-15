package com.andersenlab.autotests.core.db.webdb;

import org.openqa.selenium.By;

public interface DbLocators {
    //авторизация
    By INPUT_LOGIN = By.xpath("//input[@id='input_username']");
    By INPUT_PASS = By.xpath("//input[@id='input_password']");
    By BUTTON_FORWARD = By.xpath("//input[@id='input_go']");
    //запрос
    By SQL_TAB = By.xpath("//img[@title='SQL']//..");
    By INPUT_QUERY = By.xpath("(//div[text()=' '])[2]");
    By CLEAR_QUERY = By.xpath("//input[@id='clear']");
    By SUBMIT_QUERY = By.xpath("//input[@id='button_submit_query']");
    By RESPONSE = By.xpath("//div[@class='success']");

    By RESPONSE_MULTIPLE = By.xpath("//table[2]/tbody//td/span");
}

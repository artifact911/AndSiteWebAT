package com.andersenlab.autotests.core.mail.webmail;

import org.openqa.selenium.By;

public interface GMailLocators {
    String URL_MAIL = "https://www.google.com/intl/ru/gmail/about/";
    String MAIL_NOT_COOPERATE = "qaands@gmail.com";
    String PASS = "andersenqa2019";//это для -3
    By BUTTON_MAIL = By.xpath("/html/body/div[2]/div[1]/div[4]/ul[1]/li[2]/a");
    By INPUT_LOGIN = By.xpath("//*[@id='identifierId']");
    By BUTTON_LOGIN_NEXT = By.xpath("//*[@id='identifierNext']/div/button/div[2]");
    By INPUT_PASS = By.xpath("//*[@id='password']/div[1]/div/div[1]/input");
    By BUTTON_PASS_NEXT = By.xpath("//*[@id='passwordNext']/div/button/div[2]");

    By TOP_CHAIN = By.xpath("//*[@id=':20n']/span");
    By BUTTON_EXPAND = By.xpath("//*[@id=':oj']/span");
    




    String MAIL_COOPERATE_PASS = "u1nK~YoTn1Eh";

}

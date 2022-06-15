package com.andersenlab.autotests.core.mail.webmail;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class GMailElements implements GMailLocators, MailElementI{
    private SelenideElement ButtonMail = $(BUTTON_MAIL);
    private SelenideElement InputLogin = $(INPUT_LOGIN);
    private SelenideElement ButtonLoginNex = $(BUTTON_LOGIN_NEXT);
    private SelenideElement InputPass = $(INPUT_PASS);
    private SelenideElement ButtonPassNext = $(BUTTON_PASS_NEXT);
    private SelenideElement TopChain = $(TOP_CHAIN);
    private SelenideElement ButtonExpand = $(BUTTON_EXPAND);
    private String PASS = "andersenqa2019";
}

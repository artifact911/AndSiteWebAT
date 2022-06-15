package com.andersenlab.autotests.core.mail.webmail;

import com.codeborne.selenide.WebDriverRunner;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.*;

@Getter
public class MailG implements GMailLocators {
    private GMailElements el = new GMailElements();

    /**
     * недописано
     */

    private void login(){
        open(URL_MAIL);
        el.getButtonMail().click();
        //переключиться на другое окно
        switchTo().window(1);
        el.getInputLogin().sendKeys(MAIL_NOT_COOPERATE);
        el.getButtonLoginNex().click();
        el.getInputPass().sendKeys(PASS);
        el.getButtonPassNext().click();
    }

    public boolean isMailPresent(String name){
        login();
        el.getButtonExpand().click();
        WebDriver driver = WebDriverRunner.getWebDriver();
        return driver.getPageSource().contains(name);
    }
}

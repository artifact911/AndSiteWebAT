package com.andersenlab.autotests.site.form.popup.requestmeeting;

import com.andersenlab.autotests.site.form.popup.requestform.RequestFormLocators;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public interface RequestMeetingLocators extends RequestFormLocators {

    default void doBefore() {
        $(By.xpath("//button[@id='trips-list__link_select']")).click();
    }

    By CAPTCHA = By.xpath(BASE + "//p[contains(@class,'captcha')]");
    By INPUT_MAIL_PHONE = By.xpath(BASE + "//input[@name='email phone']");//---------------------------------------------------------
    By ASK_MAIL_PHONE = By.xpath(BASE + "//input[@name='email phone']//..");

    String TEXT_BUTTON_SEND_REQ = "\n                        Send request                    ";
    String TEXT_CAPTCHA = "\n        This site is protected by reCAPTCHA and the Google\n";
    String PRIVATE_POLICY_TERMS_NOT_HOVERED_COLOR = "rgb(2, 3, 3)";
    String PRIVATE_POLICY_TERMS_HOVERED_COLOR = "rgb(254, 218, 0)";
    String TEXT_ASK_MAIL_PHONE = "Please enter valid information";
}

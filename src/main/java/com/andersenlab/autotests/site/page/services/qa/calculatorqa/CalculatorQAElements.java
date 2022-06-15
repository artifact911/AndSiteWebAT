package com.andersenlab.autotests.site.page.services.qa.calculatorqa;

import com.andersenlab.autotests.core.utils.PropertiesReader;
import com.codeborne.selenide.SelenideElement;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Getter
class CalculatorQAElements implements CalculatorQALocators {
    private final String notCorporateEmail = "qaands@gmail.com";
    private final String corporateEmail = "qaands@andersenlab.com";
    private final String invalidEmail = "test.andersenlab.com";
    private final String emailTooltipText = "For industry-based consultancy, a corporate email is preferred.";
    private final String tipUnderEmailField = "Please, enter your corporate email";
    private final String tipUnderThePhoneNumberFieldText = "Please, enter your phone number";
    private final String phoneNumber = "121234567";
    private final String invalidShortPhoneNumber = "111";
    private final String invalidLongPhoneNumber = "123345678910212345";
    private final String ndaTooltipText = "Before we discuss any details about your project you can request to sign a Non Disclosure Agreement";
    private final String successfulText = "Thank you for your interest!\n" + "\n" + "We will contact you ASAP!";
    private final String url = PropertiesReader.get("application.db.url");
    private final String user = PropertiesReader.get("application.db.login");
    private final String password = PropertiesReader.get("application.db.password");
    private final String query = "SELECT * FROM andersenlab_stage.form_data fd ORDER BY id DESC LIMIT 1";
    private final String totalCount = "SELECT COUNT(id) FROM andersenlab_stage.form_data fd";

    private final SelenideElement webButton = $(WEB_BUTTON);
    private final SelenideElement smokeButton = $(SMOKE_BUTTON);
    private final SelenideElement getPricePopUp = $(GET_PRICE_POP_UP_BUTTON);
    private final SelenideElement base = $(By.xpath(baseString));
    private final SelenideElement ndaTooltip = $(NDA_TOOL_TIP);
    private final SelenideElement emailField = $(EMAIL_FIELD);
    private final SelenideElement nameField = $(NAME_FIELD);
    private final SelenideElement emailToolTip = $(EMAIL_TOOL_TIP);
    private final SelenideElement tipUnderPhone =$(TIP_UNDER_PHONE);
    private final SelenideElement tipUnderEmail = $(TIP_UNDER_EMAIL);
    private final SelenideElement phoneField = $(PHONE_FIELD);
    private final SelenideElement ndaButton = $(NDA_BUTTON);
    private final SelenideElement sendButton = $(SEND_BUTTON);
    private final SelenideElement successModalWindow = $(SUCCESS_MODAL_WINDOW);
    private final SelenideElement successModalWindowText = $(SUCCESS_MODAL_WINDOW_TEXT);
    private final SelenideElement successModalWindowClose = $(SUCCESS_MODAL_WINDOW_CLOSE);
}

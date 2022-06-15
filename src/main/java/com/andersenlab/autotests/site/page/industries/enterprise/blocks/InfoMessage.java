package com.andersenlab.autotests.site.page.industries.enterprise.blocks;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;

public class InfoMessage{
    InfoMessageLocators locators = new InfoMessageLocators();
    private final SelenideElement title = $(locators.getTITLE());
    private final SelenideElement message = $(locators.getMESSAGE());

    private final String expectedTitle = "Eminently suitable for enterprises";
    private final String expectedMessage = "Customers who trust us with their transformation and application of new approaches rely on more than 14 years of global experience in production and the best practices by Andresenlab employees for various production and operational processes. With in-depth knowledge of how your specific processes work and experience that allows you to combine the right technical solutions with your manufacturing needs, we can help your company better streamline processes, work more efficiently and, ultimately, gain a sustainable competitive advantage.";

    @Step
    public void checkTitle(){
        Assert.assertEquals(title.getText(), expectedTitle);
    }

    @Step
    public void checkMessage(){
        Assert.assertEquals(message.getText(), expectedMessage);
    }
}

class InfoMessageLocators{
    private final String BASE = "//h2[contains(text(), 'suitable')]//..//..";

    @Getter private final By TITLE = By.xpath(BASE + "//h2");
    @Getter private final By MESSAGE = By.xpath(BASE + "//p");
}
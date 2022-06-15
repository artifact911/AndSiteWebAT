package com.andersenlab.autotests.site.form;

import com.andersenlab.autotests.core.configs.constants.CTABlockData;
import com.andersenlab.autotests.site.form.popup.requestform.RequestForm;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.NonNull;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;

public class CallToAction {
    private SelenideElement title = $(By.xpath(CTABlockData.Locators.DEFAULT.getData().get(0)));
    private SelenideElement img = $(By.cssSelector(CTABlockData.Locators.DEFAULT.getData().get(1)));
    private SelenideElement hint = $(By.xpath(CTABlockData.Locators.DEFAULT.getData().get(2)));
    private SelenideElement btn = $(By.xpath(CTABlockData.Locators.DEFAULT.getData().get(3)));

    private final String expectedTitle;
    private final String expectedHint;
    private final String expectedHintImage;
    private final String expectedButtonText;

    public CallToAction(@NonNull List<String> locators, @NonNull List<String> values){
        title = $(By.xpath(locators.get(0)));
        img = $(By.cssSelector(locators.get(1)));
        hint = $(By.xpath(locators.get(2)));
        btn = $(By.xpath(locators.get(3)));

        expectedTitle = values.get(0);
        expectedHintImage = values.get(1);
        expectedHint = values.get(2);
        expectedButtonText = values.get(3);
    }

    public CallToAction(@NonNull List<String> values){
        expectedTitle = values.get(0);
        expectedHintImage = values.get(1);
        expectedHint = values.get(2);
        expectedButtonText = values.get(3);
    }

    @Step
    public void checkTitle(){
        Assert.assertEquals(title.getText(), expectedTitle);
    }

    @Step
    public void checkBtn(){
        Assert.assertEquals(btn.getText(), expectedButtonText);
        btn.click();
        RequestForm requestForm = new RequestForm(btn.getText());
        requestForm.checkTitle();
        requestForm.linkPhoneMail();
        requestForm.closeReq();
    }

    @Step
    public void checkHint(){
        checkImage();
        checkMessage();
    }

    private void checkImage(){
        Assert.assertTrue(img.getAttribute("xlink:href").contains(expectedHintImage));
    }

    private void checkMessage(){
        Assert.assertEquals(hint.getText(), expectedHint);
    }

    public void clickBtn(){
        btn.click();
    }
}
package com.andersenlab.autotests.site.page.services.augmentation.dynamicblockarchitecturebauxui;

import com.andersenlab.autotests.core.steps.Assertions;
import com.andersenlab.autotests.site.form.commonforms.FormPopUp;
import com.andersenlab.autotests.site.utility.Warp;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class DynamicBlock {
    private FormPopUp formPopUp;

    String BASE = "//section[contains(@class,'CallToAction-module')]";
    private final SelenideElement title = $(By.xpath(BASE + "//p"));
    private final SelenideElement buttonReq = $(By.xpath(BASE + "//button[contains(@class,'CallToAction-module--button')]"));
    private final SelenideElement buttonSeeMore = $(By.xpath(BASE + "//a[contains(@class,'CallToAction-module--link')]"));

    public DynamicBlock(FormPopUp formPopUp) {
        this.formPopUp = formPopUp;
    }

    @Step
    public void displayingElements() {
        Warp.scrollToElement(BASE);
        title.should(Condition.visible).should(Condition.exist);
        Assertions.mouseIsPointer(buttonReq);
        buttonReq.click();
        formPopUp.closeReq();
        Warp.openTargetLinkAndCheckUrl(buttonSeeMore);
    }
}

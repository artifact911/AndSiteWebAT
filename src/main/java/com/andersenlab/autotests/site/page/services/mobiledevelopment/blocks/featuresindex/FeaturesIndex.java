package com.andersenlab.autotests.site.page.services.mobiledevelopment.blocks.featuresindex;

import com.andersenlab.autotests.core.steps.Assertions;
import com.andersenlab.autotests.site.form.popup.requestform.RequestForm;
import com.andersenlab.autotests.site.utility.Warp;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class FeaturesIndex {
    private final By BUTTON_REQ = By.xpath("//section[contains(@class, 'feature-module--container')]//span[contains(text(), 'Request specialists')]");
    private final By LINK_EXTENSIVE_EXP = By.xpath("//section[contains(@class, 'feature-module--container')]//a[contains(@class, 'items-module--linkName')]");
    private final String LINK_EXTENSIVE_EXP_HREF = "https://stage.andersenlab.com/services/mobile-development/#resume";

    private final SelenideElement buttonReq = $(BUTTON_REQ);
    private final SelenideElement linkExtensiveExp = $(LINK_EXTENSIVE_EXP);

    @Step
    public void displayingElementsAndFunction() {
        Assertions.mouseIsPointer(buttonReq);
        buttonReq.click();
        new RequestForm("Request specialists").checkTitle();
        new RequestForm("Request specialists").closeReq();
        Assertions.mouseIsPointer(linkExtensiveExp);
        Warp.checkLinkThisTab(linkExtensiveExp, LINK_EXTENSIVE_EXP_HREF);
    }
}

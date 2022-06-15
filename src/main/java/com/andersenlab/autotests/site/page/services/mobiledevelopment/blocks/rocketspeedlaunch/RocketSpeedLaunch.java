package com.andersenlab.autotests.site.page.services.mobiledevelopment.blocks.rocketspeedlaunch;

import com.andersenlab.autotests.core.steps.Assertions;
import com.andersenlab.autotests.site.form.popup.requestform.RequestForm;
import com.andersenlab.autotests.site.utility.Warp;
import io.qameta.allure.Step;
import lombok.Getter;
import org.testng.Assert;

@Getter
public class RocketSpeedLaunch implements RocketSpeedLaunchLocators {
    private RocketSpeedLaunchElements el = new RocketSpeedLaunchElements();

    @Step
    public void displayingElementsAndFunction() {
        Warp.scrollToElement(el.getButtonReq());
        Assertions.mouseIsPointer(el.getButtonReq());
        Assert.assertEquals(el.getTitle().getAttribute("innerText"), TEXT_TITLE);
        String[] arts = Warp.titlesCollection(el.getArticles());
        for (int i = 0; i < arts.length; i++) {
            Assert.assertEquals(arts[i], TEXT_ARTICLES[i]);
        }
        Assert.assertEquals(arts.length, TEXT_ARTICLES.length);
        el.getButtonReq().click();
        new RequestForm().closeReq();
    }


}

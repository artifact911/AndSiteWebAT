package com.andersenlab.autotests.site.page.services.salesforce.blocks.header;

import com.andersenlab.autotests.core.configs.constants.Country;
import com.andersenlab.autotests.site.form.commonforms.FormData;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.testng.Assert;

public class Head implements FormData, HeadLocators {
    private HeadElements el = new HeadElements();

    @Step
    public void displayingElements(Country country) {
        Assert.assertEquals(el.getHeading().getAttribute("innerText"), "Premier Custom Software Development Company");
        Assert.assertEquals(el.getLinkPhone().getAttribute("href"), getLinkPhoneHref(country));
        el.getWidget().should(Condition.visible);
    }
}

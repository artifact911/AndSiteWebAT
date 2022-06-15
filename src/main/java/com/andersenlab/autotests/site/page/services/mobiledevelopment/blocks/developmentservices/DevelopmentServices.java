package com.andersenlab.autotests.site.page.services.mobiledevelopment.blocks.developmentservices;

import com.andersenlab.autotests.core.steps.Assertions;
import com.andersenlab.autotests.site.form.popup.requestform.RequestForm;
import io.qameta.allure.Step;
import org.testng.Assert;

public class DevelopmentServices implements DevelopmentServicesLocators {
    private DevelopmentServicesElements el = new DevelopmentServicesElements();

    @Step
    public void displayingElementsAndFunction() {
        Assert.assertEquals(el.getTitle2().getAttribute("innerText"), TEXT_TITLE2);
        for (int i = 0; i < el.getArts2().size(); i++) {
            Assert.assertEquals(el.getArts2().get(i).getAttribute("innerText"), TEXT_ARTICLES_TITLE2[i]);
        }
    }
}

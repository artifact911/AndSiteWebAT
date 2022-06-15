package com.andersenlab.autotests.site.page.services.salesforce.blocks.projectexamples;

import com.andersenlab.autotests.core.steps.Assertions;
import com.andersenlab.autotests.site.utility.Warp;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import org.testng.Assert;

@Getter
public class ProjectExamples implements ProjectExamplesLocators {
    private ProjectExamplesElements el = new ProjectExamplesElements();

    @Step
    public void displayingElementsAndFunction() {
        Assert.assertEquals(el.getTitle().getAttribute("innerText"), TEXT_TITLE);
        Assert.assertEquals(el.getSubtitle().getAttribute("innerText"), TEXT_SUBTITLE);

        for (SelenideElement e : el.getVcs()) {
            Assertions.mouseIsPointer(e);
            Warp.elementIsIntractable(e);
            e.click();
            el.getButtonCloseConcept().click();
        }
    }
}

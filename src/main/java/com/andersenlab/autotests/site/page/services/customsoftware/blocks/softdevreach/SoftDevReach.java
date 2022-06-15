package com.andersenlab.autotests.site.page.services.customsoftware.blocks.softdevreach;

import com.andersenlab.autotests.core.steps.Assertions;
import com.andersenlab.autotests.site.form.commonforms.FormPopUp;
import com.andersenlab.autotests.site.utility.Warp;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class SoftDevReach {
    private FormPopUp formPopUp;
    protected final String BASE = "//section[contains(@class, 'CallToAction-module')]";
    private final By TITLE = By.xpath(BASE + "//p");
    private final By BUTTON_REQ = By.xpath(BASE + "//button[contains(@class,'CallToAction-module--button')]");


    private SelenideElement title = $(TITLE);
    private SelenideElement buttonReq = $(BUTTON_REQ);

    public SoftDevReach(FormPopUp formPopUp) {
        this.formPopUp = formPopUp;
    }

    @Step
    public void displayingElements() {
        Assert.assertEquals(title.getAttribute("innerText"), textTitle());
        title.should(Condition.visible);
        Assertions.mouseIsPointer(buttonReq);
        buttonReq.click();
        formPopUp.closeReq();
    }

    private String textTitle() {
        //дописывать по необходимости
        switch (Warp.tabTitle()) {
            case "Custom Software Development Company - Andersen":
                return "Request a professional consultation on building a functional and secure custom software solution.";
            case "Mobile App Design & Development Company - Andersen":
                return "Schedule a free consultation with highly-experienced specialists to take the first step towards your new mobile application.";
            case "Custom Salesforce development services - Andersen":
                return "Did you find your issue among the list? Contact our experts to discuss operational solutions for it.";
            case "Data Science & Big Data Consulting And Development Services - Andersen":
//            case "Application Maintenance and Support Services":
//                return "";
            case "QA in full-cycle of software development":
                return "Found your problem? Our team successfully solves these problems by providing QA Audit and engaging QA specialists on our clients’ projects";
            case "Custom eLearning Development Services - Andersen":
                return "Request a professional consultation on building an engaging eLearning application.";
            case "Professional Business Analysts":
                return "Found your problem? Our team successfully solved these by engaging Business Analysts in the software development process.";
                default:
                throw new IllegalArgumentException();
        }

    }
}

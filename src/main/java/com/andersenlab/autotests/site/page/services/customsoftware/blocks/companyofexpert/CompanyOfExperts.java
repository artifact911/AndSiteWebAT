package com.andersenlab.autotests.site.page.services.customsoftware.blocks.companyofexpert;

import com.andersenlab.autotests.site.utility.Warp;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CompanyOfExperts {
    String BASE = "//section[contains(@class, 'CompanyOfExperts')]";
    private final SelenideElement title = $(By.xpath(BASE + "//p[contains(@class, '-title')]"));
    private final SelenideElement subtitle = $(By.xpath(BASE + "//p[contains(@class, 'subtitle')]"));
    private final ElementsCollection certificates = $$(By.xpath(BASE + "//figure"));

    private String textTitle = texts()[0];
    private String textSubTitle = texts()[1];

    @Step
    public void displayingElements(int quantity) {
        Warp.scrollToElement(BASE);
        title.should(Condition.visible);
        Assert.assertEquals(title.getAttribute("innerText"), textTitle);
        subtitle.should(Condition.visible);
        Assert.assertEquals(subtitle.getAttribute("innerText"), textSubTitle);
        Assert.assertEquals(certificates.size(), quantity);
    }

    private String[] texts() {
        //дописывать по необходимости
        switch (Warp.currentURL()){
            case "https://stage.andersenlab.com/services/custom-software-development":
                return new String[]{
                        "Company of experts", "To test knowledge, confirm their qualifications and professional skills, our experts receive the following certificates in the field of Project Management."
                };
            case "https://stage.andersenlab.com/services/maintenance-support":
                return new String[]{
                        "Company of experts", "To test knowledge, confirm their qualifications and professional skills, our experts receive the following certificates in the field of application support and maintenance."
                };
            case "https://stage.andersenlab.com/services/business-analysts":
                return new String[]{
                        "Company of experts", "To test knowledge, confirm their qualifications and professional skills, our experts receive the following certificates in the field of Business Analysis."
                };
            case "https://stage.andersenlab.com/services/dedicated-team":
                return new String[]{
                        "Company of experts", "To test knowledge, confirm their qualifications and professional skills, our experts receive the following certificates in the field of Project Management."
                };
            default:
                throw new IllegalArgumentException();
        }
    }
}

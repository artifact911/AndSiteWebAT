package com.andersenlab.autotests.site.page.services.mobiledevelopment.blocks.cv;

import com.andersenlab.autotests.core.steps.Assertions;
import com.andersenlab.autotests.site.utility.Warp;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Getter
public class CvBlock {

    String BASE;
    private By TITLE;
    private By BUTTON_MORE;
    private By BUTTONS_CV;
    private SelenideElement title;
    private ElementsCollection CVs;
    private SelenideElement buttonMore;

    private boolean isShowMore = true;

    private final String partOfHref = ".pdf";

    public CvBlock() {
        BASE = "//section[contains(@class, 'our-resume')]";
        calc();
    }

    private void calc(){
        TITLE = By.xpath(BASE + "//h2");
        BUTTON_MORE = By.xpath(BASE + "//*[contains(text(), 'Show more') and not(contains(@class, 'js-hidden')) and not(contains(@style, 'display: none;'))]");
        BUTTONS_CV = By.xpath(BASE + "//article[not(contains(@style, 'display: none'))]//a[contains(@class, 'button') and contains(@href, '.pdf')]");
        title = $(TITLE);
        CVs = $$(BUTTONS_CV);
        buttonMore = $(BUTTON_MORE);
    }

    public void noShowMore(){
        isShowMore = false;
    }


    @Step
    public void displayingElementsAndFunction() {
        Warp.scrollToElement(CVs.first());
        Assert.assertEquals(title.getText(), textTitle());
        int cvQuantity = CVs.size();
        isShowMore = Warp.isElementPresent(BUTTON_MORE);
        if (isShowMore) {
            if (textTitle().equals("Our engineers")) Assert.assertTrue(Warp.isElementPresent(BUTTON_MORE));
            while (Warp.isElementPresent(BUTTON_MORE)) {
                buttonMore.click();
                Assert.assertNotEquals(CVs.size(), cvQuantity);
                cvQuantity = CVs.size();
            }
            noShowMore();
        } else {
            Assert.assertFalse(Warp.isElementPresent(BUTTON_MORE));
        }
        for (SelenideElement e : CVs) {
            Assertions.mouseIsPointer(e);
            Warp.checkLinkPart(e, partOfHref);
        }
    }

    private String textTitle() {
        //дописывать по необходимости
        switch (Warp.tabTitle()) {
            case "Mobile App Design & Development Company - Andersen":
            //Techstack
            //Front-end
            case "Hire Experienced Front-end Developers - Andersen":
                return "Our engineers";
            case "Hire Experienced Angular Developers - Andersen":
                return "Team of experts";
            case "Hire Experienced JavaScript Developers - Andersen":
                return "Team of experts";
            case "Hire Experienced React.js Developers - Andersen":
                return "Team of experts";
            case "Hire Experienced Vue.js Developers - Andersen":
                return "Team of experts";
            //Back-end
            case "Hire Experienced Back-end Developers - Andersen":
                return "Our engineers";
            case "Hire Experienced Java Developers - Andersen":
                return "Team of Java experts";
            case "Hire Experienced .NET Developers - Andersen":
                return "Team of .NET experts";
            case "Hire Experienced PHP Developers - Andersen":
            case "Hire Experienced Python Developers - Andersen":
            case "Hire Experienced Ruby Developers - Andersen":
            case "Hire Experienced Node.js Developers - Andersen":
            case "Hire Experienced Scala Developers - Andersen":
                return "Team of experts";
            case "Hire Experienced Golang Developers - Andersen":
                return "Team of Golang experts";
            case "Hire Experienced C/C++ Developers - Andersen":
                return "Team of experts";
            //Mobile
            case "Hire Experienced Mobile Developers - Andersen":
                return "Our engineers";
            case "Hire Experienced Android Developers - Andersen":
            case "Hire Experienced iOS Developers - Andersen":
            case "Hire Experienced Xamarin Developers - Andersen":
                return "Team of experts";
            case "Hire Experienced React Native Developers - Andersen":
            case "Hire Experienced Ionic Developers - Andersen":
            case "Flutter App Development | Andersen":
                return "Our engineers";
            case "Professional Business Analysts":
                return "Our engineers";
            case "Custom Salesforce development services - Andersen":
            case "QA in full-cycle of software development":
                return "CV examples";
            case "Custom Software Development Company - Andersen":
            case "Web Development Company - Web App Development Services - Andersen":
            case "Data Science & Big Data Consulting And Development Services - Andersen":
            case "Application Maintenance and Support Services":

            //industries
            case "Custom eLearning Development Services - Andersen":
                return "Team of experts";
            case "E-commerce Website Development Services - Andersen":
                return "Team of experts";
            case "Software development for Banks and Financial companies":
                return "Team of experts";
            case "Qualitative software development":
                return "Designers’ portfolios";
            case "Travel Software Development - Custom Travel Solutions - Andersen":
                throw new IllegalArgumentException("CV NOT IMPLEMENTED");
            case "Healthcare Software Development Company - Andersen":
                throw new IllegalArgumentException("CV NOT IMPLEMENTED");
            case "Custom Software Development for Media & Entertainment | Andersen":
                return "Team of experts";
            case "Real Estate Software Development - Custom Real Estate Solutions - Andersen":
                throw new IllegalArgumentException("CV NOT IMPLEMENTED");
            case "Telecom Software Development - Custom Telecom Solutions - Andersen":
                throw new IllegalArgumentException("CV NOT IMPLEMENTED");
            case "Software Development for the Online Gambling Industry | Andersenlab":
                return "Team of experts";
            case "Logistics Software Development | Andersen":
                return "Team of experts";
            case "Custom Enterprise Software for Your Growth":
                throw new IllegalArgumentException("CV NOT IMPLEMENTED");
            case "Retail Software Development | Andersen":
                return "Team of experts";

            //industries subpages
            case "iGaming software development & consulting":
                return "Team of experts";
            case "Custom sports betting software solutions and development":
                return "Team of experts";
            default:
                throw new IllegalArgumentException("NOT IMPLEMENTED");
        }

    }
}

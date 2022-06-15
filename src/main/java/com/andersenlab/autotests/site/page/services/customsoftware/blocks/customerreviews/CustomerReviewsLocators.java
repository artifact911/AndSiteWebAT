package com.andersenlab.autotests.site.page.services.customsoftware.blocks.customerreviews;

import com.andersenlab.autotests.site.utility.Warp;
import org.openqa.selenium.By;

public interface CustomerReviewsLocators {
    String PATH_SECTION = "//section[contains(@class, 'reviewSlider')]";
    By TITLE = By.xpath(PATH_SECTION + "//p[contains(@class, 'title')]");
    By DESCRIPTION = By.xpath(PATH_SECTION + "//p[contains(@class, 'subtitle')]");


    String PATH_ARTICLE = PATH_SECTION + "//div[contains(@class, 'slick-active')]";
    By REVIEWER_NAME = By.xpath(PATH_ARTICLE + "//*[contains(@class, 'name')]");
    By REVIEWER_POSITION = By.xpath(PATH_ARTICLE + "//p[contains(@class, 'position')]");
    By REVIEW = By.xpath(PATH_ARTICLE + "//section[not(contains(@class, 'video'))]//p[contains(@class, 'reviewInfo-module--text')]");
    By CLUTCH = By.xpath(PATH_ARTICLE + "//a[contains(@href, 'clutch')]");

    By BUTTON_PREV = By.xpath(PATH_SECTION + "//button[contains(@class, 'slick-prev')]");
    By BUTTON_NEXT = By.xpath(PATH_SECTION + "//button[contains(@class, 'slick-next')]");
    By BUTTONS_SLICK = By.xpath(PATH_SECTION + "//ul[@class='slick-dots']//li");
    By ACTIVE_BUTTON_SLICK = By.xpath(PATH_SECTION + "//ul[@class='slick-pagination']//li[contains(@class, 'slick-active')]");
    //for drag&drop
    By TEAM_SIZE = By.xpath(PATH_ARTICLE + "//*[translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz') = 'team size']");
    By PROJECT_SUMMARY = By.xpath(PATH_ARTICLE + "//*[contains(text(), 'Project summary')]");



    By LINK_MORE_REFS = By.xpath(PATH_SECTION + "//a[contains(@href,'testimonials')]");
    By LINK_PROJECT_DESCRIPTION = By.xpath(PATH_ARTICLE + "//a[contains(text(), 'View case')]");

    String TEXT_MORE_REFS_REF = "https://dev.andersenlab.com/customer-reviews";
    String TEXT_PROJECT_DESCRIPTION_REF = "/our-projects/software-for-monitoring-vehicle-diagnostic-devices";

    default String textDescription() {
        //дописывать по необходимости
        switch (Warp.tabTitle()) {
            case "Custom Software Development Company - Andersen":
            case "Web Development Company - Web App Development Services - Andersen":
            case "Professional Business Analysts":
                return "Meet some of our clients who entrusted the development of their custom applications to Andersen. Here’s their feedback on cooperation with Andersen";
            case "Application Maintenance and Support Services":
            case "Hire Experienced Front-end Developers - Andersen":
            case "Hire Experienced Angular Developers - Andersen":
                return "SMB, enterprise, and startup clients return to us because they’re happy with our work. Here’s what they say about Andersen";
            case "Mobile App Design & Development Company - Andersen":
            case "Data Science & Big Data Consulting And Development Services - Andersen":
            case "Custom Salesforce development services - Andersen":
                return "SMB, enterprise, and startup clients return to us because they’re happy with our work. Here’s what they say about Andersen.";
            case "Custom eLearning Development Services - Andersen":
                return "SMB, enterprise and startup clients return to us because they’re happy with our work. Here’s what they say about Andersen";
            case "QA in full-cycle of software development":
                return "SMB, enterprise and startup clients return to us because they’re happy with our work. Here’s what they say about Andersen.";
            default:
                throw new IllegalArgumentException();
        }
    }

    default String textTitle() {
        //дописывать по необходимости
        String t = Warp.currentURL();
        if(t.contains("services") | t.contains("eLearning") | t.contains("business-analysts") | t.contains("qa-engineers")) return "Customer reviews";
        else if (t.contains("find-developers")) return "Our satisfied clients";
        else throw new IllegalArgumentException();

    }

    default String[] projectDescriptionHrefs() {
        //дописывать по необходимости
        switch (Warp.tabTitle()) {
//            case "Custom Software Development Company - Andersen":
//            case "Web Development Company - Web App Development Services - Andersen":
//            case "Application Maintenance and Support Services":
//            case "Hire Experienced Front-end Developers - Andersen":
//            case "Hire Experienced Angular Developers - Andersen":
//            case "Mobile App Design & Development Company - Andersen":
//            case "Data Science & Big Data Consulting And Development Services - Andersen":
//            case "Custom Salesforce development services - Andersen":
//            case "Custom eLearning Development Services - Andersen":
//            case "QA in full-cycle of software development":

            case "Professional Business Analysts":
                return new String[]{
                        "/our-projects/app-for-making-payments-and-managing-paperwork",
                        "/our-projects/system-for-issuing-short-term-loans",
                        "/our-projects/web-based-version-of-ehr-system",
                        "/our-projects/iot-solution-for-monitoring-sleep-quality",
                        "", "", ""
                };
            default:
                throw new IllegalArgumentException();
        }
    }
}

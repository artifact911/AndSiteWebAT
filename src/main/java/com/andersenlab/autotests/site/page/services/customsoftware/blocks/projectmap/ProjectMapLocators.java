package com.andersenlab.autotests.site.page.services.customsoftware.blocks.projectmap;

import com.andersenlab.autotests.site.utility.Warp;
import org.openqa.selenium.By;

public interface ProjectMapLocators {
    String BASE = "//section[contains(@class, 'ProjectsMap-module--container')]";
    By TITLE = By.xpath(BASE + "//p[contains(@class, 'title')]");
    By SUBTITLE = By.xpath(BASE + "//h4");
    By BUTTONS_FILTER = By.xpath(BASE + "//button[contains(@class, 'filterTag')]");
    By POINTS = By.xpath(BASE + "//div[contains(@style, 'position: absolute; left: 0px; top: 0px; z-index: 106; width: 100%;')]//div");
    By GOOGLE_LINK = By.xpath(BASE + "//a[contains(@href, '/help/terms_maps.html')]");
    By PROJECTS_COUNT = By.xpath(BASE + "//p[contains(@class, 'ProjectMap-module--count')]");
    By MAP_PLUS_BTN = By.xpath(BASE + "//div[contains(@class, 'gmnoprint')]//div[contains(@class, 'gmnoprint')]//button[1]");
    By MAP_MINUS_BTN = By.xpath(BASE + "//div[contains(@class, 'gmnoprint')]//div[contains(@class, 'gmnoprint')]//button[2]");
    By SLIDER_CONTROL_MODULE = By.xpath(BASE + "//div[@class='SliderControl-module--controlsWrapper--2GSlG']");
    By SLIDER_BUTTON_PREVIOUS = By.xpath(BASE + "//button[contains(@class, 'SliderControl-module--prev')]");
    By SLIDER_BUTTON_NEXT = By.xpath(BASE + "//button[contains(@class, 'SliderControl-module--next')]");
    By PROJECTS = By.xpath(BASE + "//a[contains(@class, 'ProjectPortfolioSlider')]");
    By PROJECT_LINKS = By.xpath(BASE + "//p[@class='ProjectPortfolioSlider-module--link--3wHNM']");
    By PROJECT_LOGOS = By.xpath(BASE + "//img[contains(@class, 'ProjectPortfolioSlider-module--logo-')]");
    By PROJECT_TITLES = By.xpath(BASE + "//p[contains(@class, 'ProjectPortfolioSlider-module--cardTitle-')]");
    By PRICING_MODULE = By.xpath(BASE + "//div[contains(@class, 'Alert-module--hint-')]");
    By PRICING_MODULE_CONTENT = By.xpath(BASE + "//div[contains(@class, 'Alert-module--content-')]");
    By PRICING_MODULE_BUTTON = By.xpath(BASE + "//a[contains(@class, 'button-module--button-')]");

    String BASE_MODAL_CONTAINER = "//section[@class='modal-module--popup--1hVvE']";
    By MODAL_CONTAINER = By.xpath(BASE_MODAL_CONTAINER + "//div[contains(@class, 'modal-module--container')]");
    By MODAL_ACCORDION_ELEMENTS = By.xpath(BASE_MODAL_CONTAINER + "//ul/li");
    By MODAL_VIEW_CASE_BTN = By.xpath(BASE_MODAL_CONTAINER + "//a[contains(@class, 'button-module--button--1tVYf')]");
    By MODAL_CV_EXAMPLES = By.xpath(BASE_MODAL_CONTAINER + "//span[@class='ProjectMap-module--cvExample--PWfS6']/a");
    By BUTTON_SEE_REFERENCE = By.xpath(BASE_MODAL_CONTAINER + "//a[contains(@class, 'ProjectMap-module--footerLink-')]");
    By BUTTON_CLOSE_MODAL = By.xpath(BASE_MODAL_CONTAINER + "//button[contains(@class, 'close-button')]");

    String SUBTITLETEXT = "Project portfolio";

    default String textTitle() {
        //дописывать по необходимости
        switch (Warp.tabTitle()) {
            //industries
            case "E-commerce Website Development Services - Andersen":
                throw new IllegalArgumentException();
            case "Software development for Banks and Financial companies":
                return "Financial Services project map";
            case "Custom eLearning Development Services - Andersen":
                throw new IllegalArgumentException();
            case "Travel Software Development - Custom Travel Solutions - Andersen":
                throw new IllegalArgumentException();
            case "Healthcare Software Development Company - Andersen":
                return "Healthcare project map";
            case "Custom Software Development for Media & Entertainment | Andersen":
                throw new IllegalArgumentException();
            case "Real Estate Software Development - Custom Real Estate Solutions - Andersen":
                throw new IllegalArgumentException();
            case "Telecom Software Development - Custom Telecom Solutions - Andersen":
                throw new IllegalArgumentException();
            case "Software Development for the Online Gambling Industry | Andersenlab":
                throw new IllegalArgumentException();
            case "Logistics Software Development | Andersen":
                throw new IllegalArgumentException();
            case "Custom Enterprise Software for Your Growth":
                throw new IllegalArgumentException();
            case "Retail Software Development | Andersen":
                throw new IllegalArgumentException();
            //services
            case "QA in full-cycle of software development":
                return "Andersen's QA Engagements";
            case "Get qualified software developers & engineers":
                return "Real-time project map";
            case "Professional Business Analysts":
                return "Andersen's BA Engagements";
            case "Custom Software Development Company - Andersen":
                return "Real-time project map";
            case "Mobile App Design & Development Company - Andersen":
                return "Real-time project map";

            //Techstack
            //Front-end
            case "Hire Experienced Front-end Developers - Andersen":
            case "Hire Experienced Angular Developers - Andersen":
            case "Hire Experienced JavaScript Developers - Andersen":
            case "Hire Experienced React.js Developers - Andersen":
            case "Hire Experienced Vue.js Developers - Andersen":
            //Back-end
            case "Hire Experienced Back-end Developers - Andersen":
            case "Hire Experienced Java Developers - Andersen":
            case "Hire Experienced .NET Developers - Andersen":
            case "Hire Experienced PHP Developers - Andersen":
            case "Hire Experienced Python Developers - Andersen":
            case "Hire Experienced Ruby Developers - Andersen":
            case "Hire Experienced Node.js Developers - Andersen":
            case "Hire Experienced Scala Developers - Andersen":
            case "Hire Experienced Golang Developers - Andersen":
            case "Hire Experienced C/C++ Developers - Andersen":
            //Mobile
            case "Hire Experienced Mobile Developers - Andersen":
            case "Hire Experienced Android Developers - Andersen":
            case "Hire Experienced iOS Developers - Andersen":
            case "Hire Experienced Xamarin Developers - Andersen":
            case "Hire Experienced React Native Developers - Andersen":
            case "Hire Experienced Ionic Developers - Andersen":
            case "Flutter App Development | Andersen":
                return "Real-time project map";
            default:
                throw new IllegalArgumentException();
        }
    }
}

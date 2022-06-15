package com.andersenlab.autotests.site.page.services.customsoftware.blocks.consultation;

import com.andersenlab.autotests.site.utility.Warp;
import org.openqa.selenium.By;

public interface ConsultationLocators {
    String BASE = "//h2[contains(text(), 'Contact us for a free consultation')]//..//..";

    By TITLE = By.xpath(BASE + "//h2");
    By SUBTITLE = By.xpath(BASE + "//p[contains(@class, 'subtitle')]");
    By INPUT_NAME = By.xpath(BASE + "//input[@name='name']");
    By INPUT_EMAIL = By.xpath(BASE + "//input[@name='email']");
    By INPUT_PHONE = By.xpath(BASE + "//input[@name='phone']");
    By INPUT_COMMENT = By.xpath(BASE + "//textarea[@name='message']");
    By BUTTON_SEND = By.xpath(BASE + "//button[contains(@class,'sendButton')]");

    String CHECKBOX_TO_PROTECT = BASE + "//label[contains(@class, 'checkbox')]";
    By CHECKBOX_TO_PROTECT_TEXT = By.xpath(CHECKBOX_TO_PROTECT + "//../div");
    By CHECKBOX_TO_PROTECT_I = By.xpath(CHECKBOX_TO_PROTECT + "//following-sibling::div//div/.");

    By LINK_PRIVACY_POLICY = By.xpath(BASE + "//a[contains(@href, 'privacy')]");
    By LINK_TERMS = By.xpath(BASE + "//a[contains(@href, 'terms')]");
    By CAPTCHA = By.xpath(BASE + "//article[contains(@class, 'captcha')]");

    String HINT_CHECKBOX_BASE = "//div[contains(@class, 'hint-module--content')]";
    By HINT_CHECKBOX = By.xpath(HINT_CHECKBOX_BASE + "//div[contains(@class, 'text')]");
    By BUTTON_CLOSE_HINT_CHECKBOX = By.cssSelector("span.react-tooltip-lite > div > div > svg");

    By HINT_MAIL_COOPER = By.xpath(BASE + "//section[contains(@class, 'tooltip-module')]");
    By ASK_PHONE = By.xpath(BASE + "//input[@name='phone']//..");
    By ASK_MAIL = By.xpath(BASE + "//input[@name='email']//..");

    String SUCCESS_BASE = "//div[@id='popup-success' and contains(@class, 'active')]";
    By WINDOW_SUCCESS = By.xpath(SUCCESS_BASE);
    By BUTTON_CLOSE_SUCCESS_WINDOW = By.xpath(SUCCESS_BASE + "//span[contains(@class, 'close')]");
    By TITLE_SUCCESS = By.xpath(SUCCESS_BASE + "//p");

    String TEXT_TITLE = "Schedule Your Free Consultation";
    String TEXT_SUBTITLE = "Need a hand with custom software development? Fill out the form below to receive a free consultation.";

    default String textTitle() {
        //дописывать по необходимости
        switch (Warp.tabTitle()) {
            case "Custom Software Development Company - Andersen":
                return "Schedule Your Free Consultation";
            case "Mobile App Design & Development Company - Andersen":
                return "Contact us for a free consultation on Mobile Development";
            case "Web Development Company - Web App Development Services - Andersen":
                return "Contact us for a free consultation on Web Development";
            case "Application Maintenance and Support Services":
                return "Get free IT Support consultation";
            case "Custom Salesforce development services - Andersen":
                return "Contact us for a free consultation on Salesforce";
            case "Data Science & Big Data Consulting And Development Services - Andersen":
                return "Start Seeing Value from Your Data";
            case "Get qualified software developers & engineers":
                return "Contact us for a free consultation";

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
            case "Custom eLearning Development Services - Andersen":
                return "Contact us for a free consultation";
            case "QA in full-cycle of software development":
                return "Contact us for a free QA consultation";
            case "Professional Business Analysts":
                return "Contact us for a free consultation on Business Analysis";
            default:
                throw new IllegalArgumentException();
        }
    }

    default String textSubTitle() {
        //дописывать по необходимости
        switch (Warp.tabTitle()) {
            case "Custom Software Development Company - Andersen":
                return "Need a hand with custom software development? Fill out the form below to receive a free consultation.";
            case "Mobile App Design & Development Company - Andersen":
            case "Custom Salesforce development services - Andersen":
            case "Web Development Company - Web App Development Services - Andersen":
            case "Professional Business Analysts":
                return "Fill out the form below to receive a free consultation and find out how Andersen can help your business grow.";
            case "Application Maintenance and Support Services":
                return "Need a hand with IT support services? Fill out the form below to receive a free consultation and find out how Andersen can help your business grow.";
            case "Get qualified software developers & engineers":
                return "Need a hand with augmenting your team? Fill out the form below to receive a free consultation and find out how Andersen can help your business grow.";

            //Techstack
            //Front-end
            case "Hire Experienced Front-end Developers - Andersen":
                return "Need a hand with Front-end development? Fill out the form below to receive a free consultation and find out how Andersen can help your business grow.";
            case "Hire Experienced Angular Developers - Andersen":
                return "Need a hand with Angular development? Fill out the form below to improve your business.";
            case "Hire Experienced JavaScript Developers - Andersen":
                return "Need a hand with JavaScript development? Fill out the form below to improve your business.";
            case "Hire Experienced React.js Developers - Andersen":
                return "Need a hand with React.js development? Fill out the form below to improve your business.";
            case "Hire Experienced Vue.js Developers - Andersen":
                return "Need a hand with Vue.js development? Fill out the form below to improve your business.";
            //Back-end
            case "Hire Experienced Back-end Developers - Andersen":
                return "Need a hand with Back-end development? Fill out the form below to receive a free consultation and find out how Andersen can help your business grow.";
            case "Hire Experienced Java Developers - Andersen":
                return "Need a hand with Java development? Fill out the form below to improve your business.";
            case "Hire Experienced .NET Developers - Andersen":
                return "Need a hand with .NET development? Fill out the form below to improve your business.";
            case "Hire Experienced PHP Developers - Andersen":
                return "Need a hand with PHP development? Fill out the form below to improve your business.";
            case "Hire Experienced Python Developers - Andersen":
                return "Need a hand with Python development? Fill out the form below to improve your business.";
            case "Hire Experienced Ruby Developers - Andersen":
                return "Need a hand with Ruby development? Fill out the form below to improve your business.";
            case "Hire Experienced Node.js Developers - Andersen":
                return "Need a hand with Node.js development? Fill out the form below to improve your business.";
            case "Hire Experienced Scala Developers - Andersen":
                return "Need a hand with Scala development? Fill out the form below to improve your business.";
            case "Hire Experienced Golang Developers - Andersen":
                return "Need a hand with Golang development? Fill out the form below to improve your business.";
            case "Hire Experienced C/C++ Developers - Andersen":
                return "Need a hand with C&C++ development? Fill out the form below to improve your business.";
            //Mobile
            case "Hire Experienced Mobile Developers - Andersen":
                return "Need a hand with Mobile development? Fill out the form below to receive a free consultation and find out how Andersen can help your business grow.";
            case "Hire Experienced Android Developers - Andersen":
                return "Need a hand with Android development? Fill out the form below to improve your business.";
            case "Hire Experienced iOS Developers - Andersen":
                return "Need a hand with Android development? Fill out the form below to improve your business.";
            case "Hire Experienced Xamarin Developers - Andersen":
                return "Need a hand with Xamarin development? Fill out the form below to improve your business.";
            case "Hire Experienced React Native Developers - Andersen":
                return "Need a hand with React Native development? Fill out the form below to improve your business.";
            case "Hire Experienced Ionic Developers - Andersen":
                return "Need a hand with Ionic development? Fill out the form below to receive a free consultation and find out how Andersen can help your business grow.";
            case "Flutter App Development | Andersen":
                return "Need a hand with Flutter development? Fill out the form below to receive a free consultation and find out how Andersen can help your business grow.";

            case "Data Science & Big Data Consulting And Development Services - Andersen":
                return "Start getting the most out of your data as soon as possible with Andersen. Fill in the form below to schedule your free consultation, request a quote, or set up a dedicated development team with us.";

            case "QA in full-cycle of software development":
                return "Need a hand with software testing? Fill out the form below to receive a free consultation and find out how Andersen can help your business grow.";
            case "Custom eLearning Development Services - Andersen":
                return "Need a hand with eLearning development services? Fill out the form below to receive a free consultation and find out how Andersen can help your business grow.";
                default:
                throw new IllegalArgumentException();
        }
    }


}

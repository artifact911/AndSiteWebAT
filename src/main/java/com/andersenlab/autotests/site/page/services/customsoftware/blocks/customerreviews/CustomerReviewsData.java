package com.andersenlab.autotests.site.page.services.customsoftware.blocks.customerreviews;

import com.andersenlab.autotests.site.utility.Warp;

public interface CustomerReviewsData {
    String START_WITH = "https://stage.andersenlab.com";
    /*
    описание объектов имплементирующих этот интерфейс:
    передаваться будет по интерфейсу. использует ломбок геттеры.
    заголовок и подзоголовок получаем дефотными методами отсюда
    структура: массив статей, булеан - есть ли слик-кнопки внизу, инт - количество отзывов/статей.
    статья - массив (т е, объект вернет 2-мерный массив строк):
    0 - имя клиента("" - анонимный),
    1 - позиция,
    2 - клатч("" - не ждем),
    3 - текст отзыва,
    4 - ссылка на описание проекта("" - не ждем ссылки)
     */
    String TEXT_MORE_REFS_REF = "andersenlab.com/company/testimonials";

    String[][] getTEXT_ARTICLES();
    int getArtsQuantity();
    Boolean getButtonSlick();

    default String textTitle() {
        //дописывать по необходимости
        String t = Warp.currentURL();
        if(t.contains("services") || t.contains("industries") || t.contains("find-developers")) return "Testimonials";
        else throw new IllegalArgumentException();

    }

    default String textSubtitle() {
        //дописывать по необходимости
        switch (Warp.tabTitle()) {
            case "Custom Software Development Company - Andersen":
                return "We are proud of the great projects Andersen took part in. Here is what our customers say about our expertise in Custom Software Development.";
            case "Web Development Company - Web App Development Services - Andersen":
                return "We are proud of the great projects Andersen took part in. Here is what our customers say about our expertise in Web Development.";
            case "Professional Business Analysts":
                return "We are proud of the great projects Andersen took part in. Here is what our customers say about our expertise in Business Analysis.";
            case "Application Maintenance and Support Services":
                return  "We are proud of the great projects Andersen took part in. Here is what our customers say about our expertise in IT Support.";
            case "Get qualified software developers & engineers":
                return  "We are proud of the great projects Andersen took part in. Here is what our customers say about our expertise in Software Development.";

            //techstack
            //front-end
            case "Hire Experienced Front-end Developers - Andersen":
                return "We are proud of the great projects Andersen took part in. Here is what our customers say about our expertise in Front-end development.";
            case "Hire Experienced Angular Developers - Andersen":
                return "We are proud of the great projects Andersen took part in. Here is what our customers say about our expertise in Angular.";
            case "Hire Experienced JavaScript Developers - Andersen":
                return "We are proud of the great projects Andersen took part in. Here is what our customers say about our expertise in JavaScript.";
            case "Hire Experienced React.js Developers - Andersen":
                return "We are proud of the great projects Andersen took part in. Here is what our customers say about our expertise in React.js.";
            case "Hire Experienced Vue.js Developers - Andersen":
                return "We are proud of the great projects Andersen took part in. Here is what our customers say about our expertise in Vue.js.";
            //back-end
            case "Hire Experienced Back-end Developers - Andersen":
                return "We are proud of the great projects Andersen took part in. Here is what our customers say about our expertise in Back-end development.";
            case "Hire Experienced Java Developers - Andersen":
                return "We are proud of the great projects Andersen has taken part in. Here is what our customers say about our expertise in Java.";
            case "Hire Experienced .NET Developers - Andersen":
                return "We are proud of the great projects Andersen has taken part in. Here is what our customers say about our expertise in .NET.";
            case "Hire Experienced PHP Developers - Andersen":
                return "We are proud of the great projects Andersen has taken part in. Here is what our customers say about our expertise in PHP.";
            case "Hire Experienced Python Developers - Andersen":
                return "We are proud of the great projects Andersen has taken part in. Here is what our customers say about our expertise in Python.";
            case "Hire Experienced Ruby Developers - Andersen":
                return "We are proud of the great projects Andersen has taken part in. Here is what our customers say about our expertise in Ruby.";
            case "Hire Experienced Node.js Developers - Andersen":
                return "We are proud of the great projects Andersen has taken part in. Here is what our customers say about our expertise in Node.js.";
            case "Hire Experienced Scala Developers - Andersen":
                return "We are proud of the great projects Andersen has taken part in. Here is what our customers say about our expertise in Scala.";
            case "Hire Experienced Golang Developers - Andersen":
                return "We are proud of the great projects Andersen has taken part in. Here is what our customers say about our expertise in Golang.";
            case "Hire Experienced C/C++ Developers - Andersen":
                return "We are proud of the great projects Andersen has taken part in. Here is what our customers say about our expertise in C&C++.";
            //mobile
            case "Hire Experienced Mobile Developers - Andersen":
                return "We are proud of the great projects Andersen took part in. Here is what our customers say about our expertise in Mobile development.";
            case "Hire Experienced Android Developers - Andersen":
                return "We are proud of the great projects Andersen has taken part in. Here is what our customers say about our expertise in Android.";
            case "Hire Experienced iOS Developers - Andersen":
                return "We are proud of the great projects Andersen has taken part in. Here is what our customers say about our expertise in iOS.";
            case "Hire Experienced Xamarin Developers - Andersen":
                return "We are proud of the great projects Andersen has taken part in. Here is what our customers say about our expertise in Xamarin.";
            case "Hire Experienced React Native Developers - Andersen":
                return "We are proud of the great projects Andersen has taken part in. Here is what our customers say about our expertise in React Native.";
            case "Hire Experienced Ionic Developers - Andersen":
                return "We are proud of the great projects Andersen took part in. Here is what our customers say about our expertise in Ionic.";
            case "Flutter App Development | Andersen":
                return "";

            //industries
            case "E-commerce Website Development Services - Andersen":
                throw new IllegalArgumentException("TESTIMONIALS NOT IMPLEMENTED");
            case "Software development for Banks and Financial companies":
                return "We are proud of the great projects Andersen took part in. Here is what our customers say about our expertise in Financial Software Development.";
            case "Qualitative software development":
                return "We are proud of the great projects Andersen took part in. Here is what our customers say about our expertise in eLearning Software Development.";
            case "Travel Software Development - Custom Travel Solutions - Andersen":
                return "Andersen is proud of the great projects we have taken part in. Here is what our customers say about our expertise in the Travel & Hospitality industry.";
            case "Healthcare Software Development Company - Andersen":
                return "We are proud of the great projects Andersen took part in. Here is what our customers say about our expertise in Healthcare Software Development.";
            case "Custom Software Development for Media & Entertainment | Andersen":
                return "We are proud of the great projects Andersen took part in. Here is what our customers say about our expertise in Multimedia & Entertainment Software Development.";
            case "Real Estate Software Development - Custom Real Estate Solutions - Andersen":
                throw new IllegalArgumentException("TESTIMONIALS NOT IMPLEMENTED");
            case "Telecom Software Development - Custom Telecom Solutions - Andersen":
                return "We are proud of the great projects Andersen has taken part in. Here is what our customers say about our expertise in Telecom software development.";
            case "Software Development for the Online Gambling Industry | Andersenlab":
                return "We are proud of the great projects Andersen took part in. Here is what our customers say about our expertise in iGaming Software Development.";
            case "Logistics Software Development | Andersen":
                return "We are proud of the great projects Andersen has taken part in. Here is what our customers say about our expertise in Logistics.";
            case "Custom Enterprise Software for Your Growth":
                throw new IllegalArgumentException("TESTIMONIALS NOT IMPLEMENTED");
            case "Retail Software Development | Andersen":
                return "We are proud of the great projects Andersen took part in. Here is what our customers say about our expertise in Retail Software Development.";

            //industries subpages
            case "Custom sports betting software solutions and development":
                return "We are proud of the great projects Andersen took part in. Here is what our customers say about our expertise in iGaming Software Development.";
            case "iGaming software development & consulting":
                return "We are proud of the great projects Andersen took part in. Here is what our customers say about our expertise in iGaming Software Development.";
            case "Telemedicine software development":
                return "We are proud of the great projects Andersen took part in. Here is what our customers say about our expertise in Healthcare Software Development.";
            case "Custom EMR Software Development":
                return "We are proud of the great projects Andersen took part in. Here is what our customers say about our expertise in Healthcare Software Development.";
            case "IoMT and Healthcare Data Analytics solutions | Andersen":
                return "We are proud of the great projects Andersen took part in. Here is what our customers say about our expertise in Healthcare Software Development.";
            case "Custom Healthcare and Medical Software Development":
                return "We are proud of the great projects Andersen took part in. Here is what our customers say about our expertise in Healthcare Software Development.";
            case "Data Science & Big Data Consulting And Development Services - Andersen":
            case "Custom Salesforce development services - Andersen":
                return "We are proud of the great projects Andersen took part in. Here is what our customers say about our expertise in Salesforce Consulting & Development.";
            case "Custom eLearning Development Services - Andersen":
                return "We are proud of the great projects Andersen took part in. Here is what our customers say about our expertise in eLearning Software Development.";
            case "QA in full-cycle of software development":
                return "SMB, enterprise, and startup clients return to us because they’re satisfied with our work. Here’s what they say about Andersen.";
            case "Mobile App Design & Development Company - Andersen":
                return "We are proud of the great projects Andersen took part in. Here is what our customers say about our expertise in Mobile Development.";
            default:
                throw new IllegalArgumentException();
        }
    }
}

package com.andersenlab.autotests.site.page.services.mobiledevelopment.blocks.developmentservices;

import org.openqa.selenium.By;

public interface DevelopmentServicesLocators {
    String BASE2 = "//section[contains(@class, 'what-we-do')]";
    By TITLE2 = By.xpath(BASE2 + "//h2[@class='what-we-do__title h2']");
    By ARTICLES_TITLE2 = By.xpath(BASE2 + "//h3[contains(@class, 'development-services__item-title')]");
    String TEXT_TITLE2 = "What we do";
    String[] TEXT_ARTICLES_TITLE2 = {
            "Consulting",
            "Business Analysis",
            "UI/UX Design",
            "Mobile Development",
            "Quality Assurance",
            "Support and Maintenance"
    };
}

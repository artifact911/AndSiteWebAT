package com.andersenlab.autotests.site.page.homepage.blocks.navbar;


import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.andersenlab.autotests.site.page.homepage.blocks.navbar.NavBarLocators.*;
import static com.codeborne.selenide.Selenide.$;

/**
 * Кнопки навигационного блока
 */
@Getter
public class NavBarBlock {

    private SelenideElement homePage = $(HOMEPAGE);
    private SelenideElement dropDownMenuTechStack = $(TECHSTACK);
    private SelenideElement dropDownMenuIndustries = $(INDUSTRIES);
    private SelenideElement dropDownMenuServices = $(SERVICES);
    private SelenideElement dropDownMenuCompany = $(COMPANY);
    private SelenideElement projectsButton = $(PROJECTS);
    private SelenideElement searchButton = $(SEARCH);
    private SelenideElement pricingButton = $(PRICING);

}

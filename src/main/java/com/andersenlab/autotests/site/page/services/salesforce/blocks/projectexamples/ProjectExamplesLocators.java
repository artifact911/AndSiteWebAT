package com.andersenlab.autotests.site.page.services.salesforce.blocks.projectexamples;

import org.openqa.selenium.By;

public interface ProjectExamplesLocators {
    String BASE = "//section[contains(@class, 'js-projects-examples')]";
    By TITLE = By.xpath(BASE + "//h2");
    By SUBTITLE = By.xpath(BASE + "//p[contains(@class, 'subtitle')]");
    By VCS = By.xpath(BASE + "//article[contains(@class, 'vc-card') and not(contains(@style, 'display: none;'))]//button[contains(@class, 'vc-card')]");
    String BASE_CONCEPT = "//div[@id='concept' and contains(@class, 'popup_active')]";
    By CONCEPT = By.xpath(BASE_CONCEPT);
    By BUTTON_CLOSE_CONCEPT = By.xpath(BASE_CONCEPT + "//div[@class='popup__close js--popup-close']");

    String TEXT_TITLE = "Projects examples";
    String TEXT_SUBTITLE = "We offer our all-round domain expertise, first-class engineers, robust development processes, flexible customer-oriented approach.";
}

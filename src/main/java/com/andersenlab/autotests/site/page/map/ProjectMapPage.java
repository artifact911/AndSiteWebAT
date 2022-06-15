package com.andersenlab.autotests.site.page.map;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.andersenlab.autotests.site.page.map.ProjectMapLocators.TITLE;
import static com.codeborne.selenide.Selenide.$;
/**
 * Andersen’s Project Map https://andersenlab.com/projects-map
 */
@Getter
public class ProjectMapPage {
    private SelenideElement title = $(TITLE);
}

package com.andersenlab.autotests.site.page.engineers;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.andersenlab.autotests.site.page.engineers.EngineersOnProjectsLocators.TITLE;
import static com.codeborne.selenide.Selenide.$;

/**
 * Engineers  //________ https://andersenlab.com/engineers-on-projects
 */
@Getter
public class EngineersOnProjectsPage {
    private SelenideElement title = $(TITLE);
}

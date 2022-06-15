package com.andersenlab.autotests.site.page.homepage.blocks.technologies;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.andersenlab.autotests.site.page.homepage.blocks.technologies.TechnologiesLocators.*;
import static com.codeborne.selenide.Selenide.$;

/**
 * Блок "Technologies"
 */
@Getter
public class TechnologiesBlock {

    private SelenideElement linkFrontEndPage = $(LINK_FRONT_END_PAGE);
    private SelenideElement linkScalaPage = $(LINK_SCALA_PAGE);
    private SelenideElement linkMobilePage = $(LINK_MOBILE_PAGE);
    private SelenideElement linkDedicatedTeamPage = $(LINK_DEDICATED_TEAM);
    private SelenideElement linkDotNetPage = $(LINK_DOT_NET_PAGE);
    private SelenideElement linkPythonPage = $(LINK_PYTHON_PAGE);
    private SelenideElement linkJavaPage = $(LINK_JAVA_PAGE);
}

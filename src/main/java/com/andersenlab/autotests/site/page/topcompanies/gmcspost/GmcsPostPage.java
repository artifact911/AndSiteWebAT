package com.andersenlab.autotests.site.page.topcompanies.gmcspost;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.andersenlab.autotests.site.page.topcompanies.TopCompaniesSharedLocators.*;
import static com.codeborne.selenide.Selenide.$;

/**
 * GMCS/RUSSIANPPOST  ___ https://dev.andersenlab.com/our-projects/software-for-pos-terminal
 */
@Getter
public class GmcsPostPage {
    private SelenideElement headerTitle = $(HEADER_TITLE);
}

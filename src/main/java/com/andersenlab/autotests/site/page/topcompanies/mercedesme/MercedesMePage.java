package com.andersenlab.autotests.site.page.topcompanies.mercedesme;


import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.andersenlab.autotests.site.page.topcompanies.mercedesme.MercedesMePageLocators.*;
import static com.codeborne.selenide.Selenide.$;

/**
 * Mercedes Me https://dev.andersenlab.com/case-mercedes.php
 */
@Getter
public class MercedesMePage {

    private SelenideElement headerTitle = $(HEADER_TITLE);

}

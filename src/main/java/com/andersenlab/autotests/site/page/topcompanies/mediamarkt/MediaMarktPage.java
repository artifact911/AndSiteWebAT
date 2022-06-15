package com.andersenlab.autotests.site.page.topcompanies.mediamarkt;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.andersenlab.autotests.site.page.topcompanies.mediamarkt.MediaMarktPageLocators.*;
import static com.codeborne.selenide.Selenide.$;

/**
 *Media Markt  https://andersenlab.com/mediamarkt.php
 */
@Getter
public class MediaMarktPage {

private SelenideElement headerTitle = $(HEADER_TITLE);
}

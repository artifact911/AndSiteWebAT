package com.andersenlab.autotests.core.utils.utility;

import lombok.Getter;
import org.openqa.selenium.By;

@Getter
class UtilityLocators {
    final static By acceptCookiesButton = By.xpath("//button[contains(@class, 'CookiesPolicy-module--button')]");
    final static By headerTopBlock = By.xpath("//div[contains(@class, 'toplineInside')]");
    final static By headerBottomBlock = By.xpath("//div[contains(@class, 'botlineInside')]");
}

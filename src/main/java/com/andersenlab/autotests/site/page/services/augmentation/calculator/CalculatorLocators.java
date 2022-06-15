package com.andersenlab.autotests.site.page.services.augmentation.calculator;

import org.openqa.selenium.By;

public interface CalculatorLocators {
    By PLUS_BUTTON = By.xpath("//span[text()=\"Vue.js\"]/parent::h4/following-sibling::div/button[2]");
    By MINUS_BUTTON = By.xpath("//span[text()=\"Vue.js\"]/parent::h4/following-sibling::div/button[1]");

    By CLEAR_ALL = By.xpath("//button[contains(@class, 'clearAll')]");
    By JS_TOOL_TIP = By.xpath("//span[text()=\"JavaScript\"]/following-sibling::span/div/*");
    By JS_TOOL_TIP_INFO = By.xpath("//div[contains(@class, 'Hint-module--text')]");
    By RUBY_TOOL_TIP = By.xpath("//span[text()=\"Ruby\"]/following-sibling::span/div/*");
    By RUBY_TOOL_TIP_INFO = By.xpath("//div[text()='Scope: Fintech, large and medium startups.']");
    By ANGULAR_TOOL_TIP = By.xpath("//span[text()=\"Angular\"]/following-sibling::span/div/*");
    By ANGULAR_TOOL_TIP_INFO = By.xpath("//div[text()='Suitable for medium and large Enterprise industry projects.']");

    By JAVA_PLUS_BUTTON = By.xpath("//span[text()=\"Java\"]/parent::h4/following-sibling::div/button[2]");
    By JAVA_MINUS_BUTTON = By.xpath("//span[text()=\"Java\"]/parent::h4/following-sibling::div/button[1]");
    By JAVA_COUNTER = By.xpath("//span[text()=\"Java\"]/parent::h4/following-sibling::div/input");
    By JAVA_POP_UP = By.xpath("//div[contains(@class, 'Tag-module')]");
    By JAVA_POP_UP_EXACT_ONE = By.xpath("//div[contains(@class, 'Tag-module') and text()='Java - 1 specialist']");
    By JAVA_HIGHLIGHT = By.xpath("//span[contains(@class, 'Desktop-module--highlight')]");
    By PM_PLUS_BUTTON = By.xpath("//div[text()=\"Project Manager\"]/following-sibling::div/button[2]");
    By PM_MINUS_BUTTON = By.xpath("//div[text()=\"Project Manager\"]/following-sibling::div/button[1]");
    By PM_COUNTER = By.xpath("//div[text()=\"Project Manager\"]/following-sibling::div/input");
    By PM_POP_UP = By.xpath("//div[text()='Project Manager - 1 specialist']");
    By FS_RADIO_BUTTON = By.xpath("//input[@value=\"Financial Services\"]/following-sibling::span");
    By FS_POP_UP = By.xpath("//div[contains(@class, 'Tag-module') and text()='Financial Services']");
    By TELECOM_RADIO_BUTTON = By.xpath("//input[@value=\"Telecom\"]/following-sibling::span");
    By TELECOM_CLOSE_POP_UP = By.xpath("//div[contains(@class, 'Tag-module') and text()='Telecom']");

    By FOR_SCROLL_TO_MAPS = By.xpath("//p[contains(@class,'ProjectsMap')]");
    By DURATION_LINE = By.xpath("//div[@class=\"rc-slider-handle\"]");
    By DURATION_LINE_POP_UP = By.xpath("//div[contains(@class, 'Tag-module') and contains(text(), 'months')]");
    By DURATION_LINE_9_MONTH = By.xpath("//div[@class=\"rc-slider-step\"]/span[@style=\"left: 36%;\"]");
    By DURATION_LINE_COLOR_TRACK = By.xpath("//div[@class=\"rc-slider-track\"]");
    By DURATION_LINE_1_YEAR = By.xpath("//div[@class=\"rc-slider-step\"]/span[@style=\"left: 48%;\"]");
    By DURATION_LINE_CLOUD = By.xpath("//div[contains(@class, 'RangeSlider-module--tooltip')]/div");
    By DURATION_LINE_23_MONTH = By.xpath("//div[@class=\"rc-slider-step\"]/span[@style=\"left: 92%;\"]");
    By DURATION_LINE_2_YEARS = By.xpath("//div[@class=\"rc-slider-step\"]/span[@style=\"left: 96%;\"]");

    By GET_PRICE_BUTTON = By.xpath("//div[contains(@class, 'Calculator')]//button[contains(@class, 'button-module--button') and contains(text(), 'Get price')]");
    By GET_PRICE_POP_UP = By.xpath("//button[contains(@class, 'PreviewModal-module') and text() = 'Get price']");
    By SEND_FORM = By.xpath("//div[contains(@class, 'ResultModal-module--layout')]");
    By CROSS_BUTTON = By.xpath("//button[contains(@class, 'close-button-module--close--')]");

    By TOOL_TIP_NEAR_SEND_FORM = By.xpath("//div[contains(@class, 'forms-module--wrapper')]//div/*");
    By TOOL_TIP_NEAR_SEND_FORM_INFO = By.xpath("//div[contains(text(), \"Before we discuss any details\")]");
    By NDA_CHECK_BOX = By.xpath("//form//label[contains(@class, 'Checkbox-module')]");
    By PL_REF = By.xpath("//article[contains(@class, 'GetConsultation-module--captchaRight')]//a[@href='https://policies.google.com/privacy']");
    By TERMS_REF = By.xpath("//article[contains(@class, 'GetConsultation-module--captchaRight')]//a[@href='https://policies.google.com/terms']");

    By BOTTOM_PAGE_TEXT = By.xpath("//p[contains(@class, 'NavColumn-module--title')]");
}


package com.andersenlab.autotests.site.page.services.augmentation.calculator;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CalculatorElements implements CalculatorLocators {

    static String yellowColor = "#ffdb00";
    static String greyColor = "#e0e0e0";

    SelenideElement plRef = $(PL_REF);
    SelenideElement termsRef = $(TERMS_REF);

    SelenideElement plusButton = $(PLUS_BUTTON);
    SelenideElement minusButton = $(MINUS_BUTTON);

    SelenideElement clearAll = $(CLEAR_ALL);
    SelenideElement jsToolTip = $(JS_TOOL_TIP);
    SelenideElement jsToolTipInfo = $(JS_TOOL_TIP_INFO);
    SelenideElement rubyToolTip = $(RUBY_TOOL_TIP);
    SelenideElement rubyToolTipInfo = $(RUBY_TOOL_TIP_INFO);
    SelenideElement angularToolTip = $(ANGULAR_TOOL_TIP);
    SelenideElement angularToolTipInfo = $(ANGULAR_TOOL_TIP_INFO);

    SelenideElement javaPlusButton = $(JAVA_PLUS_BUTTON);
    SelenideElement javaMinusButton = $(JAVA_MINUS_BUTTON);
    SelenideElement javaCounter = $(JAVA_COUNTER);
    SelenideElement javaPopUp = $(JAVA_POP_UP);
    SelenideElement javaPopUpExactOne = $(JAVA_POP_UP_EXACT_ONE);
    SelenideElement javaHighLight = $(JAVA_HIGHLIGHT);
    SelenideElement pmPlusButton = $(PM_PLUS_BUTTON);
    SelenideElement pmMinusButton = $(PM_MINUS_BUTTON);
    SelenideElement pmCounter = $(PM_COUNTER);
    SelenideElement pmPopUp = $(PM_POP_UP);
    SelenideElement fsRadioButton = $(FS_RADIO_BUTTON);
    SelenideElement fsPopUp = $(FS_POP_UP);
    SelenideElement telecomRadioButton = $(TELECOM_RADIO_BUTTON);
    SelenideElement telecomClosePopUp = $(TELECOM_CLOSE_POP_UP);

    SelenideElement forScrollToMaps = $(FOR_SCROLL_TO_MAPS);
    SelenideElement durationLine = $(DURATION_LINE);
    SelenideElement durationLinePopUp = $(DURATION_LINE_POP_UP);
    SelenideElement durationLine9Month = $(DURATION_LINE_9_MONTH);
    SelenideElement durationLineColorTrack = $(DURATION_LINE_COLOR_TRACK);
    SelenideElement durationLine1Year = $(DURATION_LINE_1_YEAR);
    SelenideElement durationLineCloud = $(DURATION_LINE_CLOUD);
    SelenideElement durationLine23Month = $(DURATION_LINE_23_MONTH);
    SelenideElement durationLine2Years = $(DURATION_LINE_2_YEARS);

    SelenideElement getPriceButton = $(GET_PRICE_BUTTON);
    SelenideElement getPricePopUp = $(GET_PRICE_POP_UP);
    SelenideElement sendForm = $(SEND_FORM);
    SelenideElement crossButton = $(CROSS_BUTTON);

    SelenideElement toolTipNearSendForm = $(TOOL_TIP_NEAR_SEND_FORM);
    SelenideElement toolTipNearSendFormInfo = $(TOOL_TIP_NEAR_SEND_FORM_INFO);
    SelenideElement ndaCheckBox = $(NDA_CHECK_BOX);

    SelenideElement bottomPageText = $(BOTTOM_PAGE_TEXT);
}

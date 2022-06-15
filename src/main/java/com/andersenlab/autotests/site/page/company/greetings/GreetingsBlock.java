package com.andersenlab.autotests.site.page.company.greetings;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;
import static com.andersenlab.autotests.site.page.company.greetings.GreetingsLocators.*;

public class GreetingsBlock {
    @Getter private final SelenideElement title = $(TITLE);
    @Getter private final SelenideElement photo = $(PHOTO);
    @Getter private final SelenideElement name = $(NAME);
    @Getter private final SelenideElement linkedin = $(LINKEDIN);
    @Getter private final SelenideElement position = $(POSITION);
    @Getter private final SelenideElement greetingMessage = $(GREETING_MESSAGE);
    @Getter private final SelenideElement videoPreview = $(VIDEO_PREVIEW);
    @Getter private final SelenideElement videoPopup = $(VIDEO_POPUP);
    @Getter private final SelenideElement videoCloseBtn = $(VIDEO_CLOSE_BTN);
    @Getter private final SelenideElement forbesLink = $(FORBES);
}

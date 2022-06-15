package com.andersenlab.autotests.site.page.homepage.blocks.meetustomorrow;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.andersenlab.autotests.site.page.homepage.blocks.meetustomorrow.MeetUsTomorrowLocators.*;
import static com.codeborne.selenide.Selenide.$;
/**
 * Блок "Meet Us Tomorrow"
 */
@Getter
public class MeetUsTomorrowBlock {
    private SelenideElement viewAllButton = $(VIEW_ALL_BUTTON);
    private SelenideElement RequestMeetingLink = $(REQUEST_MEETING_LINK);
}

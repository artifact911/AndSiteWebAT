package com.andersenlab.autotests.site.page.company.meetustomorrow;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.andersenlab.autotests.site.page.company.meetustomorrow.MeetUsTomorrowLocators.*;
import static com.codeborne.selenide.Selenide.$;

/**
 * Страница трипов https://dev.andersenlab.com/meet-us-tomorrow
 */
@Getter
public class MeetUsTomorrowPage {
    MeetUsTomorrowOperations operations = new MeetUsTomorrowOperations();
    private SelenideElement title = $(TITLE);
    private SelenideElement pageThreeButton = $(PAGE_THREE_BUTTON);
    private SelenideElement paginationItemCurrent = $(PAGINATION_ITEM_CURRENT);
    private SelenideElement requestMeetingLink = $(REQUEST_MEETING_LINK);
    private SelenideElement requestMeetingPopup = $(REQUEST_MEETING_POPUP);
}

package com.andersenlab.autotests.site.page.company.meetustomorrow;

import org.openqa.selenium.By;

class MeetUsTomorrowLocators {
    static final By TITLE = By.tagName("h1");
    static final String PAGINATION_NEXT = ".pagination__next";
    static final String PAGINATION_PREV = ".pagination__prev";
    static final By PAGE_THREE_BUTTON = By.xpath("//button[text()='3']");
    static final By PAGINATION_ITEM_CURRENT = By.className("pagination__item__current");
    static final By REQUEST_MEETING_LINK = By.id("trips-list__link_select");
    static final By REQUEST_MEETING_POPUP = By.cssSelector("div#popup_request_simple .popup__section");
}

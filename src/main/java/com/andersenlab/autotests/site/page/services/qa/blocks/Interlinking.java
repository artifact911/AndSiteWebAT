package com.andersenlab.autotests.site.page.services.qa.blocks;

import com.andersenlab.autotests.site.utility.Warp;

public class Interlinking {
    private String BASE; //"//section[contains(@class, 'interlinking')]"
    private String link;
    private String HREF;//"https://dev.andersenlab.com/andersen-qa-community";

    public Interlinking(String BASE, String HREF) {
        this.BASE = BASE;
        this.HREF = HREF;
        calc();
    }

    private void calc() {
        link = BASE + "//a";
    }

    public void displayingElements() {
        Warp.checkLinkThisTab(link, HREF);
        Warp.mouseIsPointer(link);
    }
}

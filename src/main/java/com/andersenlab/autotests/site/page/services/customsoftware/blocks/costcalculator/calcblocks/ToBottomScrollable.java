package com.andersenlab.autotests.site.page.services.customsoftware.blocks.costcalculator.calcblocks;

import com.andersenlab.autotests.site.utility.Warp;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public interface ToBottomScrollable {
    default void scrollToBottom(String BASE) {
        ElementsCollection nextBlock = $$(By.xpath(BASE + "/./following-sibling::section[1]//p[contains(@class, 'subtitle')]"));
        if (!nextBlock.isEmpty()) {
            Warp.scrollToElement(nextBlock.first());
        } else {
            String sectionBase = ("//").concat(BASE.split("//")[1]);
            String nextSection = sectionBase + "/ancestor::section[contains(@class, 'container-module')]/following-sibling::section[1]//h2[contains(@class, 'h2')]";
            Warp.scrollToElement($(By.xpath(nextSection)));
        }
    }
}


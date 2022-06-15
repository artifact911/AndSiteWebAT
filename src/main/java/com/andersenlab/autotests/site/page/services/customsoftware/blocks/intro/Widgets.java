package com.andersenlab.autotests.site.page.services.customsoftware.blocks.intro;

import com.andersenlab.autotests.core.steps.Assertions;
import com.andersenlab.autotests.site.utility.Warp;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;

public enum Widgets {
    CLUTCH {
        @Override
        public void check(SelenideElement w) {
            w.should(Condition.visible);
            Assertions.mouseIsNotPointer(w);
            Assert.assertTrue(w.getAttribute("alt").contains("Clutch staff") || w.getAttribute("alt").contains("Clutch top") || w.getAttribute("alt").contains("The clutch") ); //"top software" or "Top software development"
        }
    },
    CLUTCH_CLICKABLE {
        @Override
        public void check(SelenideElement w) {
            w.should(Condition.visible);
            Assertions.mouseIsPointer(w);
            Warp.elementIsIntractable(w);
            String href = Warp.justOpenedTabGetUrlAndClose(w);
            Assert.assertTrue(href.contains("https://clutch.co/profile/andersen"));
        }
    },
    CLUTCH_STARED {
        @Override
        public void check(SelenideElement w) {
            w.should(Condition.visible);
            Assertions.mouseIsPointer(w);
            Warp.elementIsIntractable(w);
            String href = Warp.justOpenedTabGetUrlAndClose(w);
            Assert.assertTrue(href.contains("https://clutch.co/it-services/staff-augmentation"));
        }
    },
    ISTQB {
        @Override
        public void check(SelenideElement w) {
            Warp.elementIsIntractable(w);
            Assertions.mouseIsPointer(w);
            w.click();
            final String BASE = "//*[contains(@class, 'intro-module--content--1__Ik box')]"; //style="display: none;"/style="display: block;"
            final String TITLE = BASE + "//*[contains(@class, 'title')]";
            final String CLOSE = BASE + "//span[contains(@class, 'close')]";
            final String OFF_SITE = BASE + "//p[contains(text(), 'Official website:')]//a";
            final String TEXT_PART = BASE + "//p[contains(text(),' International Software Testing Qualifications Board')]";
            Assert.assertEquals(Warp.el(TITLE).getAttribute("innerText"), "ISTQB Certification");
            Assert.assertTrue(Warp.isElementPresent(TEXT_PART) == 1);
            Warp.checkLinkThisTab(OFF_SITE, "https://www.istqb.org/");
            Warp.clickSimple(CLOSE);
            Assert.assertTrue(Warp.isElementPresent(BASE) == 0);
        }
    },
    PARTNER {
        @Override
        public void check(SelenideElement w) {
            w.should(Condition.visible);
            Assertions.mouseIsNotPointer(w);
            Assert.assertEquals(w.getAttribute("alt"), "Salesforce partner");
        }
    },
    PECB_MS_ISO_9001 {
        @Override
        public void check(SelenideElement w) {
            w.should(Condition.visible);
            Assertions.mouseIsPointer(w);
            Assert.assertEquals(w.getAttribute("alt"), "ISO 9001-2015");
        }
    },
    PECB_MS_ISO_27001 {
        @Override
        public void check(SelenideElement w) {
            w.should(Condition.visible);
            Assertions.mouseIsPointer(w);
            Assert.assertEquals(w.getAttribute("alt"), "ISO 27001");
        }
    },
    ISO_9001 {
        @Override
        public void check(SelenideElement w) {
            w.should(Condition.visible);
            Assert.assertEquals(w.getAttribute("alt"), "ISO 9001 logo");
        }
    },
    ISO_27001 {
        @Override
        public void check(SelenideElement w) {
            w.should(Condition.visible);
            Assert.assertEquals(w.getAttribute("alt"), "ISO/IEC 27001 logo");
        }
    },
    GDPR {
        @Override
        public void check(SelenideElement w) {
            w.should(Condition.visible);
            Assert.assertEquals(w.getAttribute("alt"), "GDPR logo");
        }
    },
    ;

    public void check(SelenideElement w) {
        Assert.fail("NOT OVERRIDE");
    }
}

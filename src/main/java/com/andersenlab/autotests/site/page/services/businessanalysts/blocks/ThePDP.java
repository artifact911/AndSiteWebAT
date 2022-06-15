package com.andersenlab.autotests.site.page.services.businessanalysts.blocks;

import com.andersenlab.autotests.site.form.popup.requestform.RequestForm;
import com.andersenlab.autotests.site.logic.Navigation;
import com.andersenlab.autotests.site.page.services.mobiledevelopment.blocks.projectexamples.ProjectExamples;
import com.andersenlab.autotests.site.utility.Warp;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;

public class ThePDP {
    private int progress = -1;
    private final By TITLE = By.xpath("//section[contains(@class, 'intro')]" + "//h1[contains(@class, 'intro__title')]");
    private final String LAYOUT = "//div[contains(@class, 'article__layout')]";
    private final By H_1 = By.xpath(LAYOUT + "//h2[contains(text(), 'What a ')]");
    private final By H_2 = By.xpath(LAYOUT + "//h2[contains(text(), 'What are the benefits')]");
    private final By H_3 = By.xpath(LAYOUT + "//h2[contains(text(), 'What if the discovery phase')]");
    private final By H_4 = By.xpath(LAYOUT + "//h2[contains(text(), 'Conclusion')]");
    private final By BUTTON_REQ = By.xpath(LAYOUT + "//button[@data-popup='popup_request']");
    private final String INTER = "//div[contains(@class, 'interlinking')]";
    private final By TITLE_INTER = By.xpath(INTER + "//h2");
    private final String LINK = INTER + "//a";
    private final By PROGRESS_BAR = By.xpath("//div[contains(@class, 'progress-bar')]");
    private final String ARTICLE_LINK = "https://dev.andersenlab.com/blueprint/importance-of-discovery-phase";

    private SelenideElement buttonReq = $(BUTTON_REQ);
    private SelenideElement title = $(TITLE);
    private SelenideElement titleInter = $(TITLE_INTER);
    private SelenideElement progressBar = $(PROGRESS_BAR);

    @Step
    public void displayingElements() {
        Navigation.gotoLink(ARTICLE_LINK);
        Assert.assertEquals(title.getAttribute("innerText"), "The Importance of the Discovery Phase");
        Assert.assertTrue(Warp.isElementPresent(H_1));
        Warp.scrollToElement(H_2);
        progress();
        Warp.scrollToElement(H_2);
        progress();
        Warp.scrollToElement(buttonReq);
        progress();
        Assert.assertEquals(titleInter.getAttribute("innerText"), "See the opportunity to Business Analysis Services easy as never before");

        buttonReq.click();
        new RequestForm().closeReq();

        Warp.checkLinkThisTab(LINK, "https://dev.andersenlab.com/services/business-analysts");
    }

    private void progress() {
        System.out.println(Integer.parseInt(progressBar.getAttribute("style").substring(7, 9)));
        Assert.assertTrue(Integer.parseInt(progressBar.getAttribute("style").substring(7, 9)) >= progress);
        progress = Integer.parseInt(progressBar.getAttribute("style").substring(7, 9));
    }


}

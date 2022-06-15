package com.andersenlab.autotests.site.page.industries.igaming.blocks;

import com.andersenlab.autotests.core.configs.constants.CSSProperties;
import com.andersenlab.autotests.site.utility.Warp;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;

public class FreeConsultationBlock {
    private final FreeConsultationBlockLocators block = new FreeConsultationBlockLocators();
    private final PopupInfo popupInfo = new PopupInfo();
    private final RequestConsultationForm requestForm = new RequestConsultationForm();

    @Getter private final SelenideElement title = $(block.getTITLE());
    @Getter private final SelenideElement requestBtn = $(block.getREQUEST_CONSULTATION_BTN());
    @Getter private final SelenideElement seeMore = $(block.getSEE_MORE_LINK());
    @Getter private final SelenideElement formTitle = $(requestForm.getTITLE());
    @Getter private final SelenideElement formCloseBtn = $(requestForm.getCLOSE_BTN());
    @Getter private final SelenideElement popupTitle = $(popupInfo.getTITLE());
    @Getter private final SelenideElement popupCloseBtn = $(popupInfo.getCLOSE_BTN());

    @Step
    public void checkBlock(String titleText){
        Assert.assertEquals(title.should(Condition.appear).getText(), titleText);
        Assert.assertEquals(requestBtn.getCssValue("background-color"), CSSProperties.Color.YELLOW.getCode());
        Assert.assertEquals(requestBtn.hover().getCssValue("background-color"), CSSProperties.Color.LIGHT_YELLOW.getCode());
    }

    @Step
    public void checkPopupForm(String formTitleText){
        requestBtn.click();
        Warp.delay(1);
        Assert.assertEquals(formTitle.getText(), formTitleText);
        formCloseBtn.click();
        Assert.assertFalse(formTitle.shouldBe(Condition.disappear).isDisplayed());
    }

    @Step
    public void checkPopupInfo(String popupTitleText){
        Warp.scrollToElement(seeMore);
        seeMore.click();
        Warp.delay(1);
        Assert.assertEquals(popupTitle.getText(), popupTitleText);
        popupCloseBtn.click();
        Warp.delay(1);
        Assert.assertFalse(popupTitle.isDisplayed());
    }
}

class FreeConsultationBlockLocators{
    private final String BASE = "//p[contains(text(), 'Schedule a free online consultation')]/../..";
    @Getter private final By TITLE = By.xpath(BASE + "//p[contains(@class, 'title')]");
    @Getter private final By REQUEST_CONSULTATION_BTN = By.xpath(BASE + "//button");
    @Getter private final By SEE_MORE_LINK = By.xpath(BASE + "//div[contains(@class, 'CallToAction-module--link')]");
}

class PopupInfo{
    private final String BASE = "//section[contains(@class, 'modal-module--popup')]";
    @Getter private final By TITLE = By.xpath(BASE + "//h3");
    @Getter private final By CLOSE_BTN = By.xpath(BASE + "//button[contains(@class, 'close')]");
}

class RequestConsultationForm{
    private final String BASE = "//section[contains(@class, 'modal-module--popup')]";
    @Getter private final By TITLE = By.xpath(BASE + "//h3");
    @Getter private final By CLOSE_BTN = By.xpath(BASE + "//button[contains(@class, 'close')]");
}


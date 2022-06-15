package com.andersenlab.autotests.site.page.industries.videoandentertainment.blocks.costcalc;

import com.andersenlab.autotests.core.configs.constants.CSSProperties;
import com.andersenlab.autotests.core.configs.constants.Country;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.List;

import static com.andersenlab.autotests.core.configs.constants.CostCalcData.checkboxes;
import static com.andersenlab.autotests.core.configs.constants.CostCalcData.plusMinusCounter;
import static com.andersenlab.autotests.core.configs.constants.CostCalcData.radiobtns;
import static com.andersenlab.autotests.core.configs.constants.CostCalcData.slider;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.switchTo;

public class MobileCostCalc {
    private final CostCalcMobileLocators mLocators = new CostCalcMobileLocators();

    private SelenideElement mSectionTitle;
    private SelenideElement mSectionTitleAfterChoose;
    private SelenideElement mSectionCounter;
    private ElementsCollection mSectionList;
    private SelenideElement mSectionEditBtn;
    private ElementsCollection mSectionButtons;

    private final SelenideElement mTitle = $(mLocators.getTITLE());
    private final SelenideElement mSubtitle = $(mLocators.getSUBTITLE());
    private final SelenideElement mClearBtn = $(mLocators.getCLEAR_BTN());
    private final SelenideElement mCalculateBtn = $(mLocators.getCALCULATE_BTN());

    private final SelenideElement mSectionPopupTitle = $(mLocators.getPOPUP_TITLE());
    private final SelenideElement mSectionPopupCount = $(mLocators.getPOPUP_COUNT());
    private final SelenideElement mSectionPopupApplyBtn = $(mLocators.getPOPUP_APPLY());
    private final ElementsCollection mPopupSlider = $$(mLocators.getPOPUP_SLIDER());
    private final SelenideElement mPopupSliderValue = $(mLocators.getPOPUP_SLIDER_VALUE());
    private final SelenideElement mPopupSliderBtn = $(mLocators.getPOPUP_SLIDER_BTN());
    private ElementsCollection mSectionPlusButtons;
    private ElementsCollection mSectionMinusButtons;
    private ElementsCollection mSectionCounters;

    private final String title;
    private final String subtitle;
    private final List<String> mSectionsTitlesText;
    private final List<String> budget;
    private final List<String> type;
    private final Country country;

    public MobileCostCalc(List<List<String>> data, Country country){
        title = data.get(0).get(0);
        subtitle = data.get(0).get(1);
        mSectionsTitlesText = data.get(3);
        budget = data.get(4);
        type = data.get(5);
        this.country = country;
    }

    public void checkMobileCalc(){
        closeIframe();
        checkBtnIsUnactive(mCalculateBtn);
        checkMobileTitle(title, subtitle);
        for (int index=0; index<mSectionsTitlesText.size(); index++){
            checkMobileSection(index);
        }
        Assert.assertEquals(mSectionButtons.size(), type.size());
        checkMobilePriceButton(mCalculateBtn);
    }

    /*реализация*/

    @Step
    private void checkMobilePriceButton(SelenideElement btn){
        checkBtnIsActive(mCalculateBtn);
        for (int index=0; index<mSectionButtons.size(); index++){
            addOneTagFromSection(index);
        }

        MobilePricePopup popup = new MobilePricePopup(btn, country);
        popup.checkPopup();
    }

    @Step
    private void checkMobileTitle(String title, String subtitle){
        Assert.assertEquals(mTitle.getText(), title);
        Assert.assertEquals(mSubtitle.getText(), subtitle);
    }

    private void checkMobileSection(int index){
        findMobileSectionElements(index);
        switch (type.get(index)) {
            case radiobtns:
                checkMobileSectionWithRadiobuttons();
                break;
            case checkboxes:
                checkMobileSectionWithCheckboxes();
                break;
            case slider:
                checkMobileSectionWithSlider();
                break;
            case plusMinusCounter:
                checkMobileSectionWithPlusMinusCounter();
        }
    }

    private void findMobileSectionElements(int index){
        String mSection = mLocators.getBASE() + mLocators.getSECTION() + "["+Integer.toString(index+1)+"]";
        mSectionTitle = $(By.xpath(mSection));
        mSectionTitleAfterChoose = $(By.xpath(mSection + mLocators.getSECTION_TITLE()));
        mSectionCounter = $(By.xpath(mSection + mLocators.getSECTION_COUNT()));
        mSectionEditBtn = $(By.xpath(mSection + mLocators.getSECTION_EDIT()));
        mSectionList = $$(By.xpath(mSection + mLocators.getSECTION_LIST()));
        switch (type.get(index)) {
            case radiobtns:
                mSectionButtons = $$(By.xpath(mLocators.getPOPUP_BASE() + mLocators.getRADIO_BTNS()));
                break;
            case checkboxes:
                mSectionButtons = $$(By.xpath(mLocators.getPOPUP_BASE() + mLocators.getCHECKBOXES()));
                break;
            case slider:
                mSectionButtons = $$(By.xpath(mLocators.getPOPUP_BASE() + mLocators.getSLIDER_BTN()));
                break;
            case plusMinusCounter:
                mSectionButtons = $$(By.xpath(mLocators.getPOPUP_BASE() + mLocators.getSLIDER_BTN()));
                mSectionMinusButtons = $$(By.xpath(mLocators.getPOPUP_BASE() + mLocators.getMINUS()));
                mSectionPlusButtons = $$(By.xpath(mLocators.getPOPUP_BASE() + mLocators.getPLUS()));
                mSectionCounters = $$(By.xpath(mLocators.getPOPUP_BASE() + mLocators.getCOUNTER()));
                break;

        }
        checkMobileSectionTitle(mSection, index);
    }

    private void addOneTagFromSection(int index){
        String mSection = mLocators.getBASE()+ mLocators.getSECTION() + "["+Integer.toString(index+1)+"]";
        mSectionTitle = $(By.xpath(mSection));
        findMobileSectionElements(index);
        switch (type.get(index)) {
            case radiobtns:
                openPopup(mSectionTitle);
                mSectionButtons.get(0).click();
                break;
            case checkboxes:
                openPopup(mSectionTitle);
                mSectionButtons.get(0).click();
                break;
            case slider:
                openPopup(mSectionTitle);
                mPopupSliderBtn.dragAndDropTo(mPopupSlider.get(0));
                break;
            case plusMinusCounter:
                openPopup(mSectionTitle);
                mSectionButtons.get(0).click();
                break;
        }
    }

    private void checkMobileSectionTitle(String section, int index){
        Assert.assertEquals($(By.xpath(section)).getText(), mSectionsTitlesText.get(index));
    }

    private void checkMobileSectionWithCheckboxes(){
        String title = mSectionTitle.getText();
        Assert.assertFalse(mSectionTitleAfterChoose.isDisplayed());
        Assert.assertFalse(mSectionCounter.isDisplayed());
        checkMobileSectionWithCheckboxesPopup(mSectionTitle, title);
    }

    private void checkMobileSectionWithRadiobuttons(){
        String title = mSectionTitle.getText();
        Assert.assertFalse(mSectionTitleAfterChoose.isDisplayed());
        Assert.assertFalse(mSectionCounter.isDisplayed());
        checkMobileSectionWithRadiobuttonsPopup(mSectionTitle, title);
    }

    private void checkMobileSectionWithSlider(){
        String title = mSectionTitle.getText();
        Assert.assertFalse(mSectionTitleAfterChoose.isDisplayed());
        Assert.assertFalse(mSectionCounter.isDisplayed());
        checkMobileSectionWithSliderPopup(mSectionTitle, title);
    }

    private void checkMobileSectionWithPlusMinusCounter(){
        String title = mSectionTitle.getText();
        Assert.assertFalse(mSectionTitleAfterChoose.isDisplayed());
        Assert.assertFalse(mSectionCounter.isDisplayed());
        checkMobileSectionWithCounterPopup(mSectionTitle, title);
    }

    private void checkMobileSectionWithCheckboxesPopup(SelenideElement btn, String title){
        openPopup(btn);
        checkMobileCheckboxes();
        mSectionPopupApplyBtn.click();
        Assert.assertEquals(mSectionTitleAfterChoose.getText(), title);
        Assert.assertEquals(mSectionCounter.getText(), Integer.toString(mSectionList.size()));
        checkClearBtn();
    }

    private void checkMobileSectionWithRadiobuttonsPopup(SelenideElement btn, String title){
        openPopup(btn);
        checkMobileRadiobuttons();
        String expectedValue = mSectionButtons.last().getText();
        mSectionPopupApplyBtn.click();
        Assert.assertEquals(mSectionTitleAfterChoose.getText(), title);
        Assert.assertEquals(mSectionCounter.getText(), expectedValue);
        checkClearBtn();
    }

    private void checkMobileSectionWithSliderPopup(SelenideElement btn, String title){
        openPopup(btn);
        checkMobileSlider();
        mSectionPopupApplyBtn.click();
        Assert.assertEquals(mSectionCounter.getText(), budget.get(budget.size()-1)+" USD");
        Assert.assertEquals(mSectionList.get(0).getText(), budget.get(budget.size()-1)+" USD");
        checkMobileEdit(mSectionEditBtn, title);
        Assert.assertEquals(mSectionCounter.getText(), budget.get(budget.size()-1)+" USD");
        Assert.assertEquals(mSectionList.get(0).getText(), budget.get(budget.size()-1)+" USD");
        checkClearBtn();
    }

    private void checkMobileSectionWithCounterPopup(SelenideElement btn, String title){
        int maxCount = 5;
        openPopup(btn);
        checkMobileCounters(maxCount);
        mSectionPopupApplyBtn.click();
        Assert.assertEquals(mSectionTitleAfterChoose.getText(), title);
        Assert.assertEquals(mSectionCounter.getText(), Integer.toString(maxCount+1));
        checkMobileEdit(mSectionEditBtn, title);
        Assert.assertEquals(mSectionCounter.getText(), Integer.toString(maxCount+2));
        checkClearBtn();
    }

    private void openPopup(SelenideElement btn){
        btn.click();
        checkBtnIsUnactive(mSectionPopupApplyBtn);
        Assert.assertTrue(mSectionPopupTitle.isDisplayed());
    }

    private void checkBtnIsUnactive(SelenideElement btn){
        Assert.assertEquals(btn.getCssValue("background-color"), CSSProperties.Color.YELLOW.getCode());
        Assert.assertFalse(btn.isEnabled());
    }

    private void checkBtnIsActive(SelenideElement btn){
        Assert.assertEquals(btn.getCssValue("background-color"), CSSProperties.Color.YELLOW.getCode());
        Assert.assertTrue(btn.isEnabled());
    }

    private void checkMobileCheckboxes(){
        for (int index=0; index<mSectionButtons.size(); index++){
            Assert.assertEquals(mSectionPopupCount.getText(), Integer.toString(index));
            mSectionButtons.get(index).click();
            Assert.assertEquals(mSectionPopupCount.getText(), Integer.toString(index+1));
        }
        checkBtnIsActive(mSectionPopupApplyBtn);
    }

    private void checkMobileRadiobuttons(){
        Assert.assertFalse(mSectionPopupCount.isDisplayed());
        for (SelenideElement radiobtn: mSectionButtons){
            radiobtn.click();
            Assert.assertEquals(mSectionPopupCount.getText() ,radiobtn.getText());
        }
        checkBtnIsActive(mSectionPopupApplyBtn);
    }

    private void checkMobileSlider(){
        mPopupSliderBtn.dragAndDropTo(mPopupSlider.get(0));
        for(int index = 1;index<mPopupSlider.size()-1; index++){
            mPopupSliderBtn.dragAndDropTo(mPopupSlider.get(index));
            Assert.assertEquals(mPopupSliderValue.getText(), budget.get(index-1)+" USD");
        }
        checkBtnIsActive(mSectionPopupApplyBtn);
    }

    private void checkMobileCounters(int maxCount){
        for (int index=0; index<mSectionButtons.size(); index++){
            Assert.assertEquals(mSectionPopupCount.getText(), Integer.toString(index));
            mSectionButtons.get(index).click();
        }
        Assert.assertEquals(mSectionPopupCount.getText(), Integer.toString(mSectionCounters.size()));
        for (SelenideElement minus: mSectionMinusButtons){
            minus.click();
        }
        Assert.assertEquals(mSectionPopupCount.getText(), "0");
        mSectionButtons.get(1).click();
        for (int count=0; count<maxCount; count++){
            mSectionPlusButtons.get(0).click();
        }
        Assert.assertEquals(mSectionPopupCount.getText(), Integer.toString(maxCount+1));
    }

    private void checkClearBtn(){
        mClearBtn.click();
        Assert.assertFalse(mSectionTitleAfterChoose.isDisplayed());
        Assert.assertFalse(mSectionCounter.isDisplayed());
    }

    private void checkMobileEdit(SelenideElement btn, String title){
        btn.click();
        Assert.assertTrue(mSectionPopupTitle.isDisplayed());
        Assert.assertEquals(mSectionPopupTitle.getText(), title);
        mSectionButtons.get(0).click();
        mSectionPopupApplyBtn.click();
    }

    private void closeIframe(){
        $("iframe.intercom-7x8nh1").click();
        switchTo().frame("intercom-messenger-frame");
        $$(By.xpath("//div[contains(@role,'button')]")).get(1).click();
        $$(By.xpath("//div[contains(@role,'button')]")).get(0).click();
        switchTo().parentFrame();
    }
}

class CostCalcMobileLocators{
    @Getter
    private final String BASE = "//div[@class='mobile-calculator-module--send--cnszA']/button/../..";
    @Getter private final String SECTION = "//button[contains(@class, 'section-module--tab')]";
    @Getter private final String SECTION_TITLE = "/span[contains(@class, 'Title')]";
    @Getter private final String SECTION_COUNT = "/span[contains(@class, 'count')]";
    @Getter private final String POPUP_BASE = "//section[@class='modal-module--popup--1hVvE']";
    @Getter private final String CHECKBOXES = "//label";
    @Getter private final String RADIO_BTNS = "//label";
    @Getter private final String SLIDER_BTN = "//div[@class='rc-slider-handle']";
    @Getter private final String SECTION_EDIT = "/following-sibling::div[1]//button";
    @Getter private final String SECTION_LIST = "/following-sibling::div[1]//ul//span";
    @Getter private final String ELEMENT = "//label";
    @Getter private final String PLUS = "//button[contains(@class,'plus')]";
    @Getter private final String MINUS = "//button[contains(@class,'minus')]";
    @Getter private final String COUNTER = "//input[@type='number']";
    private final String SLIDER = "//span[contains(@class, 'rc-slider-dot')]";
    private final String SLIDER_STEP = "//div[contains(@class, 'rc-slider-dot')]";
    private final String SLIDER_TRACK = "//div[@class='rc-slider-track']";

    @Getter private final By TITLE = By.xpath(BASE + "/h2");
    @Getter private final By SUBTITLE = By.xpath(BASE + "/p");
    @Getter private final By CLEAR_BTN = By.xpath(BASE + "/header/button");
    @Getter private final By CALCULATE_BTN = By.xpath(BASE + "//div[@class='mobile-calculator-module--send--cnszA']/button");

    @Getter private final By POPUP_CLOSE = By.xpath(POPUP_BASE + "//button[contains(@class, 'close')]");
    @Getter private final By POPUP_APPLY = By.xpath(POPUP_BASE + "//div[contains(@class, 'apply')]/button");
    @Getter private final By POPUP_TITLE = By.xpath(POPUP_BASE + "//h3/span[contains(@class, 'title')]");
    @Getter private final By POPUP_COUNT = By.xpath(POPUP_BASE + "//h3/span[contains(@class, 'count')]");
    @Getter private final By POPUP_SLIDER = By.xpath(POPUP_BASE + SLIDER);
    @Getter private final By POPUP_SLIDER_BTN = By.xpath(POPUP_BASE + SLIDER_BTN);
    @Getter private final By POPUP_SLIDER_TRACK = By.xpath(POPUP_BASE + SLIDER_TRACK);
    @Getter private final By POPUP_SLIDER_STEP = By.xpath(POPUP_BASE + SLIDER_STEP);
    @Getter private final By POPUP_SLIDER_VALUE = By.xpath(POPUP_BASE + "//h2");
}
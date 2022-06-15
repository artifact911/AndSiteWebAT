package com.andersenlab.autotests.site.page.industries.videoandentertainment.blocks.costcalc;

import com.andersenlab.autotests.core.configs.constants.CSSProperties.Color;
import com.andersenlab.autotests.core.configs.constants.Country;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.andersenlab.autotests.core.configs.constants.CostCalcData.checkboxes;
import static com.andersenlab.autotests.core.configs.constants.CostCalcData.plusMinusCounter;
import static com.andersenlab.autotests.core.configs.constants.CostCalcData.radiobtns;
import static com.andersenlab.autotests.core.configs.constants.CostCalcData.slider;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DesktopCostCalc {
    private final CostCalcDesktopLocators dLocators = new CostCalcDesktopLocators();
    private final ElementsCollection popupButtons = $$(By.xpath("//button[@class='tag-module--filterTag--1mtyv']"));

    private final SelenideElement dTitle = $(By.xpath(dLocators.getBASE()+dLocators.getTITLE()));
    private final SelenideElement dSubtitle = $(By.xpath(dLocators.getBASE()+dLocators.getSUBTITLE()));
    private final SelenideElement dPriceBtn = $(By.xpath(dLocators.getBASE() + dLocators.getBTN_PRICE()));
    private SelenideElement dSectionTitle;
    private SelenideElement dSectionSubtitle;
    private ElementsCollection dSectionButtons;
    private ElementsCollection dSectionPlusButtons;
    private ElementsCollection dSectionMinusButtons;
    private ElementsCollection dSectionCounters;
    private SelenideElement dClearButton;


    private final String title;
    private final String subtitle;
    private final String dPriceBtnText;
    private final List<String> dSectionsTitles;
    private final List<String> dSectionsSubtitles;
    private final List<String> budget;
    private final List<String> type;
    private final Country country;

    public DesktopCostCalc(List<List<String>> data, Country country){
        title = data.get(0).get(0);
        subtitle = data.get(0).get(1);
        dPriceBtnText = data.get(0).get(2);
        dSectionsTitles = data.get(1);
        dSectionsSubtitles = data.get(2);
        budget = data.get(4);
        type = data.get(5);
        this.country = country;
    }

    public void checkDesktopCalc(){
        checkDesktopTitle(title, subtitle);
        for (int index=0; index<dSectionsTitles.size(); index++){
            checkDesktopSection(index);
        }
        checkDesktopButtonPrice(dPriceBtn);
    }

    /*реализация*/

    @Step
    private void checkDesktopTitle(String title, String subtitle){
        Assert.assertEquals(dTitle.getText(), title);
        Assert.assertEquals(dSubtitle.getText(), subtitle);
    }

    @Step
    private void checkDesktopSection(int index){
        findDesktopSectionElements(index);
        checkDesktopSectionTitleAndSubtitle(index);
        switch (type.get(index)) {
            case radiobtns:
                checkDesktopSectionWithRadiobuttons(dSectionButtons);
                break;
            case checkboxes:
                checkDesktopSectionWithCheckboxes(dSectionButtons);
                break;
            case slider:
                checkDesktopSectionWithSlider(dSectionButtons);
                break;
            case plusMinusCounter:
                checkDesktopSectionWithPlusMinusCounter(dSectionButtons, dSectionPlusButtons, dSectionMinusButtons, dSectionCounters);
                break;
        }
    }

    private void checkDesktopSectionTitleAndSubtitle(int index){
        dSectionTitle.scrollTo();
        Assert.assertEquals(dSectionTitle.getText(), dSectionsTitles.get(index));
        Assert.assertEquals(dSectionSubtitle.getText(), dSectionsSubtitles.get(index));
    }

    private void findDesktopSectionElements(int index){
        String dSection = dLocators.getBASE()+ dLocators.getSECTION() + "["+Integer.toString(index+1)+"]";
        dSectionTitle = $(By.xpath(dSection + dLocators.getSECTION_TITLE()));
        dSectionSubtitle = $(By.xpath(dSection + dLocators.getSUBTITLE()));
        dClearButton = $(By.xpath(dSection + dLocators.getBTN_CLR()));

        switch (type.get(index)) {
            case radiobtns:
                dSectionButtons = $$(By.xpath(dSection + dLocators.getRADIO_BTNS()));
                break;
            case checkboxes:
                dSectionButtons = $$(By.xpath(dSection + dLocators.getCHECKBOXES()));
                break;
            case slider:
                dSectionButtons = $$(By.xpath(dSection + dLocators.getSLIDER_BTN()));
                break;
            case plusMinusCounter:
                dSectionButtons = $$(By.xpath(dSection + dLocators.getELEMENT()));
                dSectionMinusButtons = $$(By.xpath(dSection + dLocators.getBTN_MINUS()));
                dSectionPlusButtons = $$(By.xpath(dSection + dLocators.getBTN_PLUS()));
                dSectionCounters = $$(By.xpath(dSection + dLocators.getCOUNTER()));
                break;
        }
    }

    private void checkDesktopSectionWithRadiobuttons(ElementsCollection buttons){
        for (SelenideElement radiobutton: buttons){
            radiobutton.click();
            Assert.assertTrue(popupButtons.get(0).isDisplayed());
            Assert.assertEquals(popupButtons.get(0).getText(), radiobutton.getText());
            Assert.assertEquals(popupButtons.size(), 1);
            popupButtons.get(0).click();
            Assert.assertFalse(popupButtons.get(0).isDisplayed());
        }
    }

    @Step
    private void checkDesktopButtonPrice(SelenideElement btn){
        for (int index=0; index<dSectionsTitles.size(); index++){
            addOneTagFromSection(index);
        }
        List<String> tags = new ArrayList<String>(popupButtons.size());

        for(SelenideElement tag: popupButtons){
            tags.add(tag.getText());
        }
        DesktopPricePopup popup = new DesktopPricePopup(tags, btn, country);
        popup.checkPopup();
    }

    private void addOneTagFromSection(int index){
        String dSection = dLocators.getBASE()+ dLocators.getSECTION() + "["+Integer.toString(index+1)+"]";
        $(By.xpath(dSection + dLocators.getSECTION_TITLE())).scrollTo();
        findDesktopSectionElements(index);
        switch (type.get(index)) {
            case radiobtns:
                addOneTagFromSectionWithRadiobuttons();
                break;
            case checkboxes:
                addOneTagFromSectionWithCheckboxes();
                break;
            case slider:
                addOneTagFromSectionWithSlider();
                break;
            case plusMinusCounter:
                addOneTagFromSectionWithCounter();
                break;
        }
    }

    private void addOneTagFromSectionWithRadiobuttons(){
        dSectionButtons.get(0).click();
    }

    private void addOneTagFromSectionWithCheckboxes(){
        dSectionButtons.get(0).click();
    }

    private void addOneTagFromSectionWithSlider(){
        dSectionButtons.get(0).click();
    }

    private void addOneTagFromSectionWithCounter(){
        dSectionPlusButtons.get(0).click();
    }

    private void checkDesktopSectionWithCheckboxes(ElementsCollection checkboxes){
        for (SelenideElement checkBox: checkboxes){
            checkBox.click();
            Assert.assertTrue(popupButtons.get(0).isDisplayed());
            Assert.assertEquals(popupButtons.get(0).getText(), checkBox.getText());
            checkBox.click();
            Assert.assertFalse(popupButtons.get(0).isDisplayed());
        }
        for (SelenideElement checkBox: checkboxes){
            checkBox.click();
        }
        Assert.assertEquals(popupButtons.size(), checkboxes.size());
        dClearButton.click();
        Assert.assertFalse(popupButtons.get(0).isDisplayed());
    }

    private void checkDesktopSectionWithSlider(ElementsCollection buttons){
        for(int index=0; index<buttons.size(); index++)
        {
            Assert.assertEquals(buttons.get(index).getText(), budget.get(index));
            Assert.assertEquals(buttons.get(index).getCssValue("cursor"), "pointer");
        }
    }

    private void checkDesktopSectionWithPlusMinusCounter(ElementsCollection elements, ElementsCollection plus, ElementsCollection minus, ElementsCollection counter){
        int maxCount = 5;
        Assert.assertEquals(plus.size(), elements.size());
        Assert.assertEquals(minus.size(), elements.size());
        Assert.assertEquals(counter.size(), elements.size());
        for(int index = 0; index<counter.size(); index++){
            checkElement(elements.get(index), plus.get(index), minus.get(index), counter.get(index), maxCount);
        }
    }


    private void checkBtnIsUnactive(SelenideElement btn){
        Assert.assertEquals(btn.getCssValue("background-color"), Color.YELLOW.getCode());
        Assert.assertFalse(btn.isEnabled());
    }

    private void checkBtnIsActive(SelenideElement btn){
        Assert.assertEquals(btn.getCssValue("background-color"), Color.YELLOW.getCode());
        Assert.assertTrue(btn.isEnabled());
    }

    private void checkElement(SelenideElement element, SelenideElement plus, SelenideElement minus, SelenideElement counter, int maxCount){
        Assert.assertFalse(minus.getCssValue("class").contains("active"));
        Assert.assertEquals(counter.getText(), "0");
        for (int count=1; count<=maxCount; count++){
            plus.click();
            Assert.assertEquals(counter.getText(), Integer.toString(count));
            checkButtonCounter(element, count);
        }
        for (int count=maxCount; count>0; count--){
            Assert.assertTrue(minus.getCssValue("class").contains("active"));
            Assert.assertEquals(counter.getText(), Integer.toString(count));
            checkButtonCounter(element, count);
            minus.click();
        }
        Assert.assertFalse(popupButtons.get(0).isDisplayed());
    }

    private void checkButtonCounter(SelenideElement element, int count){
        String btn = element.getText() + " - " + Integer.toString(count) + " specialist";
        if (count>1){
            btn += "s";
        }
        Assert.assertEquals(popupButtons.get(0).getText(), btn);
    }


    //todo добавить проверку формы обратной связи (по кнопке Get Price/Calculate)
}

class CostCalcDesktopLocators {
    @Getter private final String BASE = "//button[contains(text(),'Calculate') or contains(text(),'Get price')]/../..";
    @Getter private final String RADIO_BTNS = "//div[contains(@class, 'radioButton-module--radiobutton')]/label";
    @Getter private final String CHECKBOXES = "//div[contains(@class, 'checkbox-module--checkbox')]/label";
    @Getter private final String BTN_CLR = "//button[@class='link-underline']";
    @Getter private final String BTN_PLUS = "//button[contains(@class, 'plus')]";
    @Getter private final String BTN_MINUS = "//button[contains(@class, 'minus')]";
    @Getter private final String COUNTER = "//input[@type='number']";
    @Getter private final String ELEMENT = COUNTER + "/../preceding-sibling::h4[1]";
    @Getter private final String BTN_PRICE = "//button[contains(text(), 'Get price')]";
    @Getter private final String SLIDER = "//span[contains(@class, 'rc-slider-dot')]";
    @Getter private final String SLIDER_BTN = "//span[contains(@class, 'rc-slider-mark-text')]";
    @Getter private final String SECTION = "//section";
    @Getter private final String TITLE = "//p[contains(@class, 'title')]";
    @Getter private final String SECTION_TITLE = "//p[contains(@class, 'title')]";
    @Getter private final String SUBTITLE = "//p[contains(@class, 'subtitle')]";
}

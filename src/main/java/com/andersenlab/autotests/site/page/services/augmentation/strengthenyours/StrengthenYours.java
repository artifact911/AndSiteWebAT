package com.andersenlab.autotests.site.page.services.augmentation.strengthenyours;

import com.andersenlab.autotests.site.page.services.augmentation.modal.requestspqcialist.RequestSpecialistModal;
import com.andersenlab.autotests.site.utility.Warp;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class StrengthenYours implements StrengthenYoursLocators {

    private final SelenideElement nameBlock = $(STRENGTHEN_H2);
    private final String expectBlockName = "Strengthen your software team with proven IT experts";
    private final SelenideElement requestSpecialistBtn = $(REQUEST_SPECIALIST_BUTTON);
    private final SelenideElement bulletName1 = $(BULLET_1_NAME);
    private final SelenideElement bulletName2 = $(BULLET_2_NAME);
    private final SelenideElement bulletName3 = $(BULLET_3_NAME);

    private final RequestSpecialistModal modal = new RequestSpecialistModal();

    @Step
    public void isPresentStartElements() {
        Warp.scrollToElement(nameBlock);
        Assert.assertTrue(Warp.isElementPresent(STRENGTHEN_H2));
        Assert.assertEquals(nameBlock.text(), expectBlockName);
        Assert.assertTrue(requestSpecialistBtn.isDisplayed());
    }

    @Step
    public void checkBulletsBox() {
        final BulletsStaff[] values = BulletsStaff.values();
        List<SelenideElement> nameList = new ArrayList<>(Arrays.asList(bulletName1, bulletName2, bulletName3));
        List<String> descriptionList = prepareDescription();
        for (int i = 0; i < nameList.size(); i++) {
            Assert.assertEquals(nameList.get(i).getText(), values[i].getNameOf());
            Assert.assertEquals(descriptionList.get(i), values[i].getText());
        }
    }

    private List<String> prepareDescription() {
        List<String> list = new ArrayList<>();
        list.add(CHOOSE_TEXT_1.getText() + "\n" + CHOOSE_TEXT_2.getText() + " " + CHOOSE_TEXT_3.getText());
        list.add(START_TEXT_1.getText() + "\n" + START_TEXT_2.getText() + " " + START_TEXT_3.getText());
        list.add(RISK_TEXT_1.getText() + "\n" + RISK_TEXT_2.getText() + " " + RISK_TEXT_3.getText());
        return list;
    }
}

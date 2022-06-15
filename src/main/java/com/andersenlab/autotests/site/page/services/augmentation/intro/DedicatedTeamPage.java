package com.andersenlab.autotests.site.page.services.augmentation.intro;

import com.andersenlab.autotests.site.page.services.augmentation.TitleAndDescriptionMeta;
import com.andersenlab.autotests.site.utility.Warp;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class DedicatedTeamPage {

    private final SelenideElement metaTitle = $(By.xpath("//meta[@name='description']"));

    @Step
    public void checkMetaTitle(TitleAndDescriptionMeta value) {
        Assert.assertEquals(Warp.tabTitle().trim(), value.getTitle().trim());
    }

    @Step
    public void checkMetaDescription(TitleAndDescriptionMeta value) {
        Assert.assertEquals(metaTitle.getAttribute("content").trim(), value.getDescription().trim());
    }
}

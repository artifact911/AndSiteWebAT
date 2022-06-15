package com.andersenlab.autotests.site.page.company.greetings;

import com.andersenlab.autotests.site.utility.Warp;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.Wait;
import static com.codeborne.selenide.Selenide.switchTo;

public class GreetingsOperations {
    GreetingsBlock block = new GreetingsBlock();

    @Step
    public void checkVideoPopup(){
        Assert.assertFalse(block.getVideoPopup().isDisplayed());
        block.getVideoPreview().click();
        Wait().until(ExpectedConditions.visibilityOfElementLocated(GreetingsLocators.VIDEO_POPUP));
        Assert.assertTrue(block.getVideoPopup().isDisplayed());
        block.getVideoCloseBtn().click();
        Wait().until(ExpectedConditions.invisibilityOfElementLocated(GreetingsLocators.VIDEO_CLOSE_BTN));
        Assert.assertFalse(block.getVideoPopup().isDisplayed());
    }

    @Step
    public void checkGreetingBlock(String title, String name, String linkedin, String position, String message){
        Assert.assertEquals(block.getTitle().getText(), title);
        Assert.assertEquals(block.getName().getText(), name);
        Warp.checkLinkNewTab(block.getName(), linkedin);
        Assert.assertTrue(block.getLinkedin().isDisplayed());
        Assert.assertEquals(block.getPosition().getText(), position);
        Assert.assertEquals(block.getGreetingMessage().getText(), message);
        Wait().until(ExpectedConditions.visibilityOfElementLocated(GreetingsLocators.VIDEO_PREVIEW));
        Assert.assertTrue(block.getVideoPreview().isDisplayed());
    }

    @Step
    public void checkForbesLink(String link){
        checkLinkNewTab(block.getForbesLink(), link);
    }

    public void checkLinkNewTab(SelenideElement element, String link){
        Assert.assertEquals(element.getCssValue("cursor"), "pointer");
        element.click();
        switchTo().window(1);
        Assert.assertEquals(Warp.currentURL(), link);
        switchTo().window(1).close();
        switchTo().window(0);
    }
}
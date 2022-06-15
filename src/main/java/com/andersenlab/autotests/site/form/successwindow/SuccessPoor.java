package com.andersenlab.autotests.site.form.successwindow;

import com.andersenlab.autotests.core.steps.Assertions;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.NoArgsConstructor;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;

@NoArgsConstructor
public class SuccessPoor implements Success {
    private final String BASE_SUCCESS = "//div[contains(@class, 'modal-module--container')]";
    private final By WINDOW_SUCCESS = By.xpath(BASE_SUCCESS);
    private final By BUTTON_CLOSE = By.xpath(BASE_SUCCESS + "//button[contains(@class, 'close')]");
    private final By TITLE = By.xpath(BASE_SUCCESS + "//p");

    private SelenideElement ButtonClose = $(BUTTON_CLOSE);
    private SelenideElement Title = $(TITLE);

    @Override
    @Step
    public void checkAndClose() {
        Assert.assertEquals(Title.getAttribute("innerText").trim().replace("\n\r", ""), TEXT_TITLE_SUCCESS_ASAP);
        Assertions.elementShouldBeVisible(WINDOW_SUCCESS);
        ButtonClose.click();
        Assertions.elementShouldNotBeVisible(WINDOW_SUCCESS);
    }
}

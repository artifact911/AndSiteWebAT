package com.andersenlab.autotests.site.form.successwindow;

import com.andersenlab.autotests.core.steps.Assertions;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.NoArgsConstructor;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;

@NoArgsConstructor
public class SuccesCase implements Success{
    private final String BASE_SUCCESS = "//section[contains(@class, 'modal-module--send--3UEvb')]";
    private final By WINDOW_SUCCESS = By.xpath(BASE_SUCCESS);
    private final By BUTTON_CLOSE = By.xpath(BASE_SUCCESS + "//button[contains(@class, 'close')]");
    private final By TITLE = By.xpath(BASE_SUCCESS + "//p");

    private SelenideElement ButtonClose = $(BUTTON_CLOSE);
    private SelenideElement Title = $(TITLE);

    @Override
    @Step
    public void checkAndClose() {
        Assert.assertEquals(Title.getAttribute("innerText").replace("\n", ""), TEXT_TITLE_SUCCESS_ASAP);
        Assertions.elementShouldBeVisible(WINDOW_SUCCESS);
        ButtonClose.click();
        Assertions.elementShouldNotBeVisible(WINDOW_SUCCESS);
    }
}

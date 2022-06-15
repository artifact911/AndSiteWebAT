package com.andersenlab.autotests.site.form.successwindow;

import com.andersenlab.autotests.core.configs.constants.Country;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import static com.codeborne.selenide.Selenide.$;

public class SuccessRich implements Success {
    Country country;
    private final String BASE_SUCCESS = "//section[contains(@class, 'modal-module--popup')]";
    private final By BUTTON_CLOSE = By.xpath(BASE_SUCCESS + "//button[contains(@class, 'close')]");
    private final By TITLE = By.xpath(BASE_SUCCESS + "//p");

    private final By WINDOW_SUCCESS_CARD1 = By.xpath(BASE_SUCCESS + "//a[contains(@href, 'mercedes')]");
    private final By WINDOW_SUCCESS_CARD2 = By.xpath(BASE_SUCCESS + "//a[contains(@href, 'interactive')]");
    private final By WINDOW_SUCCESS_CARD3 = By.xpath(BASE_SUCCESS + "//a[contains(@href, 'mediamarkt')]");

    private final SelenideElement ButtonClose = $(BUTTON_CLOSE);
    private final SelenideElement WindowSuccessCard1 = $(WINDOW_SUCCESS_CARD1);
    private final SelenideElement WindowSuccessCard2 = $(WINDOW_SUCCESS_CARD2);
    private final SelenideElement WindowSuccessCard3 = $(WINDOW_SUCCESS_CARD3);
    private final SelenideElement Title = $(TITLE);

    public SuccessRich(Country country) {
        this.country = country;
    }

    @Override
    @Step
    public void checkAndClose() {
        Assert.assertEquals(Title.getText().replace("\n", ""), textTitle());
        ButtonClose.click();
        Assert.assertFalse(Title.isDisplayed());
    }

    private String textTitle(){
        String timeZone = null;
        switch (country) {
            case US:
                timeZone = "GMT-5";
                break;
            case UA:
            case BY:
            case RU:
            case FR:
            case DE:
                timeZone = "GMT+3";
                break;
        }
        final SimpleDateFormat sdfH = new SimpleDateFormat("HH");
        sdfH.setTimeZone(TimeZone.getTimeZone(timeZone));
        int HH = Integer.parseInt(sdfH.format(new Date()));
        //return (HH >= 9 & HH < 18) ? TEXT_TITLE_SUCCESS_15 : TEXT_TITLE_SUCCESS_ASAP; FIXME раскомментить, как поправят
        return TEXT_TITLE_SUCCESS_ASAP;
    }

}

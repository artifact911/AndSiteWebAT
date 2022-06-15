package com.andersenlab.autotests.site.form.successwindow;

import com.andersenlab.autotests.core.configs.constants.Country;
import com.andersenlab.autotests.core.utils.PropertiesReader;
import com.andersenlab.autotests.site.utility.Warp;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WrapsDriver;
import org.testng.Assert;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SuccessRich2 implements Success {
    //https://andersenlab.com/services/custom-software-development calc
    Country country;
    private final String BASE_SUCCESS = "//div[@id='popup-success-cases' and @style='display: block;']";
    private final String BUTTON_CLOSE = BASE_SUCCESS + "//div[contains(@class, 'close')]";
    private final String TITLE = BASE_SUCCESS + "//h3";
    private final String SUBTITLE = BASE_SUCCESS + "//h4";

    private final String ARTS_VISIBLE = BASE_SUCCESS + "//article[contains(@class, 'resume') and contains(@aria-hidden, 'false')]";
    private final String BUTTONS_PORTFOLIO_VISIBLE = ARTS_VISIBLE + "//a[contains(text(), 'Portfolio')]";
    private final String BUTTONS_SLICK = BASE_SUCCESS + "//ul[@class='slick-dots']//li";
    private final String ACTIVE_BUTTON_SLICK = BASE_SUCCESS + "//ul[@class='slick-dots']//li[contains(@class, 'slick-active')]";
    private final String BUTTON_DOWNLOAD = BASE_SUCCESS + "//button[contains(text(), 'Download all')]";


    private final SelenideElement buttonClose = $(By.xpath(BUTTON_CLOSE));
    private final SelenideElement buttonDownload = $(By.xpath(BUTTON_DOWNLOAD));
    private final SelenideElement title = $(By.xpath(TITLE));
    private final SelenideElement subtitle = $(By.xpath(SUBTITLE));
    private final ElementsCollection artsVisible = $$(By.xpath(ARTS_VISIBLE));
    private final ElementsCollection portfolioVisible = $$(By.xpath(BUTTONS_PORTFOLIO_VISIBLE));
    private final ElementsCollection buttonsSlick = $$(By.xpath(BUTTONS_SLICK));

    public SuccessRich2(Country country) {
        this.country = country;
    }

    @Override
    @Step
    public void checkAndClose() {
        //видимость и текст заголовка и подзаголовка
        Warp.ElementVisible(TITLE);
        Warp.ElementVisible(SUBTITLE);
        Assert.assertEquals(title.getAttribute("innerText").trim(), textTitle()); //FIXME раскомментить, как поправят заголовки
        Assert.assertEquals(subtitle.getAttribute("innerText").trim(), "Take a look at our case studies that might be similar to your future project");
        //проверка листания драг-и-дропом
        buttonsSlick.first().click();
        String href = portfolioVisible.first().getAttribute("href");
        Warp.delay(1);//ожидание прокрутки
        Warp.slide(artsVisible.first(), artsVisible.last());
        Warp.delay(1);//ожидание прокрутки
        Assert.assertNotEquals(href, portfolioVisible.first().getAttribute("href"));
        //проверка кнопками внизу
        buttonsSlick.first().click();
        Assert.assertEquals(href, portfolioVisible.first().getAttribute("href"));
        //работает только локально потому что выбрать папку для загрузки пока не удается
        if(PropertiesReader.get("local.launch").equals("true")) {
            //проверка кнопки загрузить все
            buttonDownload.click();
            Warp.delay(2);//ожидание загрузки, без него не успевает
            Assert.assertTrue(Warp.isFileDownloaded("C:\\Users\\Mike\\Downloads", "Andersen Project Example.zip"));
//        System.out.println("file downloaded: " + Warp.isFileDownloaded("C:\\Users\\Mike\\Downloads", "Andersen Project Example.zip"));
        }
        //проверка закрытия
        buttonClose.click();
        Assert.assertFalse(title.isDisplayed());
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
        return (HH >= 9 & HH < 18) ? TEXT_TITLE_SUCCESS_15 : TEXT_TITLE_SUCCESS_ASAP;
    }

}


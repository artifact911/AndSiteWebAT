package com.andersenlab.autotests.site.page.services.customsoftware.blocks.customerreviews;

import com.andersenlab.autotests.site.utility.Warp;
import com.codeborne.selenide.*;
import io.qameta.allure.Step;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.*;

public class CustomerReviews implements CustomerReviewsLocators {
    private final CustomerReviewsData data;
    private final SelenideElement title = $(TITLE);
    private final SelenideElement subtitle = $(DESCRIPTION);
    private final SelenideElement reviewerName = $(REVIEWER_NAME);
    private final SelenideElement reviewerPosition = $(REVIEWER_POSITION);
    private final SelenideElement review = $(REVIEW);
    private final SelenideElement clutch = $(CLUTCH);
    private final SelenideElement buttonPrev = $(BUTTON_PREV);
    private final SelenideElement buttonNext = $(BUTTON_NEXT);
    //private ElementsCollection ButtonsDirect = $$(BUTTONS_DIRECT);
    private final ElementsCollection buttonsSlick = $$(BUTTONS_SLICK);
    private final SelenideElement activeButtonSlick = $(ACTIVE_BUTTON_SLICK);
    private final SelenideElement linkMoreReferences = $(LINK_MORE_REFS);
    private final SelenideElement linkProjectDescription = $(LINK_PROJECT_DESCRIPTION);
    //for drag&drop
    private final SelenideElement teamSize = $(TEAM_SIZE);
    private final SelenideElement projectSummary = $(PROJECT_SUMMARY);

    public CustomerReviews(CustomerReviewsData data) {
        this.data = data;
    }

    /**
     * Отображение блока и функционал блока 'Customer reviews'
     */

    @Step
    public void displayingElements() {
        //обновление и скроллинг вниз блока
        Selenide.refresh();
        Wait().until(ExpectedConditions.visibilityOf(linkMoreReferences));
        Warp.scrollToElement(linkMoreReferences);
        //проверка заголовка и описания
        Assert.assertEquals(title.getAttribute("innerText"), data.textTitle());
        Assert.assertEquals(subtitle.getAttribute("innerText"), data.textSubtitle());
        //ссылка на больше проектов
        Warp.checkLinkThisTab(linkMoreReferences, data.TEXT_MORE_REFS_REF);
        int artsQ = data.getArtsQuantity();
        checkArticles(artsQ);
        checkInterviewer(artsQ);
    }

    @Step
    public void checkArticles(int artsQ){
        for (int i = 0; i < artsQ; i++) {
            String[] art = data.getTEXT_ARTICLES()[i];
            if (!art[0].equals("")) Assert.assertEquals(reviewerName.getAttribute("innerText"), art[0]);
            Assert.assertEquals(reviewerPosition.getAttribute("innerText"), art[1]);
            if (!art[2].equals("")) Assert.assertEquals(clutch.getAttribute("href"), art[2]);
            Assert.assertEquals(review.getAttribute("innerText"), art[3]);
            if (!art[4].equals("")) Assert.assertEquals(linkProjectDescription.getAttribute("href"), art[4]);
            //клик следующую и ждем 1 сек на слайд
            if(artsQ>1) {
                Warp.clickUntouchable(buttonNext, 1, 1);
                Warp.delay(1);
            }
        }
    }

    @Step
    public void checkSlickButton(){
        if (data.getButtonSlick()) {
            String name = reviewerName.getAttribute("innerText");//запомнили имя
            Assert.assertEquals(reviewerName.getAttribute("innerText"), name);
        }
    }

    /** После цикла открыта последняя статья. запоминаем имя ревьюера и тянем справа налево. имя ревьюера = первому
    нажимаем кнопку пред. и имя снова равно запомненому*/
    @Step
    public void checkInterviewer(int artsQ){
        if (artsQ>1) {
            String name = reviewerName.getAttribute("innerText");//запомнили автора последнего отзыва
            Warp.slide(teamSize, projectSummary);//слайд вперед
            Warp.delay(1);
            Assert.assertNotEquals(reviewerName.getAttribute("innerText"), name);
            Warp.clickUntouchable(buttonPrev, 1, 1);//кнопка назад
            Assert.assertEquals(reviewerName.getAttribute("innerText"), name);
            //проверить слик-кноки, если есть
            checkSlickButton();
        }
    }
}

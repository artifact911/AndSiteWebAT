package com.andersenlab.autotests.site.page.services.mobiledevelopment.blocks.technologycarousel;

import com.andersenlab.autotests.site.utility.Warp;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

@Getter
public class TechnologyCarousel implements TechnologyCarouselLocators {
    private TechnologyCarouselElements el = new TechnologyCarouselElements();

    @Step
    public void displayingElementsAndFunction(boolean isSlider) {
        //slider
        if(isSlider){
            Warp.scrollToElement(NEXT_SECTION);
            Actions drag = new Actions(WebDriverRunner.getWebDriver());
            //drag&drop
            String[] firstTechs = getVisible();
            drag.dragAndDrop(el.getTechItems().first(), el.getTechItems().last().should(Condition.appear)).build().perform();
            String[] secondTechs = getVisible();
            drag.dragAndDrop(el.getTechItems().last(), el.getTechItems().first().should(Condition.appear)).build().perform();
            String[] thirdTechs = getVisible();
            Assert.assertNotEquals(firstTechs, secondTechs);
            Assert.assertEquals(firstTechs, thirdTechs);
            //arrows
            el.getArrowPrev().click();
            Assert.assertEquals(secondTechs, getVisible());
            el.getArrowNext().click();
            Assert.assertEquals(thirdTechs, getVisible());
            Selenide.refresh();
            System.out.println(el.getSliders().size());
            el.getSliders().get(1).click();
            Assert.assertNotEquals(firstTechs, getVisible());
        }
    }

    private String[] getVisible() {
        return Warp.titlesCollection(el.getTechItems());
    }
}

package com.andersenlab.autotests.site.page.services.customsoftware.blocks.projectmap;

import com.andersenlab.autotests.core.configs.constants.CSSProperties.Color;
import com.andersenlab.autotests.core.steps.Assertions;
import com.andersenlab.autotests.site.utility.Warp;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.*;

@Getter
public class ProjectMap implements ProjectMapLocators {
    private ProjectMapElement el = new ProjectMapElement();

/**    i < 7 в циклах в 2х методах ниже, обусловлено тем, что это оптимальное число меток для проверки. */

    @Step
    public void checkMapWithoutFilters() {
        scrollToBlock();
        checkTitle();
        el.getMapMinusBtn().click();
        for (int i = 0; i < 7; i++){
            checkTooltip(el.getPoints().get(i));
            checkModal(el.getPoints().get(i));
        }
        el.getMapPlusBtn().click();
        checkMapBasicFunctions();
    }

    @Step
    public void checkMapWithFilters() {
        scrollToBlock();
        checkTitle();
        checkFilters();
        el.getMapMinusBtn().click();
        for (int i = 0; i < 7; i++){
            checkTooltip(el.getPoints().get(i));
            checkModal(el.getPoints().get(i));
        }
        el.getMapPlusBtn().click();
        checkMapBasicFunctions();
    }

    @Step
    public void checkProjectPortfolioSubBlock(){
        checkSubTitle();
        for (int i = 0; i < 3; i++){
            checkProjects(el.getProjects().get(i), el.getProjectLogos().get(i), el.getProjectTitles().get(i), el.getProjectLinks().get(i));
        }
        checkSliderControlModule();
        checkPricingModule();
    }

    @Step
    private void scrollToBlock() {
        el.getTitle().scrollTo();
    }

    @Step
    private void checkTooltip(SelenideElement point) {
        String count = "1 project";
        openModal(point);
        if (el.getModalAccordionElements().size() != 0) {
            count = el.getModalAccordionElements().size() + " projects";
        }
        closeModal();
        actions().moveToElement(point).build().perform();
        el.getProjectsCount().shouldBe(Condition.visible);
        Assert.assertEquals(el.getProjectsCount().getText(), count);
    }

    @Step
    private void checkModal(SelenideElement point) {
        openModal(point);
        if (el.getContainerModal().getAttribute("class").contains("xlarge")) {
            checkManyProjectsModal();
        } else if (el.getContainerModal().getAttribute("class").contains("small")) {
            checkSingleProjectModal();
        } else {
            Assert.fail("no open modal window");
        }
        closeModal();
    }

    @Step
    public void checkFilters() {
        Assertions.mouseIsPointer(el.getButtonsFilter().first());
        Assert.assertTrue(el.getButtonsFilter().first().getAttribute("class").contains("active"));
        int points = el.getPoints().size();
        for (int index = 1; index < el.getButtonsFilter().size(); index++) {
            Assertions.mouseIsPointer(el.getButtonsFilter().get(index));
            Assert.assertFalse(el.getButtonsFilter().get(index).getAttribute("class").contains("active"));

            el.getButtonsFilter().get(index).click();
            Assert.assertTrue(el.getButtonsFilter().get(index).getAttribute("class").contains("active"));
            Assert.assertFalse(el.getButtonsFilter().first().getAttribute("class").contains("active"));
            Assert.assertNotEquals(el.getPoints().size(), points);

            el.getButtonsFilter().first().click();
            Assert.assertFalse(el.getButtonsFilter().get(index).getAttribute("class").contains("active"));
            Assert.assertTrue(el.getButtonsFilter().first().getAttribute("class").contains("active"));
        }
    }

    @Step
    private void checkTitle() {
        Assert.assertEquals(el.getTitle().getText(), textTitle());
    }

    @Step
    private void checkMapBasicFunctions() {
        checkMapScaling();
        checkGoogleTerms();
    }

    private void checkSingleProjectModal() {
        checkCVExamples();
        checkViewCaseButton();
        checkSeeReferenceButton();
    }

    private void checkManyProjectsModal() {
        for (int index = 1; index < el.getModalAccordionElements().size(); index++) {
            SelenideElement first = el.getModalAccordionElements().first();
            SelenideElement current = el.getModalAccordionElements().get(index);
            checkElement(first, current);
        }
    }

    private void checkElement(SelenideElement first, SelenideElement current) {
        Assert.assertTrue(first.getAttribute("class").contains("active"));
        Assert.assertFalse(current.getAttribute("class").contains("active"));
        current.click();
        Assert.assertFalse(first.getAttribute("class").contains("active"));
        Assert.assertTrue(current.getAttribute("class").contains("active"));
        checkCVExamples();
        checkViewCaseButton();
        checkSeeReferenceButton();
        first.click();
    }

    private void checkViewCaseButton() {
        if (el.getButtonViewCase().isDisplayed()) {
            Assert.assertEquals(el.getButtonViewCase().getCssValue("background-color"), Color.INVISIBLE.getCode());
            Assertions.mouseIsPointer(el.getButtonViewCase());
            actions().moveToElement(el.getButtonViewCase());
            Assert.assertEquals(el.getButtonViewCase().getCssValue("background-color"), Color.YELLOW.getCode());
            Assert.assertTrue(el.getButtonViewCase().getAttribute("href").contains("project-cases") && el.getButtonViewCase().isDisplayed() && el.getButtonViewCase().isEnabled() && el.getButtonViewCase().getAttribute("target").contains("blank"));
        }
    }

    private void checkSeeReferenceButton(){
        if(el.getButtonSeeReference().isDisplayed()){
            Assert.assertEquals(el.getButtonSeeReference().getCssValue("color"), Color.BLACK_LINK.getCode());
            Assertions.mouseIsPointer(el.getButtonSeeReference());
            Assert.assertEquals(el.getButtonSeeReference().hover().getCssValue("color"), Color.YELLOW.getCode());
            Assert.assertTrue(el.getButtonSeeReference().getAttribute("href").contains("testimonials?reviewId") && el.getButtonSeeReference().isDisplayed() && el.getButtonSeeReference().isEnabled() && el.getButtonSeeReference().getAttribute("target").contains("blank"));
        }
    }

    private void checkMapScaling() {
        Assertions.mouseIsPointer(el.getMapPlusBtn());
        Assertions.mouseIsPointer(el.getMapMinusBtn());
    }

    private void checkGoogleTerms() {
        Assertions.mouseIsPointer(el.getGoogleTerms());
        Assert.assertTrue(el.getGoogleTerms().isDisplayed());
    }

    private void checkCVExamples() {
        for (SelenideElement link : el.getModalCVExamples()) {
            Assert.assertEquals(link.getCssValue("color"), Color.BLACK_LINK.getCode());
            Assertions.mouseIsPointer(link);
            Assert.assertEquals(link.hover().getCssValue("color"), Color.YELLOW.getCode());
            Assert.assertTrue(link.getAttribute("href").contains(".pdf") && link.isDisplayed() && link.isEnabled() && link.getAttribute("target").contains("blank"));
        }
    }

    private void openModal(SelenideElement point) {
        Assert.assertFalse(el.getContainerModal().isDisplayed());
        actions().moveToElement(point).click().build().perform();
        el.getContainerModal().shouldBe(Condition.visible);
        Assert.assertTrue(el.getContainerModal().isDisplayed());
    }

    private void closeModal() {
        Assert.assertTrue(el.getContainerModal().isDisplayed());
        el.getButtonCloseModal().click();
        el.getContainerModal().shouldBe(Condition.hidden);
        Assert.assertFalse(el.getContainerModal().isDisplayed());
    }

    @Step
    private void checkSubTitle() {
        Assert.assertEquals(el.getSubTitle().getText(), SUBTITLETEXT);
    }

    @Step
    private void checkProjects(SelenideElement project, SelenideElement projectLogo, SelenideElement projectTitle, SelenideElement projectLink){
        actions().moveToElement(project);
        projectLogo.shouldBe(Condition.visible);
        Assert.assertTrue(projectLogo.getAttribute("alt").contains("Logo"));
        projectTitle.shouldBe(Condition.visible);
        projectLink.shouldBe(Condition.visible);
        Assert.assertEquals(projectLink.getCssValue("color"), Color.BLACK_LINK.getCode());
        Assertions.mouseIsPointer(project);
        Assert.assertEquals(projectLink.hover().getCssValue("color"), Color.YELLOW.getCode());
        Assert.assertTrue(project.getAttribute("href").contains("project-cases"));
    }

    @Step
    private void checkSliderControlModule() {
        Assert.assertTrue(el.getSliderControlModule().isDisplayed());
        el.getSliderButtonPrevious().shouldBe(Condition.visible).shouldHave(Condition.attribute("disabled"));
        el.getSliderButtonNext().shouldBe(Condition.visible).shouldNotHave(Condition.attribute("disabled"));
        while (!el.getSliderButtonNext().is(Condition.attribute("disabled"))) {
            el.getSliderButtonNext().click();
        }
        el.getSliderButtonPrevious().shouldBe(Condition.visible).shouldNotHave(Condition.attribute("disabled"));
        el.getSliderButtonNext().shouldBe(Condition.visible).shouldHave(Condition.attribute("disabled"));
    }

    @Step
    private void checkPricingModule(){
        Warp.scrollToElement(el.getPricingModule());
        Assert.assertTrue(el.getPricingModule().isDisplayed());
        el.getPricingModuleContent().shouldBe(Condition.visible);
        el.getPricingModuleButton().shouldBe(Condition.visible);
        Assert.assertTrue(el.getPricingModuleButton().getAttribute("href").contains("/pricing") && el.getPricingModuleButton().getAttribute("target").contains("_blank"));
        Assertions.mouseIsPointer(el.getPricingModuleButton());
        Warp.openTargetLinkAndCheckUrl(el.getPricingModuleButton());
    }
}
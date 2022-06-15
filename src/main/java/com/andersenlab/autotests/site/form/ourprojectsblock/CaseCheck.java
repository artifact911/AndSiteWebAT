package com.andersenlab.autotests.site.form.ourprojectsblock;

import com.andersenlab.autotests.core.configs.constants.CasesModel;
import com.andersenlab.autotests.core.configs.constants.Google;
import com.andersenlab.autotests.site.page.industries.igaming.blocks.ourprojectsblock.OurProjectsBlock;
import com.andersenlab.autotests.site.utility.Warp;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

import static com.codeborne.selenide.Selenide.Wait;

public class CaseCheck {
    private final int caseIndex;
    private List<String> imageLinks = null;
    private final OurProjectsBlock ourProjects = new OurProjectsBlock();

    public CaseCheck(int index){
        this.caseIndex = index;
    }

    public CaseCheck(){
        this.caseIndex = 0;
    }

    public CaseCheck(int index, List<String> imageLinks){
        this.caseIndex = index;
        this.imageLinks = imageLinks;
    }

    @Step
    public void titlesCheck(int caseIndex, List<String> titles){
        if (ourProjects.getShowMore().isDisplayed()) {
            ourProjects.getShowMore().click();
        }
        ourProjects.getTitle().scrollTo();
        String expectedTitle = ourProjects.getArticleTitles().get(caseIndex).getText();
        ourProjects.getArticleCardButtons().get(caseIndex).click();
        ourProjects.getPopupContactUs().scrollTo();
        Assert.assertEquals(ourProjects.getPopupTitle().should(Condition.appear).getText(), expectedTitle);
        for (int sectionIndex=0; sectionIndex < ourProjects.getPopupSections().size(); sectionIndex++) {
            Assert.assertEquals(ourProjects.getPopupSections().get(sectionIndex).getText(), titles.get(sectionIndex));
        }
        Assert.assertEquals(ourProjects.getPopupContactUs().getText(), CasesModel.SectionTitles.CONTACT_US.getText());
        ourProjects.getPopupClose().click();
        Wait().until(ExpectedConditions.invisibilityOf(ourProjects.getPopupTitle()));
        Assert.assertFalse(ourProjects.getPopupTitle().isDisplayed());
    }

    @Step
    public void imagesCheck(){
        if (ourProjects.getShowMore().isDisplayed()) {
            ourProjects.getShowMore().click();
        }
        ourProjects.getTitle().scrollTo();
        ourProjects.getArticleCardButtons().get(caseIndex).click();
        ourProjects.getPopupContactUs().scrollTo();
        Wait().until(ExpectedConditions.visibilityOf(ourProjects.getPopupTitle()));
        Assert.assertEquals(ourProjects.getPopupTitle().getText(), ourProjects.getArticleTitles().get(caseIndex).getText());
        for (int imageIndex=0; imageIndex < ourProjects.getPopupImages().size(); imageIndex++) {
            Assert.assertEquals(ourProjects.getPopupImages().get(imageIndex).getAttribute("data-src"), imageLinks.get(imageIndex));
        }
        Assert.assertEquals(ourProjects.getPopupContactUs().getText(), CasesModel.SectionTitles.CONTACT_US.getText());
        ourProjects.getPopupClose().click();
        Assert.assertFalse(ourProjects.getPopupTitle().shouldBe(Condition.hidden).isDisplayed());
    }

    @Step
    public void openCase(){
        ourProjects.getArticleCardButtons().get(caseIndex).click();
        ourProjects.getPopupTitle().shouldBe(Condition.visible);
    }

    @Step public void closeCase(){
        ourProjects.getPopupClose().shouldBe(Condition.visible).click();
        ourProjects.getPopupTitle().shouldBe(Condition.hidden);
    }

    @Step
    public void feedBackFormCheck(){
        openCase();
        Assert.assertEquals(ourProjects.getFormTitle().getText(), OurProjectsBlock.expectedTitle);
        Assert.assertEquals(ourProjects.getFormNDAtext().getText(), OurProjectsBlock.expectedNDAText);
        Assert.assertFalse(ourProjects.getFormNDAinfo().isDisplayed());
        ourProjects.getFormNDAinfoButton().click();
        Assert.assertEquals(ourProjects.getFormNDAinfo().getText(), OurProjectsBlock.expectedNDAPopupInfo);
        ourProjects.getFormNDAclose().click();
        Warp.checkLinkNewTab(ourProjects.getFormPrivacyLink(), Google.expectedPrivacyLink);
        Warp.checkLinkNewTab(ourProjects.getFormTermsLink(), Google.expectedTermsLink);
        Assert.assertEquals(ourProjects.getFormRecaptcha().getText().replaceAll(" ", ""), Google.expectedRECAPTCHAText.replaceAll(" ", ""));
        closeCase();
    }

    @Step
    public void checkIndexedTextInCases(List<List<String>> texts){
        if (ourProjects.getShowMore().isDisplayed()) {
            ourProjects.getShowMore().click();
        }
        ourProjects.getTitle().scrollTo();
        for (int caseIndex=0; caseIndex<ourProjects.getArticleTitles().size(); caseIndex++){
            ourProjects.getArticleCardButtons().get(caseIndex).click();
            Assert.assertEquals(ourProjects.getPopupTitle().getText(), ourProjects.getArticleTitles().get(caseIndex).getText());
            for (int strIndex = 0; strIndex<texts.get(caseIndex).size(); strIndex++){
                Assert.assertEquals(ourProjects.getPopupSEO().get(strIndex).getText(), texts.get(caseIndex).get(strIndex));
            }
            ourProjects.getPopupClose().click();
            ourProjects.getPopupClose().shouldBe(Condition.hidden);
            Assert.assertFalse(ourProjects.getPopupTitle().isDisplayed());
        }
    }
}

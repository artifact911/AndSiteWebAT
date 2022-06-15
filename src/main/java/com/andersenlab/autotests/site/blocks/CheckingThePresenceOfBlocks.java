package com.andersenlab.autotests.site.blocks;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class CheckingThePresenceOfBlocks {

    private final SelenideElement intro = $(By.xpath("//section[@id='intro']"));
    private final SelenideElement feature = $(By.xpath("//section[@id='feature']"));
    private final SelenideElement companyOfExperts = $(By.xpath("//section[@id='certificates']"));
    private final SelenideElement greetingCard = $(By.xpath("//section[@id='greeting-card']"));
    private final SelenideElement listPageInterlinking = $(By.xpath("//section[@id='list-page-interlinking']"));
    private final SelenideElement additionalInfo = $(By.xpath("//section[contains(@class, 'AdditionalInfo')]"));
    private final SelenideElement architect = $(By.xpath("//section[@id='architect']"));
    private final SelenideElement calculator = $(By.xpath("//section[@id='calculator']"));
    private final SelenideElement callToAction = $(By.xpath("//section[@id='call-to-action']"));
    private final SelenideElement callToActionWithPhoto = $(By.xpath("//section[@id='cta-with-photo']"));
    private final SelenideElement collaborationModel = $(By.xpath("//section[@id='collaboration-models']"));
    private final SelenideElement consultancyServices  = $(By.xpath("//section[@id='consultancy-services']"));
    private final SelenideElement faq = $(By.xpath("//section[@id='faq']"));
    private final SelenideElement industryRecognition = $(By.xpath("//section[@id='industry-recognition']"));
    private final SelenideElement customSolutions = $(By.xpath("//section[@id='industries']"));
    private final SelenideElement getConsultation = $(By.xpath("//section[@id='get-consultation']"));
    private final SelenideElement ourOffices = $(By.xpath("//section[@id='offices']"));
    private final SelenideElement ourResume = $(By.xpath("//section[@id='resume']"));
    private final SelenideElement ourVideo = $(By.xpath("//section[@id='our-video']"));
    private final SelenideElement pageInterlinking = $(By.xpath("//section[@id='page-interlinking']"));
    private final SelenideElement processSteps = $(By.xpath("//section[@id='process-steps']"));
    private final SelenideElement projects = $(By.xpath("//section[@id='concepts-list']"));
    private final SelenideElement projectsAtHomePage = $(By.xpath("//section[@id='projects']"));

    @Step
    public void checkAnyBlockForExistence(SelenideElement nameOfBlock){
        nameOfBlock.shouldBe(Condition.exist);
    }

}

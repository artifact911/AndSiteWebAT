package com.andersenlab.autotests.site.page.services.mobiledevelopment.blocks.projectexamples;

import com.andersenlab.autotests.core.steps.Assertions;
import com.andersenlab.autotests.site.utility.Warp;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Getter
public class ProjectExamples {
    //constants for texts()
    private final String BASE_1 = "//h2[contains(text(), 'Project examples')]//..//.."; //MOB_DEV Project examples  /  QA Case Studies //BA Our projects
    private final String BASE_2 = "//section[contains(@class, 'article-card')]"; //QA Something to think about //BA Something to think about

    private String BASE;
    private By TITLE;
    private By SUBTITLE;
    private By BUTTON_MORE;
    private By VCS;

    private SelenideElement title;
    private SelenideElement subtitle;
    private SelenideElement buttonMore;
    private ElementsCollection vcs;

    private boolean isShowMore = true;

    String TEXT_TITLE;
    String TEXT_SUBTITLE;

    public ProjectExamples(String BASE) {
        this.BASE = BASE;
        calc();
    }

    private void calc() {
        TITLE = By.xpath(BASE + "//h2");
        SUBTITLE = By.xpath(BASE + "//p[contains(@class, 'subtitle')]");
        BUTTON_MORE = By.xpath(BASE + "//button[contains(text(), 'Show more')]");
        VCS = By.xpath(BASE + "//button[contains(text(), 'View Case')]");

        title = $(TITLE);
        subtitle = $(SUBTITLE);
        buttonMore = $(BUTTON_MORE);
        vcs = $$(VCS);
        TEXT_TITLE = texts()[0];
        TEXT_SUBTITLE = texts()[1];
    }

    public void noShowMore() {
        isShowMore = false;
    }

    @Step //TODO возможно, лучше везде скроллить до заголовка след блока
    public void displayingElementsAndFunction() {
        if (isShowMore) Warp.scrollToElement(buttonMore);
        else {
            Warp.scrollToElement(Warp.el("//section[contains(@class, 'article-card')]//./following-sibling::section[1]//h2[contains(@class, 'title')]"));
        }
        Assert.assertEquals(title.getAttribute("innerText"), TEXT_TITLE);
        Assert.assertEquals(subtitle.getAttribute("innerText"), TEXT_SUBTITLE);

        if (isShowMore) {
            Assert.assertTrue(Warp.isElementPresent(BUTTON_MORE));
            while (Warp.isElementPresent(BUTTON_MORE)) {
                int vcQuantity = vcs.size();
                buttonMore.click();
                Assert.assertNotEquals(vcs.size(), vcQuantity);
            }
        } else {
            Assert.assertFalse(Warp.isElementPresent(BUTTON_MORE));
        }

        for (SelenideElement e : vcs) {
            Assertions.mouseIsPointer(e);
            Warp.elementIsIntractable(e);
        }
    }

    private String[] texts() {
        //дописывать по необходимости
        String t = Warp.currentURL();
        if(BASE.equals(BASE_1) & t.contains("mobile-development")) return new String[] {"Project examples", "Experts use the latest technology and industry-leading craft solutions for MDL business. We help companies improve service and trust through first-class mobile applications."};
        else if (BASE.equals(BASE_1) & t.contains("quality-assurance-services")) return new String[] {"Case Studies", "We often meet the same problems on our customer's projects. Let's take a look at how we solved them on certain examples"};
        else if(BASE.equals(BASE_2) & t.contains("quality-assurance-services")) return new String[] {"Something to think about", "Sharing our thoughts and news and tracking the latest trends and changes in the QA field"};
        else if (t.contains("maintenance-support")) return new String[] {"Take a Look at Our Maintenance & Support Cases", "Here is how we help clients derive maximum benefit from their software"};
        else if (t.contains("eLearning")) return new String[] {"Something to think about", "We regularly conduct market research, monitor its trends and changes. And today we want to share with you our vision of where the global market is moving in the field of banking and financial technologies."};
        else if (BASE.equals(BASE_1) & t.contains("business-analysts")) return new String[] {"Our projects", "Providing full range of BA services, we help you create best-in-class software solutions for your business that perfectly fit your needs. The best results are reflected in our projects"};
        else if (BASE.equals(BASE_2) & t.contains("business-analysts")) return new String[] {"Something to think about", "Sharing our thoughts and news tracking the latest trends and changes in the Business Analysis field"};
        else throw new IllegalArgumentException();

    }
}

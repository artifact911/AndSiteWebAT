package com.andersenlab.autotests.site.page.services.customsoftware.blocks.intro;

import com.andersenlab.autotests.core.configs.constants.Country;
import com.andersenlab.autotests.site.form.commonforms.FormData;
import io.qameta.allure.Step;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.testng.Assert;

@Getter
@NoArgsConstructor //если не нужны виджеты
public class Intro implements FormData, IntroLocators {
    private final IntroElements el = new IntroElements();
    Widgets[] widgets;

    public Intro(Widgets[] widgets) {
        this.widgets = widgets;
    }

    @Step
    public void displayingElements(Country country) {
        displayingTitle(country);
        displayingPhone(country);
        Assert.assertEquals(el.getWidgets().size(), widgets.length);
        for (int i = 0; i < widgets.length; i++) {
            widgets[i].check(el.getWidgets().get(i));
        }
    }

    @Step
    public void displayingTitle(Country country) {
        Assert.assertEquals(el.getHeading().getText(), textTitle());
    }

    @Step
    public void displayingPhone(Country country) {
        Assert.assertEquals(el.getLinkPhone().getText(), getLinkPhoneText(country));
    }
}

package com.andersenlab.autotests.site.page.engineers;

import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class EngineersOnProjectsLocators {
    static final By TITLE = By.xpath("//h1[text()[normalize-space()='Engineers on Projects']]");
}

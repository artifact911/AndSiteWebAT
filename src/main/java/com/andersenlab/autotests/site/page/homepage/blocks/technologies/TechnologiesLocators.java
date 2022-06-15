package com.andersenlab.autotests.site.page.homepage.blocks.technologies;

import org.openqa.selenium.By;

class TechnologiesLocators {

    final static By LINK_FRONT_END_PAGE = By.xpath("//span[contains(text(),'Front-end')]");
    final static By LINK_MOBILE_PAGE = By.xpath("//span[contains(text(),'Mobile')]");
    final static By LINK_SCALA_PAGE = By.xpath("//span[contains(text(),'Scala')]");
    final static By LINK_DEDICATED_TEAM = By.cssSelector(".link-underline_arrow-right");
    final static By LINK_DOT_NET_PAGE = By.xpath("//span[contains(text(),'.NET')]");
    final static By LINK_PYTHON_PAGE = By.xpath("//span[contains(text(),'Python')]");
    final static By LINK_JAVA_PAGE = By.xpath("//span[contains(text(),'Java')]");
}

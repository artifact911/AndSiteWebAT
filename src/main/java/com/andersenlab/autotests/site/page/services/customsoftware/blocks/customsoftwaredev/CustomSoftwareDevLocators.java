package com.andersenlab.autotests.site.page.services.customsoftware.blocks.customsoftwaredev;

import org.openqa.selenium.By;

public interface CustomSoftwareDevLocators {
    String BASE = "//section[contains(@class, 'container-module--container')]";
    By HEADER = By.xpath(BASE + "//h2[contains(text(), 'Custom software development')]");
    By DESCRIPTION = By.xpath(BASE + "//p[contains(text(), 'Custom solution development requires a solid technical background')]");

    By HEADER_ARTICLE1 = By.xpath(BASE + "//h2[contains(text(), 'Software Product Development')]");
    By HEADER_ARTICLE2 = By.xpath(BASE + "//h2[contains(text(), 'Enterprise Software Development')]");
    By HEADER_ARTICLE3 = By.xpath(BASE + "//h2[contains(text(), 'Software Enhancement and Modernization')]");

    By ARTICLE1 = By.xpath(BASE + "//p[contains(text(), 'Bring your software product ideas to life')]");
    By ARTICLE2 = By.xpath(BASE + "//p[contains(text(), 'Andersen’s team of experts helps large organizations')]");
    By ARTICLE3 = By.xpath(BASE + "//p[contains(text(), 'Software engineers modernize and upgrade')]");



    String TEXT_HEADER = "Custom software development";
    String TEXT_DESCRIPTION = "Custom solution development requires a solid technical background and a clear understanding of the сlient’s business goals. Andersen has 13 years of tech expertise and provides high-quality and cost-efficient software development services. It allows startups, mid-sized and enterprise-grade businesses to achieve their goals with the help of custom software solutions from simple customizations to full-cycle software development.";

    String TEXT_HEADER_ARTICLE1 = "Software Product Development";
    String TEXT_HEADER_ARTICLE2 = "Enterprise Software Development";
    String TEXT_HEADER_ARTICLE3 = "Software Enhancement and Modernization";

    String TEXT_ARTICLE1 = "Bring your software product ideas to life, improve the quality of your existing product, and reduce time-to-market and development costs with our service.";
    String TEXT_ARTICLE2 = "Andersen’s team of experts helps large organizations achieve long-term success by reengineering technical solutions of various complexities. This increases flexibility and business efficiency.";
    String TEXT_ARTICLE3 = "Software engineers modernize and upgrade your software by using the latest techniques that fill the gaps in your software operations. If necessary, they create an effective software solution from scratch, which best meets your current business needs.";


}

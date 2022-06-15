package com.andersenlab.autotests.site.page.industries.ecommerce.blocks.reachout;

import org.openqa.selenium.By;

class ReachLocators {
    final static By OPEN_REACH_FORM_BUTTON = By.xpath("//button[@class='button soft-dev-reach__button']");
//    final static By REACH_FORM_EMAIL = By.xpath("(//input[@name='email'])[3]");
    final static By REACH_FORM_EMAIL = By.xpath("//*[@id='form-request']/div[3]/div/input");
//    final static By REACH_FORM_PHONE = By.xpath("(//input[@name='phone'])[3]");
    final static By REACH_FORM_PHONE = By.xpath("(//input[@type='tel'])[3]");
//    final static By REACH_FORM_SEND_BUTTON = By.cssSelector("form#form-request>button");
    final static By REACH_FORM_SEND_BUTTON = By.xpath("//*[@id='form-request']/button");
    final static By REACH_FORM = By.id("popup_request");
    final static By POPUP_SUCCESS = By.cssSelector("#popup-success .popup__section");
    final static By CLOSE_SUCCESS_POPUP_BUTTON = By.cssSelector("#popup-success .popup__close");
    final static By CLOSE_REQUEST_POPUP_BUTTON = By.cssSelector("#popup_request .js--popup-close");
    final static String FORM_ERROR_NO_EMAIL ="#form-request div:nth-child(3) >div";
    final static String FORM_ERROR_NO_PHONE = "#form-request div:nth-child(4) >div";



}

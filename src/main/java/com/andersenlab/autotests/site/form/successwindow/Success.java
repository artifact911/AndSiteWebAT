package com.andersenlab.autotests.site.form.successwindow;

public interface Success {
    String TEXT_TITLE_SUCCESS_15 = "Thank you! We will contact you within 15 minutes!";
    String TEXT_TITLE_SUCCESS_ASAP = "Thank you for your interest!" + "We will contact you ASAP!";
//    String TEXT_TITLE_SUCCESS_ASAP = "Thanks for your request! We will contact you ASAP";//custom-software-development calc
    void checkAndClose();
}

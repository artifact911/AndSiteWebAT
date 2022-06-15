package com.andersenlab.autotests.site.form.spam;

public interface Spamable {
    String goodReq(String mail, String phone);
    void precondition();
//    String MAIL = "qaands@andersenlab.com"; //выбор почты непосредственно перед спамом
    String MAIL = "qaands+3@gmail.com";
    String PHONE = "\b\b\b\b1" + "132465798";
    String NAME_BASE = "AQA";
    boolean CHECK_BOX = true;
}

package com.andersenlab.autotests.site.form.commonforms;

import com.andersenlab.autotests.core.configs.constants.Country;

import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;

public interface FormData {
    String PHONE_VALID = "\b\b\b\b+1" + "01324657980";//костыль потому что поле для телефона с приколом
    String PHONE_INVALID = "\b\b\b\b" + randomNumeric(2, 3);
    String MAIL_COOPERATE = "qaands@andersenlab.com";
    String MAIL_NOT_COOPERATE = "qaands+3@gmail.com";
    String MAIL_INVALID = "qaandsmail.com";
    String NAME = "AQA";

    String TEXT_HINT_MAIL_COOPER = "\n        For industry-based consultancy, a corporate email is preferred.    ";
    String TEXT_TITLE_SUCCESS = "\n" + "                    Thank you for your interest!" + "\n" + "                    We will contact you ASAP!                ";
    String TEXT_ASK_PHONE = "Please, enter your phone number";
    String TEXT_ASK_MAIL = "Please, enter your corporate email";
    String TEXT_HINT_CHECKBOX = "Before we discuss any details about your project you can request to sign a Non Disclosure Agreement";
    String TEXT_CHECKBOX = "I want to protect my data by signing an NDA.";

    String PRIVACY_POLICY_HREF = "https://policies.google.com/privacy";
    String TERMS_HREF = "https://policies.google.com/terms";

    String TEXT_LINK_MAIL = "vn@andersenlab.com";
    String LINK_MAIL_HREF = "mailto:vn@andersenlab.com";

    String LINK_SKYPE_HREF = "https://join.skype.com/aM8R4P4dNJdy";
    String LINK_WHATSAPP_HREF = "https://chat.whatsapp.com/HEVIsiSlYBmG34VtaPcgmu";
    String LINK_TELEGRAM_HREF = "tg://resolve?domain=andersenlab";
    String LINK_LINKED_HREF = "https://www.linkedin.com/company/andersen-lab";
    String LINK_FB_HREF = "https://www.facebook.com/AndersenSoftwareDev";

    int DELAY = 2;
    //задержка перед запросами в базу в тестах RequestFrom. можно сделать ее адаптивной в пределах прогона
    //но для этого нужно выдлить в приватное статическое поле некоего класса и дать начальное значение (эмпирически - 30-60 сек)
    //и создать публичные методы incDelay /decDelay, которые будут это значение увеличивать/уменьшать.
    //уменьшать, если прошло с первого запроса, увеличивать, если, положим, с 3-го и больше.
    //это позволит меньше дергать базу, а учитывая к-во тестов на такие формы TODO реализовать, не срочно

    default String getLinkPhoneHref(Country c){
        switch (c){
            case US:
//                return "tel:+19179939742";
                return "tel:+18009677762";
            case UA:
                return "tel:+380443792837";
            case DE:
                return "tel:+49(0)3059008 3687";
            case FR:
                return "tel:+336768635 07";
            case BY:
                return "tel:+375173884022";
            case RU:
                return "tel:+74952041986";
            default:
                throw new IllegalArgumentException("UNKNOWN COUNTRY");
        }
    }

    default String getLinkPhoneText(Country c) {
        switch (c) {
            case US:
                return "+1 800 967 7762";
            case UA:
                return "+380 44 379 2837";
            case DE:
                return "+49 30 52014251";
            case FR:
                return "+33 6 76 86 35 07";
            case BY:
                return "+375 17 388 4022";
            case RU:
                return "+7 495 204 1986";
            default:
                throw new IllegalArgumentException("UNKNOWN COUNTRY");
        }
    }
}
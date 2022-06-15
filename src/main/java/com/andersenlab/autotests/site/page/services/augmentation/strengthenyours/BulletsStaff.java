package com.andersenlab.autotests.site.page.services.augmentation.strengthenyours;

import lombok.Getter;

@Getter
public enum BulletsStaff {

    BULLET1("CHOOSE THE BEST",
            "Receive first CVs of our specialists and start interviewing candidates within.\n" +
                    "3 business days"),
    BULLET2("START FAST",
            "Chosen engineers will be available to start within.\n" +
                    "10 business days"),
    BULLET3("MINIMIZE RISK",
            "To get rid of any doubts, check the quality of your team with no obligation to pay.\n" +
                    "2 weeks trial");

    private final String nameOf;
    private final String text;

    BulletsStaff(String nameOf, String text) {
        this.nameOf = nameOf;
        this.text = text;
    }
}

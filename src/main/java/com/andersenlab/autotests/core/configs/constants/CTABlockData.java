package com.andersenlab.autotests.core.configs.constants;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class CTABlockData {
    protected static String BASE = "//section[contains(@class, 'CallToAction-module--container')]";

    public enum Locators {
        //TITLE, IMG, HINT, BTN
        DEFAULT(Arrays.asList(BASE + "//p", "section div.CallToActionHint-module--container--p-pbu  svg > use", BASE + "//p", BASE + "//button"));

        @Getter private final List<String> data;

        Locators(List<String> data){
            this.data = data;
        }
    }

    public enum Page {
        //TITLE, IMG, HINT, BTN
        ENTERPRISE(Arrays.asList(
                "Want to know how and for how much we could improve your business? Describe the context, and our most relevant expert will get in touch with you soon!",
                "", "", "Reach out"
        )),
        TELECOM(Arrays.asList("Order the development of your software right now to become a leader in your industry", SvgIcons.hint,
                "According to Morgan Stanley data, over 95% of telecom companies will use AI, ML, and automation software in three years’ time.", "Contact us")),
        REAL_ESTATE(Arrays.asList("Are you ready to order your custom real estate software? Discuss your project with our expert now", "", "", "Get a free quote")),
        HEALTHCARE_MAIN(Arrays.asList("","","","Contact us")),
        HC_SOFT_DEV(Arrays.asList("Request a professional consultation on building an innovative custom healthcare application.","","","Contact us")),
        BI_AND_DA(Arrays.asList("Request a professional consultation on how to operate and work with your healthcare data to bring additional value to your healthcare solutions","","","Contact us")),
        TELEHEATH(Arrays.asList("Request a professional consultation on building a functional and secure custom telemedicine software solution","","","Contact us")),
        EMR(Arrays.asList("Request a professional consultation on development, customization or integration of Electronic Health Records (EHR/EMR)","","","Contact us"));

        @Getter private final List<String> expected;

        Page(List<String> expected){
            this.expected = expected;
        }
    }


}

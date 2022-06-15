package com.andersenlab.autotests.core.configs.constants;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class DifferenceBlockData{
    public enum Healthcare{
        HEADER(Arrays.asList(Arrays.asList("", "Andersen’s Difference"))),
        CARDS(Arrays.asList(
                Arrays.asList(SvgIcons.twoMan, "Over 1800 professionals"),
                Arrays.asList(SvgIcons.geoDots, "Availability of resources,\n16 development centres"),
                Arrays.asList(SvgIcons.star, "Project scoring\nOver 50 metrics"),
                Arrays.asList(SvgIcons.geoEarth, "Wide geography of operation\nOffices worldwide"))),
        LIST(Arrays.asList(
                Arrays.asList("", "We communicate in plain English"),
                Arrays.asList("", "We listen to your needs and deliver on time every time"),
                Arrays.asList("", "14 years of experience in software development"),
                Arrays.asList("", "Secure infrastructure and stable connection speed"),
                Arrays.asList("", "Constant cross-checking and project performance feedback"),
                Arrays.asList("", "Daily Skype/Slack meetings"),
                Arrays.asList("", "Possible assignments to the customer’s sitevectors"),
                Arrays.asList("", "14-day trial period at no cost in case of issues")));
        @Getter private final List<List<String>> data;

        Healthcare(List<List<String>> data){
            this.data = data;
        }
    }
}

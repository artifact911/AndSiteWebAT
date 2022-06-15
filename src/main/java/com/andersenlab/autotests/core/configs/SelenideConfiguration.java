package com.andersenlab.autotests.core.configs;

import com.andersenlab.autotests.core.configs.constants.Country;
import com.andersenlab.autotests.core.configs.constants.Resolution;
import com.andersenlab.autotests.core.utils.PropertiesReader;
import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Browsers.CHROME;

public class SelenideConfiguration {
    private static Resolution resolution = Resolution.DESKTOP;
    private static Country country = Country.NOT_SPECIFIED;

    public static Resolution getResolution() {
        return SelenideConfiguration.resolution;
    }

    public static Country getCountry() {
        return SelenideConfiguration.country;
    }

    public static void configure() {
        doResolution();
        doAll();
    }

    public static void configure(Country country) {
        SelenideConfiguration.country = country;
        doAll();
    }

    public static void configure(Resolution resolution) {
        SelenideConfiguration.resolution = resolution;
        doAll();
    }

    public static void configure(Resolution resolution, Country country) {
        SelenideConfiguration.resolution = resolution;
        SelenideConfiguration.country = country;
        doAll();
    }

    private static void doAll() {
        doBasic();
        doRemote();
        doResolution();
        doProxy();
    }

    private static void doBasic() {
        Configuration.browser = CHROME;
        Configuration.headless = Boolean.parseBoolean(PropertiesReader.get("headlessMode"));
        Configuration.fastSetValue = true;
        Configuration.savePageSource = false;
        Configuration.timeout = 30000;
        Configuration.reportsFolder = "target/allure-results";
        Configuration.browserVersion = "96.0.4664.45";
    }

    private static void doRemote() {
        if (!Boolean.parseBoolean(PropertiesReader.get("local.launch"))) {
            Configuration.remote = PropertiesReader.get("selenoid.url");
            Configuration.browserCapabilities = DriverConfiguration.getCapabilities();
        }
    }

    private static void doResolution() {
        switch (resolution) {
            case DESKTOP:
                Configuration.startMaximized = getHeadlessPropertyValue();
                Configuration.browserSize = Resolution.DESKTOP.resolution();
                break;
            case TABLET:
                Configuration.browserSize = Resolution.TABLET.resolution();
                break;
            case MOBILE:
                Configuration.browserCapabilities = Configuration.browserCapabilities.merge(DriverConfiguration.getMobile());
                break;
            default:
                throw new IllegalArgumentException("Unsupported resolution");
        }
    }

    private static void doProxy() {
        if (!country.equals(Country.NOT_SPECIFIED)) {
            Configuration.browserCapabilities = Configuration.browserCapabilities.merge(DriverConfiguration.getCapabilities(country));
        }
    }

    private static boolean getHeadlessPropertyValue() {
        boolean value = Boolean.parseBoolean(PropertiesReader.get("headlessMode"));
        boolean result;
        if (value == true) {
            result = false;
        } else {
            result = true;
        }
        return result;
    }
}

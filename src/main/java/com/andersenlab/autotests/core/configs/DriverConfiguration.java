package com.andersenlab.autotests.core.configs;

import com.andersenlab.autotests.core.configs.constants.Country;
import com.andersenlab.autotests.site.utility.Logger;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;

@Slf4j
class DriverConfiguration {

    private static DesiredCapabilities defaultRemote() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", false);
        capabilities.setCapability("name", "AndersenSite");
        capabilities.setCapability("sessionTimeout", "5m");
        capabilities.setCapability("screenResolution", "2000x1100x24");
        //попробуем загружать файлы по опред пути и блокировать поап "позвонить"
        ChromeOptions chromeOptions = new ChromeOptions();
        HashMap<String, Object> chromePref = new HashMap<>();
        final String downloadFilepath = "..\\..\\site\\drafts\\download"; //FIXME почему путь не применяется???
        chromePref.put("profile.default_content_settings.popups", 0);
        chromePref.put("download.default_directory", downloadFilepath);
        chromeOptions.setExperimentalOption("prefs", chromePref);
        chromeOptions.addArguments("--disable-popup-blocking");//added to prevent appearance chrome's pop-up tel:
        capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        //конец. опции не применились.
        return capabilities;
    }

    private static DesiredCapabilities proxy(Country country) {
        Proxy proxy = ProxyManager.getProxy(country);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("proxy", proxy);

        log.info("Current country: " + country);
        log.info("Current proxy: " + proxy.toString());

        return capabilities;
    }

    private static DesiredCapabilities mobile() {
        Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", "iPhone X");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

        return capabilities;
    }

    static DesiredCapabilities getCapabilities() {
        return defaultRemote();
    }

    static DesiredCapabilities getCapabilities(Country proxyCountry) {
        return getCapabilities().merge(proxy(proxyCountry));
    }

    static DesiredCapabilities getMobile() {
        return mobile();
    }
}


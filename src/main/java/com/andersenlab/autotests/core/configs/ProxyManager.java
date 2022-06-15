package com.andersenlab.autotests.core.configs;

import com.andersenlab.autotests.core.configs.constants.Country;
import com.andersenlab.autotests.core.utils.PropertiesReader;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebElement;

import java.util.*;

import static com.codeborne.selenide.Selenide.$$;

@Slf4j
public class ProxyManager {
    private static Map<Country, ProxyInfo> proxies = null;
    private static boolean searchForProxies = Boolean.parseBoolean(PropertiesReader.get("proxy.search.enabled"));

    private static void searchForProxies() {
        List<Country> countries = new ArrayList<>(Arrays.asList(Country.values()));
        countries.remove(Country.NOT_SPECIFIED);
        proxies = new HashMap<>();

        String proxySiteUrl = "http://spys.one/free-proxy-list/";
        By suitableProxyRow = By.xpath("//tr[contains(@class, 'spy1x')][descendant::*[contains(@href, 'https')]]" +
                "[descendant::td[4][descendant::*[@class='spy1']]][descendant::acronym[contains(@title, 'status=OK')]]");
        By ipInProxyRow = By.xpath("./td[1]");
        By latencyInProxyRow = By.xpath("./td[6]");

        countries.forEach(country -> {
            List<ProxyInfo> proxies = new ArrayList<>();
            Selenide.open(proxySiteUrl + country.name() + "/");
            ElementsCollection proxyRows = $$(suitableProxyRow);
            for (WebElement proxyRow : proxyRows) {
                String ip = proxyRow.findElement(ipInProxyRow).getText();
                Double latency = Double.parseDouble(proxyRow.findElement(latencyInProxyRow).getText());
                proxies.add(new ProxyInfo(ip, latency));
            }
            ProxyInfo minLatProxy = getProxyWithMinimalLatency(proxies);
            ProxyManager.proxies.put(country, minLatProxy);
        });
        Selenide.closeWebDriver();
        log.info("Proxy list: " + proxies.toString());
    }

    private static ProxyInfo getProxyWithMinimalLatency(List<ProxyInfo> proxyInfos) {
        return proxyInfos.stream().min(Comparator.comparing(ProxyInfo::getLatency)).orElse(null);
    }

    static Proxy getProxy(Country country) {
        Proxy proxy = new Proxy();
        if (searchForProxies) {
            if (proxies == null) {
                searchForProxies();
            }
            if (proxies.get(country) == null) {
                log.error("Proxy for country " + country + " is " + proxies.get(country));
                throw new NoSuchElementException("No suitable proxy found for country: " + country);
            }
            proxy.setHttpProxy(proxies.get(country).getIp());
            proxy.setSslProxy(proxies.get(country).getIp());
        } else {
            proxy.setHttpProxy(PropertiesReader.get("proxy." + country));
            proxy.setSslProxy(PropertiesReader.get("proxy." + country));
        }
        return proxy;
    }
}

package com.andersenlab.autotests.site.utility;

import com.andersenlab.autotests.core.configs.constants.Country;
import com.andersenlab.autotests.core.steps.Assertions;
import com.andersenlab.autotests.core.utils.utility.Utility;
import com.andersenlab.autotests.site.logic.Navigation;
import com.codeborne.selenide.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.PublicKey;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class Warp {
    private static Logger logger = Logger.getLogger();
    private static WebDriver driver;
    private static Navigation navigation;

    /**
     * этот метод всегда вызывать первой строкой в методах, где использувется поле driver
     * потому что WebDriverRunner.getWebDriver() должен быть вызван в текущий момент, иначе
     * org.openqa.selenium.NoSuchSessionException: Session ID is null. Using WebDriver after calling quit()?
     * а в отдельный метод вынесено потому что при переходе селенид/селениум способ получения driver изменится
     * <p>
     * проблема не проявляется при запуске теста из класса, но при запуске сьюта (тестнг.xml) из нескольких классов
     */
    private static void doBefore() {
        driver = WebDriverRunner.getWebDriver();
    }

    public static void refreshPage() {
        doBefore();
        String url = driver.getCurrentUrl();
        driver.get(url);
    }

    public static void delay(int sec) {
        logger.log(sec + " seconds delay start");
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException ignored) {
        }
    }

    //клики по элементам, скроллинг-----------------------------------------------------------------------------------

    public static void clickUntouchable(SelenideElement el, int xOffset, int yOffset) {
        //для псевдоэлементов /before/after
        doBefore();
        Actions action = new Actions(driver);
        action.moveToElement(el).moveByOffset(xOffset, yOffset).click().build().perform();
    }

    public static String[] openNewTab(String path) {
        /*
        передаем в метод путь на элемент, который откроет новую вкладку по клику
        метод откроет новую вкладку, переключит на нее фокус
        вернет массив [старая, новая] вкладки
        */
        return openNewTab($(By.xpath(path)));
    }

    public static String[] openNewTab(By locator) {
        return openNewTab($(locator));
    }

    public static String[] openNewTab(SelenideElement e) {
        doBefore();
        // можно проверять сразу, собирается ли что-то открываться в новой вкладке или нет, но в таком случае мотод съест только ссылку, а у нас может быть что-то вложенное в ссылку млм обернутое вокруг
        //Assert.assertTrue(e.getAttribute("target").contains("blank"));
        String startTab = driver.getWindowHandle();//сохраним первоначальную вкладку. она имеет право быть не_единственной / не_первой
        String newTab = null;//обявим переменную под вкладку, которая будет открыта по клику на элемент
        Set<String> oldTabs = driver.getWindowHandles();//возьмем сет всех вкладок открытых до

        actions().moveToElement(e.shouldBe(enabled)).click().perform();//кликнем*/
        Set<String> newTabs = driver.getWindowHandles();//возьмем сет всех вкладок открытых после
        if (newTabs.size() != oldTabs.size() + 1) {
            Assert.fail("MORE THAN ONE TAB WAS OPENED");//ожидаем, что вкладок стало на одну больше
        }
        for (String tab : newTabs) {
            newTab = tab;//нашли вкладку которой раньше не было
            if (!oldTabs.contains(newTab)) {
                break;
            }
        }
        driver.switchTo().window(newTab);//переключились на новую вкладку
        return new String[]{startTab, newTab};
    }

    public static void clickUntouchable(SelenideElement el, int xOffset, int yOffset, Boolean test) {
        //для псевдоэлементов /before/after пристрелка
        doBefore();
        Actions action = new Actions(driver);
        action.moveToElement(el).moveByOffset(xOffset, yOffset).contextClick().build().perform();
    }

    public static void clickSimple(String path) {
        ($(By.xpath(path))).click();
    }

    public static void clickSimpleIfPresent(String path) {
        if (isElementPresent(By.xpath(path))) ($(By.xpath(path))).click();
    }

    public static void scrollToElement(SelenideElement e) {
        doBefore();
        Actions action = new Actions(driver);
        action.moveToElement(e).build().perform();
    }

    public static void scrollToElement(By locator) {
        doBefore();
        Actions action = new Actions(driver);
        action.moveToElement($(locator).shouldBe(enabled)).build().perform();
    }

    public static void scrollToElement(String path) {
        doBefore();
        Actions action = new Actions(driver);
        action.moveToElement($(By.xpath(path))).build().perform();
    }

    //проверки ссылок-----------------------------------------------------------------------------------

    /**
     * Проверит переход по кнопке в новую вкладку, проверит url новой вкладки с url что был под кнопкой,
     * закроет текущую вкладку и вернется в исходную вкладку. Рабочий метод.
     */
    public static void openTargetLinkAndCheckUrl(SelenideElement el) {
        final String startWindow = WebDriverRunner.getWebDriver().getWindowHandle();
        final Set<String> windowHandles = WebDriverRunner.getWebDriver().getWindowHandles();
        final String href = el.getAttribute("href");
        el.click();
        Selenide.switchTo().window(windowHandles.size());
        Assert.assertEquals(WebDriverRunner.getWebDriver().getCurrentUrl(), href);
        Selenide.closeWindow();
        Selenide.switchTo().window(startWindow);
    }

    public static void checkLinkThisTab(SelenideElement e, String href, boolean debug) {
        //для отладки
        if (debug) {
            System.out.println("href - " + (e.getAttribute("href").equals(href) ? true : e.getAttribute("href")));
            System.out.println("isDisplayed - " + e.isDisplayed());
            System.out.println("isEnabled - " + e.isEnabled());
            System.out.println("!target:blank - " + !e.getAttribute("target").contains("blank"));
        }
        checkLinkThisTab(e, href);
    }

    public static void checkLinkThisTab(SelenideElement e, String href) {
        Assertions.mouseIsPointer(e);
        Assert.assertTrue(e.getAttribute("href").contains(href) && e.isDisplayed() && e.isEnabled() && !e.getAttribute("target").contains("blank"));
    }

    public static void checkLinkNewTab(SelenideElement e, String href) {
        Assertions.mouseIsPointer(e);
        Assert.assertTrue(e.getAttribute("href").equals(href) && e.isDisplayed() && e.isEnabled() && e.getAttribute("target").contains("blank"));
    }

    public static void checkLinkNewTab(SelenideElement e, String href, boolean debug) {
        if (debug) {
            System.out.println("href - " + (e.getAttribute("href").equals(href) ? true : e.getAttribute("href")));
            System.out.println("isDisplayed - " + e.isDisplayed());
            System.out.println("isEnabled - " + e.isEnabled());
            System.out.println("!target:blank - " + e.getAttribute("target").contains("blank"));
        }
        checkLinkNewTab(e, href);
    }

    public static void checkLinkThisTab(String path, String href) {
        SelenideElement e = $(By.xpath(path));
        Assertions.mouseIsPointer(e);
        Assert.assertTrue(e.isDisplayed() && e.isEnabled());
        Assert.assertEquals(e.getAttribute("href"), href);
    }

    public static boolean checkLinkPart(SelenideElement e, String partOfHref) {
        Assertions.mouseIsPointer(e);
        return e.getAttribute("href").contains(partOfHref) && e.isDisplayed() && e.isEnabled();
    }

    //проверки ховер-эффектов, мышь-указатель-----------------------------------------------------------------------------------

    public static void mouseIsPointer(By locator) {
        Assert.assertTrue($(locator).hover().getCssValue("cursor").equalsIgnoreCase("pointer"));
    }

    public static void mouseIsPointer(SelenideElement e) {
        Assert.assertTrue(e.hover().getCssValue("cursor").equalsIgnoreCase("pointer"));
    }

    public static void mouseIsPointer(String path) {
        Assert.assertTrue($(By.xpath(path)).hover().getCssValue("cursor").equalsIgnoreCase("pointer"));
    }

    /**
     * вызывать желательно ДО проверки mouse-pointer
     * чтоб не было проблем прочитать значение атрибута до и после наведения курсора
     */
    public static void checkHoverElement(SelenideElement el, String attribute) {
        Assert.assertNotEquals(el.getCssValue(attribute), el.hover().getCssValue(attribute));
    }

    //получение каких-либо данных-----------------------------------------------------------------------------------

    public static void testGetMethod(String methodName) throws SecurityException, NoSuchMethodException,
            IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        navigation = new Navigation();
        Method method = Navigation.class.getMethod(methodName);
        method.invoke(navigation, new Object[] {});
        Utility.operations.acceptCookies();
    }

    public static int randomInt(int max) {
        return (int) (Math.random() * max);//random [0, max)
    }

    public static String tabTitle() {
        doBefore();
        return driver.getTitle();
    }

    public static int tabsCount() {
        doBefore();
        Set<String> tabs = driver.getWindowHandles();
        return tabs.size();
    }

    public static String currentURL() {
        doBefore();
        return driver.getCurrentUrl();
    }

    public static String curWindow() {
        doBefore();
        return driver.getWindowHandle();
    }

    public static String[] titlesCollection(ElementsCollection c) {
        String[] res = new String[c.size()];
        for (int i = 0; i < c.size(); i++) {
            res[i] = c.get(i).getAttribute("innerText");
        }
        return res;
    }

    public boolean isItWorkTime(Country country) {
        String timeZone = null;
        switch (country) {
            case US:
                timeZone = "GMT-5";
                break;
            case UA:
            case BY:
                timeZone = "GMT+2";
                break;
            case RU://Moscow Standard Time
                timeZone = "GMT+3";
                break;
            case FR:
            case DE:
                timeZone = "GMT+1";
                break;
        }
        final SimpleDateFormat sdfH = new SimpleDateFormat("HH");
        sdfH.setTimeZone(TimeZone.getTimeZone(timeZone));
        int HH = Integer.parseInt(sdfH.format(new Date()));
        return HH >= 9 & HH < 18;
    }

    public static String justOpenedTabGetUrlAndClose(SelenideElement e) {
        doBefore();
        String startTab = driver.getWindowHandle();//сохраним первоначальную вкладку. она имеет право быть не_единственной / не_первой
        String newTab = null;//обявим переменную под вкладку, которая будет открыта по клику на элемент
        Set<String> oldTabs = driver.getWindowHandles();//возьмем сет всех вкладок открытых до
        e.click();//кликнем
        Set<String> newTabs = driver.getWindowHandles();//возьмем сет всех вкладок открытых после
        if (newTabs.size() != oldTabs.size() + 1) {
            Assert.fail("MORE THAN ONE TAB WAS OPENED");//ожидаем, что вкладок стало на одну больше
        }
        for (String tab : newTabs) {
            newTab = tab;//нашли вкладку которой раньше не было
            if (!oldTabs.contains(newTab)) {
                break;
            }
        }
        driver.switchTo().window(newTab);//переключились на новую вкладку
        String result = driver.getCurrentUrl();//взяли УРЛ
        Selenide.closeWindow();//нехорошо делать салат, но WebDriver не умеет закрывать вкаладку
        driver.switchTo().window(startTab);
        return result;
    }//target="blank", если ходить по вкладкам неудобно

    public static By xp(String path) {
        return By.xpath(path);
    }

    public static SelenideElement el(String path) {
        return $(By.xpath(path));
    }

    public static ElementsCollection els(String path) {
        return $$(By.xpath(path));
    }

    //проверка элемента на присутствие/кликабельность/видимость-----------------------------------------------------------------------------------

    public static boolean elementIsIntractable(SelenideElement e) {
        return e.isDisplayed() && e.isEnabled();
    }

    public static boolean isElementPresent(By locator) {
        //https://stackoverflow.com/questions/12270092/best-way-to-check-that-element-is-not-present-using-selenium-webdriver-with-java
        doBefore();
        try {
            driver.findElement(locator);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public static int isElementPresent(String path) {
        //https://stackoverflow.com/questions/12270092/best-way-to-check-that-element-is-not-present-using-selenium-webdriver-with-java
        doBefore();
        ElementsCollection ec = $$(By.xpath(path));
        return ec.size();
    }

    public static void ElementVisible(String path) {
        doBefore();
        SelenideElement e = $(By.xpath(path));
        e.should(Condition.visible);
    }

    //файлы---------------------------------------------------------------------------------------------------------------

    public static boolean isFileDownloaded(String downloadPath, String fileName) {
        //https://stackoverflow.com/questions/30726126/detecting-a-file-downloaded-in-selenium-java
        //com.andersenlab.autotests.core.configs.DriverConfiguration.defaultRemote()
        File dir = new File(downloadPath);
        File[] dirContents = dir.listFiles();
        for (File dirContent : dirContents) {
            if (dirContent.getName().equals(fileName)) {
                dirContent.delete();
                return true;
            }
        }
        return false;
    }

    //непроверенные/неотлаженные методы-----------------------------------------------------------------------------------

    public static void slide(SelenideElement drag, SelenideElement drop) {
        doBefore();
        Actions slide = new Actions(driver);
        slide.dragAndDrop(drag, drop).build().perform();
    }

    @Deprecated
    public static void switchToNewNab() {
        doBefore();
         /*String windowHandle = driver.getWindowHandle();
        //это работает, но нужно иметь каую-то ссылку
        By e = By.xpath("//*[@id='view-all-button']");
        String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
        driver.findElement(e).sendKeys(selectLinkOpeninNewTab);
        Wrap.delay(5);
        String subWindowHandler = null;
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> iterator = handles.iterator();
        while (iterator.hasNext()) {
            subWindowHandler = iterator.next();
            System.out.println(subWindowHandler);
        }
        Wrap.delay(3);
        driver.switchTo().window(subWindowHandler);
        Wrap.delay(3);
        driver.close();
        driver.switchTo().window(windowHandle);*/

        //https://sqa.stackexchange.com/questions/26800/how-to-switch-from-one-tab-to-another-tab-in-chrome
        String url = driver.getCurrentUrl();
        String windowHandle = driver.getWindowHandle();
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
        driver.findElement(By.xpath("/html/body")).sendKeys(Keys.CONTROL + "t");
        driver.get(url);


//        Actions action = new Actions(driver);
//        action.keyDown(Keys.CONTROL).sendKeys("t").build().perform();


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://mail.google.com/");
        String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
        driver.findElement(By.linkText("www.facebook.com")).sendKeys(selectLinkOpeninNewTab);


    }

    public static String allCss(By locator) {
        //https://stackoverflow.com/questions/32537339/getting-the-values-of-all-the-css-properties-of-a-selected-element-in-selenium
        doBefore();
        WebElement we = driver.findElement(locator);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        String script = "var s = '';" +
                "var o = getComputedStyle(arguments[0]);" +
                "for(var i = 0; i < o.length; i++){" +
                "s+=o[i] + ':' + o.getPropertyValue(o[i])+';';}" +
                "return s;";

        return "" + executor.executeScript(script, we);
    }

    @Deprecated
    public static String justOpenedTabUrl() {
        doBefore();
        String oldTab = driver.getWindowHandle();
        String newTab = null;
        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            newTab = handle;
        }
//        newTab = driver.getWindowHandle();
        driver.switchTo().window(newTab);
        String result = driver.getCurrentUrl();
        driver.switchTo().window(oldTab);
        return result;
    }

    public static void scrollToElementByOffset(SelenideElement e, int y) {
        doBefore();//при попытке проскроллиться ниже элемента дает исключение
        Actions action = new Actions(driver);
        action.moveToElement(e).moveByOffset(0, y).build().perform();
    }

    public void scrollToElement(WebElement element) {
        doBefore();
        int y = element.getLocation().getY();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0," + y + ")");
    }

    public void scrollToElement2(By locator) {
        doBefore();
        WebElement element = $(locator);
        int y = element.getLocation().getY();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0," + y + ")");
    }

      // -------------------------------------------------------------------------
    public static void forceClick(SelenideElement e) {
        doBefore();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", e.shouldBe(enabled));
        executor.executeScript("arguments[0].scrollIntoView();", e.shouldBe(visible));
    }
}


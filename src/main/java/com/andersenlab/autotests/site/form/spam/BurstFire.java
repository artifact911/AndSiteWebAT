package com.andersenlab.autotests.site.form.spam;

import com.andersenlab.autotests.core.configs.SelenideConfiguration;
import com.andersenlab.autotests.core.configs.constants.Country;
import com.andersenlab.autotests.core.configs.constants.Resolution;
import com.andersenlab.autotests.core.db.webdb.Db;
import com.andersenlab.autotests.core.utils.PropertiesReader;
import com.andersenlab.autotests.core.utils.utility.Utility;
import com.andersenlab.autotests.site.form.consultation.ConsultationForm;
import com.andersenlab.autotests.site.logic.Navigation;
import com.andersenlab.autotests.site.utility.Logger;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class BurstFire {
    public static void main(String[] args) {
//        burstFire("dev", 2, new ContactUsFooter(), Country.UA);
//        burstFire("dev", 2, new RequestForm(), Country.UA);
        burstFire("site", 2, new ConsultationForm(), Country.UA);
//        burstFire("dev", 2, new Calculator(), Country.UA);// упало после изменения сайта. TODO рефакторинг, не срочно
    }

    public static void burstFire(String place, int quantity, Spamable form, Country country) {
        SelenideConfiguration.configure(Resolution.DESKTOP, country);
        String link;
        switch (place) {
            case "site":
                link = PropertiesReader.get("application.url");
                break;
            case "blog":
                link = PropertiesReader.get("application.blog.url");
                break;
            default:
                throw new IllegalArgumentException("no such location");
        }
        Navigation.gotoLink(link);
        Utility.operations.acceptCookies();
        List<String> names = new ArrayList<>();
        form.precondition();

        for (int i = 0; i < quantity; i++) {
            names.add(form.goodReq(Spamable.MAIL, Spamable.PHONE));
        }

        Logger.getLogger().log("\n-----------------------------------------------Given Names:");
        for (String name : names) {
            System.out.println(name);
        }

        Db db = (place.equals("prod")) ? new Db("CRMuser", "vpidZlll5Bih") : new Db();

        Assert.assertTrue(db.recordsIsPresent(names, Spamable.MAIL, 300));
    }
}

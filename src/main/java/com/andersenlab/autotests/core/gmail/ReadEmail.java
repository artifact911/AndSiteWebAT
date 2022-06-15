package com.andersenlab.autotests.core.gmail;

import com.andersenlab.autotests.core.utils.PropertiesReader;
import com.andersenlab.autotests.site.form.contactusfooterform.ContactUsFooterForm;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.sleep;

import org.testng.Assert;

import javax.mail.*;
import java.io.IOException;
import java.util.Properties;

public class ReadEmail {

    ContactUsFooterForm contactUsFooterForm = new ContactUsFooterForm();

    @Step
    public void readGoogleEmail() throws MessagingException, IOException {

        String host = PropertiesReader.get("application.mail.host");
        String user = PropertiesReader.get("application.mail.user");
        String password = PropertiesReader.get("application.mail.password");
        int messageWaitingTime = 90000;

        Properties prop = System.getProperties();
        prop.setProperty("mail.store.protocol", "imaps");
        prop.setProperty("mail.imaps.ssl.protocols", "TLSv1.2");

        Store store = Session.getInstance(prop).getStore();
        store.connect(host, user, password);

        Folder inbox = store.getFolder("INBOX");
        sleep(messageWaitingTime);
        inbox.open(Folder.READ_WRITE);

        Message message = inbox.getMessage(inbox.getMessageCount());

        String gmailMessage = message.getContent().toString();
        String nameInGmailMessage = gmailMessage.substring(gmailMessage.indexOf("Test"), gmailMessage.indexOf("."));

        Assert.assertEquals(contactUsFooterForm.getValidUserName(), nameInGmailMessage);

        message.setFlag(Flags.Flag.SEEN, true);
        inbox.close(false);
    }
}

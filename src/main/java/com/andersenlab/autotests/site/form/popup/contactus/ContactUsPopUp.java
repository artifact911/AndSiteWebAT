package com.andersenlab.autotests.site.form.popup.contactus;

import com.andersenlab.autotests.site.form.commonforms.FormPopUp;
import lombok.Getter;
import org.testng.Assert;

@Getter
public class ContactUsPopUp implements FormPopUp {

    //устаревшая форма. пользоваться RequestForm с передачей заголовка аргументом. это форма для широкого окна, пример - custom-software-development - Contact us
    private CUElements el = new CUElements();

    @Override
    public void closeReq() {
        el.getButtonClose().click();
    }

    @Override
    public void checkTitle() {
        Assert.assertEquals(el.getTitle().getAttribute("innerText"), "Contact us");
    }

    //FIXME локаторы и элементы собраны, копипаст шаги из кантакт нас футер
    //https://dev.andersenlab.com/services/custom-software-development есть кнопка для контакт нас поп-апом
}

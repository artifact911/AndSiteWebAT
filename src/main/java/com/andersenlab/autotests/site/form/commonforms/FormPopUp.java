package com.andersenlab.autotests.site.form.commonforms;

public interface FormPopUp {
    //интерфейс для передачи разных форм в блоки soft-dev-reach, где требуется нажать кнопку,
    // проверить, что форма правильная и закрыть. полная проверка формы отдельным тестом
    void closeReq();
    void checkTitle();
}

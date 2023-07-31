package ru.netology.diplom_project.test.api;


import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.netology.diplom_project.data.APIHelper;
import ru.netology.diplom_project.data.CardDataGenerator;
import ru.netology.diplom_project.data.DataGenerator;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAPIPaymentCard {

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    //1. Отправка POST запроса платежа с валидно заполненным body и Карта APPROVED на http://localhost:8080/api/v1/pay
    //Ожидаемый результат: статус 200, появление соответствующей записей в БД
    @Test//OK
    @DisplayName("TestAPIPay№ 1 Payment for services with an APPROVED card")
    void paymentForServicesWithApprovedCard() {
        int statusCode = APIHelper.getRequestStatusCodePayment(DataGenerator.generateDataWithApprovedCard());
        assertEquals(200, statusCode);
    }

    //2. Отправка POST запроса платежа с валидно заполненным body и Карта DECLINED на http://localhost:8080/api/v1/pay
    //   Ожидаемый результат: статус 200, появление соответствующей записей в БД
    @Test//OK
    @DisplayName("TestAPIPay№ 2 Payment For Services With Declined Card")
    void paymentForServicesWithDeclinedCard() {
        int statusCode = APIHelper.getRequestStatusCodePayment(DataGenerator.generateDataWithDeclineCard());
        assertEquals(200, statusCode);
    }

    //3. Отправка POST запроса с пустым body на http://localhost:8080/api/v1/pay
    //   Ожидаемый результат: статус 400, в БД не появляются новые записи
    @Test//Баг, код 400 получен, но не обработан, появляется код ошибки 500
    @DisplayName("TestAPIPay№ 3 Payment For Services With Card Empty Fields")
    void paymentForServicesWithCardEmptyFields() {
        int statusCode = APIHelper.getRequestStatusCodePayment(DataGenerator.CardEmptyFields());
        assertEquals(400, statusCode);
    }

    //4. Отправка POST запроса платежа с пустым значением у атрибута number в body (остальные данные заполнены валидно) на http://localhost:8080/api/v1/pay
    //   Ожидаемый результат: статус 400, в БД не появляются новые записи
    @Test//Баг, код 400 получен, но не обработан, появляется код ошибки 500
    @DisplayName("TestAPIPay№ 4 Payment For Services With Card Empty Field Number")
    void paymentForServicesWithCardEmptyFieldNumber() {
        int statusCode = APIHelper.getRequestStatusCodePayment(CardDataGenerator.dataWithCardNumberEmpty());
        assertEquals(400, statusCode);
    }

    //5. Отправка POST запроса платежа с пустым значением у атрибута month в body (остальные данные заполнены валидно) на http://localhost:8080/api/v1/pay
    //   Ожидаемый результат: статус 400, в БД не появляются новые записи
    @Test//БАГ карта с пустым полем месяц попадает в бд, со статусом одобрено
    @DisplayName("TestAPIPay№ 5 Payment For Services With Month Empty Field")
    void paymentForServicesWithCardEmptyFieldMonth() {
        int statusCode = APIHelper.getRequestStatusCodePayment(CardDataGenerator.approvedCardWithMonthEmptyField());
        assertEquals(400, statusCode);
    }

    //6. Отправка POST запроса платежа с пустым значением у атрибута year в body (остальные данные заполнены валидно) на http://localhost:8080/api/v1/pay
    //   Ожидаемый результат: статус 400, в БД не появляются новые записи
    @Test//БАГ карта с пустым полем год попадает в бд, со статусом одобрено
    @DisplayName("TestAPIPay№ 6 Payment For Services With Year Empty Field")
    void paymentForServicesWithCardYearEmptyField() {
        int statusCode = APIHelper.getRequestStatusCodePayment(CardDataGenerator.approvedCardWithYearEmptyField());
        assertEquals(400, statusCode);
    }

    //7. Отправка POST запроса платежа с пустым значением у атрибута holder в body (остальные данные заполнены валидно) на http://localhost:8080/api/v1/pay
    //   Ожидаемый результат: статус 400, в БД не появляются новые записи
    @Test//БАГ карта с пустым полем владелец попадает в бд, со статусом одобрено
    @DisplayName("TestAPIPay№ 7 Payment For Services With Holder Empty Field")
    void paymentForServicesWithCardHolderEmpty() {
        int statusCode = APIHelper.getRequestStatusCodePayment(CardDataGenerator.approvedCardWithHolderEmpty());
        assertEquals(400, statusCode);
    }

    //8. Отправка POST запроса платежа с пустым значением у атрибута cvc в body (остальные данные заполнены валидно) на http://localhost:8080/api/v1/pay
    //      Ожидаемый результат: статус 400, в БД не появляются новые записи
    @Test//БАГ карта с пустым полем cvc попадает в бд, со статусом одобрено
    @DisplayName("TestAPIPay№ 8 Payment For Services With CVC Empty Field")
    void paymentForServicesWithCardCVCEmpty() {
        int statusCode = APIHelper.getRequestStatusCodePayment(CardDataGenerator.approvedCardWithEmptyFieldCVC());
        assertEquals(400, statusCode);
    }

}

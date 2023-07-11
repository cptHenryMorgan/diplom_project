package ru.netology.diplom_project.test.sql;


import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.netology.diplom_project.data.APIHelper;
import ru.netology.diplom_project.data.DataGenerator;
import ru.netology.diplom_project.data.SQLHelper;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TestAPISQL {

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void cleanTable() {
        SQLHelper.cleanDatabase();
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    //1. Отправка POST запроса на кредит с валидно заполненным body и Карта APPROVED на http://localhost:8080/api/v1/credit
    //Ожидаемый результат: статус 200, появление соответствующей записей в БД
    @Test//OK
    @DisplayName("SQLCredit № 1 add Credit data to the database with a valid APPROVED card via API")
    void creditAPIAndSQLHappyPath() {
        var cardInfo = DataGenerator.generateDataWithApprovedCard();
        var statusCode = APIHelper.getRequestStatusCodeCredit(cardInfo);
        var creditCardData = SQLHelper.getCreditCardData();

        assertEquals(200, statusCode);//проверка статуса API карта валидная статус APPROVED, код должен быть 200
        assert creditCardData != null;
        assertEquals("APPROVED", creditCardData.getStatus());//"УТВЕРЖДЕНО", Данные платежной карты. Получить Статус из БД
        assertEquals(200, statusCode, String.valueOf(!Objects.equals(creditCardData.getStatus(), "APPROVED")));
    }

    //2. Отправка POST запроса на кредит с валидно заполненным body и Карта Declined на http://localhost:8080/api/v1/credit
    //Ожидаемый результат: статус 200, появление соответствующей записей в БД
    @Test//OK
    @DisplayName("SQLCredit № 2 Credit For Services With DECLINED Card")
    void creditAPIAndSQLSadPath() {
        var cardInfo = DataGenerator.generateDataWithDeclineCard();
        var statusCode = APIHelper.getRequestStatusCodeCredit(cardInfo);
        var creditCardData = SQLHelper.getCreditCardData();

        assertEquals(200, statusCode);//проверка статуса API карта валидная статус DECLINED, код должен быть 200
        assert creditCardData != null;
        assertEquals("DECLINED", creditCardData.getStatus());//"DECLINED", Данные платежной карты. Получить Статус из БД
        assertEquals(200, statusCode, String.valueOf(!Objects.equals(creditCardData.getStatus(), "DECLINED")));
    }

    //3. Отправка POST запроса на кредит с пустым body на http://localhost:8080/api/v1/credit
    //Ожидаемый результат: статус 400, отсутствие записей в БД
    @Test//Баг, код 400 получен, но не обработан, появляется код ошибки 500
    @DisplayName("SQLCredit № 3 Credit For Services With empty Card")
    void creditForServicesWithEmptyCard() {
        var cardInfo = DataGenerator.CardEmptyFields();
        var statusCode = APIHelper.getRequestStatusCodeCredit(cardInfo);
        var creditCardData = SQLHelper.getCreditCardData();

        assertEquals(400, statusCode);//проверка статуса API карта пустое тело, код должен быть 400
        assertNull(creditCardData);// Получить Статус из БД, нет статуса в БД не должно быть записей null
        assertEquals(400, statusCode, String.valueOf((Object) null));
    }

    //4. Отправка POST запроса платежа с валидно заполненным body и Карта APPROVED на http://localhost:8080/api/v1/pay
    //Ожидаемый результат: статус 200, появление соответствующей записей в БД
    @Test//OK
    @DisplayName("SQLPay № 4 Payment data to the database with a valid APPROVED card via API")
    void paymentAPIAndSQLHappyPath() {
        var cardInfo = DataGenerator.generateDataWithApprovedCard();
        var statusCode = APIHelper.getRequestStatusCodePayment(cardInfo);
        var paymentCardData = SQLHelper.getPaymentCardData();

        assertEquals(200, statusCode);//проверка статуса API карта валидная статус APPROVED, код должен быть 200
        assert paymentCardData != null;
        assertEquals("APPROVED", paymentCardData.getStatus());//"УТВЕРЖДЕНО", Данные платежной карты. Получить Статус из БД
        assertEquals(200, statusCode, String.valueOf(!Objects.equals(paymentCardData.getStatus(), "APPROVED")));

    }

    //5. Отправка POST запроса платежа с валидно заполненным body и Карта DECLINED на http://localhost:8080/api/v1/pay
    //Ожидаемый результат: статус 200, появление соответствующей записей в БД
    @Test//OK
    @DisplayName("SQLPay № 5 Payment data to the database with a valid DECLINED Card via API ")
    void paymentAPIAndSQLSadPath() {
        var cardInfo = DataGenerator.generateDataWithDeclineCard();
        var statusCode = APIHelper.getRequestStatusCodePayment(cardInfo);
        var paymentCardData = SQLHelper.getPaymentCardData();

        assertEquals(200, statusCode);//проверка статуса API карта валидная статус APPROVED, код должен быть 200
        assert paymentCardData != null;
        assertEquals("DECLINED", paymentCardData.getStatus());//"УТВЕРЖДЕНО", Данные платежной карты. Получить Статус из БД
        assertEquals(200, statusCode, String.valueOf(!Objects.equals(paymentCardData.getStatus(), "DECLINED")));
    }

    //6. Отправка POST запроса на кредит с пустым body на http://localhost:8080/api/v1/pay
    //Ожидаемый результат: статус 400, отсутствие записей в БД
    @Test//Баг, код 400 получен, но не обработан, появляется код ошибки 500
    @DisplayName("SQLCredit № 6 Credit For Services With empty Card")
    void paymentForServicesWithEmptyCard() {
        var cardInfo = DataGenerator.CardEmptyFields();
        var statusCode = APIHelper.getRequestStatusCodePayment(cardInfo);
        var creditCardData = SQLHelper.getPaymentCardData();

        assertEquals(400, statusCode);//проверка статуса API карта пустое тело, код должен быть 400
        assertNull(creditCardData);// Получить Статус из БД, нет статуса в БД не должно быть записей null
        assertEquals(400, statusCode, String.valueOf((Object) null));
    }
}
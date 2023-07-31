package ru.netology.diplom_project.test.sql;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.awaitility.Awaitility;
import org.junit.jupiter.api.*;
import ru.netology.diplom_project.data.DataGenerator;
import ru.netology.diplom_project.data.SQLHelper;
import ru.netology.diplom_project.page.MainPage;
import ru.netology.diplom_project.page.PayPage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TestUISQL {

    MainPage mainPage = new MainPage();
    PayPage payPage = new PayPage();

    @BeforeEach
    public void openSource() {
        open("http://localhost:8080");

    }

    @BeforeAll
    static void setUpAll() {
        Awaitility.setDefaultTimeout(Duration.ofSeconds(25));
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

    //ОПЛАТА КАРТОЙ

    //    Успешная оплата тура "Путешествие дня" при валидном заполнение полей формы "Оплата по карте" по действующей карте
    //    (номер карты заполнен с пробелами после каждых 4 символов) Ожидаемый результат: появление сообщения об успешной оплате тура
    @Test//OK
    @DisplayName("TestUISQL № 1 CardPaymentHappyPath")
    public void cardPaymentHappyPath() {
        mainPage.choosePaymentCard();//выбрать оплату по карте
        payPage.fillCardData(DataGenerator.generateDataWithApprovedCard());//форму заполнить валидно картой с согласием

        Awaitility.await().until(() -> SQLHelper.getPaymentCardData() != null);
        var paymentCardData = SQLHelper.getPaymentCardData();

        Assertions.assertNotNull(paymentCardData, "paymentCardData is null");
        assertEquals("APPROVED", paymentCardData.getStatus());//"УТВЕРЖДЕНО", Данные платежной карты. Получить Статус из БД
    }

    // При валидном заполнении полей формы "Оплата по карте" по declined карте
    // Ожидаемый результат: появление сообщения в БД с "DECLINED", Данные платежной карты
    @Test//OK
    @DisplayName("TestUISQL № 2 CardPaymentSadPath")
    public void cardPaymentSadPath() {
        mainPage.choosePaymentCard();//выбрать оплату по карте
        payPage.fillCardData(DataGenerator.generateDataWithDeclineCard());//форму заполнить валидно картой с отказом

        var paymentCardData = SQLHelper.getPaymentCardData();

        Assertions.assertNotNull(paymentCardData, "paymentCardData is null");
        assertEquals("DECLINED", paymentCardData.getStatus());//"DECLINED", Данные платежной карты. Получить Статус из БД
    }

    // При пустых полях формы "Оплата по карте"
    // Ожидаемый результат: нет записей в БД
    @Test//OK
    @DisplayName("TestUISQL № 3 CardPaymentEmptyPath")
    public void cardPaymentEmptyPath() {
        mainPage.choosePaymentCard();//выбрать оплату по карте

        payPage.fillCardData(DataGenerator.CardEmptyFields());//пустая форма

        var paymentCardData = SQLHelper.getPaymentCardData();
        assertNull(paymentCardData);// Получить Статус из БД нет записей
    }

    //КРЕДИТ ПО ДАННЫМ КАРТЫ

    // Успешная оплата тура "Путешествие дня" при валидном заполнение полей формы "Оплата по карте" по действующей карте
    // (номер карты заполнен с пробелами после каждых 4 символов) Ожидаемый результат: появление сообщения об успешной оплате тура
    @Test//OK
    @DisplayName("TestUISQL № 4 credit On Card Happy Path")
    public void creditOnCardHappyPath() {
        mainPage.chooseCreditOnCard();//выбрать кредит по карте
        payPage.fillCardData(DataGenerator.generateDataWithApprovedCard());//форму заполнить валидно картой с согласием

        var creditOnCardData = SQLHelper.getCreditCardData();

        Assertions.assertNotNull(creditOnCardData, "creditOnCardData is null");
        assertEquals("APPROVED", creditOnCardData.getStatus());//"УТВЕРЖДЕНО", Данные платежной карты. Получить Статус из БД
    }

    // При валидном заполнение полей формы "Оплата по карте" по declined карте
    // Ожидаемый результат: появление сообщения в БД с "DECLINED", Данные платежной карты
    @Test//OK
    @DisplayName("TestUISQL № 5 credit On Card Sad Path")
    public void creditOnCardSadPath() {
        mainPage.chooseCreditOnCard();//выбрать кредит по карте
        payPage.fillCardData(DataGenerator.generateDataWithDeclineCard());//форму заполнить валидно картой с отказом

        var creditOnCardData = SQLHelper.getCreditCardData();

        Assertions.assertNotNull(creditOnCardData, "creditOnCardData is null");
        assertEquals("DECLINED", creditOnCardData.getStatus());//"DECLINED", Данные платежной карты. Получить Статус из БД
    }

    // При пустых полях формы "Оплата по карте"
    // Ожидаемый результат: нет записей в БД
    @Test//OK
    @DisplayName("TestUISQL № 6 credit On Card Empty Path")
    public void creditOnCardEmptyPath() {
        mainPage.chooseCreditOnCard();//выбрать кредит по карте

        payPage.fillCardData(DataGenerator.CardEmptyFields());//пустая форма

        var creditOnCardData = SQLHelper.getCreditCardData();
        assertNull(creditOnCardData);// Получить Статус из БД нет записей
    }
}

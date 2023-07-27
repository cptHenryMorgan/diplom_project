package ru.netology.diplom_project.test.ui;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.val;
import org.junit.jupiter.api.*;
import ru.netology.diplom_project.data.DataGenerator;
import ru.netology.diplom_project.data.SQLHelper;
import ru.netology.diplom_project.page.MainPage;
import ru.netology.diplom_project.page.PayPage;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;

public class TestUIAllFields {

    MainPage mainPage = new MainPage();
    PayPage payPage = new PayPage();

    @BeforeEach
    public void openSource() {
        open("http://localhost:8080");

    }

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    void setUpChoosePaymentCard() throws InterruptedException {
        mainPage.choosePaymentCard();//выбрать оплату по карте
        TimeUnit.SECONDS.sleep(6);//ожидание
    }

    @BeforeEach
    public void cleanTable() {
        SQLHelper.cleanDatabase();
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    //1. Успешный переход на оплату картой
    @Test//OK
    @DisplayName("Test№ 1 successful transition to card payment")
    void shouldGetPaymentPage() {
        val mainPage = new MainPage();
        mainPage.choosePaymentCard();
    }

    // 2. Успешный переход на оформление кредита
    @Test//OK
    @DisplayName("Test№ 2 successful transition to credit card ")
    void shouldGetCreditPage() {
        val mainPage = new MainPage();
        mainPage.chooseCreditOnCard();
    }

    //3. Успешная оплата тура "Путешествие дня" при валидном заполнении полей формы "Оплата по карте" по действующей карте
    //    (номер карты заполнен с пробелами после каждых 4 символов) Ожидаемый результат: появление сообщения об успешной оплате тура
    @Test//OK
    @DisplayName("Test№ 3 CardPaymentHappyPath")
    public void cardPaymentHappyPath() {

        payPage.fillCardData(DataGenerator.generateDataWithApprovedCard());//форму заполнить валидной картой с согласием

        payPage.shouldNotNotification();//отсутствие сообщения при валидном заполнении
        payPage.shouldSuccessNotification();//сообщение одобрения банком
    }

    //4. Отказ в оплате тура "Путешествие дня" при валидном заполнении полей формы "Оплата по карте" по declined карте
    //    (номер карты заполнен с пробелами после каждых 4 символов) Ожидаемый результат: появление сообщения об отказе в оплате тура
    @Test//Баг карта с отказом выдает согласие
    @DisplayName("Test№ 4 CardPaymentSadPath")
    public void cardPaymentSadPath() {

        payPage.fillCardData(DataGenerator.generateDataWithDeclineCard());//форму заполнить валидно картой с отказом

        payPage.shouldNotNotification();//отсутствие сообщения при валидном заполнении
        payPage.shouldFailureNotification();//отказ банком
    }

    //5. Успешная оплата в кредит тура "Путешествие дня" при валидном заполнении полей формы "Кредит по данным карты" по действующей карте
    //    (номер карты заполнен с пробелами после каждых 4 символов) Ожидаемый результат: появление сообщения об успешной взятии кредита
    @Test//OK
    @DisplayName("Test№ 5 Payment On Credit Happy Path")
    public void paymentOnCreditHappyPath() {

        payPage.fillCardData(DataGenerator.generateDataWithApprovedCard());//форму заполнить валидно картой с согласием

        payPage.shouldSuccessNotification();//сообщение одобрения банком
    }

    //6. Отказ в кредите на покупку тура "Путешествие дня" при валидном заполнении полей формы "Кредит по данным карты" по declined карте
    //    (номер карты заполнен с пробелами после каждых 4 символов) Ожидаемый результат: появление сообщения об отказе во взятие кредита
    @Test//Баг по карте с отказом банк выдает согласие
    @DisplayName("Test№ 6 paymentOnCreditSadPath")
    public void paymentOnCreditSadPath() {

        payPage.fillCardData(DataGenerator.generateDataWithDeclineCard());//форму заполнить валидно картой с отказом

        payPage.shouldFailureNotification();//отказ банком
    }

    //7. Заполнение всех полей валидными данными формы "Оплата по карте" тура "Путешествие дня" с последующим переключением на форму
    //    "Кредит по данным карты" Ожидаемый результат: форма переключиться, поля останутся заполненными теми же данными
    @Test//Баг форма очищается
    @DisplayName("Test№ 7 Switching from a completed card payment form to a credit, card data is not reset")
    public void switchingCardPaymentToCreditDataNotResetData() {

        payPage.fillCardData(DataGenerator.generateDataWithApprovedCard());//форму заполнить валидной картой с согласием
        mainPage.chooseCreditOnCard();//выбрать кредит по карте
        payPage.continueButton.click();

        payPage.shouldSuccessNotification();//сообщение одобрения банком
    }

    //8. Заполнение всех полей валидными данными формы "Кредит по данным карты" тура "Путешествие дня" с последующим переключением
    //    на форму "Оплата по карте" Ожидаемый результат: форма переключиться, поля останутся заполненными теми же данными
    @Test//OK
    @DisplayName("Test№ 8 Switching from credit according to card data to Payment by card without data reset")
    public void switchingCreditToCardPaymentNotResetData() {

        payPage.fillCardData(DataGenerator.generateDataWithApprovedCard());//форму заполнить валидной картой с согласием
        mainPage.choosePaymentCard();//выбрать кредит по карте
        payPage.continueButton.click();

        payPage.shouldSuccessNotification();//сообщение одобрения банком
    }

    //9. Оставление всех полей пустыми Ожидаемый результат: под всеми полями появиться предупреждение о пустом поле, невозможно отправить форму
    @Test//Баг надписи не соответствуют
    @DisplayName("Test№ 9 All field empty should Empty Field Notification")
    public void shouldNotificationEmptyField() {

        payPage.fillCardData(DataGenerator.CardEmptyFields());

        payPage.shouldEmptyFieldNotification();
        payPage.shouldImproperFormatNotificationHidden();
    }

    //10. Заполнение всех полей валидными данными после попытки отправки пустой формы, предупреждения должны исчезать
    @Test//Баг надписи не исчезают
    @DisplayName("Test№ 10 No notification about empty field below fields after entering valid data")
    public void shouldNotNotificationValidDataField() {

        payPage.continueButton.click();
        payPage.fillCardData(DataGenerator.generateDataWithApprovedCard());

        payPage.shouldNotNotification();

    }
}

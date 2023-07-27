package ru.netology.diplom_project.test.ui;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.netology.diplom_project.data.SQLHelper;
import ru.netology.diplom_project.data.helpers.NumberHelper;
import ru.netology.diplom_project.page.MainPage;
import ru.netology.diplom_project.page.PayPage;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;

public class TestUINumberField {

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

    //1. Заполнение поля "Номер карты" номером действующей карты без пробелов, остальные поля заполнены валидно в форме "Оплата по карте" тура "Путешествие дня"
    //   Ожидаемый результат: появление сообщения об успешной оплате тура
    @Test//OK
    @DisplayName("CardNumber Test№ 1 Card Number Without Spaces")
    public void dataWithApprovedCardNumberWithoutSpaces() {
        payPage.fillCardData(NumberHelper.dataWithApprovedCardNumberWithoutSpaces());//поля заполнены валидно, номером действующей карты без пробелов

        payPage.shouldSuccessNotification();//сообщение одобрения банком
    }

    //2. Заполнение поля "Номер карты" 1 рандомной цифрой, остальные поля заполнены валидно в форме "Оплата по карте" тура "Путешествие дня"
    //   Ожидаемый результат: под полем "Номер карты" появиться предупреждение о недопустимой длине поля
    @Test//OK
    @DisplayName("CardNumber Test№ 2 Card Number 1 random digit")
    public void dataWithCardNumberOneRandomDigit() {
        payPage.fillCardData(NumberHelper.dataWithCardNumberOneRandomDigit());//поля заполнены валидно, номером действующей карты 1 цифра

        payPage.shouldImproperFormatNotification();//видимое Сообщение Неверный формат
    }

    //3. Заполнение поля "Номер карты" 15 рандомными цифрами, остальные поля заполнены валидно в форме "Оплата по карте" тура "Путешествие дня"
    //   Ожидаемый результат: появление сообщения об отказе в оплате тура
    @Test//OK
    @DisplayName("CardNumber Test№ 3 Card Number 15 random digit")
    public void dataWithCardNumber15RandomDigit() {
        payPage.fillCardData(NumberHelper.dataWithCardNumber_15_RandomDigit());//поля заполнены валидно, номером действующей карты 15 цифра

        payPage.shouldImproperFormatNotification();//видимое Сообщение Неверный формат
    }

    //4. Заполнение поля "Номер карты" 17 рандомными цифрами, остальные поля заполнены валидно в форме "Оплата по карте" тура "Путешествие дня"
    //   Ожидаемый результат: появление сообщения об отказе в оплате тура
    @Test//ОК
    @DisplayName("CardNumber Test№ 4 Card Number 17 random digit")
    public void dataWithCardNumber17RandomDigit() {
        payPage.fillCardData(NumberHelper.dataWithCardNumber_17_RandomDigit());//поля заполнены валидно, номером действующей карты 17 цифра

        payPage.shouldFailureNotification();//Сообщение видимое Операция отклонена Банком
    }

    //5. Заполнение поля "Номер карты" 16 нулями, остальные поля заполнены валидно в форме "Оплата по карте" тура "Путешествие дня"
    //   Ожидаемый результат: под полем "Номер карты" появиться сообщения о появление сообщения об отказе в оплате тура
    @Test//Баг два сообщения
    @DisplayName("CardNumber Test№ 5 Card Number 16 zero")
    public void dataWithCardNumber16Zero() {
        payPage.fillCardData(NumberHelper.dataWithCardNumber_16_zero());//поля заполнены валидно, номером действующей карты 16 zero

        payPage.shouldFailureNotification();//Сообщение видимое Операция отклонена Банком
        payPage.shouldSuccessNotificationHidden();//Сообщение операция Одобрена не должно быть видимым
    }

    //6. Заполнение поля "Номер карты" 16 рандомными спецсимволами, остальные поля заполнены валидно в форме "Оплата по карте" тура "Путешествие дня"
    //   Ожидаемый результат: под полем "Номер карты" появиться предупреждение об недопустимых символах
    @Test//OK
    @DisplayName("CardNumber Test№ 6 Card Number 16 Symbols")
    public void dataWithCardNumber16Symbols() {
        payPage.fillCardData(NumberHelper.dataWithCardNumberWith_16_Symbols());//поля заполнены валидно, номером действующей карты 16 Symbols

        payPage.shouldImproperFormatNotification();//видимое Сообщение Неверный формат
    }

    //7. Заполнение поля "Номер карты" 16 рандомными буквами латиницы, остальные поля заполнены валидно в форме "Оплата по карте" тура "Путешествие дня"
    //   Ожидаемый результат: под полем "Номер карты" появиться предупреждение об недопустимых символах
    @Test//OK
    @DisplayName("CardNumber Test№ 7 Card Number 16 WithLatin")
    public void dataWithCardNumberWithLatin() {
        payPage.fillCardData(NumberHelper.dataWithCardNumberWith_16_Latin());//поля заполнены валидно, номером действующей карты 16 Latin

        payPage.shouldImproperFormatNotification();//видимое Сообщение Неверный формат
    }

    //8. Заполнение поля "Номер карты" 16 рандомными буквами кириллицы, остальные поля заполнены валидно в форме "Оплата по карте" тура "Путешествие дня"
    //   Ожидаемый результат: под полем "Номер карты" появиться предупреждение об недопустимых символах
    @Test//OK
    @DisplayName("CardNumber Test№ 8 Card Number 16 WithCyrillic")
    public void dataWithCardNumberWithCyrillic() {
        payPage.fillCardData(NumberHelper.dataWithCardNumberWith_16_Cyrillic());//поля заполнены валидно, номером действующей карты 16 Cyrillic

        payPage.shouldImproperFormatNotification();//видимое Сообщение Неверный формат
    }

    //9. Заполнение поля "Номер карты" действующей карты с пробелами в начале и конце, остальные поля заполнены валидно в форме "Оплата по карте" тура "Путешествие дня"
    //   Ожидаемый результат: появление сообщения об успешной оплате тура
    @Test//OK
    @DisplayName("CardNumber Test№ 9 Card Number With Start And End Spaces")
    public void dataWithCardNumberWithStartAndEndSpaces() {
        payPage.fillCardData(NumberHelper.dataWithCardNumberWithStartAndEndSpaces());//поля заполнены валидно, номером действующей карты 16 WithoutStartAndEndSpaces

        payPage.shouldSuccessNotification();//сообщение одобрения банком
    }
    //10. Заполнение поля "Номер карты" c запятыми, остальные поля заполнены валидно в форме "Оплата по карте" тура "Путешествие дня"
    //   Ожидаемый результат: под полем "Номер карты" появиться предупреждение об недопустимых символах
    @Test//OK
    @DisplayName("CardNumber Test№ 10 Card Number With Commas")
    public void dataWithCardNumberWithCommas() {
        payPage.fillCardData(NumberHelper.dataWithCardNumberWithCommas());//поля заполнены валидно, номером действующей карты 16 цифры разделены запятыми

        payPage.shouldFailureNotification();//сообщение отказ банком
    }
}

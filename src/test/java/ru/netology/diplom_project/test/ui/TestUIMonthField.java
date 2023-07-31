package ru.netology.diplom_project.test.ui;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.netology.diplom_project.data.CardDataGenerator;
import ru.netology.diplom_project.data.SQLHelper;
import ru.netology.diplom_project.page.MainPage;
import ru.netology.diplom_project.page.PayPage;


import static com.codeborne.selenide.Selenide.open;

public class TestUIMonthField {

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
    void setUpChoosePaymentCard() {
        mainPage.choosePaymentCard();//выбрать оплату по карте
    }

    @BeforeEach
    public void cleanTable() {
        SQLHelper.cleanDatabase();
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    //1. Заполнение поля "Месяц" 3 цифрами(12 и одна дополнительная), остальные поля заполнены валидно в форме "Оплата по карте" тура "Путешествие дня"
    //   Ожидаемый результат: обрезание последней цифры в поле "Месяц", появление сообщения об успешной оплате тура
    @Test//OK
    @DisplayName("Month Test№ 1 approved Card With Month Of 3numbers")
    public void approvedCardWithMonthOf3numbers() {
        payPage.fillCardData(CardDataGenerator.approvedCardWithMonthOfThreeNumbers());

        payPage.shouldSuccessNotification();//Операция одобрена Банком
    }

    //2. Заполнение поля "Месяц" значением 00, остальные поля заполнены валидно в форме "Оплата по карте" тура "Путешествие дня"
    //   Ожидаемый результат: под полем "Месяц" появиться предупреждение о невалидном значение
    @Test//Баг система допускает введение 00 в поле месяц, нет сообщения о невалидном значении
    @DisplayName("Month Test№ 2 approved Card With Month Of 00 numbers")
    public void approvedCardWithMonthOf00numbers() {
        payPage.fillCardData(CardDataGenerator.approvedCardWithMonthOf_00_numbers());

        payPage.shouldInvalidExpiredDateNotification();//Неверно указан срок действия карты
    }

    //3. Заполнение поля "Месяц" значением из 1 цифры, остальные поля заполнены валидно в форме "Оплата по карте" тура "Путешествие дня"
    //   Ожидаемый результат: автодополнение нулем вначале в поле "Месяц", появление сообщения об успешной оплате тура
    @Test//Баг нет автодополнения
    @DisplayName("Month Test№ 3 approved Card With Month Of 1 number")
    public void approvedCardWithMonthOf1numbers() {
        payPage.fillCardData(CardDataGenerator.approvedCardWithMonthOfOneNumber());

        payPage.shouldSuccessNotification();//Операция одобрена Банком
    }

    //4. Заполнение поля "Месяц" значением 12, остальные поля заполнены валидно в форме "Оплата по карте" тура "Путешествие дня"
    //   Ожидаемый результат: появление сообщения об успешной оплате тура
    @Test//OK
    @DisplayName("Month Test№ 4 approved Card With Month Of 12 number")
    public void approvedCardWithMonthOf12numbers() {
        payPage.fillCardData(CardDataGenerator.approvedCardWithMonthOf_12_numbers());

        payPage.shouldSuccessNotification();//Операция одобрена Банком
    }

    //5. Заполнение поля "Месяц" значением 13, остальные поля заполнены валидно в форме "Оплата по карте" тура "Путешествие дня"
    //   Ожидаемый результат: под полем "Месяц" появиться предупреждение об невалидном значение
    @Test//OK
    @DisplayName("Month Test№ 5 approved Card With Month Of 13 number")
    public void approvedCardWithMonthOf13numbers() {
        payPage.fillCardData(CardDataGenerator.approvedCardWithMonthOf_13_numbers());

        payPage.shouldInvalidExpiredDateNotification();//Неверно указан срок действия карты
    }

    //6. Заполнение поля "Месяц" двумя рандомными спецсимволами, остальные поля заполнены валидно в форме "Оплата по карте" тура "Путешествие дня"
    //   Ожидаемый результат: под полем "Месяц" появиться предупреждение об невалидном значение
    @Test//OK
    @DisplayName("Month Test№ 6 approved Card With Month Of 2 symbols")
    public void approvedCardWithMonthOf2symbols() {
        payPage.fillCardData(CardDataGenerator.approvedCardWithMonthOfTwoSymbols());

        payPage.shouldImproperFormatNotification();//отображение сообщения Неверный формат
    }

    //7. Заполнение поля "Месяц" буквами латиницы, остальные поля заполнены валидно в форме "Оплата по карте" тура "Путешествие дня"
    //   Ожидаемый результат: под полем "Месяц" появиться предупреждение об недопустимых символах
    @Test//OK
    @DisplayName("Month Test№ 7 approved Card With Month Of 2 Latin")
    public void approvedCardWithMonthOf2Latin() {
        payPage.fillCardData(CardDataGenerator.approvedCardWithMonthOfTwoLatinLetters());

        payPage.shouldImproperFormatNotification();//отображение сообщения Неверный формат
    }

    //8. Заполнение поля "Месяц" буквами кириллицы, остальные поля заполнены валидно в форме "Оплата по карте" тура "Путешествие дня"
    //   Ожидаемый результат: под полем "Месяц" появиться предупреждение об недопустимых символа
    @Test//OK
    @DisplayName("Month Test№ 8 approved Card With Month Of 2 Cyrillic")
    public void approvedCardWithMonthOf2Cyrillic() {
        payPage.fillCardData(CardDataGenerator.approvedCardWithMonthOfTwoCyrillicLetters());

        payPage.shouldImproperFormatNotification();//отображение сообщения Неверный формат
    }
}

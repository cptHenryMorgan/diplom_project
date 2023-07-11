package ru.netology.diplom_project.test.ui;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.netology.diplom_project.data.SQLHelper;
import ru.netology.diplom_project.data.helpers.CVCHelper;
import ru.netology.diplom_project.page.MainPage;
import ru.netology.diplom_project.page.PayPage;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;

public class TestUICVCField {

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

    //1. Заполнение поля "CVC/CVV" 1 рандомной цифрой, остальные поля заполнены валидно в форме "Оплата по карте" тура "Путешествие дня"
    //   Ожидаемый результат: под полем "CVC/CVV" появление сообщения о недопустимой длине
    @Test//Баг сообщения
    @DisplayName("CVC Test№ 1 approved Card With CVC With 1 Digit")
    public void approvedCardWithCVCWith1Digit() {
        payPage.fillCardData(CVCHelper.approvedCardWithCVCWithOneDigit());//поля заполнены валидно, номером CVC 1 цифра

        payPage.shouldEmptyFieldNotification();//видимое Сообщение поле обязательно для заполнения
    }


    //2. Заполнение поля "CVC/CVV" 4 рандомными цифрами, остальные поля заполнены валидно в форме "Оплата по карте" тура "Путешествие дня"
    //   Ожидаемый результат: 4 цифра в поле "CVC/CVV" обрезается
    @Test//ОК
    @DisplayName("CVC Test№ 2 approved Card With CVC With 4 Digit")
    public void approvedCardWithCVCWith4Digit() {
        payPage.fillCardData(CVCHelper.approvedCardWithCVCWithFourDigit());//поля заполнены валидно, номером CVC 4 цифра

        payPage.shouldSuccessNotification();//видимое Сообщение 'успешно', CVC обрезан до 3х символов
    }

    //3. Заполнение поля "CVC/CVV" 3 рандомными буквами латиницы, остальные поля заполнены валидно в форме "Оплата по карте" тура "Путешествие дня"
    //   Ожидаемый результат: под полем "CVC/CVV" появление сообщения о невалидном значение
    @Test//ОК
    @DisplayName("CVC Test№ 3 approved Card With CVC With 3 Latin")
    public void approvedCardWithCVCWith3Latin() {
        payPage.fillCardData(CVCHelper.approvedCardWithCVCWithThreeSymbolsOfLatin());//поля заполнены валидно, номером CVC 3Latin

        payPage.shouldImproperFormatNotification();//видимое отображение сообщения Неверный формат
    }

    //4. Заполнение поля "CVC/CVV" 3 рандомными буквами кириллицы, остальные поля заполнены валидно в форме "Оплата по карте" тура "Путешествие дня"
    //   Ожидаемый результат: под полем "CVC/CVV" появление сообщения о невалидном значение
    @Test//ОК
    @DisplayName("CVC Test№ 4 approved Card With CVC With 3 Cyrillic")
    public void approvedCardWithCVCWith3Cyrillic() {
        payPage.fillCardData(CVCHelper.approvedCardWithCVCWithThreeSymbolsOfCyrillic());//поля заполнены валидно, номером CVC 3 Cyrillic

        payPage.shouldImproperFormatNotification();//видимое отображение сообщения Неверный формат
    }

    //5. Заполнение поля "CVC/CVV" 3 рандомными спецсимволами, остальные поля заполнены валидно в форме "Оплата по карте" тура "Путешествие дня"
    //   Ожидаемый результат: под полем "CVC/CVV" появление сообщения о невалидном значение
    @Test//ОК
    @DisplayName("CVC Test№ 5 approved Card With CVC With 3 Symbols")
    public void approvedCardWithCVCWith3Symbols() {
        payPage.fillCardData(CVCHelper.approvedCardWithCVCWithThreeSymbols());//поля заполнены валидно, номером CVC из 3 символов

        payPage.shouldImproperFormatNotification();//видимое отображение сообщения Неверный формат
    }

    //6. Пустое поля "CVC/CVV", остальные поля заполнены валидно в форме "Оплата по карте" тура "Путешествие дня"
    //   Ожидаемый результат: под полем "CVC/CVV" появление сообщения поле обязательно для заполнения
    @Test//Баг подписи
    @DisplayName("CVC Test№ 6 approved Card With CVC Empty")
    public void approvedCardWithCVCEmpty() {
        payPage.fillCardData(CVCHelper.approvedCardWithEmptyFieldCVC());//поля заполнены валидно, номером CVC из 3 симвлов

        payPage.shouldImproperFormatNotificationHidden();//не видимое сообщения Неверный формат
        payPage.shouldEmptyFieldNotification();//видимое Сообщение поле обязательно для заполнения
    }
}

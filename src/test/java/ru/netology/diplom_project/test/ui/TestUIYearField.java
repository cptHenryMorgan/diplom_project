package ru.netology.diplom_project.test.ui;


import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.netology.diplom_project.data.SQLHelper;
import ru.netology.diplom_project.data.helpers.YearHelper;
import ru.netology.diplom_project.page.MainPage;
import ru.netology.diplom_project.page.PayPage;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;

public class TestUIYearField {

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

    //1. Оставление поля "Год" пустым, остальные поля заполнены валидно в форме "Оплата по карте" тура "Путешествие дня"
    //   Ожидаемый результат: под полем "Год" появиться предупреждение о пустом поле
    @Test//Баг подпись поля неверный формат
    @DisplayName("Year Test№ 1 approved Card With Year Empty Field")
    public void approvedCardWithYearOEmptyField() {
        payPage.fillCardData(YearHelper.approvedCardWithYearEmptyField());

        payPage.shouldEmptyFieldNotification();//Сообщение Поле обязательно для заполнения
    }

    //2. Заполнение поля "Год" предыдущим годом, остальные поля заполнены валидно в форме "Оплата по карте" тура "Путешествие дня"
    //   Ожидаемый результат: под полем "Год" появиться предупреждение об невалидном значение
    @Test//OK
    @DisplayName("Year Test№ 2 approved Card With Last Year")
    public void approvedCardWithLastYear() {
        payPage.fillCardData(YearHelper.approvedCardWithLastYear());

        payPage.shouldExpiredDatePassNotification();//Истёк срок действия карты
    }

    //3. Заполнение поля "Год" текущим годом, а поля "Месяц" предыдущим месяцем, остальные поля заполнены валидно* в форме "Оплата по карте" тура "Путешествие дня"
    //   Ожидаемый результат: под полем "Месяц" появиться предупреждение об невалидном значение
    @Test//OK
    @DisplayName("Year Test№ 3 approved Card With Valid Year Las tMonth")
    public void approvedCardWithValidYearLastMonth() {
        payPage.fillCardData(YearHelper.approvedCardWithValidYearLastMonth());

        payPage.shouldInvalidExpiredDateNotification();//Неверно указан срок действия карты
    }

    //4. Заполнение поля "Год" 1 цифрой, остальные поля заполнены валидно в форме "Оплата по карте" тура "Путешествие дня"
    //   Ожидаемый результат: под полем "Год" появиться предупреждение о невалидном значение
    @Test//Баг подпись поля неверный формат
    @DisplayName("Year Test№ 4 approved Card With Year Of 1 number")
    public void approvedCardWithYearOf1numbers() {
        payPage.fillCardData(YearHelper.approvedCardWithYearWithOneNumber());

        payPage.shouldInvalidExpiredDateNotification();//Сообщение Неверно указан срок действия карты
    }

    //5. Заполнение поля "Год" 2017, остальные поля заполнены валидно в форме "Оплата по карте" тура "Путешествие дня"
    //   Ожидаемый результат: истёк срок действия карты
    @Test//OK
    @DisplayName("Year Test№ 5 approved Card With Year 2017")
    public void approvedCardWithYear2017() {
        payPage.fillCardData(YearHelper.approvedCardWithYear2017());

        payPage.shouldExpiredDatePassNotification();//истёк срок действия карты
    }

    //6. Заполнение поля "Год" плюс 6 лет к текущему году, остальные поля заполнены валидно в форме "Оплата по карте" тура "Путешествие дня"
    //   Ожидаемый результат: под полем "Год" появиться предупреждение об невалидном значение, срок действия карты истек
    @Test//OK
    @DisplayName("Year Test№ 6 approved Card Year Plus 6")
    public void approvedCardYearPlus6() {
        payPage.fillCardData(YearHelper.approvedCardYearPlusSix());

        payPage.shouldInvalidExpiredDateNotification();//Неверно указан срок действия карты
    }

    //7. Заполнение поля "Год" рандомными спецсимволами, остальные поля заполнены валидно в форме "Оплата по карте" тура "Путешествие дня"
    //   Ожидаемый результат: под полем "Год" появиться предупреждение об невалидном значение
    @Test//OK
    @DisplayName("Year Test№ 7 approved Card With Year Of 2 symbols")
    public void approvedCardWithYearOf2symbols() {
        payPage.fillCardData(YearHelper.approvedCardWithYearWithTwoSymbols());

        payPage.shouldImproperFormatNotification();//отображение сообщения Неверный формат
    }

    //8. Заполнение поля "Год" буквами латиницы, остальные поля заполнены валидно в форме "Оплата по карте" тура "Путешествие дня"
    //   Ожидаемый результат: под полем "Год" появиться предупреждение об недопустимых символах
    @Test//OK
    @DisplayName("Year Test№ 8 approved Card With Year Of 2 Latin")
    public void approvedCardWithYearOf2Latin() {
        payPage.fillCardData(YearHelper.approvedCardWithYearWithTwoLatinLetters());

        payPage.shouldImproperFormatNotification();//отображение сообщения Неверный формат
    }

    //9. Заполнение поля "Год" буквами кириллицы, остальные поля заполнены валидно в форме "Оплата по карте" тура "Путешествие дня"
    //   Ожидаемый результат: под полем "Год" появиться предупреждение об недопустимых символах
    @Test//ОК
    @DisplayName("Year Test№ 9 approved Card With Year Of 2 Cyrillic")
    public void approvedCardWithYearOf2Cyrillic() {
        payPage.fillCardData(YearHelper.approvedCardWithYearWithTwoCyrillicLetters());

        payPage.shouldImproperFormatNotification();//отображение сообщения Неверный формат
    }

    //10. Заполнение поля "Год" 00, остальные поля заполнены валидно в форме "Оплата по карте" тура "Путешествие дня"
    //   Ожидаемый результат: истёк срок действия карты
    @Test//OK
    @DisplayName("Year Test№ 10 approved Card With 00 numbers")
    public void approvedCardWithYearWith_00_numbers() {
        payPage.fillCardData(YearHelper.approvedCardWithYearWith_00_numbers());

        payPage.shouldExpiredDatePassNotification();//Истек срок действия карты
    }

}

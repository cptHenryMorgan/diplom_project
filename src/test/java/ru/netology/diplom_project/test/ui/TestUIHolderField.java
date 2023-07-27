package ru.netology.diplom_project.test.ui;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.netology.diplom_project.data.SQLHelper;
import ru.netology.diplom_project.data.helpers.HolderHelper;
import ru.netology.diplom_project.page.MainPage;
import ru.netology.diplom_project.page.PayPage;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;

public class TestUIHolderField {

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

    //1. Заполнение поля "Владелец" валидными данными с дефисом, остальные поля заполнены валидно в форме "Оплата по карте" тура "Путешествие дня"
    //   Ожидаемый результат: появление сообщения об успешной оплате тура
    @Test//ОК
    @DisplayName("Holder Test№ 1 Approved Card With Double Last Name")
    public void approvedCardWithDoubleLastName() {
        payPage.fillCardData(HolderHelper.approvedCardWithDoubleLastName());

        payPage.shouldSuccessNotification();
    }

    //2. Заполнение поля "Владелец" в нижнем регистре, остальные поля заполнены валидно в форме "Оплата по карте" тура "Путешествие дня"
    //   Ожидаемый результат: автоисправление поля "Владелец" в верхний регистре
    @Test//БАГ возможен нижний регистр
    @DisplayName("Holder Test№ 2 Approved Card With Holder Lower Case")
    public void approvedCardWithHolderLowerCase() {
        payPage.fillCardData(HolderHelper.approvedCardWithHolderLowerCase());//пользователь в нижнем регистре

        payPage.shouldImproperFormatNotification();//неверный формат
    }

    //3. Заполнение поля "Владелец" с пробелами в начале и в конце, остальные поля заполнены валидно в форме "Оплата по карте" тура "Путешествие дня"
    //   Ожидаемый результат: авто удаление лишних символов в поле "Владелец"
    @Test//ОК
    @DisplayName("Holder Test№ 3 Approved Card With Holder Start And End Spaces")
    public void approvedCardWithHolderStartAndEndSpaces() {
        payPage.fillCardData(HolderHelper.approvedCardWithHolderStartAndEndSpaces());//пользователь пробелы в начале и конце

        payPage.shouldSuccessNotification();
    }

    //4. Заполнение поля "Владелец" с дефисами в начале и в конце, остальные поля заполнены валидно в форме "Оплата по карте" тура "Путешествие дня"
    //   Ожидаемый результат: авто удаление лишних символов в поле "Владелец"
    @Test//Баг возможны дефисы в начале и конце
    @DisplayName("Holder Test№ 4 Approved Card With Holder Start And End Hyphens")
    public void approvedCardWithHolderStartAndEndHyphens() {
        payPage.fillCardData(HolderHelper.approvedCardWithHolderStartAndEndHyphens());//пользователь дефисы в начале и конце

        payPage.shouldImproperFormatNotification();//неверный формат
    }

    //5. Заполнение поля "Владелец" цифрами, остальные поля заполнены валидно в форме "Оплата по карте" тура "Путешествие дня"
    //   Ожидаемый результат: под полем "Владелец" появиться предупреждение о невалидном значение
    @Test//Баг возможны возможно ввести цифры
    @DisplayName("Holder Test№ 5 Approved Card With Holder Numbers")
    public void approvedCardWithHolderNumbers() {
        payPage.fillCardData(HolderHelper.approvedCardWithHolderNumbers());//пользователь цифры

        payPage.shouldImproperFormatNotification();//неверный формат
    }


    //6. Заполнение поля "Владелец" максимальным количеством букв на латинице в одно слово, остальные поля заполнены валидно в форме "Оплата по карте" тура "Путешествие дня"
    //   Ожидаемый результат: появление сообщения об успешной оплате тура
    @Test//Баг возможно ввести 1001 букву, нет ограничения по вводу
    @DisplayName("Holder Test№ 6 Approved Card With Holder 1001Letter")
    public void approvedCardWithHolder1001Letter() {
        payPage.fillCardData(HolderHelper.approvedCardWithHolder1_001Letter());//пользователь 1001Letter

        payPage.shouldImproperFormatNotification();//неверный формат
    }


    //7. Заполнение поля "Владелец" одной буквой на латинице, остальные поля заполнены валидно в форме "Оплата по карте" тура "Путешествие дня"
    //   Ожидаемый результат: появиться предупреждение о невалидном значение, должно быть минимум 2 буквы
    @Test//Баг возможно ввести 1 букву
    @DisplayName("Holder Test№ 7 Approved Card With Holder One Letter")
    public void approvedCardWithHolderOneLetter() {
        payPage.fillCardData(HolderHelper.approvedCardWithHolderOneLetter());//пользователь одна буква

        payPage.shouldEmptyFieldNotification();//Поле обязательно для заполнения
    }

    //8. Заполнение поля "Владелец" кириллицей, остальные поля заполнены валидно в форме "Оплата по карте" тура "Путешествие дня"
    //   Ожидаемый результат: под полем "Владелец" появиться предупреждение о невалидном значение
    @Test//Баг кириллица в поле
    @DisplayName("Holder Test№ 8 approved Card With Holder With Cyrillic Symbols")
    public void approvedCardWithHolderWithCyrillicSymbols() {
        payPage.fillCardData(HolderHelper.approvedCardWithHolderWithCyrillicSymbols());//поля заполнены валидно, владелец кириллицей

        payPage.shouldImproperFormatNotification();//видимое Сообщение Неверный формат
    }

    //9. Заполнение поля "Владелец" рандомными спецсимволами, остальные поля заполнены валидно в форме "Оплата по карте" тура "Путешествие дня"
    //   Ожидаемый результат: под полем "Владелец" появиться предупреждение о невалидном значение
    @Test//Баг возможны спецсимволы
    @DisplayName("Holder Test№ 9 approved Card With Holder Symbols")
    public void approvedCardWithHolderSymbols() {
        payPage.fillCardData(HolderHelper.approvedCardWithHolderSymbols());//поля заполнены валидно, владелец спецсимволами

        payPage.shouldImproperFormatNotification();//видимое Сообщение Неверный формат
    }
}

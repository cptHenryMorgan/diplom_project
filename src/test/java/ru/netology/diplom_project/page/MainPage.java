package ru.netology.diplom_project.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    //описание путешествия #root > div > div
    private static final SelenideElement dailyTripCard = $x("//div[@id='root']/div/div[contains(@class, 'card')]");
    //поиск по коллекции элементов кнопка "button" плюс найти точный текст
    private static final SelenideElement cardButton = $$("button").find(exactText("Купить"));
    //поиск по коллекции элементов кнопка "button" плюс найти точный текст
    private static final SelenideElement creditButton = $$("button").find(exactText("Купить в кредит"));
    //показать форма для заполнения
    private static final SelenideElement formToFill = $("#root > div > form");
    private static final SelenideElement messPay = $("#root > div > h3");
    public void choosePaymentCard() {
        dailyTripCard.shouldBe(visible);
        cardButton.shouldBe(visible).click();
        messPay.shouldHave(text("Оплата по карте"));
        formToFill.shouldBe(visible);

    }
    public void chooseCreditOnCard() {
        dailyTripCard.shouldBe(visible);
        creditButton.shouldBe(visible).click();
        messPay.shouldHave(text("Кредит по данным карты"));
        formToFill.shouldBe(visible);

    }
}

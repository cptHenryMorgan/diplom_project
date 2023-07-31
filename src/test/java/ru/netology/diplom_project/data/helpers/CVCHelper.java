package ru.netology.diplom_project.data.helpers;

import com.github.javafaker.Faker;

import java.util.Locale;

import static ru.netology.diplom_project.data.DataGenerator.symbols;

public class CVCHelper {

    private static final Faker fakerEN = new Faker(Locale.ENGLISH);
    private static final Faker fakerRU = new Faker(new Locale("ru", "RU"));

    //создать валидный CVC
    public static String generateValidCVC() {
        return fakerEN.numerify("###");
    }

    //пустое поле CVC
    public static String generateEmptyFieldCVC() {
        return ("");
    }

    //сгенерировать невалидный CVC с 1й цифрой
    public static String generateInvalidCVCWithOneDigit() {
        return fakerEN.numerify("#");
    }

    //сгенерировать невалидный CVC с 4мя цифрами
    public static String generateInvalidCVCWithFourDigit() {
        return fakerEN.numerify("####");
    }

    //сгенерировать невалидный CVC с 3мя случайными символами кириллицы
    public static String generateInvalidCVCWithThreeSymbolsOfCyrillic() {
        return fakerRU.letterify("???");
    }

    //сгенерировать невалидный CVC с 3мя случайными символами латинницы
    public static String generateInvalidCVCWithThreeSymbolsOfLatin() {
        return fakerEN.letterify("???");
    }

    //сгенерировать невалидный CVC с 3мя случайными спецсимволами
    public static String generateInvalidCVCWithThreeSymbols() {
        return (symbols("#") + symbols("#") + symbols("#"));
    }
}



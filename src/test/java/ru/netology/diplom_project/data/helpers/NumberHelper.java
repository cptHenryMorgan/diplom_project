package ru.netology.diplom_project.data.helpers;

import com.github.javafaker.Faker;

import java.util.Locale;

import static ru.netology.diplom_project.data.DataGenerator.symbols;

public class NumberHelper {
    private static final Faker fakerEN = new Faker(Locale.ENGLISH);
    private static final Faker fakerRU = new Faker(new Locale("ru", "RU"));

    //генерировать случайную одну цифру
    public static String generateRandomOneDigit() {
        return fakerEN.numerify("#");
    }

    //генерировать пустое поле
    public static String generateEmptyField() {
        return ("");
    }

    //сгенерировать не валидный номер карты с 15 цифрами
    public static String generateInvalidCardNumberWith_15_Digits() {
        return fakerEN.numerify("3333 55## #### ###");
    }

    //сгенерировать не валидный номер карты с 17 цифрами
    public static String generateValidCardNumberWith_17_Digits() {
        return fakerEN.numerify("3333 55## #### #### #");
    }

    //сгенерировать не валидный номер карты с 16 нулей
    public static String generateValidCardNumberWith_16_Zero() {
        return fakerEN.numerify("0000 0000 0000 0000");
    }

    //номер из 16 спецсимволов
    public static String generateInvalidCardNumberWith_16_Symbols() {
        return (symbols("#") + symbols("#") + symbols("#") + symbols("#")
                + symbols("#") + symbols("#") + symbols("#") + symbols("#")
                + symbols("#") + symbols("#") + symbols("#") + symbols("#")
                + symbols("#") + symbols("#") + symbols("#") + symbols("#"));
    }

    //сгенерировать неверный номер карты с 16 случайными символами латиницы
    public static String generateInvalidCardNumberWith_16_Latin() {
        return fakerEN.letterify("???? ???? ???? ????");
    }

    //сгенерировать неверный номер карты с 16 случайными символами кириллицы
    public static String generateInvalidCardNumberWith_16_Cyrillic() {
        return fakerRU.letterify("???? ???? ???? ????");
    }

    //сгенерировать неверный номер карты из 16 цифр без пробелов
    public static String generateValidCardNumberWithoutSpaces() {
        return ("4444444444444441");
    }

    //сгенерировать неверный номер карты из 16 цифр с пробелами в начале и конце
    public static String generateValidCardNumberWithoutStartAndEndSpaces() {
        return (" 4444 4444 4444 4441 ");
    }

    //сгенерировать неверный номер карты из 16 цифр через запятую
    public static String generateInvalidCardNumberWithCommas() {
        return ("1111,2222,3333,4444");
    }
}

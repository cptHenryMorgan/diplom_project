package ru.netology.diplom_project.data.helpers;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static ru.netology.diplom_project.data.DataGenerator.symbols;

public class MonthHelper {
    private static final Faker fakerEN = new Faker(Locale.ENGLISH);
    private static final Faker fakerRU = new Faker(new Locale("ru", "RU"));

    //сгенерировать месяц
    public static String generateMonth(int shiftMonth) {
        return LocalDate.now().plusMonths(shiftMonth).format(DateTimeFormatter.ofPattern("MM"));
    }

    //поле месяц пустое
    public static String generateMonthEmptyField() {
        return ("");
    }

    //заполнить поле месяц 3мя цифрами
    public static String generateMonthWithThreeNumbers() {
        return fakerEN.numerify("12#");
    }

    //заполнить поле месяц 2мя нулями
    public static String generateMonthWith_00_numbers() {
        return ("00");
    }

    //заполнить поле месяц 1ой цифрой
    public static String generateMonthWithOneNumber() {
        return fakerEN.numerify("#");
    }

    //заполнить поле месяц числом 12
    public static String generateMonthWith_12_Number() {
        return ("12");
    }

    //заполнить поле месяц число 13
    public static String generateMonthWith_13_Numbers() {
        return ("13");
    }

    //заполнить поле месяц 2мя спецсимволами
    public static String generateMonthWithTwoSymbols() {
        return (symbols("#") + symbols("#"));
    }

    //заполнить поле месяц 2мя латинскими буквами
    public static String generateMonthWithTwoLatinLetters() {
        return fakerEN.letterify("??");
    }

    //заполнить поле месяц 2 буквы кириллица
    public static String generateMonthWithTwoCyrillicLetters() {
        return fakerRU.letterify("??");
    }
}

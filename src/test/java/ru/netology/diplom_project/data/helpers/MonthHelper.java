package ru.netology.diplom_project.data.helpers;

import com.github.javafaker.Faker;
import ru.netology.diplom_project.data.DataGenerator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static ru.netology.diplom_project.data.DataGenerator.getNumberByStatus;
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


    //ApprovedCard создать Month из 3 цифр
    public static DataGenerator.CardData approvedCardWithMonthOfThreeNumbers() {
        return new DataGenerator.CardData(getNumberByStatus("APPROVED"),
                MonthHelper.generateMonthWithThreeNumbers(),
                YearHelper.generateYear(0),
                HolderHelper.generateValidHolder(),
                CVCHelper.generateValidCVC());
    }

    //ApprovedCard создать Month из 00 цифр
    public static DataGenerator.CardData approvedCardWithMonthOf_00_numbers() {
        return new DataGenerator.CardData(getNumberByStatus("APPROVED"),
                MonthHelper.generateMonthWith_00_numbers(),
                YearHelper.generateYear(1),
                HolderHelper.generateValidHolder(),
                CVCHelper.generateValidCVC());
    }

    //ApprovedCard создать Month из 1 цифры
    public static DataGenerator.CardData approvedCardWithMonthOfOneNumber() {
        return new DataGenerator.CardData(getNumberByStatus("APPROVED"),
                MonthHelper.generateMonthWithOneNumber(),
                YearHelper.generateYear(0),
                HolderHelper.generateValidHolder(),
                CVCHelper.generateValidCVC());
    }

    //ApprovedCard создать Month из числа 12
    public static DataGenerator.CardData approvedCardWithMonthOf_12_numbers() {
        return new DataGenerator.CardData(getNumberByStatus("APPROVED"),
                MonthHelper.generateMonthWith_12_Number(),
                YearHelper.generateYear(0),
                HolderHelper.generateValidHolder(),
                CVCHelper.generateValidCVC());
    }

    //ApprovedCard создать Month из числа 13
    public static DataGenerator.CardData approvedCardWithMonthOf_13_numbers() {
        return new DataGenerator.CardData(getNumberByStatus("APPROVED"),
                MonthHelper.generateMonthWith_13_Numbers(),
                YearHelper.generateYear(0),
                HolderHelper.generateValidHolder(),
                CVCHelper.generateValidCVC());
    }

    //ApprovedCard создать Month из 2х спецсимволов
    public static DataGenerator.CardData approvedCardWithMonthOfTwoSymbols() {
        return new DataGenerator.CardData(getNumberByStatus("APPROVED"),
                MonthHelper.generateMonthWithTwoSymbols(),
                YearHelper.generateYear(0),
                HolderHelper.generateValidHolder(),
                CVCHelper.generateValidCVC());
    }

    //ApprovedCard создать Month из 2 Latin
    public static DataGenerator.CardData approvedCardWithMonthOfTwoLatinLetters() {
        return new DataGenerator.CardData(getNumberByStatus("APPROVED"),
                MonthHelper.generateMonthWithTwoLatinLetters(),
                YearHelper.generateYear(0),
                HolderHelper.generateValidHolder(),
                CVCHelper.generateValidCVC());
    }

    //ApprovedCard создать Month из 2 Cyrillic
    public static DataGenerator.CardData approvedCardWithMonthOfTwoCyrillicLetters() {
        return new DataGenerator.CardData(getNumberByStatus("APPROVED"),
                MonthHelper.generateMonthWithTwoCyrillicLetters(),
                YearHelper.generateYear(0),
                HolderHelper.generateValidHolder(),
                CVCHelper.generateValidCVC());
    }
    //ApprovedCard создать Month пустое поле
    public static DataGenerator.CardData approvedCardWithMonthEmptyField() {
        return new DataGenerator.CardData(getNumberByStatus("APPROVED"),
                MonthHelper.generateMonthEmptyField(),
                YearHelper.generateYear(0),
                HolderHelper.generateValidHolder(),
                CVCHelper.generateValidCVC());
    }
}

package ru.netology.diplom_project.data.helpers;

import com.github.javafaker.Faker;
import ru.netology.diplom_project.data.DataGenerator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static ru.netology.diplom_project.data.DataGenerator.getNumberByStatus;
import static ru.netology.diplom_project.data.DataGenerator.symbols;

    public class YearHelper {
        private static final Faker fakerEN = new Faker(Locale.ENGLISH);
        private static final Faker fakerRU = new Faker(new Locale("ru", "RU"));
        //сгенерировать год
        public static String generateYear(int shiftYear) {
            return LocalDate.now().plusYears(shiftYear).format(DateTimeFormatter.ofPattern("yy"));
        }
        //поле год пустое
        public static String generateYearEmptyField() {
            return("");
        }

        //заполнить поле год 1ой цифрой
        public static String generateYearWithOneNumber() {
            return fakerEN.numerify("#");}

        //заполнить поле год 3мя цифрами
        public static String generateYearWithThreeNumbers() {
            return fakerEN.numerify("###");
        }
        //заполнить поле год 2мя нулями
        public static String generateYearWith_00_numbers() {
            return("00");
        }

        //заполнить поле год 2мя спецсимволами
        public static String generateYearWithTwoSymbols() {
            return(symbols("#") + symbols("#"));
        }

        //заполнить поле год 2мя латинскими буквами
        public static String generateYearWithTwoLatinLetters() {
            return fakerEN.letterify("??");
        }

        //заполнить поле год 2мя буквами кириллицы
        public static String generateYearWithTwoCyrillicLetters() {
            return fakerRU.letterify("??");
        }

        //ApprovedCard создать пустое поле Year
        public static DataGenerator.CardData approvedCardWithYearEmptyField() {
            return new DataGenerator.CardData(getNumberByStatus("APPROVED"),
                    MonthHelper.generateMonth(0),
                    YearHelper.generateYearEmptyField(),
                    HolderHelper.generateValidHolder(),
                    CVCHelper.generateValidCVC());
        }
        //ApprovedCard создать Year предыдущий год
        public static DataGenerator.CardData approvedCardWithLastYear() {
            return new DataGenerator.CardData(getNumberByStatus("APPROVED"),
                    MonthHelper.generateMonth(0),
                    YearHelper.generateYear(-1),
                    HolderHelper.generateValidHolder(),
                    CVCHelper.generateValidCVC());
        }
        //ApprovedCard создать Year предыдущий месяц
        public static DataGenerator.CardData approvedCardWithValidYearLastMonth() {
            return new DataGenerator.CardData(getNumberByStatus("APPROVED"),
                    MonthHelper.generateMonth(-1),
                    YearHelper.generateYear(0),
                    HolderHelper.generateValidHolder(),
                    CVCHelper.generateValidCVC());
        }
        //ApprovedCard создать Year плюс 6 лет от текущего
        public static DataGenerator.CardData approvedCardYearPlusSix() {
            return new DataGenerator.CardData(getNumberByStatus("APPROVED"),
                    MonthHelper.generateMonth(0),
                    YearHelper.generateYear(+6),
                    HolderHelper.generateValidHolder(),
                    CVCHelper.generateValidCVC());
        }
        //ApprovedCard создать Year из 1 цифры
        public static DataGenerator.CardData approvedCardWithYearWithOneNumber() {
            return new DataGenerator.CardData(getNumberByStatus("APPROVED"),
                    MonthHelper.generateMonth(0),
                    YearHelper.generateYearWithOneNumber(),
                    HolderHelper.generateValidHolder(),
                    CVCHelper.generateValidCVC());
    }
        //ApprovedCard создать Year из 3х цифр
        public static DataGenerator.CardData approvedCardWithYearWithThreeNumbers() {
            return new DataGenerator.CardData(getNumberByStatus("APPROVED"),
                    MonthHelper.generateMonth(0),
                    YearHelper.generateYearWithThreeNumbers(),
                    HolderHelper.generateValidHolder(),
                    CVCHelper.generateValidCVC());
        }
        //ApprovedCard создать Year минус 6 лет от текущего
        public static DataGenerator.CardData approvedCardWithYear2017() {
            return new DataGenerator.CardData(getNumberByStatus("APPROVED"),
                    MonthHelper.generateMonth(0),
                    YearHelper.generateYear(-6),
                    HolderHelper.generateValidHolder(),
                    CVCHelper.generateValidCVC());
        }
        //ApprovedCard создать Year из двух 00
        public static DataGenerator.CardData approvedCardWithYearWith_00_numbers() {
            return new DataGenerator.CardData(getNumberByStatus("APPROVED"),
                    MonthHelper.generateMonth(0),
                    YearHelper.generateYearWith_00_numbers(),
                    HolderHelper.generateValidHolder(),
                    CVCHelper.generateValidCVC());
        }
        //ApprovedCard создать Year из 2х спецсимволов
        public static DataGenerator.CardData approvedCardWithYearWithTwoSymbols() {
            return new DataGenerator.CardData(getNumberByStatus("APPROVED"),
                    MonthHelper.generateMonth(0),
                    YearHelper.generateYearWithTwoSymbols(),
                    HolderHelper.generateValidHolder(),
                    CVCHelper.generateValidCVC());
        }
        //ApprovedCard создать Year из 2х Latin
        public static DataGenerator.CardData approvedCardWithYearWithTwoLatinLetters() {
            return new DataGenerator.CardData(getNumberByStatus("APPROVED"),
                    MonthHelper.generateMonth(0),
                    YearHelper.generateYearWithTwoLatinLetters(),
                    HolderHelper.generateValidHolder(),
                    CVCHelper.generateValidCVC());
        }
        //ApprovedCard создать Year из 2х Cyrillic
        public static DataGenerator.CardData approvedCardWithYearWithTwoCyrillicLetters() {
            return new DataGenerator.CardData(getNumberByStatus("APPROVED"),
                    MonthHelper.generateMonth(0),
                    YearHelper.generateYearWithTwoCyrillicLetters(),
                    HolderHelper.generateValidHolder(),
                    CVCHelper.generateValidCVC());
        }
}

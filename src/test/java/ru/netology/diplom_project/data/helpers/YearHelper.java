package ru.netology.diplom_project.data.helpers;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

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
}

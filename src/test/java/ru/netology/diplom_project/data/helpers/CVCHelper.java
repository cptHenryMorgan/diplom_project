package ru.netology.diplom_project.data.helpers;

import com.github.javafaker.Faker;
import ru.netology.diplom_project.data.DataGenerator;

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
    private static String generateEmptyFieldCVC () {
        return ("");
    }

    //сгенерировать невалидный CVC с 1й цифрой
    private static String generateInvalidCVCWithOneDigit() {
        return fakerEN.numerify("#");
    }

    //сгенерировать невалидный CVC с 4мя цифрами
    private static String generateInvalidCVCWithFourDigit() {
        return fakerEN.numerify("####");
    }

    //сгенерировать невалидный CVC с 3мя случайными символами кириллицы
    private static String generateInvalidCVCWithThreeSymbolsOfCyrillic() {
        return fakerRU.letterify("???");
    }

    //сгенерировать невалидный CVC с 3мя случайными символами латинницы
    private static String generateInvalidCVCWithThreeSymbolsOfLatin() {
        return fakerEN.letterify("???");
    }

    //сгенерировать невалидный CVC с 3мя случайными спецсимволами
    private static String generateInvalidCVCWithThreeSymbols() {
        return (symbols("#") + symbols("#") + symbols("#"));
    }

    //ApprovedCard создать CVC из 1й цифры
    public static DataGenerator.CardData approvedCardWithCVCWithOneDigit() {
        return new DataGenerator.CardData(getNumberByStatus("APPROVED"),
                MonthHelper.generateMonth(0),
                YearHelper.generateYear(0),
                HolderHelper.generateValidHolder(),
                CVCHelper.generateInvalidCVCWithOneDigit());
    }

    //ApprovedCard создать CVC из 4х цифр
    public static DataGenerator.CardData approvedCardWithCVCWithFourDigit() {
        return new DataGenerator.CardData(getNumberByStatus("APPROVED"),
                MonthHelper.generateMonth(0),
                YearHelper.generateYear(0),
                HolderHelper.generateValidHolder(),
                CVCHelper.generateInvalidCVCWithFourDigit());
    }

    //ApprovedCard создать CVC из 3 Latin
    public static DataGenerator.CardData approvedCardWithCVCWithThreeSymbolsOfLatin() {
        return new DataGenerator.CardData(getNumberByStatus("APPROVED"),
                MonthHelper.generateMonth(0),
                YearHelper.generateYear(0),
                HolderHelper.generateValidHolder(),
                CVCHelper.generateInvalidCVCWithThreeSymbolsOfLatin());
    }

    //ApprovedCard создать CVC из 3 Cyrillic
    public static DataGenerator.CardData approvedCardWithCVCWithThreeSymbolsOfCyrillic() {
        return new DataGenerator.CardData(getNumberByStatus("APPROVED"),
                MonthHelper.generateMonth(0),
                YearHelper.generateYear(0),
                HolderHelper.generateValidHolder(),
                CVCHelper.generateInvalidCVCWithThreeSymbolsOfCyrillic());
    }

    //ApprovedCard создать CVC из 3х спецсимволов
    public static DataGenerator.CardData approvedCardWithCVCWithThreeSymbols() {
        return new DataGenerator.CardData(getNumberByStatus("APPROVED"),
                MonthHelper.generateMonth(0),
                YearHelper.generateYear(0),
                HolderHelper.generateValidHolder(),
                CVCHelper.generateInvalidCVCWithThreeSymbols());
    }
    //ApprovedCard создать пустое поле CVC
    public static DataGenerator.CardData approvedCardWithEmptyFieldCVC() {
        return new DataGenerator.CardData(getNumberByStatus("APPROVED"),
                MonthHelper.generateMonth(0),
                YearHelper.generateYear(0),
                HolderHelper.generateValidHolder(),
                CVCHelper.generateEmptyFieldCVC());
    }
}

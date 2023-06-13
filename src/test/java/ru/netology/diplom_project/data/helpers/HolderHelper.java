package ru.netology.diplom_project.data.helpers;

import com.github.javafaker.Faker;
import ru.netology.diplom_project.data.DataGenerator;

import java.util.Locale;

import static ru.netology.diplom_project.data.DataGenerator.symbols;

public class HolderHelper {

    private static final Faker fakerEN = new Faker(Locale.ENGLISH);
    private static final Faker fakerRU = new Faker(new Locale("ru", "RU"));

    //сгенерировать валидного владельца карты
    public static String generateValidHolder() {
        return fakerEN.name().fullName().toUpperCase();
    }

    //сгенерировать пустое поле владельца карты
    public static String generateHolderFieldEmpty() {
        return ("");
    }

    //сгенерировать валидного владельца карты с двойной фамилией через дефис
    public static String generateValidHolderWithDoubleLastName() {
        return fakerEN.name().lastName().toUpperCase() +"-" + fakerEN.name().lastName().toUpperCase() + " "
                + fakerEN.name().firstName().toUpperCase();
    }

    //сгенерировать не валидного владельца на кириллице
    public static String generateInvalidHolderWithCyrillicSymbols() {
        return fakerRU.name().firstName().toUpperCase() + " " + fakerRU.name().lastName().toUpperCase();
    }

    //Заполнения поля владелец в нижнем регистре
    public static String generateInvalidHolderLowerCase() {
        return ("John" + "Doe");
    }

    //Заполнения поля владелец в начале и конце пробелы
    public static String generateHolderStartAndEndSpaces() {
        return (" JOHN " + " DOE ");
    }

    //Заполнения поля владелец в начале и конце дефисы
    public static String generateHolderStartAndEndHyphens() {
        return ("-JOHN-" + "-DOE-");
    }

    //Заполнения поля владелец цифрами
    public static String generateHolderNumbers() {
        return (fakerEN.numerify("####### #######"));
    }

    //Заполнение поля владелец 1001 буквой
    public static String generateInvalidHolder1_001Letter() {
        return("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF");
    }

    //Заполнения поля владелец одной буквой верхний регистр
    public static String generateHolderOneLetter() {
        return (fakerEN.letterify("?").toUpperCase());
    }

    public static String generateHolderSymbols() {
        return (symbols("#") + symbols("#") + symbols("#") + symbols("#") + symbols("#") + symbols("#") + symbols("#") + "-" + symbols("#") + symbols("#") + symbols("#") + symbols("#") + symbols("#") + symbols("#") + symbols("#"));
    }

    //ApprovedCard создать валидного владельца карты с двойной фамилией через дефис
    public static DataGenerator.CardData approvedCardWithDoubleLastName() {
        return new DataGenerator.CardData(getNumberByStatus("APPROVED"),
                MonthHelper.generateMonth(0),
                YearHelper.generateYear(0),
                HolderHelper.generateValidHolderWithDoubleLastName(),
                CVCHelper.generateValidCVC());
    }

    //ApprovedCard создать владельца карты нижний регистр
    public static DataGenerator.CardData approvedCardWithHolderLowerCase() {
        return new DataGenerator.CardData(getNumberByStatus("APPROVED"),
                MonthHelper.generateMonth(0),
                YearHelper.generateYear(0),
                HolderHelper.generateInvalidHolderLowerCase(),
                CVCHelper.generateValidCVC());
    }

    //ApprovedCard создать владельца карты пробелы в начале и конце
    public static DataGenerator.CardData approvedCardWithHolderStartAndEndSpaces() {
        return new DataGenerator.CardData(getNumberByStatus("APPROVED"),
                MonthHelper.generateMonth(0),
                YearHelper.generateYear(0),
                HolderHelper.generateHolderStartAndEndSpaces(),
                CVCHelper.generateValidCVC());
    }

    //ApprovedCard создать владельца карты дефисы в начале и конце
    public static DataGenerator.CardData approvedCardWithHolderStartAndEndHyphens() {
        return new DataGenerator.CardData(getNumberByStatus("APPROVED"),
                MonthHelper.generateMonth(0),
                YearHelper.generateYear(0),
                HolderHelper.generateHolderStartAndEndHyphens(),
                CVCHelper.generateValidCVC());
    }

    //ApprovedCard создать владельца карты из цифр
    public static DataGenerator.CardData approvedCardWithHolderNumbers() {
        return new DataGenerator.CardData(getNumberByStatus("APPROVED"),
                MonthHelper.generateMonth(0),
                YearHelper.generateYear(0),
                HolderHelper.generateHolderNumbers(),
                CVCHelper.generateValidCVC());
    }

    //ApprovedCard создать владельца из 1001 буквы
    public static DataGenerator.CardData approvedCardWithHolder1_001Letter() {
        return new DataGenerator.CardData(getNumberByStatus("APPROVED"),
                MonthHelper.generateMonth(0),
                YearHelper.generateYear(0),
                HolderHelper.generateInvalidHolder1_001Letter(),
                CVCHelper.generateValidCVC());
    }

    //ApprovedCard создать владельца из 1 буквы
    public static DataGenerator.CardData approvedCardWithHolderOneLetter() {
        return new DataGenerator.CardData(getNumberByStatus("APPROVED"),
                MonthHelper.generateMonth(0),
                YearHelper.generateYear(0),
                HolderHelper.generateHolderOneLetter(),
                CVCHelper.generateValidCVC());
    }

    //ApprovedCard создать владельца из кириллицы
    public static DataGenerator.CardData approvedCardWithHolderWithCyrillicSymbols() {
        return new DataGenerator.CardData(getNumberByStatus("APPROVED"),
                MonthHelper.generateMonth(0),
                YearHelper.generateYear(0),
                HolderHelper.generateInvalidHolderWithCyrillicSymbols(),
                CVCHelper.generateValidCVC());
    }

    //ApprovedCard создать владельца из спецсимволов
    public static DataGenerator.CardData approvedCardWithHolderSymbols() {
        return new DataGenerator.CardData(getNumberByStatus("APPROVED"),
                MonthHelper.generateMonth(0),
                YearHelper.generateYear(0),
                HolderHelper.generateHolderSymbols(),
                CVCHelper.generateValidCVC());
    }
    //ApprovedCard создать владельца пустое поле
    public static DataGenerator.CardData approvedCardWithHolderEmpty() {
        return new DataGenerator.CardData(getNumberByStatus("APPROVED"),
                MonthHelper.generateMonth(0),
                YearHelper.generateYear(0),
                HolderHelper.generateHolderFieldEmpty(),
                CVCHelper.generateValidCVC());
    }
}

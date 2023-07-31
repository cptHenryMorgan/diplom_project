package ru.netology.diplom_project.data.helpers;

import com.github.javafaker.Faker;

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
}

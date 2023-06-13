package ru.netology.diplom_project.data;

import java.util.Random;

public class DataGenerator {

    //один спецсимвол
    public static String symbols(String locale) {
        var symbol = new String[]{"!", "№", ";", "%", ":", "?", "*", "(", ")", "_", "-", "+", "=", "/", "~", "@", "#", "$", "&"};
        return symbol[new Random().nextInt(symbol.length)];
    }
}

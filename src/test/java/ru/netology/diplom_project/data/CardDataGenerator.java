package ru.netology.diplom_project.data;

import ru.netology.diplom_project.data.helpers.*;

import static ru.netology.diplom_project.data.DataGenerator.getNumberByStatus;

public class CardDataGenerator {
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
    //поля заполнены валидно, номер действующей карты без пробелов
    public static DataGenerator.CardData dataWithApprovedCardNumberWithoutSpaces() {
        return new DataGenerator.CardData(
                NumberHelper.generateValidCardNumberWithoutSpaces(),
                MonthHelper.generateMonth(0),
                YearHelper.generateYear(0),
                HolderHelper.generateValidHolder(),
                CVCHelper.generateValidCVC());
    }

    //поля заполнены валидно, номер действующей карты 1 цифра
    public static DataGenerator.CardData dataWithCardNumberOneRandomDigit() {
        return new DataGenerator.CardData(
                NumberHelper.generateRandomOneDigit(),
                MonthHelper.generateMonth(0),
                YearHelper.generateYear(0),
                HolderHelper.generateValidHolder(),
                CVCHelper.generateValidCVC());
    }

    //поля заполнены валидно, номер действующей карты 15 цифр
    public static DataGenerator.CardData dataWithCardNumber_15_RandomDigit() {
        return new DataGenerator.CardData(
                NumberHelper.generateInvalidCardNumberWith_15_Digits(),
                MonthHelper.generateMonth(0),
                YearHelper.generateYear(0),
                HolderHelper.generateValidHolder(),
                CVCHelper.generateValidCVC());
    }

    //поля заполнены валидно, номер действующей карты 17 цифр
    public static DataGenerator.CardData dataWithCardNumber_17_RandomDigit() {
        return new DataGenerator.CardData(
                NumberHelper.generateValidCardNumberWith_17_Digits(),
                MonthHelper.generateMonth(0),
                YearHelper.generateYear(0),
                HolderHelper.generateValidHolder(),
                CVCHelper.generateValidCVC());
    }

    //поля заполнены валидно, номер действующей карты 16 нулями
    public static DataGenerator.CardData dataWithCardNumber_16_zero() {
        return new DataGenerator.CardData(
                NumberHelper.generateValidCardNumberWith_16_Zero(),
                MonthHelper.generateMonth(0),
                YearHelper.generateYear(0),
                HolderHelper.generateValidHolder(),
                CVCHelper.generateValidCVC());
    }

    //поля заполнены валидно, номер действующей карты 16 спецсимволов
    public static DataGenerator.CardData dataWithCardNumberWith_16_Symbols() {
        return new DataGenerator.CardData(
                NumberHelper.generateInvalidCardNumberWith_16_Symbols(),
                MonthHelper.generateMonth(0),
                YearHelper.generateYear(0),
                HolderHelper.generateValidHolder(),
                CVCHelper.generateValidCVC());
    }

    //поля заполнены валидно, номер действующей карты 16 Latin
    public static DataGenerator.CardData dataWithCardNumberWith_16_Latin() {
        return new DataGenerator.CardData(
                NumberHelper.generateInvalidCardNumberWith_16_Latin(),
                MonthHelper.generateMonth(0),
                YearHelper.generateYear(0),
                HolderHelper.generateValidHolder(),
                CVCHelper.generateValidCVC());
    }

    //поля заполнены валидно, номер действующей карты 16 Cyrillic
    public static DataGenerator.CardData dataWithCardNumberWith_16_Cyrillic() {
        return new DataGenerator.CardData(
                NumberHelper.generateInvalidCardNumberWith_16_Cyrillic(),
                MonthHelper.generateMonth(0),
                YearHelper.generateYear(0),
                HolderHelper.generateValidHolder(),
                CVCHelper.generateValidCVC());
    }

    //поля заполнены валидно, номер действующей карты пробелы в начале и в конце
    public static DataGenerator.CardData dataWithCardNumberWithStartAndEndSpaces() {
        return new DataGenerator.CardData(
                NumberHelper.generateValidCardNumberWithoutStartAndEndSpaces(),
                MonthHelper.generateMonth(0),
                YearHelper.generateYear(0),
                HolderHelper.generateValidHolder(),
                CVCHelper.generateValidCVC());
    }

    //поля заполнены валидно, номер действующей карты цифры разделены запятыми
    public static DataGenerator.CardData dataWithCardNumberWithCommas() {
        return new DataGenerator.CardData(
                NumberHelper.generateInvalidCardNumberWithCommas(),
                MonthHelper.generateMonth(0),
                YearHelper.generateYear(0),
                HolderHelper.generateValidHolder(),
                CVCHelper.generateValidCVC());
    }
    //поля заполнены валидно, номер действующей карты пустой
    public static DataGenerator.CardData dataWithCardNumberEmpty() {
        return new DataGenerator.CardData(
                NumberHelper.generateEmptyField(),
                MonthHelper.generateMonth(0),
                YearHelper.generateYear(0),
                HolderHelper.generateValidHolder(),
                CVCHelper.generateValidCVC());
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

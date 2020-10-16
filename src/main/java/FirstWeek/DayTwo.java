package FirstWeek;


import BaseMethods.BaseMethods;

import java.io.IOException;
import java.util.Scanner;

//- Функция должна напечатать количество символов в тексте.
//- Функция должна напечатать количество символов без учета пробелов.
//- Функция должна напечатать "количество символов в тексте четное"
// или "количество символов в тексте нечетное" в зависимости от количества символов (тут пробелы учитываем).
//- Функция должна напечатать "длина текста превышает длину {N} символов",
// где N - это целочисленное значение, которое передается вторым параметром в функцию.
// Само собой, если на самом деле длина текста меньше максимальной, то это писать не надо.

public class DayTwo extends BaseMethods {
    public static void dayTwoTaskOneSimpleStringOperations() {

        System.out.println("Type some text:");
        String userInputText = getStringFromUser();

        System.out.println("Type some integer:");
        int userInputNumber = getIntFromUser();

//        System.out.println("Type some text:");
//        String userInputText = getStringFromUser();

        System.out.println("Amount of symbols in text: " + userInputText.length());
        System.out.println("Amount of symbols in text without space: " + userInputText.replace(" ", "").length());

        if (userInputText.length() % 2 == 0) {
            System.out.println("Amount of symbols in text even");
        } else {
            System.out.println("Amount of symbols in text even odd");
        }

        if (userInputText.length() > userInputNumber) {
            System.out.println("Text length more than " + userInputNumber + " symbols");
        }
    }
}

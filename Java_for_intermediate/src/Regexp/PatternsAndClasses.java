package Regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternsAndClasses {
    public static void main(String[] args) {
        String text = "Hello, guys! I send you email fsdfsd@gmail.com\n"+
                "and you can suck on afganka@mail.ru. Idi nahui!";

        // Pattern - Factory Method. Ограничиваем создание объектов класса через конструктор
        // но есть статический метод, который после своей работы выдает объект.
        Pattern email = Pattern.compile("\\w+@(gmail|mail)\\.(com|ru)"); // В круглых строках - группы
        Matcher matcher = email.matcher(text);

        // Пока есть очередное соответствие паттерну
        while(matcher.find()) {
            System.out.println(matcher.group(1)); // Получаем совпадение. Аргумент группы - те, что в круглых строках в регулярке
        // Если есть вложенные группы, то id будут выделяться по порядку (() - 2 () - 3) - 1
        }
    }
}

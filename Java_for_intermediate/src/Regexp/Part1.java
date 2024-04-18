package Regexp;

public class Part1 {
    public static void main(String[] args) {
        /*
            // Сайт regexlib.com

            \\d - одна цифра
            \\w - одна буква = [a-zA-Z]

            + - 1 или более
            * - 0 или более
            ? - 0 или 1 символов до

            (x|y|3) - одна строка из множества, либо можно просто [xy3]
            ! Если хотим использовать специальный символ в качестве обычного, то нужно экранировать \\

            [a-zA-Z] - все английские буквы
            [0-9] - все цифры \\d

            [^abc] - все символы, кроме [abc]; ^ - отрицание

            . - любой символ

            {2} - 2 символа до {\\d{2}}
            {2, } - 2 или более символов \\d{2,}
            {2, 4} - от 2 до 4 символов {\\d{2,4}}
         */


        String a = "-123";
        String b = "454";
        String c = "+1343";
        // Ниже три одинакоывых регулярки
        System.out.println(a.matches("[-|+]?\\d+"));  // Сработает если только один символ
        System.out.println(b.matches("(-+)?\\d+"));
        System.out.println(c.matches("(-|\\+)?\\d+"));

        String d = "g123443";
        System.out.println(d.matches("[a-zA-z]+\\d+"));

        String e = "heallo";
        System.out.println(e.matches("[^abc]*"));

        String url = "http://www.google.co";
        String url2 = "http://www.yandex.ru";
        System.out.println(url.matches("http://www\\..+.(com|ru)"));
        System.out.println(url2.matches("http://www\\..+.(com|ru)"));

        String f = "123";
        System.out.println(f.matches("\\d{2,}"));

        String test = "м";
        System.out.println(test.matches("[а-я]"));
    }
}

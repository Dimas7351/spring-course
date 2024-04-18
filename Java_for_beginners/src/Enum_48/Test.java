package Enum_48;

public class Test {


    public static void main(String[] args) {
       Animal animal = Animal.CAT;
        System.out.println(animal);
//
//       switch (animal){
//           case CAT:
//               System.out.println("It's a cat");
//               break;
//           case DOG:
//               System.out.println("It's a dog");
//               break;
//       }

       Season season = Season.SUMMER;

       // Object -> Enum -> Season   -  иерархия

        System.out.println(season instanceof Enum); // Проверяем, является ли объект определенным классом
        System.out.println(season.getClass());
        System.out.println(season.getTemperature());
        System.out.println(season.name()); // Вывести как в enum - SUMMER

        Animal frog = Animal.valueOf("FROG");  // Из строки получем enum. Типа пользователь ввел любимое животное frog, мы делаем UPPERCASE и вызываем valueOf
        System.out.println(frog);

        Season winter = Season.WINTER;
        System.out.println(winter.ordinal()); // Индекс enum

       switch (season){
           case SUMMER:
               System.out.println("It's warm outside");
               break;
           case WINTER:
               System.out.println("It's cold outside");
               break;
       }
    }

}

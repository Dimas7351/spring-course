package AnoymusClasses_35;

//public class Animal {
//    public void eat(){
//        System.out.println("Animal is eating...");
//    }
//}
/***
class OtherAnimal extends Animal{
    public void eat(){
        System.out.println("Other animal is eating...");
    }
}
***/

interface AbleToEat{
    public void eat();
}

//class Animal implements AbleToEat{
//
//    @Override
//    public void eat() {
//        System.out.println("I am eating");
//    }
//}

class Test{
    public static void main(String[] args) {

        // Анонимный класс от интерфейса
    AbleToEat ableToEat = new AbleToEat() {
        @Override
        public void eat() {
            System.out.println("Anonymus class is eating..");
        }
    };

    ableToEat.eat();

        // Когда implement
//    AbleToEat ableToEat = new Animal();
//    ableToEat.eat();






//        Animal animal = new Animal();
//        animal.eat();
//
//        // Анонимный класс, как лямбда-функция. Наследник класса Animal
//        Animal animal2 = new Animal(){
//            public void eat(){
//                System.out.println("Other animal is eating...");
//            }
//        };
////        OtherAnimal otherAnimal = new OtherAnimal();
//        otherAnimal.eat();


    }
}

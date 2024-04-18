package Enum_48;

public enum Animal {
    DOG("собака"), CAT("кошка"), FROG("лягушка"); // если нет конструктоора с аргументами, то пишем просто DOG, CAT, FROG без ; и ()

    private String translation;

    Animal(String translation){  // В enum конструкторы приватные (по умолчанию)
        this.translation = translation;
    }

    public String getTranslation(){
        return translation;
    }

    public String toString(){
        return "Перевод на русский язык: " + translation;
    }
}

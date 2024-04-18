package spring.app.fin;

public class ClassicalMusic implements Music {

    private ClassicalMusic() {}

    // Factory-method   фабричный метод
    public static ClassicalMusic getClassicalMusic(){
        return new ClassicalMusic();
    }

    // Может быть любой модификатор доступа и не должны принимать на вход аргументы
    public void doMyInit(){
        System.out.println("Doing my initialization");
    }

    // Для бинов с scope=prototype не вызывается destroy-method
    public void doMyDestroy(){
        System.out.println("Doing my destruction");
    }

    @Override
    public String getSong() {
        return "Hungarian Rhapsody";
    }
}

package Additional_themes.Annotations;

public class B extends A{
    @Override // Если в классе А изменим название метода, то здесь вылезет ошибка, так как мы не будем переопределять метод
    public void test(){
        System.out.println("Hello from class B");
    }
}

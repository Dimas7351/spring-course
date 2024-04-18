package Lambda;

interface Executable{
    int execute(int x);

}

class Runner{
    public void run(Executable e){
        int a = e.execute(10);
        System.out.println(a);
    }
}

//class ExecutableImplementation implements Executable{
//
//    @Override
//    public void execute(int x) {
//        System.out.println("Hello from class");
//    }
//}

public class TestPersonalInterface {
    public static void main(String[] args) {
        Runner runner = new Runner();

        // 1 способ
//        runner.run(new ExecutableImplementation());  - если есть класс

        // 2 способ
        runner.run(new Executable() {
            @Override
            public int execute(int x) {
                return x+5;
            }
        });

        // 3 способ
//        runner.run(() -> System.out.println("Hello from lambda")); // когда одна строка

//        runner.run(() -> {
//            System.out.println("Hello");
//            System.out.println("Second line");
//        });

        //runner.run(() -> 1);  - return 1, если метод int execute();

        runner.run((x) -> x+5);

        //!!! В lambda можно использовать внешние переменные
        final int a = 1; // Но переменная должна быть либо final, либо больше никогда не меняться
        runner.run(x -> x+a);

        // ! У lambda нет собственной области видимости scope
    }
}

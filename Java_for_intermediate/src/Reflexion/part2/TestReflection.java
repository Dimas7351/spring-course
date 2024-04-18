package Reflexion.part2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class TestReflection {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Scanner sc = new Scanner(System.in);

        // Название_класса1 Название_класса2 Название_метода - считаем все в одной строке
        Class classObject1 = Class.forName(sc.next());
        Class classObject2 = Class.forName(sc.next());
        String methodName = sc.next();

        Method m = classObject1.getMethod(methodName, classObject2);
        Object o1 = classObject1.newInstance();
        Object o2 = classObject2.getConstructor(String.class).newInstance("String value");

        m.invoke(o1,o2);

        System.out.println(o1);
    }
}

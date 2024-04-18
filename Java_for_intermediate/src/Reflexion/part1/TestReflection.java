package Reflexion.part1;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class TestReflection {
    public static void main(String[] args) throws ClassNotFoundException {
        Person person = new Person();

        Class personClass = Person.class;
        Class personClass2 = person.getClass();
        Class personClass3 = Class.forName("Reflexion.part1.Person");

//        Method[] methods = personClass3.getMethods();
//        for(Method method : methods){
//            System.out.println(method.getName() + ", "
//            + method.getReturnType() + " " + Arrays.toString(method.getParameterTypes()));
//        }

        Field[] fields1 = personClass.getFields(); // Показывает только public поля
        Field[] fields = personClass.getDeclaredFields(); // Показывает все поля
//        for(Field field : fields){
//            System.out.println(field.getName() + ", "
//                    + field.getType());
//        }


        Annotation[] annotations = personClass2.getAnnotations();
        for(Annotation annotation : annotations){
//            if (annotation instanceof Author)
//                System.out.println("Yes");
            System.out.println(annotation.annotationType());
        }
    }
}

package Additional_themes.PersonalAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target({ElementType.METHOD}) // аннотация может использоваться только для методов
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodInfo {
    String author() default "Dima"; // Объявляем поля как методы с ()
    int dateOfCreation() default 2024;
    String purpose();
}

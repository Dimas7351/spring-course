package spring.app.fin;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );

       ClassicalMusic classicalMusic = context.getBean("musicBean", ClassicalMusic.class);
       ClassicalMusic classicalMusic2 = context.getBean("musicBean", ClassicalMusic.class);

        System.out.println(classicalMusic==classicalMusic2);
        System.out.println(classicalMusic.getSong());
        System.out.println(classicalMusic2.getSong());

        context.close();
    }
}

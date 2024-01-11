package examples.a1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//your buisness
//dependency 1
//dependency 2
@Component
class YourBuisnessClass {
    Dependency1 dependency1;

    Dependency2 dependency2;
    //  @Autowired
    public YourBuisnessClass(Dependency1 dependency1, Dependency2 dependency2) {
        System.out.println("construction injection YourBuisnessClass");
        this.dependency1 = dependency1;
        this.dependency2 = dependency2;
    }

    //    @Autowired
//    public void setDependency1(Dependency1 dependency1) {
//        System.out.println("setter injectipon setDependency1");
//        this.dependency1 = dependency1;
//    }
//    @Autowired
//    public void setDependency2(Dependency2 dependency2) {
//        System.out.println("setter injection setDependency2");
//        this.dependency2 = dependency2;
//    }

    public String toString() {
        return "YourBuisnessClass{" +
                "dependency1=" + dependency1 +
                ", dependency2=" + dependency2 +
                '}';
    }
}
@Component
class Dependency1 {
    public Dependency1() {
        System.out.println("Dependency1 created");
    }
}
@Component
class Dependency2 {
    public Dependency2() {
        System.out.println("Dependency2 created");
    }
}
@Configuration
@ComponentScan
public class DependencyInjectionLauncherApplication {
    public static void main(String[] args) {

        try (
                var context = new AnnotationConfigApplicationContext(DependencyInjectionLauncherApplication.class)
        ) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
            System.out.println(context.getBean(YourBuisnessClass.class));
        }
    }
}

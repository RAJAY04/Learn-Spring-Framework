package examples.f1;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;
@Component
class SomeClass{
    private SomeDependancy someDependancy;
    SomeClass(SomeDependancy someDependancy){
        super();
        this.someDependancy = someDependancy;
        System.out.println("all dependencies are ready");
    }
    @PostConstruct
    public void initialize(){
        someDependancy.getReady();
    }
    @PreDestroy
    public void cleanup(){
        System.out.println("cleanup");
    }

}
@Component
class SomeDependancy{
    public void getReady(){
        System.out.println("SOme logic using some dependency");
    }

}

@Configuration
@ComponentScan
public class PrePostAnnotationsContextLauncherApplication {
    public static void main(String[] args) {

        try (
                var context = new AnnotationConfigApplicationContext(PrePostAnnotationsContextLauncherApplication.class)
        ) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        }
    }
}

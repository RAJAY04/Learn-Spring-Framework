package examples.g1;

import examples.c1.DataService;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;
//@Component

//things cant be understodd i left at lecture number 43 and jumping on to spring
@Named
class BuisnessService{
    private DataService dataService;

    public DataService getDataService() {
        return dataService;
    }
//    @Autowired
    @Inject
    public void setDataService(DataService dataService) {
        System.out.println("setter injection");
        this.dataService = dataService;
    }
}
@Component
//class DataService{
//
//
//}

@Configuration
@ComponentScan
public class CdiContextLauncherApplication {
    public static void main(String[] args) {

        try (
                var context = new AnnotationConfigApplicationContext(CdiContextLauncherApplication.class)
        ) {
            System.out.println(context.getBean(BuisnessService.class).getDataService());        }
    }
}

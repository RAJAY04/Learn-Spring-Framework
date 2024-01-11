package examples.c1;

import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.util.Arrays;
@Component
public class BuisnessCalculationService {
    private DataService dataService;

    public BuisnessCalculationService(DataService dataService){
        super();
        this.dataService = dataService;
    }
    public int findMax(){
        return Arrays.stream(dataService.retrieve_data()).max().orElse(0);
    }
}

package gnuvil.grammer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;
import org.junit.jupiter.api.Test;


public class OptionalTest {

    public  String greet(String name, Optional<String> title){
        String greeting ="Hello";
        if(title.isPresent()){
            greeting += " " + title.get();
        }
        greeting += " " + name;
        return greeting;
    }

    @Test
    void optional_get_test(){
        String result = greet("john",Optional.empty());
        assertEquals("Hello john",result);
    }

    @Test
    void optional_get_value_test(){
        String result = greet("john",Optional.of("Ms."));
        assertEquals("Hello Ms. john",result);
    }


}


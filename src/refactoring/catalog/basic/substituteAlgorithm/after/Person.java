package refactoring.catalog.basic.substituteAlgorithm.after;

import java.util.Arrays;
import java.util.List;

/**
 * @author mdrozdz
 * Chapter 6. Composing Methods
 */
public class Person {
    String foundPerson(String[] people){
        List candidates = Arrays.asList(new String[] {"Don", "John",
                "Kent"});
        for (int i=0; i<people.length; i++)
            if (candidates.contains(people[i]))
                return people[i];
        return "";
    }
}

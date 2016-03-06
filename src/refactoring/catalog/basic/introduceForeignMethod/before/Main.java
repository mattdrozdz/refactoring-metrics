package refactoring.catalog.basic.introduceForeignMethod.before;

import java.util.Date;

/**
 * @author mdrozdz
 * Chapter 7. Moving Features Between Objects
 */
public class Main {
    private static Date previousEnd;

    public static void main(String[] args) {
        Date newStart = new Date(previousEnd.getYear(),
                previousEnd.getMonth(), previousEnd.getDate() + 1);
    }
}

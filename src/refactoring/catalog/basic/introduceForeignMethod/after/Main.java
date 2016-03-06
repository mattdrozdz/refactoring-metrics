package refactoring.catalog.basic.introduceForeignMethod.after;

import java.util.Date;

/**
 * @author mdrozdz
 * Chapter 7. Moving Features Between Objects
 */
public class Main {
    private static Date previousEnd;

    public static void main(String[] args) {
        Date newStart = nextDay(previousEnd);
    }

    private static Date nextDay(Date arg) {
        // foreign method, should be on date
        return new Date(arg.getYear(), arg.getMonth(), arg.getDate() +
                1);
    }
}

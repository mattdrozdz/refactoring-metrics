package refactoring.catalog.basic.extractmethod.before;

import java.util.Dictionary;
import java.util.Enumeration;

/**
 * @author mdrozdz
 * Chapter 6. Composing Methods
 */
public class Main {
    private Dictionary _orders;
    private String _name;

    void printOwing() {
        Enumeration e = _orders.elements();
        double outstanding = 0.0;
// print banner
        System.out.println ("**************************");
        System.out.println ("***** Customer Owes ******");
        System.out.println ("**************************");
// calculate outstanding
        while (e.hasMoreElements()) {
            Order each = (Order) e.nextElement();
            outstanding += each.getAmount();
        }
//print details
        System.out.println ("name:" + _name);
        System.out.println ("amount" + outstanding);
    }
}

package refactoring.catalog.basic.extractmethod.after;

import refactoring.catalog.basic.extractmethod.before.Order;

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
        printBanner();
        Enumeration e = _orders.elements();
        double outstanding = getOutstanding();
        printDetails(outstanding);
    }

    private void printDetails(double outstanding) {
        System.out.println ("name:" + _name);
        System.out.println ("amount" + outstanding);
    }

    private void printBanner() {
        System.out.println ("**************************");
        System.out.println ("***** Customer Owes ******");
        System.out.println ("**************************");
    }

    private double getOutstanding() {
        Enumeration e = _orders.elements();
        double result = 0.0;
        while (e.hasMoreElements()) {
            Order each = (Order) e.nextElement();
            result += each.getAmount();
        }
        return result;
    }
}

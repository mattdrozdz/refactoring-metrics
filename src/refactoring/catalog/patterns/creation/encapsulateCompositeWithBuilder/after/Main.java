package refactoring.catalog.patterns.creation.encapsulateCompositeWithBuilder.after;

/**
 * @author mdrozdz
 * prev step : Replace Implicit Tree with Composite
 */
public class Main {
    public static void main(String[] args) {
        XMLBuilder orders = new XMLBuilder("orders");
        orders.addBelow("order");
        orders.addAttribute("number", "123");
        orders.addBelow("item");
        orders.addAttribute("number", "x1786");
        orders.addValue("carDoor");

        System.out.println(orders.toString());
    }
}

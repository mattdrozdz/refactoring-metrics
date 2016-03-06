package refactoring.catalog.patterns.creation.encapsulateCompositeWithBuilder.before;

/**
 * @author mdrozdz
 * prev step : EReplace Implicit Tree with Composite
 */
public class Main {
    public static void main(String[] args) {
        TagNode orders = new TagNode("orders");
        TagNode order = new TagNode("order");
        order.addAttribute("number", "123");
        orders.add(order);
        TagNode item = new TagNode("item");
        item.addAttribute("number", "x1786");
        item.addValue("carDoor");
        order.add(item);

        System.out.println(orders.toString());
    }
}

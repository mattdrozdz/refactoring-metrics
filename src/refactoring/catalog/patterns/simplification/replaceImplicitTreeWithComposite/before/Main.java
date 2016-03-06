package refactoring.catalog.patterns.simplification.replaceImplicitTreeWithComposite.before;

/**
 * @author mdrozdz
 */
public class Main {
    public static void main(String[] args) {
        String orders = "<orders>";
        orders += "<order number='123'>";
        orders += "<item number='x1786'>";
        orders += "carDoor";
        orders += "</item>";
        orders += "</order>";
        orders += "</orders>";

        System.out.println(orders);
    }
}

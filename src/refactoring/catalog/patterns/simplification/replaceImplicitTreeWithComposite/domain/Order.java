package refactoring.catalog.patterns.simplification.replaceImplicitTreeWithComposite.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mdrozdz
 */
public class Order {
    private int orderId;
    private List<Product> products = new ArrayList<Product>();

    public Order(int orderId) {
        this.orderId = orderId;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getProductCount() {
        return products.size();
    }

    public Product getProduct(int i) {
        return products.get(i);
    }
}

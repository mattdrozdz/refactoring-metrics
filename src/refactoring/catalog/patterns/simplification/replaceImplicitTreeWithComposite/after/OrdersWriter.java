package refactoring.catalog.patterns.simplification.replaceImplicitTreeWithComposite.after;

import refactoring.catalog.patterns.simplification.replaceImplicitTreeWithComposite.domain.Order;
import refactoring.catalog.patterns.simplification.replaceImplicitTreeWithComposite.domain.Orders;
import refactoring.catalog.patterns.simplification.replaceImplicitTreeWithComposite.domain.Product;
import refactoring.catalog.patterns.simplification.replaceImplicitTreeWithComposite.domain.ProductSize;

/**
 * @author mdrozdz
 */
public class OrdersWriter {
    private Orders orders;

    public OrdersWriter(Orders orders) {
        this.orders = orders;
    }

    public String getContents() {
        StringBuffer xml = new StringBuffer();
        writeOrderTo(xml);
        return xml.toString();
    }

    private void writeOrderTo(StringBuffer xml) {
        TagNode ordersTag = new TagNode("orders");
        for (int i = 0; i < orders.getOrderCount(); i++) {
            Order order = orders.getOrder(i);
            TagNode orderTag = new TagNode("order");
            orderTag.addAttribute("id", String.valueOf(order.getOrderId()));
            writeProductsTo(orderTag, order);
            ordersTag.add(orderTag);
        }
        xml.append(ordersTag.toString());
    }

    private void writeProductsTo(TagNode orderTag, Order order) {
        for (int j=0; j < order.getProductCount(); j++) {
            Product product = order.getProduct(j);
            TagNode productTag = new TagNode("product");
            productTag.addAttribute("id", String.valueOf(product.getID()));
            productTag.addAttribute("color", colorFor(product));
            if (product.getSize() != ProductSize.NOT_APPLICABLE)
                productTag.addAttribute("size", sizeFor(product).toString());
            writePriceTo(productTag, product);
            productTag.addValue(product.getName());
            orderTag.add(productTag);
        }
    }

    private ProductSize sizeFor(Product product) {
        return product.getSize();
    }

    private String colorFor(Product product) {
        return "";
    }

    private void writePriceTo(TagNode productTag, Product product) {
        TagNode priceNode = new TagNode("price");
        priceNode.addAttribute("currency", currencyFor(product));
        priceNode.addValue(String.valueOf(product.getPrice()));
        productTag.add(priceNode);
    }

    private String currencyFor(Product product) {
        return "USD";
    }

}

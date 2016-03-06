package refactoring.catalog.patterns.simplification.replaceImplicitTreeWithComposite.before;

import refactoring.catalog.patterns.simplification.replaceImplicitTreeWithComposite.domain.Order;
import refactoring.catalog.patterns.simplification.replaceImplicitTreeWithComposite.domain.Orders;
import refactoring.catalog.patterns.simplification.replaceImplicitTreeWithComposite.domain.Product;
import refactoring.catalog.patterns.simplification.replaceImplicitTreeWithComposite.domain.ProductSize;

/**
 * @author mdrozdz
 * getContents(): applying Compose Method (123) and Move Accumulation to Collecting Parameter (313)
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
        xml.append("<orders>");
        for (int i = 0; i < orders.getOrderCount(); i++) {
            Order order = orders.getOrder(i);
            xml.append("<order");
            xml.append(" id='");
            xml.append(order.getOrderId());
            xml.append("'>");

            for (int j=0; j < order.getProductCount(); j++) {
                Product product = order.getProduct(j);
                xml.append("<product");
                xml.append(" id='");
                xml.append(product.getID());
                xml.append("'");
                xml.append(" color='");
                xml.append(colorFor(product));
                xml.append("'");
                if (product.getSize() != ProductSize.NOT_APPLICABLE) {
                    xml.append(" size='");
                    xml.append(sizeFor(product));
                    xml.append("'");
                }
                xml.append(">");

                xml.append("<price");
                xml.append(" currency='");
                xml.append(currencyFor(product));
                xml.append("'>");
                xml.append(product.getPrice());
                xml.append("</price>");

                xml.append(product.getName());
                xml.append("</product>");
            }

            xml.append("</order>");
        }
        xml.append("</orders>");
    }


    private ProductSize sizeFor(Product product) {
        return product.getSize();
    }

    private String colorFor(Product product) {
        return "";
    }

    private String currencyFor(Product product) {
        return "USD";
    }

}

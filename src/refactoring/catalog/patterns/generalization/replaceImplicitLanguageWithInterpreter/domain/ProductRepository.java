package refactoring.catalog.patterns.generalization.replaceImplicitLanguageWithInterpreter.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author mdrozdz
 */
public class ProductRepository {
    List<Product> products = new ArrayList<>();
    public Iterator iterator() {
        return products.iterator();
    }

    public void add(Product product) {
        products.add(product);
    }
}

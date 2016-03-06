package refactoring.catalog.patterns.generalization.replaceOneManyDistinctionsWithComposite.after;

import refactoring.catalog.patterns.generalization.replaceOneManyDistinctionsWithComposite.domain.Product;
import refactoring.catalog.patterns.generalization.replaceOneManyDistinctionsWithComposite.domain.Spec;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author mdrozdz
 */
public class ProductRepository {
    private List products = new ArrayList();

    public Iterator iterator() {
        return products.iterator();
    }

    public List<Product> selectBy(Spec spec) {
        Iterator<Product> productsTmp = iterator();
        while (productsTmp.hasNext()) {
            Product product = productsTmp.next();
            if (spec.isSatisfiedBy(product)) {
                products.add(product);
            }
        }

        return products;
    }
}

package refactoring.catalog.patterns.generalization.replaceImplicitLanguageWithInterpreter.after;

import refactoring.catalog.patterns.generalization.replaceImplicitLanguageWithInterpreter.domain.Product;
import refactoring.catalog.patterns.generalization.replaceImplicitLanguageWithInterpreter.domain.ProductRepository;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author mdrozdz
 */
public class ProductFinder {
    private ProductRepository repository;

    public ProductFinder(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> selectBy(Spec spec) {
        List<Product> foundProducts = new ArrayList<Product>();
        Iterator<Product> products = repository.iterator();
        while (products.hasNext()) {
            Product product = products.next();
            if (spec.isSatisfiedBy(product)) {
                foundProducts.add(product);
            }
        }
        return foundProducts;
    }

    public List<Product> belowPrice(float price) {
        BelowPriceSpec spec = new BelowPriceSpec(price);
        return selectBy(spec);
    }

    public List<Product> byColor(Color colorOfProductToFind) {
        ColorSpec spec = new ColorSpec(colorOfProductToFind);
        return selectBy(spec);
    }

    public List<Product> byColorAndBelowPrice(Color color, float price) {
        ColorSpec colorSpec = new ColorSpec(color);
        BelowPriceSpec priceSpec = new BelowPriceSpec(price);
        AndSpec spec = new AndSpec(colorSpec, priceSpec);
        return selectBy(spec);
    }

    public List<Product> belowPriceAvoidingAColor(float price, Color color) {
        BelowPriceSpec belowPriceSpec = new BelowPriceSpec(price);
        NotSpec notSpec = new NotSpec(new ColorSpec(color));
        AndSpec spec = new AndSpec(belowPriceSpec, notSpec);
        return selectBy(spec);
    }
}

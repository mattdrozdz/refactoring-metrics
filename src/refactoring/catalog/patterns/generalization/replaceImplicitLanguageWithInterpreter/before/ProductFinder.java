package refactoring.catalog.patterns.generalization.replaceImplicitLanguageWithInterpreter.before;

import refactoring.catalog.patterns.generalization.replaceImplicitLanguageWithInterpreter.domain.Product;
import refactoring.catalog.patterns.generalization.replaceImplicitLanguageWithInterpreter.domain.ProductRepository;
import refactoring.catalog.patterns.generalization.replaceImplicitLanguageWithInterpreter.domain.ProductSize;

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

    public List byColor(Color colorOfProductToFind) {
        List foundProducts = new ArrayList();
        Iterator products = repository.iterator();
        while (products.hasNext()) {
            Product product = (Product) products.next();
            if (product.getColor().equals(colorOfProductToFind))
                foundProducts.add(product);
        }
        return foundProducts;
    }
    public List byPrice(float priceLimit) {
        List foundProducts = new ArrayList();
        Iterator products = repository.iterator();
        while (products.hasNext()) {
            Product product = (Product) products.next();
            if (product.getPrice() == priceLimit)
                foundProducts.add(product);
        }
        return foundProducts;
    }

    public List byColorSizeAndBelowPrice(Color color, ProductSize size, float price) {
        List foundProducts = new ArrayList();
        Iterator products = repository.iterator();
        while (products.hasNext()) {
            Product product = (Product) products.next();
            if (product.getColor() == color
                    && product.getSize() == size
                    && product.getPrice() < price)
                foundProducts.add(product);
        }
        return foundProducts;
    }

    public List belowPriceAvoidingAColor(float price, Color color) {
        List foundProducts = new ArrayList();
        Iterator products = repository.iterator();
        while (products.hasNext()) {
            Product product = (Product) products.next();
            if (product.getPrice() < price && product.getColor() != color)
                foundProducts.add(product);
        }
        return foundProducts;
    }
}

package refactoring.catalog.patterns.generalization.replaceImplicitLanguageWithInterpreter.after;

import refactoring.catalog.patterns.generalization.replaceImplicitLanguageWithInterpreter.domain.Product;
import refactoring.catalog.patterns.generalization.replaceImplicitLanguageWithInterpreter.domain.ProductSize;

/**
 * @author mdrozdz
 */
public class SizeSpec extends Spec {
    private final ProductSize productSize;

    public SizeSpec(ProductSize productSize) {
        this.productSize = productSize;
    }

    @Override
    public boolean isSatisfiedBy(Product product) {
        return product.getSize().equals(productSize);
    }
}

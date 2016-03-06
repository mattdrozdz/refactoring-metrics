package refactoring.catalog.patterns.generalization.replaceImplicitLanguageWithInterpreter.after;

import refactoring.catalog.patterns.generalization.replaceImplicitLanguageWithInterpreter.domain.Product;

/**
 * @author mdrozdz
 */
public class BelowPriceSpec extends Spec {
    private final float priceThreshold;

    public BelowPriceSpec(float priceThreshold) {
        this.priceThreshold = priceThreshold;
    }

    @Override
    public boolean isSatisfiedBy(Product product) {
        return product.getPrice() < priceThreshold;
    }

}

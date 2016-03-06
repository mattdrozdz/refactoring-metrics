package refactoring.catalog.patterns.generalization.replaceImplicitLanguageWithInterpreter.after;

import refactoring.catalog.patterns.generalization.replaceImplicitLanguageWithInterpreter.domain.Product;

/**
 * @author mdrozdz
 */
public class NotSpec extends Spec {
    private final Spec specToNegate;

    public NotSpec(Spec specToNegate) {
        this.specToNegate = specToNegate;
    }

    @Override
    public boolean isSatisfiedBy(Product product) {
        return !specToNegate.isSatisfiedBy(product);
    }
}

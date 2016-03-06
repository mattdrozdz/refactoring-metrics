package refactoring.catalog.patterns.generalization.replaceImplicitLanguageWithInterpreter.after;

import refactoring.catalog.patterns.generalization.replaceImplicitLanguageWithInterpreter.domain.Product;

/**
 * @author mdrozdz
 */
public abstract class Spec {
    public abstract boolean isSatisfiedBy(Product product);
}

package refactoring.catalog.patterns.generalization.replaceImplicitLanguageWithInterpreter.after;

import refactoring.catalog.patterns.generalization.replaceImplicitLanguageWithInterpreter.domain.Product;

import java.awt.*;

/**
 * @author mdrozdz
 */
public class ColorSpec extends Spec {
    private final Color colorOfProductToFind;

    public ColorSpec(Color colorOfProductToFind) {
        this.colorOfProductToFind = colorOfProductToFind;
    }

    @Override
    public boolean isSatisfiedBy(Product product) {
        return product.getColor().equals(colorOfProductToFind);
    }
}

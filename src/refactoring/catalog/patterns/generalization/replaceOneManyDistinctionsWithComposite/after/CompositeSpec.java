package refactoring.catalog.patterns.generalization.replaceOneManyDistinctionsWithComposite.after;

import refactoring.catalog.patterns.generalization.replaceOneManyDistinctionsWithComposite.domain.Product;
import refactoring.catalog.patterns.generalization.replaceOneManyDistinctionsWithComposite.domain.Spec;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @author mdrozdz
 */
public class CompositeSpec extends Spec {
    private List<Spec> specs = new ArrayList<Spec>();

    public void add(Spec spec) {
        specs.add(spec);
    }

    public List<Spec> getSpecs() {
        return Collections.unmodifiableList(specs);
    }

    @Override
    public boolean isSatisfiedBy(Product product) {
        Iterator<Spec> specifications = getSpecs().iterator();
        boolean satisfiesAllSpecs = true;
        while (specifications.hasNext()) {
            Spec productSpec = specifications.next();
            satisfiesAllSpecs &= productSpec.isSatisfiedBy(product);
        }
        return satisfiesAllSpecs;
    }
}

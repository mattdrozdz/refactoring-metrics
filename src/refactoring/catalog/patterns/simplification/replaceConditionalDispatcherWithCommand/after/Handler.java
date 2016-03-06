package refactoring.catalog.patterns.simplification.replaceConditionalDispatcherWithCommand.after;

import refactoring.catalog.patterns.simplification.replaceConditionalDispatcherWithCommand.domain.HandlerResponse;
import refactoring.catalog.patterns.simplification.replaceConditionalDispatcherWithCommand.domain.WorkshopManager;

import java.util.Map;

/**
 * @author mdrozdz
 */
public abstract class Handler {
    protected CatalogApp catalogApp;

    public Handler(CatalogApp catalogApp) {
        this.catalogApp = catalogApp;
    }

    public abstract HandlerResponse execute(Map parameters) throws Exception;
}

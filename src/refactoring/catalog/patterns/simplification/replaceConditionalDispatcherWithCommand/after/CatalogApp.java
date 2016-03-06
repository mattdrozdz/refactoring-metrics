package refactoring.catalog.patterns.simplification.replaceConditionalDispatcherWithCommand.after;

import refactoring.catalog.patterns.simplification.replaceConditionalDispatcherWithCommand.domain.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mdrozdz
 */
public class CatalogApp {
    private static final String NEW_WORKSHOP = "NEW_WORKSHOP";
    public static final String ALL_WORKSHOPS = "ALL_WORKSHOPS";

    private WorkshopManager workshopManager;
    private Map<String, Handler> handlers;

    public CatalogApp(WorkshopManager workshopManager) {
        this.workshopManager = workshopManager;
        createHandlers();
    }

    public HandlerResponse executeActionAndGetResponse(String handlerName, Map parameters) throws Exception {
        Handler handler = lookupHandlerBy(handlerName);
        return handler.execute(parameters);
    }

    public WorkshopManager getWorkshopManager() {
        return workshopManager;
    }

    public void createHandlers() {
        handlers = new HashMap<String, Handler>();
        handlers.put(NEW_WORKSHOP, new NewWorkshopHandler(this));
        handlers.put(ALL_WORKSHOPS, new AllWorkshopsHandler(this));
    }

    private Handler lookupHandlerBy(String handlerName) {
        return handlers.get(handlerName);
    }
}
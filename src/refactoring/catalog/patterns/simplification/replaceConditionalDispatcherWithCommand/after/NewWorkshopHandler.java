package refactoring.catalog.patterns.simplification.replaceConditionalDispatcherWithCommand.after;

import refactoring.catalog.patterns.simplification.replaceConditionalDispatcherWithCommand.domain.HandlerResponse;
import refactoring.catalog.patterns.simplification.replaceConditionalDispatcherWithCommand.domain.WorkshopManager;

import java.util.Map;

/**
 * @author mdrozdz
 * + Compose Method
 */
public class NewWorkshopHandler extends Handler {

    public NewWorkshopHandler(CatalogApp catalogApp) {
        super(catalogApp);
    }

    @Override
    public HandlerResponse execute(Map parameters) throws Exception {
        createNewWorkshop(parameters);
        return catalogApp.executeActionAndGetResponse(CatalogApp.ALL_WORKSHOPS, parameters);
    }

    private void createNewWorkshop(Map parameters) throws Exception {
        String nextWorkshopID = workshopManager().getNextWorkshopID();
        workshopManager().addWorkshop(newWorkshopContents(nextWorkshopID));
        parameters.put("id", nextWorkshopID);
    }

    private StringBuffer newWorkshopContents(String nextWorkshopID) throws Exception {
        StringBuffer newWorkshopContents = workshopManager().createNewFileFromTemplate(
                nextWorkshopID,
                workshopManager().getWorkshopDir(),
                workshopManager().getWorkshopTemplate()
        );
        return newWorkshopContents;
    }

    private WorkshopManager workshopManager() {
        return catalogApp.getWorkshopManager();
    }

}

package refactoring.catalog.patterns.simplification.replaceConditionalDispatcherWithCommand.domain;

/**
 * @author mdrozdz
 */
public class WorkshopManager {
    public String getNextWorkshopID() {
        return null;
    }

    public String getWorkshopDir() {
        return null;
    }

    public String getWorkshopTemplate() {
        return null;
    }

    public StringBuffer createNewFileFromTemplate(String nextWorkshopID, String nextWorkshopDir, String nextWorkTemplate) {
        return null;
    }

    public void addWorkshop(StringBuffer newWorkshopContents) {}

    public WorkshopRepository getWorkshopRepository() {
        return null;
    }
}

package refactoring.catalog.patterns.simplification.replaceConditionalDispatcherWithCommand.after;

import refactoring.catalog.patterns.simplification.replaceConditionalDispatcherWithCommand.domain.*;

import java.util.Iterator;
import java.util.Map;

/**
 * @author mdrozdz
 */
public class AllWorkshopsHandler extends Handler {
    private static final String ALL_WORKSHOPS_STYLESHEET = "allWorkshops.xsl";

    private PrettyPrinter prettyPrinter = new PrettyPrinter();

    public AllWorkshopsHandler(CatalogApp catalogApp) {
        super(catalogApp);
    }

    @Override
    public HandlerResponse execute(Map parameters) throws Exception {
        return new HandlerResponse(new StringBuffer(prettyPrint(allWorkshopsData())), ALL_WORKSHOPS_STYLESHEET);
    }

    private String allWorkshopsData() {
        XMLBuilder allWorkshopsXml = new XMLBuilder("workshops");
        WorkshopRepository repository = catalogApp.getWorkshopManager().getWorkshopRepository();
        Iterator ids = repository.keyIterator();
        while (ids.hasNext()) {
            String id = (String) ids.next();
            Workshop workshop = repository.getWorkshop(id);
            allWorkshopsXml.addBelowParent("workshop");
            allWorkshopsXml.addAttribute("id", workshop.getID());
            allWorkshopsXml.addAttribute("name", workshop.getName());
            allWorkshopsXml.addAttribute("status", workshop.getStatus());
            allWorkshopsXml.addAttribute("duration", workshop.getDurationAsString());
        }
        return getFormattedData(allWorkshopsXml.toString());
    }

    private String getFormattedData(String s) {
        return null;
    }

    private String prettyPrint(String buffer) {
        return prettyPrinter.format(buffer);
    }
}

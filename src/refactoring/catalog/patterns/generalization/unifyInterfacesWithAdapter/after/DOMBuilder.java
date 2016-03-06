package refactoring.catalog.patterns.generalization.unifyInterfacesWithAdapter.after;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.Stack;


/**
 * @author mdrozdz
 */
public class DOMBuilder extends AbstractBuilder {
    private Document document;

    public DOMBuilder(Document document) {
        this.document = document;
    }

    @Override
    public XMLNode createNode(String name) {
        return new ElementAdapter(document.createElement(name), document);
    }
}

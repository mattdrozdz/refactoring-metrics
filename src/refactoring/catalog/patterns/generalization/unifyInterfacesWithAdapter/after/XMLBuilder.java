package refactoring.catalog.patterns.generalization.unifyInterfacesWithAdapter.after;

/**
 * @author mdrozdz
 */
public class XMLBuilder extends AbstractBuilder {
    @Override
    public XMLNode createNode(String name) {
        return new TagNode(name);
    }
}

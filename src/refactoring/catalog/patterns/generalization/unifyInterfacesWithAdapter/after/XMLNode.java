package refactoring.catalog.patterns.generalization.unifyInterfacesWithAdapter.after;

/**
 * @author mdrozdz
 */
public interface XMLNode {
    void add(XMLNode childNode);

    void addAttribute(String attribute, String value);

    void addValue(String value);
}

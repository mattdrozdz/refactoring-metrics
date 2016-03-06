package refactoring.catalog.patterns.creation.encapsulateCompositeWithBuilder.after;

/**
 * @author mdrozdz
 */
public class XMLBuilder {
    private TagNode root;
    private TagNode current;
    private TagNode parent;

    public XMLBuilder(String rootName) {
        root = new TagNode(rootName);
        current = root;
        parent = root;
    }

    public void addBelow(String child) {
        TagNode childNode = new TagNode(child);
        current.add(childNode);
        parent = current;
        current = childNode;
    }

    public void addBeside(String sibling) {
        TagNode siblingNode = new TagNode(sibling);
        parent.add(siblingNode);
        current = siblingNode;
    }

    public void addAttribute(String name, String value) {
        current.addAttribute(name, value);
    }

    public void addValue(String value) {
        current.addValue(value);
    }

    public String toString() {
        return root.toString();
    }


}

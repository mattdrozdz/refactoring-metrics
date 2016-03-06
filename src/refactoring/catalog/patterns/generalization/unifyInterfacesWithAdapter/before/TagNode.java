package refactoring.catalog.patterns.generalization.unifyInterfacesWithAdapter.before;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mdrozdz
 * prev step: Replace Implicit Tree with Composite / Encapsulate Composite with Builder
 */
public class TagNode {
    private String tagName;
    private String tagValue = "";
    private String attributes = "";
    private List<TagNode> children = new ArrayList();
    private TagNode parent;

    public TagNode(String name) {
        tagName = name;
    }

    public void add(TagNode childNode) {
        children.add(childNode);
    }

    public void addAttribute(String name, String value) {
        attributes += (" " + name + "='" + value + "'");
    }

    public void addValue(String value) {
        tagValue = value;
    }

    public TagNode getParent() {
        return parent;
    }

    public void setParent(TagNode parent) {
        this.parent = parent;
    }

    public String toString() {
        String result = new String();
        result += "<" + tagName + attributes + ">";
        for (TagNode child : children) {
            result += child.toString();
        }
        if (!tagValue.equals(""))
            result += tagValue;
        result += "</" + tagName + ">";
        return result;
    }
}

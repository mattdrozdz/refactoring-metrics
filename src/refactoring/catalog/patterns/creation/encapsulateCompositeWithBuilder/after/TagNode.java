package refactoring.catalog.patterns.creation.encapsulateCompositeWithBuilder.after;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mdrozdz
 * next step: Move Accumulation to Collecting Parameter
 */
public class TagNode {
    private String tagName;
    private String tagValue = "";
    private String attributes = "";
    private List<TagNode> children = new ArrayList();

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

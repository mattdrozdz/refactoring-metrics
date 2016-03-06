package refactoring.catalog.patterns.accumulation.moveAccumulationToCollectingPattern.after;

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
        StringBuilder result = new StringBuilder();
        toStringHelper(result);
        return result.toString();

    }

    private void toStringHelper(StringBuilder result) {
        writeOpenTagTo(result);
        writeChildernTo(result);
        writeValueTo(result);
        writeEndTagTo(result);
    }

    private void writeOpenTagTo(StringBuilder result) {
        result.append("<");
        result.append(tagName);
        result.append(attributes.toString());
        result.append(">");
    }

    private void writeChildernTo(StringBuilder result) {
        for (TagNode child : children) {
            child.toStringHelper(result);
        }
    }

    private void writeValueTo(StringBuilder result) {
        if (!tagValue.equals(""))
            result.append(tagValue);
    }

    private void writeEndTagTo(StringBuilder result) {
        result.append("</");
        result.append(tagName);
        result.append(">");
    }
}

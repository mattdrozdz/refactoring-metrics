package refactoring.catalog.patterns.generalization.extractComposite.after;

import refactoring.catalog.patterns.generalization.extractComposite.domain.Node;
import refactoring.catalog.patterns.generalization.extractComposite.domain.Tag;

import java.util.Enumeration;
import java.util.List;
import java.util.Map;

/**
 * @author mdrozdz
 */
public class LinkTag extends CompositeTag {
    private Map<String,String> parsed;

    public LinkTag(int tagBegin, int tagEnd, String tagContents, String tagLine) {
        super(tagBegin, tagEnd, tagContents, tagLine);
    }

    public String toHTML() {
        StringBuffer sb = new StringBuffer();
        putStartTagInto(sb);
        Node node;
        for (Enumeration e = children();e.hasMoreElements();) {
            node = (Node)e.nextElement();
            sb.append(node.toHTML());
        }
        sb.append("</A>");
        return sb.toString();
    }

}

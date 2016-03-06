package refactoring.catalog.patterns.generalization.extractComposite.after;

import refactoring.catalog.patterns.generalization.extractComposite.domain.Node;
import refactoring.catalog.patterns.generalization.extractComposite.domain.Tag;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @author mdrozdz
 * TODO not finished yet
 */
public abstract class CompositeTag extends Tag {
    protected Vector children;

    public CompositeTag(int tagBegin, int tagEnd, String tagContents, String tagLine) {
        super(tagBegin, tagEnd, tagContents, tagLine);
    }

    public Enumeration children() {
        return children.elements();
    }

    public String toPlainTextString() {
        StringBuffer stringRepresentation = new StringBuffer();
        Node node;
        for (Enumeration e = children(); e.hasMoreElements(); ) {
            node = (Node) e.nextElement();
            stringRepresentation.append(node.toPlainTextString());
        }
        return stringRepresentation.toString();
    }

    public void putStartTagInto(StringBuffer sb) {
        sb.append("<" + TAGNAME + " ");
        String key, value;
        int i = 0;
        for (Enumeration e = getParsed().keys();e.hasMoreElements();) {
            key = (String)e.nextElement();
            i++;
            if (key!=TAGNAME) {
                value = getParameter(key);
                sb.append(key+"=\""+value+"\"");
                if (i<getParsed().size()) sb.append(" ");
            }
        }
        sb.append(">");
    }

    protected String getParameter(String key) {
        return null;
    }
}

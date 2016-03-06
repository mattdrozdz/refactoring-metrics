package refactoring.catalog.patterns.generalization.extractComposite.before;

import refactoring.catalog.patterns.generalization.extractComposite.domain.Node;
import refactoring.catalog.patterns.generalization.extractComposite.domain.Tag;

import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/**
 * @author mdrozdz
 */
public class LinkTag extends Tag {
    private Vector nodeVector;
    private Map<String,String> parsed;
    private String TAGNAME;

    public LinkTag(int tagBegin, int tagEnd, String tagContents, String tagLine) {
        super(tagBegin, tagEnd, tagContents, tagLine);
    }

    public String toPlainTextString() {
        StringBuffer sb = new StringBuffer();
        Node node;
        for (Enumeration e=linkData();e.hasMoreElements();) {
            node = (Node)e.nextElement();
            sb.append(node.toPlainTextString());
        }
        return sb.toString();
    }

    public String toHTML() {
        StringBuffer sb = new StringBuffer();
        putLinkStartTagInto(sb);
        Node node;
        for (Enumeration e = linkData();e.hasMoreElements();) {
            node = (Node)e.nextElement();
            sb.append(node.toHTML());
        }
        sb.append("</A>");
        return sb.toString();
    }

    public void putLinkStartTagInto(StringBuffer sb) {
        sb.append("<A ");
        String key,value;
        int i = 0;
        for (Enumeration e = (Enumeration) parsed.keySet();e.hasMoreElements();) {
            key = (String)e.nextElement();
            i++;
            if (key!=TAGNAME) {
                value = getParameter(key);
                sb.append(key+"=\""+value+"\"");
                if (i<parsed.size()-1) sb.append(" ");
            }
        }
        sb.append(">");
    }

    private String getParameter(String key) {
        return null;
    }

    private Enumeration linkData() {
        return nodeVector.elements();
    }
}

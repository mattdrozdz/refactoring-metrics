package refactoring.catalog.patterns.generalization.extractComposite.after;

import refactoring.catalog.patterns.creation.moveCreationKnowledgeToFactory.after.StringNode;
import refactoring.catalog.patterns.generalization.extractComposite.domain.Node;
import refactoring.catalog.patterns.generalization.extractComposite.domain.Tag;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

/**
 * @author mdrozdz
 */
public class FormTag extends CompositeTag {
    private String formMethod;
    private String formURL;
    private String formName;
    private StringNode lineSeparator;

    public FormTag(int tagBegin, int tagEnd, String tagContents, String tagLine) {
        super(tagBegin, tagEnd, tagContents, tagLine);
    }

    public String toHTML() {
        StringBuffer rawBuffer = new StringBuffer();
        Node node,prevNode=null;
        rawBuffer.append("<FORM METHOD=\""+formMethod+"\" ACTION=\""+formURL+"\"");
        if (formName!=null && formName.length()>0)
            rawBuffer.append(" NAME=\""+formName+"\"");
        Enumeration e = children.elements();
        node = (Node)e.nextElement();
        Tag tag = (Tag)node;
        Hashtable table = tag.getParsed();
        String key,value;
        for (Enumeration en = table.keys();en.hasMoreElements();) {
            key=(String)en.nextElement();
            if (!(key.equals("METHOD")
                    || key.equals("ACTION")
                    || key.equals("NAME")
                    || key.equals(Tag.TAGNAME))) {
                value = (String)table.get(key);
                rawBuffer.append(" "+key+"="+"\""+value+"\"");
            }
        }
        rawBuffer.append(">");
        rawBuffer.append(lineSeparator);
        for (;e.hasMoreElements();) {
            node = (Node)e.nextElement();
            if (prevNode!=null) {
                if (prevNode.elementEnd()>node.elementBegin()) {
                    // It's a new line
                    rawBuffer.append(lineSeparator);
                }
            }
            rawBuffer.append(node.toHTML());
            prevNode=node;
        }
        return rawBuffer.toString();
    }

    @Override
    public void putStartTagInto(StringBuffer sb) {
        Node node,prevNode=null;
        sb.append("<FORM METHOD=\"" + formMethod + "\" ACTION=\"" + formURL + "\"");
        if (formName!=null && formName.length()>0)
            sb.append(" NAME=\""+formName+"\"");
        Enumeration e = children.elements();
        node = (Node)e.nextElement();
        Tag tag = (Tag)node;
        Hashtable table = tag.getParsed();
        String key,value;
        for (Enumeration en = table.keys();en.hasMoreElements();) {
            key=(String)en.nextElement();
            if (!(key.equals("METHOD")
                    || key.equals("ACTION")
                    || key.equals("NAME")
                    || key.equals(Tag.TAGNAME))) {
                value = (String)table.get(key);
                sb.append(" " + key + "=" + "\"" + value + "\"");
            }
        }
        sb.append(">");
    }
}

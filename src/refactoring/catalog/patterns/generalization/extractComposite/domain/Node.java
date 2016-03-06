package refactoring.catalog.patterns.generalization.extractComposite.domain;

/**
 * @author mdrozdz
 */
public class Node extends Tag {

    public Node(int tagBegin, int tagEnd, String tagContents, String tagLine) {
        super(tagBegin, tagEnd, tagContents, tagLine);
    }

    public String toPlainTextString() {
        return null;
    }

    public String toHTML() {
        return null;
    }

    public int elementEnd() {
        return tagBegin;
    }

    public int elementBegin() {
        return tagBegin;
    }

}

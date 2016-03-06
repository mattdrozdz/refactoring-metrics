package refactoring.catalog.patterns.generalization.extractComposite.domain;

import java.util.Hashtable;

/**
 * @author mdrozdz
 */
public class Tag {
    public static String TAGNAME;
    int tagBegin;
    int tagEnd;
    String tagContents;
    String tagLine;

    public Tag(int tagBegin, int tagEnd, String tagContents, String tagLine) {
        this.tagBegin = tagBegin;
        this.tagEnd = tagEnd;
        this.tagContents = tagContents;
        this.tagLine = tagLine;
    }

    public Hashtable getParsed() {
        return null;
    }
}

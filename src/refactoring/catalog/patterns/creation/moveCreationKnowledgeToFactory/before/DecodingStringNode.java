package refactoring.catalog.patterns.creation.moveCreationKnowledgeToFactory.before;

/**
 * @author mdrozdz
 */
public class DecodingStringNode extends StringNode {
    public DecodingStringNode(StringNode stringNode) {

    }

    public DecodingStringNode(StringBuffer textBuffer, int textBegin, int textEnd) {
        super(textBuffer, textBegin, textEnd);
    }
}

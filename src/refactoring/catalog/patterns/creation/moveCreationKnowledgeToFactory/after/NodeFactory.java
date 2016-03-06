package refactoring.catalog.patterns.creation.moveCreationKnowledgeToFactory.after;

/**
 * @author mdrozdz
 */
public class NodeFactory {
    public Node createStringNode(
            StringBuffer textBuffer, int textBegin, int textEnd, boolean shouldDecode) {
        if (shouldDecode)
            return new DecodingStringNode(
                    new StringNode(textBuffer, textBegin, textEnd)
            );
        return new StringNode(textBuffer, textBegin, textEnd);
    }
}

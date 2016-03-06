package refactoring.catalog.patterns.creation.moveCreationKnowledgeToFactory.before;

/**
 * @author mdrozdz
 */
public class Parser {
    private boolean shouldDecode;

    public void setNodeDecoding(boolean shouldDecode){
        this.shouldDecode = shouldDecode;
    }

    public boolean shouldDecodeNodes(){
        return shouldDecode;
    }
}

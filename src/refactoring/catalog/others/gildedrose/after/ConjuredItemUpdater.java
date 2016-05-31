package refactoring.catalog.others.gildedrose.after;

/**
 * @author mdrozdz
 */
public class ConjuredItemUpdater extends ItemUpdater {
    public ConjuredItemUpdater(Item item) {
        super(item);
    }

    @Override
    protected int quantityAdjustment() {
        return super.quantityAdjustment() * 2;
    }
}

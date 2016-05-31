package refactoring.catalog.others.gildedrose.after;

/**
 * @author mdrozdz
 */
public class LegendaryItemUpdater extends ItemUpdater {
    public LegendaryItemUpdater(Item item) {
        super(item);
    }

    @Override
    protected int adjustQuantity() {
        return 0;
    }

    @Override
    public void adjustSellIn() {
    }
}

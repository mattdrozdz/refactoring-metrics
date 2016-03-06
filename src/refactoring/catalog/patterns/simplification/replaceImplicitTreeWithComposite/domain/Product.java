package refactoring.catalog.patterns.simplification.replaceImplicitTreeWithComposite.domain;

/**
 * @author mdrozdz
 */
public class Product {
    private int ID;
    private String name;
    private ProductSize size;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getPrice() {
        return 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductSize getSize() {
        return size;
    }

    public void setSize(ProductSize size) {
        this.size = size;
    }
}

package refactoring.catalog.patterns.generalization.replaceImplicitLanguageWithInterpreter.domain;

import java.awt.*;

/**
 * @author mdrozdz
 */
public class Product {
    String code;
    String name;
    Color color;
    float price;
    ProductSize size;

    public Product(String code, String name, Color color, float price, ProductSize size) {
        this.code = code;
        this.name = name;
        this.color = color;
        this.price = price;
        this.size = size;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public ProductSize getSize() {
        return size;
    }
}

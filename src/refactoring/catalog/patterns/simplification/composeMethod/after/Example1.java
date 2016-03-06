package refactoring.catalog.patterns.simplification.composeMethod.after;

import java.awt.*;

/**
 * @author mdrozdz
 * Compose Method
 */
public class Example1 {
    private double[] coords;

    public boolean contains(Component c) {
        return completelyWithin(c) || partiallyWithin(c);
    }

    private boolean completelyWithin(Component c) {
        Point p = c.getLocation();
        return (p.x >= coords[0] &&
                p.y >= coords[1] &&
                (p.x + CardComponent.WIDTH) <= coords[2] &&
                (p.y + CardComponent.HEIGHT) <= coords[3]);
    }

    private boolean partiallyWithin(Component c) {
        Point p = c.getLocation();
        return ((p.x + CardComponent.WIDTH) > coords[0] &&
                (p.y + CardComponent.HEIGHT) > coords[1] &&
                (p.x + CardComponent.WIDTH) < coords[2] &&
                (p.y + CardComponent.HEIGHT) < coords[3]);
    }

    private class CardComponent extends Component {
    }
}

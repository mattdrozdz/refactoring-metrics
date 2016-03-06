package refactoring.catalog.patterns.simplification.composeMethod.before;

import java.awt.*;

/**
 * @author mdrozdz
 * Compose Method
 */
public class Example1 {
    private double[] coords;

    public boolean contains(Component c) {
        Point p = c.getLocation();
        int locX = new Double(p.getX()).intValue();
        int locY = new Double(p.getY()).intValue();
        boolean completelyWithin =
                (locX >= coords[0] &&
                        locY >= coords[1] &&
                        (locX + CardComponent.WIDTH) <= coords[2]) &&
                        (locY + CardComponent.HEIGHT) <= coords[3];
        if (completelyWithin) return true;
        locX = locX + CardComponent.WIDTH;
        locY = locY + CardComponent.HEIGHT;
        boolean partiallyWithin =
                (locX > coords[0] &&
                        locY > coords[1] &&
                        (locX < coords[2]) &&
                        (locY < coords[3]));
        return partiallyWithin;
    }

    private class CardComponent extends Component {
    }
}

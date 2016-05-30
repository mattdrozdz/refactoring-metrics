package refactoring.catalog.cleancode.args.after;

import java.util.Iterator;

/**
 * @author mdrozdz
 */
public interface ArgumentMarshaler {
    void set(Iterator<String> currentArgument) throws ArgsException;
}

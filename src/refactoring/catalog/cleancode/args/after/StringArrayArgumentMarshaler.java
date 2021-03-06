package refactoring.catalog.cleancode.args.after;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import static refactoring.catalog.cleancode.args.after.ArgsException.ErrorCode.*;

/**
 * @author mdrozdz
 */
public class StringArrayArgumentMarshaler implements ArgumentMarshaler {
    private List<String> strings = new ArrayList<String>();

    @Override
    public void set(Iterator<String> currentArgument) throws ArgsException {
        try {
            strings.add(currentArgument.next());
        } catch (NoSuchElementException e) {
            throw new ArgsException(MISSING_STRING);
        }
    }

    public static String[] getValue(ArgumentMarshaler am) {
        if (am != null && am instanceof StringArrayArgumentMarshaler)
            return ((StringArrayArgumentMarshaler) am).strings.toArray(new String[0]);
        else
            return new String[0];
    }

}

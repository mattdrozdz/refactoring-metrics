package refactoring.catalog.cleancode.args.after;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static refactoring.catalog.cleancode.args.after.ArgsException.ErrorCode.MISSING_STRING;

/**
 * @author mdrozdz
 */
public class StringArgumentMarshaler implements ArgumentMarshaler {
    private String stringValue = "";

    @Override
    public void set(Iterator<String> currentArgument) throws ArgsException {
        try {
            stringValue = currentArgument.next();
        } catch (NoSuchElementException e) {
            throw new ArgsException(MISSING_STRING);
        }
    }

    public static String getValue(ArgumentMarshaler am) {
        if (am != null && am instanceof StringArgumentMarshaler)
            return ((StringArgumentMarshaler) am).stringValue;
        else
            return "";
    }
}

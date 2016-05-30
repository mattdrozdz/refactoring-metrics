package refactoring.catalog.cleancode.args.before;

import refactoring.catalog.cleancode.args.after.*;

/**
 * @author mdrozdz
 */
public class Main {
    public static void main(String[] args) {
        try {
            refactoring.catalog.cleancode.args.after.Args arg = new refactoring.catalog.cleancode.args.after.Args("l,p#,d*", args);
            boolean logging = arg.getBoolean('l');
            int port = arg.getInt('p');
            String directory = arg.getString('d');
            executeApplication(logging, port, directory);
        } catch (ArgsException e) {
            System.out.printf("Argument error: %s\n", e.errorMessage());
        }
    }
    private static void executeApplication(boolean logging, int port, String directory) {
    }

}

package refactoring.catalog.others.lansimulation.after.internals;

import java.io.IOException;
import java.io.Writer;

/**
 * @author mdrozdz
 */
public class Printer extends Node{
    public Printer(String name) {
        super(name);
    }

    public Printer(String name, Node nextNode) {
        super(name, nextNode);
    }

    public boolean printDocument(Packet document, Writer report) {
        try {
            if (document.isPostScript()) {
                accountPrintJob(report, document.getAuthor(), document.getTitle());
                report.write(">>> Postscript job delivered.\n\n");
                report.flush();
            } else {
                accountPrintJob(report, document.getAuthor(), document.getTitle());
                report.write(">>> ASCII Print job delivered.\n\n");
                report.flush();
            }

        } catch (IOException exc) {
            // just ignore
        }
        return true;
    }

    private void accountPrintJob(Writer report, String author, String title)
            throws IOException {
        report.write("\tAccounting -- author = '");
        report.write(author);
        report.write("' -- title = '");
        report.write(title);
        report.write("'\n");
    }

    public void printOn(StringBuffer buf) {
        buf.append("Printer ");
        buf.append(this.name_);
        buf.append(" [Printer]");
    }

    public void printXMLOn(StringBuffer buf) {
        buf.append("<printer>");
        buf.append(this.name_);
        buf.append("</printer>");
    }
}

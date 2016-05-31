/*   This file is part of lanSimulation.
 *
 *   lanSimulation is free software; you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation; either version 2 of the License, or
 *   (at your option) any later version.
 *
 *   lanSimulation is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with lanSimulation; if not, write to the Free Software
 *   Foundation, Inc. 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 *
 *   Copyright original Java version: 2004 Bart Du Bois, Serge Demeyer
 *   Copyright C++ version: 2006 Matthias Rieger, Bart Van Rompaey
 */
package refactoring.catalog.others.lansimulation.after.internals;

import java.io.IOException;
import java.io.Writer;

/**
 * A <em>Node</em> represents a single Node in a Local Area Network (LAN).
 * Several types of Nodes exist.
 */
public class Node {
    /**
     * Holds the name of the Node.
     */
    public String name_;

    /**
     * Holds the next Node in the token ring architecture.
     *
     * @see refactoring.catalog.others.lansimulation.after.internals.Node
     */
    public Node nextNode_;

    /**
     * Construct a <em>Node</em> with given #name.
     */
    public Node(String name) {
        name_ = name;
        nextNode_ = null;
    }

    /**
     * Construct a <em>Node</em> with given #name, and which is
     * linked to #nextNode.
     */
    public Node(String name, Node nextNode) {
        name_ = name;
        nextNode_ = nextNode;
    }

    public void logPacketPassage(Writer report) {
        try {
            report.write("\tNode '");
            report.write(name_);
            report.write("' passes packet on.\n");
            report.flush();
        } catch (IOException exc) {
            // just ignore
        }
    }

    public boolean printDocument(Packet document, Writer report) {
        try {
            report.write(">>> Destinition is not a printer, print job cancelled.\n\n");
            report.flush();
        } catch (IOException exc) {
            // just ignore
        }

        return false;
    }

    public boolean atOrigin(Packet packet) {
        return packet.origin_.equals(name_);
    }

    public boolean atDestination(Packet packet) {
        return packet.destination_.equals(name_);
    }

    public boolean send(Packet packet, Writer report) {
        boolean retval = false;
        Node currentNode = nextNode_;
        logPacketPassage(report);

        while ((!currentNode.atDestination(packet))
                & (!currentNode.atOrigin(packet))) {
            currentNode.logPacketPassage(report);

            currentNode = currentNode.nextNode_;
        }

        if (currentNode.atDestination(packet)) {
            retval = currentNode.printDocument(packet, report);
        } else {
            try {
                report.write(">>> Destinition not found, print job cancelled.\n\n");
                report.flush();
            } catch (IOException exc) {
                // just ignore
            }
            retval = false;
        }
        return retval;
    }

    public void printOn(StringBuffer buf) {
        buf.append("Node ");
        buf.append(this.name_);
        buf.append(" [Node]");
    }

    public void printXMLOn(StringBuffer buf) {
        buf.append("<node>");
        buf.append(this.name_);
        buf.append("</node>");
    }
}

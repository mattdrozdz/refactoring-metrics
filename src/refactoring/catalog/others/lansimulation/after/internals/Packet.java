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
 *   Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 *
 *   Copyright original Java version: 2004 Bart Du Bois, Serge Demeyer
 *   Copyright C++ version: 2006 Matthias Rieger, Bart Van Rompaey
 */
package refactoring.catalog.others.lansimulation.after.internals;


/**
 * A <em>Packet</em> represents a unit of information to be sent over the
 * Local Area Network (LAN).
 */
public class Packet {
    /**
     * Holds the actual message to be send over the network.
     */
    public String message_;

    /**
     * Holds the name of the Node which initiated the request.
     */
    public String origin_;

    /**
     * Holds the name of the Node which should receive the information.
     */
    public String destination_;

    /**
     * Construct a <em>Packet</em> with given #message and #destination.
     */
    public Packet(String message, String destination) {
        message_ = message;
        origin_ = "";
        destination_ = destination;
    }

    /**
     * Construct a <em>Packet</em> with given #message, #origin and #receiver.
     */
    public Packet(String message, String origin, String destination) {
        message_ = message;
        origin_ = origin;
        destination_ = destination;
    }

    public boolean isPostScript() {
        return this.message_.startsWith("!PS");
    }

    public String getTitle() {
        String retval = "Untitled";
        int startPos = 0, endPos = 0;
        if (this.isPostScript()) {
            startPos = this.message_.indexOf("title:");
            if (startPos >= 0) {
                endPos = this.message_.indexOf(".", startPos + 6);
                if (endPos < 0) {
                    endPos = this.message_.length();
                }

                retval = this.message_.substring(startPos + 6, endPos);
            }
        } else {
            retval = "ASCII DOCUMENT";
        }
        return retval;
    }

    public String getAuthor() {
        String retval = "Unknown";
        int startPos = 0, endPos = 0;
        if (this.isPostScript()) {
            startPos = this.message_.indexOf("author:");
            if (startPos >= 0) {
                endPos = this.message_.indexOf(".", startPos + 7);
                if (endPos < 0) {
                    endPos = this.message_.length();
                }

                retval = this.message_.substring(startPos + 7, endPos);
            }
        } else {
            if (this.message_.length() >= 16) {
                retval = this.message_.substring(8, 16);
            }
        }
        return retval;
    }
}

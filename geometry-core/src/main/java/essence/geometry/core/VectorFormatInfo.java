/* 
 * Copyright (C) 2018 joseluis.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 */
package essence.geometry.core;

import java.util.logging.Logger;

import static essence.geometry.core.VectorUtils.isNullOrEmpty;

/**
 * Format information of a vector or point.
 */
public class VectorFormatInfo implements Cloneable {

//<editor-fold defaultstate="collapsed" desc="fields">
    /**
     * Gets a read-only VectorFormatInfo object that contains vector formatting information for the current culture.
     */
    public static VectorFormatInfo CURRENT_INFO;

    /**
     * Gets a read-only VectorFormatInfo object that contains culture-independent (invariant) vector formatting
     * information.
     */
    public static VectorFormatInfo INVARIANT_INFO;

    static {
        CURRENT_INFO = new VectorFormatInfo();
        INVARIANT_INFO = new VectorFormatInfo();
    }

    private static final Logger LOG = Logger.getLogger(VectorFormatInfo.class.getName());
    private String Beg;
    private String Sep;
    private String End;
//</editor-fold>

    /**
     * Constructor.
     */
    public VectorFormatInfo() {
        this("(", ";", ")");
    }

    /**
     * Constructor.
     *
     * @param beg Begin string of a tuple.
     * @param sep Component separator string of a tuple.
     * @param end End string of a tuple.
     */
    public VectorFormatInfo(String beg, String sep, String end) {
        this.setBeg(beg);
        this.setSep(sep);
        this.setEnd(end);
    }

    /**
     * Tests if {@code this} info contains begin or end string.
     *
     * @return True if it contains begin o end string. False otherwise.
     */
    public boolean hasBegEnd() {
        return !isNullOrEmpty(this.getBeg()) && !isNullOrEmpty(this.getEnd());
    }

    /**
     * Tests if {@code this} info contains component separator string.
     *
     * @return True if it contains component separator string. False otherwise.
     */
    public boolean hasSep() {
        return !isNullOrEmpty(this.getSep());
    }

    /**
     * Gets the begin string of a vector/point.
     *
     * @return Begin string.
     */
    public String getBeg() {
        return Beg;
    }

    /**
     * Sets the begin string of a vector/point.
     *
     * @param value Begin string.
     */
    public void setBeg(String value) {
        Beg = value;
    }

    /**
     * Gets the component separator string of a vector/point.
     *
     * @return Component separator string.
     */
    public String getSep() {
        return Sep;
    }

    /**
     * Sets the component separator string of a vector/point.
     *
     * @param value Component separator string.
     */
    public void setSep(String value) {
        Sep = value;
    }

    /**
     * Gets the end string of a vector/point.
     *
     * @return End string.
     */
    public String getEnd() {
        return End;
    }

    /**
     * Sets the end string of a vector/point.
     *
     * @param value End string.
     */
    public void setEnd(String value) {
        End = value;
    }

//<editor-fold defaultstate="collapsed" desc="Object">
    @Override
    public Object clone() {
        VectorFormatInfo copia;
        try {
            copia = (VectorFormatInfo) super.clone();
        } catch (CloneNotSupportedException ex) {
            throw new UnsupportedOperationException(ex);
        }
        copia.setBeg(this.getBeg());
        copia.setEnd(this.getEnd());
        copia.setSep(this.getSep());
        return copia;
    }
//</editor-fold>
}

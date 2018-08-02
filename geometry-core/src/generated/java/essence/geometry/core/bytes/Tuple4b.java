/*
 * <auto-generated>
 *     This code was generated by a tool.
 *
 *     Changes to this file may cause incorrect behavior and will be lost if
 *     the code is regenerated.
 * </auto-generated>
 *
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
package essence.geometry.core.bytes;

import java.util.logging.Logger;
import essence.geometry.core.DoubleUtils;
import essence.geometry.core.Tuple;
import essence.geometry.core.TupleUtils;
import essence.geometry.core.VectorFormatInfo;
import essence.geometry.core.Tuple4_Number;
import essence.geometry.core.BuffTuple4_Number;

import static essence.geometry.core.ByteUtils.EPSILON;

/**
 * Basic implementation of a 4 dimension tuple.
 */
public class Tuple4b implements Cloneable, Tuple, Tuple4_Byte, Tuple4_Number  {

//<editor-fold defaultstate="collapsed" desc="fields">
    /** X component. */
    private final byte x;
    /** Y component. */
    private final byte y;
    /** Z component. */
    private final byte z;
    /** W component. */
    private final byte w;
    private static final Logger LOG = Logger.getLogger(Tuple4b.class.getName());
    private static String format;
//</editor-fold>

    /**
     * Empty constructor.
     */
    public Tuple4b() {
        this((byte)0, (byte)0, (byte)0, (byte)0);
    }

    /**
     * This constructor sets the components of this tuple.
     *
     * @param x Value of the component X.
     * @param y Value of the component Y.
     * @param z Value of the component Z.
     * @param w Value of the component W.
     */
    public Tuple4b(byte x, byte y, byte z, byte w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    /**
     * Copy constructor.
     *
     * @param tuple Tuple.
     */
    public Tuple4b(Tuple tuple) {
        Tuple4_Byte _tuple = TupleUtils.toTuple4_Byte(tuple);

        this.x = _tuple.getX();
        this.y = _tuple.getY();
        this.z = _tuple.getZ();
        this.w = _tuple.getW();
    }

    public final boolean isValid() {
        return true;
    }

    /**
     * This method evaluates if {@code this} tuple contains any NaN component.
     *
     * @return {@code True} if {@code this} tuple contains any NaN component. {@code False} otherwise.
     */
    public final boolean isNaN() {
        return false;
    }

    /**
     * This method evaluates if {@code this} tuple contains any infinity component.
     *
     * @return {@code True} if {@code this} tuple contains any infinity component. {@code False} otherwise.
     */
    public final boolean isInfinity() {
        return false;
    }

    /**
     * This method evaluates if {@code this} tuple is zero.
     *
     * @return {@code True} if {@code this} tuple is zero. {@code False} otherwise.
     */
    public final boolean isZero() {
        return isZero(EPSILON);
    }

    /**
     * This method evaluates if {@code this} tuple is zero.
     *
     * @param epsilon Error.
     * @return {@code True} if {@code this} tuple is zero. {@code False} otherwise.
     */
    public final boolean isZero(double epsilon) {
        return epsilonEquals((byte)0, (byte)0, (byte)0, (byte)0, epsilon);
    }

//<editor-fold defaultstate="collapsed" desc="Object">
    @Override
    public String toString() {
        VectorFormatInfo vfi = VectorFormatInfo.CURRENT_INFO;
        return String.format(getFormat(), vfi.getBeg(), vfi.getSep(), vfi.getEnd(),
                             x, y, z, w);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (other instanceof Tuple4b) {
            Tuple4b _other = (Tuple4b)other;
            return equals(_other.x,
                          _other.y,
                          _other.z,
                          _other.w);
        }
        if (other instanceof Tuple) {
            Tuple4_Byte _other = TupleUtils.toTuple4_Byte((Tuple)other);
            return equals(_other.getX(),
                          _other.getY(),
                          _other.getZ(),
                          _other.getW());
        }
        return false;
    }

    @Override
    public int hashCode() {
        // https://stackoverflow.com/questions/113511/best-implementation-for-hashcode-method
        // http://www.jarvana.com/jarvana/view/org/apache/lucene/lucene-spatial/2.9.3/lucene-spatial-2.9.3-sources.jar!/org/apache/lucene/spatial/geometry/shape/Vector2D.java
        final int prime = 31;
        int hash = 1;
        hash = prime * hash + Byte.hashCode(x);
        hash = prime * hash + Byte.hashCode(y);
        hash = prime * hash + Byte.hashCode(z);
        hash = prime * hash + Byte.hashCode(w);
        return hash;
    }

    @Override
    public Tuple4b clone() throws CloneNotSupportedException {
        Tuple4b copy = (Tuple4b)super.clone();
        return copy;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Tuple">
    @Override
    public int size() {
        return 4;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Tuple4_Byte">
    /**
     * This method gets the component {@code index}.
     *
     * @param index Index of the component.
     * @return Value of the component.
     */
    @Override
    public final byte getAt(int index) {
        switch(index) {
        case 0:
            return x;
        case 1:
            return y;
        case 2:
            return z;
        case 3:
            return w;
        }
        throw new IndexOutOfBoundsException();
    }

    /**
     * This method gets the X component.
     *
     * @return Value of the X component.
     */
    @Override
    public final byte getX() {
        return x;
    }

    /**
     * This method gets the Y component.
     *
     * @return Value of the Y component.
     */
    @Override
    public final byte getY() {
        return y;
    }

    /**
     * This method gets the Z component.
     *
     * @return Value of the Z component.
     */
    @Override
    public final byte getZ() {
        return z;
    }

    /**
     * This method gets the W component.
     *
     * @return Value of the W component.
     */
    @Override
    public final byte getW() {
        return w;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Tuple4_Number">
    /**
     * This method sets the values of {@code this} tuple into {@code buff}.
     *
     * @param buff Where to put the values.
     */
    @Override
    public final void getInto(BuffTuple4_Number buff) {
        buff.setByte(x, y, z, w);
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="EpsilonEquatable<Tuple>">
    @Override
    public boolean epsilonEquals(Tuple other) {
        return epsilonEquals(other, EPSILON);
    }

    @Override
    public boolean epsilonEquals(Tuple other, double epsilon) {
        if (other == this) {
            return true;
        }
        if (other instanceof Tuple4b) {
            Tuple4b _other = (Tuple4b)other;
            return epsilonEquals(_other.x,
                                 _other.y,
                                 _other.z,
                                 _other.w, epsilon);
        }
        if (other instanceof Tuple) {
            Tuple4_Byte _other = TupleUtils.toTuple4_Byte((Tuple)other);
            return epsilonEquals(_other.getX(),
                                 _other.getY(),
                                 _other.getZ(),
                                 _other.getW(), epsilon);
        }
        return false;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="private">
    private boolean epsilonEquals(byte x, byte y, byte z, byte w, double epsilon) {
        return DoubleUtils.epsilonEquals(this.x, x, epsilon) && DoubleUtils.epsilonEquals(this.y, y, epsilon) && DoubleUtils.epsilonEquals(this.z, z, epsilon) && DoubleUtils.epsilonEquals(this.w, w, epsilon);
    }

    private boolean equals(byte x, byte y, byte z, byte w) {
        return this.x == x && this.y == y && this.z == z && this.w == w;
    }

    private static String getFormat() {
        if (format == null) {
            String f = "d";    // Integer
            String b = "%1$s"; // Begin      [
            String s = "%2$s"; // Separation ,
            String e = "%3$s"; // End        ]

            StringBuilder buff = new StringBuilder();
            int k = 4;
            buff.append(b);
            buff.append("%").append(k++).append("$").append(f);
            buff.append(s);
            buff.append("%").append(k++).append("$").append(f);
            buff.append(s);
            buff.append("%").append(k++).append("$").append(f);
            buff.append(s);
            buff.append("%").append(k++).append("$").append(f);
            buff.append(e);
            format = buff.toString();
        }
        return format;
    }
//</editor-fold>
}

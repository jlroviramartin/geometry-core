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
import essence.util.math.EpsilonEquatable;
import essence.geometry.core.DoubleUtils;
import essence.geometry.core.Tuple;
import essence.geometry.core.TupleSet;
import essence.geometry.core.VectorFormatInfo;

import static essence.geometry.core.ByteUtils.EPSILON;

/**
 * Basic implementation of a 4 dimension tuple.
 */
public class BuffTuple4b implements Cloneable, EpsilonEquatable<Tuple>, Tuple, TupleSet  {

//<editor-fold defaultstate="collapsed" desc="fields">
    /** X component. */
    private byte x;
    /** Y component. */
    private byte y;
    /** Z component. */
    private byte z;
    /** W component. */
    private byte w;
    private static String format;
//</editor-fold>

    /**
     * Empty constructor.
     */
    public BuffTuple4b() {
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
    public BuffTuple4b(byte x, byte y, byte z, byte w) {
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
    public BuffTuple4b(Tuple tuple) {
        if (tuple instanceof Tuple4b) {
            Tuple4b _tuple = (Tuple4b)tuple;
            this.x = _tuple.getX();
            this.y = _tuple.getY();
            this.z = _tuple.getZ();
            this.w = _tuple.getW();
        } else if (tuple instanceof BuffTuple4b) {
            BuffTuple4b _tuple = (BuffTuple4b)tuple;
            this.x = _tuple.getX();
            this.y = _tuple.getY();
            this.z = _tuple.getZ();
            this.w = _tuple.getW();
        } else {
            Tuple4b _tuple = new Tuple4b(tuple);
            this.x = _tuple.getX();
            this.y = _tuple.getY();
            this.z = _tuple.getZ();
            this.w = _tuple.getW();
        }
    }

    /**
     * Copy constructor.
     *
     * @param tuple Tuple.
     */
    public BuffTuple4b(Tuple4b tuple) {
        this.x = tuple.getX();
        this.y = tuple.getY();
        this.z = tuple.getZ();
        this.w = tuple.getW();
    }

    /**
     * Copy constructor.
     *
     * @param tuple Tuple.
     */
    public BuffTuple4b(BuffTuple4b tuple) {
        this.x = tuple.getX();
        this.y = tuple.getY();
        this.z = tuple.getZ();
        this.w = tuple.getW();
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

//<editor-fold defaultstate="collapsed" desc="accessors">
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

    public final byte getX() {
        return x;
    }

    public final byte getY() {
        return y;
    }

    public final byte getZ() {
        return z;
    }

    public final byte getW() {
        return w;
    }

    /**
     * This method sets the component {@code index}.
     *
     * @param index Index of the component.
     * @param value Value of the component.
     */
    public final void setAt(int index, byte value) {
        switch(index) {
        case 0:
            x = value;
            return;
        case 1:
            y = value;
            return;
        case 2:
            z = value;
            return;
        case 3:
            w = value;
            return;
        }
        throw new IndexOutOfBoundsException();
    }

    /**
     * This method sets the X component.
     *
     * @param value Value of the X component.
     */
    public final void setX(byte value) {
        x = value;
    }

    /**
     * This method sets the Y component.
     *
     * @param value Value of the Y component.
     */
    public final void setY(byte value) {
        y = value;
    }

    /**
     * This method sets the Z component.
     *
     * @param value Value of the Z component.
     */
    public final void setZ(byte value) {
        z = value;
    }

    /**
     * This method sets the W component.
     *
     * @param value Value of the W component.
     */
    public final void setW(byte value) {
        w = value;
    }

    /**
     * This method sets all the components.
     *
     * @param x Value of the X component.
     * @param y Value of the Y component.
     * @param z Value of the Z component.
     * @param w Value of the W component.
     */
    public final void set(byte x, byte y, byte z, byte w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Object">
    @Override
    public String toString() {
        VectorFormatInfo vfi = VectorFormatInfo.CURRENT_INFO;
        return String.format(getFormat(), vfi.getBeg(), vfi.getSep(), vfi.getEnd(),
                             x, y, z, w);
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Tuple4b) {
            return equals((Tuple4b)other);
        } else if (other instanceof BuffTuple4b) {
            return equals((BuffTuple4b)other);
        } else if (other instanceof Tuple) {
            return equals(new Tuple4b((Tuple)other));
        }
        return false;
    }
    public boolean equals(Tuple4b other) {
        return equals(other.getX(),
                      other.getY(),
                      other.getZ(),
                      other.getW());
    }

    public boolean equals(BuffTuple4b other) {
        if (other == this) {
            return true;
        }
        return equals(other.getX(),
                      other.getY(),
                      other.getZ(),
                      other.getW());
    }

    @Override
    public int hashCode() {
        // https://stackoverflow.com/questions/113511/best-implementation-for-hashcode-method
        // http://www.jarvana.com/jarvana/view/org/apache/lucene/lucene-spatial/2.9.3/lucene-spatial-2.9.3-sources.jar!/org/apache/lucene/spatial/geometry/shape/Vector2D.java
        final int prime = 31;
        int hash = 1;
        hash = prime * hash + Byte.hashCode(getX());
        hash = prime * hash + Byte.hashCode(getY());
        hash = prime * hash + Byte.hashCode(getZ());
        hash = prime * hash + Byte.hashCode(getW());
        return hash;
    }

    @Override
    public BuffTuple4b clone() throws CloneNotSupportedException {
        BuffTuple4b copy = (BuffTuple4b)super.clone();
        return copy;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Tuple">
    @Override
    public final int size() {
        return 4;
    }

    @Override
    public final void getInto(TupleSet tupleSet) {
        tupleSet.setByte(0, x);
        tupleSet.setByte(1, y);
        tupleSet.setByte(2, z);
        tupleSet.setByte(3, w);
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="TupleSet">
    @Override
    public final void setByte(int index, byte value) {
        setAt(index, (byte)value);
    }

    @Override
    public final void setShort(int index, short value) {
        setAt(index, (byte)value);
    }

    @Override
    public final void setInteger(int index, int value) {
        setAt(index, (byte)value);
    }

    @Override
    public final void setLong(int index, long value) {
        setAt(index, (byte)value);
    }

    @Override
    public final void setFloat(int index, float value) {
        setAt(index, (byte)value);
    }

    @Override
    public final void setDouble(int index, double value) {
        setAt(index, (byte)value);
    }

    @Override
    public final <T> void set(Class<T> type, int index, T value) {
        if (Number.class.isAssignableFrom(type)) {
            setAt(index, ((Number)value).byteValue());
            return;
        }
        throw new UnsupportedOperationException();
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="EpsilonEquatable<Tuple>">
    @Override
    public boolean epsilonEquals(Tuple other) {
        return epsilonEquals(other, EPSILON);
    }

    @Override
    public boolean epsilonEquals(Tuple other, double epsilon) {
        if (other instanceof Tuple4b) {
            return epsilonEquals((Tuple4b)other, epsilon);
        } else if (other instanceof BuffTuple4b) {
            return epsilonEquals((BuffTuple4b)other, epsilon);
        } else if (other instanceof Tuple) {
            return epsilonEquals(new Tuple4b(other), epsilon);
        }
        return false;
    }

    public boolean epsilonEquals(Tuple4b other, double epsilon) {
        return epsilonEquals(other.getX(),
                             other.getY(),
                             other.getZ(),
                             other.getW(), epsilon);
    }

    public boolean epsilonEquals(BuffTuple4b other, double epsilon) {
        if (other == this) {
            return true;
        }
        return epsilonEquals(other.getX(),
                             other.getY(),
                             other.getZ(),
                             other.getW(), epsilon);
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

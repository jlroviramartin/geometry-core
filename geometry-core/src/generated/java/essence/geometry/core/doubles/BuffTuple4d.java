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
package essence.geometry.core.doubles;

import java.util.logging.Logger;
import essence.geometry.core.DoubleUtils;
import essence.geometry.core.Tuple;
import essence.geometry.core.TupleUtils;
import essence.geometry.core.BuffTuple;
import essence.geometry.core.VectorFormatInfo;
import essence.geometry.core.BuffTuple4_Number;

import static essence.geometry.core.DoubleUtils.EPSILON;

/**
 * Basic implementation of a 4 dimension tuple.
 */
public class BuffTuple4d implements Cloneable, BuffTuple, BuffTuple4_Double, BuffTuple4_Number  {

//<editor-fold defaultstate="collapsed" desc="fields">
    /** X component. */
    private double x;
    /** Y component. */
    private double y;
    /** Z component. */
    private double z;
    /** W component. */
    private double w;
    private static final Logger LOG = Logger.getLogger(BuffTuple4d.class.getName());
    private static String format;
//</editor-fold>

    /**
     * Empty constructor.
     */
    public BuffTuple4d() {
        this((double)0, (double)0, (double)0, (double)0);
    }

    /**
     * This constructor sets the components of this tuple.
     *
     * @param x Value of the component X.
     * @param y Value of the component Y.
     * @param z Value of the component Z.
     * @param w Value of the component W.
     */
    public BuffTuple4d(double x, double y, double z, double w) {
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
    public BuffTuple4d(Tuple tuple) {
        Tuple4_Double _tuple = TupleUtils.toTuple4_Double(tuple);

        this.x = _tuple.getX();
        this.y = _tuple.getY();
        this.z = _tuple.getZ();
        this.w = _tuple.getW();
    }

    public final boolean isValid() {
        return !isNaN() && !isInfinity();
    }

    /**
     * This method evaluates if {@code this} tuple contains any NaN component.
     *
     * @return {@code True} if {@code this} tuple contains any NaN component. {@code False} otherwise.
     */
    public final boolean isNaN() {
        return Double.isNaN(x) || Double.isNaN(y) || Double.isNaN(z) || Double.isNaN(w);
    }

    /**
     * This method evaluates if {@code this} tuple contains any infinity component.
     *
     * @return {@code True} if {@code this} tuple contains any infinity component. {@code False} otherwise.
     */
    public final boolean isInfinity() {
        return Double.isInfinite(x) || Double.isInfinite(y) || Double.isInfinite(z) || Double.isInfinite(w);
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
        return epsilonEquals((double)0, (double)0, (double)0, (double)0, epsilon);
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
        if (other instanceof BuffTuple4d) {
            BuffTuple4d _other = (BuffTuple4d)other;
            return equals(_other.x,
                          _other.y,
                          _other.z,
                          _other.w);
        }
        if (other instanceof Tuple) {
            Tuple4_Double _other = TupleUtils.toTuple4_Double((Tuple)other);
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
        hash = prime * hash + Double.hashCode(x);
        hash = prime * hash + Double.hashCode(y);
        hash = prime * hash + Double.hashCode(z);
        hash = prime * hash + Double.hashCode(w);
        return hash;
    }

    @Override
    public BuffTuple4d clone() throws CloneNotSupportedException {
        BuffTuple4d copy = (BuffTuple4d)super.clone();
        return copy;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="BuffTuple">
    @Override
    public final void set(Tuple other) {
        if (other instanceof BuffTuple4d) {
            BuffTuple4d _other = (BuffTuple4d)other;
            set(_other.x, _other.y, _other.z, _other.w);
            return;
        }
        Tuple4_Double _other = TupleUtils.toTuple4_Double(other);
        set(_other.getX(), _other.getY(), _other.getZ(), _other.getW());
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Tuple">
    @Override
    public int size() {
        return 4;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="BuffTuple4_Double">
    /**
     * This method sets the component {@code index}.
     *
     * @param index Index of the component.
     * @param value Value of the component.
     */
    @Override
    public final void setAt(int index, double value) {
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
    @Override
    public final void setX(double value) {
        x = value;
    }

    /**
     * This method sets the Y component.
     *
     * @param value Value of the Y component.
     */
    @Override
    public final void setY(double value) {
        y = value;
    }

    /**
     * This method sets the Z component.
     *
     * @param value Value of the Z component.
     */
    @Override
    public final void setZ(double value) {
        z = value;
    }

    /**
     * This method sets the W component.
     *
     * @param value Value of the W component.
     */
    @Override
    public final void setW(double value) {
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
    @Override
    public final void set(double x, double y, double z, double w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Tuple4_Double">
    @Override
    public final double getAt(int index) {
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

    @Override
    public final double getX() {
        return x;
    }

    @Override
    public final double getY() {
        return y;
    }

    @Override
    public final double getZ() {
        return z;
    }

    @Override
    public final double getW() {
        return w;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="BuffTuple4_Number">
    /**
    * This method sets the value all components as double values.
    *
    * @param x Value of the X component.
    * @param y Value of the Y component.
    * @param z Value of the Z component.
    * @param w Value of the W component.
    */
    @Override
    public final void setDouble(double x, double y, double z, double w) {
        this.x = (double)x;
        this.y = (double)y;
        this.z = (double)z;
        this.w = (double)w;
    }

    /**
    * This method sets the value all components as float values.
    *
    * @param x Value of the X component.
    * @param y Value of the Y component.
    * @param z Value of the Z component.
    * @param w Value of the W component.
    */
    @Override
    public final void setFloat(float x, float y, float z, float w) {
        this.x = (double)x;
        this.y = (double)y;
        this.z = (double)z;
        this.w = (double)w;
    }

    /**
    * This method sets the value all components as long values.
    *
    * @param x Value of the X component.
    * @param y Value of the Y component.
    * @param z Value of the Z component.
    * @param w Value of the W component.
    */
    @Override
    public final void setLong(long x, long y, long z, long w) {
        this.x = (double)x;
        this.y = (double)y;
        this.z = (double)z;
        this.w = (double)w;
    }

    /**
    * This method sets the value all components as int values.
    *
    * @param x Value of the X component.
    * @param y Value of the Y component.
    * @param z Value of the Z component.
    * @param w Value of the W component.
    */
    @Override
    public final void setInteger(int x, int y, int z, int w) {
        this.x = (double)x;
        this.y = (double)y;
        this.z = (double)z;
        this.w = (double)w;
    }

    /**
    * This method sets the value all components as short values.
    *
    * @param x Value of the X component.
    * @param y Value of the Y component.
    * @param z Value of the Z component.
    * @param w Value of the W component.
    */
    @Override
    public final void setShort(short x, short y, short z, short w) {
        this.x = (double)x;
        this.y = (double)y;
        this.z = (double)z;
        this.w = (double)w;
    }

    /**
    * This method sets the value all components as byte values.
    *
    * @param x Value of the X component.
    * @param y Value of the Y component.
    * @param z Value of the Z component.
    * @param w Value of the W component.
    */
    @Override
    public final void setByte(byte x, byte y, byte z, byte w) {
        this.x = (double)x;
        this.y = (double)y;
        this.z = (double)z;
        this.w = (double)w;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Tuple4_Number">
    @Override
    public final void getInto(BuffTuple4_Number buff) {
        buff.setDouble(x, y, z, w);
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
        if (other instanceof BuffTuple4d) {
            BuffTuple4d _other = (BuffTuple4d)other;
            return epsilonEquals(_other.x,
                                 _other.y,
                                 _other.z,
                                 _other.w, epsilon);
        }
        if (other instanceof Tuple) {
            Tuple4_Double _other = TupleUtils.toTuple4_Double((Tuple)other);
            return epsilonEquals(_other.getX(),
                                 _other.getY(),
                                 _other.getZ(),
                                 _other.getW(), epsilon);
        }
        return false;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="private">
    private boolean epsilonEquals(double x, double y, double z, double w, double epsilon) {
        return DoubleUtils.epsilonEquals(this.x, x, epsilon) && DoubleUtils.epsilonEquals(this.y, y, epsilon) && DoubleUtils.epsilonEquals(this.z, z, epsilon) && DoubleUtils.epsilonEquals(this.w, w, epsilon);
    }

    private boolean equals(double x, double y, double z, double w) {
        return this.x == x && this.y == y && this.z == z && this.w == w;
    }

    private static String getFormat() {
        if (format == null) {
            String f = ".3f";  // Floating point number with 3 decimal places
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

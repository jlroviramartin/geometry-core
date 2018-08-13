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
import essence.geometry.core.BuffTuple2_Number;

import static essence.geometry.core.DoubleUtils.EPSILON;

/**
 * Basic implementation of a 2 dimension tuple.
 */
public class BuffTuple2d implements Cloneable, BuffTuple, BuffTuple2_Double, BuffTuple2_Number  {

//<editor-fold defaultstate="collapsed" desc="fields">
    /** X component. */
    private double x;
    /** Y component. */
    private double y;
    private static final Logger LOG = Logger.getLogger(BuffTuple2d.class.getName());
    private static String format;
//</editor-fold>

    /**
     * Empty constructor.
     */
    public BuffTuple2d() {
        this((double)0, (double)0);
    }

    /**
     * This constructor sets the components of this tuple.
     *
     * @param x Value of the component X.
     * @param y Value of the component Y.
     */
    public BuffTuple2d(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Copy constructor.
     *
     * @param tuple Tuple.
     */
    public BuffTuple2d(Tuple tuple) {
        Tuple2_Double _tuple = TupleUtils.toTuple2_Double(tuple);

        this.x = _tuple.getX();
        this.y = _tuple.getY();
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
        return Double.isNaN(x) || Double.isNaN(y);
    }

    /**
     * This method evaluates if {@code this} tuple contains any infinity component.
     *
     * @return {@code True} if {@code this} tuple contains any infinity component. {@code False} otherwise.
     */
    public final boolean isInfinity() {
        return Double.isInfinite(x) || Double.isInfinite(y);
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
        return epsilonEquals((double)0, (double)0, epsilon);
    }

//<editor-fold defaultstate="collapsed" desc="Object">
    @Override
    public String toString() {
        VectorFormatInfo vfi = VectorFormatInfo.CURRENT_INFO;
        return String.format(getFormat(), vfi.getBeg(), vfi.getSep(), vfi.getEnd(),
                             x, y);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (other instanceof BuffTuple2d) {
            BuffTuple2d _other = (BuffTuple2d)other;
            return equals(_other.x,
                          _other.y);
        }
        if (other instanceof Tuple) {
            Tuple2_Double _other = TupleUtils.toTuple2_Double((Tuple)other);
            return equals(_other.getX(),
                          _other.getY());
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
        return hash;
    }

    @Override
    public BuffTuple2d clone() throws CloneNotSupportedException {
        BuffTuple2d copy = (BuffTuple2d)super.clone();
        return copy;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="BuffTuple">
    @Override
    public final void set(Tuple other) {
        if (other instanceof BuffTuple2d) {
            BuffTuple2d _other = (BuffTuple2d)other;
            set(_other.x, _other.y);
            return;
        }
        Tuple2_Double _other = TupleUtils.toTuple2_Double(other);
        set(_other.getX(), _other.getY());
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Tuple">
    @Override
    public int size() {
        return 2;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="BuffTuple2_Double">
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
     * This method sets all the components.
     *
     * @param x Value of the X component.
     * @param y Value of the Y component.
     */
    @Override
    public final void set(double x, double y) {
        this.x = x;
        this.y = y;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Tuple2_Double">
    @Override
    public final double getAt(int index) {
        switch(index) {
        case 0:
            return x;
        case 1:
            return y;
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
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="BuffTuple2_Number">
    /**
    * This method sets the value all components as double values.
    *
    * @param x Value of the X component.
    * @param y Value of the Y component.
    */
    @Override
    public final void setDouble(double x, double y) {
        this.x = (double)x;
        this.y = (double)y;
    }

    /**
    * This method sets the value all components as float values.
    *
    * @param x Value of the X component.
    * @param y Value of the Y component.
    */
    @Override
    public final void setFloat(float x, float y) {
        this.x = (double)x;
        this.y = (double)y;
    }

    /**
    * This method sets the value all components as long values.
    *
    * @param x Value of the X component.
    * @param y Value of the Y component.
    */
    @Override
    public final void setLong(long x, long y) {
        this.x = (double)x;
        this.y = (double)y;
    }

    /**
    * This method sets the value all components as int values.
    *
    * @param x Value of the X component.
    * @param y Value of the Y component.
    */
    @Override
    public final void setInteger(int x, int y) {
        this.x = (double)x;
        this.y = (double)y;
    }

    /**
    * This method sets the value all components as short values.
    *
    * @param x Value of the X component.
    * @param y Value of the Y component.
    */
    @Override
    public final void setShort(short x, short y) {
        this.x = (double)x;
        this.y = (double)y;
    }

    /**
    * This method sets the value all components as byte values.
    *
    * @param x Value of the X component.
    * @param y Value of the Y component.
    */
    @Override
    public final void setByte(byte x, byte y) {
        this.x = (double)x;
        this.y = (double)y;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Tuple2_Number">
    @Override
    public final void getInto(BuffTuple2_Number buff) {
        buff.setDouble(x, y);
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
        if (other instanceof BuffTuple2d) {
            BuffTuple2d _other = (BuffTuple2d)other;
            return epsilonEquals(_other.x,
                                 _other.y, epsilon);
        }
        if (other instanceof Tuple) {
            Tuple2_Double _other = TupleUtils.toTuple2_Double((Tuple)other);
            return epsilonEquals(_other.getX(),
                                 _other.getY(), epsilon);
        }
        return false;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="private">
    private boolean epsilonEquals(double x, double y, double epsilon) {
        return DoubleUtils.epsilonEquals(this.x, x, epsilon) && DoubleUtils.epsilonEquals(this.y, y, epsilon);
    }

    private boolean equals(double x, double y) {
        return this.x == x && this.y == y;
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
            buff.append(e);
            format = buff.toString();
        }
        return format;
    }
//</editor-fold>
}

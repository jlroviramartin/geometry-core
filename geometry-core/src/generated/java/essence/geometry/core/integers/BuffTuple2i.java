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
package essence.geometry.core.integers;

import java.util.logging.Logger;
import essence.geometry.core.DoubleUtils;
import essence.geometry.core.Tuple;
import essence.geometry.core.TupleUtils;
import essence.geometry.core.BuffTuple;
import essence.geometry.core.VectorFormatInfo;
import essence.geometry.core.BuffTuple2_Number;

import static essence.geometry.core.IntegerUtils.EPSILON;

/**
 * Basic implementation of a 2 dimension tuple.
 */
public class BuffTuple2i implements Cloneable, BuffTuple, BuffTuple2_Integer, BuffTuple2_Number  {

//<editor-fold defaultstate="collapsed" desc="fields">
    /** X component. */
    private int x;
    /** Y component. */
    private int y;
    private static final Logger LOG = Logger.getLogger(BuffTuple2i.class.getName());
    private static String format;
//</editor-fold>

    /**
     * Empty constructor.
     */
    public BuffTuple2i() {
        this((int)0, (int)0);
    }

    /**
     * This constructor sets the components of this tuple.
     *
     * @param x Value of the component X.
     * @param y Value of the component Y.
     */
    public BuffTuple2i(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Copy constructor.
     *
     * @param tuple Tuple.
     */
    public BuffTuple2i(Tuple tuple) {
        Tuple2_Integer _tuple = TupleUtils.toTuple2_Integer(tuple);

        this.x = _tuple.getX();
        this.y = _tuple.getY();
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
        return epsilonEquals((int)0, (int)0, epsilon);
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
        if (other instanceof BuffTuple2i) {
            BuffTuple2i _other = (BuffTuple2i)other;
            return equals(_other.x,
                          _other.y);
        }
        if (other instanceof Tuple) {
            Tuple2_Integer _other = TupleUtils.toTuple2_Integer((Tuple)other);
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
        hash = prime * hash + Integer.hashCode(x);
        hash = prime * hash + Integer.hashCode(y);
        return hash;
    }

    @Override
    public BuffTuple2i clone() throws CloneNotSupportedException {
        BuffTuple2i copy = (BuffTuple2i)super.clone();
        return copy;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="BuffTuple">
    @Override
    public final void set(Tuple other) {
        if (other instanceof BuffTuple2i) {
            BuffTuple2i _other = (BuffTuple2i)other;
            set(_other.x, _other.y);
            return;
        }
        Tuple2_Integer _other = TupleUtils.toTuple2_Integer(other);
        set(_other.getX(), _other.getY());
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Tuple">
    @Override
    public int size() {
        return 2;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="BuffTuple2_Integer">
    /**
     * This method sets the component {@code index}.
     *
     * @param index Index of the component.
     * @param value Value of the component.
     */
    @Override
    public final void setAt(int index, int value) {
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
    public final void setX(int value) {
        x = value;
    }

    /**
     * This method sets the Y component.
     *
     * @param value Value of the Y component.
     */
    @Override
    public final void setY(int value) {
        y = value;
    }

    /**
     * This method sets all the components.
     *
     * @param x Value of the X component.
     * @param y Value of the Y component.
     */
    @Override
    public final void set(int x, int y) {
        this.x = x;
        this.y = y;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Tuple2_Integer">
    /**
     * This method gets the component {@code index}.
     *
     * @param index Index of the component.
     * @return Value of the component.
     */
    @Override
    public final int getAt(int index) {
        switch(index) {
        case 0:
            return x;
        case 1:
            return y;
        }
        throw new IndexOutOfBoundsException();
    }

    /**
     * This method gets the X component.
     *
     * @return Value of the X component.
     */
    @Override
    public final int getX() {
        return x;
    }

    /**
     * This method gets the Y component.
     *
     * @return Value of the Y component.
     */
    @Override
    public final int getY() {
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
        this.x = (int)x;
        this.y = (int)y;
    }

    /**
    * This method sets the value all components as float values.
    *
    * @param x Value of the X component.
    * @param y Value of the Y component.
    */
    @Override
    public final void setFloat(float x, float y) {
        this.x = (int)x;
        this.y = (int)y;
    }

    /**
    * This method sets the value all components as long values.
    *
    * @param x Value of the X component.
    * @param y Value of the Y component.
    */
    @Override
    public final void setLong(long x, long y) {
        this.x = (int)x;
        this.y = (int)y;
    }

    /**
    * This method sets the value all components as int values.
    *
    * @param x Value of the X component.
    * @param y Value of the Y component.
    */
    @Override
    public final void setInteger(int x, int y) {
        this.x = (int)x;
        this.y = (int)y;
    }

    /**
    * This method sets the value all components as short values.
    *
    * @param x Value of the X component.
    * @param y Value of the Y component.
    */
    @Override
    public final void setShort(short x, short y) {
        this.x = (int)x;
        this.y = (int)y;
    }

    /**
    * This method sets the value all components as byte values.
    *
    * @param x Value of the X component.
    * @param y Value of the Y component.
    */
    @Override
    public final void setByte(byte x, byte y) {
        this.x = (int)x;
        this.y = (int)y;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Tuple2_Number">
    /**
     * This method sets the values of {@code this} tuple into {@code buff}.
     *
     * @param buff Where to put the values.
     */
    @Override
    public final void getInto(BuffTuple2_Number buff) {
        buff.setInteger(x, y);
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
        if (other instanceof BuffTuple2i) {
            BuffTuple2i _other = (BuffTuple2i)other;
            return epsilonEquals(_other.x,
                                 _other.y, epsilon);
        }
        if (other instanceof Tuple) {
            Tuple2_Integer _other = TupleUtils.toTuple2_Integer((Tuple)other);
            return epsilonEquals(_other.getX(),
                                 _other.getY(), epsilon);
        }
        return false;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="private">
    private boolean epsilonEquals(int x, int y, double epsilon) {
        return DoubleUtils.epsilonEquals(this.x, x, epsilon) && DoubleUtils.epsilonEquals(this.y, y, epsilon);
    }

    private boolean equals(int x, int y) {
        return this.x == x && this.y == y;
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
            buff.append(e);
            format = buff.toString();
        }
        return format;
    }
//</editor-fold>
}

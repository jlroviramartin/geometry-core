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
import essence.util.math.EpsilonEquatable;
import essence.geometry.core.DoubleUtils;
import essence.geometry.core.Tuple;
import essence.geometry.core.TupleSet;
import essence.geometry.core.VectorFormatInfo;

import static essence.geometry.core.DoubleUtils.EPSILON;

/**
 * Basic implementation of a 2 dimension tuple.
 */
public class BuffTuple2d implements Cloneable, EpsilonEquatable<Tuple>, Tuple, TupleSet  {

//<editor-fold defaultstate="collapsed" desc="fields">
    /** X component. */
    private double x;
    /** Y component. */
    private double y;
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
        if (tuple instanceof Tuple2d) {
            Tuple2d _tuple = (Tuple2d)tuple;
            this.x = _tuple.getX();
            this.y = _tuple.getY();
        } else if (tuple instanceof BuffTuple2d) {
            BuffTuple2d _tuple = (BuffTuple2d)tuple;
            this.x = _tuple.getX();
            this.y = _tuple.getY();
        } else {
            Tuple2d _tuple = new Tuple2d(tuple);
            this.x = _tuple.getX();
            this.y = _tuple.getY();
        }
    }

    /**
     * Copy constructor.
     *
     * @param tuple Tuple.
     */
    public BuffTuple2d(Tuple2d tuple) {
        this.x = tuple.getX();
        this.y = tuple.getY();
    }

    /**
     * Copy constructor.
     *
     * @param tuple Tuple.
     */
    public BuffTuple2d(BuffTuple2d tuple) {
        this.x = tuple.getX();
        this.y = tuple.getY();
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

//<editor-fold defaultstate="collapsed" desc="accessors">
    public final double getAt(int index) {
        switch(index) {
        case 0:
            return x;
        case 1:
            return y;
        }
        throw new IndexOutOfBoundsException();
    }

    public final double getX() {
        return x;
    }

    public final double getY() {
        return y;
    }

    /**
     * This method sets the component {@code index}.
     *
     * @param index Index of the component.
     * @param value Value of the component.
     */
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
    public final void setX(double value) {
        x = value;
    }

    /**
     * This method sets the Y component.
     *
     * @param value Value of the Y component.
     */
    public final void setY(double value) {
        y = value;
    }

    /**
     * This method sets all the components.
     *
     * @param x Value of the X component.
     * @param y Value of the Y component.
     */
    public final void set(double x, double y) {
        this.x = x;
        this.y = y;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Object">
    @Override
    public String toString() {
        VectorFormatInfo vfi = VectorFormatInfo.CURRENT_INFO;
        return String.format(getFormat(), vfi.getBeg(), vfi.getSep(), vfi.getEnd(),
                             x, y);
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Tuple2d) {
            return equals((Tuple2d)other);
        } else if (other instanceof BuffTuple2d) {
            return equals((BuffTuple2d)other);
        } else if (other instanceof Tuple) {
            return equals(new Tuple2d((Tuple)other));
        }
        return false;
    }
    public boolean equals(Tuple2d other) {
        return equals(other.getX(),
                      other.getY());
    }

    public boolean equals(BuffTuple2d other) {
        if (other == this) {
            return true;
        }
        return equals(other.getX(),
                      other.getY());
    }

    @Override
    public int hashCode() {
        // https://stackoverflow.com/questions/113511/best-implementation-for-hashcode-method
        // http://www.jarvana.com/jarvana/view/org/apache/lucene/lucene-spatial/2.9.3/lucene-spatial-2.9.3-sources.jar!/org/apache/lucene/spatial/geometry/shape/Vector2D.java
        final int prime = 31;
        int hash = 1;
        hash = prime * hash + Double.hashCode(getX());
        hash = prime * hash + Double.hashCode(getY());
        return hash;
    }

    @Override
    public BuffTuple2d clone() throws CloneNotSupportedException {
        BuffTuple2d copy = (BuffTuple2d)super.clone();
        return copy;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Tuple">
    @Override
    public final int size() {
        return 2;
    }

    @Override
    public final void getInto(TupleSet tupleSet) {
        tupleSet.setDouble(0, x);
        tupleSet.setDouble(1, y);
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="TupleSet">
    @Override
    public final void setByte(int index, byte value) {
        setAt(index, (double)value);
    }

    @Override
    public final void setShort(int index, short value) {
        setAt(index, (double)value);
    }

    @Override
    public final void setInteger(int index, int value) {
        setAt(index, (double)value);
    }

    @Override
    public final void setLong(int index, long value) {
        setAt(index, (double)value);
    }

    @Override
    public final void setFloat(int index, float value) {
        setAt(index, (double)value);
    }

    @Override
    public final void setDouble(int index, double value) {
        setAt(index, (double)value);
    }

    @Override
    public final <T> void set(Class<T> type, int index, T value) {
        if (Number.class.isAssignableFrom(type)) {
            setAt(index, ((Number)value).doubleValue());
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
        if (other instanceof Tuple2d) {
            return epsilonEquals((Tuple2d)other, epsilon);
        } else if (other instanceof BuffTuple2d) {
            return epsilonEquals((BuffTuple2d)other, epsilon);
        } else if (other instanceof Tuple) {
            return epsilonEquals(new Tuple2d(other), epsilon);
        }
        return false;
    }

    public boolean epsilonEquals(Tuple2d other, double epsilon) {
        return epsilonEquals(other.getX(),
                             other.getY(), epsilon);
    }

    public boolean epsilonEquals(BuffTuple2d other, double epsilon) {
        if (other == this) {
            return true;
        }
        return epsilonEquals(other.getX(),
                             other.getY(), epsilon);
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

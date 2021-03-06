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
package essence.geometry.core.floats;

import java.util.logging.Logger;
import essence.util.math.EpsilonEquatable;
import essence.geometry.core.DoubleUtils;
import essence.geometry.core.Tuple;
import essence.geometry.core.TupleSet;
import essence.geometry.core.VectorFormatInfo;

import static essence.geometry.core.FloatUtils.EPSILON;

/**
 * Basic implementation of a 2 dimension tuple.
 */
public class BuffTuple2f implements Cloneable, EpsilonEquatable<Tuple>, Tuple, TupleSet  {

//<editor-fold defaultstate="collapsed" desc="fields">
    /** X component. */
    private float x;
    /** Y component. */
    private float y;
    private static String format;
//</editor-fold>

    /**
     * Empty constructor.
     */
    public BuffTuple2f() {
        this((float)0, (float)0);
    }

    /**
     * This constructor sets the components of this tuple.
     *
     * @param x Value of the component X.
     * @param y Value of the component Y.
     */
    public BuffTuple2f(float x, float y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Copy constructor.
     *
     * @param tuple Tuple.
     */
    public BuffTuple2f(Tuple tuple) {
        if (tuple instanceof Tuple2f) {
            Tuple2f _tuple = (Tuple2f)tuple;
            this.x = _tuple.getX();
            this.y = _tuple.getY();
        } else if (tuple instanceof BuffTuple2f) {
            BuffTuple2f _tuple = (BuffTuple2f)tuple;
            this.x = _tuple.getX();
            this.y = _tuple.getY();
        } else {
            Tuple2f _tuple = new Tuple2f(tuple);
            this.x = _tuple.getX();
            this.y = _tuple.getY();
        }
    }

    /**
     * Copy constructor.
     *
     * @param tuple Tuple.
     */
    public BuffTuple2f(Tuple2f tuple) {
        this.x = tuple.getX();
        this.y = tuple.getY();
    }

    /**
     * Copy constructor.
     *
     * @param tuple Tuple.
     */
    public BuffTuple2f(BuffTuple2f tuple) {
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
        return Float.isNaN(x) || Float.isNaN(y);
    }

    /**
     * This method evaluates if {@code this} tuple contains any infinity component.
     *
     * @return {@code True} if {@code this} tuple contains any infinity component. {@code False} otherwise.
     */
    public final boolean isInfinity() {
        return Float.isInfinite(x) || Float.isInfinite(y);
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
        return epsilonEquals((float)0, (float)0, epsilon);
    }

//<editor-fold defaultstate="collapsed" desc="accessors">
    public final float getAt(int index) {
        switch(index) {
        case 0:
            return x;
        case 1:
            return y;
        }
        throw new IndexOutOfBoundsException();
    }

    public final float getX() {
        return x;
    }

    public final float getY() {
        return y;
    }

    /**
     * This method sets the component {@code index}.
     *
     * @param index Index of the component.
     * @param value Value of the component.
     */
    public final void setAt(int index, float value) {
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
    public final void setX(float value) {
        x = value;
    }

    /**
     * This method sets the Y component.
     *
     * @param value Value of the Y component.
     */
    public final void setY(float value) {
        y = value;
    }

    /**
     * This method sets all the components.
     *
     * @param x Value of the X component.
     * @param y Value of the Y component.
     */
    public final void set(float x, float y) {
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
        if (other instanceof Tuple2f) {
            return equals((Tuple2f)other);
        } else if (other instanceof BuffTuple2f) {
            return equals((BuffTuple2f)other);
        } else if (other instanceof Tuple) {
            return equals(new Tuple2f((Tuple)other));
        }
        return false;
    }
    public boolean equals(Tuple2f other) {
        return equals(other.getX(),
                      other.getY());
    }

    public boolean equals(BuffTuple2f other) {
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
        hash = prime * hash + Float.hashCode(getX());
        hash = prime * hash + Float.hashCode(getY());
        return hash;
    }

    @Override
    public BuffTuple2f clone() throws CloneNotSupportedException {
        BuffTuple2f copy = (BuffTuple2f)super.clone();
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
        tupleSet.setFloat(0, x);
        tupleSet.setFloat(1, y);
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="TupleSet">
    @Override
    public final void setByte(int index, byte value) {
        setAt(index, (float)value);
    }

    @Override
    public final void setShort(int index, short value) {
        setAt(index, (float)value);
    }

    @Override
    public final void setInteger(int index, int value) {
        setAt(index, (float)value);
    }

    @Override
    public final void setLong(int index, long value) {
        setAt(index, (float)value);
    }

    @Override
    public final void setFloat(int index, float value) {
        setAt(index, (float)value);
    }

    @Override
    public final void setDouble(int index, double value) {
        setAt(index, (float)value);
    }

    @Override
    public final <T> void set(Class<T> type, int index, T value) {
        if (Number.class.isAssignableFrom(type)) {
            setAt(index, ((Number)value).floatValue());
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
        if (other instanceof Tuple2f) {
            return epsilonEquals((Tuple2f)other, epsilon);
        } else if (other instanceof BuffTuple2f) {
            return epsilonEquals((BuffTuple2f)other, epsilon);
        } else if (other instanceof Tuple) {
            return epsilonEquals(new Tuple2f(other), epsilon);
        }
        return false;
    }

    public boolean epsilonEquals(Tuple2f other, double epsilon) {
        return epsilonEquals(other.getX(),
                             other.getY(), epsilon);
    }

    public boolean epsilonEquals(BuffTuple2f other, double epsilon) {
        if (other == this) {
            return true;
        }
        return epsilonEquals(other.getX(),
                             other.getY(), epsilon);
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="private">
    private boolean epsilonEquals(float x, float y, double epsilon) {
        return DoubleUtils.epsilonEquals(this.x, x, epsilon) && DoubleUtils.epsilonEquals(this.y, y, epsilon);
    }

    private boolean equals(float x, float y) {
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

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
import essence.geometry.core.DoubleUtils;
import essence.geometry.core.Tuple;
import essence.geometry.core.VectorFormatInfo;
import essence.geometry.core.Tuple2_Number;
import essence.geometry.core.BuffTuple2_Number;

import static essence.geometry.core.FloatUtils.EPSILON;

/**
 * Basic implementation of a 2 dimension tuple.
 */
public class Tuple2f implements Cloneable, Tuple, Tuple2_Float, Tuple2_Number  {

//<editor-fold defaultstate="collapsed" desc="fields">
    /** X component. */
    private final float x;
    /** Y component. */
    private final float y;
    private static final Logger LOG = Logger.getLogger(Tuple2f.class.getName());
    private static String format;
//</editor-fold>

    /**
     * Empty constructor.
     */
    public Tuple2f() {
        this((float)0, (float)0);
    }

    /**
     * This constructor sets the components of this tuple.
     *
     * @param x Value of the component X.
     * @param y Value of the component Y.
     */
    public Tuple2f(float x, float y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Copy constructor.
     *
     * @param tuple Tuple.
     */
    public Tuple2f(Tuple tuple) {
        Tuple2_Float _tuple = toTuple(tuple);

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

    /**
     * This method converts a Tuple into a Tuple2_Float. It is a helper method to ease the operations.
     *
     * @param other Tuple.
     * @return Tuple2_Float.
     */
    protected static Tuple2_Float toTuple(Tuple other) {
        if (other instanceof Tuple2_Float) {
            return (Tuple2_Float)other;
        }
        BuffTuple2f aux = new BuffTuple2f();
        aux.set(other);
        return aux;
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
        if (other instanceof Tuple2f) {
            Tuple2f _other = (Tuple2f)other;
            return equals(_other.x,
                          _other.y);
        }
        if (other instanceof Tuple) {
            Tuple2_Float _other = toTuple((Tuple)other);
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
        hash = prime * hash + Float.hashCode(x);
        hash = prime * hash + Float.hashCode(y);
        return hash;
    }

    @Override
    public Tuple2f clone() throws CloneNotSupportedException {
        Tuple2f copy = (Tuple2f)super.clone();
        return copy;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Tuple">
    @Override
    public int size() {
        return 2;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Tuple2_Float">
    /**
     * This method gets the component {@code index}.
     *
     * @param index Index of the component.
     * @return Value of the component.
     */
    @Override
    public final float getAt(int index) {
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
    public final float getX() {
        return x;
    }

    /**
     * This method gets the Y component.
     *
     * @return Value of the Y component.
     */
    @Override
    public final float getY() {
        return y;
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
        buff.setFloat(x, y);
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
        if (other instanceof Tuple2f) {
            Tuple2f _other = (Tuple2f)other;
            return epsilonEquals(_other.x,
                                 _other.y, epsilon);
        }
        if (other instanceof Tuple) {
            Tuple2_Float _other = toTuple((Tuple)other);
            return epsilonEquals(_other.getX(),
                                 _other.getY(), epsilon);
        }
        return false;
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

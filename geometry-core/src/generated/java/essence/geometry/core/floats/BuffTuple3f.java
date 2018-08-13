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
import essence.geometry.core.TupleUtils;
import essence.geometry.core.BuffTuple;
import essence.geometry.core.VectorFormatInfo;
import essence.geometry.core.BuffTuple3_Number;

import static essence.geometry.core.FloatUtils.EPSILON;

/**
 * Basic implementation of a 3 dimension tuple.
 */
public class BuffTuple3f implements Cloneable, BuffTuple, BuffTuple3_Float, BuffTuple3_Number  {

//<editor-fold defaultstate="collapsed" desc="fields">
    /** X component. */
    private float x;
    /** Y component. */
    private float y;
    /** Z component. */
    private float z;
    private static final Logger LOG = Logger.getLogger(BuffTuple3f.class.getName());
    private static String format;
//</editor-fold>

    /**
     * Empty constructor.
     */
    public BuffTuple3f() {
        this((float)0, (float)0, (float)0);
    }

    /**
     * This constructor sets the components of this tuple.
     *
     * @param x Value of the component X.
     * @param y Value of the component Y.
     * @param z Value of the component Z.
     */
    public BuffTuple3f(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Copy constructor.
     *
     * @param tuple Tuple.
     */
    public BuffTuple3f(Tuple tuple) {
        Tuple3_Float _tuple = TupleUtils.toTuple3_Float(tuple);

        this.x = _tuple.getX();
        this.y = _tuple.getY();
        this.z = _tuple.getZ();
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
        return Float.isNaN(x) || Float.isNaN(y) || Float.isNaN(z);
    }

    /**
     * This method evaluates if {@code this} tuple contains any infinity component.
     *
     * @return {@code True} if {@code this} tuple contains any infinity component. {@code False} otherwise.
     */
    public final boolean isInfinity() {
        return Float.isInfinite(x) || Float.isInfinite(y) || Float.isInfinite(z);
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
        return epsilonEquals((float)0, (float)0, (float)0, epsilon);
    }

//<editor-fold defaultstate="collapsed" desc="Object">
    @Override
    public String toString() {
        VectorFormatInfo vfi = VectorFormatInfo.CURRENT_INFO;
        return String.format(getFormat(), vfi.getBeg(), vfi.getSep(), vfi.getEnd(),
                             x, y, z);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (other instanceof BuffTuple3f) {
            BuffTuple3f _other = (BuffTuple3f)other;
            return equals(_other.x,
                          _other.y,
                          _other.z);
        }
        if (other instanceof Tuple) {
            Tuple3_Float _other = TupleUtils.toTuple3_Float((Tuple)other);
            return equals(_other.getX(),
                          _other.getY(),
                          _other.getZ());
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
        hash = prime * hash + Float.hashCode(z);
        return hash;
    }

    @Override
    public BuffTuple3f clone() throws CloneNotSupportedException {
        BuffTuple3f copy = (BuffTuple3f)super.clone();
        return copy;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="BuffTuple">
    @Override
    public final void set(Tuple other) {
        if (other instanceof BuffTuple3f) {
            BuffTuple3f _other = (BuffTuple3f)other;
            set(_other.x, _other.y, _other.z);
            return;
        }
        Tuple3_Float _other = TupleUtils.toTuple3_Float(other);
        set(_other.getX(), _other.getY(), _other.getZ());
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Tuple">
    @Override
    public int size() {
        return 3;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="BuffTuple3_Float">
    /**
     * This method sets the component {@code index}.
     *
     * @param index Index of the component.
     * @param value Value of the component.
     */
    @Override
    public final void setAt(int index, float value) {
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
        }
        throw new IndexOutOfBoundsException();
    }

    /**
     * This method sets the X component.
     *
     * @param value Value of the X component.
     */
    @Override
    public final void setX(float value) {
        x = value;
    }

    /**
     * This method sets the Y component.
     *
     * @param value Value of the Y component.
     */
    @Override
    public final void setY(float value) {
        y = value;
    }

    /**
     * This method sets the Z component.
     *
     * @param value Value of the Z component.
     */
    @Override
    public final void setZ(float value) {
        z = value;
    }

    /**
     * This method sets all the components.
     *
     * @param x Value of the X component.
     * @param y Value of the Y component.
     * @param z Value of the Z component.
     */
    @Override
    public final void set(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Tuple3_Float">
    @Override
    public final float getAt(int index) {
        switch(index) {
        case 0:
            return x;
        case 1:
            return y;
        case 2:
            return z;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public final float getX() {
        return x;
    }

    @Override
    public final float getY() {
        return y;
    }

    @Override
    public final float getZ() {
        return z;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="BuffTuple3_Number">
    /**
    * This method sets the value all components as double values.
    *
    * @param x Value of the X component.
    * @param y Value of the Y component.
    * @param z Value of the Z component.
    */
    @Override
    public final void setDouble(double x, double y, double z) {
        this.x = (float)x;
        this.y = (float)y;
        this.z = (float)z;
    }

    /**
    * This method sets the value all components as float values.
    *
    * @param x Value of the X component.
    * @param y Value of the Y component.
    * @param z Value of the Z component.
    */
    @Override
    public final void setFloat(float x, float y, float z) {
        this.x = (float)x;
        this.y = (float)y;
        this.z = (float)z;
    }

    /**
    * This method sets the value all components as long values.
    *
    * @param x Value of the X component.
    * @param y Value of the Y component.
    * @param z Value of the Z component.
    */
    @Override
    public final void setLong(long x, long y, long z) {
        this.x = (float)x;
        this.y = (float)y;
        this.z = (float)z;
    }

    /**
    * This method sets the value all components as int values.
    *
    * @param x Value of the X component.
    * @param y Value of the Y component.
    * @param z Value of the Z component.
    */
    @Override
    public final void setInteger(int x, int y, int z) {
        this.x = (float)x;
        this.y = (float)y;
        this.z = (float)z;
    }

    /**
    * This method sets the value all components as short values.
    *
    * @param x Value of the X component.
    * @param y Value of the Y component.
    * @param z Value of the Z component.
    */
    @Override
    public final void setShort(short x, short y, short z) {
        this.x = (float)x;
        this.y = (float)y;
        this.z = (float)z;
    }

    /**
    * This method sets the value all components as byte values.
    *
    * @param x Value of the X component.
    * @param y Value of the Y component.
    * @param z Value of the Z component.
    */
    @Override
    public final void setByte(byte x, byte y, byte z) {
        this.x = (float)x;
        this.y = (float)y;
        this.z = (float)z;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Tuple3_Number">
    @Override
    public final void getInto(BuffTuple3_Number buff) {
        buff.setFloat(x, y, z);
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
        if (other instanceof BuffTuple3f) {
            BuffTuple3f _other = (BuffTuple3f)other;
            return epsilonEquals(_other.x,
                                 _other.y,
                                 _other.z, epsilon);
        }
        if (other instanceof Tuple) {
            Tuple3_Float _other = TupleUtils.toTuple3_Float((Tuple)other);
            return epsilonEquals(_other.getX(),
                                 _other.getY(),
                                 _other.getZ(), epsilon);
        }
        return false;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="private">
    private boolean epsilonEquals(float x, float y, float z, double epsilon) {
        return DoubleUtils.epsilonEquals(this.x, x, epsilon) && DoubleUtils.epsilonEquals(this.y, y, epsilon) && DoubleUtils.epsilonEquals(this.z, z, epsilon);
    }

    private boolean equals(float x, float y, float z) {
        return this.x == x && this.y == y && this.z == z;
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
            buff.append(e);
            format = buff.toString();
        }
        return format;
    }
//</editor-fold>
}

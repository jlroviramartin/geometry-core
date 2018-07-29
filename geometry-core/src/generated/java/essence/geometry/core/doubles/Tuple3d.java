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
import essence.geometry.core.VectorFormatInfo;
import essence.geometry.core.Tuple3_Number;

import static essence.geometry.core.DoubleUtils.EPSILON;

/**
 * Basic implementation of a 3 dimension tuple.
 */
public class Tuple3d implements Cloneable, Tuple, Tuple3_Double, Tuple3_Number  {

    //<editor-fold defaultstate="collapsed" desc="fields">
    /** X component. */
    private double x;
    /** Y component. */
    private double y;
    /** Z component. */
    private double z;
    private static final Logger LOG = Logger.getLogger(Tuple3d.class.getName());
    private static String format;
//</editor-fold>

    /**
    * Empty constructor.
    */
    public Tuple3d() {
        this((double)0, (double)0, (double)0);
    }

    /**
     * This constructor sets the components of this tuple.
     *
     * @param x Value of the component X.
     * @param y Value of the component Y.
     * @param z Value of the component Z.
     */
    public Tuple3d(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public final boolean isValid() {
        return !isNaN() && !isInfinity();
    }

    /**
     * This method evaluates is {@code this} tuple contains any NaN component.
     *
     * @return {@code True} if {@code this} tuple contains any NaN component. {@code False} otherwise.
     */
    public final boolean isNaN() {
        return Double.isNaN(x) || Double.isNaN(y) || Double.isNaN(z);
    }

    /**
     * This method evaluates is {@code this} tuple contains any infinity component.
     *
     * @return {@code True} if {@code this} tuple contains any infinity component. {@code False} otherwise.
     */
    public final boolean isInfinity() {
        return Double.isInfinite(x) || Double.isInfinite(y) || Double.isInfinite(z);
    }

    /**
     * This method evaluates is {@code this} tuple is zero.
     *
     * @return {@code True} if {@code this} tuple is zero. {@code False} otherwise.
     */
    public final boolean isZero() {
        return isZero(EPSILON);
    }

    /**
     * This method evaluates is {@code this} tuple is zero.
     *
     * @param epsilon Error.
     * @return {@code True} if {@code this} tuple is zero. {@code False} otherwise.
     */
    public final boolean isZero(double epsilon) {
        return epsilonEquals((double)0, (double)0, (double)0, epsilon);
    }

    protected static Tuple3_Double toTuple(Tuple other) {
        if (other instanceof Tuple3_Double) {
            return (Tuple3_Double)other;
        }
        Tuple3d aux = new Tuple3d();
        other.getInto(aux);
        return aux;
    }

    //<editor-fold defaultstate="collapsed" desc="Object">
    @Override
    public String toString() {
        VectorFormatInfo vfi = VectorFormatInfo.CURRENT_INFO;
        return String.format(getFormat(), vfi.getBeg(), vfi.getSep(), vfi.getEnd(),
                             getX(),getY(),getZ());
    }

    public boolean equals(Tuple3d other) {
        if (other == this) {
            return true;
        }
        if (other == null) {
            return false;
        }

        return this.equals(other.getX(), other.getY(), other.getZ());
    }

    @Override
    public boolean equals(Object other) {
        return ((other instanceof Tuple3d) && this.equals((Tuple3d) other));
    }

    @Override
    public int hashCode() {
        // https://stackoverflow.com/questions/113511/best-implementation-for-hashcode-method
        // http://www.jarvana.com/jarvana/view/org/apache/lucene/lucene-spatial/2.9.3/lucene-spatial-2.9.3-sources.jar!/org/apache/lucene/spatial/geometry/shape/Vector2D.java
        final int prime = 31;
        int hash = 1;
        hash = prime * hash + Double.hashCode(getX());
        hash = prime * hash + Double.hashCode(getY());
        hash = prime * hash + Double.hashCode(getZ());
        return hash;
    }

    @Override
    public Tuple3d clone() {
        try {
            Tuple3d copy = (Tuple3d)super.clone();
            return copy;
        } catch (CloneNotSupportedException ex) {
            throw new Error(ex);
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Tuple">
    @Override
    public int size() {
        return 3;
    }

    @Override
    public void getInto(Tuple other) {
        if (other instanceof Tuple3d) {
            Tuple3d _other = (Tuple3d)other;
            _other.set(getX(), getY(), getZ());
            return;
        }
        if (other instanceof Tuple3_Double) {
            Tuple3_Double _other = (Tuple3_Double)other;
            _other.set(getX(), getY(), getZ());
            return;
        }
        if (other instanceof Tuple3_Number) {
            Tuple3_Number _other = (Tuple3_Number)other;
            _other.setDouble(getX(), getY(), getZ());
            return;
        }
        throw new UnsupportedOperationException();
    }

    @Override
    public void set(Tuple other) {
        if (other instanceof Tuple3_Double) {
            Tuple3_Double _other = (Tuple3_Double)other;
            set(_other.getX(), _other.getY(), _other.getZ());
            return;
        }
        if (other instanceof Tuple3_Number) {
            Tuple3_Number _other = (Tuple3_Number)other;
            _other.getInto(this);
            return;
        }
        throw new UnsupportedOperationException();
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Tuple3_Double">
    /**
     * This method gets the component {@code index}.
     *
     * @param index Index of the component.
     * @return Value of the component.
     */
    @Override
    public double getAt(int index) {
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

    /**
     * This method sets the component {@code index}.
     *
     * @param index Index of the component.
     * @param value Value of the component.
     */
    @Override
    public void setAt(int index, double value) {
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
     * This method gets the X component.
     *
     * @return Value of the X component.
     */
    @Override
    public double getX() {
        return x;
    }

    /**
     * This method sets the X component.
     *
     * @param value Value of the X component.
     */
    @Override
    public void setX(double value) {
        x = value;
    }

    /**
     * This method gets the Y component.
     *
     * @return Value of the Y component.
     */
    @Override
    public double getY() {
        return y;
    }

    /**
     * This method sets the Y component.
     *
     * @param value Value of the Y component.
     */
    @Override
    public void setY(double value) {
        y = value;
    }

    /**
     * This method gets the Z component.
     *
     * @return Value of the Z component.
     */
    @Override
    public double getZ() {
        return z;
    }

    /**
     * This method sets the Z component.
     *
     * @param value Value of the Z component.
     */
    @Override
    public void setZ(double value) {
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
    public void set(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Tuple3_Number">
    /**
     * This method sets the values of {@code this} tuple into {@code buff}.
     *
     * @param buff Where to put the values.
     */
    @Override
    public void getInto(Tuple3_Number buff) {
        buff.setDouble(x, y, z);
    }

    /**
    * This method sets the value all components as double values.
    *
    * @param x Value of the X component.
    * @param y Value of the Y component.
    * @param z Value of the Z component.
    */
    @Override
    public void setDouble(double x, double y, double z) {
        this.x = (double)x;
        this.y = (double)y;
        this.z = (double)z;
    }

    /**
    * This method sets the value all components as float values.
    *
    * @param x Value of the X component.
    * @param y Value of the Y component.
    * @param z Value of the Z component.
    */
    @Override
    public void setFloat(float x, float y, float z) {
        this.x = (double)x;
        this.y = (double)y;
        this.z = (double)z;
    }

    /**
    * This method sets the value all components as long values.
    *
    * @param x Value of the X component.
    * @param y Value of the Y component.
    * @param z Value of the Z component.
    */
    @Override
    public void setLong(long x, long y, long z) {
        this.x = (double)x;
        this.y = (double)y;
        this.z = (double)z;
    }

    /**
    * This method sets the value all components as int values.
    *
    * @param x Value of the X component.
    * @param y Value of the Y component.
    * @param z Value of the Z component.
    */
    @Override
    public void setInteger(int x, int y, int z) {
        this.x = (double)x;
        this.y = (double)y;
        this.z = (double)z;
    }

    /**
    * This method sets the value all components as short values.
    *
    * @param x Value of the X component.
    * @param y Value of the Y component.
    * @param z Value of the Z component.
    */
    @Override
    public void setShort(short x, short y, short z) {
        this.x = (double)x;
        this.y = (double)y;
        this.z = (double)z;
    }

    /**
    * This method sets the value all components as byte values.
    *
    * @param x Value of the X component.
    * @param y Value of the Y component.
    * @param z Value of the Z component.
    */
    @Override
    public void setByte(byte x, byte y, byte z) {
        this.x = (double)x;
        this.y = (double)y;
        this.z = (double)z;
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
        if (!(other instanceof Tuple3d)) {
            return false;
        }
        Tuple3d _other = (Tuple3d)other;
        return epsilonEquals(_other.getX(),
                             _other.getY(),
                             _other.getZ(), epsilon);
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="private">
    private boolean epsilonEquals(double x, double y, double z, double epsilon) {
        return DoubleUtils.epsilonEquals(getX(), x, epsilon) && DoubleUtils.epsilonEquals(getY(), y, epsilon) && DoubleUtils.epsilonEquals(getZ(), z, epsilon);
    }

    private boolean equals(double x, double y, double z) {
        return getX() == x && getY() == y && getZ() == z;
    }

    private static String getFormat() {
        if (format == null) {
            String f = ".3f";  // Floating point number with 2 decimal places
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

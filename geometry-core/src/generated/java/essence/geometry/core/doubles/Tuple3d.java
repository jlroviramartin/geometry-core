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
 * Basic implementation of a 3 dimension tuple.
 */
public class Tuple3d implements Cloneable, EpsilonEquatable<Tuple>, Tuple  {

//<editor-fold defaultstate="collapsed" desc="fields">
    /** X component. */
    private final double x;
    /** Y component. */
    private final double y;
    /** Z component. */
    private final double z;
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

    /**
     * Copy constructor.
     *
     * @param tuple Tuple.
     */
    public Tuple3d(Tuple tuple) {
        if (tuple instanceof Tuple3d) {
            Tuple3d _tuple = (Tuple3d)tuple;
            this.x = _tuple.getX();
            this.y = _tuple.getY();
            this.z = _tuple.getZ();
        } else if (tuple instanceof BuffTuple3d) {
            BuffTuple3d _tuple = (BuffTuple3d)tuple;
            this.x = _tuple.getX();
            this.y = _tuple.getY();
            this.z = _tuple.getZ();
        } else {
            Tuple3d _tuple = new Tuple3d(tuple);
            this.x = _tuple.getX();
            this.y = _tuple.getY();
            this.z = _tuple.getZ();
        }
    }

    /**
     * Copy constructor.
     *
     * @param tuple Tuple.
     */
    public Tuple3d(Tuple3d tuple) {
        this.x = tuple.getX();
        this.y = tuple.getY();
        this.z = tuple.getZ();
    }

    /**
     * Copy constructor.
     *
     * @param tuple Tuple.
     */
    public Tuple3d(BuffTuple3d tuple) {
        this.x = tuple.getX();
        this.y = tuple.getY();
        this.z = tuple.getZ();
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
        return Double.isNaN(x) || Double.isNaN(y) || Double.isNaN(z);
    }

    /**
     * This method evaluates if {@code this} tuple contains any infinity component.
     *
     * @return {@code True} if {@code this} tuple contains any infinity component. {@code False} otherwise.
     */
    public final boolean isInfinity() {
        return Double.isInfinite(x) || Double.isInfinite(y) || Double.isInfinite(z);
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
        return epsilonEquals((double)0, (double)0, (double)0, epsilon);
    }

//<editor-fold defaultstate="collapsed" desc="accessors">
    public final double getAt(int index) {
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

    public final double getX() {
        return x;
    }

    public final double getY() {
        return y;
    }

    public final double getZ() {
        return z;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Object">
    @Override
    public String toString() {
        VectorFormatInfo vfi = VectorFormatInfo.CURRENT_INFO;
        return String.format(getFormat(), vfi.getBeg(), vfi.getSep(), vfi.getEnd(),
                             x, y, z);
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Tuple3d) {
            return equals((Tuple3d)other);
        } else if (other instanceof BuffTuple3d) {
            return equals((BuffTuple3d)other);
        } else if (other instanceof Tuple) {
            return equals(new Tuple3d((Tuple)other));
        }
        return false;
    }
    public boolean equals(Tuple3d other) {
        if (other == this) {
            return true;
        }
        return equals(other.getX(),
                      other.getY(),
                      other.getZ());
    }

    public boolean equals(BuffTuple3d other) {
        return equals(other.getX(),
                      other.getY(),
                      other.getZ());
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
    public Tuple3d clone() throws CloneNotSupportedException {
        Tuple3d copy = (Tuple3d)super.clone();
        return copy;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Tuple">
    @Override
    public final int size() {
        return 3;
    }

    @Override
    public final void getInto(TupleSet tupleSet) {
        tupleSet.setDouble(0, x);
        tupleSet.setDouble(1, y);
        tupleSet.setDouble(2, z);
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="EpsilonEquatable<Tuple>">
    @Override
    public boolean epsilonEquals(Tuple other) {
        return epsilonEquals(other, EPSILON);
    }

    @Override
    public boolean epsilonEquals(Tuple other, double epsilon) {
        if (other instanceof Tuple3d) {
            return epsilonEquals((Tuple3d)other, epsilon);
        } else if (other instanceof BuffTuple3d) {
            return epsilonEquals((BuffTuple3d)other, epsilon);
        } else if (other instanceof Tuple) {
            return epsilonEquals(new Tuple3d(other), epsilon);
        }
        return false;
    }

    public boolean epsilonEquals(Tuple3d other, double epsilon) {
        if (other == this) {
            return true;
        }
        return epsilonEquals(other.getX(),
                             other.getY(),
                             other.getZ(), epsilon);
    }

    public boolean epsilonEquals(BuffTuple3d other, double epsilon) {
        return epsilonEquals(other.getX(),
                             other.getY(),
                             other.getZ(), epsilon);
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="private">
    private boolean epsilonEquals(double x, double y, double z, double epsilon) {
        return DoubleUtils.epsilonEquals(this.x, x, epsilon) && DoubleUtils.epsilonEquals(this.y, y, epsilon) && DoubleUtils.epsilonEquals(this.z, z, epsilon);
    }

    private boolean equals(double x, double y, double z) {
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

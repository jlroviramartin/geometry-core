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
import essence.geometry.core.SingularMatrixException;
import essence.geometry.core.Tuple;
import essence.geometry.core.TupleUtils;
import essence.geometry.core.Vector2;
import essence.geometry.core.BuffVector2;
import essence.geometry.core.VectorFormatInfo;

import static essence.geometry.core.DoubleUtils.EPSILON;

/**
 * Basic implementation of a 2x2 matrix.
 */
public class Matrix2x2d implements Cloneable, EpsilonEquatable<Matrix2x2d> {
//<editor-fold defaultstate="collapsed" desc="fields">
    /** M00 component. */
    private double m00;
    /** M01 component. */
    private double m01;
    /** M10 component. */
    private double m10;
    /** M11 component. */
    private double m11;
    private static final Logger LOG = Logger.getLogger(Matrix2x2d.class.getName());
    private static String format;
//</editor-fold>

    /**
     * Empty constructor.
     */
    public Matrix2x2d() {
        this(0, 0,
             0, 0);
    }

    /**
     * This constructor sets the properties of this matrix.
     *
     * @param m00 Value of the property M00.
     * @param m01 Value of the property M01.
     * @param m10 Value of the property M10.
     * @param m11 Value of the property M11.
     */
    public Matrix2x2d(double m00, double m01,
                      double m10, double m11) {
        this.m00 = m00;
        this.m01 = m01;
        this.m10 = m10;
        this.m11 = m11;
    }

    /*
     * This method gets an identity matrix.
     *
     * return Identity matrix.
     */
    public static Matrix2x2d getIdentity() {
        return new Matrix2x2d(1, 0,
                              0, 1);
    }

//<editor-fold defaultstate="collapsed" desc="accessors">
    /*
     * This method gets the number of rows.
     *
     * @return Number of rows.
     */
    public int sizeRows() {
        return 2;
    }

    /*
     * This method gets the number of columns.
     *
     * @return Number of columns.
     */
    public int sizeCols() {
        return 2;
    }

    /*
     * This method evaluates is {@code this} matrix is squared.
     *
     * @return {@code True} if {@code this} matrix is squared. {@code False} otherwise.
     */
    public boolean isSquared() {
        return true;
    }

    /**
     * This methods gets the property [r, c].
     *
     * @param r Number of the row.
     * @param c Number of the column.
     * @return Property [r, c].
     */
    public final double get(int r, int c) {
        switch(r) {
        case 0:
            switch(c) {
            case 0:
                return m00;
            case 1:
                return m01;
            }
        case 1:
            switch(c) {
            case 0:
                return m10;
            case 1:
                return m11;
            }
        }
        throw new IndexOutOfBoundsException();
    }

    /**
     * This methods sets the property [r, c].
     *
     * @param r Number of the row.
     * @param c Number of the column.
     * @param value Property [r, c].
     */
    public void set(int r, int c, double value) {
        switch(r) {
        case 0:
            switch(c) {
            case 0:
                m00 = value;
                return;
            case 1:
                m01 = value;
                return;
            }
        case 1:
            switch(c) {
            case 0:
                m10 = value;
                return;
            case 1:
                m11 = value;
                return;
            }
        }
        throw new IndexOutOfBoundsException();
    }

    /**
     * This methods gets the property [0, 0].
     *
     * @return Property [0, 0].
     */
    public final double getM00() {
        return m00;
    }

    /**
     * This methods sets the property [0, 0].
     *
     * @param value Property [0, 0].
     */
    public void setM00(double value) {
        m00 = value;
    }

    /**
     * This methods gets the property [0, 1].
     *
     * @return Property [0, 1].
     */
    public final double getM01() {
        return m01;
    }

    /**
     * This methods sets the property [0, 1].
     *
     * @param value Property [0, 1].
     */
    public void setM01(double value) {
        m01 = value;
    }

    /**
     * This methods gets the property [1, 0].
     *
     * @return Property [1, 0].
     */
    public final double getM10() {
        return m10;
    }

    /**
     * This methods sets the property [1, 0].
     *
     * @param value Property [1, 0].
     */
    public void setM10(double value) {
        m10 = value;
    }

    /**
     * This methods gets the property [1, 1].
     *
     * @return Property [1, 1].
     */
    public final double getM11() {
        return m11;
    }

    /**
     * This methods sets the property [1, 1].
     *
     * @param value Property [1, 1].
     */
    public void setM11(double value) {
        m11 = value;
    }

    /**
     * This methods sets all the properties.
     *
     * @param m00 Property [0, 0].
     * @param m01 Property [0, 1].
     * @param m10 Property [1, 0].
     * @param m11 Property [1, 1].
     */
    public Matrix2x2d set(double m00, double m01,
                          double m10, double m11) {
        this.m00 = m00;
        this.m01 = m01;
        this.m10 = m10;
        this.m11 = m11;
        return this;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Transforms">
    /**
     * This method multiplies {@code this} matrix by the {@code v} vector.
     *
     * @param v Vector.
     */
    public Vector2d mul(Vector2 v) {
        Tuple2_Double _v = TupleUtils.toTuple2_Double(v);

        return new Vector2d(getM00() * _v.getX() + getM01() * _v.getY(),
                            getM10() * _v.getX() + getM11() * _v.getY());
    }

    /**
     * This method multiplies {@code this} matrix by the {@code v} vector.
     *
     * @param v Vector.
     */
    public Vector2d mul(Vector2d v) {
        return new Vector2d(getM00() * v.getX() + getM01() * v.getY(),
                            getM10() * v.getX() + getM11() * v.getY());
    }

    /**
     * This method premultiplies {@code this} matrix by the {@code v} vector.
     *
     * @param v Vector.
     */
    public Vector2d premul(Vector2 v) {
        Tuple2_Double _v = TupleUtils.toTuple2_Double(v);

        return new Vector2d(_v.getX() * getM00() + _v.getY() * getM10(),
                            _v.getX() * getM01() + _v.getY() * getM11());
    }

    /**
     * This method premultiplies {@code this} matrix by the {@code v} vector.
     *
     * @param v Vector.
     */
    public Vector2d premul(Vector2d v) {
        return new Vector2d(v.getX() * getM00() + v.getY() * getM10(),
                            v.getX() * getM01() + v.getY() * getM11());
    }

    /**
     * This method multiplies {@code this} matrix by the {@code v} vector.
     *
     * @param v Vector.
     */
    public void mul(BuffVector2 v) {
        BuffTuple2_Double _v = TupleUtils.toBuffTuple2_Double(v);

        _v.set(getM00() * _v.getX() + getM01() * _v.getY(),
               getM10() * _v.getX() + getM11() * _v.getY());
    }

    /**
     * This method multiplies {@code this} matrix by the {@code v} vector.
     *
     * @param v Vector.
     */
    public void mul(BuffVector2d v) {
        v.set(getM00() * v.getX() + getM01() * v.getY(),
              getM10() * v.getX() + getM11() * v.getY());
    }

    /**
     * This method premultiplies {@code this} matrix by the {@code v} vector.
     *
     * @param v Vector.
     */
    public void premul(BuffVector2 v) {
        BuffTuple2_Double _v = TupleUtils.toBuffTuple2_Double(v);

        _v.set(_v.getX() * getM00() + _v.getY() * getM10(),
               _v.getX() * getM01() + _v.getY() * getM11());
    }

    /**
     * This method premultiplies {@code this} matrix by the {@code v} vector.
     *
     * @param v Vector.
     */
    public void premul(BuffVector2d v) {
        v.set (v.getX() * getM00() + v.getY() * getM10(),
               v.getX() * getM01() + v.getY() * getM11());
    }
//</editor-fold>

    public final boolean isValid() {
        return !isNaN() && !isInfinity();
    }

    /**
     * This method evaluates is {@code this} matrix contains any NaN component.
     *
     * @return {@code True} if {@code this} matrix contains any NaN component. {@code False} otherwise.
     */
    public final boolean isNaN() {
        return Double.isNaN(getM00()) || Double.isNaN(getM01()) ||
               Double.isNaN(getM10()) || Double.isNaN(getM11());
    }

    /**
     * This method evaluates is {@code this} matrix contains any infinity component.
     *
     * @return {@code True} if {@code this} matrix contains any infinity component. {@code False} otherwise.
     */
    public final boolean isInfinity() {
        return Double.isInfinite(getM00()) || Double.isInfinite(getM01()) ||
               Double.isInfinite(getM10()) || Double.isInfinite(getM11());
    }

    /**
     * This method evaluates is {@code this} matrix is zero.
     *
     * @return {@code True} if {@code this} matrix is zero. {@code False} otherwise.
     */
    public final boolean isZero() {
        return isZero(EPSILON);
    }

    /**
     * This method evaluates is {@code this} matrix is zero.
     *
     * @param epsilon Error.
     * @return {@code True} if {@code this} matrix is zero. {@code False} otherwise.
     */
    public final boolean isZero(double epsilon) {
        return epsilonEquals(0, 0,
                             0, 0, epsilon);
    }

    /**
     * This method evaluates is {@code this} matrix is the identity.
     *
     * @return {@code True} if {@code this} matrix is the identity. {@code False} otherwise.
     */
    public boolean isIdentity() {
        return isIdentity(EPSILON);
    }

    /**
     * This method evaluates is {@code this} matrix is the identity.
     *
     * @param epsilon Error.
     * @return {@code True} if {@code this} matrix is the identity. {@code False} otherwise.
     */
    public boolean isIdentity(double epsilon) {
        return epsilonEquals(1, 0,
                             0, 1, epsilon);
    }

    /**
     * This method evaluates is {@code this} matrix is the invertible.
     *
     * @return {@code True} if {@code this} matrix is invertible. {@code False} otherwise.
     */
    public boolean isInvertible() {
        return isInvertible(EPSILON);
    }

    /**
     * This method evaluates is {@code this} matrix is the invertible.
     *
     * @param epsilon Error.
     * @return {@code True} if {@code this} matrix is invertible. {@code False} otherwise.
     */
    public boolean isInvertible(double epsilon) {
        return !DoubleUtils.epsilonEquals(getDeterminant(), epsilon);
    }

    /**
     * This method evaluates the determinant of {@code this} matrix
     *
     * @return Determinant.
     */
    public double getDeterminant() {
        return (getM00() * getM11()
                - getM01() * getM10());
    }

    /**
     * This method adds {@code this} matrix and {@code other} matrix.
     *
     * @param other Other matrix.
     * @return {@code this + other}
     */
    public Matrix2x2d add(Matrix2x2d other) {
        return new Matrix2x2d(getM00() + other.getM00(), getM01() + other.getM01(),
                              getM10() + other.getM10(), getM11() + other.getM11());
    }

    /**
     * This method subs {@code this} matrix and {@code other} matrix.
     *
     * @param other Other matrix.
     * @return {@code this - other}
     */
    public Matrix2x2d sub(Matrix2x2d other) {
        return new Matrix2x2d(getM00() - other.getM00(), getM01() - other.getM01(),
                              getM10() - other.getM10(), getM11() - other.getM11());
    }

    /**
     * This method multiplies {@code this} matrix by {@code v}.
     *
     * @param v Scalar.
     * @return {@code this * v}
     */
    public Matrix2x2d mul(double v) {
        return new Matrix2x2d((double)(getM00() * v), (double)(getM01() * v),
                              (double)(getM10() * v), (double)(getM11() * v));
    }

    /**
     * This method divides {@code this} matrix by {@code v}.
     *
     * @param v Scalar.
     * @return {@code this / v}
     */
    public Matrix2x2d div(double v) {
        return new Matrix2x2d((double)(getM00() / v), (double)(getM01() / v),
                              (double)(getM10() / v), (double)(getM11() / v));
    }

    /**
     * This method multiplies {@code this} matrix by {@code other} matrix.
     *
     * @param other Other matrix.
     * @return {@code this * other}
     */
    public Matrix2x2d mul(Matrix2x2d other) {
        return new Matrix2x2d(getM00() * other.getM00() + getM01() * other.getM10(),
                              getM00() * other.getM01() + getM01() * other.getM11(),
                              getM10() * other.getM00() + getM11() * other.getM10(),
                              getM10() * other.getM01() + getM11() * other.getM11());
    }

    /**
     * This method changes the sign of {@code this} matrix.
     *
     * @return {@code -this}
     */
    public Matrix2x2d neg() {
        return new Matrix2x2d(- getM00(), - getM01(),
                              - getM10(), - getM11());
    }

    /**
     * This method calculates the absolute value of {@code this} matrix.
     *
     * @return {@code abs(this)}
     */
    public Matrix2x2d abs() {
        return new Matrix2x2d(Math.abs(getM00()), Math.abs(getM01()),
                              Math.abs(getM10()), Math.abs(getM11()));
    }

    /**
     * This method calculates the transpose of {@code this} matrix.
     *
     * @return {@code transpose(this)}
     */
    public Matrix2x2d transpose() {
        return new Matrix2x2d(getM00(), getM10(),
                              getM01(), getM11());
    }

    /**
     * This method evaluates the inverse of {@code this} matrix.
     *
     * @return {@code inverse(this)}
     */
    public Matrix2x2d inverse() throws SingularMatrixException {
        double s = getDeterminant();
        if (DoubleUtils.epsilonZero(s, EPSILON)) {
            throw new SingularMatrixException();
        }

        s = 1 / s;

        return new Matrix2x2d(
                   (double)(getM11() * s), (double)(-getM01() * s),
                   (double)(-getM10() * s), (double)(getM00() * s));
    }

    /**
     * This method sets {@code this} matrix to zero.
     *
     * @return {@code this = zero}
     */
    public Matrix2x2d setZero() {
        set(0, 0,
            0, 0);
        return this;
    }

    /**
     * This method sets {@code this} matrix to the identity.
     *
     * @return {@code this = identity}
     */
    public Matrix2x2d setIdentity() {
        set(1, 0,
            0, 1);
        return this;
    }

    /**
     * This method adds {@code this} matrix and {@code other} matrix and sets the result
     * into {@code this}.
     *
     * @param other Other matrix.
     * @return {@code this = this + other}
     */
    public Matrix2x2d addAndSet(Matrix2x2d other) {
        set(getM00() + other.getM00(), getM01() + other.getM01(),
            getM10() + other.getM10(), getM11() + other.getM11());
        return this;
    }

    /**
     * This method subs {@code this} matrix and {@code other} matrix and sets the result
     * into {@code this}.
     *
     * @param other Other matrix.
     * @return {@code this = this - other}
     */
    public Matrix2x2d subAndSet(Matrix2x2d other) {
        set(getM00() - other.getM00(), getM01() - other.getM01(),
            getM10() - other.getM10(), getM11() - other.getM11());
        return this;
    }

    /**
     * This method multiplies {@code this} matrix by {@code v} and sets the result
     * into {@code this}.
     *
     * @param v Scalar.
     * @return {@code this = this * v}
     */
    public Matrix2x2d mulAndSet(double v) {
        set((double)(getM00() * v), (double)(getM01() * v),
            (double)(getM10() * v), (double)(getM11() * v));
        return this;
    }

    /**
     * This method divides {@code this} matrix by {@code v} and sets the result
     * into {@code this}.
     *
     * @param v Scalar.
     * @return {@code this = this / v}
     */
    public Matrix2x2d divAndSet(double v) {
        set((double)(getM00() / v), (double)(getM01() / v),
            (double)(getM10() / v), (double)(getM11() / v));
        return this;
    }

    /**
     * This method multiplies {@code this} matrix by {@code other} matrix and sets the result
     * into {@code this}.
     *
     * @param other Other matrix.
     * @return {@code this = this * other}
     */
    public Matrix2x2d mulAndSet(Matrix2x2d other) {
        set(getM00() * other.getM00() + getM01() * other.getM10(),
            getM00() * other.getM01() + getM01() * other.getM11(),
            getM10() * other.getM00() + getM11() * other.getM10(),
            getM10() * other.getM01() + getM11() * other.getM11());
        return this;
    }

    /**
     * This method changes the sign of {@code this} matrix and sets the result
     * into {@code this}.
     *
     * @return {@code this = -this}
     */
    public Matrix2x2d negAndSet() {
        set(- getM00(), - getM01(),
            - getM10(), - getM11());
        return this;
    }

    /**
     * This method calculates the absolute value of {@code this} matrix and sets the result
     * into {@code this}.
     *
     * @return {@code this = abs(this)}
     */
    public Matrix2x2d absAndSet() {
        set(Math.abs(getM00()), Math.abs(getM01()),
            Math.abs(getM10()), Math.abs(getM11()));
        return this;
    }

    /**
     * This method calculates the transpose of {@code this} matrix and sets the result
     * into {@code this}.
     *
     * @return {@code this = transpose(this)}
     */
    public Matrix2x2d transposeAndSet() {
        set(getM00(), getM10(),
            getM01(), getM11());
        return this;
    }

    /**
     * This method evaluates the inverse of {@code this} matrix and sets the result
     * into {@code this}.
     *
     * @return {@code this = this^-1}
     */
    public Matrix2x2d inverseAndSet() throws SingularMatrixException {
        double s = getDeterminant();
        if (DoubleUtils.epsilonZero(s, EPSILON)) {
            throw new SingularMatrixException();
        }

        s = 1 / s;

        set(
            (double)(getM11() * s), (double)(-getM01() * s),
            (double)(-getM10() * s), (double)(getM00() * s));
        return this;
    }

//<editor-fold defaultstate="collapsed" desc="Object">
    @Override
    public String toString() {
        VectorFormatInfo vfi = VectorFormatInfo.CURRENT_INFO;
        return String.format(getFormat(), vfi.getBeg(), vfi.getSep(), vfi.getEnd(),
                             getM00(),getM01(),
                             getM10(),getM11());
    }

    public boolean equals(Matrix2x2d other) {
        if (other == this) {
            return true;
        }
        if (other == null) {
            return false;
        }

        return this.equals(other.getM00(), other.getM01(),
                           other.getM10(), other.getM11());
    }

    @Override
    public boolean equals(Object other) {
        return ((other instanceof Matrix2x2d) && this.equals((Matrix2x2d) other));
    }

    @Override
    public int hashCode() {
        // https://stackoverflow.com/questions/113511/best-implementation-for-hashcode-method
        // http://www.jarvana.com/jarvana/view/org/apache/lucene/lucene-spatial/2.9.3/lucene-spatial-2.9.3-sources.jar!/org/apache/lucene/spatial/geometry/shape/Vector2D.java
        final int prime = 31;
        int hash = 1;
        hash = prime * hash + Double.hashCode(getM00());
        hash = prime * hash + Double.hashCode(getM01());
        hash = prime * hash + Double.hashCode(getM10());
        hash = prime * hash + Double.hashCode(getM11());
        return hash;
    }

    @Override
    public Matrix2x2d clone() throws CloneNotSupportedException {
        return (Matrix2x2d)super.clone();
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="EpsilonEquatable<Matrix2x2d>">
    @Override
    public boolean epsilonEquals(Matrix2x2d other, double epsilon) {
        if (other == this) {
            return true;
        }
        if (other == null) {
            return false;
        }
        return epsilonEquals(getM00(), getM01(),
                             getM10(), getM11(), epsilon);
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="private">
    private boolean epsilonEquals(double m00, double m01,
                                  double m10, double m11) {
        return epsilonEquals(m00, m01,
                             m10, m11, EPSILON);
    }

    private boolean epsilonEquals(double m00, double m01,
                                  double m10, double m11, double epsilon) {
        return DoubleUtils.epsilonEquals(getM00(), m00, epsilon) && DoubleUtils.epsilonEquals(getM01(), m01, epsilon)
               && DoubleUtils.epsilonEquals(getM10(), m10, epsilon) && DoubleUtils.epsilonEquals(getM11(), m11, epsilon);
    }

    private boolean equals(double m00, double m01,
                           double m10, double m11) {
        return getM00() == m00 && getM01() == m01
               && getM10() == m10 && getM11() == m11;
    }

    private static String getFormat() {
        if (format == null) {
            String f = ".3f"; // Floating point number with 2 decimal places

            StringBuilder buff = new StringBuilder();
            String b = "%1$s"; // Begin      [
            String s = "%2$s"; // Separation ,
            String e = "%3$s"; // End        ]
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

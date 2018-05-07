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
import essence.geometry.core.Vector3;
import essence.geometry.core.Vector2;
import essence.geometry.core.Point2;
import essence.geometry.core.VectorFormatInfo;

import static essence.geometry.core.DoubleUtils.EPSILON;

/**
 * Basic implementation of a 3x3 matrix.
 */
public class Matrix3x3d implements Cloneable, EpsilonEquatable<Matrix3x3d> {
//<editor-fold defaultstate="collapsed" desc="fields">
    /** M00 component. */
    private double m00;
    /** M01 component. */
    private double m01;
    /** M02 component. */
    private double m02;
    /** M10 component. */
    private double m10;
    /** M11 component. */
    private double m11;
    /** M12 component. */
    private double m12;
    /** M20 component. */
    private double m20;
    /** M21 component. */
    private double m21;
    /** M22 component. */
    private double m22;
    private static final Logger LOG = Logger.getLogger(Matrix3x3d.class.getName());
    private static String format;
//</editor-fold>

    /**
     * Empty constructor.
     */
    public Matrix3x3d() {
        this(0, 0, 0,
            0, 0, 0,
            0, 0, 0);
    }

    /**
     * This constructor sets the properties of this matrix.
     *
     * @param m00 Value of the property M00.
     * @param m01 Value of the property M01.
     * @param m02 Value of the property M02.
     * @param m10 Value of the property M10.
     * @param m11 Value of the property M11.
     * @param m12 Value of the property M12.
     * @param m20 Value of the property M20.
     * @param m21 Value of the property M21.
     * @param m22 Value of the property M22.
     */
    public Matrix3x3d(double m00, double m01, double m02,
        double m10, double m11, double m12,
        double m20, double m21, double m22) {
        this.m00 = m00;
        this.m01 = m01;
        this.m02 = m02;
        this.m10 = m10;
        this.m11 = m11;
        this.m12 = m12;
        this.m20 = m20;
        this.m21 = m21;
        this.m22 = m22;
    }

    /*
     * This method gets an identity matrix.
     *
     * return Identity matrix. 
     */
    public static Matrix3x3d getIdentity() {
        return new Matrix3x3d(1, 0, 0,
            0, 1, 0,
            0, 0, 1);
    }

    protected static Tuple3_Double toTuple(Tuple other) {
        if (other instanceof Tuple3_Double) {
            return (Tuple3_Double)other;
        }
        Tuple3d aux = new Tuple3d();
        other.getInto(aux);
        return aux;
    }

//<editor-fold defaultstate="collapsed" desc="accessors">
    /*
     * This method gets the number of rows.
     *
     * @return Number of rows.
     */
    public int sizeRows() {
        return 3;
    }

    /*
     * This method gets the number of columns.
     *
     * @return Number of columns.
     */
    public int sizeCols() {
        return 3;
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
    public double get(int r, int c) {
        switch(r) {
            case 0:
                switch(c) {
                    case 0:
                        return m00;
                    case 1:
                        return m01;
                    case 2:
                        return m02;
                }
            case 1:
                switch(c) {
                    case 0:
                        return m10;
                    case 1:
                        return m11;
                    case 2:
                        return m12;
                }
            case 2:
                switch(c) {
                    case 0:
                        return m20;
                    case 1:
                        return m21;
                    case 2:
                        return m22;
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
                    case 2:
                        m02 = value;
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
                    case 2:
                        m12 = value;
                        return;
                }
            case 2:
                switch(c) {
                    case 0:
                        m20 = value;
                        return;
                    case 1:
                        m21 = value;
                        return;
                    case 2:
                        m22 = value;
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
    public double getM00() {
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
    public double getM01() {
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
     * This methods gets the property [0, 2].
     *
     * @return Property [0, 2].
     */
    public double getM02() {
        return m02;
    }

    /**
     * This methods sets the property [0, 2].
     *
     * @param value Property [0, 2].
     */
    public void setM02(double value) {
        m02 = value;
    }

    /**
     * This methods gets the property [1, 0].
     *
     * @return Property [1, 0].
     */
    public double getM10() {
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
    public double getM11() {
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
     * This methods gets the property [1, 2].
     *
     * @return Property [1, 2].
     */
    public double getM12() {
        return m12;
    }

    /**
     * This methods sets the property [1, 2].
     *
     * @param value Property [1, 2].
     */
    public void setM12(double value) {
        m12 = value;
    }

    /**
     * This methods gets the property [2, 0].
     *
     * @return Property [2, 0].
     */
    public double getM20() {
        return m20;
    }

    /**
     * This methods sets the property [2, 0].
     *
     * @param value Property [2, 0].
     */
    public void setM20(double value) {
        m20 = value;
    }

    /**
     * This methods gets the property [2, 1].
     *
     * @return Property [2, 1].
     */
    public double getM21() {
        return m21;
    }

    /**
     * This methods sets the property [2, 1].
     *
     * @param value Property [2, 1].
     */
    public void setM21(double value) {
        m21 = value;
    }

    /**
     * This methods gets the property [2, 2].
     *
     * @return Property [2, 2].
     */
    public double getM22() {
        return m22;
    }

    /**
     * This methods sets the property [2, 2].
     *
     * @param value Property [2, 2].
     */
    public void setM22(double value) {
        m22 = value;
    }

    /**
     * This methods sets all the properties.
     *
     * @param m00 Property [0, 0].
     * @param m01 Property [0, 1].
     * @param m02 Property [0, 2].
     * @param m10 Property [1, 0].
     * @param m11 Property [1, 1].
     * @param m12 Property [1, 2].
     * @param m20 Property [2, 0].
     * @param m21 Property [2, 1].
     * @param m22 Property [2, 2].
     */
    public Matrix3x3d set(double m00, double m01, double m02,
        double m10, double m11, double m12,
        double m20, double m21, double m22) {
        this.m00 = m00;
        this.m01 = m01;
        this.m02 = m02;
        this.m10 = m10;
        this.m11 = m11;
        this.m12 = m12;
        this.m20 = m20;
        this.m21 = m21;
        this.m22 = m22;
        return this;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Transforms">
    /**
     * This method multiplies {@code this} matrix by the {@code v} vector.
     *
     * @param v Vector.
     */
    public void mul(Vector3 v) {
        if (v instanceof Vector3d) {
            mul((Vector3d)v);
        } else {
            Vector3d aux = new Vector3d(v);
            premul(aux);
            v.set(aux);
        }
    }

    /**
     * This method multiplies {@code this} matrix by the {@code v} vector.
     *
     * @param v Vector.
     */
    public void mul(Vector3d v) {
        v.set(getM00() * v.getX() + getM01() * v.getY() + getM02() * v.getZ(),
            getM10() * v.getX() + getM11() * v.getY() + getM12() * v.getZ(),
            getM20() * v.getX() + getM21() * v.getY() + getM22() * v.getZ());
    }

    /**
     * This method premultiplies {@code this} matrix by the {@code v} vector.
     *
     * @param v Vector.
     */
    public void premul(Vector3 v) {
        if (v instanceof Vector3d) {
            premul((Vector3d)v);
        } else {
            Vector3d aux = new Vector3d(v);
            premul(aux);
            v.set(aux);
        }
    }

    /**
     * This method premultiplies {@code this} matrix by the {@code v} vector.
     *
     * @param v Vector.
     */
    public void premul(Vector3d v) {
        v.set(v.getX() * getM00() + v.getY() * getM10() + v.getZ() * getM20(),
            v.getX() * getM01() + v.getY() * getM11() + v.getZ() * getM21(),
            v.getX() * getM02() + v.getY() * getM12() + v.getZ() * getM22());
    }

    /**
     * This method multiplies {@code this} matrix by the {@code v} vector.
     *
     * @param v Vector.
     */
    public void mul(Vector2 v) {
        if (v instanceof Vector2d) {
            mul((Vector2d)v);
        } else {
            Vector2d aux = new Vector2d(v);
            mul(aux);
            v.set(aux);
        }
    }

    /**
     * This method multiplies {@code this} matrix by the {@code v} vector.
     *
     * @param v Vector.
     */
    public void mul(Vector2d v) {
        double x = getM00() * v.getX() + getM01() * v.getY();
        double y = getM10() * v.getX() + getM11() * v.getY();
        v.set(x, y);
    }

    /**
     * This method multiplies {@code this} matrix by the {@code p} point.
     *
     * @param p Point.
     */
    public void mul(Point2 p) {
        if (p instanceof Point2d) {
            mul((Point2d)p);
        } else {
            Point2d aux = new Point2d(p);
            mul(aux);
            p.set(aux);
        }
    }

    /**
     * This method multiplies {@code this} matrix by the {@code p} point.
     *
     * @param p Point.
     */
    public void mul(Point2d p) {
        double x = getM00() * p.getX() + getM01() * p.getY() + getM02();
        double y = getM10() * p.getX() + getM11() * p.getY() + getM12();
        double z = getM20() * p.getX() + getM21() * p.getY() + getM22();
        p.set(x / z, y / z);
    }

    /**
     * This method premultiplies {@code this} matrix by the {@code v} vector.
     *
     * @param v Vector.
     */
    public void premul(Vector2 v) {
        if (v instanceof Vector2d) {
            premul((Vector2d)v);
        } else {
            Vector2d aux = new Vector2d(v);
            premul(aux);
            v.set(aux);
        }
    }

    /**
     * This method premultiplies {@code this} matrix by the {@code v} vector.
     *
     * @param v Vector.
     */
    public void premul(Vector2d v) {
        double x = v.getX() * getM00() + v.getY() * getM10();
        double y = v.getX() * getM01() + v.getY() * getM11();
        v.set(x, y);
    }

    /**
     * This method premultiplies {@code this} matrix by the {@code p} point.
     *
     * @param p Point.
     */
    public void premul(Point2 p) {
        if (p instanceof Point2d) {
            premul((Point2d)p);
        } else {
            Point2d aux = new Point2d(p);
            premul(aux);
            p.set(aux);
        }
    }

    /**
     * This method premultiplies {@code this} matrix by the {@code p} point.
     *
     * @param p Point.
     */
    public void premul(Point2d p) {
        double x = p.getX() * getM00() + p.getY() * getM10() + getM20();
        double y = p.getX() * getM01() + p.getY() * getM11() + getM21();
        double z = p.getX() * getM02() + p.getY() * getM12() + getM22();
        p.set(x / z, y / z);
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
        return Double.isNaN(getM00()) || Double.isNaN(getM01()) || Double.isNaN(getM02()) ||
            Double.isNaN(getM10()) || Double.isNaN(getM11()) || Double.isNaN(getM12()) ||
            Double.isNaN(getM20()) || Double.isNaN(getM21()) || Double.isNaN(getM22());
    }

    /**
     * This method evaluates is {@code this} matrix contains any infinity component.
     *
     * @return {@code True} if {@code this} matrix contains any infinity component. {@code False} otherwise.
     */
    public final boolean isInfinity() {
        return Double.isInfinite(getM00()) || Double.isInfinite(getM01()) || Double.isInfinite(getM02()) ||
            Double.isInfinite(getM10()) || Double.isInfinite(getM11()) || Double.isInfinite(getM12()) ||
            Double.isInfinite(getM20()) || Double.isInfinite(getM21()) || Double.isInfinite(getM22());
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
        return epsilonEquals(0, 0, 0,
            0, 0, 0,
            0, 0, 0, epsilon);
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
        return epsilonEquals(1, 0, 0,
            0, 1, 0,
            0, 0, 1, epsilon);
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
        return (getM00() * (getM11() * getM22() - getM21() * getM12())
                - getM01() * (getM10() * getM22() - getM20() * getM12())
                + getM02() * (getM10() * getM21() - getM20() * getM11()));
    }

    /**
     * This method adds {@code this} matrix and {@code other} matrix.
     *
     * @param other Other matrix.
     * @return {@code this + other}
     */
    public Matrix3x3d add(Matrix3x3d other) {
        return clone().addAndSet(other);
    }

    /**
     * This method subs {@code this} matrix and {@code other} matrix.
     *
     * @param other Other matrix.
     * @return {@code this - other}
     */
    public Matrix3x3d sub(Matrix3x3d other) {
        return clone().subAndSet(other);
    }

    /**
     * This method multiplies {@code this} matrix by {@code v}.
     *
     * @param v Scalar.
     * @return {@code this * v}
     */
    public Matrix3x3d mul(double v) {
        return clone().mulAndSet(v);
    }

    /**
     * This method divides {@code this} matrix by {@code v}.
     *
     * @param v Scalar.
     * @return {@code this / v}
     */
    public Matrix3x3d div(double v) {
        return clone().divAndSet(v);
    }

    /**
     * This method multiplies {@code this} matrix by {@code other} matrix.
     *
     * @param other Other matrix.
     * @return {@code this * other}
     */
    public Matrix3x3d mul(Matrix3x3d other) {
        return clone().mulAndSet(other);
    }

    /**
     * This method changes the sign of {@code this} matrix.
     *
     * @return {@code -this}
     */
    public Matrix3x3d neg() {
        return clone().negAndSet();
    }

    /**
     * This method calculates the absolute value of {@code this} matrix.
     *
     * @return {@code abs(this)}
     */
    public Matrix3x3d abs() {
        return clone().absAndSet();
    }

    /**
     * This method calculates the transpose of {@code this} matrix.
     *
     * @return {@code transpose(this)}
     */
    public Matrix3x3d transpose() {
        return clone().transposeAndSet();
    }

    /**
     * This method evaluates the inverse of {@code this} matrix.
     *
     * @return {@code inverse(this)}
     */
    public Matrix3x3d inverse() throws SingularMatrixException {
        return clone().inverseAndSet();
    }

    /**
     * This method sets {@code this} matrix to zero.
     *
     * @return {@code this = zero}
     */
    public Matrix3x3d setZero() {
        set(0, 0, 0,
            0, 0, 0,
            0, 0, 0);
        return this;
    }

    /**
     * This method sets {@code this} matrix to the identity.
     *
     * @return {@code this = identity}
     */
    public Matrix3x3d setIdentity() {
        set(1, 0, 0,
            0, 1, 0,
            0, 0, 1);
        return this;
    }

    /**
     * This method adds {@code this} matrix and {@code other} matrix and sets the result
     * into {@code this}.
     *
     * @param other Other matrix.
     * @return {@code this = this + other}
     */
    public Matrix3x3d addAndSet(Matrix3x3d other) {
        set(getM00() + other.getM00(), getM01() + other.getM01(), getM02() + other.getM02(),
            getM10() + other.getM10(), getM11() + other.getM11(), getM12() + other.getM12(),
            getM20() + other.getM20(), getM21() + other.getM21(), getM22() + other.getM22());
        return this;
    }

    /**
     * This method subs {@code this} matrix and {@code other} matrix and sets the result
     * into {@code this}.
     *
     * @param other Other matrix.
     * @return {@code this = this - other}
     */
    public Matrix3x3d subAndSet(Matrix3x3d other) {
        set(getM00() - other.getM00(), getM01() - other.getM01(), getM02() - other.getM02(),
            getM10() - other.getM10(), getM11() - other.getM11(), getM12() - other.getM12(),
            getM20() - other.getM20(), getM21() - other.getM21(), getM22() - other.getM22());
        return this;
    }

    /**
     * This method multiplies {@code this} matrix by {@code v} and sets the result
     * into {@code this}.
     *
     * @param v Scalar.
     * @return {@code this = this * v}
     */
    public Matrix3x3d mulAndSet(double v) {
        set((double)(getM00() * v), (double)(getM01() * v), (double)(getM02() * v),
            (double)(getM10() * v), (double)(getM11() * v), (double)(getM12() * v),
            (double)(getM20() * v), (double)(getM21() * v), (double)(getM22() * v));
        return this;
    }

    /**
     * This method divides {@code this} matrix by {@code v} and sets the result
     * into {@code this}.
     *
     * @param v Scalar.
     * @return {@code this = this / v}
     */
    public Matrix3x3d divAndSet(double v) {
        set((double)(getM00() / v), (double)(getM01() / v), (double)(getM02() / v),
            (double)(getM10() / v), (double)(getM11() / v), (double)(getM12() / v),
            (double)(getM20() / v), (double)(getM21() / v), (double)(getM22() / v));
        return this;
    }

    /**
     * This method multiplies {@code this} matrix by {@code other} matrix and sets the result
     * into {@code this}.
     *
     * @param other Other matrix.
     * @return {@code this = this * other}
     */
    public Matrix3x3d mulAndSet(Matrix3x3d other) {
        set(getM00() * other.getM00() + getM01() * other.getM10() + getM02() * other.getM20(),
            getM00() * other.getM01() + getM01() * other.getM11() + getM02() * other.getM21(),
            getM00() * other.getM02() + getM01() * other.getM12() + getM02() * other.getM22(),
            getM10() * other.getM00() + getM11() * other.getM10() + getM12() * other.getM20(),
            getM10() * other.getM01() + getM11() * other.getM11() + getM12() * other.getM21(),
            getM10() * other.getM02() + getM11() * other.getM12() + getM12() * other.getM22(),
            getM20() * other.getM00() + getM21() * other.getM10() + getM22() * other.getM20(),
            getM20() * other.getM01() + getM21() * other.getM11() + getM22() * other.getM21(),
            getM20() * other.getM02() + getM21() * other.getM12() + getM22() * other.getM22());
        return this;
    }

    /**
     * This method changes the sign of {@code this} matrix and sets the result
     * into {@code this}.
     *
     * @return {@code this = -this}
     */
    public Matrix3x3d negAndSet() {
        set(-getM00(), -getM01(), -getM02(),
            -getM10(), -getM11(), -getM12(),
            -getM20(), -getM21(), -getM22());
        return this;
    }

    /**
     * This method calculates the absolute value of {@code this} matrix and sets the result
     * into {@code this}.
     *
     * @return {@code this = abs(this)}
     */
    public Matrix3x3d absAndSet() {
        set(Math.abs(getM00()), Math.abs(getM01()), Math.abs(getM02()),
            Math.abs(getM10()), Math.abs(getM11()), Math.abs(getM12()),
            Math.abs(getM20()), Math.abs(getM21()), Math.abs(getM22()));
        return this;
    }

    /**
     * This method calculates the transpose of {@code this} matrix and sets the result
     * into {@code this}.
     *
     * @return {@code this = transpose(this)}
     */
    public Matrix3x3d transposeAndSet() {
        set(getM00(), getM10(), getM20(),
            getM01(), getM11(), getM21(),
            getM02(), getM12(), getM22());
        return this;
    }

    /**
     * This method evaluates the inverse of {@code this} matrix and sets the result
     * into {@code this}.
     *
     * @return {@code this = this^-1}
     */
    public Matrix3x3d inverseAndSet() throws SingularMatrixException {
        double s = getDeterminant();
        if (DoubleUtils.epsilonZero(s, EPSILON)) {
            throw new SingularMatrixException();
        }

        s = 1 / s;
        set(
            (double)((getM11() * getM22() - getM12() * getM21()) * s),
            (double)((getM02() * getM21() - getM01() * getM22()) * s),
            (double)((getM01() * getM12() - getM02() * getM11()) * s),
            (double)((getM12() * getM20() - getM10() * getM22()) * s),
            (double)((getM00() * getM22() - getM02() * getM20()) * s),
            (double)((getM02() * getM10() - getM00() * getM12()) * s),
            (double)((getM10() * getM21() - getM11() * getM20()) * s),
            (double)((getM01() * getM20() - getM00() * getM21()) * s),
            (double)((getM00() * getM11() - getM01() * getM10()) * s));
        return this;
    }

//<editor-fold defaultstate="collapsed" desc="Object">
    @Override
    public String toString() {
        VectorFormatInfo vfi = VectorFormatInfo.CURRENT_INFO;
        return String.format(getFormat(), vfi.getBeg(), vfi.getSep(), vfi.getEnd(),
            getM00(),getM01(),getM02(),
            getM10(),getM11(),getM12(),
            getM20(),getM21(),getM22());
    }

    public boolean equals(Matrix3x3d other) {
        if (other == this) {
            return true;
        }
        if (other == null) {
            return false;
        }

        return this.equals(getM00(), getM01(), getM02(),
            getM10(), getM11(), getM12(),
            getM20(), getM21(), getM22());
    }

    @Override
    public boolean equals(Object other) {
        return ((other instanceof Matrix3x3d) && this.equals((Matrix3x3d) other));
    }

    @Override
    public int hashCode() {
        // https://stackoverflow.com/questions/113511/best-implementation-for-hashcode-method
        // http://www.jarvana.com/jarvana/view/org/apache/lucene/lucene-spatial/2.9.3/lucene-spatial-2.9.3-sources.jar!/org/apache/lucene/spatial/geometry/shape/Vector2D.java
        final int prime = 31;
        int hash = 1;
        hash = prime * hash + Double.hashCode(getM00());
        hash = prime * hash + Double.hashCode(getM01());
        hash = prime * hash + Double.hashCode(getM02());
        hash = prime * hash + Double.hashCode(getM10());
        hash = prime * hash + Double.hashCode(getM11());
        hash = prime * hash + Double.hashCode(getM12());
        hash = prime * hash + Double.hashCode(getM20());
        hash = prime * hash + Double.hashCode(getM21());
        hash = prime * hash + Double.hashCode(getM22());
        return hash;
    }

    @Override
    public Matrix3x3d clone() {
        try {
            Matrix3x3d copy = (Matrix3x3d)super.clone();
            return copy;
        } catch (CloneNotSupportedException ex) {
            throw new Error(ex);
        }
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="EpsilonEquatable<Matrix3x3d>">
    @Override
    public boolean epsilonEquals(Matrix3x3d other, double epsilon) {
        if (other == this) {
            return true;
        }
        if (other == null) {
            return false;
        }
        return epsilonEquals(getM00(), getM01(), getM02(),
            getM10(), getM11(), getM12(),
            getM20(), getM21(), getM22(), epsilon);
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="private">
    private boolean epsilonEquals(double m00, double m01, double m02,
        double m10, double m11, double m12,
        double m20, double m21, double m22) {
        return epsilonEquals(m00, m01, m02,
            m10, m11, m12,
            m20, m21, m22, EPSILON);
    }

    private boolean epsilonEquals(double m00, double m01, double m02,
        double m10, double m11, double m12,
        double m20, double m21, double m22, double epsilon) {
        return DoubleUtils.epsilonEquals(getM00(), m00, epsilon) && DoubleUtils.epsilonEquals(getM01(), m01, epsilon) && DoubleUtils.epsilonEquals(getM02(), m02, epsilon)
            && DoubleUtils.epsilonEquals(getM10(), m10, epsilon) && DoubleUtils.epsilonEquals(getM11(), m11, epsilon) && DoubleUtils.epsilonEquals(getM12(), m12, epsilon)
            && DoubleUtils.epsilonEquals(getM20(), m20, epsilon) && DoubleUtils.epsilonEquals(getM21(), m21, epsilon) && DoubleUtils.epsilonEquals(getM22(), m22, epsilon);
    }

    private boolean equals(double m00, double m01, double m02,
        double m10, double m11, double m12,
        double m20, double m21, double m22) {
        return getM00() == m00 && getM01() == m01 && getM02() == m02
            && getM10() == m10 && getM11() == m11 && getM12() == m12
            && getM20() == m20 && getM21() == m21 && getM22() == m22;
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
            buff.append(s);
            buff.append("%").append(k++).append("$").append(f);
            buff.append(s);
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









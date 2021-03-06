// <auto-generated>
//     This code was generated by a tool.
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </auto-generated>
//
// Copyright (C) 2018 joseluis.
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 2.1 of the License, or (at your option) any later version.
//
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
// Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public
// License along with this library; if not, write to the Free Software
// Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
// MA 02110-1301  USA

using java.util.logging.Logger;
using essence.util.math.EpsilonEquatable;
using essence.geometry.core.DoubleUtils;
using essence.geometry.core.SingularMatrixException;
using essence.geometry.core.Tuple;
using essence.geometry.core.MatrixInpector;
using essence.geometry.core.MatrixSet;
using essence.geometry.core.Vector3;
using essence.geometry.core.BuffVector3;
using essence.geometry.core.Vector2;
using essence.geometry.core.Point2;
using essence.geometry.core.BuffVector2;
using essence.geometry.core.BuffPoint2;
using essence.geometry.core.VectorFormatInfo;
using essence.geometry.core.Matrix3x3;
using essence.geometry.core.BuffMatrix3x3;

using static essence.geometry.core.DoubleUtils.EPSILON;

namespace essence.geometry.core.doubles
{
/**
 * Basic implementation of a 3x3 matrix.
 */
public class Matrix3x3d : Cloneable, EpsilonEquatable<Matrix3x3d>, BuffMatrix3x3
{
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
    public Matrix3x3d()
    {
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
                      double m20, double m21, double m22)
    {
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

    /**
     * Copy constructor.
     */
    public Matrix3x3d(MatrixInpector other)
    {
        other.getInto(this);
    }

    /*
     * This method gets an identity matrix.
     *
     * return Identity matrix.
     */
    public static Matrix3x3d getIdentity()
    {
        return new Matrix3x3d(1, 0, 0,
                              0, 1, 0,
                              0, 0, 1);
    }

//<editor-fold defaultstate="collapsed" desc="Transforms">
    public Vector3d Mul(Vector3 v)
    {
        if (v is Vector3d)
        {
            return Mul((Vector3d)v);
        }
        else if (v is BuffVector3d)
        {
            return Mul((BuffVector3d)v);
        }
        else
        {
            return Mul(new Vector3d(v));
        }
    }

    public Vector3d Mul(Vector3d v)
    {
        return new Vector3d(getM00() * v.getX() + getM01() * v.getY() + getM02() * v.getZ(),
                            getM10() * v.getX() + getM11() * v.getY() + getM12() * v.getZ(),
                            getM20() * v.getX() + getM21() * v.getY() + getM22() * v.getZ());
    }

    public Vector3d Mul(BuffVector3d v)
    {
        return new Vector3d(getM00() * v.getX() + getM01() * v.getY() + getM02() * v.getZ(),
                            getM10() * v.getX() + getM11() * v.getY() + getM12() * v.getZ(),
                            getM20() * v.getX() + getM21() * v.getY() + getM22() * v.getZ());
    }

    public Vector3d Premul(Vector3 v)
    {
        if (v is Vector3d)
        {
            return Premul((Vector3d)v);
        }
        else if (v is BuffVector3d)
        {
            return Premul((BuffVector3d)v);
        }
        else
        {
            return Premul(new Vector3d(v));
        }
    }

    public Vector3d Premul(Vector3d v)
    {
        return new Vector3d(v.getX() * getM00() + v.getY() * getM10() + v.getZ() * getM20(),
                            v.getX() * getM01() + v.getY() * getM11() + v.getZ() * getM21(),
                            v.getX() * getM02() + v.getY() * getM12() + v.getZ() * getM22());
    }

    public Vector3d Premul(BuffVector3d v)
    {
        return new Vector3d(v.getX() * getM00() + v.getY() * getM10() + v.getZ() * getM20(),
                            v.getX() * getM01() + v.getY() * getM11() + v.getZ() * getM21(),
                            v.getX() * getM02() + v.getY() * getM12() + v.getZ() * getM22());
    }

    public Vector2d Mul(Vector2 v)
    {
        if (v is Vector2d)
        {
            return Mul((Vector2d)v);
        }
        else if (v is BuffVector2d)
        {
            return Mul((BuffVector2d)v);
        }
        else
        {
            return Mul(new Vector2d(v));
        }
    }

    public Vector2d Mul(Vector2d v)
    {
        double x = getM00() * v.getX() + getM01() * v.getY();
        double y = getM10() * v.getX() + getM11() * v.getY();
        return new Vector2d(x, y);
    }

    public Vector2d Mul(BuffVector2d v)
    {
        double x = getM00() * v.getX() + getM01() * v.getY();
        double y = getM10() * v.getX() + getM11() * v.getY();
        return new Vector2d(x, y);
    }

    public Point2d Mul(Point2 p)
    {
        if (p is Point2d)
        {
            return Mul((Point2d)p);
        }
        else if (p is BuffPoint2d)
        {
            return Mul((BuffPoint2d)p);
        }
        else
        {
            return Mul(new Point2d(p));
        }
    }

    public Point2d Mul(Point2d p)
    {
        double x = getM00() * p.getX() + getM01() * p.getY() + getM02();
        double y = getM10() * p.getX() + getM11() * p.getY() + getM12();
        double z = getM20() * p.getX() + getM21() * p.getY() + getM22();
        return new Point2d(x / z, y / z);
    }

    public Point2d Mul(BuffPoint2d p)
    {
        double x = getM00() * p.getX() + getM01() * p.getY() + getM02();
        double y = getM10() * p.getX() + getM11() * p.getY() + getM12();
        double z = getM20() * p.getX() + getM21() * p.getY() + getM22();
        return new Point2d(x / z, y / z);
    }

    public Vector2d Premul(Vector2 v)
    {
        if (v is Vector2d)
        {
            return Premul((Vector2d)v);
        }
        else if (v is BuffVector2d)
        {
            return Premul((BuffVector2d)v);
        }
        else
        {
            return Premul(new Vector2d(v));
        }
    }

    public Vector2d Premul(Vector2d v)
    {
        double x = v.getX() * getM00() + v.getY() * getM10();
        double y = v.getX() * getM01() + v.getY() * getM11();
        return new Vector2d(x, y);
    }

    public Vector2d Premul(BuffVector2d v)
    {
        double x = v.getX() * getM00() + v.getY() * getM10();
        double y = v.getX() * getM01() + v.getY() * getM11();
        return new Vector2d(x, y);
    }

    public Point2d Premul(Point2 p)
    {
        if (p is Point2d)
        {
            return Premul((Point2d)p);
        }
        else if (p is BuffPoint2d)
        {
            return Premul((BuffPoint2d)p);
        }
        else
        {
            return Premul(new Point2d(p));
        }
    }

    public Point2d Premul(Point2d p)
    {
        double x = p.getX() * getM00() + p.getY() * getM10() + getM20();
        double y = p.getX() * getM01() + p.getY() * getM11() + getM21();
        double z = p.getX() * getM02() + p.getY() * getM12() + getM22();
        return new Point2d(x / z, y / z);
    }

    public Point2d Premul(BuffPoint2d p)
    {
        double x = p.getX() * getM00() + p.getY() * getM10() + getM20();
        double y = p.getX() * getM01() + p.getY() * getM11() + getM21();
        double z = p.getX() * getM02() + p.getY() * getM12() + getM22();
        return new Point2d(x / z, y / z);
    }

    public void MulAndSetInto(BuffVector3 v)
    {
        if (v is BuffVector3d)
        {
            this.MulAndSetInto((BuffVector3d)v);
        }
        else
        {
            BuffVector3d _v = new BuffVector3d(v);
            this.MulAndSetInto(_v);
            _v.getInto(v);
        }
    }

    public void MulAndSetInto(BuffVector3d v)
    {
        v.set(getM00() * v.getX() + getM01() * v.getY() + getM02() * v.getZ(),
              getM10() * v.getX() + getM11() * v.getY() + getM12() * v.getZ(),
              getM20() * v.getX() + getM21() * v.getY() + getM22() * v.getZ());
    }

    public void PremulAndSetInto(BuffVector3 v)
    {
        if (v is BuffVector3d)
        {
            this.PremulAndSetInto((BuffVector3d)v);
        }
        else
        {
            BuffVector3d _v = new BuffVector3d(v);
            this.PremulAndSetInto(_v);
            _v.getInto(v);
        }
    }

    public void PremulAndSetInto(BuffVector3d v)
    {
        v.set (v.getX() * getM00() + v.getY() * getM10() + v.getZ() * getM20(),
               v.getX() * getM01() + v.getY() * getM11() + v.getZ() * getM21(),
               v.getX() * getM02() + v.getY() * getM12() + v.getZ() * getM22());
    }

    public void MulAndSetInto(BuffVector2 v)
    {
        if (v is BuffVector2d)
        {
            this.MulAndSetInto((BuffVector2d)v);
        }
        else
        {
            BuffVector2d _v = new BuffVector2d(v);
            this.MulAndSetInto(_v);
            _v.getInto(v);
        }
    }

    public void MulAndSetInto(BuffVector2d v)
    {
        double x = getM00() * v.getX() + getM01() * v.getY();
        double y = getM10() * v.getX() + getM11() * v.getY();
        v.set(x, y);
    }

    public void MulAndSetInto(BuffPoint2 p)
    {
        if (p is BuffVector2d)
        {
            this.MulAndSetInto((BuffPoint2d)p);
        }
        else
        {
            BuffPoint2d _p = new BuffPoint2d(p);
            this.MulAndSetInto(_p);
            _p.getInto(p);
        }
    }

    public void MulAndSetInto(BuffPoint2d p)
    {
        double x = getM00() * p.getX() + getM01() * p.getY() + getM02();
        double y = getM10() * p.getX() + getM11() * p.getY() + getM12();
        double z = getM20() * p.getX() + getM21() * p.getY() + getM22();
        p.set(x / z, y / z);
    }

    public void PremulAndSetInto(BuffVector2 v)
    {
        if (v is BuffVector2d)
        {
            this.PremulAndSetInto((BuffVector2d)v);
        }
        else
        {
            BuffVector2d _v = new BuffVector2d(v);
            this.PremulAndSetInto(_v);
            _v.getInto(v);
        }
    }

    public void PremulAndSetInto(BuffVector2d v)
    {
        double x = v.getX() * getM00() + v.getY() * getM10();
        double y = v.getX() * getM01() + v.getY() * getM11();
        v.set(x, y);
    }

    public void PremulAndSetInto(BuffPoint2 p)
    {
        if (p is BuffVector2d)
        {
            this.PremulAndSetInto((BuffPoint2d)p);
        }
        else
        {
            BuffPoint2d _p = new BuffPoint2d(p);
            this.PremulAndSetInto(_p);
            _p.getInto(p);
        }
    }

    public void PremulAndSetInto(BuffPoint2d p)
    {
        double x = p.getX() * getM00() + p.getY() * getM10() + getM20();
        double y = p.getX() * getM01() + p.getY() * getM11() + getM21();
        double z = p.getX() * getM02() + p.getY() * getM12() + getM22();
        p.set(x / z, y / z);
    }
//</editor-fold>

    @Override
    public final bool IsValid()
    {
        return !IsNaN() && !IsInfinity();
    }

    public final bool IsNaN()
    {
        return Double.IsNaN(getM00()) || Double.IsNaN(getM01()) || Double.IsNaN(getM02()) ||
               Double.IsNaN(getM10()) || Double.IsNaN(getM11()) || Double.IsNaN(getM12()) ||
               Double.IsNaN(getM20()) || Double.IsNaN(getM21()) || Double.IsNaN(getM22());
    }

    public final bool IsInfinity()
    {
        return Double.IsInfinite(getM00()) || Double.IsInfinite(getM01()) || Double.IsInfinite(getM02()) ||
               Double.IsInfinite(getM10()) || Double.IsInfinite(getM11()) || Double.IsInfinite(getM12()) ||
               Double.IsInfinite(getM20()) || Double.IsInfinite(getM21()) || Double.IsInfinite(getM22());
    }

    public final bool IsZero(double epsilon = EPSILON)
    {
        return EpsilonEquals(0, 0, 0,
                             0, 0, 0,
                             0, 0, 0, epsilon);
    }

    public bool isIdentity(double epsilon = EPSILON)
    {
        return EpsilonEquals(1, 0, 0,
                             0, 1, 0,
                             0, 0, 1, epsilon);
    }

    public bool IsInvertible(double epsilon)
    {
        return !DoubleUtils.EpsilonEquals(getDeterminant(), epsilon);
    }

    public double GetDeterminant()
    {
        return (getM00() * (getM11() * getM22() - getM21() * getM12())
                - getM01() * (getM10() * getM22() - getM20() * getM12())
                + getM02() * (getM10() * getM21() - getM20() * getM11()));
    }

    public Matrix3x3d Add(Matrix3x3 other)
    {
        Matrix3x3d _other = ToMatrix3x3d(other);

        return new Matrix3x3d(getM00() + _other.getM00(), getM01() + _other.getM01(), getM02() + _other.getM02(),
                              getM10() + _other.getM10(), getM11() + _other.getM11(), getM12() + _other.getM12(),
                              getM20() + _other.getM20(), getM21() + _other.getM21(), getM22() + _other.getM22());
    }

    public Matrix3x3d Add(Matrix3x3d other)
    {
        return new Matrix3x3d(getM00() + other.getM00(), getM01() + other.getM01(), getM02() + other.getM02(),
                              getM10() + other.getM10(), getM11() + other.getM11(), getM12() + other.getM12(),
                              getM20() + other.getM20(), getM21() + other.getM21(), getM22() + other.getM22());
    }

    public Matrix3x3d Sub(Matrix3x3 other)
    {
        Matrix3x3d _other = ToMatrix3x3d(other);

        return new Matrix3x3d(getM00() - _other.getM00(), getM01() - _other.getM01(), getM02() - _other.getM02(),
                              getM10() - _other.getM10(), getM11() - _other.getM11(), getM12() - _other.getM12(),
                              getM20() - _other.getM20(), getM21() - _other.getM21(), getM22() - _other.getM22());
    }

    public Matrix3x3d Sub(Matrix3x3d other)
    {
        return new Matrix3x3d(getM00() - other.getM00(), getM01() - other.getM01(), getM02() - other.getM02(),
                              getM10() - other.getM10(), getM11() - other.getM11(), getM12() - other.getM12(),
                              getM20() - other.getM20(), getM21() - other.getM21(), getM22() - other.getM22());
    }

    public Matrix3x3d Mul(double v)
    {
        return new Matrix3x3d((double)(getM00() * v), (double)(getM01() * v), (double)(getM02() * v),
                              (double)(getM10() * v), (double)(getM11() * v), (double)(getM12() * v),
                              (double)(getM20() * v), (double)(getM21() * v), (double)(getM22() * v));
    }

    public Matrix3x3d Div(double v)
    {
        return new Matrix3x3d((double)(getM00() / v), (double)(getM01() / v), (double)(getM02() / v),
                              (double)(getM10() / v), (double)(getM11() / v), (double)(getM12() / v),
                              (double)(getM20() / v), (double)(getM21() / v), (double)(getM22() / v));
    }

    public Matrix3x3d Mul(Matrix3x3 other)
    {
        Matrix3x3d _other = toMatrix3x3d(other);

        return new Matrix3x3d(getM00() * _other.getM00() + getM01() * _other.getM10() + getM02() * _other.getM20(),
                              getM00() * _other.getM01() + getM01() * _other.getM11() + getM02() * _other.getM21(),
                              getM00() * _other.getM02() + getM01() * _other.getM12() + getM02() * _other.getM22(),
                              getM10() * _other.getM00() + getM11() * _other.getM10() + getM12() * _other.getM20(),
                              getM10() * _other.getM01() + getM11() * _other.getM11() + getM12() * _other.getM21(),
                              getM10() * _other.getM02() + getM11() * _other.getM12() + getM12() * _other.getM22(),
                              getM20() * _other.getM00() + getM21() * _other.getM10() + getM22() * _other.getM20(),
                              getM20() * _other.getM01() + getM21() * _other.getM11() + getM22() * _other.getM21(),
                              getM20() * _other.getM02() + getM21() * _other.getM12() + getM22() * _other.getM22());
    }

    public Matrix3x3d Mul(Matrix3x3d other)
    {
        return new Matrix3x3d(getM00() * other.getM00() + getM01() * other.getM10() + getM02() * other.getM20(),
                              getM00() * other.getM01() + getM01() * other.getM11() + getM02() * other.getM21(),
                              getM00() * other.getM02() + getM01() * other.getM12() + getM02() * other.getM22(),
                              getM10() * other.getM00() + getM11() * other.getM10() + getM12() * other.getM20(),
                              getM10() * other.getM01() + getM11() * other.getM11() + getM12() * other.getM21(),
                              getM10() * other.getM02() + getM11() * other.getM12() + getM12() * other.getM22(),
                              getM20() * other.getM00() + getM21() * other.getM10() + getM22() * other.getM20(),
                              getM20() * other.getM01() + getM21() * other.getM11() + getM22() * other.getM21(),
                              getM20() * other.getM02() + getM21() * other.getM12() + getM22() * other.getM22());
    }

    public Matrix3x3d Neg()
    {
        return new Matrix3x3d(- getM00(), - getM01(), - getM02(),
                              - getM10(), - getM11(), - getM12(),
                              - getM20(), - getM21(), - getM22());
    }

    public Matrix3x3d Abs()
    {
        return new Matrix3x3d(Math.abs(getM00()), Math.abs(getM01()), Math.abs(getM02()),
                              Math.abs(getM10()), Math.abs(getM11()), Math.abs(getM12()),
                              Math.abs(getM20()), Math.abs(getM21()), Math.abs(getM22()));
    }

    public Matrix3x3d Transpose()
    {
        return new Matrix3x3d(getM00(), getM10(), getM20(),
                              getM01(), getM11(), getM21(),
                              getM02(), getM12(), getM22());
    }

    @Override
    public Matrix3x3d Inverse() throws SingularMatrixException
    {
        double s = getDeterminant();
        if (DoubleUtils.epsilonZero(s, EPSILON))
        {
            throw new SingularMatrixException();
        }

        s = 1 / s;

        return new Matrix3x3d(
            (double)((getM11() * getM22() - getM12() * getM21()) * s),
            (double)((getM02() * getM21() - getM01() * getM22()) * s),
            (double)((getM01() * getM12() - getM02() * getM11()) * s),
            (double)((getM12() * getM20() - getM10() * getM22()) * s),
            (double)((getM00() * getM22() - getM02() * getM20()) * s),
            (double)((getM02() * getM10() - getM00() * getM12()) * s),
            (double)((getM10() * getM21() - getM11() * getM20()) * s),
            (double)((getM01() * getM20() - getM00() * getM21()) * s),
            (double)((getM00() * getM11() - getM01() * getM10()) * s));
    }

    @Override
    public Matrix3x3d SetZero()
    {
        Set(0, 0, 0,
            0, 0, 0,
            0, 0, 0);
        return this;
    }

    @Override
    public Matrix3x3d SetIdentity()
    {
        Set(1, 0, 0,
            0, 1, 0,
            0, 0, 1);
        return this;
    }

    @Override
    public Matrix3x3d AddAndSet(Matrix3x3 other)
    {
        Matrix3x3d _other = toMatrix3x3d(other);

        Set(getM00() + _other.getM00(), getM01() + _other.getM01(), getM02() + _other.getM02(),
            getM10() + _other.getM10(), getM11() + _other.getM11(), getM12() + _other.getM12(),
            getM20() + _other.getM20(), getM21() + _other.getM21(), getM22() + _other.getM22());
        return this;
    }

    public Matrix3x3d AddAndSet(Matrix3x3d other)
    {
        Set(getM00() + other.getM00(), getM01() + other.getM01(), getM02() + other.getM02(),
            getM10() + other.getM10(), getM11() + other.getM11(), getM12() + other.getM12(),
            getM20() + other.getM20(), getM21() + other.getM21(), getM22() + other.getM22());
        return this;
    }

    @Override
    public Matrix3x3d SubAndSet(Matrix3x3 other)
    {
        Matrix3x3d _other = toMatrix3x3d(other);

        Set(getM00() - _other.getM00(), getM01() - _other.getM01(), getM02() - _other.getM02(),
            getM10() - _other.getM10(), getM11() - _other.getM11(), getM12() - _other.getM12(),
            getM20() - _other.getM20(), getM21() - _other.getM21(), getM22() - _other.getM22());
        return this;
    }

    public Matrix3x3d SubAndSet(Matrix3x3d other)
    {
        Set(getM00() - other.getM00(), getM01() - other.getM01(), getM02() - other.getM02(),
            getM10() - other.getM10(), getM11() - other.getM11(), getM12() - other.getM12(),
            getM20() - other.getM20(), getM21() - other.getM21(), getM22() - other.getM22());
        return this;
    }

    @Override
    public Matrix3x3d MulAndSet(double v)
    {
        Set((double)(getM00() * v), (double)(getM01() * v), (double)(getM02() * v),
            (double)(getM10() * v), (double)(getM11() * v), (double)(getM12() * v),
            (double)(getM20() * v), (double)(getM21() * v), (double)(getM22() * v));
        return this;
    }

    @Override
    public Matrix3x3d DivAndSet(double v)
    {
        Set((double)(getM00() / v), (double)(getM01() / v), (double)(getM02() / v),
            (double)(getM10() / v), (double)(getM11() / v), (double)(getM12() / v),
            (double)(getM20() / v), (double)(getM21() / v), (double)(getM22() / v));
        return this;
    }

    @Override
    public Matrix3x3d MulAndSet(Matrix3x3 other)
    {
        Matrix3x3d _other = toMatrix3x3d(other);

        Set(getM00() * _other.getM00() + getM01() * _other.getM10() + getM02() * _other.getM20(),
            getM00() * _other.getM01() + getM01() * _other.getM11() + getM02() * _other.getM21(),
            getM00() * _other.getM02() + getM01() * _other.getM12() + getM02() * _other.getM22(),
            getM10() * _other.getM00() + getM11() * _other.getM10() + getM12() * _other.getM20(),
            getM10() * _other.getM01() + getM11() * _other.getM11() + getM12() * _other.getM21(),
            getM10() * _other.getM02() + getM11() * _other.getM12() + getM12() * _other.getM22(),
            getM20() * _other.getM00() + getM21() * _other.getM10() + getM22() * _other.getM20(),
            getM20() * _other.getM01() + getM21() * _other.getM11() + getM22() * _other.getM21(),
            getM20() * _other.getM02() + getM21() * _other.getM12() + getM22() * _other.getM22());
        return this;
    }

    public Matrix3x3d MulAndSet(Matrix3x3d other)
    {
        Set(getM00() * other.getM00() + getM01() * other.getM10() + getM02() * other.getM20(),
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

    @Override
    public Matrix3x3d NegAndSet()
    {
        Set(- getM00(), - getM01(), - getM02(),
            - getM10(), - getM11(), - getM12(),
            - getM20(), - getM21(), - getM22());
        return this;
    }

    @Override
    public Matrix3x3d AbsAndSet()
    {
        Set(Math.abs(getM00()), Math.abs(getM01()), Math.abs(getM02()),
            Math.abs(getM10()), Math.abs(getM11()), Math.abs(getM12()),
            Math.abs(getM20()), Math.abs(getM21()), Math.abs(getM22()));
        return this;
    }

    @Override
    public Matrix3x3d TransposeAndSet()
    {
        Set(getM00(), getM10(), getM20(),
            getM01(), getM11(), getM21(),
            getM02(), getM12(), getM22());
        return this;
    }

    @Override
    public Matrix3x3d InverseAndSet() throws SingularMatrixException
    {
        double s = getDeterminant();
        if (DoubleUtils.epsilonZero(s, EPSILON))
        {
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

//<editor-fold defaultstate="collapsed" desc="accessors">
    public bool IsSquared()
    {
        return true;
    }

    public double Get(int r, int c)
    {
        switch(r)
        {
        case 0:
            switch(c)
            {
            case 0:
                return m00;
            case 1:
                return m01;
            case 2:
                return m02;
            }
        case 1:
            switch(c)
            {
            case 0:
                return m10;
            case 1:
                return m11;
            case 2:
                return m12;
            }
        case 2:
            switch(c)
            {
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

    public double GetM00()
    {
        return m00;
    }

    public double GetM01()
    {
        return m01;
    }

    public double GetM02()
    {
        return m02;
    }

    public double GetM10()
    {
        return m10;
    }

    public double GetM11()
    {
        return m11;
    }

    public double GetM12()
    {
        return m12;
    }

    public double GetM20()
    {
        return m20;
    }

    public double GetM21()
    {
        return m21;
    }

    public double GetM22()
    {
        return m22;
    }

    public final void Set(int r, int c, double value)
    {
        switch(r)
        {
        case 0:
            switch(c)
            {
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
            switch(c)
            {
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
            switch(c)
            {
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

    public void SetM00(double value)
    {
        m00 = value;
    }

    public void SetM01(double value)
    {
        m01 = value;
    }

    public void SetM02(double value)
    {
        m02 = value;
    }

    public void SetM10(double value)
    {
        m10 = value;
    }

    public void SetM11(double value)
    {
        m11 = value;
    }

    public void SetM12(double value)
    {
        m12 = value;
    }

    public void SetM20(double value)
    {
        m20 = value;
    }

    public void SetM21(double value)
    {
        m21 = value;
    }

    public void SetM22(double value)
    {
        m22 = value;
    }

    public void Set(double m00, double m01, double m02,
                    double m10, double m11, double m12,
                    double m20, double m21, double m22)
    {
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
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="MatrixInpector">
    @Override
    public final int sizeRows()
    {
        return 3;
    }

    @Override
    public final int sizeCols()
    {
        return 3;
    }

    @Override
    public void getInto(MatrixSet matrixSet)
    {
        matrixSet.setDouble( 0, 0, (double)m00 );
        matrixSet.setDouble( 0, 1, (double)m01 );
        matrixSet.setDouble( 0, 2, (double)m02 );
        matrixSet.setDouble( 1, 0, (double)m10 );
        matrixSet.setDouble( 1, 1, (double)m11 );
        matrixSet.setDouble( 1, 2, (double)m12 );
        matrixSet.setDouble( 2, 0, (double)m20 );
        matrixSet.setDouble( 2, 1, (double)m21 );
        matrixSet.setDouble( 2, 2, (double)m22 );
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="MatrixSet">
    @Override
    public void setFloat(int r, int c, float value)
    {
        set(r, c, (double)value);
    }

    @Override
    public void setDouble(int r, int c, double value)
    {
        set(r, c, (double)value);
    }

    @Override
    public <T> void set(Class<T> type, int r, int c, T value)
    {
        if (Number.class.isAssignableFrom(type))
        {
            set(r, c, ((Number)value).doubleValue());
            return;
        }
        throw new UnsupportedOperationException();
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Object">
    @Override
    public String toString()
    {
        VectorFormatInfo vfi = VectorFormatInfo.CURRENT_INFO;
        return String.format(getFormat(), vfi.getBeg(), vfi.getSep(), vfi.getEnd(),
                             getM00(),getM01(),getM02(),
                             getM10(),getM11(),getM12(),
                             getM20(),getM21(),getM22());
    }

    public boolean equals(Matrix3x3d other)
    {
        if (other == this)
        {
            return true;
        }
        if (other == null)
        {
            return false;
        }

        return this.equals(other.getM00(), other.getM01(), other.getM02(),
                           other.getM10(), other.getM11(), other.getM12(),
                           other.getM20(), other.getM21(), other.getM22());
    }

    @Override
    public boolean equals(Object other)
    {
        return ((other instanceof Matrix3x3d) && this.equals((Matrix3x3d) other));
    }

    @Override
    public int hashCode()
    {
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
    public Matrix3x3d clone() throws CloneNotSupportedException
    {
        return (Matrix3x3d)super.clone();
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="EpsilonEquatable<Matrix3x3d>">
    @Override
    public boolean epsilonEquals(Matrix3x3d other, double epsilon)
    {
        if (other == this)
        {
            return true;
        }
        if (other == null)
        {
            return false;
        }
        return epsilonEquals(getM00(), getM01(), getM02(),
                             getM10(), getM11(), getM12(),
                             getM20(), getM21(), getM22(), epsilon);
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="private">
    private Matrix3x3d toMatrix3x3d(Matrix3x3 other)
    {
        if (other instanceof Matrix3x3d)
        {
            return (Matrix3x3d)other;
        }
        return new Matrix3x3d(other);
    }

    private boolean epsilonEquals(double m00, double m01, double m02,
                                  double m10, double m11, double m12,
                                  double m20, double m21, double m22)
    {
        return epsilonEquals(m00, m01, m02,
                             m10, m11, m12,
                             m20, m21, m22, EPSILON);
    }

    private boolean epsilonEquals(double m00, double m01, double m02,
                                  double m10, double m11, double m12,
                                  double m20, double m21, double m22, double epsilon)
    {
        return DoubleUtils.epsilonEquals(getM00(), m00, epsilon) && DoubleUtils.epsilonEquals(getM01(), m01, epsilon) && DoubleUtils.epsilonEquals(getM02(), m02, epsilon)
               && DoubleUtils.epsilonEquals(getM10(), m10, epsilon) && DoubleUtils.epsilonEquals(getM11(), m11, epsilon) && DoubleUtils.epsilonEquals(getM12(), m12, epsilon)
               && DoubleUtils.epsilonEquals(getM20(), m20, epsilon) && DoubleUtils.epsilonEquals(getM21(), m21, epsilon) && DoubleUtils.epsilonEquals(getM22(), m22, epsilon);
    }

    private boolean equals(double m00, double m01, double m02,
                           double m10, double m11, double m12,
                           double m20, double m21, double m22)
    {
        return getM00() == m00 && getM01() == m01 && getM02() == m02
               && getM10() == m10 && getM11() == m11 && getM12() == m12
               && getM20() == m20 && getM21() == m21 && getM22() == m22;
    }

    private static String getFormat()
    {
        if (format == null)
        {
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
}

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

using static essence.geometry.core.FloatUtils.EPSILON;

namespace essence.geometry.core.floats
{
/**
 * Basic implementation of a 3x3 matrix.
 */
public class Matrix3x3f : Cloneable, EpsilonEquatable<Matrix3x3f>, BuffMatrix3x3
{
//<editor-fold defaultstate="collapsed" desc="fields">
    /** M00 component. */
    private float m00;
    /** M01 component. */
    private float m01;
    /** M02 component. */
    private float m02;
    /** M10 component. */
    private float m10;
    /** M11 component. */
    private float m11;
    /** M12 component. */
    private float m12;
    /** M20 component. */
    private float m20;
    /** M21 component. */
    private float m21;
    /** M22 component. */
    private float m22;
    private static final Logger LOG = Logger.getLogger(Matrix3x3f.class.getName());
    private static String format;
//</editor-fold>

    /**
     * Empty constructor.
     */
    public Matrix3x3f()
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
    public Matrix3x3f(float m00, float m01, float m02,
                      float m10, float m11, float m12,
                      float m20, float m21, float m22)
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
    public Matrix3x3f(MatrixInpector other)
    {
        other.getInto(this);
    }

    /*
     * This method gets an identity matrix.
     *
     * return Identity matrix.
     */
    public static Matrix3x3f getIdentity()
    {
        return new Matrix3x3f(1, 0, 0,
                              0, 1, 0,
                              0, 0, 1);
    }

//<editor-fold defaultstate="collapsed" desc="Transforms">
    public Vector3f Mul(Vector3 v)
    {
        if (v is Vector3f)
        {
            return Mul((Vector3f)v);
        }
        else if (v is BuffVector3f)
        {
            return Mul((BuffVector3f)v);
        }
        else
        {
            return Mul(new Vector3f(v));
        }
    }

    public Vector3f Mul(Vector3f v)
    {
        return new Vector3f(getM00() * v.getX() + getM01() * v.getY() + getM02() * v.getZ(),
                            getM10() * v.getX() + getM11() * v.getY() + getM12() * v.getZ(),
                            getM20() * v.getX() + getM21() * v.getY() + getM22() * v.getZ());
    }

    public Vector3f Mul(BuffVector3f v)
    {
        return new Vector3f(getM00() * v.getX() + getM01() * v.getY() + getM02() * v.getZ(),
                            getM10() * v.getX() + getM11() * v.getY() + getM12() * v.getZ(),
                            getM20() * v.getX() + getM21() * v.getY() + getM22() * v.getZ());
    }

    public Vector3f Premul(Vector3 v)
    {
        if (v is Vector3f)
        {
            return Premul((Vector3f)v);
        }
        else if (v is BuffVector3f)
        {
            return Premul((BuffVector3f)v);
        }
        else
        {
            return Premul(new Vector3f(v));
        }
    }

    public Vector3f Premul(Vector3f v)
    {
        return new Vector3f(v.getX() * getM00() + v.getY() * getM10() + v.getZ() * getM20(),
                            v.getX() * getM01() + v.getY() * getM11() + v.getZ() * getM21(),
                            v.getX() * getM02() + v.getY() * getM12() + v.getZ() * getM22());
    }

    public Vector3f Premul(BuffVector3f v)
    {
        return new Vector3f(v.getX() * getM00() + v.getY() * getM10() + v.getZ() * getM20(),
                            v.getX() * getM01() + v.getY() * getM11() + v.getZ() * getM21(),
                            v.getX() * getM02() + v.getY() * getM12() + v.getZ() * getM22());
    }

    public Vector2f Mul(Vector2 v)
    {
        if (v is Vector2f)
        {
            return Mul((Vector2f)v);
        }
        else if (v is BuffVector2f)
        {
            return Mul((BuffVector2f)v);
        }
        else
        {
            return Mul(new Vector2f(v));
        }
    }

    public Vector2f Mul(Vector2f v)
    {
        float x = getM00() * v.getX() + getM01() * v.getY();
        float y = getM10() * v.getX() + getM11() * v.getY();
        return new Vector2f(x, y);
    }

    public Vector2f Mul(BuffVector2f v)
    {
        float x = getM00() * v.getX() + getM01() * v.getY();
        float y = getM10() * v.getX() + getM11() * v.getY();
        return new Vector2f(x, y);
    }

    public Point2f Mul(Point2 p)
    {
        if (p is Point2f)
        {
            return Mul((Point2f)p);
        }
        else if (p is BuffPoint2f)
        {
            return Mul((BuffPoint2f)p);
        }
        else
        {
            return Mul(new Point2f(p));
        }
    }

    public Point2f Mul(Point2f p)
    {
        float x = getM00() * p.getX() + getM01() * p.getY() + getM02();
        float y = getM10() * p.getX() + getM11() * p.getY() + getM12();
        float z = getM20() * p.getX() + getM21() * p.getY() + getM22();
        return new Point2f(x / z, y / z);
    }

    public Point2f Mul(BuffPoint2f p)
    {
        float x = getM00() * p.getX() + getM01() * p.getY() + getM02();
        float y = getM10() * p.getX() + getM11() * p.getY() + getM12();
        float z = getM20() * p.getX() + getM21() * p.getY() + getM22();
        return new Point2f(x / z, y / z);
    }

    public Vector2f Premul(Vector2 v)
    {
        if (v is Vector2f)
        {
            return Premul((Vector2f)v);
        }
        else if (v is BuffVector2f)
        {
            return Premul((BuffVector2f)v);
        }
        else
        {
            return Premul(new Vector2f(v));
        }
    }

    public Vector2f Premul(Vector2f v)
    {
        float x = v.getX() * getM00() + v.getY() * getM10();
        float y = v.getX() * getM01() + v.getY() * getM11();
        return new Vector2f(x, y);
    }

    public Vector2f Premul(BuffVector2f v)
    {
        float x = v.getX() * getM00() + v.getY() * getM10();
        float y = v.getX() * getM01() + v.getY() * getM11();
        return new Vector2f(x, y);
    }

    public Point2f Premul(Point2 p)
    {
        if (p is Point2f)
        {
            return Premul((Point2f)p);
        }
        else if (p is BuffPoint2f)
        {
            return Premul((BuffPoint2f)p);
        }
        else
        {
            return Premul(new Point2f(p));
        }
    }

    public Point2f Premul(Point2f p)
    {
        float x = p.getX() * getM00() + p.getY() * getM10() + getM20();
        float y = p.getX() * getM01() + p.getY() * getM11() + getM21();
        float z = p.getX() * getM02() + p.getY() * getM12() + getM22();
        return new Point2f(x / z, y / z);
    }

    public Point2f Premul(BuffPoint2f p)
    {
        float x = p.getX() * getM00() + p.getY() * getM10() + getM20();
        float y = p.getX() * getM01() + p.getY() * getM11() + getM21();
        float z = p.getX() * getM02() + p.getY() * getM12() + getM22();
        return new Point2f(x / z, y / z);
    }

    public void MulAndSetInto(BuffVector3 v)
    {
        if (v is BuffVector3f)
        {
            this.MulAndSetInto((BuffVector3f)v);
        }
        else
        {
            BuffVector3f _v = new BuffVector3f(v);
            this.MulAndSetInto(_v);
            _v.getInto(v);
        }
    }

    public void MulAndSetInto(BuffVector3f v)
    {
        v.set(getM00() * v.getX() + getM01() * v.getY() + getM02() * v.getZ(),
              getM10() * v.getX() + getM11() * v.getY() + getM12() * v.getZ(),
              getM20() * v.getX() + getM21() * v.getY() + getM22() * v.getZ());
    }

    public void PremulAndSetInto(BuffVector3 v)
    {
        if (v is BuffVector3f)
        {
            this.PremulAndSetInto((BuffVector3f)v);
        }
        else
        {
            BuffVector3f _v = new BuffVector3f(v);
            this.PremulAndSetInto(_v);
            _v.getInto(v);
        }
    }

    public void PremulAndSetInto(BuffVector3f v)
    {
        v.set (v.getX() * getM00() + v.getY() * getM10() + v.getZ() * getM20(),
               v.getX() * getM01() + v.getY() * getM11() + v.getZ() * getM21(),
               v.getX() * getM02() + v.getY() * getM12() + v.getZ() * getM22());
    }

    public void MulAndSetInto(BuffVector2 v)
    {
        if (v is BuffVector2f)
        {
            this.MulAndSetInto((BuffVector2f)v);
        }
        else
        {
            BuffVector2f _v = new BuffVector2f(v);
            this.MulAndSetInto(_v);
            _v.getInto(v);
        }
    }

    public void MulAndSetInto(BuffVector2f v)
    {
        float x = getM00() * v.getX() + getM01() * v.getY();
        float y = getM10() * v.getX() + getM11() * v.getY();
        v.set(x, y);
    }

    public void MulAndSetInto(BuffPoint2 p)
    {
        if (p is BuffVector2f)
        {
            this.MulAndSetInto((BuffPoint2f)p);
        }
        else
        {
            BuffPoint2f _p = new BuffPoint2f(p);
            this.MulAndSetInto(_p);
            _p.getInto(p);
        }
    }

    public void MulAndSetInto(BuffPoint2f p)
    {
        float x = getM00() * p.getX() + getM01() * p.getY() + getM02();
        float y = getM10() * p.getX() + getM11() * p.getY() + getM12();
        float z = getM20() * p.getX() + getM21() * p.getY() + getM22();
        p.set(x / z, y / z);
    }

    public void PremulAndSetInto(BuffVector2 v)
    {
        if (v is BuffVector2f)
        {
            this.PremulAndSetInto((BuffVector2f)v);
        }
        else
        {
            BuffVector2f _v = new BuffVector2f(v);
            this.PremulAndSetInto(_v);
            _v.getInto(v);
        }
    }

    public void PremulAndSetInto(BuffVector2f v)
    {
        float x = v.getX() * getM00() + v.getY() * getM10();
        float y = v.getX() * getM01() + v.getY() * getM11();
        v.set(x, y);
    }

    public void PremulAndSetInto(BuffPoint2 p)
    {
        if (p is BuffVector2f)
        {
            this.PremulAndSetInto((BuffPoint2f)p);
        }
        else
        {
            BuffPoint2f _p = new BuffPoint2f(p);
            this.PremulAndSetInto(_p);
            _p.getInto(p);
        }
    }

    public void PremulAndSetInto(BuffPoint2f p)
    {
        float x = p.getX() * getM00() + p.getY() * getM10() + getM20();
        float y = p.getX() * getM01() + p.getY() * getM11() + getM21();
        float z = p.getX() * getM02() + p.getY() * getM12() + getM22();
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
        return Float.IsNaN(getM00()) || Float.IsNaN(getM01()) || Float.IsNaN(getM02()) ||
               Float.IsNaN(getM10()) || Float.IsNaN(getM11()) || Float.IsNaN(getM12()) ||
               Float.IsNaN(getM20()) || Float.IsNaN(getM21()) || Float.IsNaN(getM22());
    }

    public final bool IsInfinity()
    {
        return Float.IsInfinite(getM00()) || Float.IsInfinite(getM01()) || Float.IsInfinite(getM02()) ||
               Float.IsInfinite(getM10()) || Float.IsInfinite(getM11()) || Float.IsInfinite(getM12()) ||
               Float.IsInfinite(getM20()) || Float.IsInfinite(getM21()) || Float.IsInfinite(getM22());
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

    public Matrix3x3f Add(Matrix3x3 other)
    {
        Matrix3x3f _other = ToMatrix3x3f(other);

        return new Matrix3x3f(getM00() + _other.getM00(), getM01() + _other.getM01(), getM02() + _other.getM02(),
                              getM10() + _other.getM10(), getM11() + _other.getM11(), getM12() + _other.getM12(),
                              getM20() + _other.getM20(), getM21() + _other.getM21(), getM22() + _other.getM22());
    }

    public Matrix3x3f Add(Matrix3x3f other)
    {
        return new Matrix3x3f(getM00() + other.getM00(), getM01() + other.getM01(), getM02() + other.getM02(),
                              getM10() + other.getM10(), getM11() + other.getM11(), getM12() + other.getM12(),
                              getM20() + other.getM20(), getM21() + other.getM21(), getM22() + other.getM22());
    }

    public Matrix3x3f Sub(Matrix3x3 other)
    {
        Matrix3x3f _other = ToMatrix3x3f(other);

        return new Matrix3x3f(getM00() - _other.getM00(), getM01() - _other.getM01(), getM02() - _other.getM02(),
                              getM10() - _other.getM10(), getM11() - _other.getM11(), getM12() - _other.getM12(),
                              getM20() - _other.getM20(), getM21() - _other.getM21(), getM22() - _other.getM22());
    }

    public Matrix3x3f Sub(Matrix3x3f other)
    {
        return new Matrix3x3f(getM00() - other.getM00(), getM01() - other.getM01(), getM02() - other.getM02(),
                              getM10() - other.getM10(), getM11() - other.getM11(), getM12() - other.getM12(),
                              getM20() - other.getM20(), getM21() - other.getM21(), getM22() - other.getM22());
    }

    public Matrix3x3f Mul(double v)
    {
        return new Matrix3x3f((float)(getM00() * v), (float)(getM01() * v), (float)(getM02() * v),
                              (float)(getM10() * v), (float)(getM11() * v), (float)(getM12() * v),
                              (float)(getM20() * v), (float)(getM21() * v), (float)(getM22() * v));
    }

    public Matrix3x3f Div(double v)
    {
        return new Matrix3x3f((float)(getM00() / v), (float)(getM01() / v), (float)(getM02() / v),
                              (float)(getM10() / v), (float)(getM11() / v), (float)(getM12() / v),
                              (float)(getM20() / v), (float)(getM21() / v), (float)(getM22() / v));
    }

    public Matrix3x3f Mul(Matrix3x3 other)
    {
        Matrix3x3f _other = toMatrix3x3f(other);

        return new Matrix3x3f(getM00() * _other.getM00() + getM01() * _other.getM10() + getM02() * _other.getM20(),
                              getM00() * _other.getM01() + getM01() * _other.getM11() + getM02() * _other.getM21(),
                              getM00() * _other.getM02() + getM01() * _other.getM12() + getM02() * _other.getM22(),
                              getM10() * _other.getM00() + getM11() * _other.getM10() + getM12() * _other.getM20(),
                              getM10() * _other.getM01() + getM11() * _other.getM11() + getM12() * _other.getM21(),
                              getM10() * _other.getM02() + getM11() * _other.getM12() + getM12() * _other.getM22(),
                              getM20() * _other.getM00() + getM21() * _other.getM10() + getM22() * _other.getM20(),
                              getM20() * _other.getM01() + getM21() * _other.getM11() + getM22() * _other.getM21(),
                              getM20() * _other.getM02() + getM21() * _other.getM12() + getM22() * _other.getM22());
    }

    public Matrix3x3f Mul(Matrix3x3f other)
    {
        return new Matrix3x3f(getM00() * other.getM00() + getM01() * other.getM10() + getM02() * other.getM20(),
                              getM00() * other.getM01() + getM01() * other.getM11() + getM02() * other.getM21(),
                              getM00() * other.getM02() + getM01() * other.getM12() + getM02() * other.getM22(),
                              getM10() * other.getM00() + getM11() * other.getM10() + getM12() * other.getM20(),
                              getM10() * other.getM01() + getM11() * other.getM11() + getM12() * other.getM21(),
                              getM10() * other.getM02() + getM11() * other.getM12() + getM12() * other.getM22(),
                              getM20() * other.getM00() + getM21() * other.getM10() + getM22() * other.getM20(),
                              getM20() * other.getM01() + getM21() * other.getM11() + getM22() * other.getM21(),
                              getM20() * other.getM02() + getM21() * other.getM12() + getM22() * other.getM22());
    }

    public Matrix3x3f Neg()
    {
        return new Matrix3x3f(- getM00(), - getM01(), - getM02(),
                              - getM10(), - getM11(), - getM12(),
                              - getM20(), - getM21(), - getM22());
    }

    public Matrix3x3f Abs()
    {
        return new Matrix3x3f(Math.abs(getM00()), Math.abs(getM01()), Math.abs(getM02()),
                              Math.abs(getM10()), Math.abs(getM11()), Math.abs(getM12()),
                              Math.abs(getM20()), Math.abs(getM21()), Math.abs(getM22()));
    }

    public Matrix3x3f Transpose()
    {
        return new Matrix3x3f(getM00(), getM10(), getM20(),
                              getM01(), getM11(), getM21(),
                              getM02(), getM12(), getM22());
    }

    @Override
    public Matrix3x3f Inverse() throws SingularMatrixException
    {
        double s = getDeterminant();
        if (DoubleUtils.epsilonZero(s, EPSILON))
        {
            throw new SingularMatrixException();
        }

        s = 1 / s;

        return new Matrix3x3f(
            (float)((getM11() * getM22() - getM12() * getM21()) * s),
            (float)((getM02() * getM21() - getM01() * getM22()) * s),
            (float)((getM01() * getM12() - getM02() * getM11()) * s),
            (float)((getM12() * getM20() - getM10() * getM22()) * s),
            (float)((getM00() * getM22() - getM02() * getM20()) * s),
            (float)((getM02() * getM10() - getM00() * getM12()) * s),
            (float)((getM10() * getM21() - getM11() * getM20()) * s),
            (float)((getM01() * getM20() - getM00() * getM21()) * s),
            (float)((getM00() * getM11() - getM01() * getM10()) * s));
    }

    @Override
    public Matrix3x3f SetZero()
    {
        Set(0, 0, 0,
            0, 0, 0,
            0, 0, 0);
        return this;
    }

    @Override
    public Matrix3x3f SetIdentity()
    {
        Set(1, 0, 0,
            0, 1, 0,
            0, 0, 1);
        return this;
    }

    @Override
    public Matrix3x3f AddAndSet(Matrix3x3 other)
    {
        Matrix3x3f _other = toMatrix3x3f(other);

        Set(getM00() + _other.getM00(), getM01() + _other.getM01(), getM02() + _other.getM02(),
            getM10() + _other.getM10(), getM11() + _other.getM11(), getM12() + _other.getM12(),
            getM20() + _other.getM20(), getM21() + _other.getM21(), getM22() + _other.getM22());
        return this;
    }

    public Matrix3x3f AddAndSet(Matrix3x3f other)
    {
        Set(getM00() + other.getM00(), getM01() + other.getM01(), getM02() + other.getM02(),
            getM10() + other.getM10(), getM11() + other.getM11(), getM12() + other.getM12(),
            getM20() + other.getM20(), getM21() + other.getM21(), getM22() + other.getM22());
        return this;
    }

    @Override
    public Matrix3x3f SubAndSet(Matrix3x3 other)
    {
        Matrix3x3f _other = toMatrix3x3f(other);

        Set(getM00() - _other.getM00(), getM01() - _other.getM01(), getM02() - _other.getM02(),
            getM10() - _other.getM10(), getM11() - _other.getM11(), getM12() - _other.getM12(),
            getM20() - _other.getM20(), getM21() - _other.getM21(), getM22() - _other.getM22());
        return this;
    }

    public Matrix3x3f SubAndSet(Matrix3x3f other)
    {
        Set(getM00() - other.getM00(), getM01() - other.getM01(), getM02() - other.getM02(),
            getM10() - other.getM10(), getM11() - other.getM11(), getM12() - other.getM12(),
            getM20() - other.getM20(), getM21() - other.getM21(), getM22() - other.getM22());
        return this;
    }

    @Override
    public Matrix3x3f MulAndSet(double v)
    {
        Set((float)(getM00() * v), (float)(getM01() * v), (float)(getM02() * v),
            (float)(getM10() * v), (float)(getM11() * v), (float)(getM12() * v),
            (float)(getM20() * v), (float)(getM21() * v), (float)(getM22() * v));
        return this;
    }

    @Override
    public Matrix3x3f DivAndSet(double v)
    {
        Set((float)(getM00() / v), (float)(getM01() / v), (float)(getM02() / v),
            (float)(getM10() / v), (float)(getM11() / v), (float)(getM12() / v),
            (float)(getM20() / v), (float)(getM21() / v), (float)(getM22() / v));
        return this;
    }

    @Override
    public Matrix3x3f MulAndSet(Matrix3x3 other)
    {
        Matrix3x3f _other = toMatrix3x3f(other);

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

    public Matrix3x3f MulAndSet(Matrix3x3f other)
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
    public Matrix3x3f NegAndSet()
    {
        Set(- getM00(), - getM01(), - getM02(),
            - getM10(), - getM11(), - getM12(),
            - getM20(), - getM21(), - getM22());
        return this;
    }

    @Override
    public Matrix3x3f AbsAndSet()
    {
        Set(Math.abs(getM00()), Math.abs(getM01()), Math.abs(getM02()),
            Math.abs(getM10()), Math.abs(getM11()), Math.abs(getM12()),
            Math.abs(getM20()), Math.abs(getM21()), Math.abs(getM22()));
        return this;
    }

    @Override
    public Matrix3x3f TransposeAndSet()
    {
        Set(getM00(), getM10(), getM20(),
            getM01(), getM11(), getM21(),
            getM02(), getM12(), getM22());
        return this;
    }

    @Override
    public Matrix3x3f InverseAndSet() throws SingularMatrixException
    {
        double s = getDeterminant();
        if (DoubleUtils.epsilonZero(s, EPSILON))
        {
            throw new SingularMatrixException();
        }

        s = 1 / s;

        set(
            (float)((getM11() * getM22() - getM12() * getM21()) * s),
            (float)((getM02() * getM21() - getM01() * getM22()) * s),
            (float)((getM01() * getM12() - getM02() * getM11()) * s),
            (float)((getM12() * getM20() - getM10() * getM22()) * s),
            (float)((getM00() * getM22() - getM02() * getM20()) * s),
            (float)((getM02() * getM10() - getM00() * getM12()) * s),
            (float)((getM10() * getM21() - getM11() * getM20()) * s),
            (float)((getM01() * getM20() - getM00() * getM21()) * s),
            (float)((getM00() * getM11() - getM01() * getM10()) * s));
        return this;
    }

//<editor-fold defaultstate="collapsed" desc="accessors">
    public bool IsSquared()
    {
        return true;
    }

    public float Get(int r, int c)
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

    public float GetM00()
    {
        return m00;
    }

    public float GetM01()
    {
        return m01;
    }

    public float GetM02()
    {
        return m02;
    }

    public float GetM10()
    {
        return m10;
    }

    public float GetM11()
    {
        return m11;
    }

    public float GetM12()
    {
        return m12;
    }

    public float GetM20()
    {
        return m20;
    }

    public float GetM21()
    {
        return m21;
    }

    public float GetM22()
    {
        return m22;
    }

    public final void Set(int r, int c, float value)
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

    public void SetM00(float value)
    {
        m00 = value;
    }

    public void SetM01(float value)
    {
        m01 = value;
    }

    public void SetM02(float value)
    {
        m02 = value;
    }

    public void SetM10(float value)
    {
        m10 = value;
    }

    public void SetM11(float value)
    {
        m11 = value;
    }

    public void SetM12(float value)
    {
        m12 = value;
    }

    public void SetM20(float value)
    {
        m20 = value;
    }

    public void SetM21(float value)
    {
        m21 = value;
    }

    public void SetM22(float value)
    {
        m22 = value;
    }

    public void Set(float m00, float m01, float m02,
                    float m10, float m11, float m12,
                    float m20, float m21, float m22)
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
        matrixSet.setFloat( 0, 0, (float)m00 );
        matrixSet.setFloat( 0, 1, (float)m01 );
        matrixSet.setFloat( 0, 2, (float)m02 );
        matrixSet.setFloat( 1, 0, (float)m10 );
        matrixSet.setFloat( 1, 1, (float)m11 );
        matrixSet.setFloat( 1, 2, (float)m12 );
        matrixSet.setFloat( 2, 0, (float)m20 );
        matrixSet.setFloat( 2, 1, (float)m21 );
        matrixSet.setFloat( 2, 2, (float)m22 );
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="MatrixSet">
    @Override
    public void setFloat(int r, int c, float value)
    {
        set(r, c, (float)value);
    }

    @Override
    public void setDouble(int r, int c, double value)
    {
        set(r, c, (float)value);
    }

    @Override
    public <T> void set(Class<T> type, int r, int c, T value)
    {
        if (Number.class.isAssignableFrom(type))
        {
            set(r, c, ((Number)value).floatValue());
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

    public boolean equals(Matrix3x3f other)
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
        return ((other instanceof Matrix3x3f) && this.equals((Matrix3x3f) other));
    }

    @Override
    public int hashCode()
    {
        // https://stackoverflow.com/questions/113511/best-implementation-for-hashcode-method
        // http://www.jarvana.com/jarvana/view/org/apache/lucene/lucene-spatial/2.9.3/lucene-spatial-2.9.3-sources.jar!/org/apache/lucene/spatial/geometry/shape/Vector2D.java
        final int prime = 31;
        int hash = 1;
        hash = prime * hash + Float.hashCode(getM00());
        hash = prime * hash + Float.hashCode(getM01());
        hash = prime * hash + Float.hashCode(getM02());
        hash = prime * hash + Float.hashCode(getM10());
        hash = prime * hash + Float.hashCode(getM11());
        hash = prime * hash + Float.hashCode(getM12());
        hash = prime * hash + Float.hashCode(getM20());
        hash = prime * hash + Float.hashCode(getM21());
        hash = prime * hash + Float.hashCode(getM22());
        return hash;
    }

    @Override
    public Matrix3x3f clone() throws CloneNotSupportedException
    {
        return (Matrix3x3f)super.clone();
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="EpsilonEquatable<Matrix3x3f>">
    @Override
    public boolean epsilonEquals(Matrix3x3f other, double epsilon)
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
    private Matrix3x3f toMatrix3x3f(Matrix3x3 other)
    {
        if (other instanceof Matrix3x3f)
        {
            return (Matrix3x3f)other;
        }
        return new Matrix3x3f(other);
    }

    private boolean epsilonEquals(float m00, float m01, float m02,
                                  float m10, float m11, float m12,
                                  float m20, float m21, float m22)
    {
        return epsilonEquals(m00, m01, m02,
                             m10, m11, m12,
                             m20, m21, m22, EPSILON);
    }

    private boolean epsilonEquals(float m00, float m01, float m02,
                                  float m10, float m11, float m12,
                                  float m20, float m21, float m22, double epsilon)
    {
        return DoubleUtils.epsilonEquals(getM00(), m00, epsilon) && DoubleUtils.epsilonEquals(getM01(), m01, epsilon) && DoubleUtils.epsilonEquals(getM02(), m02, epsilon)
               && DoubleUtils.epsilonEquals(getM10(), m10, epsilon) && DoubleUtils.epsilonEquals(getM11(), m11, epsilon) && DoubleUtils.epsilonEquals(getM12(), m12, epsilon)
               && DoubleUtils.epsilonEquals(getM20(), m20, epsilon) && DoubleUtils.epsilonEquals(getM21(), m21, epsilon) && DoubleUtils.epsilonEquals(getM22(), m22, epsilon);
    }

    private boolean equals(float m00, float m01, float m02,
                           float m10, float m11, float m12,
                           float m20, float m21, float m22)
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

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
using essence.geometry.core.Vector2;
using essence.geometry.core.BuffVector2;
using essence.geometry.core.VectorFormatInfo;
using essence.geometry.core.Matrix2x2;
using essence.geometry.core.BuffMatrix2x2;

using static essence.geometry.core.FloatUtils.EPSILON;

namespace essence.geometry.core.floats
{
/**
 * Basic implementation of a 2x2 matrix.
 */
public class Matrix2x2f : Cloneable, EpsilonEquatable<Matrix2x2f>, BuffMatrix2x2
{
//<editor-fold defaultstate="collapsed" desc="fields">
    /** M00 component. */
    private float m00;
    /** M01 component. */
    private float m01;
    /** M10 component. */
    private float m10;
    /** M11 component. */
    private float m11;
    private static final Logger LOG = Logger.getLogger(Matrix2x2f.class.getName());
    private static String format;
//</editor-fold>

    /**
     * Empty constructor.
     */
    public Matrix2x2f()
    {
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
    public Matrix2x2f(float m00, float m01,
                      float m10, float m11)
    {
        this.m00 = m00;
        this.m01 = m01;
        this.m10 = m10;
        this.m11 = m11;
    }

    /**
     * Copy constructor.
     */
    public Matrix2x2f(MatrixInpector other)
    {
        other.getInto(this);
    }

    /*
     * This method gets an identity matrix.
     *
     * return Identity matrix.
     */
    public static Matrix2x2f getIdentity()
    {
        return new Matrix2x2f(1, 0,
                              0, 1);
    }

//<editor-fold defaultstate="collapsed" desc="Transforms">
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
        return new Vector2f(getM00() * v.getX() + getM01() * v.getY(),
                            getM10() * v.getX() + getM11() * v.getY());
    }

    public Vector2f Mul(BuffVector2f v)
    {
        return new Vector2f(getM00() * v.getX() + getM01() * v.getY(),
                            getM10() * v.getX() + getM11() * v.getY());
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
        return new Vector2f(v.getX() * getM00() + v.getY() * getM10(),
                            v.getX() * getM01() + v.getY() * getM11());
    }

    public Vector2f Premul(BuffVector2f v)
    {
        return new Vector2f(v.getX() * getM00() + v.getY() * getM10(),
                            v.getX() * getM01() + v.getY() * getM11());
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
        v.set(getM00() * v.getX() + getM01() * v.getY(),
              getM10() * v.getX() + getM11() * v.getY());
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
        v.set (v.getX() * getM00() + v.getY() * getM10(),
               v.getX() * getM01() + v.getY() * getM11());
    }
//</editor-fold>

    @Override
    public final bool IsValid()
    {
        return !IsNaN() && !IsInfinity();
    }

    public final bool IsNaN()
    {
        return Float.IsNaN(getM00()) || Float.IsNaN(getM01()) ||
               Float.IsNaN(getM10()) || Float.IsNaN(getM11());
    }

    public final bool IsInfinity()
    {
        return Float.IsInfinite(getM00()) || Float.IsInfinite(getM01()) ||
               Float.IsInfinite(getM10()) || Float.IsInfinite(getM11());
    }

    public final bool IsZero(double epsilon = EPSILON)
    {
        return EpsilonEquals(0, 0,
                             0, 0, epsilon);
    }

    public bool isIdentity(double epsilon = EPSILON)
    {
        return EpsilonEquals(1, 0,
                             0, 1, epsilon);
    }

    public bool IsInvertible(double epsilon)
    {
        return !DoubleUtils.EpsilonEquals(getDeterminant(), epsilon);
    }

    public double GetDeterminant()
    {
        return (getM00() * getM11()
                - getM01() * getM10());
    }

    public Matrix2x2f Add(Matrix2x2 other)
    {
        Matrix2x2f _other = ToMatrix2x2f(other);

        return new Matrix2x2f(getM00() + _other.getM00(), getM01() + _other.getM01(),
                              getM10() + _other.getM10(), getM11() + _other.getM11());
    }

    public Matrix2x2f Add(Matrix2x2f other)
    {
        return new Matrix2x2f(getM00() + other.getM00(), getM01() + other.getM01(),
                              getM10() + other.getM10(), getM11() + other.getM11());
    }

    public Matrix2x2f Sub(Matrix2x2 other)
    {
        Matrix2x2f _other = ToMatrix2x2f(other);

        return new Matrix2x2f(getM00() - _other.getM00(), getM01() - _other.getM01(),
                              getM10() - _other.getM10(), getM11() - _other.getM11());
    }

    public Matrix2x2f Sub(Matrix2x2f other)
    {
        return new Matrix2x2f(getM00() - other.getM00(), getM01() - other.getM01(),
                              getM10() - other.getM10(), getM11() - other.getM11());
    }

    public Matrix2x2f Mul(double v)
    {
        return new Matrix2x2f((float)(getM00() * v), (float)(getM01() * v),
                              (float)(getM10() * v), (float)(getM11() * v));
    }

    public Matrix2x2f Div(double v)
    {
        return new Matrix2x2f((float)(getM00() / v), (float)(getM01() / v),
                              (float)(getM10() / v), (float)(getM11() / v));
    }

    public Matrix2x2f Mul(Matrix2x2 other)
    {
        Matrix2x2f _other = toMatrix2x2f(other);

        return new Matrix2x2f(getM00() * _other.getM00() + getM01() * _other.getM10(),
                              getM00() * _other.getM01() + getM01() * _other.getM11(),
                              getM10() * _other.getM00() + getM11() * _other.getM10(),
                              getM10() * _other.getM01() + getM11() * _other.getM11());
    }

    public Matrix2x2f Mul(Matrix2x2f other)
    {
        return new Matrix2x2f(getM00() * other.getM00() + getM01() * other.getM10(),
                              getM00() * other.getM01() + getM01() * other.getM11(),
                              getM10() * other.getM00() + getM11() * other.getM10(),
                              getM10() * other.getM01() + getM11() * other.getM11());
    }

    public Matrix2x2f Neg()
    {
        return new Matrix2x2f(- getM00(), - getM01(),
                              - getM10(), - getM11());
    }

    public Matrix2x2f Abs()
    {
        return new Matrix2x2f(Math.abs(getM00()), Math.abs(getM01()),
                              Math.abs(getM10()), Math.abs(getM11()));
    }

    public Matrix2x2f Transpose()
    {
        return new Matrix2x2f(getM00(), getM10(),
                              getM01(), getM11());
    }

    @Override
    public Matrix2x2f Inverse() throws SingularMatrixException
    {
        double s = getDeterminant();
        if (DoubleUtils.epsilonZero(s, EPSILON))
        {
            throw new SingularMatrixException();
        }

        s = 1 / s;

        return new Matrix2x2f(
            (float)(getM11() * s), (float)(-getM01() * s),
            (float)(-getM10() * s), (float)(getM00() * s));
    }

    @Override
    public Matrix2x2f SetZero()
    {
        Set(0, 0,
            0, 0);
        return this;
    }

    @Override
    public Matrix2x2f SetIdentity()
    {
        Set(1, 0,
            0, 1);
        return this;
    }

    @Override
    public Matrix2x2f AddAndSet(Matrix2x2 other)
    {
        Matrix2x2f _other = toMatrix2x2f(other);

        Set(getM00() + _other.getM00(), getM01() + _other.getM01(),
            getM10() + _other.getM10(), getM11() + _other.getM11());
        return this;
    }

    public Matrix2x2f AddAndSet(Matrix2x2f other)
    {
        Set(getM00() + other.getM00(), getM01() + other.getM01(),
            getM10() + other.getM10(), getM11() + other.getM11());
        return this;
    }

    @Override
    public Matrix2x2f SubAndSet(Matrix2x2 other)
    {
        Matrix2x2f _other = toMatrix2x2f(other);

        Set(getM00() - _other.getM00(), getM01() - _other.getM01(),
            getM10() - _other.getM10(), getM11() - _other.getM11());
        return this;
    }

    public Matrix2x2f SubAndSet(Matrix2x2f other)
    {
        Set(getM00() - other.getM00(), getM01() - other.getM01(),
            getM10() - other.getM10(), getM11() - other.getM11());
        return this;
    }

    @Override
    public Matrix2x2f MulAndSet(double v)
    {
        Set((float)(getM00() * v), (float)(getM01() * v),
            (float)(getM10() * v), (float)(getM11() * v));
        return this;
    }

    @Override
    public Matrix2x2f DivAndSet(double v)
    {
        Set((float)(getM00() / v), (float)(getM01() / v),
            (float)(getM10() / v), (float)(getM11() / v));
        return this;
    }

    @Override
    public Matrix2x2f MulAndSet(Matrix2x2 other)
    {
        Matrix2x2f _other = toMatrix2x2f(other);

        Set(getM00() * _other.getM00() + getM01() * _other.getM10(),
            getM00() * _other.getM01() + getM01() * _other.getM11(),
            getM10() * _other.getM00() + getM11() * _other.getM10(),
            getM10() * _other.getM01() + getM11() * _other.getM11());
        return this;
    }

    public Matrix2x2f MulAndSet(Matrix2x2f other)
    {
        Set(getM00() * other.getM00() + getM01() * other.getM10(),
            getM00() * other.getM01() + getM01() * other.getM11(),
            getM10() * other.getM00() + getM11() * other.getM10(),
            getM10() * other.getM01() + getM11() * other.getM11());
        return this;
    }

    @Override
    public Matrix2x2f NegAndSet()
    {
        Set(- getM00(), - getM01(),
            - getM10(), - getM11());
        return this;
    }

    @Override
    public Matrix2x2f AbsAndSet()
    {
        Set(Math.abs(getM00()), Math.abs(getM01()),
            Math.abs(getM10()), Math.abs(getM11()));
        return this;
    }

    @Override
    public Matrix2x2f TransposeAndSet()
    {
        Set(getM00(), getM10(),
            getM01(), getM11());
        return this;
    }

    @Override
    public Matrix2x2f InverseAndSet() throws SingularMatrixException
    {
        double s = getDeterminant();
        if (DoubleUtils.epsilonZero(s, EPSILON))
        {
            throw new SingularMatrixException();
        }

        s = 1 / s;

        set(
            (float)(getM11() * s), (float)(-getM01() * s),
            (float)(-getM10() * s), (float)(getM00() * s));
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
            }
        case 1:
            switch(c)
            {
            case 0:
                return m10;
            case 1:
                return m11;
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

    public float GetM10()
    {
        return m10;
    }

    public float GetM11()
    {
        return m11;
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

    public void SetM10(float value)
    {
        m10 = value;
    }

    public void SetM11(float value)
    {
        m11 = value;
    }

    public void Set(float m00, float m01,
                    float m10, float m11)
    {
        this.m00 = m00;
        this.m01 = m01;
        this.m10 = m10;
        this.m11 = m11;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="MatrixInpector">
    @Override
    public final int sizeRows()
    {
        return 2;
    }

    @Override
    public final int sizeCols()
    {
        return 2;
    }

    @Override
    public void getInto(MatrixSet matrixSet)
    {
        matrixSet.setFloat( 0, 0, (float)m00 );
        matrixSet.setFloat( 0, 1, (float)m01 );
        matrixSet.setFloat( 1, 0, (float)m10 );
        matrixSet.setFloat( 1, 1, (float)m11 );
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
                             getM00(),getM01(),
                             getM10(),getM11());
    }

    public boolean equals(Matrix2x2f other)
    {
        if (other == this)
        {
            return true;
        }
        if (other == null)
        {
            return false;
        }

        return this.equals(other.getM00(), other.getM01(),
                           other.getM10(), other.getM11());
    }

    @Override
    public boolean equals(Object other)
    {
        return ((other instanceof Matrix2x2f) && this.equals((Matrix2x2f) other));
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
        hash = prime * hash + Float.hashCode(getM10());
        hash = prime * hash + Float.hashCode(getM11());
        return hash;
    }

    @Override
    public Matrix2x2f clone() throws CloneNotSupportedException
    {
        return (Matrix2x2f)super.clone();
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="EpsilonEquatable<Matrix2x2f>">
    @Override
    public boolean epsilonEquals(Matrix2x2f other, double epsilon)
    {
        if (other == this)
        {
            return true;
        }
        if (other == null)
        {
            return false;
        }
        return epsilonEquals(getM00(), getM01(),
                             getM10(), getM11(), epsilon);
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="private">
    private Matrix2x2f toMatrix2x2f(Matrix2x2 other)
    {
        if (other instanceof Matrix2x2f)
        {
            return (Matrix2x2f)other;
        }
        return new Matrix2x2f(other);
    }

    private boolean epsilonEquals(float m00, float m01,
                                  float m10, float m11)
    {
        return epsilonEquals(m00, m01,
                             m10, m11, EPSILON);
    }

    private boolean epsilonEquals(float m00, float m01,
                                  float m10, float m11, double epsilon)
    {
        return DoubleUtils.epsilonEquals(getM00(), m00, epsilon) && DoubleUtils.epsilonEquals(getM01(), m01, epsilon)
               && DoubleUtils.epsilonEquals(getM10(), m10, epsilon) && DoubleUtils.epsilonEquals(getM11(), m11, epsilon);
    }

    private boolean equals(float m00, float m01,
                           float m10, float m11)
    {
        return getM00() == m00 && getM01() == m01
               && getM10() == m10 && getM11() == m11;
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
            buff.append(e);
            format = buff.toString();
        }
        return format;
    }
//</editor-fold>
}
}

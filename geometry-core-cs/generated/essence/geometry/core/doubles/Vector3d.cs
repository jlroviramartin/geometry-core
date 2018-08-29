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

using System;
using essence.geometry.core;
using essence.util.math;

namespace essence.geometry.core.doubles
{
/**
 * Basic implementation of a 3 dimension vector.
 */
public struct Vector3d : Vector3
{

    #region fields
    public const double EPSILON = essence.util.math.DoubleUtils.EPSILON;
    /** X component. */
    private readonly double x;
    /** Y component. */
    private readonly double y;
    /** Z component. */
    private readonly double z;
    private static String format;
    #endregion

    /**
     * Empty constructor.
     */
    public Vector3d()
    {
        this((double)0, (double)0, (double)0);
    }

    /**
     * This constructor sets the components of this tuple.
     *
     * @param x Value of the component X.
     * @param y Value of the component Y.
     * @param z Value of the component Z.
     */
    public Vector3d(double x, double y, double z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Copy constructor.
     *
     * @param tuple Tuple.
     */
    public Vector3d(Tuple tuple)
    {
        if (tuple is Tuple3d)
        {
            Tuple3d _tuple = (Tuple3d)tuple;
            this.x = _tuple.GetX();
            this.y = _tuple.GetY();
            this.z = _tuple.GetZ();
        }
        else if (tuple is BuffTuple3d)
        {
            BuffTuple3d _tuple = (BuffTuple3d)tuple;
            this.x = _tuple.GetX();
            this.y = _tuple.GetY();
            this.z = _tuple.GetZ();
        }
        else
        {
            Tuple3d _tuple = new Tuple3d(tuple);
            this.x = _tuple.GetX();
            this.y = _tuple.GetY();
            this.z = _tuple.GetZ();
        }
    }

    /**
     * Copy constructor.
     *
     * @param tuple Tuple.
     */
    public Vector3d(Tuple3d tuple)
    {
        this.x = tuple.GetX();
        this.y = tuple.GetY();
        this.z = tuple.GetZ();
    }

    /**
     * Copy constructor.
     *
     * @param tuple Tuple.
     */
    public Vector3d(BuffTuple3d tuple)
    {
        this.x = tuple.GetX();
        this.y = tuple.GetY();
        this.z = tuple.GetZ();
    }

    /**
     * Zero vector.
     *
     * @return Vector zero.
     */
    public static Vector3d getZero()
    {
        return new Vector3d((double)0, (double)0, (double)0);
    }

    /**
     * One vector.
     *
     * @return Vector one.
     */
    public static Vector3d getOne()
    {
        return new Vector3d((double)1, (double)1, (double)1);
    }

    /**
     * Unit vector: X.
     *
     * @return Vector unit.
     */
    public static Vector3d getUX()
    {
        return getUnit(0);
    }

    /**
     * Unit vector: Y.
     *
     * @return Vector unit.
     */
    public static Vector3d getUY()
    {
        return getUnit(1);
    }

    /**
     * Unit vector: Z.
     *
     * @return Vector unit.
     */
    public static Vector3d getUZ()
    {
        return getUnit(2);
    }

    #region accessors
    public double GetAt(int index)
    {
        switch(index)
        {
        case 0:
            return x;
        case 1:
            return y;
        case 2:
            return z;
        }
        throw new IndexOutOfRangeException();
    }

    public double GetX()
    {
        return x;
    }

    public double GetY()
    {
        return y;
    }

    public double GetZ()
    {
        return z;
    }
    #endregion

    #region Vector3
    public bool IsUnit(double epsilon = EPSILON)
    {
        return DoubleUtils.epsilonEquals(getLength(), 1, epsilon);
    }

    public Vector3d GetUnit()
    {
        double len = getLength();
        if (DoubleUtils.epsilonZero(len))
        {
            throw new ArithmeticException("Divided by 0");
        }
        return div(len);
    }

    public int GetQuadrant()
    {
        int v = 0;
        int p = 1;
        if (getX() < 0)
        {
            v |= p;
            p <<= 1;
        }
        if (getY() < 0)
        {
            v |= p;
            p <<= 1;
        }
        if (getZ() < 0)
        {
            v |= p;
            p <<= 1;
        }
        return v;
    }

    public double GetLength()
    {
        return Math.sqrt(getLengthCuad());
    }

    public double GetLengthCuad()
    {
        return dot(this);
    }

    public double GetLengthL1()
    {
        return Math.abs(getX())
               + Math.abs(getY())
               + Math.abs(getZ());
    }

    public Vector3d add(Vector3 other)
    {
        if (other instanceof Vector3d)
        {
            return add((Vector3d)other);
        }
        else if (other instanceof BuffVector3d)
        {
            return add((BuffVector3d)other);
        }
        else
        {
            return add(new Vector3d(other));
        }
    }

    public Vector3d add(Vector3d other)
    {
        return new Vector3d((double)(getX() + other.getX()), (double)(getY() + other.getY()), (double)(getZ() + other.getZ()));
    }

    public Vector3d add(BuffVector3d other)
    {
        return new Vector3d((double)(getX() + other.getX()), (double)(getY() + other.getY()), (double)(getZ() + other.getZ()));
    }

    public Vector3d sub(Vector3 other)
    {
        if (other instanceof Vector3d)
        {
            return sub((Vector3d)other);
        }
        else if (other instanceof BuffVector3d)
        {
            return sub((BuffVector3d)other);
        }
        else
        {
            return sub(new Vector3d(other));
        }
    }

    public Vector3d sub(Vector3d other)
    {
        return new Vector3d((double)(getX() - other.getX()), (double)(getY() - other.getY()), (double)(getZ() - other.getZ()));
    }

    public Vector3d sub(BuffVector3d other)
    {
        return new Vector3d((double)(getX() - other.getX()), (double)(getY() - other.getY()), (double)(getZ() - other.getZ()));
    }

    public Vector3d simpleMul(Vector3 other)
    {
        if (other instanceof Vector3d)
        {
            return simpleMul((Vector3d)other);
        }
        else if (other instanceof BuffVector3d)
        {
            return simpleMul((BuffVector3d)other);
        }
        else
        {
            return simpleMul(new Vector3d(other));
        }
    }

    public Vector3d simpleMul(Vector3d other)
    {
        return new Vector3d((double)(getX() * other.getX()), (double)(getY() * other.getY()), (double)(getZ() * other.getZ()));
    }

    public Vector3d simpleMul(BuffVector3d other)
    {
        return new Vector3d((double)(getX() * other.getX()), (double)(getY() * other.getY()), (double)(getZ() * other.getZ()));
    }

    public Vector3d simpleDiv(Vector3 other)
    {
        if (other instanceof Vector3d)
        {
            return simpleDiv((Vector3d)other);
        }
        else if (other instanceof BuffVector3d)
        {
            return simpleDiv((BuffVector3d)other);
        }
        else
        {
            return simpleDiv(new Vector3d(other));
        }
    }

    public Vector3d simpleDiv(Vector3d other)
    {
        return new Vector3d((double)(getX() / other.getX()), (double)(getY() / other.getY()), (double)(getZ() / other.getZ()));
    }

    public Vector3d simpleDiv(BuffVector3d other)
    {
        return new Vector3d((double)(getX() / other.getX()), (double)(getY() / other.getY()), (double)(getZ() / other.getZ()));
    }

    public Vector3d mul(double v)
    {
        return new Vector3d((double)(getX() * v), (double)(getY() * v), (double)(getZ() * v));
    }

    public Vector3d div(double v)
    {
        if (DoubleUtils.epsilonZero(v))
        {
            throw new ArithmeticError("divided by zero");
        }
        return new Vector3d((double)(getX() / v), (double)(getY() / v), (double)(getZ() / v));
    }

    public Vector3d neg()
    {
        return new Vector3d((double)(- getX()), (double)(- getY()), (double)(- getZ()));
    }

    public Vector3d abs()
    {
        return new Vector3d((double)Math.abs(getX()), (double)Math.abs(getY()), (double)Math.abs(getZ()));
    }

    public Vector3d lerp(Vector3 other, double alpha)
    {
        if (other instanceof Vector3d)
        {
            return lerp((Vector3d)other, alpha);
        }
        else if (other instanceof BuffVector3d)
        {
            return lerp((BuffVector3d)other, alpha);
        }
        else
        {
            return lerp(new Vector3d(other), alpha);
        }
    }

    public Vector3d lerp(Vector3d other, double alpha)
    {
        return lineal(other, 1 - alpha, alpha);
    }

    public Vector3d lerp(BuffVector3d other, double alpha)
    {
        return lineal(other, 1 - alpha, alpha);
    }

    public double invLerp(Vector3 other, Vector3 lerp)
    {
        if (other instanceof Vector3d && lerp instanceof Vector3d)
        {
            return invLerp((Vector3d)other, (Vector3d)lerp);
        }
        else if (other instanceof BuffVector3d && lerp instanceof BuffVector3d)
        {
            return invLerp((BuffVector3d)other, (BuffVector3d)lerp);
        }
        else
        {
            return invLerp(new Vector3d(other), new Vector3d(other));
        }
    }

    public double invLerp(Vector3d other, Vector3d lerp)
    {
        double x1 = other.getX() - getX();
        double y1 = other.getY() - getY();
        double z1 = other.getZ() - getZ();
        double x2 = lerp.getX() - getX();
        double y2 = lerp.getY() - getY();
        double z2 = lerp.getZ() - getZ();
        return (x1 * x2 + y1 * y2 + z1 * z2) / Math.sqrt(x1 * x1 + y1 * y1 + z1 * z1);
    }

    public double invLerp(BuffVector3d other, BuffVector3d lerp)
    {
        double x1 = other.getX() - getX();
        double y1 = other.getY() - getY();
        double z1 = other.getZ() - getZ();
        double x2 = lerp.getX() - getX();
        double y2 = lerp.getY() - getY();
        double z2 = lerp.getZ() - getZ();
        return (x1 * x2 + y1 * y2 + z1 * z2) / Math.sqrt(x1 * x1 + y1 * y1 + z1 * z1);
    }

    public Vector3d lineal(Vector3 other, double alpha, double beta)
    {
        if (other instanceof Vector3d)
        {
            return lineal((Vector3d)other, alpha, beta);
        }
        else if (other instanceof BuffVector3d)
        {
            return lineal((BuffVector3d)other, alpha, beta);
        }
        else
        {
            return lineal(new Vector3d(other), alpha, beta);
        }
    }

    public Vector3d lineal(Vector3d other, double alpha, double beta)
    {
        return new Vector3d((double)(alpha * getX() + beta * other.getX()),
                            (double)(alpha * getY() + beta * other.getY()),
                            (double)(alpha * getZ() + beta * other.getZ()));
    }

    public Vector3d lineal(BuffVector3d other, double alpha, double beta)
    {
        return new Vector3d((double)(alpha * getX() + beta * other.getX()),
                            (double)(alpha * getY() + beta * other.getY()),
                            (double)(alpha * getZ() + beta * other.getZ()));
    }

    public double Dot(Vector3 other)
    {
        if (other is Vector3d)
        {
            return Dot((Vector3d)other);
        }
        else if (other is BuffVector3d)
        {
            return Dot((BuffVector3d)other);
        }
        else
        {
            return Dot(new Vector3d(other));
        }
    }
    public double Dot(Vector3d other)
    {
        return getX() * other.getX() + getY() * other.getY() + getZ() * other.getZ();
    }

    public double Dot(BuffVector3d other)
    {
        return getX() * other.getX() + getY() * other.getY() + getZ() * other.getZ();
    }

    public Vector3d cross(Vector3 other)
    {
        if (other is Vector3d)
        {
            return cross((Vector3d)other);
        }
        else if (other is BuffVector3d)
        {
            return cross((BuffVector3d)other);
        }
        else
        {
            return cross(new Vector3d(other));
        }
    }

    public Vector3d cross(Vector3d other)
    {
        return new Vector3d((getY() * other.getZ()) - (getZ() * other.getY()),
                            (getZ() * other.getX()) - (getX() * other.getZ()),
                            (getX() * other.getY()) - (getY() * other.getX()));
    }

    public Vector3d cross(BuffVector3d other)
    {
        return new Vector3d((getY() * other.getZ()) - (getZ() * other.getY()),
                            (getZ() * other.getX()) - (getX() * other.getZ()),
                            (getX() * other.getY()) - (getY() * other.getX()));
    }

    public double tripleProduct(Vector3 v2, Vector3 v3)
    {
        if (v2 is Vector3d && v3 is Vector3d)
        {
            return tripleProduct((Vector3d)v2, (Vector3d)v3);
        }
        else if (v2 is BuffVector3d && v3 is BuffVector3d)
        {
            return tripleProduct((BuffVector3d)v2, (BuffVector3d)v3);
        }
        else
        {
            return tripleProduct(new Vector3d(v2), new Vector3d(v3));
        }
    }

    public double tripleProduct(Vector3d v2, Vector3d v3)
    {
        return dot(v2.cross(v3));
    }

    public double tripleProduct(BuffVector3d v2, BuffVector3d v3)
    {
        return dot(v2.cross(v3));
    }

    public double scalarProjection(Vector3 where)
    {
        if (where is Vector3d)
        {
            return scalarProjection((Vector3d)where);
        }
        else if (where is BuffVector3d)
        {
            return scalarProjection((BuffVector3d)where);
        }
        else
        {
            return scalarProjection(new Vector3d(where));
        }
    }

    public double scalarProjection(Vector3d where)
    {
        return dot(where) / where.getLength();
    }

    public double scalarProjection(BuffVector3d where)
    {
        return dot(where) / where.getLength();
    }

    public Vector3 vectorProjection(Vector3 where)
    {
        if (where is Vector3d)
        {
            return vectorProjection((Vector3d)where);
        }
        else if (where is BuffVector3d)
        {
            return vectorProjection((BuffVector3d)where);
        }
        else
        {
            return vectorProjection(new Vector3d(where));
        }
    }

    public Vector3d vectorProjection(Vector3d where)
    {
        double r = dot(where) / where.getLengthCuad();
        return where.mul(r);
    }

    public BuffVector3d vectorProjection(BuffVector3d where)
    {
        double r = dot(where) / where.getLengthCuad();
        return where.mul(r);
    }
    #endregion

    #region Object
    public override String ToString()
    {
        VectorFormatInfo vfi = VectorFormatInfo.CURRENT_INFO;
        return String.Format(GetFormat(), vfi.getBeg(), vfi.getSep(), vfi.getEnd(),
                             x, y, z);
    }

    public override bool Equals(Object other)
    {
        if (other is Tuple3d)
        {
            return Equals((Tuple3d)other);
        }
        else if (other is BuffTuple3d)
        {
            return Equals((BuffTuple3d)other);
        }
        else if (other is Tuple)
        {
            return Equals(new Tuple3d((Tuple)other));
        }
        return false;
    }
    public bool Equals(Tuple3d other)
    {
        if (other == this)
        {
            return true;
        }
        return Equals(other.GetX(),
                      other.GetY(),
                      other.GetZ());
    }

    public bool Equals(BuffTuple3d other)
    {
        return Equals(other.GetX(),
                      other.GetY(),
                      other.GetZ());
    }

    public override int GetHashCode()
    {
        // https://stackoverflow.com/questions/113511/best-implementation-for-hashcode-method
        // http://www.jarvana.com/jarvana/view/org/apache/lucene/lucene-spatial/2.9.3/lucene-spatial-2.9.3-sources.jar!/org/apache/lucene/spatial/geometry/shape/Vector2D.java
        const int prime = 31;
        int hash = 1;
        hash = prime * hash + GetX().GetHashCode();
        hash = prime * hash + GetY().GetHashCode();
        hash = prime * hash + GetZ().GetHashCode();
        return hash;
    }

    public Vector3d Clone()
    {
        Vector3d copy = (Vector3d)base.Clone();
        return copy;
    }
    #endregion

    #region Tuple
    public int Size
    {
        get
        {
            return 3;
        }
    }

    public void GetInto(TupleSet tupleSet)
    {
        tupleSet.SetDouble(0, x);
        tupleSet.SetDouble(1, y);
        tupleSet.SetDouble(2, z);
    }
    #endregion

    #region EpsilonEquatable<Tuple>
    public bool EpsilonEquals(Tuple other, double epsilon = EPSILON)
    {
        if (other is Tuple3d)
        {
            return EpsilonEquals((Tuple3d)other, epsilon);
        }
        else if (other is BuffTuple3d)
        {
            return EpsilonEquals((BuffTuple3d)other, epsilon);
        }
        else if (other is Tuple)
        {
            return EpsilonEquals(new Tuple3d(other), epsilon);
        }
        return false;
    }

    public bool EpsilonEquals(Tuple3d other, double epsilon = EPSILON)
    {
        if (other == this)
        {
            return true;
        }
        return EpsilonEquals(other.GetX(),
                             other.GetY(),
                             other.GetZ(), epsilon);
    }

    public bool EpsilonEquals(BuffTuple3d other, double epsilon = EPSILON)
    {
        return EpsilonEquals(other.GetX(),
                             other.GetY(),
                             other.GetZ(), epsilon);
    }
    #endregion

    #region private
    private static Vector3d getUnit(int index)
    {
        return new Vector3d((double)((index == 0) ? 1 : 0),
                            (double)((index == 1) ? 1 : 0),
                            (double)((index == 2) ? 1 : 0));
    }
    #endregion
}
}
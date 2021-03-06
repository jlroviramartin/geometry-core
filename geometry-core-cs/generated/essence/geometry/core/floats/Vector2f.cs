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

namespace essence.geometry.core.floats
{
/**
 * Basic implementation of a 2 dimension vector.
 */
public struct Vector2f : Vector2
{

    #region fields
    public const float EPSILON = essence.util.math.FloatUtils.EPSILON;
    /** X component. */
    private readonly float x;
    /** Y component. */
    private readonly float y;
    private static String format;
    #endregion

    /**
     * Empty constructor.
     */
    public Vector2f()
    {
        this((float)0, (float)0);
    }

    /**
     * This constructor sets the components of this tuple.
     *
     * @param x Value of the component X.
     * @param y Value of the component Y.
     */
    public Vector2f(float x, float y)
    {
        this.x = x;
        this.y = y;
    }

    /**
     * Copy constructor.
     *
     * @param tuple Tuple.
     */
    public Vector2f(Tuple tuple)
    {
        if (tuple is Tuple2f)
        {
            Tuple2f _tuple = (Tuple2f)tuple;
            this.x = _tuple.GetX();
            this.y = _tuple.GetY();
        }
        else if (tuple is BuffTuple2f)
        {
            BuffTuple2f _tuple = (BuffTuple2f)tuple;
            this.x = _tuple.GetX();
            this.y = _tuple.GetY();
        }
        else
        {
            Tuple2f _tuple = new Tuple2f(tuple);
            this.x = _tuple.GetX();
            this.y = _tuple.GetY();
        }
    }

    /**
     * Copy constructor.
     *
     * @param tuple Tuple.
     */
    public Vector2f(Tuple2f tuple)
    {
        this.x = tuple.GetX();
        this.y = tuple.GetY();
    }

    /**
     * Copy constructor.
     *
     * @param tuple Tuple.
     */
    public Vector2f(BuffTuple2f tuple)
    {
        this.x = tuple.GetX();
        this.y = tuple.GetY();
    }

    /**
     * Zero vector.
     *
     * @return Vector zero.
     */
    public static Vector2f getZero()
    {
        return new Vector2f((float)0, (float)0);
    }

    /**
     * One vector.
     *
     * @return Vector one.
     */
    public static Vector2f getOne()
    {
        return new Vector2f((float)1, (float)1);
    }

    /**
     * Unit vector: X.
     *
     * @return Vector unit.
     */
    public static Vector2f getUX()
    {
        return getUnit(0);
    }

    /**
     * Unit vector: Y.
     *
     * @return Vector unit.
     */
    public static Vector2f getUY()
    {
        return getUnit(1);
    }

    #region accessors
    public float GetAt(int index)
    {
        switch(index)
        {
        case 0:
            return x;
        case 1:
            return y;
        }
        throw new IndexOutOfRangeException();
    }

    public float GetX()
    {
        return x;
    }

    public float GetY()
    {
        return y;
    }
    #endregion

    #region Vector2
    public bool IsUnit(double epsilon = EPSILON)
    {
        return DoubleUtils.epsilonEquals(getLength(), 1, epsilon);
    }

    public Vector2f GetUnit()
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
               + Math.abs(getY());
    }

    public double GetAngle()
    {
        return (double) Math.atan2(getY(), getX());
    }

    public double AngleTo(Vector2 other)
    {
        if (other is Vector2f)
        {
            return angleTo((Vector2f)other);
        }
        else if (other is BuffVector2f)
        {
            return angleTo((BuffVector2f)other);
        }
        else
        {
            return angleTo(new Vector2f(other));
        }
    }

    public double AngleTo(Vector2f other)
    {
        // http://stackoverflow.com/questions/2150050/finding-signed-angle-between-vectors
        return Math.atan2(getX() * other.getY() - getY() * other.getX(),
                          getX() * other.getX() + getY() * other.getY());
    }

    public double AngleTo(BuffVector2f other)
    {
        // http://stackoverflow.com/questions/2150050/finding-signed-angle-between-vectors
        return Math.atan2(getX() * other.getY() - getY() * other.getX(),
                          getX() * other.getX() + getY() * other.getY());
    }

    public Vector2f GetPerpLeft()
    {
        return new Vector2f(-getY(), getX());
    }

    public Vector2f GetPerpRight()
    {
        return new Vector2f(getY(), -getX());
    }

    public Vector2f Rotate(double angle)
    {
        double s = Math.sin(angle);
        double c = Math.cos(angle);
        return new Vector2f((float)(getX() * c - getY() * s),
                            (float)(getX() * s + getY() * c));
    }

    public Vector2f RotateAndScale(double angle, double len)
    {
        double s = Math.sin(angle);
        double c = Math.cos(angle);
        return new Vector2f((float)(len*(getX() * c - getY() * s)),
                            (float)(len*(getX() * s + getY() * c)));
    }

    public Vector2f add(Vector2 other)
    {
        if (other instanceof Vector2f)
        {
            return add((Vector2f)other);
        }
        else if (other instanceof BuffVector2f)
        {
            return add((BuffVector2f)other);
        }
        else
        {
            return add(new Vector2f(other));
        }
    }

    public Vector2f add(Vector2f other)
    {
        return new Vector2f((float)(getX() + other.getX()), (float)(getY() + other.getY()));
    }

    public Vector2f add(BuffVector2f other)
    {
        return new Vector2f((float)(getX() + other.getX()), (float)(getY() + other.getY()));
    }

    public Vector2f sub(Vector2 other)
    {
        if (other instanceof Vector2f)
        {
            return sub((Vector2f)other);
        }
        else if (other instanceof BuffVector2f)
        {
            return sub((BuffVector2f)other);
        }
        else
        {
            return sub(new Vector2f(other));
        }
    }

    public Vector2f sub(Vector2f other)
    {
        return new Vector2f((float)(getX() - other.getX()), (float)(getY() - other.getY()));
    }

    public Vector2f sub(BuffVector2f other)
    {
        return new Vector2f((float)(getX() - other.getX()), (float)(getY() - other.getY()));
    }

    public Vector2f simpleMul(Vector2 other)
    {
        if (other instanceof Vector2f)
        {
            return simpleMul((Vector2f)other);
        }
        else if (other instanceof BuffVector2f)
        {
            return simpleMul((BuffVector2f)other);
        }
        else
        {
            return simpleMul(new Vector2f(other));
        }
    }

    public Vector2f simpleMul(Vector2f other)
    {
        return new Vector2f((float)(getX() * other.getX()), (float)(getY() * other.getY()));
    }

    public Vector2f simpleMul(BuffVector2f other)
    {
        return new Vector2f((float)(getX() * other.getX()), (float)(getY() * other.getY()));
    }

    public Vector2f simpleDiv(Vector2 other)
    {
        if (other instanceof Vector2f)
        {
            return simpleDiv((Vector2f)other);
        }
        else if (other instanceof BuffVector2f)
        {
            return simpleDiv((BuffVector2f)other);
        }
        else
        {
            return simpleDiv(new Vector2f(other));
        }
    }

    public Vector2f simpleDiv(Vector2f other)
    {
        return new Vector2f((float)(getX() / other.getX()), (float)(getY() / other.getY()));
    }

    public Vector2f simpleDiv(BuffVector2f other)
    {
        return new Vector2f((float)(getX() / other.getX()), (float)(getY() / other.getY()));
    }

    public Vector2f mul(double v)
    {
        return new Vector2f((float)(getX() * v), (float)(getY() * v));
    }

    public Vector2f div(double v)
    {
        if (DoubleUtils.epsilonZero(v))
        {
            throw new ArithmeticError("divided by zero");
        }
        return new Vector2f((float)(getX() / v), (float)(getY() / v));
    }

    public Vector2f neg()
    {
        return new Vector2f((float)(- getX()), (float)(- getY()));
    }

    public Vector2f abs()
    {
        return new Vector2f((float)Math.abs(getX()), (float)Math.abs(getY()));
    }

    public Vector2f lerp(Vector2 other, double alpha)
    {
        if (other instanceof Vector2f)
        {
            return lerp((Vector2f)other, alpha);
        }
        else if (other instanceof BuffVector2f)
        {
            return lerp((BuffVector2f)other, alpha);
        }
        else
        {
            return lerp(new Vector2f(other), alpha);
        }
    }

    public Vector2f lerp(Vector2f other, double alpha)
    {
        return lineal(other, 1 - alpha, alpha);
    }

    public Vector2f lerp(BuffVector2f other, double alpha)
    {
        return lineal(other, 1 - alpha, alpha);
    }

    public double invLerp(Vector2 other, Vector2 lerp)
    {
        if (other instanceof Vector2f && lerp instanceof Vector2f)
        {
            return invLerp((Vector2f)other, (Vector2f)lerp);
        }
        else if (other instanceof BuffVector2f && lerp instanceof BuffVector2f)
        {
            return invLerp((BuffVector2f)other, (BuffVector2f)lerp);
        }
        else
        {
            return invLerp(new Vector2f(other), new Vector2f(other));
        }
    }

    public double invLerp(Vector2f other, Vector2f lerp)
    {
        double x1 = other.getX() - getX();
        double y1 = other.getY() - getY();
        double x2 = lerp.getX() - getX();
        double y2 = lerp.getY() - getY();
        return (x1 * x2 + y1 * y2) / Math.sqrt(x1 * x1 + y1 * y1);
    }

    public double invLerp(BuffVector2f other, BuffVector2f lerp)
    {
        double x1 = other.getX() - getX();
        double y1 = other.getY() - getY();
        double x2 = lerp.getX() - getX();
        double y2 = lerp.getY() - getY();
        return (x1 * x2 + y1 * y2) / Math.sqrt(x1 * x1 + y1 * y1);
    }

    public Vector2f lineal(Vector2 other, double alpha, double beta)
    {
        if (other instanceof Vector2f)
        {
            return lineal((Vector2f)other, alpha, beta);
        }
        else if (other instanceof BuffVector2f)
        {
            return lineal((BuffVector2f)other, alpha, beta);
        }
        else
        {
            return lineal(new Vector2f(other), alpha, beta);
        }
    }

    public Vector2f lineal(Vector2f other, double alpha, double beta)
    {
        return new Vector2f((float)(alpha * getX() + beta * other.getX()),
                            (float)(alpha * getY() + beta * other.getY()));
    }

    public Vector2f lineal(BuffVector2f other, double alpha, double beta)
    {
        return new Vector2f((float)(alpha * getX() + beta * other.getX()),
                            (float)(alpha * getY() + beta * other.getY()));
    }

    public double Dot(Vector2 other)
    {
        if (other is Vector2f)
        {
            return Dot((Vector2f)other);
        }
        else if (other is BuffVector2f)
        {
            return Dot((BuffVector2f)other);
        }
        else
        {
            return Dot(new Vector2f(other));
        }
    }
    public double Dot(Vector2f other)
    {
        return getX() * other.getX() + getY() * other.getY();
    }

    public double Dot(BuffVector2f other)
    {
        return getX() * other.getX() + getY() * other.getY();
    }

    public double Cross(Vector2 other)
    {
        if (other is Vector2f)
        {
            return Cross((Vector2f)other);
        }
        else if (other is BuffVector2f)
        {
            return Cross((BuffVector2f)other);
        }
        else
        {
            return Cross(new Vector2f(other));
        }
    }

    public double Cross(Vector2f other)
    {
        return getX() * other.getY() - getY() * other.getX();
    }

    public double Cross(BuffVector2f other)
    {
        return getX() * other.getY() - getY() * other.getX();
    }

    public double scalarProjection(Vector2 where)
    {
        if (where is Vector2f)
        {
            return scalarProjection((Vector2f)where);
        }
        else if (where is BuffVector2f)
        {
            return scalarProjection((BuffVector2f)where);
        }
        else
        {
            return scalarProjection(new Vector2f(where));
        }
    }

    public double scalarProjection(Vector2f where)
    {
        return dot(where) / where.getLength();
    }

    public double scalarProjection(BuffVector2f where)
    {
        return dot(where) / where.getLength();
    }

    public Vector2 vectorProjection(Vector2 where)
    {
        if (where is Vector2f)
        {
            return vectorProjection((Vector2f)where);
        }
        else if (where is BuffVector2f)
        {
            return vectorProjection((BuffVector2f)where);
        }
        else
        {
            return vectorProjection(new Vector2f(where));
        }
    }

    public Vector2f vectorProjection(Vector2f where)
    {
        double r = dot(where) / where.getLengthCuad();
        return where.mul(r);
    }

    public BuffVector2f vectorProjection(BuffVector2f where)
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
                             x, y);
    }

    public override bool Equals(Object other)
    {
        if (other is Tuple2f)
        {
            return Equals((Tuple2f)other);
        }
        else if (other is BuffTuple2f)
        {
            return Equals((BuffTuple2f)other);
        }
        else if (other is Tuple)
        {
            return Equals(new Tuple2f((Tuple)other));
        }
        return false;
    }
    public bool Equals(Tuple2f other)
    {
        if (other == this)
        {
            return true;
        }
        return Equals(other.GetX(),
                      other.GetY());
    }

    public bool Equals(BuffTuple2f other)
    {
        return Equals(other.GetX(),
                      other.GetY());
    }

    public override int GetHashCode()
    {
        // https://stackoverflow.com/questions/113511/best-implementation-for-hashcode-method
        // http://www.jarvana.com/jarvana/view/org/apache/lucene/lucene-spatial/2.9.3/lucene-spatial-2.9.3-sources.jar!/org/apache/lucene/spatial/geometry/shape/Vector2D.java
        const int prime = 31;
        int hash = 1;
        hash = prime * hash + GetX().GetHashCode();
        hash = prime * hash + GetY().GetHashCode();
        return hash;
    }

    public Vector2f Clone()
    {
        Vector2f copy = (Vector2f)base.Clone();
        return copy;
    }
    #endregion

    #region Tuple
    public int Size
    {
        get
        {
            return 2;
        }
    }

    public void GetInto(TupleSet tupleSet)
    {
        tupleSet.SetFloat(0, x);
        tupleSet.SetFloat(1, y);
    }
    #endregion

    #region EpsilonEquatable<Tuple>
    public bool EpsilonEquals(Tuple other, double epsilon = EPSILON)
    {
        if (other is Tuple2f)
        {
            return EpsilonEquals((Tuple2f)other, epsilon);
        }
        else if (other is BuffTuple2f)
        {
            return EpsilonEquals((BuffTuple2f)other, epsilon);
        }
        else if (other is Tuple)
        {
            return EpsilonEquals(new Tuple2f(other), epsilon);
        }
        return false;
    }

    public bool EpsilonEquals(Tuple2f other, double epsilon = EPSILON)
    {
        if (other == this)
        {
            return true;
        }
        return EpsilonEquals(other.GetX(),
                             other.GetY(), epsilon);
    }

    public bool EpsilonEquals(BuffTuple2f other, double epsilon = EPSILON)
    {
        return EpsilonEquals(other.GetX(),
                             other.GetY(), epsilon);
    }
    #endregion

    #region private
    private static Vector2f getUnit(int index)
    {
        return new Vector2f((float)((index == 0) ? 1 : 0),
                            (float)((index == 1) ? 1 : 0));
    }
    #endregion
}
}

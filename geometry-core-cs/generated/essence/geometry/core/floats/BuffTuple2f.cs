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
using System.Text;
using essence.util.math;
using essence.geometry.core;

namespace essence.geometry.core.floats
{
/**
 * Basic implementation of a 2 dimension tuple.
 */
public class BuffTuple2f : ICloneable, IEpsilonEquatable<Tuple>, Tuple, TupleSet
{

//<editor-fold defaultstate="collapsed" desc="fields">
    public const float EPSILON = essence.util.math.FloatUtils.EPSILON;
    /** X component. */
    private float x;
    /** Y component. */
    private float y;
    private static String format;
//</editor-fold>

    /**
     * Empty constructor.
     */
    public BuffTuple2f()
    {
        this((float)0, (float)0);
    }

    /**
     * This constructor sets the components of this tuple.
     *
     * @param x Value of the component X.
     * @param y Value of the component Y.
     */
    public BuffTuple2f(float x, float y)
    {
        this.x = x;
        this.y = y;
    }

    /**
     * Copy constructor.
     *
     * @param tuple Tuple.
     */
    public BuffTuple2f(Tuple tuple)
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
    public BuffTuple2f(Tuple2f tuple)
    {
        this.x = tuple.GetX();
        this.y = tuple.GetY();
    }

    /**
     * Copy constructor.
     *
     * @param tuple Tuple.
     */
    public BuffTuple2f(BuffTuple2f tuple)
    {
        this.x = tuple.GetX();
        this.y = tuple.GetY();
    }

    public bool IsValid()
    {
        return !IsNaN() && !IsInfinity();
    }

    /**
     * This method evaluates if {@code this} tuple contains any NaN component.
     *
     * @return {@code True} if {@code this} tuple contains any NaN component. {@code False} otherwise.
     */
    public bool IsNaN()
    {
        return Float.IsNaN(x) || Float.IsNaN(y);
    }

    /**
     * This method evaluates if {@code this} tuple contains any infinity component.
     *
     * @return {@code True} if {@code this} tuple contains any infinity component. {@code False} otherwise.
     */
    public bool IsInfinity()
    {
        return Float.IsInfinity(x) || Float.IsInfinity(y);
    }

    /**
     * This method evaluates if {@code this} tuple is zero.
     *
     * @param epsilon Error.
     * @return {@code True} if {@code this} tuple is zero. {@code False} otherwise.
     */
    public bool IsZero(double epsilon = EPSILON)
    {
        return EpsilonEquals((float)0, (float)0, epsilon);
    }

//<editor-fold defaultstate="collapsed" desc="accessors">
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

    /**
     * This method sets the component {@code index}.
     *
     * @param index Index of the component.
     * @param value Value of the component.
     */
    public void SetAt(int index, float value)
    {
        switch(index)
        {
        case 0:
            x = value;
            return;
        case 1:
            y = value;
            return;
        }
        throw new IndexOutOfRangeException();
    }

    /**
     * This method sets the X component.
     *
     * @param value Value of the X component.
     */
    public void SetX(float value)
    {
        x = value;
    }

    /**
     * This method sets the Y component.
     *
     * @param value Value of the Y component.
     */
    public void SetY(float value)
    {
        y = value;
    }

    /**
     * This method sets all the components.
     *
     * @param x Value of the X component.
     * @param y Value of the Y component.
     */
    public void Set(float x, float y)
    {
        this.x = x;
        this.y = y;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Object">
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
        return Equals(other.GetX(),
                      other.GetY());
    }

    public bool Equals(BuffTuple2f other)
    {
        if (other == this)
        {
            return true;
        }
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

    public BuffTuple2f Clone()
    {
        BuffTuple2f copy = (BuffTuple2f)base.Clone();
        return copy;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Tuple">
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
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="TupleSet">
    public void SetByte(int index, byte value)
    {
        SetAt(index, (float)value);
    }

    public void SetShort(int index, short value)
    {
        SetAt(index, (float)value);
    }

    public void SetInteger(int index, int value)
    {
        SetAt(index, (float)value);
    }

    public void SetLong(int index, long value)
    {
        SetAt(index, (float)value);
    }

    public void SetFloat(int index, float value)
    {
        SetAt(index, (float)value);
    }

    public void SetDouble(int index, double value)
    {
        SetAt(index, (float)value);
    }

    public void Set<T>(int index, T value)
    {
        if (typeof(IConvertible).IsAssignableFrom(typeof(T)))
        {
            SetAt(index, ((IConvertible)value).ToFloat(null));
            return;
        }
        throw new NotSupportedException();
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="EpsilonEquatable<Tuple>">
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
        return EpsilonEquals(other.GetX(),
                             other.GetY(), epsilon);
    }

    public bool EpsilonEquals(BuffTuple2f other, double epsilon = EPSILON)
    {
        if (other == this)
        {
            return true;
        }
        return EpsilonEquals(other.GetX(),
                             other.GetY(), epsilon);
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="private">
    private bool EpsilonEquals(float x, float y, double epsilon)
    {
        return DoubleUtils.EpsilonEquals(this.x, x, epsilon) && DoubleUtils.EpsilonEquals(this.y, y, epsilon);
    }

    private bool Equals(float x, float y)
    {
        return this.x == x && this.y == y;
    }

    private static String GetFormat()
    {
        if (format == null)
        {
            String f = ".3f";  // Floating point number with 3 decimal places
            String b = "%1$s"; // Begin      [
            String s = "%2$s"; // Separation ,
            String e = "%3$s"; // End        ]

            StringBuilder buff = new StringBuilder();
            int k = 4;
            buff.Append(b);
            buff.Append("%").Append(k++).Append("$").Append(f);
            buff.Append(s);
            buff.Append("%").Append(k++).Append("$").Append(f);
            buff.Append(e);
            format = buff.ToString();
        }
        return format;
    }
//</editor-fold>
}
}

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
 * Basic implementation of a 4 dimension tuple.
 */
public class BuffTuple4f : ICloneable, IEpsilonEquatable<Tuple>, Tuple, TupleSet
{

//<editor-fold defaultstate="collapsed" desc="fields">
    public const float EPSILON = essence.util.math.FloatUtils.EPSILON;
    /** X component. */
    private float x;
    /** Y component. */
    private float y;
    /** Z component. */
    private float z;
    /** W component. */
    private float w;
    private static String format;
//</editor-fold>

    /**
     * Empty constructor.
     */
    public BuffTuple4f()
    {
        this((float)0, (float)0, (float)0, (float)0);
    }

    /**
     * This constructor sets the components of this tuple.
     *
     * @param x Value of the component X.
     * @param y Value of the component Y.
     * @param z Value of the component Z.
     * @param w Value of the component W.
     */
    public BuffTuple4f(float x, float y, float z, float w)
    {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    /**
     * Copy constructor.
     *
     * @param tuple Tuple.
     */
    public BuffTuple4f(Tuple tuple)
    {
        if (tuple is Tuple4f)
        {
            Tuple4f _tuple = (Tuple4f)tuple;
            this.x = _tuple.GetX();
            this.y = _tuple.GetY();
            this.z = _tuple.GetZ();
            this.w = _tuple.GetW();
        }
        else if (tuple is BuffTuple4f)
        {
            BuffTuple4f _tuple = (BuffTuple4f)tuple;
            this.x = _tuple.GetX();
            this.y = _tuple.GetY();
            this.z = _tuple.GetZ();
            this.w = _tuple.GetW();
        }
        else
        {
            Tuple4f _tuple = new Tuple4f(tuple);
            this.x = _tuple.GetX();
            this.y = _tuple.GetY();
            this.z = _tuple.GetZ();
            this.w = _tuple.GetW();
        }
    }

    /**
     * Copy constructor.
     *
     * @param tuple Tuple.
     */
    public BuffTuple4f(Tuple4f tuple)
    {
        this.x = tuple.GetX();
        this.y = tuple.GetY();
        this.z = tuple.GetZ();
        this.w = tuple.GetW();
    }

    /**
     * Copy constructor.
     *
     * @param tuple Tuple.
     */
    public BuffTuple4f(BuffTuple4f tuple)
    {
        this.x = tuple.GetX();
        this.y = tuple.GetY();
        this.z = tuple.GetZ();
        this.w = tuple.GetW();
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
        return Float.IsNaN(x) || Float.IsNaN(y) || Float.IsNaN(z) || Float.IsNaN(w);
    }

    /**
     * This method evaluates if {@code this} tuple contains any infinity component.
     *
     * @return {@code True} if {@code this} tuple contains any infinity component. {@code False} otherwise.
     */
    public bool IsInfinity()
    {
        return Float.IsInfinity(x) || Float.IsInfinity(y) || Float.IsInfinity(z) || Float.IsInfinity(w);
    }

    /**
     * This method evaluates if {@code this} tuple is zero.
     *
     * @param epsilon Error.
     * @return {@code True} if {@code this} tuple is zero. {@code False} otherwise.
     */
    public bool IsZero(double epsilon = EPSILON)
    {
        return EpsilonEquals((float)0, (float)0, (float)0, (float)0, epsilon);
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
        case 2:
            return z;
        case 3:
            return w;
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

    public float GetZ()
    {
        return z;
    }

    public float GetW()
    {
        return w;
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
        case 2:
            z = value;
            return;
        case 3:
            w = value;
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
     * This method sets the Z component.
     *
     * @param value Value of the Z component.
     */
    public void SetZ(float value)
    {
        z = value;
    }

    /**
     * This method sets the W component.
     *
     * @param value Value of the W component.
     */
    public void SetW(float value)
    {
        w = value;
    }

    /**
     * This method sets all the components.
     *
     * @param x Value of the X component.
     * @param y Value of the Y component.
     * @param z Value of the Z component.
     * @param w Value of the W component.
     */
    public void Set(float x, float y, float z, float w)
    {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Object">
    public override String ToString()
    {
        VectorFormatInfo vfi = VectorFormatInfo.CURRENT_INFO;
        return String.Format(GetFormat(), vfi.getBeg(), vfi.getSep(), vfi.getEnd(),
                             x, y, z, w);
    }

    public override bool Equals(Object other)
    {
        if (other is Tuple4f)
        {
            return Equals((Tuple4f)other);
        }
        else if (other is BuffTuple4f)
        {
            return Equals((BuffTuple4f)other);
        }
        else if (other is Tuple)
        {
            return Equals(new Tuple4f((Tuple)other));
        }
        return false;
    }
    public bool Equals(Tuple4f other)
    {
        return Equals(other.GetX(),
                      other.GetY(),
                      other.GetZ(),
                      other.GetW());
    }

    public bool Equals(BuffTuple4f other)
    {
        if (other == this)
        {
            return true;
        }
        return Equals(other.GetX(),
                      other.GetY(),
                      other.GetZ(),
                      other.GetW());
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
        hash = prime * hash + GetW().GetHashCode();
        return hash;
    }

    public BuffTuple4f Clone()
    {
        BuffTuple4f copy = (BuffTuple4f)base.Clone();
        return copy;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Tuple">
    public int Size
    {
        get
        {
            return 4;
        }
    }

    public void GetInto(TupleSet tupleSet)
    {
        tupleSet.SetFloat(0, x);
        tupleSet.SetFloat(1, y);
        tupleSet.SetFloat(2, z);
        tupleSet.SetFloat(3, w);
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
        if (other is Tuple4f)
        {
            return EpsilonEquals((Tuple4f)other, epsilon);
        }
        else if (other is BuffTuple4f)
        {
            return EpsilonEquals((BuffTuple4f)other, epsilon);
        }
        else if (other is Tuple)
        {
            return EpsilonEquals(new Tuple4f(other), epsilon);
        }
        return false;
    }

    public bool EpsilonEquals(Tuple4f other, double epsilon = EPSILON)
    {
        return EpsilonEquals(other.GetX(),
                             other.GetY(),
                             other.GetZ(),
                             other.GetW(), epsilon);
    }

    public bool EpsilonEquals(BuffTuple4f other, double epsilon = EPSILON)
    {
        if (other == this)
        {
            return true;
        }
        return EpsilonEquals(other.GetX(),
                             other.GetY(),
                             other.GetZ(),
                             other.GetW(), epsilon);
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="private">
    private bool EpsilonEquals(float x, float y, float z, float w, double epsilon)
    {
        return DoubleUtils.EpsilonEquals(this.x, x, epsilon) && DoubleUtils.EpsilonEquals(this.y, y, epsilon) && DoubleUtils.EpsilonEquals(this.z, z, epsilon) && DoubleUtils.EpsilonEquals(this.w, w, epsilon);
    }

    private bool Equals(float x, float y, float z, float w)
    {
        return this.x == x && this.y == y && this.z == z && this.w == w;
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
            buff.Append(s);
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

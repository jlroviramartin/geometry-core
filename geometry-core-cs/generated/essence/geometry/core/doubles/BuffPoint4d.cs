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

import essence.geometry.core.Tuple;
import essence.geometry.core.Vector4;
import essence.geometry.core.Point4;
import essence.geometry.core.BuffPoint4;

namespace essence.geometry.core.doubles
{
/**
 * Basic implementation of a 4 dimension vector.
 */
public class BuffPoint4d : BuffTuple4d, BuffPoint4
{

    /**
     * Empty constructor.
     */
    public BuffPoint4d()
    {
    }

    /**
     * This constructor sets the components of this point.
     *
     * @param x Value of the component X.
     * @param y Value of the component Y.
     * @param z Value of the component Z.
     * @param w Value of the component W.
     */
    public BuffPoint4d(double x, double y, double z, double w)
    {
        super(x, y, z, w);
    }

    /**
     * Copy constructor.
     *
     * @param tuple Tuple.
     */
    public BuffPoint4d(Tuple tuple)
    {
        super(tuple);
    }

    /**
     * Zero point.
     *
     * @return Point zero.
     */
    public static final BuffPoint4d GetZero()
    {
        return new BuffPoint4d((double)0, (double)0, (double)0, (double)0);
    }

    /**
     * One point.
     *
     * @return Point one.
     */
    public static final BuffPoint4d GetOne()
    {
        return new BuffPoint4d((double)1, (double)1, (double)1, (double)1);
    }

//<editor-fold defaultstate="collapsed" desc="BuffPoint4">
    public BuffPoint4d addAndSet(Vector4 other)
    {
        if (other instanceof Vector4d)
        {
            return addAndSet((Vector4d)other);
        }
        else if (other instanceof BuffVector4d)
        {
            return addAndSet((BuffVector4d)other);
        }
        else
        {
            return addAndSet(new Vector4d(other));
        }
    }

    public BuffPoint4d addAndSet(Vector4d other)
    {
        set((double)(getX() + other.getX()), (double)(getY() + other.getY()), (double)(getZ() + other.getZ()), (double)(getW() + other.getW()));
        return this;
    }

    public BuffPoint4d addAndSet(BuffVector4d other)
    {
        set((double)(getX() + other.getX()), (double)(getY() + other.getY()), (double)(getZ() + other.getZ()), (double)(getW() + other.getW()));
        return this;
    }

    public BuffPoint4d subAndSet(Vector4 other)
    {
        if (other instanceof Vector4d)
        {
            return subAndSet((Vector4d)other);
        }
        else if (other instanceof BuffVector4d)
        {
            return subAndSet((BuffVector4d)other);
        }
        else
        {
            return subAndSet(new Vector4d(other));
        }
    }

    public BuffPoint4d subAndSet(Vector4d other)
    {
        set((double)(getX() - other.getX()), (double)(getY() - other.getY()), (double)(getZ() - other.getZ()), (double)(getW() - other.getW()));
        return this;
    }

    public BuffPoint4d subAndSet(BuffVector4d other)
    {
        set((double)(getX() - other.getX()), (double)(getY() - other.getY()), (double)(getZ() - other.getZ()), (double)(getW() - other.getW()));
        return this;
    }

    public BuffPoint4d lerpAndSet(Point4 other, double alpha)
    {
        if (other instanceof Point4d)
        {
            return lerpAndSet((Point4d)other, alpha);
        }
        else if (other instanceof BuffPoint4d)
        {
            return lerpAndSet((BuffPoint4d)other, alpha);
        }
        else
        {
            return lerpAndSet(new Point4d(other), alpha);
        }
    }

    public BuffPoint4d lerpAndSet(Point4d other, double alpha)
    {
        linealAndSet(other, 1 - alpha, alpha);
        return this;
    }

    public BuffPoint4d lerpAndSet(BuffPoint4d other, double alpha)
    {
        linealAndSet(other, 1 - alpha, alpha);
        return this;
    }

    @Override
    public BuffPoint4d linealAndSet(Point4 other, double alpha, double beta)
    {
        if (other instanceof Point4d)
        {
            return linealAndSet((Point4d)other, alpha, beta);
        }
        else if (other instanceof BuffPoint4d)
        {
            return linealAndSet((BuffPoint4d)other, alpha, beta);
        }
        else
        {
            return linealAndSet(new Point4d(other), alpha, beta);
        }
    }

    public BuffPoint4d linealAndSet(Point4d other, double alpha, double beta)
    {
        set((double)(alpha * getX() + beta * other.getX()),
            (double)(alpha * getY() + beta * other.getY()),
            (double)(alpha * getZ() + beta * other.getZ()),
            (double)(alpha * getW() + beta * other.getW()));
        return this;
    }

    public BuffPoint4d linealAndSet(BuffPoint4d other, double alpha, double beta)
    {
        set((double)(alpha * getX() + beta * other.getX()),
            (double)(alpha * getY() + beta * other.getY()),
            (double)(alpha * getZ() + beta * other.getZ()),
            (double)(alpha * getW() + beta * other.getW()));
        return this;
    }

    @Override
    public BuffPoint4d vectorProjectionAndSet(Vector4 where)
    {
        if (where instanceof Vector4d)
        {
            return vectorProjectionAndSet((Vector4d)where);
        }
        else if (where instanceof BuffVector4d)
        {
            return vectorProjectionAndSet((BuffVector4d)where);
        }
        else
        {
            return vectorProjectionAndSet(new Vector4d(where));
        }
    }

    public BuffPoint4d vectorProjectionAndSet(Vector4d where)
    {
        double dot = getX() * where.getX() + getY() * where.getY() + getZ() * where.getZ() + getW() * where.getW();
        double r = dot / where.GetLengthCuad();

        set((double)(getX() * r), (double)(getY() * r), (double)(getZ() * r), (double)(getW() * r));
        return this;
    }

    public BuffPoint4d vectorProjectionAndSet(BuffVector4d where)
    {
        double dot = getX() * where.getX() + getY() * where.getY() + getZ() * where.getZ() + getW() * where.getW();
        double r = dot / where.GetLengthCuad();

        set((double)(getX() * r), (double)(getY() * r), (double)(getZ() * r), (double)(getW() * r));
        return this;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Point4">
    @Override
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
        if (getW() < 0)
        {
            v |= p;
            p <<= 1;
        }
        return v;
    }

    @Override
    public double getDistance(Point4 other)
    {
        if (other is Point4d)
        {
            return getDistance((Point4d)other);
        }
        else if (other is BuffPoint4d)
        {
            return getDistance((BuffPoint4d)other);
        }
        else
        {
            return getDistance(new Point4d(other));
        }
    }

    public double getDistance(Point4d other)
    {
        return Math.sqrt(getDistanceCuad(other));
    }

    public double getDistance(BuffPoint4d other)
    {
        return Math.sqrt(getDistanceCuad(other));
    }

    @Override
    public double getDistanceCuad(Point4 other)
    {
        if (other is Point4d)
        {
            return getDistanceCuad((Point4d)other);
        }
        else if (other is BuffPoint4d)
        {
            return getDistanceCuad((BuffPoint4d)other);
        }
        else
        {
            return getDistanceCuad(new Point4d(other));
        }
    }

    public double getDistanceCuad(Point4d other)
    {
        return Square(other.getX() - getX())
               + Square(other.getY() - getY())
               + Square(other.getZ() - getZ())
               + Square(other.getW() - getW());
    }

    public double getDistanceCuad(BuffPoint4d other)
    {
        return Square(other.getX() - getX())
               + Square(other.getY() - getY())
               + Square(other.getZ() - getZ())
               + Square(other.getW() - getW());
    }

    @Override
    public double getDistanceL1(Point4 other)
    {
        if (other is Point4d)
        {
            return getDistanceL1((Point4d)other);
        }
        else if (other is BuffPoint4d)
        {
            return getDistanceL1((BuffPoint4d)other);
        }
        else
        {
            return getDistanceL1(new Point4d(other));
        }
    }

    public double getDistanceL1(Point4d other)
    {
        return Math.Abs(other.getX() - getX())
               + Math.Abs(other.getY() - getY())
               + Math.Abs(other.getZ() - getZ())
               + Math.Abs(other.getW() - getW());
    }

    public double getDistanceL1(BuffPoint4d other)
    {
        return Math.Abs(other.getX() - getX())
               + Math.Abs(other.getY() - getY())
               + Math.Abs(other.getZ() - getZ())
               + Math.Abs(other.getW() - getW());
    }

    public BuffPoint4d add(Vector4 other)
    {
        if (other instanceof Vector4d)
        {
            return add((Vector4d)other);
        }
        else if (other instanceof BuffVector4d)
        {
            return add((BuffVector4d)other);
        }
        else
        {
            return add(new Vector4d(other));
        }
    }

    public BuffPoint4d add(Vector4d other)
    {
        return new BuffPoint4d((double)(getX() + other.getX()), (double)(getY() + other.getY()), (double)(getZ() + other.getZ()), (double)(getW() + other.getW()));
    }

    public BuffPoint4d add(BuffVector4d other)
    {
        return new BuffPoint4d((double)(getX() + other.getX()), (double)(getY() + other.getY()), (double)(getZ() + other.getZ()), (double)(getW() + other.getW()));
    }

    public BuffPoint4d sub(Vector4 other)
    {
        if (other instanceof Vector4d)
        {
            return sub((Vector4d)other);
        }
        else if (other instanceof BuffVector4d)
        {
            return sub((BuffVector4d)other);
        }
        else
        {
            return sub(new Vector4d(other));
        }
    }

    public BuffPoint4d sub(Vector4d other)
    {
        return new BuffPoint4d((double)(getX() - other.getX()), (double)(getY() - other.getY()), (double)(getZ() - other.getZ()), (double)(getW() - other.getW()));
    }

    public BuffPoint4d sub(BuffVector4d other)
    {
        return new BuffPoint4d((double)(getX() - other.getX()), (double)(getY() - other.getY()), (double)(getZ() - other.getZ()), (double)(getW() - other.getW()));
    }

    @Override
    public BuffVector4d VectorTo(Point4 other)
    {
        if (other is Point4d)
        {
            return VectorTo((Point4d)other);
        }
        else if (other is BuffPoint4d)
        {
            return VectorTo((BuffPoint4d)other);
        }
        else
        {
            return VectorTo(new Point4d(other));
        }
    }

    public BuffVector4d VectorTo(Point4d other)
    {
        return new BuffVector4d((double)(other.getX() - getX()), (double)(other.getY() - getY()), (double)(other.getZ() - getZ()), (double)(other.getW() - getW()));
    }

    public BuffVector4d VectorTo(BuffPoint4d other)
    {
        return new BuffVector4d((double)(other.getX() - getX()), (double)(other.getY() - getY()), (double)(other.getZ() - getZ()), (double)(other.getW() - getW()));
    }

    public BuffPoint4d lerp(Point4 other, double alpha)
    {
        if (other instanceof Point4d)
        {
            return lerp((Point4d)other, alpha);
        }
        else if (other instanceof BuffPoint4d)
        {
            return lerp((BuffPoint4d)other, alpha);
        }
        else
        {
            return lerp(new Point4d(other), alpha);
        }
    }

    public BuffPoint4d lerp(Point4d other, double alpha)
    {
        return lineal(other, 1 - alpha, alpha);
    }

    public BuffPoint4d lerp(BuffPoint4d other, double alpha)
    {
        return lineal(other, 1 - alpha, alpha);
    }

    public double invLerp(Point4 other, Point4 lerp)
    {
        if (other instanceof Point4d && lerp instanceof Point4d)
        {
            return invLerp((Point4d)other, (Point4d)lerp);
        }
        else if (other instanceof BuffPoint4d && lerp instanceof BuffPoint4d)
        {
            return invLerp((BuffPoint4d)other, (BuffPoint4d)lerp);
        }
        else
        {
            return invLerp(new Point4d(other), new Point4d(other));
        }
    }

    public double invLerp(Point4d other, Point4d lerp)
    {
        double x1 = other.getX() - getX();
        double y1 = other.getY() - getY();
        double z1 = other.getZ() - getZ();
        double w1 = other.getW() - getW();
        double x2 = lerp.getX() - getX();
        double y2 = lerp.getY() - getY();
        double z2 = lerp.getZ() - getZ();
        double w2 = lerp.getW() - getW();
        return (x1 * x2 + y1 * y2 + z1 * z2 + w1 * w2) / Math.sqrt(x1 * x1 + y1 * y1 + z1 * z1 + w1 * w1);
    }

    public double invLerp(BuffPoint4d other, BuffPoint4d lerp)
    {
        double x1 = other.getX() - getX();
        double y1 = other.getY() - getY();
        double z1 = other.getZ() - getZ();
        double w1 = other.getW() - getW();
        double x2 = lerp.getX() - getX();
        double y2 = lerp.getY() - getY();
        double z2 = lerp.getZ() - getZ();
        double w2 = lerp.getW() - getW();
        return (x1 * x2 + y1 * y2 + z1 * z2 + w1 * w2) / Math.sqrt(x1 * x1 + y1 * y1 + z1 * z1 + w1 * w1);
    }

    public BuffPoint4d lineal(Point4 other, double alpha, double beta)
    {
        if (other instanceof Point4d)
        {
            return lineal((Point4d)other, alpha, beta);
        }
        else if (other instanceof BuffPoint4d)
        {
            return lineal((BuffPoint4d)other, alpha, beta);
        }
        else
        {
            return lineal(new Point4d(other), alpha, beta);
        }
    }

    public BuffPoint4d lineal(Point4d other, double alpha, double beta)
    {
        return new BuffPoint4d((double)(alpha * getX() + beta * other.getX()),
                               (double)(alpha * getY() + beta * other.getY()),
                               (double)(alpha * getZ() + beta * other.getZ()),
                               (double)(alpha * getW() + beta * other.getW()));
    }

    public BuffPoint4d lineal(BuffPoint4d other, double alpha, double beta)
    {
        return new BuffPoint4d((double)(alpha * getX() + beta * other.getX()),
                               (double)(alpha * getY() + beta * other.getY()),
                               (double)(alpha * getZ() + beta * other.getZ()),
                               (double)(alpha * getW() + beta * other.getW()));
    }

    @Override
    public double ScalarProjection(Vector4 where)
    {
        if (where is Vector4d)
        {
            return ScalarProjection((Vector4d)where);
        }
        else if (where is BuffVector4d)
        {
            return ScalarProjection((BuffVector4d)where);
        }
        else
        {
            return ScalarProjection(new Vector4d(where));
        }
    }

    public double ScalarProjection(Vector4d where)
    {
        double dot = getX() * where.getX() + getY() * where.getY() + getZ() * where.getZ() + getW() * where.getW();
        return  dot / where.GetLengthCuad();
    }

    public double ScalarProjection(BuffVector4d where)
    {
        double dot = getX() * where.getX() + getY() * where.getY() + getZ() * where.getZ() + getW() * where.getW();
        return  dot / where.GetLengthCuad();
    }

    @Override
    public BuffPoint4d VectorProjection(Vector4 where)
    {
        if (where is Vector4d)
        {
            return VectorProjection((Vector4d)where);
        }
        else if (where is BuffVector4d)
        {
            return VectorProjection((BuffVector4d)where);
        }
        else
        {
            return VectorProjection(new Vector4d(where));
        }
    }

    public BuffPoint4d VectorProjection(Vector4d where)
    {
        double dot = getX() * where.getX() + getY() * where.getY() + getZ() * where.getZ() + getW() * where.getW();
        double r = dot / where.GetLengthCuad();

        return new BuffPoint4d((double)(getX() * r), (double)(getY() * r), (double)(getZ() * r), (double)(getW() * r));
    }

    public BuffPoint4d VectorProjection(BuffVector4d where)
    {
        double dot = getX() * where.getX() + getY() * where.getY() + getZ() * where.getZ() + getW() * where.getW();
        double r = dot / where.GetLengthCuad();

        return new BuffPoint4d((double)(getX() * r), (double)(getY() * r), (double)(getZ() * r), (double)(getW() * r));
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Object">
    @Override
    public BuffPoint4d Clone()
    {
        return (BuffPoint4d)base.Clone();
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="private">
    private static double Square(double v)
    {
        return v*v;
    }
//</editor-fold>
}
}

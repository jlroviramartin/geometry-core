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

import essence.geometry.core.Tuple;
import essence.geometry.core.TupleUtils;
import essence.geometry.core.Vector4;
import essence.geometry.core.Point4;
import essence.geometry.core.BuffPoint4;

/**
 * Basic implementation of a 4 dimension vector.
 */
public class BuffPoint4d extends BuffTuple4d implements BuffPoint4 {

    /**
     * Empty constructor.
     */
    public BuffPoint4d() {
    }

    /**
     * This constructor sets the components of this point.
     *
     * @param x Value of the component X.
     * @param y Value of the component Y.
     * @param z Value of the component Z.
     * @param w Value of the component W.
     */
    public BuffPoint4d(double x, double y, double z, double w) {
        super(x, y, z, w);
    }

    /**
     * Copy constructor.
     *
     * @param tuple Tuple.
     */
    public BuffPoint4d(Tuple tuple) {
        super(tuple);
    }

    /**
     * Zero point.
     *
     * @return Point zero.
     */
    public static final BuffPoint4d getZero() {
        return new BuffPoint4d((double)0, (double)0, (double)0, (double)0);
    }

    /**
     * One point.
     *
     * @return Point one.
     */
    public static final BuffPoint4d getOne() {
        return new BuffPoint4d((double)1, (double)1, (double)1, (double)1);
    }

    public BuffPoint4d addAndSet(BuffVector4d other) {
        set(getX() + other.getX(), getY() + other.getY(), getZ() + other.getZ(), getW() + other.getW());
        return this;
    }

    public BuffPoint4d subAndSet(BuffVector4d other) {
        set(getX() - other.getX(), getY() - other.getY(), getZ() - other.getZ(), getW() - other.getW());
        return this;
    }

    public BuffPoint4d lerpAndSet(BuffPoint4d other, double alpha) {
        return linealAndSet(other, 1 - alpha, alpha);
    }

    public BuffPoint4d linealAndSet(BuffPoint4d other, double alpha, double beta) {
        set((double)(alpha * getX() + beta * other.getX()),
            (double)(alpha * getY() + beta * other.getY()),
            (double)(alpha * getZ() + beta * other.getZ()),
            (double)(alpha * getW() + beta * other.getW()));
        return this;
    }

    public BuffPoint4d vectorProjectionAndSet(BuffVector4d where) {
        double dot = getX() * where.getX() + getY() * where.getY() + getZ() * where.getZ() + getW() * where.getW();
        double r = dot / where.getLengthCuad();

        set((double)(getX() * r), (double)(getY() * r), (double)(getZ() * r), (double)(getW() * r));
        return this;

        //set(new BuffVector4d(this).vectorProjectionAndSet(where));
        //return this;
    }

    public double getDistance(BuffPoint4d other) {
        return Math.sqrt(getDistanceCuad(other));
    }

    public double getDistanceCuad(BuffPoint4d other) {
        return square(other.getX() - getX())
               + square(other.getY() - getY())
               + square(other.getZ() - getZ())
               + square(other.getW() - getW());
    }

    public double getDistanceL1(BuffPoint4d other) {
        return Math.abs(other.getX() - getX())
               + Math.abs(other.getY() - getY())
               + Math.abs(other.getZ() - getZ())
               + Math.abs(other.getW() - getW());
    }

    public BuffPoint4d add(BuffVector4d other) {
        return new BuffPoint4d(getX() + other.getX(), getY() + other.getY(), getZ() + other.getZ(), getW() + other.getW());
    }

    public BuffPoint4d sub(BuffVector4d other) {
        return new BuffPoint4d(getX() - other.getX(), getY() - other.getY(), getZ() - other.getZ(), getW() - other.getW());
    }

    public BuffVector4d vectorTo(BuffPoint4d other) {
        return new BuffVector4d(other.getX() - getX(), other.getY() - getY(), other.getZ() - getZ(), other.getW() - getW());
    }

    public BuffPoint4d lerp(BuffPoint4d other, double alpha) {
        return lineal(other, 1 - alpha, alpha);
    }

    public double invLerp(BuffPoint4d other, BuffPoint4d pLerp) {
        double x1 = other.getX() - getX();
        double y1 = other.getY() - getY();
        double z1 = other.getZ() - getZ();
        double w1 = other.getW() - getW();
        double x2 = pLerp.getX() - getX();
        double y2 = pLerp.getY() - getY();
        double z2 = pLerp.getZ() - getZ();
        double w2 = pLerp.getW() - getW();
        return (x1 * x2 + y1 * y2 + z1 * z2 + w1 * w2) / Math.sqrt(x1 * x1 + y1 * y1 + z1 * z1 + w1 * w1);
    }

    public BuffPoint4d lineal(BuffPoint4d other, double alpha, double beta) {
        return new BuffPoint4d((double)(alpha * getX() + beta * other.getX()),
                               (double)(alpha * getY() + beta * other.getY()),
                               (double)(alpha * getZ() + beta * other.getZ()),
                               (double)(alpha * getW() + beta * other.getW()));
    }

    public double scalarProjection(BuffVector4d where) {
        return new BuffVector4d(this).dot(where) / where.getLength();
    }

    public BuffPoint4d vectorProjection(BuffVector4d where) {
        double dot = getX() * where.getX() + getY() * where.getY() + getZ() * where.getZ() + getW() * where.getW();
        double r = dot / where.getLengthCuad();

        return new BuffPoint4d((double)(getX() * r), (double)(getY() * r), (double)(getZ() * r), (double)(getW() * r));

        //return new BuffPoint4d(new Vector4d(this).vectorProjection(where));
    }

//<editor-fold defaultstate="collapsed" desc="BuffPoint4">
    @Override
    public BuffPoint4d addAndSet(Vector4 other) {
        Tuple4_Double _other = TupleUtils.toTuple4_Double(other);

        set(getX() + _other.getX(), getY() + _other.getY(), getZ() + _other.getZ(), getW() + _other.getW());
        return this;
    }

    @Override
    public BuffPoint4d subAndSet(Vector4 other) {
        Tuple4_Double _other = TupleUtils.toTuple4_Double(other);

        set(getX() - _other.getX(), getY() - _other.getY(), getZ() - _other.getZ(), getW() - _other.getW());
        return this;
    }

    @Override
    public BuffPoint4d lerpAndSet(Point4 other, double alpha) {
        return linealAndSet(other, 1 - alpha, alpha);
    }

    @Override
    public BuffPoint4d linealAndSet(Point4 other, double alpha, double beta) {
        Tuple4_Double _other = TupleUtils.toTuple4_Double(other);

        set((double)(alpha * getX() + beta * _other.getX()),
            (double)(alpha * getY() + beta * _other.getY()),
            (double)(alpha * getZ() + beta * _other.getZ()),
            (double)(alpha * getW() + beta * _other.getW()));
        return this;
    }

    @Override
    public BuffPoint4d vectorProjectionAndSet(Vector4 where) {
        Tuple4_Double _where = TupleUtils.toTuple4_Double(where);

        double dot = getX() * _where.getX() + getY() * _where.getY() + getZ() * _where.getZ() + getW() * _where.getW();
        double r = dot / where.getLengthCuad();

        set((double)(getX() * r), (double)(getY() * r), (double)(getZ() * r), (double)(getW() * r));
        return this;

        //set(new BuffVector4d(this).vectorProjectionAndSet(where));
        //return this;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Point4">
    @Override
    public int getQuadrant() {
        int v = 0;
        int p = 1;
        if (getX() < 0) {
            v |= p;
            p <<= 1;
        }
        if (getY() < 0) {
            v |= p;
            p <<= 1;
        }
        if (getZ() < 0) {
            v |= p;
            p <<= 1;
        }
        if (getW() < 0) {
            v |= p;
            p <<= 1;
        }
        return v;
    }

    @Override
    public double getDistance(Point4 other) {
        return Math.sqrt(getDistanceCuad(other));
    }

    @Override
    public double getDistanceCuad(Point4 other) {
        Tuple4_Double _other = TupleUtils.toTuple4_Double(other);

        return square(_other.getX() - getX())
               + square(_other.getY() - getY())
               + square(_other.getZ() - getZ())
               + square(_other.getW() - getW());
    }

    @Override
    public double getDistanceL1(Point4 other) {
        Tuple4_Double _other = TupleUtils.toTuple4_Double(other);

        return Math.abs(_other.getX() - getX())
               + Math.abs(_other.getY() - getY())
               + Math.abs(_other.getZ() - getZ())
               + Math.abs(_other.getW() - getW());
    }

    @Override
    public BuffPoint4d add(Vector4 other) {
        Tuple4_Double _other = TupleUtils.toTuple4_Double(other);

        return new BuffPoint4d(getX() + _other.getX(), getY() + _other.getY(), getZ() + _other.getZ(), getW() + _other.getW());
    }

    @Override
    public BuffPoint4d sub(Vector4 other) {
        Tuple4_Double _other = TupleUtils.toTuple4_Double(other);

        return new BuffPoint4d(getX() - _other.getX(), getY() - _other.getY(), getZ() - _other.getZ(), getW() - _other.getW());
    }

    @Override
    public BuffVector4d vectorTo(Point4 other) {
        Tuple4_Double _other = TupleUtils.toTuple4_Double(other);

        return new BuffVector4d(_other.getX() - getX(), _other.getY() - getY(), _other.getZ() - getZ(), _other.getW() - getW());
    }

    @Override
    public BuffPoint4d lerp(Point4 other, double alpha) {
        return lineal(other, 1 - alpha, alpha);
    }

    @Override
    public double invLerp(Point4 other, Point4 pLerp) {
        Tuple4_Double _other = TupleUtils.toTuple4_Double(other);
        Tuple4_Double _pLerp = TupleUtils.toTuple4_Double(pLerp);

        double x1 = _other.getX() - getX();
        double y1 = _other.getY() - getY();
        double z1 = _other.getZ() - getZ();
        double w1 = _other.getW() - getW();
        double x2 = _pLerp.getX() - getX();
        double y2 = _pLerp.getY() - getY();
        double z2 = _pLerp.getZ() - getZ();
        double w2 = _pLerp.getW() - getW();
        return (x1 * x2 + y1 * y2 + z1 * z2 + w1 * w2) / Math.sqrt(x1 * x1 + y1 * y1 + z1 * z1 + w1 * w1);
    }

    @Override
    public BuffPoint4d lineal(Point4 other, double alpha, double beta) {
        Tuple4_Double _other = TupleUtils.toTuple4_Double(other);

        return new BuffPoint4d((double)(alpha * getX() + beta * _other.getX()),
                               (double)(alpha * getY() + beta * _other.getY()),
                               (double)(alpha * getZ() + beta * _other.getZ()),
                               (double)(alpha * getW() + beta * _other.getW()));
    }

    @Override
    public double scalarProjection(Vector4 where) {
        return new BuffVector4d(this).dot(where) / where.getLength();
    }

    @Override
    public BuffPoint4d vectorProjection(Vector4 where) {
        Tuple4_Double _where = TupleUtils.toTuple4_Double(where);

        double dot = getX() * _where.getX() + getY() * _where.getY() + getZ() * _where.getZ() + getW() * _where.getW();
        double r = dot / where.getLengthCuad();

        return new BuffPoint4d((double)(getX() * r), (double)(getY() * r), (double)(getZ() * r), (double)(getW() * r));

        //return new BuffPoint4d(new BuffVector4d(this).vectorProjection(where));
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Object">
    @Override
    public BuffPoint4d clone() throws CloneNotSupportedException {
        return (BuffPoint4d)super.clone();
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="private">
    private static double square(double v) {
        return v*v;
    }
//</editor-fold>
}

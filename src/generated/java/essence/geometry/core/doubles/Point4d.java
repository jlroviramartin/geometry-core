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
import essence.geometry.core.Vector4;
import essence.geometry.core.Point4;

/**
 * Basic implementation of a 4 dimension vector.
 */
public class Point4d extends Tuple4d implements Point4 {

    /**
     * Empty constructor.
     */
    public Point4d() {
    }

    /**
     * This constructor sets the components of this point.
     *
     * @param x Value of the component X.
     * @param y Value of the component Y.
     * @param z Value of the component Z.
     * @param w Value of the component W.
     */
    public Point4d(double x, double y, double z, double w) {
        super(x, y, z, w);
    }

    /**
     * Copy constructor.
     *
     * @param tuple Tuple.
     */
    public Point4d(Tuple tuple) {
        tuple.getInto(this);
    }

    /**
     * Zero point.
     *
     * @return Point zero.
     */
    public static final Point4d getZero() {
        return new Point4d((double)0, (double)0, (double)0, (double)0);
    }

    /**
     * One point.
     *
     * @return Point one.
     */
    public static final Point4d getOne() {
        return new Point4d((double)1, (double)1, (double)1, (double)1);
    }

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
    public double getDistanceCuad(Point4 other) {
        Tuple4_Double _other = toTuple(other);

        return square(_other.getX() - getX())
                + square(_other.getY() - getY())
                + square(_other.getZ() - getZ())
                + square(_other.getW() - getW());
    }

    public double getDistanceCuad(Point4d other) {
        return square(other.getX() - getX())
                + square(other.getY() - getY())
                + square(other.getZ() - getZ())
                + square(other.getW() - getW());
    }

    @Override
    public double getDistanceL1(Point4 other) {
        Tuple4_Double _other = toTuple(other);

        return Math.abs(_other.getX() - getX())
                + Math.abs(_other.getY() - getY())
                + Math.abs(_other.getZ() - getZ())
                + Math.abs(_other.getW() - getW());
    }

    public double getDistanceL1(Point4d other) {
        return Math.abs(other.getX() - getX())
                + Math.abs(other.getY() - getY())
                + Math.abs(other.getZ() - getZ())
                + Math.abs(other.getW() - getW());
    }

    @Override
    public Point4d add(Vector4 other) {
        return clone().addAndSet(other);
    }

    public Point4d add(Vector4d other) {
        return clone().addAndSet(other);
    }

    @Override
    public Point4 sub(Vector4 other) {
        return clone().subAndSet(other);
    }

    public Point4d sub(Vector4d other) {
        return clone().subAndSet(other);
    }

    @Override
    public Vector4d vectorTo(Point4 other) {
        Tuple4_Double _other = toTuple(other);

        return new Vector4d(_other.getX() - getX(), _other.getY() - getY(), _other.getZ() - getZ(), _other.getW() - getW());
    }

    public Vector4d vectorTo(Point4d other) {
        return new Vector4d(other.getX() - getX(), other.getY() - getY(), other.getZ() - getZ(), other.getW() - getW());
    }

    @Override
    public Point4d lerp(Point4 other, double alpha) {
        return clone().lerpAndSet(other, alpha);
    }

    public Point4d lerp(Point4d other, double alpha) {
        return clone().lerpAndSet(other, alpha);
    }

    @Override
    public double invLerp(Point4 other, Point4 pLerp) {
        Tuple4_Double _other = toTuple(other);
        Tuple4_Double _pLerp = toTuple(pLerp);

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

    public double invLerp(Point4d other, Point4d pLerp) {
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

    @Override
    public Point4d lineal(Point4 other, double alpha, double beta) {
        return clone().linealAndSet(other, alpha, beta);
    }

    public Point4d lineal(Point4d other, double alpha, double beta) {
        return clone().linealAndSet(other, alpha, beta);
    }

    @Override
    public double scalarProjection(Vector4 where) {
        return new Vector4d(this).dot(where) / where.getLength();
    }

    public double scalarProjection(Vector4d where) {
        return new Vector4d(this).dot(where) / where.getLength();
    }

    @Override
    public Point4d vectorProjection(Vector4 where) {
        return clone().vectorProjectionAndSet(where);
    }

    public Point4d vectorProjection(Vector4d where) {
        return clone().vectorProjectionAndSet(where);
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Point4">
    @Override
    public Point4d addAndSet(Vector4 other) {
        Tuple4_Double _other = toTuple(other);

        set(getX() + _other.getX(), getY() + _other.getY(), getZ() + _other.getZ(), getW() + _other.getW());
        return this;
    }

    public Point4d addAndSet(Vector4d other) {
        set(getX() + other.getX(), getY() + other.getY(), getZ() + other.getZ(), getW() + other.getW());
        return this;
    }

    @Override
    public Point4d subAndSet(Vector4 other) {
        Tuple4_Double _other = toTuple(other);

        set(getX() - _other.getX(), getY() - _other.getY(), getZ() - _other.getZ(), getW() - _other.getW());
        return this;
    }

    public Point4d subAndSet(Vector4d other) {
        set(getX() - other.getX(), getY() - other.getY(), getZ() - other.getZ(), getW() - other.getW());
        return this;
    }

    @Override
    public Point4d lerpAndSet(Point4 other, double alpha) {
        return linealAndSet(other, 1 - alpha, alpha);
    }

    public Point4d lerpAndSet(Point4d other, double alpha) {
        return linealAndSet(other, 1 - alpha, alpha);
    }

    @Override
    public Point4d linealAndSet(Point4 other, double alpha, double beta) {
        Tuple4_Double _other = toTuple(other);

        set((double)(alpha * getX() + beta * _other.getX()),
                (double)(alpha * getY() + beta * _other.getY()),
                (double)(alpha * getZ() + beta * _other.getZ()),
                (double)(alpha * getW() + beta * _other.getW()));
        return this;
    }

    public Point4d linealAndSet(Point4d other, double alpha, double beta) {
        set((double)(alpha * getX() + beta * other.getX()),
                (double)(alpha * getY() + beta * other.getY()),
                (double)(alpha * getZ() + beta * other.getZ()),
                (double)(alpha * getW() + beta * other.getW()));
        return this;
    }

    @Override
    public Point4d vectorProjectionAndSet(Vector4 where) {
        set(new Vector4d(this).vectorProjectionAndSet(where));
        return this;
    }

    public Point4d vectorProjectionAndSet(Vector4d where) {
        set(new Vector4d(this).vectorProjectionAndSet(where));
        return this;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Object">
    @Override
    public Point4d clone() {
        return (Point4d)super.clone();
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="private">
    private static double square(double v) {
        return v*v;
    }
//</editor-fold>
}





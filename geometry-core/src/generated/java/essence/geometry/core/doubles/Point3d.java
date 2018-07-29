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
import essence.geometry.core.Vector3;
import essence.geometry.core.Point3;

/**
 * Basic implementation of a 3 dimension vector.
 */
public class Point3d extends Tuple3d implements Point3 {

    /**
    * Empty constructor.
    */
    public Point3d() {
    }

    /**
     * This constructor sets the components of this point.
     *
     * @param x Value of the component X.
     * @param y Value of the component Y.
     * @param z Value of the component Z.
     */
    public Point3d(double x, double y, double z) {
        super(x, y, z);
    }

    /**
     * Copy constructor.
     *
     * @param tuple Tuple.
     */
    public Point3d(Tuple tuple) {
        tuple.getInto(this);
    }

    /**
    * Zero point.
    *
    * @return Point zero.
    */
    public static final Point3d getZero() {
        return new Point3d((double)0, (double)0, (double)0);
    }

    /**
     * One point.
     *
     * @return Point one.
     */
    public static final Point3d getOne() {
        return new Point3d((double)1, (double)1, (double)1);
    }

    //<editor-fold defaultstate="collapsed" desc="Point3">
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
        return v;
    }

    @Override
    public double getDistanceCuad(Point3 other) {
        Tuple3_Double _other = toTuple(other);

        return square(_other.getX() - getX())
               + square(_other.getY() - getY())
               + square(_other.getZ() - getZ());
    }

    public double getDistanceCuad(Point3d other) {
        return square(other.getX() - getX())
               + square(other.getY() - getY())
               + square(other.getZ() - getZ());
    }

    @Override
    public double getDistanceL1(Point3 other) {
        Tuple3_Double _other = toTuple(other);

        return Math.abs(_other.getX() - getX())
               + Math.abs(_other.getY() - getY())
               + Math.abs(_other.getZ() - getZ());
    }

    public double getDistanceL1(Point3d other) {
        return Math.abs(other.getX() - getX())
               + Math.abs(other.getY() - getY())
               + Math.abs(other.getZ() - getZ());
    }

    @Override
    public Point3d add(Vector3 other) {
        return clone().addAndSet(other);
    }

    public Point3d add(Vector3d other) {
        return clone().addAndSet(other);
    }

    @Override
    public Point3 sub(Vector3 other) {
        return clone().subAndSet(other);
    }

    public Point3d sub(Vector3d other) {
        return clone().subAndSet(other);
    }

    @Override
    public Vector3d vectorTo(Point3 other) {
        Tuple3_Double _other = toTuple(other);

        return new Vector3d(_other.getX() - getX(), _other.getY() - getY(), _other.getZ() - getZ());
    }

    public Vector3d vectorTo(Point3d other) {
        return new Vector3d(other.getX() - getX(), other.getY() - getY(), other.getZ() - getZ());
    }

    @Override
    public Point3d lerp(Point3 other, double alpha) {
        return clone().lerpAndSet(other, alpha);
    }

    public Point3d lerp(Point3d other, double alpha) {
        return clone().lerpAndSet(other, alpha);
    }

    @Override
    public double invLerp(Point3 other, Point3 pLerp) {
        Tuple3_Double _other = toTuple(other);
        Tuple3_Double _pLerp = toTuple(pLerp);

        double x1 = _other.getX() - getX();
        double y1 = _other.getY() - getY();
        double z1 = _other.getZ() - getZ();
        double x2 = _pLerp.getX() - getX();
        double y2 = _pLerp.getY() - getY();
        double z2 = _pLerp.getZ() - getZ();
        return (x1 * x2 + y1 * y2 + z1 * z2) / Math.sqrt(x1 * x1 + y1 * y1 + z1 * z1);
    }

    public double invLerp(Point3d other, Point3d pLerp) {
        double x1 = other.getX() - getX();
        double y1 = other.getY() - getY();
        double z1 = other.getZ() - getZ();
        double x2 = pLerp.getX() - getX();
        double y2 = pLerp.getY() - getY();
        double z2 = pLerp.getZ() - getZ();
        return (x1 * x2 + y1 * y2 + z1 * z2) / Math.sqrt(x1 * x1 + y1 * y1 + z1 * z1);
    }

    @Override
    public Point3d lineal(Point3 other, double alpha, double beta) {
        return clone().linealAndSet(other, alpha, beta);
    }

    public Point3d lineal(Point3d other, double alpha, double beta) {
        return clone().linealAndSet(other, alpha, beta);
    }

    @Override
    public double scalarProjection(Vector3 where) {
        return new Vector3d(this).dot(where) / where.getLength();
    }

    public double scalarProjection(Vector3d where) {
        return new Vector3d(this).dot(where) / where.getLength();
    }

    @Override
    public Point3d vectorProjection(Vector3 where) {
        return clone().vectorProjectionAndSet(where);
    }

    public Point3d vectorProjection(Vector3d where) {
        return clone().vectorProjectionAndSet(where);
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Point3">
    @Override
    public Point3d addAndSet(Vector3 other) {
        Tuple3_Double _other = toTuple(other);

        set(getX() + _other.getX(), getY() + _other.getY(), getZ() + _other.getZ());
        return this;
    }

    public Point3d addAndSet(Vector3d other) {
        set(getX() + other.getX(), getY() + other.getY(), getZ() + other.getZ());
        return this;
    }

    @Override
    public Point3d subAndSet(Vector3 other) {
        Tuple3_Double _other = toTuple(other);

        set(getX() - _other.getX(), getY() - _other.getY(), getZ() - _other.getZ());
        return this;
    }

    public Point3d subAndSet(Vector3d other) {
        set(getX() - other.getX(), getY() - other.getY(), getZ() - other.getZ());
        return this;
    }

    @Override
    public Point3d lerpAndSet(Point3 other, double alpha) {
        return linealAndSet(other, 1 - alpha, alpha);
    }

    public Point3d lerpAndSet(Point3d other, double alpha) {
        return linealAndSet(other, 1 - alpha, alpha);
    }

    @Override
    public Point3d linealAndSet(Point3 other, double alpha, double beta) {
        Tuple3_Double _other = toTuple(other);

        set((double)(alpha * getX() + beta * _other.getX()),
            (double)(alpha * getY() + beta * _other.getY()),
            (double)(alpha * getZ() + beta * _other.getZ()));
        return this;
    }

    public Point3d linealAndSet(Point3d other, double alpha, double beta) {
        set((double)(alpha * getX() + beta * other.getX()),
            (double)(alpha * getY() + beta * other.getY()),
            (double)(alpha * getZ() + beta * other.getZ()));
        return this;
    }

    @Override
    public Point3d vectorProjectionAndSet(Vector3 where) {
        set(new Vector3d(this).vectorProjectionAndSet(where));
        return this;
    }

    public Point3d vectorProjectionAndSet(Vector3d where) {
        set(new Vector3d(this).vectorProjectionAndSet(where));
        return this;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Object">
    @Override
    public Point3d clone() {
        return (Point3d)super.clone();
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="private">
    private static double square(double v) {
        return v*v;
    }
//</editor-fold>
}

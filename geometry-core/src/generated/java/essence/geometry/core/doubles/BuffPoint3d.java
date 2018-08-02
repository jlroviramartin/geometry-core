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
import essence.geometry.core.Vector3;
import essence.geometry.core.Point3;
import essence.geometry.core.BuffPoint3;

/**
 * Basic implementation of a 3 dimension vector.
 */
public class BuffPoint3d extends BuffTuple3d implements BuffPoint3 {

    /**
     * Empty constructor.
     */
    public BuffPoint3d() {
    }

    /**
     * This constructor sets the components of this point.
     *
     * @param x Value of the component X.
     * @param y Value of the component Y.
     * @param z Value of the component Z.
     */
    public BuffPoint3d(double x, double y, double z) {
        super(x, y, z);
    }

    /**
     * Copy constructor.
     *
     * @param tuple Tuple.
     */
    public BuffPoint3d(Tuple tuple) {
        super(tuple);
    }

    /**
     * Zero point.
     *
     * @return Point zero.
     */
    public static final BuffPoint3d getZero() {
        return new BuffPoint3d((double)0, (double)0, (double)0);
    }

    /**
     * One point.
     *
     * @return Point one.
     */
    public static final BuffPoint3d getOne() {
        return new BuffPoint3d((double)1, (double)1, (double)1);
    }

    public BuffPoint3d addAndSet(BuffVector3d other) {
        set(getX() + other.getX(), getY() + other.getY(), getZ() + other.getZ());
        return this;
    }

    public BuffPoint3d subAndSet(BuffVector3d other) {
        set(getX() - other.getX(), getY() - other.getY(), getZ() - other.getZ());
        return this;
    }

    public BuffPoint3d lerpAndSet(BuffPoint3d other, double alpha) {
        return linealAndSet(other, 1 - alpha, alpha);
    }

    public BuffPoint3d linealAndSet(BuffPoint3d other, double alpha, double beta) {
        set((double)(alpha * getX() + beta * other.getX()),
            (double)(alpha * getY() + beta * other.getY()),
            (double)(alpha * getZ() + beta * other.getZ()));
        return this;
    }

    public BuffPoint3d vectorProjectionAndSet(BuffVector3d where) {
        double dot = getX() * where.getX() + getY() * where.getY() + getZ() * where.getZ();
        double r = dot / where.getLengthCuad();

        set((double)(getX() * r), (double)(getY() * r), (double)(getZ() * r));
        return this;

        //set(new BuffVector3d(this).vectorProjectionAndSet(where));
        //return this;
    }

    public double getDistance(BuffPoint3d other) {
        return Math.sqrt(getDistanceCuad(other));
    }

    public double getDistanceCuad(BuffPoint3d other) {
        return square(other.getX() - getX())
               + square(other.getY() - getY())
               + square(other.getZ() - getZ());
    }

    public double getDistanceL1(BuffPoint3d other) {
        return Math.abs(other.getX() - getX())
               + Math.abs(other.getY() - getY())
               + Math.abs(other.getZ() - getZ());
    }

    public BuffPoint3d add(BuffVector3d other) {
        return new BuffPoint3d(getX() + other.getX(), getY() + other.getY(), getZ() + other.getZ());
    }

    public BuffPoint3d sub(BuffVector3d other) {
        return new BuffPoint3d(getX() - other.getX(), getY() - other.getY(), getZ() - other.getZ());
    }

    public BuffVector3d vectorTo(BuffPoint3d other) {
        return new BuffVector3d(other.getX() - getX(), other.getY() - getY(), other.getZ() - getZ());
    }

    public BuffPoint3d lerp(BuffPoint3d other, double alpha) {
        return lineal(other, 1 - alpha, alpha);
    }

    public double invLerp(BuffPoint3d other, BuffPoint3d pLerp) {
        double x1 = other.getX() - getX();
        double y1 = other.getY() - getY();
        double z1 = other.getZ() - getZ();
        double x2 = pLerp.getX() - getX();
        double y2 = pLerp.getY() - getY();
        double z2 = pLerp.getZ() - getZ();
        return (x1 * x2 + y1 * y2 + z1 * z2) / Math.sqrt(x1 * x1 + y1 * y1 + z1 * z1);
    }

    public BuffPoint3d lineal(BuffPoint3d other, double alpha, double beta) {
        return new BuffPoint3d((double)(alpha * getX() + beta * other.getX()),
                               (double)(alpha * getY() + beta * other.getY()),
                               (double)(alpha * getZ() + beta * other.getZ()));
    }

    public double scalarProjection(BuffVector3d where) {
        return new BuffVector3d(this).dot(where) / where.getLength();
    }

    public BuffPoint3d vectorProjection(BuffVector3d where) {
        double dot = getX() * where.getX() + getY() * where.getY() + getZ() * where.getZ();
        double r = dot / where.getLengthCuad();

        return new BuffPoint3d((double)(getX() * r), (double)(getY() * r), (double)(getZ() * r));

        //return new BuffPoint3d(new Vector3d(this).vectorProjection(where));
    }

//<editor-fold defaultstate="collapsed" desc="BuffPoint3">
    @Override
    public BuffPoint3d addAndSet(Vector3 other) {
        Tuple3_Double _other = TupleUtils.toTuple3_Double(other);

        set(getX() + _other.getX(), getY() + _other.getY(), getZ() + _other.getZ());
        return this;
    }

    @Override
    public BuffPoint3d subAndSet(Vector3 other) {
        Tuple3_Double _other = TupleUtils.toTuple3_Double(other);

        set(getX() - _other.getX(), getY() - _other.getY(), getZ() - _other.getZ());
        return this;
    }

    @Override
    public BuffPoint3d lerpAndSet(Point3 other, double alpha) {
        return linealAndSet(other, 1 - alpha, alpha);
    }

    @Override
    public BuffPoint3d linealAndSet(Point3 other, double alpha, double beta) {
        Tuple3_Double _other = TupleUtils.toTuple3_Double(other);

        set((double)(alpha * getX() + beta * _other.getX()),
            (double)(alpha * getY() + beta * _other.getY()),
            (double)(alpha * getZ() + beta * _other.getZ()));
        return this;
    }

    @Override
    public BuffPoint3d vectorProjectionAndSet(Vector3 where) {
        Tuple3_Double _where = TupleUtils.toTuple3_Double(where);

        double dot = getX() * _where.getX() + getY() * _where.getY() + getZ() * _where.getZ();
        double r = dot / where.getLengthCuad();

        set((double)(getX() * r), (double)(getY() * r), (double)(getZ() * r));
        return this;

        //set(new BuffVector3d(this).vectorProjectionAndSet(where));
        //return this;
    }
//</editor-fold>

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
    public double getDistance(Point3 other) {
        return Math.sqrt(getDistanceCuad(other));
    }

    @Override
    public double getDistanceCuad(Point3 other) {
        Tuple3_Double _other = TupleUtils.toTuple3_Double(other);

        return square(_other.getX() - getX())
               + square(_other.getY() - getY())
               + square(_other.getZ() - getZ());
    }

    @Override
    public double getDistanceL1(Point3 other) {
        Tuple3_Double _other = TupleUtils.toTuple3_Double(other);

        return Math.abs(_other.getX() - getX())
               + Math.abs(_other.getY() - getY())
               + Math.abs(_other.getZ() - getZ());
    }

    @Override
    public BuffPoint3d add(Vector3 other) {
        Tuple3_Double _other = TupleUtils.toTuple3_Double(other);

        return new BuffPoint3d(getX() + _other.getX(), getY() + _other.getY(), getZ() + _other.getZ());
    }

    @Override
    public BuffPoint3d sub(Vector3 other) {
        Tuple3_Double _other = TupleUtils.toTuple3_Double(other);

        return new BuffPoint3d(getX() - _other.getX(), getY() - _other.getY(), getZ() - _other.getZ());
    }

    @Override
    public BuffVector3d vectorTo(Point3 other) {
        Tuple3_Double _other = TupleUtils.toTuple3_Double(other);

        return new BuffVector3d(_other.getX() - getX(), _other.getY() - getY(), _other.getZ() - getZ());
    }

    @Override
    public BuffPoint3d lerp(Point3 other, double alpha) {
        return lineal(other, 1 - alpha, alpha);
    }

    @Override
    public double invLerp(Point3 other, Point3 pLerp) {
        Tuple3_Double _other = TupleUtils.toTuple3_Double(other);
        Tuple3_Double _pLerp = TupleUtils.toTuple3_Double(pLerp);

        double x1 = _other.getX() - getX();
        double y1 = _other.getY() - getY();
        double z1 = _other.getZ() - getZ();
        double x2 = _pLerp.getX() - getX();
        double y2 = _pLerp.getY() - getY();
        double z2 = _pLerp.getZ() - getZ();
        return (x1 * x2 + y1 * y2 + z1 * z2) / Math.sqrt(x1 * x1 + y1 * y1 + z1 * z1);
    }

    @Override
    public BuffPoint3d lineal(Point3 other, double alpha, double beta) {
        Tuple3_Double _other = TupleUtils.toTuple3_Double(other);

        return new BuffPoint3d((double)(alpha * getX() + beta * _other.getX()),
                               (double)(alpha * getY() + beta * _other.getY()),
                               (double)(alpha * getZ() + beta * _other.getZ()));
    }

    @Override
    public double scalarProjection(Vector3 where) {
        return new BuffVector3d(this).dot(where) / where.getLength();
    }

    @Override
    public BuffPoint3d vectorProjection(Vector3 where) {
        Tuple3_Double _where = TupleUtils.toTuple3_Double(where);

        double dot = getX() * _where.getX() + getY() * _where.getY() + getZ() * _where.getZ();
        double r = dot / where.getLengthCuad();

        return new BuffPoint3d((double)(getX() * r), (double)(getY() * r), (double)(getZ() * r));

        //return new BuffPoint3d(new BuffVector3d(this).vectorProjection(where));
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Object">
    @Override
    public BuffPoint3d clone() throws CloneNotSupportedException {
        return (BuffPoint3d)super.clone();
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="private">
    private static double square(double v) {
        return v*v;
    }
//</editor-fold>
}

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
import essence.geometry.core.Vector2;
import essence.geometry.core.DoubleUtils;

import static essence.geometry.core.DoubleUtils.EPSILON;

/**
 * Basic implementation of a 2 dimension vector.
 */
public class Vector2d extends Tuple2d implements Vector2 {

    /**
     * Empty constructor.
     */
    public Vector2d() {
    }

    /**
     * This constructor sets the components of this vector.
     *
     * @param x Value of the component X.
     * @param y Value of the component Y.
     */
    public Vector2d(double x, double y) {
        super(x, y);
    }

    /**
     * Copy constructor.
     *
     * @param tuple Tuple.
     */
    public Vector2d(Tuple tuple) {
        tuple.getInto(this);
    }

    /**
     * Zero vector.
     *
     * @return Vector zero.
     */
    public static final Vector2d getZero() {
        return new Vector2d((double)0, (double)0);
    }

    /**
     * One vector.
     *
     * @return Vector one.
     */
    public static final Vector2d getOne() {
        return new Vector2d((double)1, (double)1);
    }


    /**
     * Unit vector: X.
     *
     * @return Vector unit.
     */
    public static final Vector2d getUX() {
        return getUnit(0);
    }

    /**
     * Unit vector: Y.
     *
     * @return Vector unit.
     */
    public static final Vector2d getUY() {
        return getUnit(1);
    }
//<editor-fold defaultstate="collapsed" desc="Vector2">
    @Override
    public boolean isUnit() {
        return isUnit(EPSILON);
    }

    @Override
    public boolean isUnit(double epsilon) {
        return DoubleUtils.epsilonEquals(getLength(), 1, epsilon);
    }

    @Override
    public Vector2d getUnit() {
        return clone().setUnit();
    }

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
        return v;
    }

    @Override
    public double getLengthL1() {
        return Math.abs(getX())
                + Math.abs(getY());
    }

    @Override
    public double getAngle() {
        return (double) Math.atan2(getY(), getX());
    }

    @Override
    public double angleTo(Vector2 other) {
        Tuple2_Double _other = toTuple(other);

        // http://stackoverflow.com/questions/2150050/finding-signed-angle-between-vectors
        return Math.atan2(getX() * _other.getY() - getY() * _other.getX(),
                getX() * _other.getX() + getY() * _other.getY());
    }

    @Override
    public Vector2d getPerpLeft() {
        return clone().setPerpLeft();
    }

    @Override
    public Vector2d getPerpRight() {
        return clone().setPerpRight();
    }

    @Override
    public Vector2d rotate(double angle) {
        return clone().setRotate(angle);
    }

    @Override
    public Vector2d rotateAndScale(double angle, double len) {
        return clone().setRotateAndScale(angle, len);
    }

    @Override
    public Vector2d add(Vector2 other) {
        return clone().addAndSet(other);
    }

    public Vector2d add(Vector2d other) {
        return clone().addAndSet(other);
    }

    @Override
    public Vector2d sub(Vector2 other) {
        return clone().subAndSet(other);
    }

    public Vector2d sub(Vector2d other) {
        return clone().subAndSet(other);
    }

    @Override
    public Vector2d simpleMul(Vector2 other) {
        return clone().simpleMulAndSet(other);
    }

    public Vector2d simpleMul(Vector2d other) {
        return clone().simpleMulAndSet(other);
    }

    @Override
    public Vector2d simpleDiv(Vector2 other) {
        return clone().simpleDivAndSet(other);
    }

    public Vector2d simpleDiv(Vector2d other) {
        return clone().simpleDivAndSet(other);
    }

    @Override
    public Vector2d mul(double v) {
        return clone().mulAndSet(v);
    }

    @Override
    public Vector2d div(double v) {
        return clone().divAndSet(v);
    }

    @Override
    public Vector2d neg() {
        return clone().negAndSet();
    }

    @Override
    public Vector2d abs() {
        return clone().absAndSet();
    }

    @Override
    public Vector2d lerp(Vector2 other, double alpha) {
        return clone().lerpAndSet(other, alpha);
    }

    public Vector2d lerp(Vector2d other, double alpha) {
        return clone().lerpAndSet(other, alpha);
    }

    @Override
    public double invLerp(Vector2 other, Vector2 vLerp) {
        Tuple2_Double _other = toTuple(other);
        Tuple2_Double _vLerp = toTuple(vLerp);

        double x1 = _other.getX() - getX();
        double y1 = _other.getY() - getY();
        double x2 = _vLerp.getX() - getX();
        double y2 = _vLerp.getY() - getY();
        return (x1 * x2 + y1 * y2) / Math.sqrt(x1 * x1 + y1 * y1);
    }

    public double invLerp(Vector2d other, Vector2d vLerp) {
        double x1 = other.getX() - getX();
        double y1 = other.getY() - getY();
        double x2 = vLerp.getX() - getX();
        double y2 = vLerp.getY() - getY();
        return (x1 * x2 + y1 * y2) / Math.sqrt(x1 * x1 + y1 * y1);
    }

    @Override
    public Vector2d lineal(Vector2 other, double alpha, double beta) {
        return clone().linealAndSet(other, alpha, beta);
    }

    public Vector2d lineal(Vector2d other, double alpha, double beta) {
        return clone().linealAndSet(other, alpha, beta);
    }

    @Override
    public double dot(Vector2 other) {
        Tuple2_Double _other = toTuple(other);
        return getX() * _other.getX() + getY() * _other.getY();
    }

    public double dot(Vector2d other) {
        return getX() * other.getX() + getY() * other.getY();
    }

    @Override
    public double cross(Vector2 other) {
        Tuple2_Double _other = toTuple(other);

        return getX() * _other.getY() - getY() * _other.getX();
    }

    public double cross(Vector2d other) {
        return getX() * other.getY() - getY() * other.getX();
    }

    @Override
    public Vector2d vectorProjection(Vector2 where) {
        return clone().vectorProjectionAndSet(where);
    }

    public Vector2d vectorProjection(Vector2d where) {
        return clone().vectorProjectionAndSet(where);
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Vector2">
    @Override
    public Vector2d setZero() {
        set(0, 0);
        return this;
    }

    @Override
    public Vector2d setUnit() {
        double len = getLength();
        if (DoubleUtils.epsilonZero(len)) {
            setZero();
        } else {
            divAndSet(len);
        }
        return this;
    }

    @Override
    public Vector2d setPerpLeft() {
        set(-getY(), getX());
        return this;
    }

    @Override
    public Vector2d setPerpRight() {
        set(getY(), -getX());
        return this;
    }

    @Override
    public Vector2d setRotate(double angle) {
        double s = Math.sin(angle);
        double c = Math.cos(angle);
        set((double)(getX() * c - getY() * s),
                (double)(getX() * s + getY() * c));
        return this;
    }

    @Override
    public Vector2d setRotateAndScale(double angle, double len) {
        double s = Math.sin(angle);
        double c = Math.cos(angle);
        set((double)(len*(getX() * c - getY() * s)),
                (double)(len*(getX() * s + getY() * c)));
        return this;
    }

    @Override
    public Vector2d addAndSet(Vector2 other) {
        Tuple2_Double _other = toTuple(other);

        set(getX() + _other.getX(), getY() + _other.getY());
        return this;
    }

    public Vector2d addAndSet(Vector2d other) {
        set(getX() + other.getX(), getY() + other.getY());
        return this;
    }

    @Override
    public Vector2d subAndSet(Vector2 other) {
        Tuple2_Double _other = toTuple(other);

        set(getX() - _other.getX(), getY() - _other.getY());
        return this;
    }

    public Vector2d subAndSet(Vector2d other) {
        set(getX() - other.getX(), getY() - other.getY());
        return this;
    }

    @Override
    public Vector2d simpleMulAndSet(Vector2 other) {
        Tuple2_Double _other = toTuple(other);

        set(getX() * _other.getX(), getY() * _other.getY());
        return this;
    }

    public Vector2d simpleMulAndSet(Vector2d other) {
        set(getX() * other.getX(), getY() * other.getY());
        return this;
    }

    @Override
    public Vector2d simpleDivAndSet(Vector2 other) {
        Tuple2_Double _other = toTuple(other);

        set(getX() / _other.getX(), getY() / _other.getY());
        return this;
    }

    public Vector2d simpleDivAndSet(Vector2d other) {
        set(getX() / other.getX(), getY() / other.getY());
        return this;
    }

    @Override
    public Vector2d mulAndSet(double v) {
        set((double)(getX() * v), (double)(getY() * v));
        return this;
    }

    @Override
    public Vector2d divAndSet(double v) {
        set((double)(getX() / v), (double)(getY() / v));
        return this;
    }

    @Override
    public Vector2d negAndSet() {
        set(- getX(), - getY());
        return this;
    }

    @Override
    public Vector2d absAndSet() {
        set(Math.abs(getX()), Math.abs(getY()));
        return this;
    }

    @Override
    public Vector2d lerpAndSet(Vector2 other, double alpha) {
        linealAndSet(other, 1 - alpha, alpha);
        return this;
    }

    public Vector2d lerpAndSet(Vector2d other, double alpha) {
        linealAndSet(other, 1 - alpha, alpha);
        return this;
    }

    @Override
    public Vector2d linealAndSet(Vector2 other, double alpha, double beta) {
        Tuple2_Double _other = toTuple(other);

        set((double)(alpha * getX() + beta * _other.getX()),
                (double)(alpha * getY() + beta * _other.getY()));
        return this;
    }

    public Vector2d linealAndSet(Vector2d other, double alpha, double beta) {
        set((double)(alpha * getX() + beta * other.getX()),
                (double)(alpha * getY() + beta * other.getY()));
        return this;
    }

    @Override
    public Vector2d vectorProjectionAndSet(Vector2 where) {
        double r = dot(where) / where.getLengthCuad();
        set(where);
        mulAndSet(r);
        return this;
    }

    public Vector2d vectorProjectionAndSet(Vector2d where) {
        double r = dot(where) / where.getLengthCuad();
        set(where);
        mulAndSet(r);
        return this;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Object">
    @Override
    public Vector2d clone() {
        return (Vector2d)super.clone();
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="private">
    private static Vector2d getUnit(int index) {
        return new Vector2d((double)((index == 0) ? 1 : 0),
                (double)((index == 1) ? 1 : 0));
    }
//</editor-fold>
}





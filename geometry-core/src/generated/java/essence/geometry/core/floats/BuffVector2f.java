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
package essence.geometry.core.floats;

import essence.geometry.core.Tuple;
import essence.geometry.core.TupleUtils;
import essence.geometry.core.Vector2;
import essence.geometry.core.BuffVector2;
import essence.geometry.core.DoubleUtils;
import essence.util.math.ArithmeticError;

import static essence.geometry.core.FloatUtils.EPSILON;

/**
 * Basic implementation of a 2 dimension vector.
 */
public class BuffVector2f extends BuffTuple2f implements BuffVector2 {

    /**
     * Empty constructor.
     */
    public BuffVector2f() {
    }

    /**
     * This constructor sets the components of this vector.
     *
     * @param x Value of the component X.
     * @param y Value of the component Y.
     */
    public BuffVector2f(float x, float y) {
        super(x, y);
    }

    /**
     * Copy constructor.
     *
     * @param tuple Tuple.
     */
    public BuffVector2f(Tuple tuple) {
        super(tuple);
    }

    /**
     * Zero vector.
     *
     * @return Vector zero.
     */
    public static final BuffVector2f getZero() {
        return new BuffVector2f((float)0, (float)0);
    }

    /**
     * One vector.
     *
     * @return Vector one.
     */
    public static final BuffVector2f getOne() {
        return new BuffVector2f((float)1, (float)1);
    }

    /**
     * Unit vector: X.
     *
     * @return Vector unit.
     */
    public static final BuffVector2f getUX() {
        return getUnit(0);
    }

    /**
     * Unit vector: Y.
     *
     * @return Vector unit.
     */
    public static final BuffVector2f getUY() {
        return getUnit(1);
    }

    public BuffVector2f addAndSet(BuffVector2f other) {
        set(getX() + other.getX(), getY() + other.getY());
        return this;
    }

    public BuffVector2f subAndSet(BuffVector2f other) {
        set(getX() - other.getX(), getY() - other.getY());
        return this;
    }

    public BuffVector2f simpleMulAndSet(BuffVector2f other) {
        set(getX() * other.getX(), getY() * other.getY());
        return this;
    }

    public BuffVector2f simpleDivAndSet(BuffVector2f other) {
        set(getX() / other.getX(), getY() / other.getY());
        return this;
    }

    public BuffVector2f lerpAndSet(BuffVector2f other, double alpha) {
        linealAndSet(other, 1 - alpha, alpha);
        return this;
    }

    public BuffVector2f linealAndSet(BuffVector2f other, double alpha, double beta) {
        set((float)(alpha * getX() + beta * other.getX()),
            (float)(alpha * getY() + beta * other.getY()));
        return this;
    }

    public BuffVector2f vectorProjectionAndSet(BuffVector2f where) {
        double r = dot(where) / where.getLengthCuad();
        set((float)(where.getX() * r), (float)(where.getY() * r));
        return this;

        //double r = dot(where) / where.getLengthCuad();
        //set(where);
        //mulAndSet(r);
        //return this;
    }

    public BuffVector2f add(BuffVector2f other) {
        return new BuffVector2f(getX() + other.getX(), getY() + other.getY());
    }

    public BuffVector2f sub(BuffVector2f other) {
        return new BuffVector2f(getX() - other.getX(), getY() - other.getY());
    }

    public BuffVector2f simpleMul(BuffVector2f other) {
        return new BuffVector2f(getX() * other.getX(), getY() * other.getY());
    }

    public BuffVector2f simpleDiv(BuffVector2f other) {
        return new BuffVector2f(getX() / other.getX(), getY() / other.getY());
    }

    public BuffVector2f lerp(BuffVector2f other, double alpha) {
        return lineal(other, 1 - alpha, alpha);
    }

    public double invLerp(BuffVector2f other, BuffVector2f vLerp) {
        double x1 = other.getX() - getX();
        double y1 = other.getY() - getY();
        double x2 = vLerp.getX() - getX();
        double y2 = vLerp.getY() - getY();
        return (x1 * x2 + y1 * y2) / Math.sqrt(x1 * x1 + y1 * y1);
    }

    public BuffVector2f lineal(BuffVector2f other, double alpha, double beta) {
        return new BuffVector2f((float)(alpha * getX() + beta * other.getX()),
                                (float)(alpha * getY() + beta * other.getY()));
    }

    public double dot(BuffVector2f other) {
        return getX() * other.getX() + getY() * other.getY();
    }

    public double cross(BuffVector2f other) {
        return getX() * other.getY() - getY() * other.getX();
    }

    public BuffVector2f vectorProjection(BuffVector2f where) {
        double r = dot(where) / where.getLengthCuad();
        return where.mul(r);
    }

//<editor-fold defaultstate="collapsed" desc="BuffVector2">
    @Override
    public BuffVector2f setZero() {
        set(0, 0);
        return this;
    }

    @Override
    public BuffVector2f setUnit() {
        double len = getLength();
        if (DoubleUtils.epsilonZero(len)) {
            setZero();
        } else {
            divAndSet(len);
        }
        return this;
    }

    @Override
    public BuffVector2f setPerpLeft() {
        set(-getY(), getX());
        return this;
    }

    @Override
    public BuffVector2f setPerpRight() {
        set(getY(), -getX());
        return this;
    }

    @Override
    public BuffVector2f setRotate(double angle) {
        double s = Math.sin(angle);
        double c = Math.cos(angle);
        set((float)(getX() * c - getY() * s),
            (float)(getX() * s + getY() * c));
        return this;
    }

    @Override
    public BuffVector2f setRotateAndScale(double angle, double len) {
        double s = Math.sin(angle);
        double c = Math.cos(angle);
        set((float)(len*(getX() * c - getY() * s)),
            (float)(len*(getX() * s + getY() * c)));
        return this;
    }

    @Override
    public BuffVector2f addAndSet(Vector2 other) {
        Tuple2_Float _other = TupleUtils.toTuple2_Float(other);

        set(getX() + _other.getX(), getY() + _other.getY());
        return this;
    }

    @Override
    public BuffVector2f subAndSet(Vector2 other) {
        Tuple2_Float _other = TupleUtils.toTuple2_Float(other);

        set(getX() - _other.getX(), getY() - _other.getY());
        return this;
    }

    @Override
    public BuffVector2f simpleMulAndSet(Vector2 other) {
        Tuple2_Float _other = TupleUtils.toTuple2_Float(other);

        set(getX() * _other.getX(), getY() * _other.getY());
        return this;
    }

    @Override
    public BuffVector2f simpleDivAndSet(Vector2 other) {
        Tuple2_Float _other = TupleUtils.toTuple2_Float(other);

        set(getX() / _other.getX(), getY() / _other.getY());
        return this;
    }

    @Override
    public BuffVector2f mulAndSet(double v) {
        set((float)(getX() * v), (float)(getY() * v));
        return this;
    }

    @Override
    public BuffVector2f divAndSet(double v) {
        set((float)(getX() / v), (float)(getY() / v));
        return this;
    }

    @Override
    public BuffVector2f negAndSet() {
        set(- getX(), - getY());
        return this;
    }

    @Override
    public BuffVector2f absAndSet() {
        set(Math.abs(getX()), Math.abs(getY()));
        return this;
    }

    @Override
    public BuffVector2f lerpAndSet(Vector2 other, double alpha) {
        linealAndSet(other, 1 - alpha, alpha);
        return this;
    }

    @Override
    public BuffVector2f linealAndSet(Vector2 other, double alpha, double beta) {
        Tuple2_Float _other = TupleUtils.toTuple2_Float(other);

        set((float)(alpha * getX() + beta * _other.getX()),
            (float)(alpha * getY() + beta * _other.getY()));
        return this;
    }

    @Override
    public BuffVector2f vectorProjectionAndSet(Vector2 where) {
        Tuple2_Float _where = TupleUtils.toTuple2_Float(where);

        double r = dot(where) / where.getLengthCuad();
        set((float)(_where.getX() * r), (float)(_where.getY() * r));
        return this;

        //double r = dot(where) / where.getLengthCuad();
        //set(where);
        //mulAndSet(r);
        //return this;
    }
//</editor-fold>

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
    public BuffVector2f getUnit() {
        double len = getLength();
        return div(len);
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
        Tuple2_Float _other = TupleUtils.toTuple2_Float(other);

        // http://stackoverflow.com/questions/2150050/finding-signed-angle-between-vectors
        return Math.atan2(getX() * _other.getY() - getY() * _other.getX(),
                          getX() * _other.getX() + getY() * _other.getY());
    }

    @Override
    public BuffVector2f getPerpLeft() {
        return new BuffVector2f(-getY(), getX());
    }

    @Override
    public BuffVector2f getPerpRight() {
        return new BuffVector2f(getY(), -getX());
    }

    @Override
    public BuffVector2f rotate(double angle) {
        double s = Math.sin(angle);
        double c = Math.cos(angle);
        return new BuffVector2f((float)(getX() * c - getY() * s),
                                (float)(getX() * s + getY() * c));
    }

    @Override
    public BuffVector2f rotateAndScale(double angle, double len) {
        double s = Math.sin(angle);
        double c = Math.cos(angle);
        return new BuffVector2f((float)(len*(getX() * c - getY() * s)),
                                (float)(len*(getX() * s + getY() * c)));
    }

    @Override
    public BuffVector2f add(Vector2 other) {
        Tuple2_Float _other = TupleUtils.toTuple2_Float(other);

        return new BuffVector2f(getX() + _other.getX(), getY() + _other.getY());
    }

    @Override
    public BuffVector2f sub(Vector2 other) {
        Tuple2_Float _other = TupleUtils.toTuple2_Float(other);

        return new BuffVector2f(getX() - _other.getX(), getY() - _other.getY());
    }

    @Override
    public BuffVector2f simpleMul(Vector2 other) {
        Tuple2_Float _other = TupleUtils.toTuple2_Float(other);

        return new BuffVector2f(getX() * _other.getX(), getY() * _other.getY());
    }

    @Override
    public BuffVector2f simpleDiv(Vector2 other) {
        Tuple2_Float _other = TupleUtils.toTuple2_Float(other);

        return new BuffVector2f(getX() / _other.getX(), getY() / _other.getY());
    }

    @Override
    public BuffVector2f mul(double v) {
        return new BuffVector2f((float)(getX() * v), (float)(getY() * v));
    }

    @Override
    public BuffVector2f div(double v) {
        if (DoubleUtils.epsilonZero(v)) {
            throw new ArithmeticError("divided by zero");
        }
        return new BuffVector2f((float)(getX() / v), (float)(getY() / v));
    }

    @Override
    public BuffVector2f neg() {
        return new BuffVector2f(- getX(), - getY());
    }

    @Override
    public BuffVector2f abs() {
        return new BuffVector2f(Math.abs(getX()), Math.abs(getY()));
    }

    @Override
    public BuffVector2f lerp(Vector2 other, double alpha) {
        return lineal(other, 1 - alpha, alpha);
    }

    @Override
    public double invLerp(Vector2 other, Vector2 vLerp) {
        Tuple2_Float _other = TupleUtils.toTuple2_Float(other);
        Tuple2_Float _vLerp = TupleUtils.toTuple2_Float(vLerp);

        double x1 = _other.getX() - getX();
        double y1 = _other.getY() - getY();
        double x2 = _vLerp.getX() - getX();
        double y2 = _vLerp.getY() - getY();
        return (x1 * x2 + y1 * y2) / Math.sqrt(x1 * x1 + y1 * y1);
    }

    @Override
    public BuffVector2f lineal(Vector2 other, double alpha, double beta) {
        Tuple2_Float _other = TupleUtils.toTuple2_Float(other);

        return new BuffVector2f((float)(alpha * getX() + beta * _other.getX()),
                                (float)(alpha * getY() + beta * _other.getY()));
    }

    @Override
    public double dot(Vector2 other) {
        Tuple2_Float _other = TupleUtils.toTuple2_Float(other);

        return getX() * _other.getX() + getY() * _other.getY();
    }

    @Override
    public double cross(Vector2 other) {
        Tuple2_Float _other = TupleUtils.toTuple2_Float(other);

        return getX() * _other.getY() - getY() * _other.getX();
    }

    @Override
    public Vector2 vectorProjection(Vector2 where) {
        double r = dot(where) / where.getLengthCuad();
        return where.mul(r);
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Object">
    @Override
    public BuffVector2f clone() throws CloneNotSupportedException {
        return (BuffVector2f)super.clone();
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="private">
    private static BuffVector2f getUnit(int index) {
        return new BuffVector2f((float)((index == 0) ? 1 : 0),
                                (float)((index == 1) ? 1 : 0));
    }
//</editor-fold>
}

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
import essence.geometry.core.Vector3;
import essence.geometry.core.BuffVector3;
import essence.geometry.core.DoubleUtils;
import essence.util.math.ArithmeticError;

import static essence.geometry.core.FloatUtils.EPSILON;

/**
 * Basic implementation of a 3 dimension vector.
 */
public class BuffVector3f extends BuffTuple3f implements BuffVector3 {

    /**
     * Empty constructor.
     */
    public BuffVector3f() {
    }

    /**
     * This constructor sets the components of this vector.
     *
     * @param x Value of the component X.
     * @param y Value of the component Y.
     * @param z Value of the component Z.
     */
    public BuffVector3f(float x, float y, float z) {
        super(x, y, z);
    }

    /**
     * Copy constructor.
     *
     * @param tuple Tuple.
     */
    public BuffVector3f(Tuple tuple) {
        super(tuple);
    }

    /**
     * Zero vector.
     *
     * @return Vector zero.
     */
    public static final BuffVector3f getZero() {
        return new BuffVector3f((float)0, (float)0, (float)0);
    }

    /**
     * One vector.
     *
     * @return Vector one.
     */
    public static final BuffVector3f getOne() {
        return new BuffVector3f((float)1, (float)1, (float)1);
    }

    /**
     * Unit vector: X.
     *
     * @return Vector unit.
     */
    public static final BuffVector3f getUX() {
        return getUnit(0);
    }

    /**
     * Unit vector: Y.
     *
     * @return Vector unit.
     */
    public static final BuffVector3f getUY() {
        return getUnit(1);
    }

    /**
     * Unit vector: Z.
     *
     * @return Vector unit.
     */
    public static final BuffVector3f getUZ() {
        return getUnit(2);
    }

    public BuffVector3f addAndSet(BuffVector3f other) {
        set(getX() + other.getX(), getY() + other.getY(), getZ() + other.getZ());
        return this;
    }

    public BuffVector3f subAndSet(BuffVector3f other) {
        set(getX() - other.getX(), getY() - other.getY(), getZ() - other.getZ());
        return this;
    }

    public BuffVector3f simpleMulAndSet(BuffVector3f other) {
        set(getX() * other.getX(), getY() * other.getY(), getZ() * other.getZ());
        return this;
    }

    public BuffVector3f simpleDivAndSet(BuffVector3f other) {
        set(getX() / other.getX(), getY() / other.getY(), getZ() / other.getZ());
        return this;
    }

    public BuffVector3f lerpAndSet(BuffVector3f other, double alpha) {
        linealAndSet(other, 1 - alpha, alpha);
        return this;
    }

    public BuffVector3f linealAndSet(BuffVector3f other, double alpha, double beta) {
        set((float)(alpha * getX() + beta * other.getX()),
            (float)(alpha * getY() + beta * other.getY()),
            (float)(alpha * getZ() + beta * other.getZ()));
        return this;
    }

    public BuffVector3f crossAndSet(BuffVector3f other) {
        set((getY() * other.getZ()) - (getZ() * other.getY()),
            (getZ() * other.getX()) - (getX() * other.getZ()),
            (getX() * other.getY()) - (getY() * other.getX()));
        return this;
    }

    public BuffVector3f vectorProjectionAndSet(BuffVector3f where) {
        double r = dot(where) / where.getLengthCuad();
        set((float)(where.getX() * r), (float)(where.getY() * r), (float)(where.getZ() * r));
        return this;

        //double r = dot(where) / where.getLengthCuad();
        //set(where);
        //mulAndSet(r);
        //return this;
    }

    public BuffVector3f add(BuffVector3f other) {
        return new BuffVector3f(getX() + other.getX(), getY() + other.getY(), getZ() + other.getZ());
    }

    public BuffVector3f sub(BuffVector3f other) {
        return new BuffVector3f(getX() - other.getX(), getY() - other.getY(), getZ() - other.getZ());
    }

    public BuffVector3f simpleMul(BuffVector3f other) {
        return new BuffVector3f(getX() * other.getX(), getY() * other.getY(), getZ() * other.getZ());
    }

    public BuffVector3f simpleDiv(BuffVector3f other) {
        return new BuffVector3f(getX() / other.getX(), getY() / other.getY(), getZ() / other.getZ());
    }

    public BuffVector3f lerp(BuffVector3f other, double alpha) {
        return lineal(other, 1 - alpha, alpha);
    }

    public double invLerp(BuffVector3f other, BuffVector3f vLerp) {
        double x1 = other.getX() - getX();
        double y1 = other.getY() - getY();
        double z1 = other.getZ() - getZ();
        double x2 = vLerp.getX() - getX();
        double y2 = vLerp.getY() - getY();
        double z2 = vLerp.getZ() - getZ();
        return (x1 * x2 + y1 * y2 + z1 * z2) / Math.sqrt(x1 * x1 + y1 * y1 + z1 * z1);
    }

    public BuffVector3f lineal(BuffVector3f other, double alpha, double beta) {
        return new BuffVector3f((float)(alpha * getX() + beta * other.getX()),
                                (float)(alpha * getY() + beta * other.getY()),
                                (float)(alpha * getZ() + beta * other.getZ()));
    }

    public double dot(BuffVector3f other) {
        return getX() * other.getX() + getY() * other.getY() + getZ() * other.getZ();
    }

    public BuffVector3f cross(BuffVector3f other) {
        return new BuffVector3f((getY() * other.getZ()) - (getZ() * other.getY()),
                                (getZ() * other.getX()) - (getX() * other.getZ()),
                                (getX() * other.getY()) - (getY() * other.getX()));
    }

    public BuffVector3f vectorProjection(BuffVector3f where) {
        double r = dot(where) / where.getLengthCuad();
        return where.mul(r);
    }

//<editor-fold defaultstate="collapsed" desc="BuffVector3">
    @Override
    public BuffVector3f setZero() {
        set(0, 0, 0);
        return this;
    }

    @Override
    public BuffVector3f setUnit() {
        double len = getLength();
        if (DoubleUtils.epsilonZero(len)) {
            setZero();
        } else {
            divAndSet(len);
        }
        return this;
    }

    @Override
    public BuffVector3f addAndSet(Vector3 other) {
        Tuple3_Float _other = TupleUtils.toTuple3_Float(other);

        set(getX() + _other.getX(), getY() + _other.getY(), getZ() + _other.getZ());
        return this;
    }

    @Override
    public BuffVector3f subAndSet(Vector3 other) {
        Tuple3_Float _other = TupleUtils.toTuple3_Float(other);

        set(getX() - _other.getX(), getY() - _other.getY(), getZ() - _other.getZ());
        return this;
    }

    @Override
    public BuffVector3f simpleMulAndSet(Vector3 other) {
        Tuple3_Float _other = TupleUtils.toTuple3_Float(other);

        set(getX() * _other.getX(), getY() * _other.getY(), getZ() * _other.getZ());
        return this;
    }

    @Override
    public BuffVector3f simpleDivAndSet(Vector3 other) {
        Tuple3_Float _other = TupleUtils.toTuple3_Float(other);

        set(getX() / _other.getX(), getY() / _other.getY(), getZ() / _other.getZ());
        return this;
    }

    @Override
    public BuffVector3f mulAndSet(double v) {
        set((float)(getX() * v), (float)(getY() * v), (float)(getZ() * v));
        return this;
    }

    @Override
    public BuffVector3f divAndSet(double v) {
        set((float)(getX() / v), (float)(getY() / v), (float)(getZ() / v));
        return this;
    }

    @Override
    public BuffVector3f negAndSet() {
        set(- getX(), - getY(), - getZ());
        return this;
    }

    @Override
    public BuffVector3f absAndSet() {
        set(Math.abs(getX()), Math.abs(getY()), Math.abs(getZ()));
        return this;
    }

    @Override
    public BuffVector3f lerpAndSet(Vector3 other, double alpha) {
        linealAndSet(other, 1 - alpha, alpha);
        return this;
    }

    @Override
    public BuffVector3f linealAndSet(Vector3 other, double alpha, double beta) {
        Tuple3_Float _other = TupleUtils.toTuple3_Float(other);

        set((float)(alpha * getX() + beta * _other.getX()),
            (float)(alpha * getY() + beta * _other.getY()),
            (float)(alpha * getZ() + beta * _other.getZ()));
        return this;
    }

    @Override
    public BuffVector3f crossAndSet(Vector3 other) {
        Tuple3_Float _other = TupleUtils.toTuple3_Float(other);

        set((getY() * _other.getZ()) - (getZ() * _other.getY()),
            (getZ() * _other.getX()) - (getX() * _other.getZ()),
            (getX() * _other.getY()) - (getY() * _other.getX()));
        return this;
    }

    @Override
    public BuffVector3f vectorProjectionAndSet(Vector3 where) {
        Tuple3_Float _where = TupleUtils.toTuple3_Float(where);

        double r = dot(where) / where.getLengthCuad();
        set((float)(_where.getX() * r), (float)(_where.getY() * r), (float)(_where.getZ() * r));
        return this;

        //double r = dot(where) / where.getLengthCuad();
        //set(where);
        //mulAndSet(r);
        //return this;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Vector3">
    @Override
    public boolean isUnit() {
        return isUnit(EPSILON);
    }

    @Override
    public boolean isUnit(double epsilon) {
        return DoubleUtils.epsilonEquals(getLength(), 1, epsilon);
    }

    @Override
    public BuffVector3f getUnit() {
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
        if (getZ() < 0) {
            v |= p;
            p <<= 1;
        }
        return v;
    }

    @Override
    public double getLengthL1() {
        return Math.abs(getX())
               + Math.abs(getY())
               + Math.abs(getZ());
    }

    @Override
    public BuffVector3f add(Vector3 other) {
        Tuple3_Float _other = TupleUtils.toTuple3_Float(other);

        return new BuffVector3f(getX() + _other.getX(), getY() + _other.getY(), getZ() + _other.getZ());
    }

    @Override
    public BuffVector3f sub(Vector3 other) {
        Tuple3_Float _other = TupleUtils.toTuple3_Float(other);

        return new BuffVector3f(getX() - _other.getX(), getY() - _other.getY(), getZ() - _other.getZ());
    }

    @Override
    public BuffVector3f simpleMul(Vector3 other) {
        Tuple3_Float _other = TupleUtils.toTuple3_Float(other);

        return new BuffVector3f(getX() * _other.getX(), getY() * _other.getY(), getZ() * _other.getZ());
    }

    @Override
    public BuffVector3f simpleDiv(Vector3 other) {
        Tuple3_Float _other = TupleUtils.toTuple3_Float(other);

        return new BuffVector3f(getX() / _other.getX(), getY() / _other.getY(), getZ() / _other.getZ());
    }

    @Override
    public BuffVector3f mul(double v) {
        return new BuffVector3f((float)(getX() * v), (float)(getY() * v), (float)(getZ() * v));
    }

    @Override
    public BuffVector3f div(double v) {
        if (DoubleUtils.epsilonZero(v)) {
            throw new ArithmeticError("divided by zero");
        }
        return new BuffVector3f((float)(getX() / v), (float)(getY() / v), (float)(getZ() / v));
    }

    @Override
    public BuffVector3f neg() {
        return new BuffVector3f(- getX(), - getY(), - getZ());
    }

    @Override
    public BuffVector3f abs() {
        return new BuffVector3f(Math.abs(getX()), Math.abs(getY()), Math.abs(getZ()));
    }

    @Override
    public BuffVector3f lerp(Vector3 other, double alpha) {
        return lineal(other, 1 - alpha, alpha);
    }

    @Override
    public double invLerp(Vector3 other, Vector3 vLerp) {
        Tuple3_Float _other = TupleUtils.toTuple3_Float(other);
        Tuple3_Float _vLerp = TupleUtils.toTuple3_Float(vLerp);

        double x1 = _other.getX() - getX();
        double y1 = _other.getY() - getY();
        double z1 = _other.getZ() - getZ();
        double x2 = _vLerp.getX() - getX();
        double y2 = _vLerp.getY() - getY();
        double z2 = _vLerp.getZ() - getZ();
        return (x1 * x2 + y1 * y2 + z1 * z2) / Math.sqrt(x1 * x1 + y1 * y1 + z1 * z1);
    }

    @Override
    public BuffVector3f lineal(Vector3 other, double alpha, double beta) {
        Tuple3_Float _other = TupleUtils.toTuple3_Float(other);

        return new BuffVector3f((float)(alpha * getX() + beta * _other.getX()),
                                (float)(alpha * getY() + beta * _other.getY()),
                                (float)(alpha * getZ() + beta * _other.getZ()));
    }

    @Override
    public double dot(Vector3 other) {
        Tuple3_Float _other = TupleUtils.toTuple3_Float(other);

        return getX() * _other.getX() + getY() * _other.getY() + getZ() * _other.getZ();
    }

    @Override
    public BuffVector3f cross(Vector3 other) {
        Tuple3_Float _other = TupleUtils.toTuple3_Float(other);

        return new BuffVector3f((getY() * _other.getZ()) - (getZ() * _other.getY()),
                                (getZ() * _other.getX()) - (getX() * _other.getZ()),
                                (getX() * _other.getY()) - (getY() * _other.getX()));
    }

    @Override
    public Vector3 vectorProjection(Vector3 where) {
        double r = dot(where) / where.getLengthCuad();
        return where.mul(r);
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Object">
    @Override
    public BuffVector3f clone() throws CloneNotSupportedException {
        return (BuffVector3f)super.clone();
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="private">
    private static BuffVector3f getUnit(int index) {
        return new BuffVector3f((float)((index == 0) ? 1 : 0),
                                (float)((index == 1) ? 1 : 0),
                                (float)((index == 2) ? 1 : 0));
    }
//</editor-fold>
}
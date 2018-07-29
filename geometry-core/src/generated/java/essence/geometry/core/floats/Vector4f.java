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
import essence.geometry.core.Vector4;
import essence.geometry.core.DoubleUtils;

import static essence.geometry.core.FloatUtils.EPSILON;

/**
 * Basic implementation of a 4 dimension vector.
 */
public class Vector4f extends Tuple4f implements Vector4 {

    /**
     * Empty constructor.
     */
    public Vector4f() {
    }

    /**
     * This constructor sets the components of this vector.
     *
     * @param x Value of the component X.
     * @param y Value of the component Y.
     * @param z Value of the component Z.
     * @param w Value of the component W.
     */
    public Vector4f(float x, float y, float z, float w) {
        super(x, y, z, w);
    }

    /**
     * Copy constructor.
     *
     * @param tuple Tuple.
     */
    public Vector4f(Tuple tuple) {
        tuple.getInto(this);
    }

    /**
     * Zero vector.
     *
     * @return Vector zero.
     */
    public static final Vector4f getZero() {
        return new Vector4f((float)0, (float)0, (float)0, (float)0);
    }

    /**
     * One vector.
     *
     * @return Vector one.
     */
    public static final Vector4f getOne() {
        return new Vector4f((float)1, (float)1, (float)1, (float)1);
    }


    /**
     * Unit vector: X.
     *
     * @return Vector unit.
     */
    public static final Vector4f getUX() {
        return getUnit(0);
    }

    /**
     * Unit vector: Y.
     *
     * @return Vector unit.
     */
    public static final Vector4f getUY() {
        return getUnit(1);
    }

    /**
     * Unit vector: Z.
     *
     * @return Vector unit.
     */
    public static final Vector4f getUZ() {
        return getUnit(2);
    }

    /**
     * Unit vector: W.
     *
     * @return Vector unit.
     */
    public static final Vector4f getUW() {
        return getUnit(3);
    }
//<editor-fold defaultstate="collapsed" desc="Vector4">
    @Override
    public boolean isUnit() {
        return isUnit(EPSILON);
    }

    @Override
    public boolean isUnit(double epsilon) {
        return DoubleUtils.epsilonEquals(getLength(), 1, epsilon);
    }

    @Override
    public Vector4f getUnit() {
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
    public double getLengthL1() {
        return Math.abs(getX())
               + Math.abs(getY())
               + Math.abs(getZ())
               + Math.abs(getW());
    }

    @Override
    public Vector4f add(Vector4 other) {
        return clone().addAndSet(other);
    }

    public Vector4f add(Vector4f other) {
        return clone().addAndSet(other);
    }

    @Override
    public Vector4f sub(Vector4 other) {
        return clone().subAndSet(other);
    }

    public Vector4f sub(Vector4f other) {
        return clone().subAndSet(other);
    }

    @Override
    public Vector4f simpleMul(Vector4 other) {
        return clone().simpleMulAndSet(other);
    }

    public Vector4f simpleMul(Vector4f other) {
        return clone().simpleMulAndSet(other);
    }

    @Override
    public Vector4f simpleDiv(Vector4 other) {
        return clone().simpleDivAndSet(other);
    }

    public Vector4f simpleDiv(Vector4f other) {
        return clone().simpleDivAndSet(other);
    }

    @Override
    public Vector4f mul(double v) {
        return clone().mulAndSet(v);
    }

    @Override
    public Vector4f div(double v) {
        return clone().divAndSet(v);
    }

    @Override
    public Vector4f neg() {
        return clone().negAndSet();
    }

    @Override
    public Vector4f abs() {
        return clone().absAndSet();
    }

    @Override
    public Vector4f lerp(Vector4 other, double alpha) {
        return clone().lerpAndSet(other, alpha);
    }

    public Vector4f lerp(Vector4f other, double alpha) {
        return clone().lerpAndSet(other, alpha);
    }

    @Override
    public double invLerp(Vector4 other, Vector4 vLerp) {
        Tuple4_Float _other = toTuple(other);
        Tuple4_Float _vLerp = toTuple(vLerp);

        double x1 = _other.getX() - getX();
        double y1 = _other.getY() - getY();
        double z1 = _other.getZ() - getZ();
        double w1 = _other.getW() - getW();
        double x2 = _vLerp.getX() - getX();
        double y2 = _vLerp.getY() - getY();
        double z2 = _vLerp.getZ() - getZ();
        double w2 = _vLerp.getW() - getW();
        return (x1 * x2 + y1 * y2 + z1 * z2 + w1 * w2) / Math.sqrt(x1 * x1 + y1 * y1 + z1 * z1 + w1 * w1);
    }

    public double invLerp(Vector4f other, Vector4f vLerp) {
        double x1 = other.getX() - getX();
        double y1 = other.getY() - getY();
        double z1 = other.getZ() - getZ();
        double w1 = other.getW() - getW();
        double x2 = vLerp.getX() - getX();
        double y2 = vLerp.getY() - getY();
        double z2 = vLerp.getZ() - getZ();
        double w2 = vLerp.getW() - getW();
        return (x1 * x2 + y1 * y2 + z1 * z2 + w1 * w2) / Math.sqrt(x1 * x1 + y1 * y1 + z1 * z1 + w1 * w1);
    }

    @Override
    public Vector4f lineal(Vector4 other, double alpha, double beta) {
        return clone().linealAndSet(other, alpha, beta);
    }

    public Vector4f lineal(Vector4f other, double alpha, double beta) {
        return clone().linealAndSet(other, alpha, beta);
    }

    @Override
    public double dot(Vector4 other) {
        Tuple4_Float _other = toTuple(other);
        return getX() * _other.getX() + getY() * _other.getY() + getZ() * _other.getZ() + getW() * _other.getW();
    }

    public double dot(Vector4f other) {
        return getX() * other.getX() + getY() * other.getY() + getZ() * other.getZ() + getW() * other.getW();
    }

    @Override
    public Vector4f vectorProjection(Vector4 where) {
        return clone().vectorProjectionAndSet(where);
    }

    public Vector4f vectorProjection(Vector4f where) {
        return clone().vectorProjectionAndSet(where);
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Vector4">
    @Override
    public Vector4f setZero() {
        set(0, 0, 0, 0);
        return this;
    }

    @Override
    public Vector4f setUnit() {
        double len = getLength();
        if (DoubleUtils.epsilonZero(len)) {
            setZero();
        } else {
            divAndSet(len);
        }
        return this;
    }

    @Override
    public Vector4f addAndSet(Vector4 other) {
        Tuple4_Float _other = toTuple(other);

        set(getX() + _other.getX(), getY() + _other.getY(), getZ() + _other.getZ(), getW() + _other.getW());
        return this;
    }

    public Vector4f addAndSet(Vector4f other) {
        set(getX() + other.getX(), getY() + other.getY(), getZ() + other.getZ(), getW() + other.getW());
        return this;
    }

    @Override
    public Vector4f subAndSet(Vector4 other) {
        Tuple4_Float _other = toTuple(other);

        set(getX() - _other.getX(), getY() - _other.getY(), getZ() - _other.getZ(), getW() - _other.getW());
        return this;
    }

    public Vector4f subAndSet(Vector4f other) {
        set(getX() - other.getX(), getY() - other.getY(), getZ() - other.getZ(), getW() - other.getW());
        return this;
    }

    @Override
    public Vector4f simpleMulAndSet(Vector4 other) {
        Tuple4_Float _other = toTuple(other);

        set(getX() * _other.getX(), getY() * _other.getY(), getZ() * _other.getZ(), getW() * _other.getW());
        return this;
    }

    public Vector4f simpleMulAndSet(Vector4f other) {
        set(getX() * other.getX(), getY() * other.getY(), getZ() * other.getZ(), getW() * other.getW());
        return this;
    }

    @Override
    public Vector4f simpleDivAndSet(Vector4 other) {
        Tuple4_Float _other = toTuple(other);

        set(getX() / _other.getX(), getY() / _other.getY(), getZ() / _other.getZ(), getW() / _other.getW());
        return this;
    }

    public Vector4f simpleDivAndSet(Vector4f other) {
        set(getX() / other.getX(), getY() / other.getY(), getZ() / other.getZ(), getW() / other.getW());
        return this;
    }

    @Override
    public Vector4f mulAndSet(double v) {
        set((float)(getX() * v), (float)(getY() * v), (float)(getZ() * v), (float)(getW() * v));
        return this;
    }

    @Override
    public Vector4f divAndSet(double v) {
        set((float)(getX() / v), (float)(getY() / v), (float)(getZ() / v), (float)(getW() / v));
        return this;
    }

    @Override
    public Vector4f negAndSet() {
        set(- getX(), - getY(), - getZ(), - getW());
        return this;
    }

    @Override
    public Vector4f absAndSet() {
        set(Math.abs(getX()), Math.abs(getY()), Math.abs(getZ()), Math.abs(getW()));
        return this;
    }

    @Override
    public Vector4f lerpAndSet(Vector4 other, double alpha) {
        linealAndSet(other, 1 - alpha, alpha);
        return this;
    }

    public Vector4f lerpAndSet(Vector4f other, double alpha) {
        linealAndSet(other, 1 - alpha, alpha);
        return this;
    }

    @Override
    public Vector4f linealAndSet(Vector4 other, double alpha, double beta) {
        Tuple4_Float _other = toTuple(other);

        set((float)(alpha * getX() + beta * _other.getX()),
            (float)(alpha * getY() + beta * _other.getY()),
            (float)(alpha * getZ() + beta * _other.getZ()),
            (float)(alpha * getW() + beta * _other.getW()));
        return this;
    }

    public Vector4f linealAndSet(Vector4f other, double alpha, double beta) {
        set((float)(alpha * getX() + beta * other.getX()),
            (float)(alpha * getY() + beta * other.getY()),
            (float)(alpha * getZ() + beta * other.getZ()),
            (float)(alpha * getW() + beta * other.getW()));
        return this;
    }

    @Override
    public Vector4f vectorProjectionAndSet(Vector4 where) {
        double r = dot(where) / where.getLengthCuad();
        set(where);
        mulAndSet(r);
        return this;
    }

    public Vector4f vectorProjectionAndSet(Vector4f where) {
        double r = dot(where) / where.getLengthCuad();
        set(where);
        mulAndSet(r);
        return this;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Object">
    @Override
    public Vector4f clone() {
        return (Vector4f)super.clone();
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="private">
    private static Vector4f getUnit(int index) {
        return new Vector4f((float)((index == 0) ? 1 : 0),
                            (float)((index == 1) ? 1 : 0),
                            (float)((index == 2) ? 1 : 0),
                            (float)((index == 3) ? 1 : 0));
    }
//</editor-fold>
}
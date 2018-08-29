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
import essence.geometry.core.BuffVector4;
import essence.geometry.core.DoubleUtils;
import essence.util.math.ArithmeticError;

import static essence.geometry.core.FloatUtils.EPSILON;

/**
 * Basic implementation of a 4 dimension vector.
 */
public class BuffVector4f extends BuffTuple4f implements BuffVector4 {

    /**
     * Empty constructor.
     */
    public BuffVector4f() {
    }

    /**
     * This constructor sets the components of this vector.
     *
     * @param x Value of the component X.
     * @param y Value of the component Y.
     * @param z Value of the component Z.
     * @param w Value of the component W.
     */
    public BuffVector4f(float x, float y, float z, float w) {
        super(x, y, z, w);
    }

    /**
     * Copy constructor.
     *
     * @param tuple Tuple.
     */
    public BuffVector4f(Tuple tuple) {
        super(tuple);
    }

    /**
     * Copy constructor.
     *
     * @param tuple Tuple.
     */
    public BuffVector4f(Vector4f tuple) {
        super(tuple);
    }

    /**
     * Copy constructor.
     *
     * @param tuple Tuple.
     */
    public BuffVector4f(BuffVector4f tuple) {
        super(tuple);
    }

    /**
     * Zero vector.
     *
     * @return Vector zero.
     */
    public static final BuffVector4f getZero() {
        return new BuffVector4f((float)0, (float)0, (float)0, (float)0);
    }

    /**
     * One vector.
     *
     * @return Vector one.
     */
    public static final BuffVector4f getOne() {
        return new BuffVector4f((float)1, (float)1, (float)1, (float)1);
    }

    /**
     * Unit vector: X.
     *
     * @return Vector unit.
     */
    public static final BuffVector4f getUX() {
        return getUnit(0);
    }

    /**
     * Unit vector: Y.
     *
     * @return Vector unit.
     */
    public static final BuffVector4f getUY() {
        return getUnit(1);
    }

    /**
     * Unit vector: Z.
     *
     * @return Vector unit.
     */
    public static final BuffVector4f getUZ() {
        return getUnit(2);
    }

    /**
     * Unit vector: W.
     *
     * @return Vector unit.
     */
    public static final BuffVector4f getUW() {
        return getUnit(3);
    }

//<editor-fold defaultstate="collapsed" desc="BuffVector4">
    @Override
    public BuffVector4f setZero() {
        set(0, 0, 0, 0);
        return this;
    }

    @Override
    public BuffVector4f setUnit() {
        double len = getLength();
        if (DoubleUtils.epsilonZero(len)) {
            throw new ArithmeticException("Divided by 0");
        }
        return divAndSet(len);
    }

    @Override
    public BuffVector4f addAndSet(Vector4 other) {
        if (other instanceof Vector4f) {
            return addAndSet((Vector4f)other);
        } else if (other instanceof BuffVector4f) {
            return addAndSet((BuffVector4f)other);
        } else {
            return addAndSet(new Vector4f(other));
        }
    }

    public BuffVector4f addAndSet(Vector4f other) {
        set((float)(getX() + other.getX()), (float)(getY() + other.getY()), (float)(getZ() + other.getZ()), (float)(getW() + other.getW()));
        return this;
    }

    public BuffVector4f addAndSet(BuffVector4f other) {
        set((float)(getX() + other.getX()), (float)(getY() + other.getY()), (float)(getZ() + other.getZ()), (float)(getW() + other.getW()));
        return this;
    }

    @Override
    public BuffVector4f subAndSet(Vector4 other) {
        if (other instanceof Vector4f) {
            return subAndSet((Vector4f)other);
        } else if (other instanceof BuffVector4f) {
            return subAndSet((BuffVector4f)other);
        } else {
            return subAndSet(new Vector4f(other));
        }
    }

    public BuffVector4f subAndSet(Vector4f other) {
        set((float)(getX() - other.getX()), (float)(getY() - other.getY()), (float)(getZ() - other.getZ()), (float)(getW() - other.getW()));
        return this;
    }

    public BuffVector4f subAndSet(BuffVector4f other) {
        set((float)(getX() - other.getX()), (float)(getY() - other.getY()), (float)(getZ() - other.getZ()), (float)(getW() - other.getW()));
        return this;
    }

    @Override
    public BuffVector4f simpleMulAndSet(Vector4 other) {
        if (other instanceof Vector4f) {
            return simpleMulAndSet((Vector4f)other);
        } else if (other instanceof BuffVector4f) {
            return simpleMulAndSet((BuffVector4f)other);
        } else {
            return simpleMulAndSet(new Vector4f(other));
        }
    }

    public BuffVector4f simpleMulAndSet(Vector4f other) {
        set((float)(getX() * other.getX()), (float)(getY() * other.getY()), (float)(getZ() * other.getZ()), (float)(getW() * other.getW()));
        return this;
    }

    public BuffVector4f simpleMulAndSet(BuffVector4f other) {
        set((float)(getX() * other.getX()), (float)(getY() * other.getY()), (float)(getZ() * other.getZ()), (float)(getW() * other.getW()));
        return this;
    }

    @Override
    public BuffVector4f simpleDivAndSet(Vector4 other) {
        if (other instanceof Vector4f) {
            return simpleDivAndSet((Vector4f)other);
        } else if (other instanceof BuffVector4f) {
            return simpleDivAndSet((BuffVector4f)other);
        } else {
            return simpleDivAndSet(new Vector4f(other));
        }
    }

    public BuffVector4f simpleDivAndSet(Vector4f other) {
        set((float)(getX() / other.getX()), (float)(getY() / other.getY()), (float)(getZ() / other.getZ()), (float)(getW() / other.getW()));
        return this;
    }

    public BuffVector4f simpleDivAndSet(BuffVector4f other) {
        set((float)(getX() / other.getX()), (float)(getY() / other.getY()), (float)(getZ() / other.getZ()), (float)(getW() / other.getW()));
        return this;
    }

    @Override
    public BuffVector4f mulAndSet(double v) {
        set((float)(getX() * v), (float)(getY() * v), (float)(getZ() * v), (float)(getW() * v));
        return this;
    }

    @Override
    public BuffVector4f divAndSet(double v) {
        set((float)(getX() / v), (float)(getY() / v), (float)(getZ() / v), (float)(getW() / v));
        return this;
    }

    @Override
    public BuffVector4f negAndSet() {
        set((float)(- getX()), (float)(- getY()), (float)(- getZ()), (float)(- getW()));
        return this;
    }

    @Override
    public BuffVector4f absAndSet() {
        set((float)Math.abs(getX()), (float)Math.abs(getY()), (float)Math.abs(getZ()), (float)Math.abs(getW()));
        return this;
    }

    @Override
    public BuffVector4f lerpAndSet(Vector4 other, double alpha) {
        if (other instanceof Vector4f) {
            return lerpAndSet((Vector4f)other, alpha);
        } else if (other instanceof BuffVector4f) {
            return lerpAndSet((BuffVector4f)other, alpha);
        } else {
            return lerpAndSet(new Vector4f(other), alpha);
        }
    }

    public BuffVector4f lerpAndSet(Vector4f other, double alpha) {
        linealAndSet(other, 1 - alpha, alpha);
        return this;
    }

    public BuffVector4f lerpAndSet(BuffVector4f other, double alpha) {
        linealAndSet(other, 1 - alpha, alpha);
        return this;
    }

    @Override
    public BuffVector4f linealAndSet(Vector4 other, double alpha, double beta) {
        if (other instanceof Vector4f) {
            return linealAndSet((Vector4f)other, alpha, beta);
        } else if (other instanceof BuffVector4f) {
            return linealAndSet((BuffVector4f)other, alpha, beta);
        } else {
            return linealAndSet(new Vector4f(other), alpha, beta);
        }
    }

    public BuffVector4f linealAndSet(Vector4f other, double alpha, double beta) {
        set((float)(alpha * getX() + beta * other.getX()),
            (float)(alpha * getY() + beta * other.getY()),
            (float)(alpha * getZ() + beta * other.getZ()),
            (float)(alpha * getW() + beta * other.getW()));
        return this;
    }

    public BuffVector4f linealAndSet(BuffVector4f other, double alpha, double beta) {
        set((float)(alpha * getX() + beta * other.getX()),
            (float)(alpha * getY() + beta * other.getY()),
            (float)(alpha * getZ() + beta * other.getZ()),
            (float)(alpha * getW() + beta * other.getW()));
        return this;
    }

    @Override
    public BuffVector4f vectorProjectionAndSet(Vector4 where) {
        if (where instanceof Vector4f) {
            return vectorProjectionAndSet((Vector4f)where);
        } else if (where instanceof BuffVector4f) {
            return vectorProjectionAndSet((BuffVector4f)where);
        } else {
            return vectorProjectionAndSet(new Vector4f(where));
        }
    }

    public BuffVector4f vectorProjectionAndSet(Vector4f where) {
        double r = dot(where) / where.getLengthCuad();
        set((float)(where.getX() * r), (float)(where.getY() * r), (float)(where.getZ() * r), (float)(where.getW() * r));
        return this;
    }

    public BuffVector4f vectorProjectionAndSet(BuffVector4f where) {
        double r = dot(where) / where.getLengthCuad();
        set((float)(where.getX() * r), (float)(where.getY() * r), (float)(where.getZ() * r), (float)(where.getW() * r));
        return this;
    }
//</editor-fold>

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
    public BuffVector4f getUnit() {
        double len = getLength();
        if (DoubleUtils.epsilonZero(len)) {
            throw new ArithmeticException("Divided by 0");
        }
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
        if (getW() < 0) {
            v |= p;
            p <<= 1;
        }
        return v;
    }

    @Override
    public double getLength() {
        return Math.sqrt(getLengthCuad());
    }

    @Override
    public double getLengthCuad() {
        return dot(this);
    }

    @Override
    public double getLengthL1() {
        return Math.abs(getX())
               + Math.abs(getY())
               + Math.abs(getZ())
               + Math.abs(getW());
    }

    @Override
    public BuffVector4f add(Vector4 other) {
        if (other instanceof Vector4f) {
            return add((Vector4f)other);
        } else if (other instanceof BuffVector4f) {
            return add((BuffVector4f)other);
        } else {
            return add(new Vector4f(other));
        }
    }

    public BuffVector4f add(Vector4f other) {
        return new BuffVector4f((float)(getX() + other.getX()), (float)(getY() + other.getY()), (float)(getZ() + other.getZ()), (float)(getW() + other.getW()));
    }

    public BuffVector4f add(BuffVector4f other) {
        return new BuffVector4f((float)(getX() + other.getX()), (float)(getY() + other.getY()), (float)(getZ() + other.getZ()), (float)(getW() + other.getW()));
    }

    @Override
    public BuffVector4f sub(Vector4 other) {
        if (other instanceof Vector4f) {
            return sub((Vector4f)other);
        } else if (other instanceof BuffVector4f) {
            return sub((BuffVector4f)other);
        } else {
            return sub(new Vector4f(other));
        }
    }

    public BuffVector4f sub(Vector4f other) {
        return new BuffVector4f((float)(getX() - other.getX()), (float)(getY() - other.getY()), (float)(getZ() - other.getZ()), (float)(getW() - other.getW()));
    }

    public BuffVector4f sub(BuffVector4f other) {
        return new BuffVector4f((float)(getX() - other.getX()), (float)(getY() - other.getY()), (float)(getZ() - other.getZ()), (float)(getW() - other.getW()));
    }

    @Override
    public BuffVector4f simpleMul(Vector4 other) {
        if (other instanceof Vector4f) {
            return simpleMul((Vector4f)other);
        } else if (other instanceof BuffVector4f) {
            return simpleMul((BuffVector4f)other);
        } else {
            return simpleMul(new Vector4f(other));
        }
    }

    public BuffVector4f simpleMul(Vector4f other) {
        return new BuffVector4f((float)(getX() * other.getX()), (float)(getY() * other.getY()), (float)(getZ() * other.getZ()), (float)(getW() * other.getW()));
    }

    public BuffVector4f simpleMul(BuffVector4f other) {
        return new BuffVector4f((float)(getX() * other.getX()), (float)(getY() * other.getY()), (float)(getZ() * other.getZ()), (float)(getW() * other.getW()));
    }

    @Override
    public BuffVector4f simpleDiv(Vector4 other) {
        if (other instanceof Vector4f) {
            return simpleDiv((Vector4f)other);
        } else if (other instanceof BuffVector4f) {
            return simpleDiv((BuffVector4f)other);
        } else {
            return simpleDiv(new Vector4f(other));
        }
    }

    public BuffVector4f simpleDiv(Vector4f other) {
        return new BuffVector4f((float)(getX() / other.getX()), (float)(getY() / other.getY()), (float)(getZ() / other.getZ()), (float)(getW() / other.getW()));
    }

    public BuffVector4f simpleDiv(BuffVector4f other) {
        return new BuffVector4f((float)(getX() / other.getX()), (float)(getY() / other.getY()), (float)(getZ() / other.getZ()), (float)(getW() / other.getW()));
    }

    @Override
    public BuffVector4f mul(double v) {
        return new BuffVector4f((float)(getX() * v), (float)(getY() * v), (float)(getZ() * v), (float)(getW() * v));
    }

    @Override
    public BuffVector4f div(double v) {
        if (DoubleUtils.epsilonZero(v)) {
            throw new ArithmeticError("divided by zero");
        }
        return new BuffVector4f((float)(getX() / v), (float)(getY() / v), (float)(getZ() / v), (float)(getW() / v));
    }

    @Override
    public BuffVector4f neg() {
        return new BuffVector4f((float)(- getX()), (float)(- getY()), (float)(- getZ()), (float)(- getW()));
    }

    @Override
    public BuffVector4f abs() {
        return new BuffVector4f((float)Math.abs(getX()), (float)Math.abs(getY()), (float)Math.abs(getZ()), (float)Math.abs(getW()));
    }

    @Override
    public BuffVector4f lerp(Vector4 other, double alpha) {
        if (other instanceof Vector4f) {
            return lerp((Vector4f)other, alpha);
        } else if (other instanceof BuffVector4f) {
            return lerp((BuffVector4f)other, alpha);
        } else {
            return lerp(new Vector4f(other), alpha);
        }
    }

    public BuffVector4f lerp(Vector4f other, double alpha) {
        return lineal(other, 1 - alpha, alpha);
    }

    public BuffVector4f lerp(BuffVector4f other, double alpha) {
        return lineal(other, 1 - alpha, alpha);
    }

    @Override
    public double invLerp(Vector4 other, Vector4 lerp) {
        if (other instanceof Vector4f && lerp instanceof Vector4f) {
            return invLerp((Vector4f)other, (Vector4f)lerp);
        } else if (other instanceof BuffVector4f && lerp instanceof BuffVector4f) {
            return invLerp((BuffVector4f)other, (BuffVector4f)lerp);
        } else {
            return invLerp(new Vector4f(other), new Vector4f(other));
        }
    }

    public double invLerp(Vector4f other, Vector4f lerp) {
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

    public double invLerp(BuffVector4f other, BuffVector4f lerp) {
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

    @Override
    public BuffVector4f lineal(Vector4 other, double alpha, double beta) {
        if (other instanceof Vector4f) {
            return lineal((Vector4f)other, alpha, beta);
        } else if (other instanceof BuffVector4f) {
            return lineal((BuffVector4f)other, alpha, beta);
        } else {
            return lineal(new Vector4f(other), alpha, beta);
        }
    }

    public BuffVector4f lineal(Vector4f other, double alpha, double beta) {
        return new BuffVector4f((float)(alpha * getX() + beta * other.getX()),
                                (float)(alpha * getY() + beta * other.getY()),
                                (float)(alpha * getZ() + beta * other.getZ()),
                                (float)(alpha * getW() + beta * other.getW()));
    }

    public BuffVector4f lineal(BuffVector4f other, double alpha, double beta) {
        return new BuffVector4f((float)(alpha * getX() + beta * other.getX()),
                                (float)(alpha * getY() + beta * other.getY()),
                                (float)(alpha * getZ() + beta * other.getZ()),
                                (float)(alpha * getW() + beta * other.getW()));
    }

    @Override
    public double dot(Vector4 other) {

        if (other instanceof Vector4f) {
            return dot((Vector4f)other);
        } else if (other instanceof BuffVector4f) {
            return dot((BuffVector4f)other);
        } else {
            return dot(new Vector4f(other));
        }
    }

    public double dot(Vector4f other) {
        return getX() * other.getX() + getY() * other.getY() + getZ() * other.getZ() + getW() * other.getW();
    }

    public double dot(BuffVector4f other) {
        return getX() * other.getX() + getY() * other.getY() + getZ() * other.getZ() + getW() * other.getW();
    }

    @Override
    public double scalarProjection(Vector4 where) {

        if (where instanceof Vector4f) {
            return scalarProjection((Vector4f)where);
        } else if (where instanceof BuffVector4f) {
            return scalarProjection((BuffVector4f)where);
        } else {
            return scalarProjection(new Vector4f(where));
        }
    }

    public double scalarProjection(Vector4f where) {
        return dot(where) / where.getLength();
    }

    public double scalarProjection(BuffVector4f where) {
        return dot(where) / where.getLength();
    }

    @Override
    public Vector4 vectorProjection(Vector4 where) {

        if (where instanceof Vector4f) {
            return vectorProjection((Vector4f)where);
        } else if (where instanceof BuffVector4f) {
            return vectorProjection((BuffVector4f)where);
        } else {
            return vectorProjection(new Vector4f(where));
        }
    }

    public Vector4 vectorProjection(Vector4f where) {
        double r = dot(where) / where.getLengthCuad();
        return where.mul(r);
    }

    public Vector4 vectorProjection(BuffVector4f where) {
        double r = dot(where) / where.getLengthCuad();
        return where.mul(r);
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Object">
    @Override
    public BuffVector4f clone() throws CloneNotSupportedException {
        return (BuffVector4f)super.clone();
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="private">
    private static BuffVector4f getUnit(int index) {
        return new BuffVector4f((float)((index == 0) ? 1 : 0),
                                (float)((index == 1) ? 1 : 0),
                                (float)((index == 2) ? 1 : 0),
                                (float)((index == 3) ? 1 : 0));
    }
//</editor-fold>
}

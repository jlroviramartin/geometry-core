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
     * Copy constructor.
     *
     * @param tuple Tuple.
     */
    public BuffVector2f(Vector2f tuple) {
        super(tuple);
    }

    /**
     * Copy constructor.
     *
     * @param tuple Tuple.
     */
    public BuffVector2f(BuffVector2f tuple) {
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
            throw new ArithmeticException("Divided by 0");
        }
        return divAndSet(len);
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
        if (other instanceof Vector2f) {
            return addAndSet((Vector2f)other);
        } else if (other instanceof BuffVector2f) {
            return addAndSet((BuffVector2f)other);
        } else {
            return addAndSet(new Vector2f(other));
        }
    }

    public BuffVector2f addAndSet(Vector2f other) {
        set((float)(getX() + other.getX()), (float)(getY() + other.getY()));
        return this;
    }

    public BuffVector2f addAndSet(BuffVector2f other) {
        set((float)(getX() + other.getX()), (float)(getY() + other.getY()));
        return this;
    }

    @Override
    public BuffVector2f subAndSet(Vector2 other) {
        if (other instanceof Vector2f) {
            return subAndSet((Vector2f)other);
        } else if (other instanceof BuffVector2f) {
            return subAndSet((BuffVector2f)other);
        } else {
            return subAndSet(new Vector2f(other));
        }
    }

    public BuffVector2f subAndSet(Vector2f other) {
        set((float)(getX() - other.getX()), (float)(getY() - other.getY()));
        return this;
    }

    public BuffVector2f subAndSet(BuffVector2f other) {
        set((float)(getX() - other.getX()), (float)(getY() - other.getY()));
        return this;
    }

    @Override
    public BuffVector2f simpleMulAndSet(Vector2 other) {
        if (other instanceof Vector2f) {
            return simpleMulAndSet((Vector2f)other);
        } else if (other instanceof BuffVector2f) {
            return simpleMulAndSet((BuffVector2f)other);
        } else {
            return simpleMulAndSet(new Vector2f(other));
        }
    }

    public BuffVector2f simpleMulAndSet(Vector2f other) {
        set((float)(getX() * other.getX()), (float)(getY() * other.getY()));
        return this;
    }

    public BuffVector2f simpleMulAndSet(BuffVector2f other) {
        set((float)(getX() * other.getX()), (float)(getY() * other.getY()));
        return this;
    }

    @Override
    public BuffVector2f simpleDivAndSet(Vector2 other) {
        if (other instanceof Vector2f) {
            return simpleDivAndSet((Vector2f)other);
        } else if (other instanceof BuffVector2f) {
            return simpleDivAndSet((BuffVector2f)other);
        } else {
            return simpleDivAndSet(new Vector2f(other));
        }
    }

    public BuffVector2f simpleDivAndSet(Vector2f other) {
        set((float)(getX() / other.getX()), (float)(getY() / other.getY()));
        return this;
    }

    public BuffVector2f simpleDivAndSet(BuffVector2f other) {
        set((float)(getX() / other.getX()), (float)(getY() / other.getY()));
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
        set((float)(- getX()), (float)(- getY()));
        return this;
    }

    @Override
    public BuffVector2f absAndSet() {
        set((float)Math.abs(getX()), (float)Math.abs(getY()));
        return this;
    }

    @Override
    public BuffVector2f lerpAndSet(Vector2 other, double alpha) {
        if (other instanceof Vector2f) {
            return lerpAndSet((Vector2f)other, alpha);
        } else if (other instanceof BuffVector2f) {
            return lerpAndSet((BuffVector2f)other, alpha);
        } else {
            return lerpAndSet(new Vector2f(other), alpha);
        }
    }

    public BuffVector2f lerpAndSet(Vector2f other, double alpha) {
        linealAndSet(other, 1 - alpha, alpha);
        return this;
    }

    public BuffVector2f lerpAndSet(BuffVector2f other, double alpha) {
        linealAndSet(other, 1 - alpha, alpha);
        return this;
    }

    @Override
    public BuffVector2f linealAndSet(Vector2 other, double alpha, double beta) {
        if (other instanceof Vector2f) {
            return linealAndSet((Vector2f)other, alpha, beta);
        } else if (other instanceof BuffVector2f) {
            return linealAndSet((BuffVector2f)other, alpha, beta);
        } else {
            return linealAndSet(new Vector2f(other), alpha, beta);
        }
    }

    public BuffVector2f linealAndSet(Vector2f other, double alpha, double beta) {
        set((float)(alpha * getX() + beta * other.getX()),
            (float)(alpha * getY() + beta * other.getY()));
        return this;
    }

    public BuffVector2f linealAndSet(BuffVector2f other, double alpha, double beta) {
        set((float)(alpha * getX() + beta * other.getX()),
            (float)(alpha * getY() + beta * other.getY()));
        return this;
    }

    @Override
    public BuffVector2f vectorProjectionAndSet(Vector2 where) {
        if (where instanceof Vector2f) {
            return vectorProjectionAndSet((Vector2f)where);
        } else if (where instanceof BuffVector2f) {
            return vectorProjectionAndSet((BuffVector2f)where);
        } else {
            return vectorProjectionAndSet(new Vector2f(where));
        }
    }

    public BuffVector2f vectorProjectionAndSet(Vector2f where) {
        double r = dot(where) / where.getLengthCuad();
        set((float)(where.getX() * r), (float)(where.getY() * r));
        return this;
    }

    public BuffVector2f vectorProjectionAndSet(BuffVector2f where) {
        double r = dot(where) / where.getLengthCuad();
        set((float)(where.getX() * r), (float)(where.getY() * r));
        return this;
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
               + Math.abs(getY());
    }

    @Override
    public double getAngle() {
        return (double) Math.atan2(getY(), getX());
    }

    @Override
    public double angleTo(Vector2 other) {
        if (other instanceof Vector2f) {
            return angleTo((Vector2f)other);
        } else if (other instanceof BuffVector2f) {
            return angleTo((BuffVector2f)other);
        } else {
            return angleTo(new Vector2f(other));
        }
    }

    public double angleTo(Vector2f other) {
        // http://stackoverflow.com/questions/2150050/finding-signed-angle-between-vectors
        return Math.atan2(getX() * other.getY() - getY() * other.getX(),
                          getX() * other.getX() + getY() * other.getY());
    }

    public double angleTo(BuffVector2f other) {
        // http://stackoverflow.com/questions/2150050/finding-signed-angle-between-vectors
        return Math.atan2(getX() * other.getY() - getY() * other.getX(),
                          getX() * other.getX() + getY() * other.getY());
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
        if (other instanceof Vector2f) {
            return add((Vector2f)other);
        } else if (other instanceof BuffVector2f) {
            return add((BuffVector2f)other);
        } else {
            return add(new Vector2f(other));
        }
    }

    public BuffVector2f add(Vector2f other) {
        return new BuffVector2f((float)(getX() + other.getX()), (float)(getY() + other.getY()));
    }

    public BuffVector2f add(BuffVector2f other) {
        return new BuffVector2f((float)(getX() + other.getX()), (float)(getY() + other.getY()));
    }

    @Override
    public BuffVector2f sub(Vector2 other) {
        if (other instanceof Vector2f) {
            return sub((Vector2f)other);
        } else if (other instanceof BuffVector2f) {
            return sub((BuffVector2f)other);
        } else {
            return sub(new Vector2f(other));
        }
    }

    public BuffVector2f sub(Vector2f other) {
        return new BuffVector2f((float)(getX() - other.getX()), (float)(getY() - other.getY()));
    }

    public BuffVector2f sub(BuffVector2f other) {
        return new BuffVector2f((float)(getX() - other.getX()), (float)(getY() - other.getY()));
    }

    @Override
    public BuffVector2f simpleMul(Vector2 other) {
        if (other instanceof Vector2f) {
            return simpleMul((Vector2f)other);
        } else if (other instanceof BuffVector2f) {
            return simpleMul((BuffVector2f)other);
        } else {
            return simpleMul(new Vector2f(other));
        }
    }

    public BuffVector2f simpleMul(Vector2f other) {
        return new BuffVector2f((float)(getX() * other.getX()), (float)(getY() * other.getY()));
    }

    public BuffVector2f simpleMul(BuffVector2f other) {
        return new BuffVector2f((float)(getX() * other.getX()), (float)(getY() * other.getY()));
    }

    @Override
    public BuffVector2f simpleDiv(Vector2 other) {
        if (other instanceof Vector2f) {
            return simpleDiv((Vector2f)other);
        } else if (other instanceof BuffVector2f) {
            return simpleDiv((BuffVector2f)other);
        } else {
            return simpleDiv(new Vector2f(other));
        }
    }

    public BuffVector2f simpleDiv(Vector2f other) {
        return new BuffVector2f((float)(getX() / other.getX()), (float)(getY() / other.getY()));
    }

    public BuffVector2f simpleDiv(BuffVector2f other) {
        return new BuffVector2f((float)(getX() / other.getX()), (float)(getY() / other.getY()));
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
        return new BuffVector2f((float)(- getX()), (float)(- getY()));
    }

    @Override
    public BuffVector2f abs() {
        return new BuffVector2f((float)Math.abs(getX()), (float)Math.abs(getY()));
    }

    @Override
    public BuffVector2f lerp(Vector2 other, double alpha) {
        if (other instanceof Vector2f) {
            return lerp((Vector2f)other, alpha);
        } else if (other instanceof BuffVector2f) {
            return lerp((BuffVector2f)other, alpha);
        } else {
            return lerp(new Vector2f(other), alpha);
        }
    }

    public BuffVector2f lerp(Vector2f other, double alpha) {
        return lineal(other, 1 - alpha, alpha);
    }

    public BuffVector2f lerp(BuffVector2f other, double alpha) {
        return lineal(other, 1 - alpha, alpha);
    }

    @Override
    public double invLerp(Vector2 other, Vector2 lerp) {
        if (other instanceof Vector2f && lerp instanceof Vector2f) {
            return invLerp((Vector2f)other, (Vector2f)lerp);
        } else if (other instanceof BuffVector2f && lerp instanceof BuffVector2f) {
            return invLerp((BuffVector2f)other, (BuffVector2f)lerp);
        } else {
            return invLerp(new Vector2f(other), new Vector2f(other));
        }
    }

    public double invLerp(Vector2f other, Vector2f lerp) {
        double x1 = other.getX() - getX();
        double y1 = other.getY() - getY();
        double x2 = lerp.getX() - getX();
        double y2 = lerp.getY() - getY();
        return (x1 * x2 + y1 * y2) / Math.sqrt(x1 * x1 + y1 * y1);
    }

    public double invLerp(BuffVector2f other, BuffVector2f lerp) {
        double x1 = other.getX() - getX();
        double y1 = other.getY() - getY();
        double x2 = lerp.getX() - getX();
        double y2 = lerp.getY() - getY();
        return (x1 * x2 + y1 * y2) / Math.sqrt(x1 * x1 + y1 * y1);
    }

    @Override
    public BuffVector2f lineal(Vector2 other, double alpha, double beta) {
        if (other instanceof Vector2f) {
            return lineal((Vector2f)other, alpha, beta);
        } else if (other instanceof BuffVector2f) {
            return lineal((BuffVector2f)other, alpha, beta);
        } else {
            return lineal(new Vector2f(other), alpha, beta);
        }
    }

    public BuffVector2f lineal(Vector2f other, double alpha, double beta) {
        return new BuffVector2f((float)(alpha * getX() + beta * other.getX()),
                                (float)(alpha * getY() + beta * other.getY()));
    }

    public BuffVector2f lineal(BuffVector2f other, double alpha, double beta) {
        return new BuffVector2f((float)(alpha * getX() + beta * other.getX()),
                                (float)(alpha * getY() + beta * other.getY()));
    }

    @Override
    public double dot(Vector2 other) {
        if (other instanceof Vector2f) {
            return dot((Vector2f)other);
        } else if (other instanceof BuffVector2f) {
            return dot((BuffVector2f)other);
        } else {
            return dot(new Vector2f(other));
        }
    }
    public double dot(Vector2f other) {
        return getX() * other.getX() + getY() * other.getY();
    }

    public double dot(BuffVector2f other) {
        return getX() * other.getX() + getY() * other.getY();
    }

    @Override
    public double cross(Vector2 other) {
        if (other instanceof Vector2f) {
            return cross((Vector2f)other);
        } else if (other instanceof BuffVector2f) {
            return cross((BuffVector2f)other);
        } else {
            return cross(new Vector2f(other));
        }
    }

    public double cross(Vector2f other) {
        return getX() * other.getY() - getY() * other.getX();
    }

    public double cross(BuffVector2f other) {
        return getX() * other.getY() - getY() * other.getX();
    }

    @Override
    public double scalarProjection(Vector2 where) {
        if (where instanceof Vector2f) {
            return scalarProjection((Vector2f)where);
        } else if (where instanceof BuffVector2f) {
            return scalarProjection((BuffVector2f)where);
        } else {
            return scalarProjection(new Vector2f(where));
        }
    }

    public double scalarProjection(Vector2f where) {
        return dot(where) / where.getLength();
    }

    public double scalarProjection(BuffVector2f where) {
        return dot(where) / where.getLength();
    }

    @Override
    public Vector2 vectorProjection(Vector2 where) {
        if (where instanceof Vector2f) {
            return vectorProjection((Vector2f)where);
        } else if (where instanceof BuffVector2f) {
            return vectorProjection((BuffVector2f)where);
        } else {
            return vectorProjection(new Vector2f(where));
        }
    }

    public Vector2f vectorProjection(Vector2f where) {
        double r = dot(where) / where.getLengthCuad();
        return where.mul(r);
    }

    public BuffVector2f vectorProjection(BuffVector2f where) {
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

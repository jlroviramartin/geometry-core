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
package essence.geometry.core.integers;

import essence.geometry.core.Tuple;
import essence.geometry.core.Vector2;
import essence.geometry.core.BuffVector2;
import essence.geometry.core.DoubleUtils;
import essence.util.math.ArithmeticError;

import static essence.geometry.core.IntegerUtils.EPSILON;

/**
 * Basic implementation of a 2 dimension vector.
 */
public class BuffVector2i extends BuffTuple2i implements BuffVector2 {

    /**
     * Empty constructor.
     */
    public BuffVector2i() {
    }

    /**
     * This constructor sets the components of this vector.
     *
     * @param x Value of the component X.
     * @param y Value of the component Y.
     */
    public BuffVector2i(int x, int y) {
        super(x, y);
    }

    /**
     * Copy constructor.
     *
     * @param tuple Tuple.
     */
    public BuffVector2i(Tuple tuple) {
        super(tuple);
    }

    /**
     * Copy constructor.
     *
     * @param tuple Tuple.
     */
    public BuffVector2i(Vector2i tuple) {
        super(tuple);
    }

    /**
     * Copy constructor.
     *
     * @param tuple Tuple.
     */
    public BuffVector2i(BuffVector2i tuple) {
        super(tuple);
    }

    /**
     * Zero vector.
     *
     * @return Vector zero.
     */
    public static final BuffVector2i getZero() {
        return new BuffVector2i((int)0, (int)0);
    }

    /**
     * One vector.
     *
     * @return Vector one.
     */
    public static final BuffVector2i getOne() {
        return new BuffVector2i((int)1, (int)1);
    }

    /**
     * Unit vector: X.
     *
     * @return Vector unit.
     */
    public static final BuffVector2i getUX() {
        return getUnit(0);
    }

    /**
     * Unit vector: Y.
     *
     * @return Vector unit.
     */
    public static final BuffVector2i getUY() {
        return getUnit(1);
    }

//<editor-fold defaultstate="collapsed" desc="BuffVector2">
    @Override
    public BuffVector2i setZero() {
        set(0, 0);
        return this;
    }

    @Override
    public BuffVector2i setUnit() {
        double len = getLength();
        if (DoubleUtils.epsilonZero(len)) {
            throw new ArithmeticException("Divided by 0");
        }
        return divAndSet(len);
    }

    @Override
    public BuffVector2i setPerpLeft() {
        set(-getY(), getX());
        return this;
    }

    @Override
    public BuffVector2i setPerpRight() {
        set(getY(), -getX());
        return this;
    }

    @Override
    public BuffVector2i setRotate(double angle) {
        double s = Math.sin(angle);
        double c = Math.cos(angle);
        set((int)(getX() * c - getY() * s),
            (int)(getX() * s + getY() * c));
        return this;
    }

    @Override
    public BuffVector2i setRotateAndScale(double angle, double len) {
        double s = Math.sin(angle);
        double c = Math.cos(angle);
        set((int)(len*(getX() * c - getY() * s)),
            (int)(len*(getX() * s + getY() * c)));
        return this;
    }

    @Override
    public BuffVector2i addAndSet(Vector2 other) {
        if (other instanceof Vector2i) {
            return addAndSet((Vector2i)other);
        } else if (other instanceof BuffVector2i) {
            return addAndSet((BuffVector2i)other);
        } else {
            return addAndSet(new Vector2i(other));
        }
    }

    public BuffVector2i addAndSet(Vector2i other) {
        set((int)(getX() + other.getX()), (int)(getY() + other.getY()));
        return this;
    }

    public BuffVector2i addAndSet(BuffVector2i other) {
        set((int)(getX() + other.getX()), (int)(getY() + other.getY()));
        return this;
    }

    @Override
    public BuffVector2i subAndSet(Vector2 other) {
        if (other instanceof Vector2i) {
            return subAndSet((Vector2i)other);
        } else if (other instanceof BuffVector2i) {
            return subAndSet((BuffVector2i)other);
        } else {
            return subAndSet(new Vector2i(other));
        }
    }

    public BuffVector2i subAndSet(Vector2i other) {
        set((int)(getX() - other.getX()), (int)(getY() - other.getY()));
        return this;
    }

    public BuffVector2i subAndSet(BuffVector2i other) {
        set((int)(getX() - other.getX()), (int)(getY() - other.getY()));
        return this;
    }

    @Override
    public BuffVector2i simpleMulAndSet(Vector2 other) {
        if (other instanceof Vector2i) {
            return simpleMulAndSet((Vector2i)other);
        } else if (other instanceof BuffVector2i) {
            return simpleMulAndSet((BuffVector2i)other);
        } else {
            return simpleMulAndSet(new Vector2i(other));
        }
    }

    public BuffVector2i simpleMulAndSet(Vector2i other) {
        set((int)(getX() * other.getX()), (int)(getY() * other.getY()));
        return this;
    }

    public BuffVector2i simpleMulAndSet(BuffVector2i other) {
        set((int)(getX() * other.getX()), (int)(getY() * other.getY()));
        return this;
    }

    @Override
    public BuffVector2i simpleDivAndSet(Vector2 other) {
        if (other instanceof Vector2i) {
            return simpleDivAndSet((Vector2i)other);
        } else if (other instanceof BuffVector2i) {
            return simpleDivAndSet((BuffVector2i)other);
        } else {
            return simpleDivAndSet(new Vector2i(other));
        }
    }

    public BuffVector2i simpleDivAndSet(Vector2i other) {
        set((int)(getX() / other.getX()), (int)(getY() / other.getY()));
        return this;
    }

    public BuffVector2i simpleDivAndSet(BuffVector2i other) {
        set((int)(getX() / other.getX()), (int)(getY() / other.getY()));
        return this;
    }

    @Override
    public BuffVector2i mulAndSet(double v) {
        set((int)(getX() * v), (int)(getY() * v));
        return this;
    }

    @Override
    public BuffVector2i divAndSet(double v) {
        set((int)(getX() / v), (int)(getY() / v));
        return this;
    }

    @Override
    public BuffVector2i negAndSet() {
        set((int)(- getX()), (int)(- getY()));
        return this;
    }

    @Override
    public BuffVector2i absAndSet() {
        set((int)Math.abs(getX()), (int)Math.abs(getY()));
        return this;
    }

    @Override
    public BuffVector2i lerpAndSet(Vector2 other, double alpha) {
        if (other instanceof Vector2i) {
            return lerpAndSet((Vector2i)other, alpha);
        } else if (other instanceof BuffVector2i) {
            return lerpAndSet((BuffVector2i)other, alpha);
        } else {
            return lerpAndSet(new Vector2i(other), alpha);
        }
    }

    public BuffVector2i lerpAndSet(Vector2i other, double alpha) {
        linealAndSet(other, 1 - alpha, alpha);
        return this;
    }

    public BuffVector2i lerpAndSet(BuffVector2i other, double alpha) {
        linealAndSet(other, 1 - alpha, alpha);
        return this;
    }

    @Override
    public BuffVector2i linealAndSet(Vector2 other, double alpha, double beta) {
        if (other instanceof Vector2i) {
            return linealAndSet((Vector2i)other, alpha, beta);
        } else if (other instanceof BuffVector2i) {
            return linealAndSet((BuffVector2i)other, alpha, beta);
        } else {
            return linealAndSet(new Vector2i(other), alpha, beta);
        }
    }

    public BuffVector2i linealAndSet(Vector2i other, double alpha, double beta) {
        set((int)(alpha * getX() + beta * other.getX()),
            (int)(alpha * getY() + beta * other.getY()));
        return this;
    }

    public BuffVector2i linealAndSet(BuffVector2i other, double alpha, double beta) {
        set((int)(alpha * getX() + beta * other.getX()),
            (int)(alpha * getY() + beta * other.getY()));
        return this;
    }

    @Override
    public BuffVector2i vectorProjectionAndSet(Vector2 where) {
        if (where instanceof Vector2i) {
            return vectorProjectionAndSet((Vector2i)where);
        } else if (where instanceof BuffVector2i) {
            return vectorProjectionAndSet((BuffVector2i)where);
        } else {
            return vectorProjectionAndSet(new Vector2i(where));
        }
    }

    public BuffVector2i vectorProjectionAndSet(Vector2i where) {
        double r = dot(where) / where.getLengthCuad();
        set((int)(where.getX() * r), (int)(where.getY() * r));
        return this;
    }

    public BuffVector2i vectorProjectionAndSet(BuffVector2i where) {
        double r = dot(where) / where.getLengthCuad();
        set((int)(where.getX() * r), (int)(where.getY() * r));
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
    public BuffVector2i getUnit() {
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

        if (other instanceof Vector2i) {
            return angleTo((Vector2i)other);
        } else if (other instanceof BuffVector2i) {
            return angleTo((BuffVector2i)other);
        } else {
            return angleTo(new Vector2i(other));
        }
    }

    public double angleTo(Vector2i other) {
        // http://stackoverflow.com/questions/2150050/finding-signed-angle-between-vectors
        return Math.atan2(getX() * other.getY() - getY() * other.getX(),
                          getX() * other.getX() + getY() * other.getY());
    }

    public double angleTo(BuffVector2i other) {
        // http://stackoverflow.com/questions/2150050/finding-signed-angle-between-vectors
        return Math.atan2(getX() * other.getY() - getY() * other.getX(),
                          getX() * other.getX() + getY() * other.getY());
    }

    @Override
    public BuffVector2i getPerpLeft() {
        return new BuffVector2i(-getY(), getX());
    }

    @Override
    public BuffVector2i getPerpRight() {
        return new BuffVector2i(getY(), -getX());
    }

    @Override
    public BuffVector2i rotate(double angle) {
        double s = Math.sin(angle);
        double c = Math.cos(angle);
        return new BuffVector2i((int)(getX() * c - getY() * s),
                                (int)(getX() * s + getY() * c));
    }

    @Override
    public BuffVector2i rotateAndScale(double angle, double len) {
        double s = Math.sin(angle);
        double c = Math.cos(angle);
        return new BuffVector2i((int)(len*(getX() * c - getY() * s)),
                                (int)(len*(getX() * s + getY() * c)));
    }

    @Override
    public BuffVector2i add(Vector2 other) {
        if (other instanceof Vector2i) {
            return add((Vector2i)other);
        } else if (other instanceof BuffVector2i) {
            return add((BuffVector2i)other);
        } else {
            return add(new Vector2i(other));
        }
    }

    public BuffVector2i add(Vector2i other) {
        return new BuffVector2i((int)(getX() + other.getX()), (int)(getY() + other.getY()));
    }

    public BuffVector2i add(BuffVector2i other) {
        return new BuffVector2i((int)(getX() + other.getX()), (int)(getY() + other.getY()));
    }

    @Override
    public BuffVector2i sub(Vector2 other) {
        if (other instanceof Vector2i) {
            return sub((Vector2i)other);
        } else if (other instanceof BuffVector2i) {
            return sub((BuffVector2i)other);
        } else {
            return sub(new Vector2i(other));
        }
    }

    public BuffVector2i sub(Vector2i other) {
        return new BuffVector2i((int)(getX() - other.getX()), (int)(getY() - other.getY()));
    }

    public BuffVector2i sub(BuffVector2i other) {
        return new BuffVector2i((int)(getX() - other.getX()), (int)(getY() - other.getY()));
    }

    @Override
    public BuffVector2i simpleMul(Vector2 other) {
        if (other instanceof Vector2i) {
            return simpleMul((Vector2i)other);
        } else if (other instanceof BuffVector2i) {
            return simpleMul((BuffVector2i)other);
        } else {
            return simpleMul(new Vector2i(other));
        }
    }

    public BuffVector2i simpleMul(Vector2i other) {
        return new BuffVector2i((int)(getX() * other.getX()), (int)(getY() * other.getY()));
    }

    public BuffVector2i simpleMul(BuffVector2i other) {
        return new BuffVector2i((int)(getX() * other.getX()), (int)(getY() * other.getY()));
    }

    @Override
    public BuffVector2i simpleDiv(Vector2 other) {
        if (other instanceof Vector2i) {
            return simpleDiv((Vector2i)other);
        } else if (other instanceof BuffVector2i) {
            return simpleDiv((BuffVector2i)other);
        } else {
            return simpleDiv(new Vector2i(other));
        }
    }

    public BuffVector2i simpleDiv(Vector2i other) {
        return new BuffVector2i((int)(getX() / other.getX()), (int)(getY() / other.getY()));
    }

    public BuffVector2i simpleDiv(BuffVector2i other) {
        return new BuffVector2i((int)(getX() / other.getX()), (int)(getY() / other.getY()));
    }

    @Override
    public BuffVector2i mul(double v) {
        return new BuffVector2i((int)(getX() * v), (int)(getY() * v));
    }

    @Override
    public BuffVector2i div(double v) {
        if (DoubleUtils.epsilonZero(v)) {
            throw new ArithmeticError("divided by zero");
        }
        return new BuffVector2i((int)(getX() / v), (int)(getY() / v));
    }

    @Override
    public BuffVector2i neg() {
        return new BuffVector2i((int)(- getX()), (int)(- getY()));
    }

    @Override
    public BuffVector2i abs() {
        return new BuffVector2i((int)Math.abs(getX()), (int)Math.abs(getY()));
    }

    @Override
    public BuffVector2i lerp(Vector2 other, double alpha) {
        if (other instanceof Vector2i) {
            return lerp((Vector2i)other, alpha);
        } else if (other instanceof BuffVector2i) {
            return lerp((BuffVector2i)other, alpha);
        } else {
            return lerp(new Vector2i(other), alpha);
        }
    }

    public BuffVector2i lerp(Vector2i other, double alpha) {
        return lineal(other, 1 - alpha, alpha);
    }

    public BuffVector2i lerp(BuffVector2i other, double alpha) {
        return lineal(other, 1 - alpha, alpha);
    }

    @Override
    public double invLerp(Vector2 other, Vector2 lerp) {
        if (other instanceof Vector2i && lerp instanceof Vector2i) {
            return invLerp((Vector2i)other, (Vector2i)lerp);
        } else if (other instanceof BuffVector2i && lerp instanceof BuffVector2i) {
            return invLerp((BuffVector2i)other, (BuffVector2i)lerp);
        } else {
            return invLerp(new Vector2i(other), new Vector2i(other));
        }
    }

    public double invLerp(Vector2i other, Vector2i lerp) {
        double x1 = other.getX() - getX();
        double y1 = other.getY() - getY();
        double x2 = lerp.getX() - getX();
        double y2 = lerp.getY() - getY();
        return (x1 * x2 + y1 * y2) / Math.sqrt(x1 * x1 + y1 * y1);
    }

    public double invLerp(BuffVector2i other, BuffVector2i lerp) {
        double x1 = other.getX() - getX();
        double y1 = other.getY() - getY();
        double x2 = lerp.getX() - getX();
        double y2 = lerp.getY() - getY();
        return (x1 * x2 + y1 * y2) / Math.sqrt(x1 * x1 + y1 * y1);
    }

    @Override
    public BuffVector2i lineal(Vector2 other, double alpha, double beta) {
        if (other instanceof Vector2i) {
            return lineal((Vector2i)other, alpha, beta);
        } else if (other instanceof BuffVector2i) {
            return lineal((BuffVector2i)other, alpha, beta);
        } else {
            return lineal(new Vector2i(other), alpha, beta);
        }
    }

    public BuffVector2i lineal(Vector2i other, double alpha, double beta) {
        return new BuffVector2i((int)(alpha * getX() + beta * other.getX()),
                                (int)(alpha * getY() + beta * other.getY()));
    }

    public BuffVector2i lineal(BuffVector2i other, double alpha, double beta) {
        return new BuffVector2i((int)(alpha * getX() + beta * other.getX()),
                                (int)(alpha * getY() + beta * other.getY()));
    }

    @Override
    public double dot(Vector2 other) {

        if (other instanceof Vector2i) {
            return dot((Vector2i)other);
        } else if (other instanceof BuffVector2i) {
            return dot((BuffVector2i)other);
        } else {
            return dot(new Vector2i(other));
        }
    }

    public double dot(Vector2i other) {
        return getX() * other.getX() + getY() * other.getY();
    }

    public double dot(BuffVector2i other) {
        return getX() * other.getX() + getY() * other.getY();
    }

    @Override
    public double cross(Vector2 other) {

        if (other instanceof Vector2i) {
            return cross((Vector2i)other);
        } else if (other instanceof BuffVector2i) {
            return cross((BuffVector2i)other);
        } else {
            return cross(new Vector2i(other));
        }
    }

    public double cross(Vector2i other) {
        return getX() * other.getY() - getY() * other.getX();
    }

    public double cross(BuffVector2i other) {
        return getX() * other.getY() - getY() * other.getX();
    }

    @Override
    public double scalarProjection(Vector2 where) {

        if (where instanceof Vector2i) {
            return scalarProjection((Vector2i)where);
        } else if (where instanceof BuffVector2i) {
            return scalarProjection((BuffVector2i)where);
        } else {
            return scalarProjection(new Vector2i(where));
        }
    }

    public double scalarProjection(Vector2i where) {
        return dot(where) / where.getLength();
    }

    public double scalarProjection(BuffVector2i where) {
        return dot(where) / where.getLength();
    }

    @Override
    public Vector2 vectorProjection(Vector2 where) {

        if (where instanceof Vector2i) {
            return vectorProjection((Vector2i)where);
        } else if (where instanceof BuffVector2i) {
            return vectorProjection((BuffVector2i)where);
        } else {
            return vectorProjection(new Vector2i(where));
        }
    }

    public Vector2 vectorProjection(Vector2i where) {
        double r = dot(where) / where.getLengthCuad();
        return where.mul(r);
    }

    public Vector2 vectorProjection(BuffVector2i where) {
        double r = dot(where) / where.getLengthCuad();
        return where.mul(r);
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Object">
    @Override
    public BuffVector2i clone() throws CloneNotSupportedException {
        return (BuffVector2i)super.clone();
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="private">
    private static BuffVector2i getUnit(int index) {
        return new BuffVector2i((int)((index == 0) ? 1 : 0),
                                (int)((index == 1) ? 1 : 0));
    }
//</editor-fold>
}

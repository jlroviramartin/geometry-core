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
import essence.geometry.core.TupleUtils;
import essence.geometry.core.Vector2;
import essence.geometry.core.DoubleUtils;
import essence.util.math.ArithmeticError;

import static essence.geometry.core.IntegerUtils.EPSILON;

/**
 * Basic implementation of a 2 dimension vector.
 */
public class Vector2i extends Tuple2i implements Vector2 {

    /**
     * Empty constructor.
     */
    public Vector2i() {
    }

    /**
     * This constructor sets the components of this vector.
     *
     * @param x Value of the component X.
     * @param y Value of the component Y.
     */
    public Vector2i(int x, int y) {
        super(x, y);
    }

    /**
     * Copy constructor.
     *
     * @param tuple Tuple.
     */
    public Vector2i(Tuple tuple) {
        super(tuple);
    }

    /**
     * Zero vector.
     *
     * @return Vector zero.
     */
    public static final Vector2i getZero() {
        return new Vector2i((int)0, (int)0);
    }

    /**
     * One vector.
     *
     * @return Vector one.
     */
    public static final Vector2i getOne() {
        return new Vector2i((int)1, (int)1);
    }

    /**
     * Unit vector: X.
     *
     * @return Vector unit.
     */
    public static final Vector2i getUX() {
        return getUnit(0);
    }

    /**
     * Unit vector: Y.
     *
     * @return Vector unit.
     */
    public static final Vector2i getUY() {
        return getUnit(1);
    }

    public Vector2i add(Vector2i other) {
        return new Vector2i(getX() + other.getX(), getY() + other.getY());
    }

    public Vector2i sub(Vector2i other) {
        return new Vector2i(getX() - other.getX(), getY() - other.getY());
    }

    public Vector2i simpleMul(Vector2i other) {
        return new Vector2i(getX() * other.getX(), getY() * other.getY());
    }

    public Vector2i simpleDiv(Vector2i other) {
        return new Vector2i(getX() / other.getX(), getY() / other.getY());
    }

    public Vector2i lerp(Vector2i other, double alpha) {
        return lineal(other, 1 - alpha, alpha);
    }

    public double invLerp(Vector2i other, Vector2i vLerp) {
        double x1 = other.getX() - getX();
        double y1 = other.getY() - getY();
        double x2 = vLerp.getX() - getX();
        double y2 = vLerp.getY() - getY();
        return (x1 * x2 + y1 * y2) / Math.sqrt(x1 * x1 + y1 * y1);
    }

    public Vector2i lineal(Vector2i other, double alpha, double beta) {
        return new Vector2i((int)(alpha * getX() + beta * other.getX()),
                            (int)(alpha * getY() + beta * other.getY()));
    }

    public double dot(Vector2i other) {
        return getX() * other.getX() + getY() * other.getY();
    }

    public double cross(Vector2i other) {
        return getX() * other.getY() - getY() * other.getX();
    }

    public Vector2i vectorProjection(Vector2i where) {
        double r = dot(where) / where.getLengthCuad();
        return where.mul(r);
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
    public Vector2i getUnit() {
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
        Tuple2_Integer _other = TupleUtils.toTuple2_Integer(other);

        // http://stackoverflow.com/questions/2150050/finding-signed-angle-between-vectors
        return Math.atan2(getX() * _other.getY() - getY() * _other.getX(),
                          getX() * _other.getX() + getY() * _other.getY());
    }

    @Override
    public Vector2i getPerpLeft() {
        return new Vector2i(-getY(), getX());
    }

    @Override
    public Vector2i getPerpRight() {
        return new Vector2i(getY(), -getX());
    }

    @Override
    public Vector2i rotate(double angle) {
        double s = Math.sin(angle);
        double c = Math.cos(angle);
        return new Vector2i((int)(getX() * c - getY() * s),
                            (int)(getX() * s + getY() * c));
    }

    @Override
    public Vector2i rotateAndScale(double angle, double len) {
        double s = Math.sin(angle);
        double c = Math.cos(angle);
        return new Vector2i((int)(len*(getX() * c - getY() * s)),
                            (int)(len*(getX() * s + getY() * c)));
    }

    @Override
    public Vector2i add(Vector2 other) {
        Tuple2_Integer _other = TupleUtils.toTuple2_Integer(other);

        return new Vector2i(getX() + _other.getX(), getY() + _other.getY());
    }

    @Override
    public Vector2i sub(Vector2 other) {
        Tuple2_Integer _other = TupleUtils.toTuple2_Integer(other);

        return new Vector2i(getX() - _other.getX(), getY() - _other.getY());
    }

    @Override
    public Vector2i simpleMul(Vector2 other) {
        Tuple2_Integer _other = TupleUtils.toTuple2_Integer(other);

        return new Vector2i(getX() * _other.getX(), getY() * _other.getY());
    }

    @Override
    public Vector2i simpleDiv(Vector2 other) {
        Tuple2_Integer _other = TupleUtils.toTuple2_Integer(other);

        return new Vector2i(getX() / _other.getX(), getY() / _other.getY());
    }

    @Override
    public Vector2i mul(double v) {
        return new Vector2i((int)(getX() * v), (int)(getY() * v));
    }

    @Override
    public Vector2i div(double v) {
        if (DoubleUtils.epsilonZero(v)) {
            throw new ArithmeticError("divided by zero");
        }
        return new Vector2i((int)(getX() / v), (int)(getY() / v));
    }

    @Override
    public Vector2i neg() {
        return new Vector2i(- getX(), - getY());
    }

    @Override
    public Vector2i abs() {
        return new Vector2i(Math.abs(getX()), Math.abs(getY()));
    }

    @Override
    public Vector2i lerp(Vector2 other, double alpha) {
        return lineal(other, 1 - alpha, alpha);
    }

    @Override
    public double invLerp(Vector2 other, Vector2 vLerp) {
        Tuple2_Integer _other = TupleUtils.toTuple2_Integer(other);
        Tuple2_Integer _vLerp = TupleUtils.toTuple2_Integer(vLerp);

        double x1 = _other.getX() - getX();
        double y1 = _other.getY() - getY();
        double x2 = _vLerp.getX() - getX();
        double y2 = _vLerp.getY() - getY();
        return (x1 * x2 + y1 * y2) / Math.sqrt(x1 * x1 + y1 * y1);
    }

    @Override
    public Vector2i lineal(Vector2 other, double alpha, double beta) {
        Tuple2_Integer _other = TupleUtils.toTuple2_Integer(other);

        return new Vector2i((int)(alpha * getX() + beta * _other.getX()),
                            (int)(alpha * getY() + beta * _other.getY()));
    }

    @Override
    public double dot(Vector2 other) {
        Tuple2_Integer _other = TupleUtils.toTuple2_Integer(other);

        return getX() * _other.getX() + getY() * _other.getY();
    }

    @Override
    public double cross(Vector2 other) {
        Tuple2_Integer _other = TupleUtils.toTuple2_Integer(other);

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
    public Vector2i clone() throws CloneNotSupportedException {
        return (Vector2i)super.clone();
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="private">
    private static Vector2i getUnit(int index) {
        return new Vector2i((int)((index == 0) ? 1 : 0),
                            (int)((index == 1) ? 1 : 0));
    }
//</editor-fold>
}

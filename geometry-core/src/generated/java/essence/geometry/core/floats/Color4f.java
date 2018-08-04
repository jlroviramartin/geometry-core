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
import essence.geometry.core.Color4;
import essence.geometry.core.DoubleUtils;
import essence.util.math.ArithmeticError;

/**
 * Basic implementation of a 4 dimension color.
 */
public class Color4f extends Tuple4f implements Color4 {

    /**
     * Empty constructor.
     */
    public Color4f() {
    }

    /**
     * This constructor sets the components of this color.
     *
     * @param x Value of the component X.
     * @param y Value of the component Y.
     * @param z Value of the component Z.
     * @param w Value of the component W.
     */
    public Color4f(float x, float y, float z, float w) {
        super(x, y, z, w);
    }

    /**
     * Copy constructor.
     *
     * @param tuple Tuple.
     */
    public Color4f(Tuple tuple) {
        super(tuple);
    }

    /**
     * Zero color.
     */
    public static final Color4f getZero() {
        return new Color4f((float)0, (float)0, (float)0, (float)0);
    }

    /**
     * One color.
     */
    public static final Color4f getOne() {
        return new Color4f((float)1, (float)1, (float)1, (float)1);
    }

    public Color4f add(Color4f other) {
        return new Color4f((float)(getX() + other.getX()), (float)(getY() + other.getY()), (float)(getZ() + other.getZ()), (float)(getW() + other.getW()));
    }

    public Color4f sub(Color4f other) {
        return new Color4f((float)(getX() - other.getX()), (float)(getY() - other.getY()), (float)(getZ() - other.getZ()), (float)(getW() - other.getW()));
    }

    public Color4f simpleMul(Color4f other) {
        return new Color4f((float)(getX() * other.getX()), (float)(getY() * other.getY()), (float)(getZ() * other.getZ()), (float)(getW() * other.getW()));
    }

    public Color4f simpleDiv(Color4f other) {
        return new Color4f((float)(getX() / other.getX()), (float)(getY() / other.getY()), (float)(getZ() / other.getZ()), (float)(getW() / other.getW()));
    }

    public Color4f lerp(Color4f other, double alpha) {
        return lineal(other, 1 - alpha, alpha);
    }

    public double invLerp(Color4f other, Color4f cLerp) {
        double x1 = other.getX() - getX();
        double y1 = other.getY() - getY();
        double z1 = other.getZ() - getZ();
        double w1 = other.getW() - getW();
        double x2 = cLerp.getX() - getX();
        double y2 = cLerp.getY() - getY();
        double z2 = cLerp.getZ() - getZ();
        double w2 = cLerp.getW() - getW();
        return (x1 * x2 + y1 * y2 + z1 * z2 + w1 * w2) / Math.sqrt(x1 * x1 + y1 * y1 + z1 * z1 + w1 * w1);
    }

    public Color4f lineal(Color4f other, double alpha, double beta) {
        return new Color4f((float)(alpha * getX() + beta * other.getX()),
                           (float)(alpha * getY() + beta * other.getY()),
                           (float)(alpha * getZ() + beta * other.getZ()),
                           (float)(alpha * getW() + beta * other.getW()));
    }

//<editor-fold defaultstate="collapsed" desc="Color4">
    @Override
    public boolean isNormalized() {
        return isNormal(getX(), (float)0, (float)1) && isNormal(getY(), (float)0, (float)1) && isNormal(getZ(), (float)0, (float)1) && isNormal(getW(), (float)0, (float)1);
    }

    @Override
    public Color4f getNormalized() {
        return new Color4f(clamp(getX(), (float)0, (float)1), clamp(getY(), (float)0, (float)1), clamp(getZ(), (float)0, (float)1), clamp(getW(), (float)0, (float)1));
    }

    @Override
    public Color4f add(Color4 other) {
        Tuple4_Float _other = TupleUtils.toTuple4_Float(other);

        return new Color4f((float)(getX() + _other.getX()), (float)(getY() + _other.getY()), (float)(getZ() + _other.getZ()), (float)(getW() + _other.getW()));
    }

    @Override
    public Color4f sub(Color4 other) {
        Tuple4_Float _other = TupleUtils.toTuple4_Float(other);

        return new Color4f((float)(getX() - _other.getX()), (float)(getY() - _other.getY()), (float)(getZ() - _other.getZ()), (float)(getW() - _other.getW()));
    }

    @Override
    public Color4f simpleMul(Color4 other) {
        Tuple4_Float _other = TupleUtils.toTuple4_Float(other);

        return new Color4f((float)(getX() * _other.getX()), (float)(getY() * _other.getY()), (float)(getZ() * _other.getZ()), (float)(getW() * _other.getW()));
    }

    @Override
    public Color4f simpleDiv(Color4 other) {
        Tuple4_Float _other = TupleUtils.toTuple4_Float(other);

        return new Color4f((float)(getX() / _other.getX()), (float)(getY() / _other.getY()), (float)(getZ() / _other.getZ()), (float)(getW() / _other.getW()));
    }

    @Override
    public Color4f mul(double v) {
        return new Color4f((float)(getX() * v), (float)(getY() * v), (float)(getZ() * v), (float)(getW() * v));
    }

    @Override
    public Color4f div(double v) {
        if (DoubleUtils.epsilonZero(v)) {
            throw new ArithmeticError("divided by zero");
        }
        return new Color4f((float)(getX() / v), (float)(getY() / v), (float)(getZ() / v), (float)(getW() / v));
    }

    @Override
    public Color4f neg() {
        return new Color4f((float)(- getX()), (float)(- getY()), (float)(- getZ()), (float)(- getW()));
    }

    @Override
    public Color4f abs() {
        return new Color4f((float)Math.abs(getX()), (float)Math.abs(getY()), (float)Math.abs(getZ()), (float)Math.abs(getW()));
    }

    @Override
    public Color4f lerp(Color4 other, double alpha) {
        return lineal(other, 1 - alpha, alpha);
    }

    @Override
    public double invLerp(Color4 other, Color4 cLerp) {
        Tuple4_Float _other = TupleUtils.toTuple4_Float(other);
        Tuple4_Float _cLerp = TupleUtils.toTuple4_Float(cLerp);

        double x1 = _other.getX() - getX();
        double y1 = _other.getY() - getY();
        double z1 = _other.getZ() - getZ();
        double w1 = _other.getW() - getW();
        double x2 = _cLerp.getX() - getX();
        double y2 = _cLerp.getY() - getY();
        double z2 = _cLerp.getZ() - getZ();
        double w2 = _cLerp.getW() - getW();
        return (x1 * x2 + y1 * y2 + z1 * z2 + w1 * w2) / Math.sqrt(x1 * x1 + y1 * y1 + z1 * z1 + w1 * w1);
    }

    @Override
    public Color4f lineal(Color4 other, double alpha, double beta) {
        Tuple4_Float _other = TupleUtils.toTuple4_Float(other);

        return new Color4f((float)(alpha * getX() + beta * _other.getX()),
                           (float)(alpha * getY() + beta * _other.getY()),
                           (float)(alpha * getZ() + beta * _other.getZ()),
                           (float)(alpha * getW() + beta * _other.getW()));
    }

    private static boolean isNormal(float v, float min, float max) {
        return v >= min && v <= max;
    }

    private static float clamp(float v, float min, float max) {
        return v < min ? min : v > max ? max : v;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Object">
    @Override
    public Color4f clone() throws CloneNotSupportedException {
        return (Color4f)super.clone();
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="private">
//</editor-fold>
}

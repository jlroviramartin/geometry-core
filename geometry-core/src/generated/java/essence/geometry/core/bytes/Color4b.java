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
package essence.geometry.core.bytes;

import essence.geometry.core.Tuple;
import essence.geometry.core.Color4;
import essence.geometry.core.DoubleUtils;
import essence.util.math.ArithmeticError;

/**
 * Basic implementation of a 4 dimension color.
 */
public class Color4b extends Tuple4b implements Color4 {

    /**
     * Empty constructor.
     */
    public Color4b() {
    }

    /**
     * This constructor sets the components of this color.
     *
     * @param x Value of the component X.
     * @param y Value of the component Y.
     * @param z Value of the component Z.
     * @param w Value of the component W.
     */
    public Color4b(byte x, byte y, byte z, byte w) {
        super(x, y, z, w);
    }

    /**
     * Copy constructor.
     *
     * @param tuple Tuple.
     */
    public Color4b(Tuple tuple) {
        super(tuple);
    }

    /**
     * Zero color.
     */
    public static final Color4b getZero() {
        return new Color4b((byte)0, (byte)0, (byte)0, (byte)0);
    }

    /**
     * One color.
     */
    public static final Color4b getOne() {
        return new Color4b((byte)1, (byte)1, (byte)1, (byte)1);
    }

//<editor-fold defaultstate="collapsed" desc="Color4">
    @Override
    public boolean isNormalized() {
        return isNormal(getX(), (byte)0, (byte)255) && isNormal(getY(), (byte)0, (byte)255) && isNormal(getZ(), (byte)0, (byte)255) && isNormal(getW(), (byte)0, (byte)255);
    }

    @Override
    public Color4b getNormalized() {
        return new Color4b(clamp(getX(), (byte)0, (byte)255), clamp(getY(), (byte)0, (byte)255), clamp(getZ(), (byte)0, (byte)255), clamp(getW(), (byte)0, (byte)255));
    }

    @Override
    public Color4b add(Color4 other) {
        if (other instanceof Color4b) {
            return add((Color4b)other);
        } else if (other instanceof BuffColor4b) {
            return add((BuffColor4b)other);
        } else {
            return add(new Color4b(other));
        }
    }

    public Color4b add(Color4b other) {
        return new Color4b((byte)(getX() + other.getX()), (byte)(getY() + other.getY()), (byte)(getZ() + other.getZ()), (byte)(getW() + other.getW()));
    }

    public Color4b add(BuffColor4b other) {
        return new Color4b((byte)(getX() + other.getX()), (byte)(getY() + other.getY()), (byte)(getZ() + other.getZ()), (byte)(getW() + other.getW()));
    }

    @Override
    public Color4b sub(Color4 other) {
        if (other instanceof Color4b) {
            return sub((Color4b)other);
        } else if (other instanceof BuffColor4b) {
            return sub((BuffColor4b)other);
        } else {
            return sub(new Color4b(other));
        }
    }

    public Color4b sub(Color4b other) {
        return new Color4b((byte)(getX() - other.getX()), (byte)(getY() - other.getY()), (byte)(getZ() - other.getZ()), (byte)(getW() - other.getW()));
    }

    public Color4b sub(BuffColor4b other) {
        return new Color4b((byte)(getX() - other.getX()), (byte)(getY() - other.getY()), (byte)(getZ() - other.getZ()), (byte)(getW() - other.getW()));
    }

    @Override
    public Color4b simpleMul(Color4 other) {
        if (other instanceof Color4b) {
            return simpleMul((Color4b)other);
        } else if (other instanceof BuffColor4b) {
            return simpleMul((BuffColor4b)other);
        } else {
            return simpleMul(new Color4b(other));
        }
    }

    public Color4b simpleMul(Color4b other) {
        return new Color4b((byte)(getX() * other.getX()), (byte)(getY() * other.getY()), (byte)(getZ() * other.getZ()), (byte)(getW() * other.getW()));
    }

    public Color4b simpleMul(BuffColor4b other) {
        return new Color4b((byte)(getX() * other.getX()), (byte)(getY() * other.getY()), (byte)(getZ() * other.getZ()), (byte)(getW() * other.getW()));
    }

    @Override
    public Color4b simpleDiv(Color4 other) {
        if (other instanceof Color4b) {
            return simpleDiv((Color4b)other);
        } else if (other instanceof BuffColor4b) {
            return simpleDiv((BuffColor4b)other);
        } else {
            return simpleDiv(new Color4b(other));
        }
    }

    public Color4b simpleDiv(Color4b other) {
        return new Color4b((byte)(getX() / other.getX()), (byte)(getY() / other.getY()), (byte)(getZ() / other.getZ()), (byte)(getW() / other.getW()));
    }

    public Color4b simpleDiv(BuffColor4b other) {
        return new Color4b((byte)(getX() / other.getX()), (byte)(getY() / other.getY()), (byte)(getZ() / other.getZ()), (byte)(getW() / other.getW()));
    }

    @Override
    public Color4b mul(double v) {
        return new Color4b((byte)(getX() * v), (byte)(getY() * v), (byte)(getZ() * v), (byte)(getW() * v));
    }

    @Override
    public Color4b div(double v) {
        if (DoubleUtils.epsilonZero(v)) {
            throw new ArithmeticError("divided by zero");
        }
        return new Color4b((byte)(getX() / v), (byte)(getY() / v), (byte)(getZ() / v), (byte)(getW() / v));
    }

    @Override
    public Color4b neg() {
        return new Color4b((byte)(- getX()), (byte)(- getY()), (byte)(- getZ()), (byte)(- getW()));
    }

    @Override
    public Color4b abs() {
        return new Color4b((byte)Math.abs(getX()), (byte)Math.abs(getY()), (byte)Math.abs(getZ()), (byte)Math.abs(getW()));
    }

    @Override
    public Color4b lerp(Color4 other, double alpha) {
        if (other instanceof Color4b) {
            return lerp((Color4b)other, alpha);
        } else if (other instanceof BuffColor4b) {
            return lerp((BuffColor4b)other, alpha);
        } else {
            return lerp(new Color4b(other), alpha);
        }
    }

    public Color4b lerp(Color4b other, double alpha) {
        return lineal(other, 1 - alpha, alpha);
    }

    public Color4b lerp(BuffColor4b other, double alpha) {
        return lineal(other, 1 - alpha, alpha);
    }

    @Override
    public double invLerp(Color4 other, Color4 lerp) {
        if (other instanceof Color4b && lerp instanceof Color4b) {
            return invLerp((Color4b)other, (Color4b)lerp);
        } else if (other instanceof BuffColor4b && lerp instanceof BuffColor4b) {
            return invLerp((BuffColor4b)other, (BuffColor4b)lerp);
        } else {
            return invLerp(new Color4b(other), new Color4b(other));
        }
    }

    public double invLerp(Color4b other, Color4b lerp) {
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

    public double invLerp(BuffColor4b other, BuffColor4b lerp) {
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
    public Color4b lineal(Color4 other, double alpha, double beta) {
        if (other instanceof Color4b) {
            return lineal((Color4b)other, alpha, beta);
        } else if (other instanceof BuffColor4b) {
            return lineal((BuffColor4b)other, alpha, beta);
        } else {
            return lineal(new Color4b(other), alpha, beta);
        }
    }

    public Color4b lineal(Color4b other, double alpha, double beta) {
        return new Color4b((byte)(alpha * getX() + beta * other.getX()),
                           (byte)(alpha * getY() + beta * other.getY()),
                           (byte)(alpha * getZ() + beta * other.getZ()),
                           (byte)(alpha * getW() + beta * other.getW()));
    }

    public Color4b lineal(BuffColor4b other, double alpha, double beta) {
        return new Color4b((byte)(alpha * getX() + beta * other.getX()),
                           (byte)(alpha * getY() + beta * other.getY()),
                           (byte)(alpha * getZ() + beta * other.getZ()),
                           (byte)(alpha * getW() + beta * other.getW()));
    }

    private static boolean isNormal(byte v, byte min, byte max) {
        return v >= min && v <= max;
    }

    private static byte clamp(byte v, byte min, byte max) {
        return v < min ? min : v > max ? max : v;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Object">
    @Override
    public Color4b clone() throws CloneNotSupportedException {
        return (Color4b)super.clone();
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="private">
//</editor-fold>
}

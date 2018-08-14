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
import essence.geometry.core.Color3;
import essence.geometry.core.DoubleUtils;
import essence.util.math.ArithmeticError;

/**
 * Basic implementation of a 3 dimension color.
 */
public class Color3b extends Tuple3b implements Color3 {

    /**
     * Empty constructor.
     */
    public Color3b() {
    }

    /**
     * This constructor sets the components of this color.
     *
     * @param x Value of the component X.
     * @param y Value of the component Y.
     * @param z Value of the component Z.
     */
    public Color3b(byte x, byte y, byte z) {
        super(x, y, z);
    }

    /**
     * Copy constructor.
     *
     * @param tuple Tuple.
     */
    public Color3b(Tuple tuple) {
        super(tuple);
    }

    /**
     * Zero color.
     */
    public static final Color3b getZero() {
        return new Color3b((byte)0, (byte)0, (byte)0);
    }

    /**
     * One color.
     */
    public static final Color3b getOne() {
        return new Color3b((byte)1, (byte)1, (byte)1);
    }

//<editor-fold defaultstate="collapsed" desc="Color3">
    @Override
    public boolean isNormalized() {
        return isNormal(getX(), (byte)0, (byte)255) && isNormal(getY(), (byte)0, (byte)255) && isNormal(getZ(), (byte)0, (byte)255);
    }

    @Override
    public Color3b getNormalized() {
        return new Color3b(clamp(getX(), (byte)0, (byte)255), clamp(getY(), (byte)0, (byte)255), clamp(getZ(), (byte)0, (byte)255));
    }

    @Override
    public Color3b add(Color3 other) {
        if (other instanceof Color3b) {
            return add((Color3b)other);
        } else if (other instanceof BuffColor3b) {
            return add((BuffColor3b)other);
        } else {
            return add(new Color3b(other));
        }
    }

    public Color3b add(Color3b other) {
        return new Color3b((byte)(getX() + other.getX()), (byte)(getY() + other.getY()), (byte)(getZ() + other.getZ()));
    }

    public Color3b add(BuffColor3b other) {
        return new Color3b((byte)(getX() + other.getX()), (byte)(getY() + other.getY()), (byte)(getZ() + other.getZ()));
    }

    @Override
    public Color3b sub(Color3 other) {
        if (other instanceof Color3b) {
            return sub((Color3b)other);
        } else if (other instanceof BuffColor3b) {
            return sub((BuffColor3b)other);
        } else {
            return sub(new Color3b(other));
        }
    }

    public Color3b sub(Color3b other) {
        return new Color3b((byte)(getX() - other.getX()), (byte)(getY() - other.getY()), (byte)(getZ() - other.getZ()));
    }

    public Color3b sub(BuffColor3b other) {
        return new Color3b((byte)(getX() - other.getX()), (byte)(getY() - other.getY()), (byte)(getZ() - other.getZ()));
    }

    @Override
    public Color3b simpleMul(Color3 other) {
        if (other instanceof Color3b) {
            return simpleMul((Color3b)other);
        } else if (other instanceof BuffColor3b) {
            return simpleMul((BuffColor3b)other);
        } else {
            return simpleMul(new Color3b(other));
        }
    }

    public Color3b simpleMul(Color3b other) {
        return new Color3b((byte)(getX() * other.getX()), (byte)(getY() * other.getY()), (byte)(getZ() * other.getZ()));
    }

    public Color3b simpleMul(BuffColor3b other) {
        return new Color3b((byte)(getX() * other.getX()), (byte)(getY() * other.getY()), (byte)(getZ() * other.getZ()));
    }

    @Override
    public Color3b simpleDiv(Color3 other) {
        if (other instanceof Color3b) {
            return simpleDiv((Color3b)other);
        } else if (other instanceof BuffColor3b) {
            return simpleDiv((BuffColor3b)other);
        } else {
            return simpleDiv(new Color3b(other));
        }
    }

    public Color3b simpleDiv(Color3b other) {
        return new Color3b((byte)(getX() / other.getX()), (byte)(getY() / other.getY()), (byte)(getZ() / other.getZ()));
    }

    public Color3b simpleDiv(BuffColor3b other) {
        return new Color3b((byte)(getX() / other.getX()), (byte)(getY() / other.getY()), (byte)(getZ() / other.getZ()));
    }

    @Override
    public Color3b mul(double v) {
        return new Color3b((byte)(getX() * v), (byte)(getY() * v), (byte)(getZ() * v));
    }

    @Override
    public Color3b div(double v) {
        if (DoubleUtils.epsilonZero(v)) {
            throw new ArithmeticError("divided by zero");
        }
        return new Color3b((byte)(getX() / v), (byte)(getY() / v), (byte)(getZ() / v));
    }

    @Override
    public Color3b neg() {
        return new Color3b((byte)(- getX()), (byte)(- getY()), (byte)(- getZ()));
    }

    @Override
    public Color3b abs() {
        return new Color3b((byte)Math.abs(getX()), (byte)Math.abs(getY()), (byte)Math.abs(getZ()));
    }

    @Override
    public Color3b lerp(Color3 other, double alpha) {
        if (other instanceof Color3b) {
            return lerp((Color3b)other, alpha);
        } else if (other instanceof BuffColor3b) {
            return lerp((BuffColor3b)other, alpha);
        } else {
            return lerp(new Color3b(other), alpha);
        }
    }

    public Color3b lerp(Color3b other, double alpha) {
        return lineal(other, 1 - alpha, alpha);
    }

    public Color3b lerp(BuffColor3b other, double alpha) {
        return lineal(other, 1 - alpha, alpha);
    }

    @Override
    public double invLerp(Color3 other, Color3 lerp) {
        if (other instanceof Color3b && lerp instanceof Color3b) {
            return invLerp((Color3b)other, (Color3b)lerp);
        } else if (other instanceof BuffColor3b && lerp instanceof BuffColor3b) {
            return invLerp((BuffColor3b)other, (BuffColor3b)lerp);
        } else {
            return invLerp(new Color3b(other), new Color3b(other));
        }
    }

    public double invLerp(Color3b other, Color3b lerp) {
        double x1 = other.getX() - getX();
        double y1 = other.getY() - getY();
        double z1 = other.getZ() - getZ();
        double x2 = lerp.getX() - getX();
        double y2 = lerp.getY() - getY();
        double z2 = lerp.getZ() - getZ();
        return (x1 * x2 + y1 * y2 + z1 * z2) / Math.sqrt(x1 * x1 + y1 * y1 + z1 * z1);
    }

    public double invLerp(BuffColor3b other, BuffColor3b lerp) {
        double x1 = other.getX() - getX();
        double y1 = other.getY() - getY();
        double z1 = other.getZ() - getZ();
        double x2 = lerp.getX() - getX();
        double y2 = lerp.getY() - getY();
        double z2 = lerp.getZ() - getZ();
        return (x1 * x2 + y1 * y2 + z1 * z2) / Math.sqrt(x1 * x1 + y1 * y1 + z1 * z1);
    }

    @Override
    public Color3b lineal(Color3 other, double alpha, double beta) {
        if (other instanceof Color3b) {
            return lineal((Color3b)other, alpha, beta);
        } else if (other instanceof BuffColor3b) {
            return lineal((BuffColor3b)other, alpha, beta);
        } else {
            return lineal(new Color3b(other), alpha, beta);
        }
    }

    public Color3b lineal(Color3b other, double alpha, double beta) {
        return new Color3b((byte)(alpha * getX() + beta * other.getX()),
                           (byte)(alpha * getY() + beta * other.getY()),
                           (byte)(alpha * getZ() + beta * other.getZ()));
    }

    public Color3b lineal(BuffColor3b other, double alpha, double beta) {
        return new Color3b((byte)(alpha * getX() + beta * other.getX()),
                           (byte)(alpha * getY() + beta * other.getY()),
                           (byte)(alpha * getZ() + beta * other.getZ()));
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
    public Color3b clone() throws CloneNotSupportedException {
        return (Color3b)super.clone();
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="private">
//</editor-fold>
}

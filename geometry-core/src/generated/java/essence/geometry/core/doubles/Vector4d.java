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
package essence.geometry.core.doubles;

import essence.geometry.core.Tuple;
import essence.geometry.core.TupleUtils;
import essence.geometry.core.Vector4;
import essence.geometry.core.DoubleUtils;
import essence.util.math.ArithmeticError;

import static essence.geometry.core.DoubleUtils.EPSILON;

/**
 * Basic implementation of a 4 dimension vector.
 */
public class Vector4d extends Tuple4d implements Vector4 {

    /**
     * Empty constructor.
     */
    public Vector4d() {
    }

    /**
     * This constructor sets the components of this vector.
     *
     * @param x Value of the component X.
     * @param y Value of the component Y.
     * @param z Value of the component Z.
     * @param w Value of the component W.
     */
    public Vector4d(double x, double y, double z, double w) {
        super(x, y, z, w);
    }

    /**
     * Copy constructor.
     *
     * @param tuple Tuple.
     */
    public Vector4d(Tuple tuple) {
        super(tuple);
    }

    /**
     * Zero vector.
     *
     * @return Vector zero.
     */
    public static final Vector4d getZero() {
        return new Vector4d((double)0, (double)0, (double)0, (double)0);
    }

    /**
     * One vector.
     *
     * @return Vector one.
     */
    public static final Vector4d getOne() {
        return new Vector4d((double)1, (double)1, (double)1, (double)1);
    }

    /**
     * Unit vector: X.
     *
     * @return Vector unit.
     */
    public static final Vector4d getUX() {
        return getUnit(0);
    }

    /**
     * Unit vector: Y.
     *
     * @return Vector unit.
     */
    public static final Vector4d getUY() {
        return getUnit(1);
    }

    /**
     * Unit vector: Z.
     *
     * @return Vector unit.
     */
    public static final Vector4d getUZ() {
        return getUnit(2);
    }

    /**
     * Unit vector: W.
     *
     * @return Vector unit.
     */
    public static final Vector4d getUW() {
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
    public Vector4d getUnit() {
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
    public double getLengthL1() {
        return Math.abs(getX())
               + Math.abs(getY())
               + Math.abs(getZ())
               + Math.abs(getW());
    }

    @Override
    public Vector4d add(Vector4 other) {
        if (other instanceof Vector4d) {
            return add((Vector4d)other);
        } else if (other instanceof BuffVector4d) {
            return add((BuffVector4d)other);
        } else {
            return add(new Vector4d(other));
        }
    }

    public Vector4d add(Vector4d other) {
        return new Vector4d((double)(getX() + other.getX()), (double)(getY() + other.getY()), (double)(getZ() + other.getZ()), (double)(getW() + other.getW()));
    }

    public Vector4d add(BuffVector4d other) {
        return new Vector4d((double)(getX() + other.getX()), (double)(getY() + other.getY()), (double)(getZ() + other.getZ()), (double)(getW() + other.getW()));
    }

    @Override
    public Vector4d sub(Vector4 other) {
        if (other instanceof Vector4d) {
            return sub((Vector4d)other);
        } else if (other instanceof BuffVector4d) {
            return sub((BuffVector4d)other);
        } else {
            return sub(new Vector4d(other));
        }
    }

    public Vector4d sub(Vector4d other) {
        return new Vector4d((double)(getX() - other.getX()), (double)(getY() - other.getY()), (double)(getZ() - other.getZ()), (double)(getW() - other.getW()));
    }

    public Vector4d sub(BuffVector4d other) {
        return new Vector4d((double)(getX() - other.getX()), (double)(getY() - other.getY()), (double)(getZ() - other.getZ()), (double)(getW() - other.getW()));
    }

    @Override
    public Vector4d simpleMul(Vector4 other) {
        if (other instanceof Vector4d) {
            return simpleMul((Vector4d)other);
        } else if (other instanceof BuffVector4d) {
            return simpleMul((BuffVector4d)other);
        } else {
            return simpleMul(new Vector4d(other));
        }
    }

    public Vector4d simpleMul(Vector4d other) {
        return new Vector4d((double)(getX() * other.getX()), (double)(getY() * other.getY()), (double)(getZ() * other.getZ()), (double)(getW() * other.getW()));
    }

    public Vector4d simpleMul(BuffVector4d other) {
        return new Vector4d((double)(getX() * other.getX()), (double)(getY() * other.getY()), (double)(getZ() * other.getZ()), (double)(getW() * other.getW()));
    }

    @Override
    public Vector4d simpleDiv(Vector4 other) {
        if (other instanceof Vector4d) {
            return simpleDiv((Vector4d)other);
        } else if (other instanceof BuffVector4d) {
            return simpleDiv((BuffVector4d)other);
        } else {
            return simpleDiv(new Vector4d(other));
        }
    }

    public Vector4d simpleDiv(Vector4d other) {
        return new Vector4d((double)(getX() / other.getX()), (double)(getY() / other.getY()), (double)(getZ() / other.getZ()), (double)(getW() / other.getW()));
    }

    public Vector4d simpleDiv(BuffVector4d other) {
        return new Vector4d((double)(getX() / other.getX()), (double)(getY() / other.getY()), (double)(getZ() / other.getZ()), (double)(getW() / other.getW()));
    }

    @Override
    public Vector4d mul(double v) {
        return new Vector4d((double)(getX() * v), (double)(getY() * v), (double)(getZ() * v), (double)(getW() * v));
    }

    @Override
    public Vector4d div(double v) {
        if (DoubleUtils.epsilonZero(v)) {
            throw new ArithmeticError("divided by zero");
        }
        return new Vector4d((double)(getX() / v), (double)(getY() / v), (double)(getZ() / v), (double)(getW() / v));
    }

    @Override
    public Vector4d neg() {
        return new Vector4d((double)(- getX()), (double)(- getY()), (double)(- getZ()), (double)(- getW()));
    }

    @Override
    public Vector4d abs() {
        return new Vector4d((double)Math.abs(getX()), (double)Math.abs(getY()), (double)Math.abs(getZ()), (double)Math.abs(getW()));
    }

    @Override
    public Vector4d lerp(Vector4 other, double alpha) {
        if (other instanceof Vector4d) {
            return lerp((Vector4d)other, alpha);
        } else if (other instanceof BuffVector4d) {
            return lerp((BuffVector4d)other, alpha);
        } else {
            return lerp(new Vector4d(other), alpha);
        }
    }

    public Vector4d lerp(Vector4d other, double alpha) {
        return lineal(other, 1 - alpha, alpha);
    }

    public Vector4d lerp(BuffVector4d other, double alpha) {
        return lineal(other, 1 - alpha, alpha);
    }

    @Override
    public double invLerp(Vector4 other, Vector4 vLerp) {
        if (other instanceof Vector4d && vLerp instanceof Vector4d) {
            return invLerp((Vector4d)other, (Vector4d)vLerp);
        } else if (other instanceof BuffVector4d && vLerp instanceof BuffVector4d) {
            return invLerp((BuffVector4d)other, (BuffVector4d)vLerp);
        } else {
            return invLerp(new Vector4d(other), new Vector4d(vLerp));
        }
    }

    public double invLerp(Vector4d other, Vector4d vLerp) {
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

    public double invLerp(BuffVector4d other, BuffVector4d vLerp) {
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
    public Vector4d lineal(Vector4 other, double alpha, double beta) {
        if (other instanceof Vector4d) {
            return lineal((Vector4d)other, alpha, beta);
        } else if (other instanceof BuffVector4d) {
            return lineal((BuffVector4d)other, alpha, beta);
        } else {
            return lineal(new Vector4d(other), alpha, beta);
        }
    }

    public Vector4d lineal(Vector4d other, double alpha, double beta) {
        return new Vector4d((double)(alpha * getX() + beta * other.getX()),
                            (double)(alpha * getY() + beta * other.getY()),
                            (double)(alpha * getZ() + beta * other.getZ()),
                            (double)(alpha * getW() + beta * other.getW()));
    }

    public Vector4d lineal(BuffVector4d other, double alpha, double beta) {
        return new Vector4d((double)(alpha * getX() + beta * other.getX()),
                            (double)(alpha * getY() + beta * other.getY()),
                            (double)(alpha * getZ() + beta * other.getZ()),
                            (double)(alpha * getW() + beta * other.getW()));
    }

    @Override
    public double dot(Vector4 other) {
        if (other instanceof Vector4d) {
            return dot((Vector4d)other);
        } else if (other instanceof BuffVector4d) {
            return dot((BuffVector4d)other);
        } else {
            return dot(new Vector4d(other));
        }
    }
    public double dot(Vector4d other) {
        return getX() * other.getX() + getY() * other.getY() + getZ() * other.getZ() + getW() * other.getW();
    }

    public double dot(BuffVector4d other) {
        return getX() * other.getX() + getY() * other.getY() + getZ() * other.getZ() + getW() * other.getW();
    }

    @Override
    public Vector4 vectorProjection(Vector4 where) {
        if (where instanceof Vector4d) {
            return vectorProjection((Vector4d)where);
        } else if (where instanceof BuffVector4d) {
            return vectorProjection((BuffVector4d)where);
        } else {
            return vectorProjection(new Vector4d(where));
        }
    }

    public Vector4d vectorProjection(Vector4d where) {
        double r = dot(where) / where.getLengthCuad();
        return where.mul(r);
    }

    public BuffVector4d vectorProjection(BuffVector4d where) {
        double r = dot(where) / where.getLengthCuad();
        return where.mul(r);
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Object">
    @Override
    public Vector4d clone() throws CloneNotSupportedException {
        return (Vector4d)super.clone();
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="private">
    private static Vector4d getUnit(int index) {
        return new Vector4d((double)((index == 0) ? 1 : 0),
                            (double)((index == 1) ? 1 : 0),
                            (double)((index == 2) ? 1 : 0),
                            (double)((index == 3) ? 1 : 0));
    }
//</editor-fold>
}

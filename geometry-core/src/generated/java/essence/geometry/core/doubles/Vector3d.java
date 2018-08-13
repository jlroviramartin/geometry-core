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
import essence.geometry.core.Vector3;
import essence.geometry.core.DoubleUtils;
import essence.util.math.ArithmeticError;

import static essence.geometry.core.DoubleUtils.EPSILON;

/**
 * Basic implementation of a 3 dimension vector.
 */
public class Vector3d extends Tuple3d implements Vector3 {

    /**
     * Empty constructor.
     */
    public Vector3d() {
    }

    /**
     * This constructor sets the components of this vector.
     *
     * @param x Value of the component X.
     * @param y Value of the component Y.
     * @param z Value of the component Z.
     */
    public Vector3d(double x, double y, double z) {
        super(x, y, z);
    }

    /**
     * Copy constructor.
     *
     * @param tuple Tuple.
     */
    public Vector3d(Tuple tuple) {
        super(tuple);
    }

    /**
     * Zero vector.
     *
     * @return Vector zero.
     */
    public static final Vector3d getZero() {
        return new Vector3d((double)0, (double)0, (double)0);
    }

    /**
     * One vector.
     *
     * @return Vector one.
     */
    public static final Vector3d getOne() {
        return new Vector3d((double)1, (double)1, (double)1);
    }

    /**
     * Unit vector: X.
     *
     * @return Vector unit.
     */
    public static final Vector3d getUX() {
        return getUnit(0);
    }

    /**
     * Unit vector: Y.
     *
     * @return Vector unit.
     */
    public static final Vector3d getUY() {
        return getUnit(1);
    }

    /**
     * Unit vector: Z.
     *
     * @return Vector unit.
     */
    public static final Vector3d getUZ() {
        return getUnit(2);
    }

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
    public Vector3d getUnit() {
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
        return v;
    }

    @Override
    public double getLengthL1() {
        return Math.abs(getX())
               + Math.abs(getY())
               + Math.abs(getZ());
    }

    @Override
    public Vector3d add(Vector3 other) {
        if (other instanceof Vector3d) {
            return add((Vector3d)other);
        } else if (other instanceof BuffVector3d) {
            return add((BuffVector3d)other);
        } else {
            return add(new Vector3d(other));
        }
    }

    public Vector3d add(Vector3d other) {
        return new Vector3d((double)(getX() + other.getX()), (double)(getY() + other.getY()), (double)(getZ() + other.getZ()));
    }

    public Vector3d add(BuffVector3d other) {
        return new Vector3d((double)(getX() + other.getX()), (double)(getY() + other.getY()), (double)(getZ() + other.getZ()));
    }

    @Override
    public Vector3d sub(Vector3 other) {
        if (other instanceof Vector3d) {
            return sub((Vector3d)other);
        } else if (other instanceof BuffVector3d) {
            return sub((BuffVector3d)other);
        } else {
            return sub(new Vector3d(other));
        }
    }

    public Vector3d sub(Vector3d other) {
        return new Vector3d((double)(getX() - other.getX()), (double)(getY() - other.getY()), (double)(getZ() - other.getZ()));
    }

    public Vector3d sub(BuffVector3d other) {
        return new Vector3d((double)(getX() - other.getX()), (double)(getY() - other.getY()), (double)(getZ() - other.getZ()));
    }

    @Override
    public Vector3d simpleMul(Vector3 other) {
        if (other instanceof Vector3d) {
            return simpleMul((Vector3d)other);
        } else if (other instanceof BuffVector3d) {
            return simpleMul((BuffVector3d)other);
        } else {
            return simpleMul(new Vector3d(other));
        }
    }

    public Vector3d simpleMul(Vector3d other) {
        return new Vector3d((double)(getX() * other.getX()), (double)(getY() * other.getY()), (double)(getZ() * other.getZ()));
    }

    public Vector3d simpleMul(BuffVector3d other) {
        return new Vector3d((double)(getX() * other.getX()), (double)(getY() * other.getY()), (double)(getZ() * other.getZ()));
    }

    @Override
    public Vector3d simpleDiv(Vector3 other) {
        if (other instanceof Vector3d) {
            return simpleDiv((Vector3d)other);
        } else if (other instanceof BuffVector3d) {
            return simpleDiv((BuffVector3d)other);
        } else {
            return simpleDiv(new Vector3d(other));
        }
    }

    public Vector3d simpleDiv(Vector3d other) {
        return new Vector3d((double)(getX() / other.getX()), (double)(getY() / other.getY()), (double)(getZ() / other.getZ()));
    }

    public Vector3d simpleDiv(BuffVector3d other) {
        return new Vector3d((double)(getX() / other.getX()), (double)(getY() / other.getY()), (double)(getZ() / other.getZ()));
    }

    @Override
    public Vector3d mul(double v) {
        return new Vector3d((double)(getX() * v), (double)(getY() * v), (double)(getZ() * v));
    }

    @Override
    public Vector3d div(double v) {
        if (DoubleUtils.epsilonZero(v)) {
            throw new ArithmeticError("divided by zero");
        }
        return new Vector3d((double)(getX() / v), (double)(getY() / v), (double)(getZ() / v));
    }

    @Override
    public Vector3d neg() {
        return new Vector3d((double)(- getX()), (double)(- getY()), (double)(- getZ()));
    }

    @Override
    public Vector3d abs() {
        return new Vector3d((double)Math.abs(getX()), (double)Math.abs(getY()), (double)Math.abs(getZ()));
    }

    @Override
    public Vector3d lerp(Vector3 other, double alpha) {
        if (other instanceof Vector3d) {
            return lerp((Vector3d)other, alpha);
        } else if (other instanceof BuffVector3d) {
            return lerp((BuffVector3d)other, alpha);
        } else {
            return lerp(new Vector3d(other), alpha);
        }
    }

    public Vector3d lerp(Vector3d other, double alpha) {
        return lineal(other, 1 - alpha, alpha);
    }

    public Vector3d lerp(BuffVector3d other, double alpha) {
        return lineal(other, 1 - alpha, alpha);
    }

    @Override
    public double invLerp(Vector3 other, Vector3 vLerp) {
        if (other instanceof Vector3d && vLerp instanceof Vector3d) {
            return invLerp((Vector3d)other, (Vector3d)vLerp);
        } else if (other instanceof BuffVector3d && vLerp instanceof BuffVector3d) {
            return invLerp((BuffVector3d)other, (BuffVector3d)vLerp);
        } else {
            return invLerp(new Vector3d(other), new Vector3d(vLerp));
        }
    }

    public double invLerp(Vector3d other, Vector3d vLerp) {
        double x1 = other.getX() - getX();
        double y1 = other.getY() - getY();
        double z1 = other.getZ() - getZ();
        double x2 = vLerp.getX() - getX();
        double y2 = vLerp.getY() - getY();
        double z2 = vLerp.getZ() - getZ();
        return (x1 * x2 + y1 * y2 + z1 * z2) / Math.sqrt(x1 * x1 + y1 * y1 + z1 * z1);
    }

    public double invLerp(BuffVector3d other, BuffVector3d vLerp) {
        double x1 = other.getX() - getX();
        double y1 = other.getY() - getY();
        double z1 = other.getZ() - getZ();
        double x2 = vLerp.getX() - getX();
        double y2 = vLerp.getY() - getY();
        double z2 = vLerp.getZ() - getZ();
        return (x1 * x2 + y1 * y2 + z1 * z2) / Math.sqrt(x1 * x1 + y1 * y1 + z1 * z1);
    }

    @Override
    public Vector3d lineal(Vector3 other, double alpha, double beta) {
        if (other instanceof Vector3d) {
            return lineal((Vector3d)other, alpha, beta);
        } else if (other instanceof BuffVector3d) {
            return lineal((BuffVector3d)other, alpha, beta);
        } else {
            return lineal(new Vector3d(other), alpha, beta);
        }
    }

    public Vector3d lineal(Vector3d other, double alpha, double beta) {
        return new Vector3d((double)(alpha * getX() + beta * other.getX()),
                            (double)(alpha * getY() + beta * other.getY()),
                            (double)(alpha * getZ() + beta * other.getZ()));
    }

    public Vector3d lineal(BuffVector3d other, double alpha, double beta) {
        return new Vector3d((double)(alpha * getX() + beta * other.getX()),
                            (double)(alpha * getY() + beta * other.getY()),
                            (double)(alpha * getZ() + beta * other.getZ()));
    }

    @Override
    public double dot(Vector3 other) {
        if (other instanceof Vector3d) {
            return dot((Vector3d)other);
        } else if (other instanceof BuffVector3d) {
            return dot((BuffVector3d)other);
        } else {
            return dot(new Vector3d(other));
        }
    }
    public double dot(Vector3d other) {
        return getX() * other.getX() + getY() * other.getY() + getZ() * other.getZ();
    }

    public double dot(BuffVector3d other) {
        return getX() * other.getX() + getY() * other.getY() + getZ() * other.getZ();
    }

    @Override
    public Vector3d cross(Vector3 other) {
        if (other instanceof Vector3d) {
            return cross((Vector3d)other);
        } else if (other instanceof BuffVector3d) {
            return cross((BuffVector3d)other);
        } else {
            return cross(new Vector3d(other));
        }
    }

    public Vector3d cross(Vector3d other) {
        return new Vector3d((getY() * other.getZ()) - (getZ() * other.getY()),
                            (getZ() * other.getX()) - (getX() * other.getZ()),
                            (getX() * other.getY()) - (getY() * other.getX()));
    }

    public Vector3d cross(BuffVector3d other) {
        return new Vector3d((getY() * other.getZ()) - (getZ() * other.getY()),
                            (getZ() * other.getX()) - (getX() * other.getZ()),
                            (getX() * other.getY()) - (getY() * other.getX()));
    }

    @Override
    public Vector3 vectorProjection(Vector3 where) {
        if (where instanceof Vector3d) {
            return vectorProjection((Vector3d)where);
        } else if (where instanceof BuffVector3d) {
            return vectorProjection((BuffVector3d)where);
        } else {
            return vectorProjection(new Vector3d(where));
        }
    }

    public Vector3d vectorProjection(Vector3d where) {
        double r = dot(where) / where.getLengthCuad();
        return where.mul(r);
    }

    public BuffVector3d vectorProjection(BuffVector3d where) {
        double r = dot(where) / where.getLengthCuad();
        return where.mul(r);
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Object">
    @Override
    public Vector3d clone() throws CloneNotSupportedException {
        return (Vector3d)super.clone();
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="private">
    private static Vector3d getUnit(int index) {
        return new Vector3d((double)((index == 0) ? 1 : 0),
                            (double)((index == 1) ? 1 : 0),
                            (double)((index == 2) ? 1 : 0));
    }
//</editor-fold>
}

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
import essence.geometry.core.Vector3;
import essence.geometry.core.DoubleUtils;
import essence.util.math.ArithmeticError;

import static essence.geometry.core.FloatUtils.EPSILON;

/**
 * Basic implementation of a 3 dimension vector.
 */
public class Vector3f extends Tuple3f implements Vector3 {

    /**
     * Empty constructor.
     */
    public Vector3f() {
    }

    /**
     * This constructor sets the components of this vector.
     *
     * @param x Value of the component X.
     * @param y Value of the component Y.
     * @param z Value of the component Z.
     */
    public Vector3f(float x, float y, float z) {
        super(x, y, z);
    }

    /**
     * Copy constructor.
     *
     * @param tuple Tuple.
     */
    public Vector3f(Tuple tuple) {
        super(tuple);
    }

    /**
     * Copy constructor.
     *
     * @param tuple Tuple.
     */
    public Vector3f(Vector3f tuple) {
        super(tuple);
    }

    /**
     * Copy constructor.
     *
     * @param tuple Tuple.
     */
    public Vector3f(BuffVector3f tuple) {
        super(tuple);
    }

    /**
     * Zero vector.
     *
     * @return Vector zero.
     */
    public static final Vector3f getZero() {
        return new Vector3f((float)0, (float)0, (float)0);
    }

    /**
     * One vector.
     *
     * @return Vector one.
     */
    public static final Vector3f getOne() {
        return new Vector3f((float)1, (float)1, (float)1);
    }

    /**
     * Unit vector: X.
     *
     * @return Vector unit.
     */
    public static final Vector3f getUX() {
        return getUnit(0);
    }

    /**
     * Unit vector: Y.
     *
     * @return Vector unit.
     */
    public static final Vector3f getUY() {
        return getUnit(1);
    }

    /**
     * Unit vector: Z.
     *
     * @return Vector unit.
     */
    public static final Vector3f getUZ() {
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
    public Vector3f getUnit() {
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
    public Vector3f add(Vector3 other) {
        if (other instanceof Vector3f) {
            return add((Vector3f)other);
        } else if (other instanceof BuffVector3f) {
            return add((BuffVector3f)other);
        } else {
            return add(new Vector3f(other));
        }
    }

    public Vector3f add(Vector3f other) {
        return new Vector3f((float)(getX() + other.getX()), (float)(getY() + other.getY()), (float)(getZ() + other.getZ()));
    }

    public Vector3f add(BuffVector3f other) {
        return new Vector3f((float)(getX() + other.getX()), (float)(getY() + other.getY()), (float)(getZ() + other.getZ()));
    }

    @Override
    public Vector3f sub(Vector3 other) {
        if (other instanceof Vector3f) {
            return sub((Vector3f)other);
        } else if (other instanceof BuffVector3f) {
            return sub((BuffVector3f)other);
        } else {
            return sub(new Vector3f(other));
        }
    }

    public Vector3f sub(Vector3f other) {
        return new Vector3f((float)(getX() - other.getX()), (float)(getY() - other.getY()), (float)(getZ() - other.getZ()));
    }

    public Vector3f sub(BuffVector3f other) {
        return new Vector3f((float)(getX() - other.getX()), (float)(getY() - other.getY()), (float)(getZ() - other.getZ()));
    }

    @Override
    public Vector3f simpleMul(Vector3 other) {
        if (other instanceof Vector3f) {
            return simpleMul((Vector3f)other);
        } else if (other instanceof BuffVector3f) {
            return simpleMul((BuffVector3f)other);
        } else {
            return simpleMul(new Vector3f(other));
        }
    }

    public Vector3f simpleMul(Vector3f other) {
        return new Vector3f((float)(getX() * other.getX()), (float)(getY() * other.getY()), (float)(getZ() * other.getZ()));
    }

    public Vector3f simpleMul(BuffVector3f other) {
        return new Vector3f((float)(getX() * other.getX()), (float)(getY() * other.getY()), (float)(getZ() * other.getZ()));
    }

    @Override
    public Vector3f simpleDiv(Vector3 other) {
        if (other instanceof Vector3f) {
            return simpleDiv((Vector3f)other);
        } else if (other instanceof BuffVector3f) {
            return simpleDiv((BuffVector3f)other);
        } else {
            return simpleDiv(new Vector3f(other));
        }
    }

    public Vector3f simpleDiv(Vector3f other) {
        return new Vector3f((float)(getX() / other.getX()), (float)(getY() / other.getY()), (float)(getZ() / other.getZ()));
    }

    public Vector3f simpleDiv(BuffVector3f other) {
        return new Vector3f((float)(getX() / other.getX()), (float)(getY() / other.getY()), (float)(getZ() / other.getZ()));
    }

    @Override
    public Vector3f mul(double v) {
        return new Vector3f((float)(getX() * v), (float)(getY() * v), (float)(getZ() * v));
    }

    @Override
    public Vector3f div(double v) {
        if (DoubleUtils.epsilonZero(v)) {
            throw new ArithmeticError("divided by zero");
        }
        return new Vector3f((float)(getX() / v), (float)(getY() / v), (float)(getZ() / v));
    }

    @Override
    public Vector3f neg() {
        return new Vector3f((float)(- getX()), (float)(- getY()), (float)(- getZ()));
    }

    @Override
    public Vector3f abs() {
        return new Vector3f((float)Math.abs(getX()), (float)Math.abs(getY()), (float)Math.abs(getZ()));
    }

    @Override
    public Vector3f lerp(Vector3 other, double alpha) {
        if (other instanceof Vector3f) {
            return lerp((Vector3f)other, alpha);
        } else if (other instanceof BuffVector3f) {
            return lerp((BuffVector3f)other, alpha);
        } else {
            return lerp(new Vector3f(other), alpha);
        }
    }

    public Vector3f lerp(Vector3f other, double alpha) {
        return lineal(other, 1 - alpha, alpha);
    }

    public Vector3f lerp(BuffVector3f other, double alpha) {
        return lineal(other, 1 - alpha, alpha);
    }

    @Override
    public double invLerp(Vector3 other, Vector3 lerp) {
        if (other instanceof Vector3f && lerp instanceof Vector3f) {
            return invLerp((Vector3f)other, (Vector3f)lerp);
        } else if (other instanceof BuffVector3f && lerp instanceof BuffVector3f) {
            return invLerp((BuffVector3f)other, (BuffVector3f)lerp);
        } else {
            return invLerp(new Vector3f(other), new Vector3f(other));
        }
    }

    public double invLerp(Vector3f other, Vector3f lerp) {
        double x1 = other.getX() - getX();
        double y1 = other.getY() - getY();
        double z1 = other.getZ() - getZ();
        double x2 = lerp.getX() - getX();
        double y2 = lerp.getY() - getY();
        double z2 = lerp.getZ() - getZ();
        return (x1 * x2 + y1 * y2 + z1 * z2) / Math.sqrt(x1 * x1 + y1 * y1 + z1 * z1);
    }

    public double invLerp(BuffVector3f other, BuffVector3f lerp) {
        double x1 = other.getX() - getX();
        double y1 = other.getY() - getY();
        double z1 = other.getZ() - getZ();
        double x2 = lerp.getX() - getX();
        double y2 = lerp.getY() - getY();
        double z2 = lerp.getZ() - getZ();
        return (x1 * x2 + y1 * y2 + z1 * z2) / Math.sqrt(x1 * x1 + y1 * y1 + z1 * z1);
    }

    @Override
    public Vector3f lineal(Vector3 other, double alpha, double beta) {
        if (other instanceof Vector3f) {
            return lineal((Vector3f)other, alpha, beta);
        } else if (other instanceof BuffVector3f) {
            return lineal((BuffVector3f)other, alpha, beta);
        } else {
            return lineal(new Vector3f(other), alpha, beta);
        }
    }

    public Vector3f lineal(Vector3f other, double alpha, double beta) {
        return new Vector3f((float)(alpha * getX() + beta * other.getX()),
                            (float)(alpha * getY() + beta * other.getY()),
                            (float)(alpha * getZ() + beta * other.getZ()));
    }

    public Vector3f lineal(BuffVector3f other, double alpha, double beta) {
        return new Vector3f((float)(alpha * getX() + beta * other.getX()),
                            (float)(alpha * getY() + beta * other.getY()),
                            (float)(alpha * getZ() + beta * other.getZ()));
    }

    @Override
    public double dot(Vector3 other) {
        if (other instanceof Vector3f) {
            return dot((Vector3f)other);
        } else if (other instanceof BuffVector3f) {
            return dot((BuffVector3f)other);
        } else {
            return dot(new Vector3f(other));
        }
    }
    public double dot(Vector3f other) {
        return getX() * other.getX() + getY() * other.getY() + getZ() * other.getZ();
    }

    public double dot(BuffVector3f other) {
        return getX() * other.getX() + getY() * other.getY() + getZ() * other.getZ();
    }

    @Override
    public Vector3f cross(Vector3 other) {
        if (other instanceof Vector3f) {
            return cross((Vector3f)other);
        } else if (other instanceof BuffVector3f) {
            return cross((BuffVector3f)other);
        } else {
            return cross(new Vector3f(other));
        }
    }

    public Vector3f cross(Vector3f other) {
        return new Vector3f((getY() * other.getZ()) - (getZ() * other.getY()),
                            (getZ() * other.getX()) - (getX() * other.getZ()),
                            (getX() * other.getY()) - (getY() * other.getX()));
    }

    public Vector3f cross(BuffVector3f other) {
        return new Vector3f((getY() * other.getZ()) - (getZ() * other.getY()),
                            (getZ() * other.getX()) - (getX() * other.getZ()),
                            (getX() * other.getY()) - (getY() * other.getX()));
    }

    @Override
    public Vector3 vectorProjection(Vector3 where) {
        if (where instanceof Vector3f) {
            return vectorProjection((Vector3f)where);
        } else if (where instanceof BuffVector3f) {
            return vectorProjection((BuffVector3f)where);
        } else {
            return vectorProjection(new Vector3f(where));
        }
    }

    public Vector3f vectorProjection(Vector3f where) {
        double r = dot(where) / where.getLengthCuad();
        return where.mul(r);
    }

    public BuffVector3f vectorProjection(BuffVector3f where) {
        double r = dot(where) / where.getLengthCuad();
        return where.mul(r);
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Object">
    @Override
    public Vector3f clone() throws CloneNotSupportedException {
        return (Vector3f)super.clone();
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="private">
    private static Vector3f getUnit(int index) {
        return new Vector3f((float)((index == 0) ? 1 : 0),
                            (float)((index == 1) ? 1 : 0),
                            (float)((index == 2) ? 1 : 0));
    }
//</editor-fold>
}

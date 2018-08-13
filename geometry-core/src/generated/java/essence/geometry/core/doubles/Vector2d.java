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
import essence.geometry.core.Vector2;
import essence.geometry.core.DoubleUtils;
import essence.util.math.ArithmeticError;

import static essence.geometry.core.DoubleUtils.EPSILON;

/**
 * Basic implementation of a 2 dimension vector.
 */
public class Vector2d extends Tuple2d implements Vector2 {

    /**
     * Empty constructor.
     */
    public Vector2d() {
    }

    /**
     * This constructor sets the components of this vector.
     *
     * @param x Value of the component X.
     * @param y Value of the component Y.
     */
    public Vector2d(double x, double y) {
        super(x, y);
    }

    /**
     * Copy constructor.
     *
     * @param tuple Tuple.
     */
    public Vector2d(Tuple tuple) {
        super(tuple);
    }

    /**
     * Zero vector.
     *
     * @return Vector zero.
     */
    public static final Vector2d getZero() {
        return new Vector2d((double)0, (double)0);
    }

    /**
     * One vector.
     *
     * @return Vector one.
     */
    public static final Vector2d getOne() {
        return new Vector2d((double)1, (double)1);
    }

    /**
     * Unit vector: X.
     *
     * @return Vector unit.
     */
    public static final Vector2d getUX() {
        return getUnit(0);
    }

    /**
     * Unit vector: Y.
     *
     * @return Vector unit.
     */
    public static final Vector2d getUY() {
        return getUnit(1);
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
    public Vector2d getUnit() {
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
        if (other instanceof Vector2d) {
            return angleTo((Vector2d)other);
        } else if (other instanceof BuffVector2d) {
            return angleTo((BuffVector2d)other);
        } else {
            return angleTo(new Vector2d(other));
        }
    }

    public double angleTo(Vector2d other) {
        // http://stackoverflow.com/questions/2150050/finding-signed-angle-between-vectors
        return Math.atan2(getX() * other.getY() - getY() * other.getX(),
                          getX() * other.getX() + getY() * other.getY());
    }

    public double angleTo(BuffVector2d other) {
        // http://stackoverflow.com/questions/2150050/finding-signed-angle-between-vectors
        return Math.atan2(getX() * other.getY() - getY() * other.getX(),
                          getX() * other.getX() + getY() * other.getY());
    }

    @Override
    public Vector2d getPerpLeft() {
        return new Vector2d(-getY(), getX());
    }

    @Override
    public Vector2d getPerpRight() {
        return new Vector2d(getY(), -getX());
    }

    @Override
    public Vector2d rotate(double angle) {
        double s = Math.sin(angle);
        double c = Math.cos(angle);
        return new Vector2d((double)(getX() * c - getY() * s),
                            (double)(getX() * s + getY() * c));
    }

    @Override
    public Vector2d rotateAndScale(double angle, double len) {
        double s = Math.sin(angle);
        double c = Math.cos(angle);
        return new Vector2d((double)(len*(getX() * c - getY() * s)),
                            (double)(len*(getX() * s + getY() * c)));
    }

    @Override
    public Vector2d add(Vector2 other) {
        if (other instanceof Vector2d) {
            return add((Vector2d)other);
        } else if (other instanceof BuffVector2d) {
            return add((BuffVector2d)other);
        } else {
            return add(new Vector2d(other));
        }
    }

    public Vector2d add(Vector2d other) {
        return new Vector2d((double)(getX() + other.getX()), (double)(getY() + other.getY()));
    }

    public Vector2d add(BuffVector2d other) {
        return new Vector2d((double)(getX() + other.getX()), (double)(getY() + other.getY()));
    }

    @Override
    public Vector2d sub(Vector2 other) {
        if (other instanceof Vector2d) {
            return sub((Vector2d)other);
        } else if (other instanceof BuffVector2d) {
            return sub((BuffVector2d)other);
        } else {
            return sub(new Vector2d(other));
        }
    }

    public Vector2d sub(Vector2d other) {
        return new Vector2d((double)(getX() - other.getX()), (double)(getY() - other.getY()));
    }

    public Vector2d sub(BuffVector2d other) {
        return new Vector2d((double)(getX() - other.getX()), (double)(getY() - other.getY()));
    }

    @Override
    public Vector2d simpleMul(Vector2 other) {
        if (other instanceof Vector2d) {
            return simpleMul((Vector2d)other);
        } else if (other instanceof BuffVector2d) {
            return simpleMul((BuffVector2d)other);
        } else {
            return simpleMul(new Vector2d(other));
        }
    }

    public Vector2d simpleMul(Vector2d other) {
        return new Vector2d((double)(getX() * other.getX()), (double)(getY() * other.getY()));
    }

    public Vector2d simpleMul(BuffVector2d other) {
        return new Vector2d((double)(getX() * other.getX()), (double)(getY() * other.getY()));
    }

    @Override
    public Vector2d simpleDiv(Vector2 other) {
        if (other instanceof Vector2d) {
            return simpleDiv((Vector2d)other);
        } else if (other instanceof BuffVector2d) {
            return simpleDiv((BuffVector2d)other);
        } else {
            return simpleDiv(new Vector2d(other));
        }
    }

    public Vector2d simpleDiv(Vector2d other) {
        return new Vector2d((double)(getX() / other.getX()), (double)(getY() / other.getY()));
    }

    public Vector2d simpleDiv(BuffVector2d other) {
        return new Vector2d((double)(getX() / other.getX()), (double)(getY() / other.getY()));
    }

    @Override
    public Vector2d mul(double v) {
        return new Vector2d((double)(getX() * v), (double)(getY() * v));
    }

    @Override
    public Vector2d div(double v) {
        if (DoubleUtils.epsilonZero(v)) {
            throw new ArithmeticError("divided by zero");
        }
        return new Vector2d((double)(getX() / v), (double)(getY() / v));
    }

    @Override
    public Vector2d neg() {
        return new Vector2d((double)(- getX()), (double)(- getY()));
    }

    @Override
    public Vector2d abs() {
        return new Vector2d((double)Math.abs(getX()), (double)Math.abs(getY()));
    }

    @Override
    public Vector2d lerp(Vector2 other, double alpha) {
        if (other instanceof Vector2d) {
            return lerp((Vector2d)other, alpha);
        } else if (other instanceof BuffVector2d) {
            return lerp((BuffVector2d)other, alpha);
        } else {
            return lerp(new Vector2d(other), alpha);
        }
    }

    public Vector2d lerp(Vector2d other, double alpha) {
        return lineal(other, 1 - alpha, alpha);
    }

    public Vector2d lerp(BuffVector2d other, double alpha) {
        return lineal(other, 1 - alpha, alpha);
    }

    @Override
    public double invLerp(Vector2 other, Vector2 vLerp) {
        if (other instanceof Vector2d && vLerp instanceof Vector2d) {
            return invLerp((Vector2d)other, (Vector2d)vLerp);
        } else if (other instanceof BuffVector2d && vLerp instanceof BuffVector2d) {
            return invLerp((BuffVector2d)other, (BuffVector2d)vLerp);
        } else {
            return invLerp(new Vector2d(other), new Vector2d(vLerp));
        }
    }

    public double invLerp(Vector2d other, Vector2d vLerp) {
        double x1 = other.getX() - getX();
        double y1 = other.getY() - getY();
        double x2 = vLerp.getX() - getX();
        double y2 = vLerp.getY() - getY();
        return (x1 * x2 + y1 * y2) / Math.sqrt(x1 * x1 + y1 * y1);
    }

    public double invLerp(BuffVector2d other, BuffVector2d vLerp) {
        double x1 = other.getX() - getX();
        double y1 = other.getY() - getY();
        double x2 = vLerp.getX() - getX();
        double y2 = vLerp.getY() - getY();
        return (x1 * x2 + y1 * y2) / Math.sqrt(x1 * x1 + y1 * y1);
    }

    @Override
    public Vector2d lineal(Vector2 other, double alpha, double beta) {
        if (other instanceof Vector2d) {
            return lineal((Vector2d)other, alpha, beta);
        } else if (other instanceof BuffVector2d) {
            return lineal((BuffVector2d)other, alpha, beta);
        } else {
            return lineal(new Vector2d(other), alpha, beta);
        }
    }

    public Vector2d lineal(Vector2d other, double alpha, double beta) {
        return new Vector2d((double)(alpha * getX() + beta * other.getX()),
                            (double)(alpha * getY() + beta * other.getY()));
    }

    public Vector2d lineal(BuffVector2d other, double alpha, double beta) {
        return new Vector2d((double)(alpha * getX() + beta * other.getX()),
                            (double)(alpha * getY() + beta * other.getY()));
    }

    @Override
    public double dot(Vector2 other) {
        if (other instanceof Vector2d) {
            return dot((Vector2d)other);
        } else if (other instanceof BuffVector2d) {
            return dot((BuffVector2d)other);
        } else {
            return dot(new Vector2d(other));
        }
    }
    public double dot(Vector2d other) {
        return getX() * other.getX() + getY() * other.getY();
    }

    public double dot(BuffVector2d other) {
        return getX() * other.getX() + getY() * other.getY();
    }

    @Override
    public double cross(Vector2 other) {
        if (other instanceof Vector2d) {
            return cross((Vector2d)other);
        } else if (other instanceof BuffVector2d) {
            return cross((BuffVector2d)other);
        } else {
            return cross(new Vector2d(other));
        }
    }

    public double cross(Vector2d other) {
        return getX() * other.getY() - getY() * other.getX();
    }

    public double cross(BuffVector2d other) {
        return getX() * other.getY() - getY() * other.getX();
    }

    @Override
    public Vector2 vectorProjection(Vector2 where) {
        if (where instanceof Vector2d) {
            return vectorProjection((Vector2d)where);
        } else if (where instanceof BuffVector2d) {
            return vectorProjection((BuffVector2d)where);
        } else {
            return vectorProjection(new Vector2d(where));
        }
    }

    public Vector2d vectorProjection(Vector2d where) {
        double r = dot(where) / where.getLengthCuad();
        return where.mul(r);
    }

    public BuffVector2d vectorProjection(BuffVector2d where) {
        double r = dot(where) / where.getLengthCuad();
        return where.mul(r);
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Object">
    @Override
    public Vector2d clone() throws CloneNotSupportedException {
        return (Vector2d)super.clone();
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="private">
    private static Vector2d getUnit(int index) {
        return new Vector2d((double)((index == 0) ? 1 : 0),
                            (double)((index == 1) ? 1 : 0));
    }
//</editor-fold>
}

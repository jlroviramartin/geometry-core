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
import essence.geometry.core.Vector2;
import essence.geometry.core.Point2;
import essence.geometry.core.BuffPoint2;

/**
 * Basic implementation of a 2 dimension vector.
 */
public class BuffPoint2d extends BuffTuple2d implements BuffPoint2 {

    /**
     * Empty constructor.
     */
    public BuffPoint2d() {
    }

    /**
     * This constructor sets the components of this point.
     *
     * @param x Value of the component X.
     * @param y Value of the component Y.
     */
    public BuffPoint2d(double x, double y) {
        super(x, y);
    }

    /**
     * Copy constructor.
     *
     * @param tuple Tuple.
     */
    public BuffPoint2d(Tuple tuple) {
        super(tuple);
    }

    /**
     * Zero point.
     *
     * @return Point zero.
     */
    public static final BuffPoint2d getZero() {
        return new BuffPoint2d((double)0, (double)0);
    }

    /**
     * One point.
     *
     * @return Point one.
     */
    public static final BuffPoint2d getOne() {
        return new BuffPoint2d((double)1, (double)1);
    }

//<editor-fold defaultstate="collapsed" desc="BuffPoint2">
    @Override
    public BuffPoint2d addAndSet(Vector2 other) {
        if (other instanceof Vector2d) {
            return addAndSet((Vector2d)other);
        } else if (other instanceof BuffVector2d) {
            return addAndSet((BuffVector2d)other);
        } else {
            return addAndSet(new Vector2d(other));
        }
    }

    public BuffPoint2d addAndSet(Vector2d other) {
        set((double)(getX() + other.getX()), (double)(getY() + other.getY()));
        return this;
    }

    public BuffPoint2d addAndSet(BuffVector2d other) {
        set((double)(getX() + other.getX()), (double)(getY() + other.getY()));
        return this;
    }

    @Override
    public BuffPoint2d subAndSet(Vector2 other) {
        if (other instanceof Vector2d) {
            return subAndSet((Vector2d)other);
        } else if (other instanceof BuffVector2d) {
            return subAndSet((BuffVector2d)other);
        } else {
            return subAndSet(new Vector2d(other));
        }
    }

    public BuffPoint2d subAndSet(Vector2d other) {
        set((double)(getX() - other.getX()), (double)(getY() - other.getY()));
        return this;
    }

    public BuffPoint2d subAndSet(BuffVector2d other) {
        set((double)(getX() - other.getX()), (double)(getY() - other.getY()));
        return this;
    }

    @Override
    public BuffPoint2d lerpAndSet(Point2 other, double alpha) {
        if (other instanceof Point2d) {
            return lerpAndSet((Point2d)other, alpha);
        } else if (other instanceof BuffPoint2d) {
            return lerpAndSet((BuffPoint2d)other, alpha);
        } else {
            return lerpAndSet(new Point2d(other), alpha);
        }
    }

    public BuffPoint2d lerpAndSet(Point2d other, double alpha) {
        linealAndSet(other, 1 - alpha, alpha);
        return this;
    }

    public BuffPoint2d lerpAndSet(BuffPoint2d other, double alpha) {
        linealAndSet(other, 1 - alpha, alpha);
        return this;
    }

    @Override
    public BuffPoint2d linealAndSet(Point2 other, double alpha, double beta) {
        if (other instanceof Point2d) {
            return linealAndSet((Point2d)other, alpha, beta);
        } else if (other instanceof BuffPoint2d) {
            return linealAndSet((BuffPoint2d)other, alpha, beta);
        } else {
            return linealAndSet(new Point2d(other), alpha, beta);
        }
    }

    public BuffPoint2d linealAndSet(Point2d other, double alpha, double beta) {
        set((double)(alpha * getX() + beta * other.getX()),
            (double)(alpha * getY() + beta * other.getY()));
        return this;
    }

    public BuffPoint2d linealAndSet(BuffPoint2d other, double alpha, double beta) {
        set((double)(alpha * getX() + beta * other.getX()),
            (double)(alpha * getY() + beta * other.getY()));
        return this;
    }

    @Override
    public BuffPoint2d vectorProjectionAndSet(Vector2 where) {
        if (where instanceof Vector2d) {
            return vectorProjectionAndSet((Vector2d)where);
        } else if (where instanceof BuffVector2d) {
            return vectorProjectionAndSet((BuffVector2d)where);
        } else {
            return vectorProjectionAndSet(new Vector2d(where));
        }
    }

    public BuffPoint2d vectorProjectionAndSet(Vector2d where) {
        double dot = getX() * where.getX() + getY() * where.getY();
        double r = dot / where.getLengthCuad();

        set((double)(getX() * r), (double)(getY() * r));
        return this;
    }

    public BuffPoint2d vectorProjectionAndSet(BuffVector2d where) {
        double dot = getX() * where.getX() + getY() * where.getY();
        double r = dot / where.getLengthCuad();

        set((double)(getX() * r), (double)(getY() * r));
        return this;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Point2">
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
    public double getDistance(Point2 other) {
        if (other instanceof Point2d) {
            return getDistance((Point2d)other);
        } else if (other instanceof BuffPoint2d) {
            return getDistance((BuffPoint2d)other);
        } else {
            return getDistance(new Point2d(other));
        }
    }

    public double getDistance(Point2d other) {
        return Math.sqrt(getDistanceCuad(other));
    }

    public double getDistance(BuffPoint2d other) {
        return Math.sqrt(getDistanceCuad(other));
    }

    @Override
    public double getDistanceCuad(Point2 other) {
        if (other instanceof Point2d) {
            return getDistanceCuad((Point2d)other);
        } else if (other instanceof BuffPoint2d) {
            return getDistanceCuad((BuffPoint2d)other);
        } else {
            return getDistanceCuad(new Point2d(other));
        }
    }

    public double getDistanceCuad(Point2d other) {
        return square(other.getX() - getX())
               + square(other.getY() - getY());
    }

    public double getDistanceCuad(BuffPoint2d other) {
        return square(other.getX() - getX())
               + square(other.getY() - getY());
    }

    @Override
    public double getDistanceL1(Point2 other) {
        if (other instanceof Point2d) {
            return getDistanceL1((Point2d)other);
        } else if (other instanceof BuffPoint2d) {
            return getDistanceL1((BuffPoint2d)other);
        } else {
            return getDistanceL1(new Point2d(other));
        }
    }

    public double getDistanceL1(Point2d other) {
        return Math.abs(other.getX() - getX())
               + Math.abs(other.getY() - getY());
    }

    public double getDistanceL1(BuffPoint2d other) {
        return Math.abs(other.getX() - getX())
               + Math.abs(other.getY() - getY());
    }

    @Override
    public BuffPoint2d add(Vector2 other) {
        if (other instanceof Vector2d) {
            return add((Vector2d)other);
        } else if (other instanceof BuffVector2d) {
            return add((BuffVector2d)other);
        } else {
            return add(new Vector2d(other));
        }
    }

    public BuffPoint2d add(Vector2d other) {
        return new BuffPoint2d((double)(getX() + other.getX()), (double)(getY() + other.getY()));
    }

    public BuffPoint2d add(BuffVector2d other) {
        return new BuffPoint2d((double)(getX() + other.getX()), (double)(getY() + other.getY()));
    }

    @Override
    public BuffPoint2d sub(Vector2 other) {
        if (other instanceof Vector2d) {
            return sub((Vector2d)other);
        } else if (other instanceof BuffVector2d) {
            return sub((BuffVector2d)other);
        } else {
            return sub(new Vector2d(other));
        }
    }

    public BuffPoint2d sub(Vector2d other) {
        return new BuffPoint2d((double)(getX() - other.getX()), (double)(getY() - other.getY()));
    }

    public BuffPoint2d sub(BuffVector2d other) {
        return new BuffPoint2d((double)(getX() - other.getX()), (double)(getY() - other.getY()));
    }

    @Override
    public BuffVector2d vectorTo(Point2 other) {
        if (other instanceof Point2d) {
            return vectorTo((Point2d)other);
        } else if (other instanceof BuffPoint2d) {
            return vectorTo((BuffPoint2d)other);
        } else {
            return vectorTo(new Point2d(other));
        }
    }

    public BuffVector2d vectorTo(Point2d other) {
        return new BuffVector2d((double)(other.getX() - getX()), (double)(other.getY() - getY()));
    }

    public BuffVector2d vectorTo(BuffPoint2d other) {
        return new BuffVector2d((double)(other.getX() - getX()), (double)(other.getY() - getY()));
    }

    @Override
    public BuffPoint2d lerp(Point2 other, double alpha) {
        if (other instanceof Point2d) {
            return lerp((Point2d)other, alpha);
        } else if (other instanceof BuffPoint2d) {
            return lerp((BuffPoint2d)other, alpha);
        } else {
            return lerp(new Point2d(other), alpha);
        }
    }

    public BuffPoint2d lerp(Point2d other, double alpha) {
        return lineal(other, 1 - alpha, alpha);
    }

    public BuffPoint2d lerp(BuffPoint2d other, double alpha) {
        return lineal(other, 1 - alpha, alpha);
    }

    @Override
    public double invLerp(Point2 other, Point2 lerp) {
        if (other instanceof Point2d && lerp instanceof Point2d) {
            return invLerp((Point2d)other, (Point2d)lerp);
        } else if (other instanceof BuffPoint2d && lerp instanceof BuffPoint2d) {
            return invLerp((BuffPoint2d)other, (BuffPoint2d)lerp);
        } else {
            return invLerp(new Point2d(other), new Point2d(other));
        }
    }

    public double invLerp(Point2d other, Point2d lerp) {
        double x1 = other.getX() - getX();
        double y1 = other.getY() - getY();
        double x2 = lerp.getX() - getX();
        double y2 = lerp.getY() - getY();
        return (x1 * x2 + y1 * y2) / Math.sqrt(x1 * x1 + y1 * y1);
    }

    public double invLerp(BuffPoint2d other, BuffPoint2d lerp) {
        double x1 = other.getX() - getX();
        double y1 = other.getY() - getY();
        double x2 = lerp.getX() - getX();
        double y2 = lerp.getY() - getY();
        return (x1 * x2 + y1 * y2) / Math.sqrt(x1 * x1 + y1 * y1);
    }

    @Override
    public BuffPoint2d lineal(Point2 other, double alpha, double beta) {
        if (other instanceof Point2d) {
            return lineal((Point2d)other, alpha, beta);
        } else if (other instanceof BuffPoint2d) {
            return lineal((BuffPoint2d)other, alpha, beta);
        } else {
            return lineal(new Point2d(other), alpha, beta);
        }
    }

    public BuffPoint2d lineal(Point2d other, double alpha, double beta) {
        return new BuffPoint2d((double)(alpha * getX() + beta * other.getX()),
                               (double)(alpha * getY() + beta * other.getY()));
    }

    public BuffPoint2d lineal(BuffPoint2d other, double alpha, double beta) {
        return new BuffPoint2d((double)(alpha * getX() + beta * other.getX()),
                               (double)(alpha * getY() + beta * other.getY()));
    }

    @Override
    public double scalarProjection(Vector2 where) {
        if (where instanceof Vector2d) {
            return scalarProjection((Vector2d)where);
        } else if (where instanceof BuffVector2d) {
            return scalarProjection((BuffVector2d)where);
        } else {
            return scalarProjection(new Vector2d(where));
        }
    }

    public double scalarProjection(Vector2d where) {
        double dot = getX() * where.getX() + getY() * where.getY();
        return  dot / where.getLengthCuad();
    }

    public double scalarProjection(BuffVector2d where) {
        double dot = getX() * where.getX() + getY() * where.getY();
        return  dot / where.getLengthCuad();
    }

    @Override
    public BuffPoint2d vectorProjection(Vector2 where) {
        if (where instanceof Vector2d) {
            return vectorProjection((Vector2d)where);
        } else if (where instanceof BuffVector2d) {
            return vectorProjection((BuffVector2d)where);
        } else {
            return vectorProjection(new Vector2d(where));
        }
    }

    public BuffPoint2d vectorProjection(Vector2d where) {
        double dot = getX() * where.getX() + getY() * where.getY();
        double r = dot / where.getLengthCuad();

        return new BuffPoint2d((double)(getX() * r), (double)(getY() * r));
    }

    public BuffPoint2d vectorProjection(BuffVector2d where) {
        double dot = getX() * where.getX() + getY() * where.getY();
        double r = dot / where.getLengthCuad();

        return new BuffPoint2d((double)(getX() * r), (double)(getY() * r));
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Object">
    @Override
    public BuffPoint2d clone() throws CloneNotSupportedException {
        return (BuffPoint2d)super.clone();
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="private">
    private static double square(double v) {
        return v*v;
    }
//</editor-fold>
}

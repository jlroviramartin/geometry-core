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
import essence.geometry.core.Point2;

/**
 * Basic implementation of a 2 dimension vector.
 */
public class Point2i extends Tuple2i implements Point2 {

    /**
     * Empty constructor.
     */
    public Point2i() {
    }

    /**
     * This constructor sets the components of this point.
     *
     * @param x Value of the component X.
     * @param y Value of the component Y.
     */
    public Point2i(int x, int y) {
        super(x, y);
    }

    /**
     * Copy constructor.
     *
     * @param tuple Tuple.
     */
    public Point2i(Tuple tuple) {
        super(tuple);
    }

    /**
     * Zero point.
     *
     * @return Point zero.
     */
    public static final Point2i getZero() {
        return new Point2i((int)0, (int)0);
    }

    /**
     * One point.
     *
     * @return Point one.
     */
    public static final Point2i getOne() {
        return new Point2i((int)1, (int)1);
    }

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
        if (other instanceof Point2i) {
            return getDistance((Point2i)other);
        } else if (other instanceof BuffPoint2i) {
            return getDistance((BuffPoint2i)other);
        } else {
            return getDistance(new Point2i(other));
        }
    }

    public double getDistance(Point2i other) {
        return Math.sqrt(getDistanceCuad(other));
    }

    public double getDistance(BuffPoint2i other) {
        return Math.sqrt(getDistanceCuad(other));
    }

    @Override
    public double getDistanceCuad(Point2 other) {
        if (other instanceof Point2i) {
            return getDistanceCuad((Point2i)other);
        } else if (other instanceof BuffPoint2i) {
            return getDistanceCuad((BuffPoint2i)other);
        } else {
            return getDistanceCuad(new Point2i(other));
        }
    }

    public double getDistanceCuad(Point2i other) {
        return square(other.getX() - getX())
               + square(other.getY() - getY());
    }

    public double getDistanceCuad(BuffPoint2i other) {
        return square(other.getX() - getX())
               + square(other.getY() - getY());
    }

    @Override
    public double getDistanceL1(Point2 other) {
        if (other instanceof Point2i) {
            return getDistanceL1((Point2i)other);
        } else if (other instanceof BuffPoint2i) {
            return getDistanceL1((BuffPoint2i)other);
        } else {
            return getDistanceL1(new Point2i(other));
        }
    }

    public double getDistanceL1(Point2i other) {
        return Math.abs(other.getX() - getX())
               + Math.abs(other.getY() - getY());
    }

    public double getDistanceL1(BuffPoint2i other) {
        return Math.abs(other.getX() - getX())
               + Math.abs(other.getY() - getY());
    }

    @Override
    public Point2i add(Vector2 other) {
        if (other instanceof Vector2i) {
            return add((Vector2i)other);
        } else if (other instanceof BuffVector2i) {
            return add((BuffVector2i)other);
        } else {
            return add(new Vector2i(other));
        }
    }

    public Point2i add(Vector2i other) {
        return new Point2i((int)(getX() + other.getX()), (int)(getY() + other.getY()));
    }

    public Point2i add(BuffVector2i other) {
        return new Point2i((int)(getX() + other.getX()), (int)(getY() + other.getY()));
    }

    @Override
    public Point2i sub(Vector2 other) {
        if (other instanceof Vector2i) {
            return sub((Vector2i)other);
        } else if (other instanceof BuffVector2i) {
            return sub((BuffVector2i)other);
        } else {
            return sub(new Vector2i(other));
        }
    }

    public Point2i sub(Vector2i other) {
        return new Point2i((int)(getX() - other.getX()), (int)(getY() - other.getY()));
    }

    public Point2i sub(BuffVector2i other) {
        return new Point2i((int)(getX() - other.getX()), (int)(getY() - other.getY()));
    }

    @Override
    public Vector2i vectorTo(Point2 other) {
        if (other instanceof Point2i) {
            return vectorTo((Point2i)other);
        } else if (other instanceof BuffPoint2i) {
            return vectorTo((BuffPoint2i)other);
        } else {
            return vectorTo(new Point2i(other));
        }
    }

    public Vector2i vectorTo(Point2i other) {
        return new Vector2i((int)(other.getX() - getX()), (int)(other.getY() - getY()));
    }

    public Vector2i vectorTo(BuffPoint2i other) {
        return new Vector2i((int)(other.getX() - getX()), (int)(other.getY() - getY()));
    }

    @Override
    public Point2i lerp(Point2 other, double alpha) {
        if (other instanceof Point2i) {
            return lerp((Point2i)other, alpha);
        } else if (other instanceof BuffPoint2i) {
            return lerp((BuffPoint2i)other, alpha);
        } else {
            return lerp(new Point2i(other), alpha);
        }
    }

    public Point2i lerp(Point2i other, double alpha) {
        return lineal(other, 1 - alpha, alpha);
    }

    public Point2i lerp(BuffPoint2i other, double alpha) {
        return lineal(other, 1 - alpha, alpha);
    }

    @Override
    public double invLerp(Point2 other, Point2 lerp) {
        if (other instanceof Point2i && lerp instanceof Point2i) {
            return invLerp((Point2i)other, (Point2i)lerp);
        } else if (other instanceof BuffPoint2i && lerp instanceof BuffPoint2i) {
            return invLerp((BuffPoint2i)other, (BuffPoint2i)lerp);
        } else {
            return invLerp(new Point2i(other), new Point2i(other));
        }
    }

    public double invLerp(Point2i other, Point2i lerp) {
        double x1 = other.getX() - getX();
        double y1 = other.getY() - getY();
        double x2 = lerp.getX() - getX();
        double y2 = lerp.getY() - getY();
        return (x1 * x2 + y1 * y2) / Math.sqrt(x1 * x1 + y1 * y1);
    }

    public double invLerp(BuffPoint2i other, BuffPoint2i lerp) {
        double x1 = other.getX() - getX();
        double y1 = other.getY() - getY();
        double x2 = lerp.getX() - getX();
        double y2 = lerp.getY() - getY();
        return (x1 * x2 + y1 * y2) / Math.sqrt(x1 * x1 + y1 * y1);
    }

    @Override
    public Point2i lineal(Point2 other, double alpha, double beta) {
        if (other instanceof Point2i) {
            return lineal((Point2i)other, alpha, beta);
        } else if (other instanceof BuffPoint2i) {
            return lineal((BuffPoint2i)other, alpha, beta);
        } else {
            return lineal(new Point2i(other), alpha, beta);
        }
    }

    public Point2i lineal(Point2i other, double alpha, double beta) {
        return new Point2i((int)(alpha * getX() + beta * other.getX()),
                           (int)(alpha * getY() + beta * other.getY()));
    }

    public Point2i lineal(BuffPoint2i other, double alpha, double beta) {
        return new Point2i((int)(alpha * getX() + beta * other.getX()),
                           (int)(alpha * getY() + beta * other.getY()));
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
        double dot = getX() * where.getX() + getY() * where.getY();
        return  dot / where.getLengthCuad();
    }

    public double scalarProjection(BuffVector2i where) {
        double dot = getX() * where.getX() + getY() * where.getY();
        return  dot / where.getLengthCuad();
    }

    @Override
    public Point2i vectorProjection(Vector2 where) {
        if (where instanceof Vector2i) {
            return vectorProjection((Vector2i)where);
        } else if (where instanceof BuffVector2i) {
            return vectorProjection((BuffVector2i)where);
        } else {
            return vectorProjection(new Vector2i(where));
        }
    }

    public Point2i vectorProjection(Vector2i where) {
        double dot = getX() * where.getX() + getY() * where.getY();
        double r = dot / where.getLengthCuad();

        return new Point2i((int)(getX() * r), (int)(getY() * r));
    }

    public Point2i vectorProjection(BuffVector2i where) {
        double dot = getX() * where.getX() + getY() * where.getY();
        double r = dot / where.getLengthCuad();

        return new Point2i((int)(getX() * r), (int)(getY() * r));
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Object">
    @Override
    public Point2i clone() throws CloneNotSupportedException {
        return (Point2i)super.clone();
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="private">
    private static int square(int v) {
        return v*v;
    }
//</editor-fold>
}

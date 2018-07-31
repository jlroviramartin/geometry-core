/*
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
package essence.geometry.core;

/**
 * Simple math utils for double values.
 *
 * @author joseluis
 */
public class DoubleUtils {

    public static final double EPSILON = (double) 1e-09;

    public static final double ZERO_TOLERANCE = (double) 1e-08;

    public static boolean epsilonEquals(double v1, double v2) {
        return epsilonEquals(v1, v2, EPSILON);
    }

    public static boolean epsilonEquals(double v1, double v2, double epsilon) {
        //return (Math.abs(v2 - v1) <= epsilon);
        // To resolve the PositiveInfinity / NegativeInfinity comparisons:
        if (v2 > v1) {
            return v2 <= v1 + epsilon;
        } else {
            return v1 <= v2 + epsilon;
        }
    }

    public static boolean epsilonZero(double v) {
        return epsilonZero(v, ZERO_TOLERANCE);
    }

    public static boolean epsilonZero(double v, double epsilon) {
        return (Math.abs(v) <= epsilon);
    }
}

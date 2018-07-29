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
 * Simple math utils for long values.
 *
 * @author joseluis
 */
public class LongUtils {

    public static final double EPSILON = 0;

    public static final double ZERO_TOLERANCE = 0;

    public static boolean epsilonEquals(long v1, long v2) {
        return epsilonEquals(v1, v2, EPSILON);
    }

    public static boolean epsilonEquals(long v1, long v2, double epsilon) {
        return (Math.abs(v2 - v1) <= epsilon);
    }

    public static boolean epsilonZero(long v) {
        return epsilonZero(v, ZERO_TOLERANCE);
    }

    public static boolean epsilonZero(long v, double epsilon) {
        return (Math.abs(v) <= epsilon);
    }
}

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
package essence.geometry.core;


/**
 * A {@code Vector3} is a 3 dimensional collection of values
 * that represents a vector.
 */
public interface Vector3 extends Tuple {

    /**
     * This method tests if {@code this} is an unit vector (the length is 1).
     *
     * @return True if the length is 1. False otherwise.
     */
    boolean isUnit();

    /**
     * This method tests if {@code this} is an unit vector (the length is 1).
     *
     * @param epsilon Error.
     * @return True if the length is 1. False otherwise.
     */
    boolean isUnit(double epsilon);

    /**
     * This method gets the quadrant/octant of {@code this} vector.
     *
     * @return Quadrant of this vector.
     */
    int getQuadrant();

    /**
     * This method gets the length of {@code this} vector.
     *
     * @return Length of this vector.
     */
    default double getLength() {
        return Math.sqrt(getLengthCuad());
    }

    /**
     * This method gets the squared length of {@code this} vector.
     *
     * @return Squared length of this vector.
     */
    default double getLengthCuad() {
        return dot(this);
    }

    /**
     * This method gets the L1 (Manhattan) length of {@code this} vector.
     *
     * @return L1 (Manhattan) length of this vector.
     */
    double getLengthL1();

    /**
     * This method evaluates the unit vector of {@code this} vector.
     *
     * @return {@code this.unit.length == 1}
     */
    Vector3 getUnit();

    /**
     * This method adds {@code this} vector to {@code other} vector.
     *
     * @param other Other vector.
     * @return {@code this + other}
     */
    Vector3 add(Vector3 other);

    /**
     * This method subs {@code this} vector to {@code other} vector.
     *
     * @param other Other vector.
     * @return {@code this - other}
     */
    Vector3 sub(Vector3 other);

    /**
     * This method multiplies {@code this} vector by {@code other} vector (coordinate by coordenate).
     *
     * @param other Other vector.
     * @return {@code (this.x * other.x, this.y * other.y, ...)}
     */
    Vector3 simpleMul(Vector3 other);

    /**
     * This method divides {@code this} vector by {@code other} vector (coordinate by coordenate).
     *
     * @param other Other vector.
     * @return {@code (this.x / other.x, this.y / other.y, ...)}
     */
    Vector3 simpleDiv(Vector3 other);

    /**
     * This method multiplies {@code this} vector by {@code v} scalar.
     *
     * @param v Scalar.
     * @return {@code this * v}
     */
    Vector3 mul(double v);

    /**
     * This method divides {@code this} vector by {@code v} scalar.
     *
     * @param v Scalar.
     * @return {@code this / v}
     */
    Vector3 div(double v);

    /**
     * This method evaluates the negation of {@code this} vector.
     *
     * @return {@code -this}
     */
    Vector3 neg();

    /**
     * This method evaluates the absolute value of {@code this} vector.
     *
     * @return {@code abs( this )}
     */
    Vector3 abs();

    /**
     * This method evaluates the linear interpolation of {@code this} vector and {@code other} vector at {@code alpha}.
     *
     * @param other Other vector.
     * @param alpha Interpolation.
     * @return {@code this * alpha + other * (1 - alpha)}
     */
    default Vector3 lerp(Vector3 other, double alpha) {
        return lineal(other, 1 - alpha, alpha);
    }

    /**
     * This method evaluates the inverse of the linear interpolation of {@code this} vector and {@code other} vector at {@code vLerp}.
     *
     * @param other Other vector.
     * @param vLerp Interpolated vector.
     * @return {@code vLerp = this * result + other * (1 - result)
     *                vLerp = this * result + other - other * result
     *                vLerp = (this - other) * result + other
     *                vLerp - other = (this - other) * result
     *                vLerp - other = V1 = |V1| * U   si V1 != 0
     *                this - other  = V2 = |V2| * U   si V2 != 0
     *                |V1| * U = |V2| * U * result
     *                |V1| = |V2| * result
     *                result = |V1| / |V2|}
     */
    double invLerp(Vector3 other, Vector3 vLerp);

    /**
     * This method evaluates the linear combination of {@code this} vector and {@code other} vector at {@code alpha} and {@code beta}.
     *
     * @param other Other vector.
     * @param alpha Interpolation for {@code this}.
     * @param beta Interpolation for {@code other}.
     * @return {@code this * alpha + other * beta}
     */
    Vector3 lineal(Vector3 other, double alpha, double beta);

    /**
     * This method evaluates the dot product of {@code this} vector and {@code other} vector.
     *
     * @param other Other vector.
     * @return {@code this . other}
     */
    double dot(Vector3 other);

    /**
     * This method evaluates the cross product of {@code this} vector and {@code other} vector.
     *
     * @param other Other vector.
     * @return {@code this x other}
     */
    Vector3 cross(Vector3 other);

    /**
     * This method evaluates the triple product of {@code this} vector and {@code v2} and {@code v3} vectors.
     *
     * @param v2 Other vector.
     * @param v3 Other vector.
     * @return {@code this . ( v1 x v2 )}
     */
    default double tripleProduct(Vector3 v2, Vector3 v3) {
        return dot(v2.cross(v3));
    }

    /**
     * This method evaluates the scalar projection of {@code this} vector over {@code where} vector.
     * https://en.wikipedia.org/wiki/Vector_projection
     *
     * @param where Where to project.
     * @return {@code this . where.getUnit()}
     */
    default double scalarProjection(Vector3 where) {
        return dot(where) / where.getLength();
    }

    /**
     * This method evaluates the vector projection of {@code this} vector over {@code where} vector.
     * https://en.wikipedia.org/wiki/Vector_projection
     *
     * @param where Where to project.
     * @return {@code this.scalarProjection(where) . where.getUnit()}
     */
    Vector3 vectorProjection(Vector3 where);
}

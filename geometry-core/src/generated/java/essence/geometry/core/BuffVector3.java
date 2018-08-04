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
 * A {@code BuffVector3} is a 3 dimensional collection of values
 * that represents a vector.
 */
public interface BuffVector3 extends Vector3, BuffTuple {

    /**
     * This method sets the vector to zero.
     *
     * @return This vector.
     */
    BuffVector3 setZero();

    /**
     * This method sets the vector to the unit.
     *
     * @return {@code this.unit.length == 1}
     */
    BuffVector3 setUnit();

    /**
     * This method adds {@code this} vector to {@code other} vector.
     *
     * @param other Other vector.
     * @return {@code result = this + other}
     */
    BuffVector3 addAndSet(Vector3 other);

    /**
     * This method subs {@code this} vector to {@code other} vector.
     *
     * @param other Other vector.
     * @return {@code result = this - other}
     */
    BuffVector3 subAndSet(Vector3 other);

    /**
     * This method multiplies {@code this} vector to {@code other} vector (coordinate by coordenate).
     *
     * @param other Other vector.
     * @return result.
     */
    BuffVector3 simpleMulAndSet(Vector3 other);

    /**
     * This method divides {@code this} vector by {@code other} vector (coordinate by coordenate).
     *
     * @param other Other vector.
     * @return result.
     */
    BuffVector3 simpleDivAndSet(Vector3 other);

    /**
     * This method multiplies {@code this} vector to {@code v}.
     *
     * @param v Scalar.
     * @return {@code result = this * v}
     */
    BuffVector3 mulAndSet(double v);

    /**
     * This method divides {@code this} vector by {@code v}.
     *
     * @param v Scalar.
     * @return {@code result = this / v}
     */
    BuffVector3 divAndSet(double v);

    /**
     * This method evaluates the negation of {@code this} vector.
     *
     * @return {@code result = -this}
     */
    BuffVector3 negAndSet();

    /**
     * This method evaluates the absolute value of {@code this} vector.
     *
     * @return {@code result = abs( this )}
     */
    BuffVector3 absAndSet();

    /**
     * This method evaluates the linear interpolation of {@code this} vector and {@code other} vector at {@code alpha}.
     *
     * @param other Other vector.
     * @param alpha Interpolation.
     * @return {@code this * alpha + other * (1 - alpha)}
     */
    BuffVector3 lerpAndSet(Vector3 other, double alpha);

    /**
     * This method evaluates the linear combination of {@code this} vector and {@code other} vector at {@code alpha} and {@code beta}.
     *
     * @param other Other vector.
     * @param alpha Interpolation for {@code this}.
     * @param beta Interpolation for {@code other}.
     * @return {@code this * alpha + other * beta}
     */
    BuffVector3 linealAndSet(Vector3 other, double alpha, double beta);

    /**
     * This method evaluates the cross product of {@code this} vector and {@code other} vector.
     *
     * @param other Other vector.
     * @return {@code this x other}
     */
    BuffVector3 crossAndSet(Vector3 other);

    /**
     * This method evaluates the vector projection of {@code this} vector over {@code where} vector.
     * https://en.wikipedia.org/wiki/Vector_projection
     *
     * @param where Where to project.
     * @return {@code this.scalarProjection(where) . where.getUnit()}
     */
    BuffVector3 vectorProjectionAndSet(Vector3 where);
}

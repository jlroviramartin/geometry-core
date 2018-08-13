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
 * A {@code BuffVector2} is a 2 dimensional collection of values
 * that represents a vector.
 */
public interface BuffVector2 extends Vector2 {

    /**
     * This method sets the vector to zero.
     *
     * @return This vector.
     */
    BuffVector2 setZero();

    /**
     * This method sets the vector to the unit.
     *
     * @return {@code this.unit.length == 1}
     */
    BuffVector2 setUnit();

    /**
     * This method adds {@code this} vector to {@code other} vector.
     *
     * @param other Other vector.
     * @return {@code result = this + other}
     */
    BuffVector2 addAndSet(Vector2 other);

    /**
     * This method subs {@code this} vector to {@code other} vector.
     *
     * @param other Other vector.
     * @return {@code result = this - other}
     */
    BuffVector2 subAndSet(Vector2 other);

    /**
     * This method multiplies {@code this} vector to {@code other} vector (coordinate by coordenate).
     *
     * @param other Other vector.
     * @return result.
     */
    BuffVector2 simpleMulAndSet(Vector2 other);

    /**
     * This method divides {@code this} vector by {@code other} vector (coordinate by coordenate).
     *
     * @param other Other vector.
     * @return result.
     */
    BuffVector2 simpleDivAndSet(Vector2 other);

    /**
     * This method multiplies {@code this} vector to {@code v}.
     *
     * @param v Scalar.
     * @return {@code result = this * v}
     */
    BuffVector2 mulAndSet(double v);

    /**
     * This method divides {@code this} vector by {@code v}.
     *
     * @param v Scalar.
     * @return {@code result = this / v}
     */
    BuffVector2 divAndSet(double v);

    /**
     * This method evaluates the negation of {@code this} vector.
     *
     * @return {@code result = -this}
     */
    BuffVector2 negAndSet();

    /**
     * This method evaluates the absolute value of {@code this} vector.
     *
     * @return {@code result = abs( this )}
     */
    BuffVector2 absAndSet();

    /**
     * This method evaluates the linear interpolation of {@code this} vector and {@code other} vector at {@code alpha}.
     *
     * @param other Other vector.
     * @param alpha Interpolation.
     * @return {@code this * alpha + other * (1 - alpha)}
     */
    BuffVector2 lerpAndSet(Vector2 other, double alpha);

    /**
     * This method evaluates the linear combination of {@code this} vector and {@code other} vector at {@code alpha} and {@code beta}.
     *
     * @param other Other vector.
     * @param alpha Interpolation for {@code this}.
     * @param beta Interpolation for {@code other}.
     * @return {@code this * alpha + other * beta}
     */
    BuffVector2 linealAndSet(Vector2 other, double alpha, double beta);

    /**
     * This method calculates the perpendicular vector to the left of {@code this} vector.
     *
     * @return {@code (-y, x)}
     */
    BuffVector2 setPerpLeft();

    /**
     * This method calculates the perpendicular vector to the right (Perp) of {@code this} vector.
     *
     * @return {@code (y, -x)}
     */
    BuffVector2 setPerpRight();

    /**
     * This method rotates {@code this} vector.
     *
     * @param angle Angle (radians).
     * @return Rotated vector.
     */
    BuffVector2 setRotate(double angle);

    /**
     * This method rotates and scales {@code this} vector.
     *
     * @param angle Angle (radians).
     * @param len Scale.
     * @return Rotated vector.
     */
    BuffVector2 setRotateAndScale(double angle, double len);

    /**
     * This method evaluates the vector projection of {@code this} vector over {@code where} vector.
     * https://en.wikipedia.org/wiki/Vector_projection
     *
     * @param where Where to project.
     * @return {@code this.scalarProjection(where) . where.getUnit()}
     */
    BuffVector2 vectorProjectionAndSet(Vector2 where);
}

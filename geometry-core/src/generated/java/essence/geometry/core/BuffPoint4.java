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
 * A {@code BuffPoint4} is a 4 dimensional collection of values
 * that represents a point.
 */
public interface BuffPoint4 extends Point4, BuffTuple {

    /**
     * This method adds {@code this} point to {@code other} vector and sets the result
     * into {@code this}.
     *
     * @param other Other vector.
     * @return {@code this = this + other}
     */
    BuffPoint4 addAndSet(Vector4 other);

    /**
     * This method subs {@code this} point to {@code other} vector and sets the result
     * into {@code this}.
     *
     * @param other Other vector.
     * @return {@code this = this - other}
     */
    BuffPoint4 subAndSet(Vector4 other);

    /**
     * This method evaluates the linear interpolation of {@code this} point and
     * {@code other} point at {@code alpha} and sets the result
     * into {@code this}.
     *
     * @param other Other point.
     * @param alpha Interpolation.
     * @return {@code this = this * alpha + other * (1 - alpha)}
     */
    BuffPoint4 lerpAndSet(Point4 other, double alpha);

    /**
     * This method evaluates the linear combination of {@code this} point and
     * {@code other} point at {@code alpha} and {@code beta} and sets the result
     * into {@code this}.
     *
     * @param other Other point.
     * @param alpha Interpolation for {@code this}.
     * @param beta Interpolation for {@code other}.
     * @return {@code this = this * alpha + other * beta}
     */
    BuffPoint4 linealAndSet(Point4 other, double alpha, double beta);

    /**
     * This method evaluates the vector projection of {@code this} point over
     * {@code where} vector and sets the result
     * into {@code this}.
     * https://en.wikipedia.org/wiki/Vector_projection
     *
     * @param where Where to project.
     * @return {@code this = this.scalarProjection(where) . where.getUnit()}
     */
    BuffPoint4 vectorProjectionAndSet(Vector4 where);
}

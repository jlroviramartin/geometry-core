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

import essence.geometry.core.MatrixSet;

/**
 * A {@code BuffMatrix2x2} is a collection of values that represents a matrix.
 */
public interface BuffMatrix2x2 extends Matrix2x2, MatrixSet {

    /**
     * This method sets {@code this} matrix to zero.
     *
     * @return {@code this = zero}
     */
    BuffMatrix2x2 setZero();

    /**
     * This method sets {@code this} matrix to the identity.
     *
     * @return {@code this = identity}
     */
    BuffMatrix2x2 setIdentity();

    /**
     * This method adds {@code this} matrix and {@code other} matrix and sets the result
     * into {@code this}.
     *
     * @param other Other matrix.
     * @return {@code this = this + other}
     */
    BuffMatrix2x2 addAndSet(Matrix2x2 other);

    /**
     * This method subs {@code this} matrix and {@code other} matrix and sets the result
     * into {@code this}.
     *
     * @param other Other matrix.
     * @return {@code this = this - other}
     */
    BuffMatrix2x2 subAndSet(Matrix2x2 other);

    /**
     * This method multiplies {@code this} matrix by {@code v} and sets the result
     * into {@code this}.
     *
     * @param v Scalar.
     * @return {@code this = this * v}
     */
    BuffMatrix2x2 mulAndSet(double v);

    /**
     * This method divides {@code this} matrix by {@code v} and sets the result
     * into {@code this}.
     *
     * @param v Scalar.
     * @return {@code this = this / v}
     */
    BuffMatrix2x2 divAndSet(double v);

    /**
     * This method multiplies {@code this} matrix by {@code other} matrix and sets the result
     * into {@code this}.
     *
     * @param other Other matrix.
     * @return {@code this = this * other}
     */
    BuffMatrix2x2 mulAndSet(Matrix2x2 other);

    /**
     * This method changes the sign of {@code this} matrix and sets the result
     * into {@code this}.
     *
     * @return {@code this = -this}
     */
    BuffMatrix2x2 negAndSet();

    /**
     * This method calculates the absolute value of {@code this} matrix and sets the result
     * into {@code this}.
     *
     * @return {@code this = abs(this)}
     */
    BuffMatrix2x2 absAndSet();

    /**
     * This method calculates the transpose of {@code this} matrix and sets the result
     * into {@code this}.
     *
     * @return {@code this = transpose(this)}
     */
    BuffMatrix2x2 transposeAndSet();

    /**
     * This method evaluates the inverse of {@code this} matrix and sets the result
     * into {@code this}.
     *
     * @return {@code this = this^-1}
     */
    BuffMatrix2x2 inverseAndSet() throws SingularMatrixException;
}

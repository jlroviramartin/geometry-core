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
 * A {@code Matrix3x3} is a collection of values that represents a matrix.
 */
public interface Matrix3x3 {

    /**
     * This method evaluates is {@code this} matrix is valid.
     *
     * @return {@code True} if {@code this} matrix contains only valid components. {@code False} otherwise.
     */
    boolean isValid();

    /**
     * This method evaluates is {@code this} matrix contains any NaN component.
     *
     * @return {@code True} if {@code this} matrix contains any NaN component. {@code False} otherwise.
     */
    boolean isNaN();

    /**
     * This method evaluates is {@code this} matrix contains any infinity component.
     *
     * @return {@code True} if {@code this} matrix contains any infinity component. {@code False} otherwise.
     */
    boolean isInfinity();

    /**
     * This method evaluates is {@code this} matrix is zero.
     *
     * @return {@code True} if {@code this} matrix is zero. {@code False} otherwise.
     */
    boolean isZero();

    /**
     * This method evaluates is {@code this} matrix is zero.
     *
     * @param epsilon Error.
     * @return {@code True} if {@code this} matrix is zero. {@code False} otherwise.
     */
    boolean isZero(double epsilon);

    /**
     * This method evaluates is {@code this} matrix is the identity.
     *
     * @return {@code True} if {@code this} matrix is the identity. {@code False} otherwise.
     */
    boolean isIdentity();

    /**
     * This method evaluates is {@code this} matrix is the identity.
     *
     * @param epsilon Error.
     * @return {@code True} if {@code this} matrix is the identity. {@code False} otherwise.
     */
    boolean isIdentity(double epsilon);

    /**
     * This method evaluates is {@code this} matrix is the invertible.
     *
     * @return {@code True} if {@code this} matrix is invertible. {@code False} otherwise.
     */
    boolean isInvertible();

    /**
     * This method evaluates is {@code this} matrix is the invertible.
     *
     * @param epsilon Error.
     * @return {@code True} if {@code this} matrix is invertible. {@code False} otherwise.
     */
    boolean isInvertible(double epsilon);

    /**
     * This method evaluates the determinant of {@code this} matrix
     *
     * @return Determinant.
     */
    double getDeterminant();

    /**
     * This method adds {@code this} matrix and {@code other} matrix.
     *
     * @param other Other matrix.
     * @return {@code this + other}
     */
    Matrix3x3 add(Matrix3x3 other);

    /**
     * This method subs {@code this} matrix and {@code other} matrix.
     *
     * @param other Other matrix.
     * @return {@code this - other}
     */
    Matrix3x3 sub(Matrix3x3 other);

    /**
     * This method multiplies {@code this} matrix by {@code v}.
     *
     * @param v Scalar.
     * @return {@code this * v}
     */
    Matrix3x3 mul(double v);

    /**
     * This method divides {@code this} matrix by {@code v}.
     *
     * @param v Scalar.
     * @return {@code this / v}
     */
    Matrix3x3 div(double v);

    /**
     * This method multiplies {@code this} matrix by {@code other} matrix.
     *
     * @param other Other matrix.
     * @return {@code this * other}
     */
    Matrix3x3 mul(Matrix3x3 other);

    /**
     * This method changes the sign of {@code this} matrix.
     *
     * @return {@code -this}
     */
    Matrix3x3 neg();

    /**
     * This method calculates the absolute value of {@code this} matrix.
     *
     * @return {@code abs(this)}
     */
    Matrix3x3 abs();

    /**
     * This method calculates the transpose of {@code this} matrix.
     *
     * @return {@code transpose(this)}
     */
    Matrix3x3 transpose();

    /**
     * This method evaluates the inverse of {@code this} matrix.
     *
     * @return {@code inverse(this)}
     */
    Matrix3x3 inverse() throws SingularMatrixException;
}

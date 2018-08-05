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


/**
 * A {@code MatrixSetter2x2_Double} is a 2x2 dimensional collection of values
 * of type double.
 */
public interface MatrixSetter2x2_Double extends MatrixGetter2x2_Double {

    /**
     * This methods sets the property [r, c].
     *
     * @param r Number of the row.
     * @param c Number of the column.
     * @param value Property [r, c].
     */
    void set(int r, int c, double value);

    /**
     * This methods sets the property [0, 0].
     *
     * @param value Property [0, 0].
     */
    void setM00(double value);

    /**
     * This methods sets the property [0, 1].
     *
     * @param value Property [0, 1].
     */
    void setM01(double value);

    /**
     * This methods sets the property [1, 0].
     *
     * @param value Property [1, 0].
     */
    void setM10(double value);

    /**
     * This methods sets the property [1, 1].
     *
     * @param value Property [1, 1].
     */
    void setM11(double value);

    /**
     * This methods sets all the properties.
     *
     * @param m00 Property [0, 0].
     * @param m01 Property [0, 1].
     * @param m10 Property [1, 0].
     * @param m11 Property [1, 1].
     */
    Matrix2x2d set(double m00, double m01, double m10, double m11);
}
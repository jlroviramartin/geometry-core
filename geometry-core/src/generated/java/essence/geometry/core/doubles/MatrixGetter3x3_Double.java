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
 * A {@code MatrixGetter3x3_Double} is a 3x3 dimensional collection of values
 * of type double.
 */
public interface MatrixGetter3x3_Double {

    /**
     * This method gets the number of rows.
     *
     * @return Number of rows.
     */
    int sizeRows();

    /**
     * This method gets the number of columns.
     *
     * @return Number of columns.
     */
    int sizeCols();

    /**
     * This method evaluates is {@code this} matrix is squared.
     *
     * @return {@code True} if {@code this} matrix is squared. {@code False} otherwise.
     */
    boolean isSquared();

    /**
     * This methods gets the property [r, c].
     *
     * @param r Number of the row.
     * @param c Number of the column.
     * @return Property [r, c].
     */
    double get(int r, int c);

    /**
     * This methods gets the property [0, 0].
     *
     * @return Property [0, 0].
     */
    double getM00();

    /**
     * This methods gets the property [0, 1].
     *
     * @return Property [0, 1].
     */
    double getM01();

    /**
     * This methods gets the property [0, 2].
     *
     * @return Property [0, 2].
     */
    double getM02();

    /**
     * This methods gets the property [1, 0].
     *
     * @return Property [1, 0].
     */
    double getM10();

    /**
     * This methods gets the property [1, 1].
     *
     * @return Property [1, 1].
     */
    double getM11();

    /**
     * This methods gets the property [1, 2].
     *
     * @return Property [1, 2].
     */
    double getM12();

    /**
     * This methods gets the property [2, 0].
     *
     * @return Property [2, 0].
     */
    double getM20();

    /**
     * This methods gets the property [2, 1].
     *
     * @return Property [2, 1].
     */
    double getM21();

    /**
     * This methods gets the property [2, 2].
     *
     * @return Property [2, 2].
     */
    double getM22();
}

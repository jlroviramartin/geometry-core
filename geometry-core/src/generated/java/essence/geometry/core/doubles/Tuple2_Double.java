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

import essence.geometry.core.Tuple;

/**
 * A {@code Tuple2_Double} is a 2 dimensional collection of values of type double.
 */
public interface Tuple2_Double extends Tuple {

    /**
     * This method gets the component {@code index}.
     *
     * @param index Index of the component.
     * @return Value of the component.
     */
    double getAt(int index);

    /**
     * This method gets the X component.
     *
     * @return Value of the X component.
     */
    double getX();

    /**
     * This method gets the Y component.
     *
     * @return Value of the Y component.
     */
    double getY();
}

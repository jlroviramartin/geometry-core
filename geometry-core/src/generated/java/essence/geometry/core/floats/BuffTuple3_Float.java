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
package essence.geometry.core.floats;

import essence.geometry.core.Tuple;
import essence.geometry.core.BuffTuple;

/**
 * A {@code BuffTuple3_Float} is a 3 dimensional collection of values of type float.
 */
public interface BuffTuple3_Float extends BuffTuple, Tuple3_Float {

    /**
     * This method sets the component {@code index}.
     *
     * @param index Index of the component.
     * @param value Value of the component.
     */
    void setAt(int index, float value);

    /**
     * This method sets the X component.
     *
     * @param value Value of the X component.
     */
    void setX(float value);

    /**
     * This method sets the Y component.
     *
     * @param value Value of the Y component.
     */
    void setY(float value);

    /**
     * This method sets the Z component.
     *
     * @param value Value of the Z component.
     */
    void setZ(float value);

    /**
     * This method sets all the components.
     *
     * @param x Value of the X component.
     * @param y Value of the Y component.
     * @param z Value of the Z component.
     */
    void set(float x, float y, float z);
}

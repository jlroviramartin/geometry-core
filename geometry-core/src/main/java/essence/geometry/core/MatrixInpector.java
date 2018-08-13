/*
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
 *
 * @author joseluis
 */
public interface MatrixInpector {

    /**
     * This method gets the number of rows of this tuple.
     *
     * @return Number of rows of this tuple.
     */
    int sizeRows();

    /**
     * This method gets the number of columns of this tuple.
     *
     * @return Number of columns of this tuple.
     */
    int sizeCols();

    /**
     * This method gets the values of this matrix into {@code matrixSet}.
     *
     * @param matrixSet Where to get the values.
     */
    void getInto(MatrixSet matrixSet);
}

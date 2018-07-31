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

import essence.util.math.EpsilonEquatable;

/**
 * Base class of the tuples, vectors and points.
 *
 * @author joseluis
 */
public interface Tuple extends EpsilonEquatable<Tuple> {

    /**
     * This method gets the number of components of the tuple.
     *
     * @return Size of the tuple.
     */
    int size();

//    /**
//     * This method copies the content of the tuple into another tuple.
//     *
//     * @param other Other tuple where to copy the content.
//     */
//    void getInto(BuffTuple other);
}

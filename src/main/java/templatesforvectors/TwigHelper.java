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
package templatesforvectors;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 *
 * @author joseluis
 */
public class TwigHelper {

    public Object myfilter(Object obj) {
        if (obj == null) {
            System.out.println("-- Null");
            return null;
        }
        if (obj.getClass().isArray()) {
            System.out.println("-- Array " + obj.getClass().getComponentType());
            ArrayAsList<?> asList = new ArrayAsList<>(obj);
            return asList.stream()
                    .map(x -> "{" + x + "}")
                    .collect(Collectors.toList());
        }
        if (obj instanceof Iterable<?>) {
            System.out.println("-- Iterable " + obj.getClass());
            Iterable<?> asIterable = (Iterable<?>) obj;
            return StreamSupport.stream(asIterable.spliterator(), false)
                    .map(x -> "{" + x + "}")
                    .collect(Collectors.toList());
        }
        System.out.println("-- Other");
        return "{" + obj + "}";
    }
}

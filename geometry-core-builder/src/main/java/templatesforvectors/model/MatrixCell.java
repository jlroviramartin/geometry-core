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
package templatesforvectors.model;

/**
 *
 * @author joseluis
 */
public class MatrixCell {

    MatrixCell(String name, String type, String ctype, int r, int c) {
        this.name = name;
        this.type = type;
        this.ctype = ctype;
        this.r = r;
        this.c = c;
    }

    public String name;

    public String getUpperName() {
        return Character.toUpperCase(name.charAt(0)) + name.substring(1);
    }

    public String type;
    public String ctype;
    public int r;
    public int c;

}

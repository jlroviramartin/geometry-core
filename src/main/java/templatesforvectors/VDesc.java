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

/**
 * Description of a tuple/vector/point.
 */
public class VDesc {

    public static VDesc getDefault(int dim) {
        final String[] names = new String[]{"x", "y", "z", "w"};
        VDesc desc = new VDesc();
        desc._package = "essence.geometry.core";
        desc.corePackage = "essence.geometry.core";
        desc.dim = dim;
        desc.suffix = "";
        desc.type = "";
        desc.ctype = "";
        desc.integral = false;
        desc.properties = new VDim[dim];
        for (int i = 0; i < dim; i++) {
            desc.properties[i] = new VDim(names[i], desc.type, desc.ctype, i);
        }
        return desc;
    }

    public static VDesc getFloat(int dim) {
        final String[] names = new String[]{"x", "y", "z", "w"};
        VDesc desc = new VDesc();
        desc._package = "essence.geometry.core.floats";
        desc.corePackage = "essence.geometry.core";
        desc.dim = dim;
        desc.suffix = "f";
        desc.type = "float";
        desc.ctype = "Float";
        desc.integral = false;
        desc.properties = new VDim[dim];
        for (int i = 0; i < dim; i++) {
            desc.properties[i] = new VDim(names[i], desc.type, desc.ctype, i);
        }
        return desc;
    }

    public static VDesc getDouble(int dim) {
        final String[] names = new String[]{"x", "y", "z", "w"};
        VDesc desc = new VDesc();
        desc._package = "essence.geometry.core.doubles";
        desc.corePackage = "essence.geometry.core";
        desc.dim = dim;
        desc.suffix = "d";
        desc.type = "double";
        desc.ctype = "Double";
        desc.integral = false;
        desc.properties = new VDim[dim];
        for (int i = 0; i < dim; i++) {
            desc.properties[i] = new VDim(names[i], desc.type, desc.ctype, i);
        }
        return desc;
    }

    public static VDesc getInteger(int dim) {
        final String[] names = new String[]{"x", "y", "z", "w"};
        VDesc desc = new VDesc();
        desc._package = "essence.geometry.core.integers";
        desc.corePackage = "essence.geometry.core";
        desc.dim = dim;
        desc.suffix = "i";
        desc.type = "int";
        desc.ctype = "Integer";
        desc.integral = true;
        desc.properties = new VDim[dim];
        for (int i = 0; i < dim; i++) {
            desc.properties[i] = new VDim(names[i], desc.type, desc.ctype, i);
        }
        return desc;
    }

    public static VDesc getByte(int dim) {
        final String[] names = new String[]{"x", "y", "z", "w"};
        VDesc desc = new VDesc();
        desc._package = "essence.geometry.core.bytes";
        desc.corePackage = "essence.geometry.core";
        desc.dim = dim;
        desc.suffix = "b";
        desc.type = "byte";
        desc.ctype = "Byte";
        desc.integral = true;
        desc.properties = new VDim[dim];
        for (int i = 0; i < dim; i++) {
            desc.properties[i] = new VDim(names[i], desc.type, desc.ctype, i);
        }
        return desc;
    }

    public String getTupleName() {
        return "Tuple" + dim;
    }

    public String getTupleTypeName() {
        return "Tuple" + dim + "_" + ctype;
    }

    public String getTupleNumberName() {
        return "Tuple" + dim + "_Number";
    }

    public String getTupleImpName() {
        return "Tuple" + dim + suffix;
    }

    public String getVectorName() {
        return "Vector" + dim;
    }

    public String getVectorImpName() {
        return "Vector" + dim + suffix;
    }

    public String getPointName() {
        return "Point" + dim;
    }

    public String getPointImpName() {
        return "Point" + dim + suffix;
    }

    public String getColorName() {
        return "Color" + dim;
    }

    public String getColorImpName() {
        return "Color" + dim + suffix;
    }

    public String getTupleImpListName() {
        return getTupleImpName() + "List";
    }

    /**
     * This function gets a vector descriptor of a {@code dim - 1} dimension.
     */
    public VDesc getLowerDimension() {
        if (this.dim <= 2) {
            return null;
        }
        VDesc lower = new VDesc();
        lower._package = _package;
        lower.corePackage = corePackage;
        lower.dim = dim - 1;
        lower.suffix = suffix;
        lower.type = type;
        lower.ctype = ctype;
        lower.integral = integral;
        lower.properties = new VDim[lower.dim];
        for (int i = 0; i < lower.properties.length; i++) {
            lower.properties[i] = properties[i];
        }
        return lower;
    }

    public String _package;
    public String corePackage;
    public int dim;
    public String suffix;
    public String type;
    public String ctype;
    public boolean integral;
    public VDim[] properties;

    public boolean is2D() {
        return dim == 2;
    }

    public boolean is3D() {
        return dim == 3;
    }
}

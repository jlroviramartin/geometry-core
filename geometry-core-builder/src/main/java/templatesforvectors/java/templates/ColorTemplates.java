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
package templatesforvectors.java.templates;

import templatesforvectors.model.VectorDescription;

/**
 *
 * @author joseluis
 */
public class ColorTemplates extends JavaTemplate {

    private final Template color = load(subPath + "/colors/Color.pebble");
    private final Template colorImp = load(subPath + "/colors/ColorImp.pebble");
    private final Template buffcolor = load(subPath + "/buffcolors/BuffColor.pebble");
    private final Template buffcolorImp = load(subPath + "/buffcolors/BuffColorImp.pebble");

    @Override
    public void execute() {

        buildSimple(3);
        buildSimple(4);
        buildFloat(3);
        buildFloat(4);
        buildByte(3);
        buildByte(4);
    }

    private void buildSimple(int dim) {
        VectorDescription desc = VectorDescription.getDefault(dim);
        writeToFile(color, desc, desc.getColorName(), desc._package);
        writeToFile(buffcolor, desc, desc.getBuffColorName(), desc._package);
    }

    private void buildFloat(int dim) {
        VectorDescription desc = VectorDescription.getFloat(dim);
        desc.minValue = 0;
        desc.maxValue = 1;
        writeToFile(colorImp, desc, desc.getColorImpName(), desc._package);
        writeToFile(buffcolorImp, desc, desc.getBuffColorImpName(), desc._package);
    }

    private void buildByte(int dim) {
        VectorDescription desc = VectorDescription.getByte(dim);
        desc.minValue = 0;
        desc.maxValue = 255;
        writeToFile(colorImp, desc, desc.getColorImpName(), desc._package);
        writeToFile(buffcolorImp, desc, desc.getBuffColorImpName(), desc._package);
    }
}

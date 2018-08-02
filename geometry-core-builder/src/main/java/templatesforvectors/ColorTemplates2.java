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
 *
 * @author joseluis
 */
public class ColorTemplates2 extends BaseTemplate {

    private final Template color = load("pebble/colors/Color.pebble");
    private final Template colorImp = load("pebble/colors/ColorImp.pebble");
    private final Template buffcolor = load("pebble/buffcolors/BuffColor.pebble");
    private final Template buffcolorImp = load("pebble/buffcolors/BuffColorImp.pebble");

    @Override
    public void execute() {

        System.out.println("user.dir  " + System.getProperty("user.dir"));
        System.out.println("main path " + mainPath);

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
        writeToFile(colorImp, desc, desc.getColorImpName(), desc._package);
        writeToFile(buffcolorImp, desc, desc.getBuffColorImpName(), desc._package);
    }

    private void buildByte(int dim) {
        VectorDescription desc = VectorDescription.getByte(dim);
        writeToFile(colorImp, desc, desc.getColorImpName(), desc._package);
        writeToFile(buffcolorImp, desc, desc.getBuffColorImpName(), desc._package);
    }
}

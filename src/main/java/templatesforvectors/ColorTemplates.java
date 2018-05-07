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
public class ColorTemplates extends BaseTemplate {

    private final Template color = loadPebbleResource("pebble/Color.pebble");
    private final Template colorImp = loadPebbleResource("pebble/ColorImp.pebble");

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
        VDesc desc = VDesc.getDefault(dim);
        exec(color, desc, desc.getColorName(), desc._package);
    }

    private void buildFloat(int dim) {
        VDesc desc = VDesc.getFloat(dim);
        exec(colorImp, desc, desc.getColorImpName(), desc._package);
    }

    private void buildByte(int dim) {
        VDesc desc = VDesc.getByte(dim);
        exec(colorImp, desc, desc.getColorImpName(), desc._package);
    }
}

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
public class VectorTemplates extends BaseTemplate {

    private final Template vector = loadPebbleResource("pebble/Vector.pebble");
    private final Template vectorImp = loadPebbleResource("pebble/VectorImp.pebble");

    @Override
    public void execute() {

        System.out.println("user.dir  " + System.getProperty("user.dir"));
        System.out.println("main path " + mainPath);

        for (int i = 2; i <= 4; i++) {
            buildSimple(i);
            buildFloat(i);
            buildDouble(i);
        }
        buildInteger(2);
    }

    private void buildSimple(int dim) {
        VectorDescription desc = VectorDescription.getDefault(dim);
        exec(vector, desc, desc.getVectorName(), desc._package);
    }

    private void buildFloat(int dim) {
        VectorDescription desc = VectorDescription.getFloat(dim);
        exec(vectorImp, desc, desc.getVectorImpName(), desc._package);
    }

    private void buildDouble(int dim) {
        VectorDescription desc = VectorDescription.getDouble(dim);
        exec(vectorImp, desc, desc.getVectorImpName(), desc._package);
    }

    private void buildInteger(int dim) {
        VectorDescription desc = VectorDescription.getInteger(dim);
        exec(vectorImp, desc, desc.getVectorImpName(), desc._package);
    }
}

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

import templatesforvectors.BaseTemplate;
import templatesforvectors.model.VectorDescription;

/**
 *
 * @author joseluis
 */
public class VectorTemplates extends BaseTemplate {

    private final Template vector = load("pebble/java/vectors/Vector.pebble");
    private final Template vectorImp = load("pebble/java/vectors/VectorImp.pebble");

    private final Template buffvector = load("pebble/java/buffvectors/BuffVector.pebble");
    private final Template buffvectorImp = load("pebble/java/buffvectors/BuffVectorImp.pebble");

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
        writeToFile(vector, desc, desc.getVectorName(), desc._package);

        writeToFile(buffvector, desc, desc.getBuffVectorName(), desc._package);
    }

    private void buildFloat(int dim) {
        VectorDescription desc = VectorDescription.getFloat(dim);
        writeToFile(vectorImp, desc, desc.getVectorImpName(), desc._package);

        writeToFile(buffvectorImp, desc, desc.getBuffVectorImpName(), desc._package);
    }

    private void buildDouble(int dim) {
        VectorDescription desc = VectorDescription.getDouble(dim);
        writeToFile(vectorImp, desc, desc.getVectorImpName(), desc._package);

        writeToFile(buffvectorImp, desc, desc.getBuffVectorImpName(), desc._package);
    }

    private void buildInteger(int dim) {
        VectorDescription desc = VectorDescription.getInteger(dim);
        writeToFile(vectorImp, desc, desc.getVectorImpName(), desc._package);

        writeToFile(buffvectorImp, desc, desc.getBuffVectorImpName(), desc._package);
    }
}

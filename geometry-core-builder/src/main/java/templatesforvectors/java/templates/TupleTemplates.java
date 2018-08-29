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
public class TupleTemplates extends JavaTemplate {

    private final Template bufftupleImp = load(subPath + "/bufftuples/BuffTupleImp.pebble");
    private final Template tupleImp = load(subPath + "/tuples/TupleImp.pebble");
    private final Template tupleImpList = load(subPath + "/collections/TupleImpList.pebble");

    @Override
    public void execute() {

        for (int i = 2; i <= 4; i++) {
            buildSimple(i);

            buildFloat(i);
            buildDouble(i);
        }
        buildInteger(2);
        buildByte(3);
        buildByte(4);
    }

    private void buildSimple(int dim) {
        VectorDescription desc = VectorDescription.getDefault(dim);
    }

    private void buildFloat(int dim) {
        VectorDescription desc = VectorDescription.getFloat(dim);
        writeToFile(tupleImp, desc, desc.getTupleImpName(), desc._package);
        writeToFile(bufftupleImp, desc, desc.getBuffTupleImpName(), desc._package);

        //writeToFile(tupleImpList, desc, desc.getTupleImpListName(), desc._package);
    }

    private void buildDouble(int dim) {
        VectorDescription desc = VectorDescription.getDouble(dim);
        writeToFile(tupleImp, desc, desc.getTupleImpName(), desc._package);
        writeToFile(bufftupleImp, desc, desc.getBuffTupleImpName(), desc._package);

        //writeToFile(tupleImpList, desc, desc.getTupleImpListName(), desc._package);
    }

    private void buildInteger(int dim) {
        VectorDescription desc = VectorDescription.getInteger(dim);
        writeToFile(tupleImp, desc, desc.getTupleImpName(), desc._package);
        writeToFile(bufftupleImp, desc, desc.getBuffTupleImpName(), desc._package);
    }

    private void buildByte(int dim) {
        VectorDescription desc = VectorDescription.getByte(dim);
        writeToFile(tupleImp, desc, desc.getTupleImpName(), desc._package);
        writeToFile(bufftupleImp, desc, desc.getBuffTupleImpName(), desc._package);
    }
}

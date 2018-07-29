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
public class TupleTemplates extends BaseTemplate {

    private final Template tuple_Number = load("pebble/Tuple_Number.pebble");
    private final Template tuple_Type = load("pebble/Tuple_Type.pebble");
    private final Template tupleImp = load("pebble/TupleImp.pebble");
    private final Template tupleImpList = load("pebble/collections/TupleImpList.pebble");

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
        buildByte(3);
        buildByte(4);
    }

    private void buildSimple(int dim) {
        VectorDescription desc = VectorDescription.getDefault(dim);
        writeToFile(tuple_Number, desc, desc.getTupleNumberName(), desc._package);
    }

    private void buildFloat(int dim) {
        VectorDescription desc = VectorDescription.getFloat(dim);
        writeToFile(tuple_Type, desc, desc.getTupleTypeName(), desc._package);
        writeToFile(tupleImp, desc, desc.getTupleImpName(), desc._package);
        writeToFile(tupleImpList, desc, desc.getTupleImpListName(), desc._package);
    }

    private void buildDouble(int dim) {
        VectorDescription desc = VectorDescription.getDouble(dim);
        writeToFile(tuple_Type, desc, desc.getTupleTypeName(), desc._package);
        writeToFile(tupleImp, desc, desc.getTupleImpName(), desc._package);
        writeToFile(tupleImpList, desc, desc.getTupleImpListName(), desc._package);
    }

    private void buildInteger(int dim) {
        VectorDescription desc = VectorDescription.getInteger(dim);
        writeToFile(tuple_Type, desc, desc.getTupleTypeName(), desc._package);
        writeToFile(tupleImp, desc, desc.getTupleImpName(), desc._package);
    }

    private void buildByte(int dim) {
        VectorDescription desc = VectorDescription.getByte(dim);
        writeToFile(tuple_Type, desc, desc.getTupleTypeName(), desc._package);
        writeToFile(tupleImp, desc, desc.getTupleImpName(), desc._package);
    }
}

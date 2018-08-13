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

import java.util.ArrayList;
import java.util.List;
import templatesforvectors.BaseTemplate;
import templatesforvectors.model.MatrixDescription;
import templatesforvectors.model.TupleUtilsDescription;
import templatesforvectors.model.VectorDescription;

/**
 *
 * @author joseluis
 */
public class TupleTemplates extends BaseTemplate {

    private final Template bufftupleImp = load("pebble/java/bufftuples/BuffTupleImp.pebble");

    private final Template tupleImp = load("pebble/java/tuples/TupleImp.pebble");
    private final Template tupleImpList = load("pebble/java/collections/TupleImpList.pebble");

    private final Template tupleUtils = load("pebble/java/TupleUtils.pebble");

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

        buildTupleUtils();
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

    private void buildTupleUtils() {
        TupleUtilsDescription desc = new TupleUtilsDescription();
        List<VectorDescription> aux = new ArrayList<>();
        for (int i = 2; i <= 4; i++) {
            aux.add(VectorDescription.getFloat(i));
            aux.add(VectorDescription.getDouble(i));
        }
        aux.add(VectorDescription.getInteger(2));
        aux.add(VectorDescription.getByte(3));
        aux.add(VectorDescription.getByte(4));

        List<MatrixDescription> maux = new ArrayList<>();
        for (int i = 2; i <= 4; i++) {
            maux.add(MatrixDescription.getFloat(i));
            maux.add(MatrixDescription.getDouble(i));
        }

        desc._package = VectorDescription.CORE_PACKAGE;
        desc.descriptors = aux.toArray(new VectorDescription[aux.size()]);
        desc.mdescriptors = maux.toArray(new MatrixDescription[maux.size()]);

        writeToFile(tupleUtils, desc, "TupleUtils", desc._package);
    }
}

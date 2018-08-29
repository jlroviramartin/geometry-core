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
package templatesforvectors.cs.templates;

import templatesforvectors.model.MatrixDescription;

/**
 *
 * @author joseluis
 */
public class MatrixTemplates extends CsTemplate {

    private final Template matrixImpPebble = load(subPath + "/matrices/MatrixImp.pebble");
    private final Template matrixPebble = load(subPath + "/matrices/Matrix.pebble");
    private final Template buffmatrixPebble = load(subPath + "/matrices/BuffMatrix.pebble");

    @Override
    public void execute() {

        for (int i = 2; i <= 4; i++) {
            buildSimple(i);
            buildFloat(i);
            buildDouble(i);
        }
    }

    private void buildSimple(int dim) {
        MatrixDescription mdesc = MatrixDescription.getDefault(dim);
        writeToFile(matrixPebble, mdesc, mdesc.getMatrixName(), mdesc._package);
        writeToFile(buffmatrixPebble, mdesc, mdesc.getBuffMatrixName(), mdesc._package);
    }

    private void buildFloat(int dim) {
        MatrixDescription mdesc = MatrixDescription.getFloat(dim);
        writeToFile(matrixImpPebble, mdesc, mdesc.getMatrixImpName(), mdesc._package);

        //writeToFile(matrixGetterTypePebble, mdesc, mdesc.getMatrixGetterTypeName(), mdesc._package);
        //writeToFile(matrixSetterTypePebble, mdesc, mdesc.getMatrixSetterTypeName(), mdesc._package);
    }

    private void buildDouble(int dim) {
        MatrixDescription mdesc = MatrixDescription.getDouble(dim);
        writeToFile(matrixImpPebble, mdesc, mdesc.getMatrixImpName(), mdesc._package);

        //writeToFile(matrixGetterTypePebble, mdesc, mdesc.getMatrixGetterTypeName(), mdesc._package);
        //writeToFile(matrixSetterTypePebble, mdesc, mdesc.getMatrixSetterTypeName(), mdesc._package);
    }
}

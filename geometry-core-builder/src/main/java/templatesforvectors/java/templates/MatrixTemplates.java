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
import templatesforvectors.model.MatrixDescription;

/**
 *
 * @author joseluis
 */
public class MatrixTemplates extends BaseTemplate {

    private final Template matrixImpPebble = load("pebble/java/matrices/MatrixImp.pebble");

    private final Template matrixPebble = load("pebble/java/matrices/Matrix.pebble");
    private final Template buffmatrixPebble = load("pebble/java/matrices/BuffMatrix.pebble");

    private final Template matrixGetterTypePebble = load("pebble/java/matrices/gettersetter/MatrixGetter_Type.pebble");
    private final Template matrixSetterTypePebble = load("pebble/java/matrices/gettersetter/Matrixsetter_Type.pebble");

    @Override
    public void execute() {

        System.out.println("user.dir  " + System.getProperty("user.dir"));
        System.out.println("main path " + mainPath);

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

        writeToFile(matrixGetterTypePebble, mdesc, mdesc.getMatrixGetterTypeName(), mdesc._package);
        writeToFile(matrixSetterTypePebble, mdesc, mdesc.getMatrixSetterTypeName(), mdesc._package);
    }

    private void buildDouble(int dim) {
        MatrixDescription mdesc = MatrixDescription.getDouble(dim);
        writeToFile(matrixImpPebble, mdesc, mdesc.getMatrixImpName(), mdesc._package);

        writeToFile(matrixGetterTypePebble, mdesc, mdesc.getMatrixGetterTypeName(), mdesc._package);
        writeToFile(matrixSetterTypePebble, mdesc, mdesc.getMatrixSetterTypeName(), mdesc._package);
    }
}

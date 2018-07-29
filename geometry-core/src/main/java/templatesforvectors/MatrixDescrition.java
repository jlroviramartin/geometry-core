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

import java.util.Arrays;

/**
 * Description of a matrix.
 */
public class MatrixDescrition {

    public static MatrixDescrition getDouble(int dim) {
        MatrixDescrition mdesc = new MatrixDescrition();
        mdesc._package = "essence.geometry.core.doubles";
        mdesc.corePackage = "essence.geometry.core";
        mdesc.dimRows = dim;
        mdesc.dimCols = dim;
        mdesc.suffix = "d";
        mdesc.type = "double";
        mdesc.ctype = "Double";
        mdesc.properties = new MatrixCell[dim * dim];

        mdesc.vector = VectorDescription.getDouble(dim);

        int i = 0;
        for (int r = 0; r < mdesc.dimRows; r++) {
            for (int c = 0; c < mdesc.dimCols; c++) {
                mdesc.properties[i] = new MatrixCell("m" + r + "" + c, mdesc.type, mdesc.ctype, r, c);
                i++;
            }
        }
        return mdesc;
    }

    public static MatrixDescrition getFloat(int dim) {
        MatrixDescrition mdesc = new MatrixDescrition();
        mdesc._package = "essence.geometry.core.floats";
        mdesc.corePackage = "essence.geometry.core";
        mdesc.dimRows = dim;
        mdesc.dimCols = dim;
        mdesc.suffix = "f";
        mdesc.type = "float";
        mdesc.ctype = "Float";
        mdesc.properties = new MatrixCell[dim * dim];

        mdesc.vector = VectorDescription.getFloat(dim);

        int i = 0;
        for (int r = 0; r < mdesc.dimRows; r++) {
            for (int c = 0; c < mdesc.dimCols; c++) {
                mdesc.properties[i] = new MatrixCell("m" + r + "" + c, mdesc.type, mdesc.ctype, r, c);
                i++;
            }
        }
        return mdesc;
    }

    public String getMatrixImpName() {
        return "Matrix" + dimRows + "x" + dimCols + suffix;
    }

    public String _package;
    public String corePackage;
    public int dimRows;
    public int dimCols;
    public String suffix;
    public String type;
    public String ctype;
    public MatrixCell[] properties;

    public VectorDescription vector;

    // Rows -> Cols
    public Row[] getRows() {
        Row[] rows = new Row[dimRows];
        for (int r = 0; r < dimRows; r++) {
            rows[r] = new Row();
            rows[r].r = r;
            rows[r].cols = new MatrixCell[dimCols];
            for (int c = 0; c < dimCols; c++) {
                rows[r].cols[c] = getProperty(r, c);
            }
        }
        return rows;
    }

    // Cols -> Rows
    public Col[] getCols() {
        Col[] cols = new Col[dimCols];
        for (int c = 0; c < dimCols; c++) {
            cols[c] = new Col();
            cols[c].c = c;
            cols[c].rows = new MatrixCell[dimRows];
            for (int r = 0; r < dimRows; r++) {
                cols[c].rows[r] = getProperty(r, c);
            }
        }
        return cols;
    }

    public MatrixCell getProperty(int r, int c) {
        return Arrays.asList(properties).stream().filter((x) -> x.r == r && x.c == c).findFirst().orElse(null);
    }

    public class Row {

        public int getR() {
            return r;
        }

        public MatrixCell[] getCols() {
            return cols;
        }

        public int r;
        public MatrixCell[] cols;
    }

    public class Col {

        public int getC() {
            return c;
        }

        public MatrixCell[] getRows() {
            return rows;
        }

        public int c;
        public MatrixCell[] rows;
    }
}

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
package org.essence.astyle;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joseluis
 */
public interface Astyle {

    public static final Astyle INSTANCE = create();

    public static Astyle create() {
        AstyleWindows aux = null;
        try {
            aux = new AstyleWindows();
        } catch (IOException ex) {
            Logger.getLogger(Astyle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aux;
    }

    void astyle(String... args) throws IOException;

    default public void javaBeautify(File file) throws IOException {
        javaBeautify(file.getAbsolutePath());
    }

    default public void javaBeautify(String file) throws IOException {
        astyle("--style=java", "-n", file);
    }
}

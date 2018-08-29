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

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.essence.astyle.Astyle;
import templatesforvectors.BaseTemplate;

/**
 *
 * @author joseluis
 */
public abstract class JavaTemplate extends BaseTemplate {

    private static final Logger LOGGER = Logger.getLogger(JavaTemplate.class.getName());
    private final static String mainPath = System.getProperty("user.dir") + "\\..\\geometry-core\\src\\generated\\java";
    private final static String Ext = ".java";
    public final static String subPath = "pebble/java";

    public JavaTemplate() {
        super(mainPath, Ext);
    }

    @Override
    public void beautify(String fileName) {
        if (Astyle.INSTANCE != null) {
            try {
                Astyle.INSTANCE.javaBeautify(fileName);
            } catch (IOException ex) {
                LOGGER.log(Level.SEVERE, null, ex);
            }
        }
    }
}

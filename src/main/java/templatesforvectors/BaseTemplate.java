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

import org.essence.pebble.TemplateEngine;

/**
 *
 * @author joseluis
 */
public abstract class BaseTemplate extends TemplateEngine {

//<editor-fold defaultstate="collapsed" desc="fields">
    //protected final String mainPath = "C:\\Users\\joseluis\\source\\Java\\TemplatesForVectors\\src\\generated\\java";
    protected final String mainPath = System.getProperty("user.dir") + "\\src\\generated\\java";
//</editor-fold>

    public abstract void execute();

    protected void writeToFile(Template template, Object desc, String className, String _package) {
        String fileName = mainPath + "\\" + _package.replace('.', '\\') + '\\' + className + ".java";

        template.writeToFile(new MapBuilder<String, Object>().put("desc", desc).build(),
                             fileName);
    }
}

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

import java.util.logging.Level;
import java.util.logging.Logger;
import org.essence.pebble.TemplateEngine;

/**
 *
 * @author joseluis
 */
public abstract class BaseTemplate extends TemplateEngine {

//<editor-fold defaultstate="collapsed" desc="fields">
    private static final Logger LOGGER = Logger.getLogger(BaseTemplate.class.getName());
    private final String mainPath;
    private final String ext;
//</editor-fold>

    public BaseTemplate(String mainPath, String ext) {
        this.mainPath = mainPath;
        this.ext = ext;
    }

    public abstract void execute();

    protected void writeToFile(Template template, Object desc, String className, String _package) {
        String fileName = mainPath + "\\" + _package.replace('.', '\\') + '\\' + className + ext;

        LOGGER.log(Level.SEVERE, "Writing class " + _package + " " + className);

        template.writeToFile(new MapBuilder<String, Object>().put("desc", desc).build(),
                             fileName);

        beautify(fileName);
    }

    public void beautify(String fileName) {
    }
}

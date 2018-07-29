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

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joseluis
 */
public class AstyleWindows implements Astyle {

//<editor-fold defaultstate="collapsed" desc="fields">
    private static final Logger LOGGER = Logger.getLogger(AstyleWindows.class.getName());
    private static final String ASTYLE_EXE = "astyle\\bin\\AStyle.exe";
    private final File srcPath;
//</editor-fold>

    public AstyleWindows() throws IOException {
        this(createTmp());
    }

    public AstyleWindows(File srcPath) {
        this.srcPath = srcPath;
        prepareAstyle(srcPath);
    }

//<editor-fold defaultstate="collapsed" desc="Astyle">
    @Override
    public void astyle(String... args) throws IOException {

        File aestyle = new File(srcPath, ASTYLE_EXE);
        List<String> asList = new ArrayList();
        asList.add(aestyle.toString());
        asList.addAll(Arrays.asList(args));
        try {
            Process process = new ProcessBuilder(asList.toArray(new String[asList.size()]))
                    .redirectErrorStream(true)
                    .start();

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    LOGGER.log(Level.INFO, line);
                }
            }
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
            throw ex;
        }
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="private">
    private static File createTmp() throws IOException {
        try {
            Path tmp = Files.createTempDirectory("astyle");
            File tempFile = tmp.toFile();
            tempFile.deleteOnExit();

            LOGGER.log(Level.INFO, "Creating tmp directory: " + tempFile);

            return tempFile;
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    private void prepareAstyle(File srcPath) {
        try {
            ResourceUtils.copyContent("app.astyle", new File(srcPath, "astyle"));
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }
//</editor-fold>
}

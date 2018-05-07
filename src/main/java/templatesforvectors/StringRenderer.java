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

import java.util.Locale;
import org.stringtemplate.v4.AttributeRenderer;

/**
 *
 * @author joseluis
 */
public class StringRenderer implements AttributeRenderer {

    @Override
    public String toString(Object o, String format, Locale locale) {
        String str = (String) o;
        if (format != null) {
            switch (format) {
                case "UpperFirst":
                    return Character.toUpperCase(str.charAt(0)) + str.substring(1);
                case "LowerFirst":
                    return Character.toLowerCase(str.charAt(0)) + str.substring(1);
                case "Upper":
                    return str.toUpperCase();
                case "Lower":
                    return str.toLowerCase();
            }
        }
        return o.toString();
    }
}

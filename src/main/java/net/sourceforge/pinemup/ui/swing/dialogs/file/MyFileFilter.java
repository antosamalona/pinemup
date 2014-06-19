/*
 * pin 'em up
 *
 * Copyright (C) 2007-2013 by Mario Ködding
 *
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package net.sourceforge.pinemup.ui.swing.dialogs.file;

import java.io.File;

import javax.swing.filechooser.FileFilter;

class MyFileFilter extends FileFilter {
   private final String ending;

   public boolean accept(File f) {
      return f.getName().toUpperCase().endsWith("." + ending) || f.isDirectory();
   }

   public String getDescription() {
      return "*." + ending.toLowerCase();
   }

   public MyFileFilter(String ending) {
      super();
      this.ending = ending.toUpperCase();
   }
}

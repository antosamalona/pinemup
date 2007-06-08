/*
 * pin 'em up
 * 
 * Copyright (C) 2007 by Mario Koedding
 *
 *
 * pin 'em up is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * pin 'em up is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with pin 'em up; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 */

package net.sourceforge.pinemup.logic;

import java.awt.*;

public class TrayMenu extends PopupMenu {

   /**
    * 
    */
   private static final long serialVersionUID = 1L;

   private MenuItem exportItem, aboutItem, closeItem, addNoteItem, showAllItem, hideAllItem, showSettingsDialogItem, ftpUploadItem, ftpDownloadItem;

   private Menu[] catMenu;
   
   public TrayMenu() {
      // title and notes actions
      super("pin 'em up");
      addNoteItem = new MenuItem("add note");
      addNoteItem.setActionCommand("AddNote");
      addNoteItem.addActionListener(PinEmUp.getMenuListener());
      add(addNoteItem);
      showAllItem = new MenuItem("show all notes");
      showAllItem.setActionCommand("ShowAllNotes");
      showAllItem.addActionListener(PinEmUp.getMenuListener());
      add(showAllItem);
      hideAllItem = new MenuItem("hide all notes");
      hideAllItem.setActionCommand("HideAllNotes");
      hideAllItem.addActionListener(PinEmUp.getMenuListener());
      add(hideAllItem);
      
      // categories menu
      Menu categoriesMenu = new Menu("category actions");
      add(categoriesMenu);
      catMenu = new Menu[5];
      MenuItem[] showOnlyCategoryItem = new MenuItem[5];
      MenuItem[] hideCategoryItem = new MenuItem[5];
      MenuItem[] showCategoryItem = new MenuItem[5];
      MenuItem[] setTempDefItem = new MenuItem[5];
      for (int i=0; i<5; i++) {
         catMenu[i] = new Menu((i+1) + " " + PinEmUp.getUserSettings().getCategoryNames()[i]);
         categoriesMenu.add(catMenu[i]);
         hideCategoryItem[i] = new MenuItem("hide all notes of this category");
         hideCategoryItem[i].setActionCommand("HideCategory"+i);
         hideCategoryItem[i].addActionListener(PinEmUp.getMenuListener());
         catMenu[i].add(hideCategoryItem[i]);
         showCategoryItem[i] = new MenuItem("show all notes of this category");
         showCategoryItem[i].setActionCommand("ShowCategory"+i);
         showCategoryItem[i].addActionListener(PinEmUp.getMenuListener());
         catMenu[i].add(showCategoryItem[i]);
         showOnlyCategoryItem[i] = new MenuItem("show only notes of this category");
         showOnlyCategoryItem[i].setActionCommand("ShowOnlyCategory"+i);
         showOnlyCategoryItem[i].addActionListener(PinEmUp.getMenuListener());
         catMenu[i].add(showOnlyCategoryItem[i]);
         catMenu[i].addSeparator();
         setTempDefItem[i] = new MenuItem("set temporarily as default");
         setTempDefItem[i].setActionCommand("SetTempDef"+i);
         setTempDefItem[i].addActionListener(PinEmUp.getMenuListener());
         catMenu[i].add(setTempDefItem[i]);
      }
      
      // im-/export menu      
      addSeparator();
      Menu imExMenu = new Menu("notes im-/export");
      Menu ftpMenu = new Menu("ftp");
      ftpUploadItem = new MenuItem("upload to ftp server");
      ftpUploadItem.setActionCommand("UploadNotesToFTP");
      ftpUploadItem.addActionListener(PinEmUp.getMenuListener());
      ftpMenu.add(ftpUploadItem);
      ftpDownloadItem = new MenuItem("download from ftp server");
      ftpDownloadItem.setActionCommand("DownloadNotesFromFTP");
      ftpDownloadItem.addActionListener(PinEmUp.getMenuListener());
      ftpMenu.add(ftpDownloadItem);
      imExMenu.add(ftpMenu);
      imExMenu.addSeparator();
      exportItem = new MenuItem("export to textfile");
      exportItem.setActionCommand("ExportToTextFile");
      exportItem.addActionListener(PinEmUp.getMenuListener());
      imExMenu.add(exportItem);
      add(imExMenu);
      
      // other items
      addSeparator();
      showSettingsDialogItem = new MenuItem("settings");
      showSettingsDialogItem.setActionCommand("ShowSettings");
      showSettingsDialogItem.addActionListener(PinEmUp.getMenuListener());
      add(showSettingsDialogItem);
      Menu helpMenu = new Menu("help");
      aboutItem = new MenuItem("about pin 'em up");
      aboutItem.setActionCommand("ShowAboutDialog");
      aboutItem.addActionListener(PinEmUp.getMenuListener());
      helpMenu.add(aboutItem);
      add(helpMenu);
      addSeparator();
      closeItem = new MenuItem("exit");
      closeItem.setActionCommand("Exit");
      closeItem.addActionListener(PinEmUp.getMenuListener());
      add(closeItem);
   }
   
   public void updateCategories() {
      for (int i=0; i<5; i++) {
         catMenu[i].setLabel((i+1) + " " + PinEmUp.getUserSettings().getCategoryNames()[i]);
      }
   }
}

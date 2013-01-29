package org.catacomb.druid.gui.base;


import org.catacomb.druid.swing.DListCellRenderer;
import org.catacomb.druid.swing.DListQuantityRenderer;


 
public class DruListQuantityRenderer implements DruListCellRenderer {
   static final long serialVersionUID = 1001;
  

   DListQuantityRenderer dRenderer;
   
   public DruListQuantityRenderer() {
      dRenderer = new DListQuantityRenderer();
   }
   
   public DListCellRenderer getGUIPeer() {
      return dRenderer;
   }
   
}


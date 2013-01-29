package org.psics.morph;

import org.psics.geom.Position;
import org.psics.util.FileUtil;

import java.io.File;



public class TreeWriter {

   TreePoint[] points;
   
   int pointCount;
   
   public TreeWriter(TreePoint[] tpa) {
         points = tpa;
   }
   
   
   public void writeSWC(File fout) {
      String s = serializeSWC();
      FileUtil.writeStringToFile(s, fout);
   }
   
   
   public String serializeSWC() {
      int np = points.length;
      for (int i = 0; i < np; i++) {
         points[i].setWork(-1);
      }
      StringBuffer sb = new StringBuffer();
      sb.append("cctswc00\n");
      pointCount = 0;
      
      for (int i = 0; i < np; i++) {
         if (points[i].getWork() < 0) {
            TreePoint p = points[i];
            recAppend(sb, p, -1);
         }
      }
      
      return sb.toString();
   }
   
   @SuppressWarnings("boxing")
   private void recAppend(StringBuffer sb, TreePoint tp, int ipar) {
      tp.setWork(pointCount);
      pointCount += 1;
      
      Position p = tp.getPosition();
      
      String s = String.format("%6d %10.5g %10.5g %10.5g %10.5g %6d ", 
                           tp.getWork(), p.getX(), p.getY(), p.getZ(), tp.getRadius(), ipar);
      sb.append(s);
      sb.append("\n");
      for (int i = 0; i < tp.nnbr; i++) {
         TreePoint pc = tp.nbr[i];
         if (pc.getWork() < 0) {
            recAppend(sb, pc, tp.getWork());
         }
      }
   }
   
   
}

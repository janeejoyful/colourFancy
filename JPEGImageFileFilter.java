// JPEGImageFileFilter.java
// This is for Project22stv110.java
// Janee Yeak
// This class is used in the TellTheColor class. (So that the logger can upload an image from his/her computer.)
// Many thanks to :: https://stackoverflow.com/questions/13512612/browse-for-image-file-and-display-it-using-java-swing

package Project22stv110;
import java.io.File;

import javax.swing.filechooser.FileFilter;


public class JPEGImageFileFilter extends FileFilter implements java.io.FileFilter
 {
 public boolean accept(File f)
   {
   if (f.getName().toLowerCase().endsWith(".jpeg")) return true;
   if (f.getName().toLowerCase().endsWith(".jpg")) return true;
   if(f.isDirectory())return true;
   return false;
  }
 public String getDescription()
   {
   return "JPEG files";
   }

} 
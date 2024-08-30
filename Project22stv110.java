// Project22stv110.java
// Janee Yeak
// 1 July 2021


package Project22stv110;

import java.awt.*;
import javax.swing.*; 
import javax.imageio.ImageIO;
    
      
public class Project22stv110 
{
   private static JMenuBar mb;
   
   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createPicture();
         }
      
      });
   }

   public static void createPicture() 
   {
      JFrame myFrame = new JFrame("All About Colors");
      myFrame.setSize(1024, 650);
      myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Display display = new Display();
      myFrame.add(display);
      
    //   create Menu Bar;
      mb = new JMenuBar();
      mb.add(display.getPane());

      myFrame.setJMenuBar(mb);
      myFrame.setLayout(null);
      myFrame.setVisible(true);
   }
}

// Display.java
// This is for Project22stv110.java
// Janee Yeak
// This class is where objects of the ColorCodes, ColorEncyclopedia, and TellTheColor class is created and added to the JTabbedPane.

package Project22stv110;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

import java.awt.image.BufferedImage;

import javax.swing.border.*;


public class Display extends JPanel
{
   JTabbedPane tabbedPane;
   
   public Display()
   {
       setPreferredSize(new Dimension(1024, 768));   
            
       ColorCodes cc = new ColorCodes();
       TellTheColor ttc = new TellTheColor();
       ColorEncyclopedia ce = new ColorEncyclopedia();
      
      try { 
      
      tabbedPane = new JTabbedPane();
      
      BufferedImage bi = ImageIO.read(new java.net.URL("https://st3.depositphotos.com/1156795/14258/v/1600/depositphotos_142584989-stock-illustration-color-wheel-or-color-circle.jpg")); 
      BufferedImage b2 = ImageIO.read(new java.net.URL("https://st2.depositphotos.com/3004689/8004/v/950/depositphotos_80045846-stock-illustration-handmade-color-wheel.jpg")); 
      BufferedImage b3 = ImageIO.read(new java.net.URL("https://st2.depositphotos.com/1472273/8141/v/950/depositphotos_81419162-stock-illustration-color-round-brush-strokes-background.jpg"));
      
      ImageIcon icon = new ImageIcon(bi);
      ImageIcon icon2 = new ImageIcon(b2);
      ImageIcon icon3 = new ImageIcon(b3);
      
      JPanel panel = new JPanel();
      
      tabbedPane.addTab("Tell the Color", icon, ttc,"Get the Color of any Picture");
      tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

      JComponent panel2 = makeTextPanel("Panel #2");
      tabbedPane.addTab("Color Codes", icon2, cc, "When you're not satisied the color found, but want someting similar.");
      tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);

      JComponent panel3 = makeTextPanel("Panel #3");
      tabbedPane.addTab("Color Encyclopedia", icon3, ce, "Search Up a Color to get Shades, Tints, and Complemetory colors");
      tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);     
      
      }
      catch (IOException exception) {} 
      
   }
  public JTabbedPane getPane()  {  return tabbedPane;  }

    protected JComponent makeTextPanel(String text) 
    {
      JPanel panel = new JPanel(false);
      JLabel filler = new JLabel(text);
      filler.setHorizontalAlignment(JLabel.CENTER);
      panel.setLayout(new GridLayout(1, 1));
      panel.add(filler);
      return panel;
   }
    
}
   
     

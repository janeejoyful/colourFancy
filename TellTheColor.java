// TellTheColor.java
// This is for Project22stv110.java
// Janee Yeak
// This class makes up one of the three JPanels (in the JTabbedPane). This class can derive the color 
// of a picture.

package Project22stv110;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

import javax.swing.border.EmptyBorder;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TellTheColor extends JPanel 
{
     private JPanel fields;
     private JPanel fields10S, fields20S, fields30S, fields40S, fields50S, fields60S, fields70S, fields80S, fields90S, fields100S;  // JTextFields for shades
     private JPanel fields10T, fields20T, fields30T, fields40T, fields50T, fields60T, fields70T, fields80T, fields90T, fields100T;  // JTextFields for tints
     private JLabel label, original, shades, tints;
     private JTextField red, green, blue, tf;
     private JTextField hex10S, hex20S, hex30S, hex40S, hex50S, hex60S, hex70S, hex80S, hex90S, hex100S; // JTextFields for the hex codes for the shades
     private JTextField hex10T, hex20T, hex30T, hex40T, hex50T, hex60T, hex70T, hex80T, hex90T, hex100T; // JTextFields for the hex codes for the tints 
     private JTextField percent10, percent20, percent30, percent40, percent50, percent60, percent70, percent80, percent90, percent100; 
     private JTextField whatsZeColor; // a TextField to tell the user what all this is about
     private JPanel originalColor;
     
     private File targetFile;
     private BufferedImage targetImg;
     
     private JTextArea area;     
     private static  Logger logger;
     private static final String basePath = "C:\\Documents and Settings\\Administrator\\Desktop\\Images";

   
   public TellTheColor()
   {
      setPreferredSize(new Dimension(1024, 768));     
      JMenuBar mb = new JMenuBar();
      tf = new JTextField("");
      logger = Logger.getLogger(Display.class.getName());
      whatsZeColor = new JTextField("Find the exact color of a picture; simply upload an image from your computer and click the pixel of the image"); 
      whatsZeColor.setEditable(false);
      
      setLayout(new GridBagLayout());
      GridBagConstraints c = new GridBagConstraints();
      c.fill = GridBagConstraints.HORIZONTAL;

      label = new JLabel();
      tints = new JLabel("Tints: ");
      shades = new JLabel("Shades: ");
      
      try {
            original = new JLabel("Original Color: "); 
            
            targetImg = ImageIO.read(new java.net.URL("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSFAhy8GM1F3_TyPjG7ezbeFRUy00PN4hpJCA&usqp=CAU"));
            label.setIcon(new ImageIcon(targetImg));  // rescal
                 
            
            c.weightx = 0.5;
            c.gridx = 0;
            c.gridy = 0;
            c.gridwidth = 10;
            c.gridheight = 1;
            
            add(whatsZeColor, c);
            
            c.gridx = 0;
            c.gridy = 1;
            c.gridwidth = 4;  
            c.gridheight = 4;
      
            add(label, c);
     
            area = new JTextArea("The color is below, with RGB values; click to see more");
            area.setEditable(false);
            
            c.gridx = 5;
            c.gridy = 1;
            c.gridwidth = 5;  
            c.gridheight =1;
            add(area, c);
            
            fields = new JPanel();
            red = new JTextField(3);
            green = new JTextField(3);
            blue = new JTextField(3);
            red.setEditable(false);
            green.setEditable(false);
            blue.setEditable(false);
            fields.add(red);
            fields.add(green);
            fields.add(blue); 
            
            c.gridx = 5;
            c.gridy = 2;
            c.gridwidth = 5;  
            c.gridheight = 1;
            add(fields, c);
            
            hex10S = new JTextField();  // HEx codes for all the shades
            hex20S = new JTextField();
            hex30S = new JTextField();
            hex40S = new JTextField();
            hex50S = new JTextField();
            hex60S = new JTextField();
            hex70S = new JTextField();
            hex80S = new JTextField();
            hex90S = new JTextField();
            hex100S = new JTextField();
            
            hex10T = new JTextField(); // Hex codes for all tints
            hex20T = new JTextField();
            hex30T = new JTextField();
            hex40T = new JTextField();
            hex50T = new JTextField();
            hex60T = new JTextField();
            hex70T = new JTextField();
            hex80T = new JTextField();
            hex90T = new JTextField();
            hex100T = new JTextField();
            
            
            hex10S.setVisible(false);   // Setting all the JTextField's visibility to false;
            hex20S.setVisible(false);
            hex30S.setVisible(false);
            hex40S.setVisible(false);
            hex50S.setVisible(false);
            hex60S.setVisible(false);
            hex70S.setVisible(false);
            hex80S.setVisible(false);
            hex90S.setVisible(false);
            hex100S.setVisible(false);
            
            hex10T.setVisible(false);  //  See the eariler comments...
            hex20T.setVisible(false);
            hex30T.setVisible(false);
            hex40T.setVisible(false);
            hex50T.setVisible(false);
            hex60T.setVisible(false);
            hex70T.setVisible(false);
            hex80T.setVisible(false);
            hex90T.setVisible(false);
            hex100T.setVisible(false);
             
            JTextField shade10 = new JTextField("10% Shade");    // Making JTextFIelds for the words...
            JTextField shade20 = new JTextField("20% Shade"); 
            JTextField shade30 = new JTextField("30% Shade");
            JTextField shade40 = new JTextField("40% Shade");
            JTextField shade50 = new JTextField("50% Shade");
            JTextField shade60 = new JTextField("60% Shade");
            JTextField shade70 = new JTextField("70% Shade");
            JTextField shade80 = new JTextField("80% Shade");
            JTextField shade90 = new JTextField("90% Shade");
            JTextField shade100 = new JTextField("100% Shade");
            
            JTextField tint10 = new JTextField("10% Tint");   // More JTextFields
            JTextField tint20 = new JTextField("20% Tint");
            JTextField tint30 = new JTextField("30% Tint");
            JTextField tint40 = new JTextField("40% Tint");
            JTextField tint50 = new JTextField("50% Tint");
            JTextField tint60 = new JTextField("60% Tint");
            JTextField tint70 = new JTextField("70% Tint");
            JTextField tint80 = new JTextField("80% Tint");
            JTextField tint90 = new JTextField("90% Tint");
            JTextField tint100 = new JTextField("100% Tint");
            
            
            fields10S = new JPanel();   // These are for the shades   
            fields20S = new JPanel();   // You gotta know what it looks like, right?
            fields30S = new JPanel(); 
            fields40S = new JPanel(); 
            fields50S = new JPanel(); 
            fields60S = new JPanel(); 
            fields70S = new JPanel(); 
            fields80S = new JPanel(); 
            fields90S = new JPanel(); 
            fields100S = new JPanel(); 

            fields10T = new JPanel();  // These are for Tints
            fields20T = new JPanel();  // See the above comments; THese are SOOO troublesome
            fields30T = new JPanel();
            fields40T = new JPanel();
            fields50T = new JPanel();
            fields60T = new JPanel();
            fields70T = new JPanel();
            fields80T = new JPanel();
            fields90T = new JPanel();
            fields100T = new JPanel();
            
            fields10S.setVisible(false);   // These are for the shades   
            fields20S.setVisible(false);   // You cant see me
            fields30S.setVisible(false);
            fields40S.setVisible(false);
            fields50S.setVisible(false);
            fields60S.setVisible(false);
            fields70S.setVisible(false);
            fields80S.setVisible(false);
            fields90S.setVisible(false);
            fields100S.setVisible(false);

            fields10T.setVisible(false);  // You also cannot see the tints.
            fields20T.setVisible(false);
            fields30T.setVisible(false);
            fields40T.setVisible(false);
            fields50T.setVisible(false);
            fields60T.setVisible(false);
            fields70T.setVisible(false);
            fields80T.setVisible(false);
            fields90T.setVisible(false);
            fields100T.setVisible(false);  
   
   
            percent10 = new JTextField("10%");    //// Names....
            percent20 = new JTextField("20%");
            percent30 = new JTextField("30%");
            percent40 = new JTextField("40%");
            percent50 = new JTextField("50%");
            percent60 = new JTextField("60%");
            percent70 = new JTextField("70%");
            percent80 = new JTextField("80%");
            percent90 = new JTextField("90%");
            percent100 = new JTextField("100%");
            
            percent10.setVisible(false);   // again, another classic magic trick...
            percent20.setVisible(false);
            percent30.setVisible(false);
            percent40.setVisible(false);
            percent50.setVisible(false);
            percent60.setVisible(false);
            percent70.setVisible(false);
            percent80.setVisible(false);
            percent90.setVisible(false);
            percent100.setVisible(false);
            
            shades.setVisible(false);
            tints.setVisible(false);
            
            originalColor = new JPanel();
            originalColor.setBorder(new EmptyBorder(5, 5, 1, 1));
                
            tf.setVisible(false);
            originalColor.setVisible(false);
            original.setVisible(false);
           
           
           /////////// Adding the stuff to the panel.     
       c.gridx = 5;
       c.gridy = 3;
       c.gridwidth = 5;  
       c.gridheight = 1;
            
       add(tf, c);
        
       c.gridwidth = 1;
       c.gridheight = 3;
       c.gridx = 5;
       c.gridy = 3;
       
       add(original, c);
       
       c.gridwidth = 1;
       c.gridheight = 7;
       c.gridx = 5;
       c.gridy = 4;
       
       add(originalColor, c);
      // Color shades
        
       c.gridwidth = 2;
       c.gridheight = 4;
       c.gridx = 0;
       c.gridy = 8;
       
       add(shades, c);
       
       c.gridwidth = 1;
       c.gridheight = 4;
       c.gridx = 2;
       c.gridy = 8;
       
       add(fields10S, c);
       
       c.gridwidth = 1;
       c.gridheight = 4;
       c.gridx = 3;
       c.gridy = 8;
       
       add(fields20S, c);
       
       c.gridwidth = 1;
       c.gridheight = 4;
       c.gridx = 4;
       c.gridy = 8;
       
       add(fields30S, c);
       
       c.gridwidth = 1;
       c.gridheight = 4;
       c.gridx = 5;
       c.gridy = 8;
       
       add(fields40S, c);
       
       c.gridwidth = 1;
       c.gridheight = 4;
       c.gridx = 6;
       c.gridy = 8;
       
       add(fields50S, c);
       
       c.gridwidth = 1;
       c.gridheight = 4;
       c.gridx = 7;
       c.gridy = 8;
       
       add(fields60S, c);
       
       c.gridwidth = 1;
       c.gridheight = 4;
       c.gridx = 8;
       c.gridy = 8;
       
       add(fields70S, c);
       
       c.gridwidth = 1;
       c.gridheight = 4;
       c.gridx = 9;
       c.gridy = 8;
       
       add(fields80S, c);
       
       c.gridwidth = 1;
       c.gridheight = 4;
       c.gridx = 10;
       c.gridy = 8;
       
       add(fields90S, c);
       
       c.gridwidth = 1;
       c.gridheight = 4;
       c.gridx = 11;
       c.gridy = 8;
       
       add(fields100S, c);
       
       
       //////// HEx codes //////////////
       
       c.gridwidth = 1;
       c.gridheight = 4;        
       c.gridx = 2;
       c.gridy = 12;
       
       add(hex10S, c);
       
       c.gridwidth = 1;
       c.gridheight = 4;
       c.gridx = 3;
       c.gridy = 12;
       
       add(hex20S, c);
       
       c.gridwidth = 1;
       c.gridheight = 4;
       c.gridx = 4;
       c.gridy = 12;
       
       add(hex30S, c);
       
       c.gridwidth = 1;
       c.gridheight = 4;
       c.gridx = 5;
       c.gridy = 12;
       
       add(hex40S, c);
       
       c.gridwidth = 1;
       c.gridheight = 4;
       c.gridx = 6;
       c.gridy = 12;
       
       add(hex50S, c);
       
       c.gridwidth = 1;
       c.gridheight = 4;
       c.gridx = 7;
       c.gridy = 12;
       
       add(hex60S, c);
       
       c.gridwidth = 1;
       c.gridheight = 4;
       c.gridx = 8;
       c.gridy = 12;
       
       add(hex70S, c);
       
       c.gridwidth = 1;
       c.gridheight = 4;
       c.gridx = 9;
       c.gridy = 12;
       
       add(hex80S, c);
       
       c.gridwidth = 1;
       c.gridheight = 4;
       c.gridx = 10;
       c.gridy = 12;
       
       add(hex90S, c);
       
       c.gridwidth = 1;
       c.gridheight = 4;
       c.gridx = 11;
       c.gridy = 12;
       
       add(hex100S, c);
       
     ////////////// Tint Fields /////////////////////////////////////////////////////////////////////////////////////////////////////  
       c.gridwidth = 2;
       c.gridheight = 4;
       c.gridx = 0;
       c.gridy = 16;
       
       add(tints, c);
       
       c.gridwidth = 1;
       c.gridheight = 4;
       c.gridx = 2;
       c.gridy = 16;
        
       add(fields10T, c);
       
       c.gridwidth = 1;
       c.gridheight = 4;
       c.gridx = 3;
       c.gridy = 16;
       
       add(fields20T, c);
       
       c.gridwidth = 1;
       c.gridheight = 4;
       c.gridx = 4;
       c.gridy = 16;
       
       add(fields30T, c);
       
       c.gridwidth = 1;
       c.gridheight = 4;
       c.gridx = 5;
       c.gridy = 16;
       
       add(fields40T, c);
       
       c.gridwidth = 1;
       c.gridheight = 4;
       c.gridx = 6;
       c.gridy = 16;
       
       add(fields50T, c);
       
       c.gridwidth = 1;
       c.gridheight = 4;
       c.gridx = 7;
       c.gridy = 16;
       
       add(fields60T, c);
       
       c.gridwidth = 1;
       c.gridheight = 4;
       c.gridx = 8;
       c.gridy = 16;
       
       add(fields70T, c);
       
       c.gridwidth = 1;
       c.gridheight = 4;
       c.gridx = 9;
       c.gridy = 16;
       
       add(fields80T, c);
       
       c.gridwidth = 1;
       c.gridheight = 4;
       c.gridx = 10;
       c.gridy = 16;
       
       add(fields90T, c);
       
       c.gridwidth = 1;
       c.gridheight = 4;
       c.gridx = 11;
       c.gridy = 16;
       
       add(fields100T, c);
       
       
       //////// HEx codes (tint)  /////// /////// /////// /////// /////// /////// /////// ///////
       
       c.gridwidth = 1;
       c.gridheight = 4;        
       c.gridx = 2;
       c.gridy = 20;
       
       add(hex10T, c);
       
       c.gridwidth = 1;
       c.gridheight = 4;
       c.gridx = 3;
       c.gridy = 20;
       
       add(hex20T, c);
       
       c.gridwidth = 1;
       c.gridheight = 4;
       c.gridx = 4;
       c.gridy = 20;
       
       add(hex30T, c);
       
       c.gridwidth = 1;
       c.gridheight = 4;
       c.gridx = 5;
       c.gridy = 20;
       
       add(hex40T, c);
       
       c.gridwidth = 1;
       c.gridheight = 4;
       c.gridx = 6;
       c.gridy = 20;
       
       add(hex50T, c);
       
       c.gridwidth = 1;
       c.gridheight = 4;
       c.gridx = 7;
       c.gridy = 20;
       
       add(hex60T, c);
       
       c.gridwidth = 1;
       c.gridheight = 4;
       c.gridx = 8;
       c.gridy = 20;
       
       add(hex70T, c);
       
       c.gridwidth = 1;
       c.gridheight = 4;
       c.gridx = 9;
       c.gridy = 20;
       
       add(hex80T, c);
       
       c.gridwidth = 1;
       c.gridheight = 4;
       c.gridx = 10;
       c.gridy = 20;
       
       add(hex90T, c);
       
       c.gridwidth = 1;
       c.gridheight = 4;
       c.gridx = 11;
       c.gridy = 20;
       
       add(hex100T, c);
       
////////////////////////////////////// /Percemtage markers //////////////////////////////////////////////////
      
       c.gridwidth = 1;
       c.gridheight = 4;
       c.gridx = 2;
       c.gridy = 24;
       
       add(percent10, c);
       
       c.gridwidth = 1;
       c.gridheight = 4;
       c.gridx = 3;
       c.gridy = 24;
       
       add(percent20, c);
       
       c.gridwidth = 1;
       c.gridheight = 4;
       c.gridx = 4;
       c.gridy = 24;
       
       add(percent30, c);
       
       c.gridwidth = 1;
       c.gridheight = 4;
       c.gridx = 5;
       c.gridy = 24;
       
       add(percent40, c);
       
       c.gridwidth = 1;
       c.gridheight = 4;
       c.gridx = 6;
       c.gridy = 24;
       
       add(percent50, c);
       
       c.gridwidth = 1;
       c.gridheight = 4;
       c.gridx = 7;
       c.gridy = 24;
       
       add(percent60, c);
       
       c.gridwidth = 1;
       c.gridheight = 4;
       c.gridx = 8;
       c.gridy = 24;
       
       add(percent70, c);
       
       c.gridwidth = 1;
       c.gridheight = 4;
       c.gridx = 9;
       c.gridy = 24;
       
       add(percent80, c);
       
       c.gridwidth = 1;
       c.gridheight = 4;
       c.gridx = 10;
       c.gridy = 24;
       
       add(percent90, c);
       
       c.gridwidth = 1;
       c.gridheight = 4;
       c.gridx = 11;
       c.gridy = 24;
       
       add(percent100, c);  

      label.addMouseListener(new MouseAdapter() {
      
   @Override
   public void mouseClicked(MouseEvent e) { }

   @Override
   public void mousePressed(MouseEvent e)
   {
      try { 
      int packedInt = targetImg.getRGB(e.getX(), e.getY());
      Color color = new Color(packedInt, true);                    
                    
      String r = Integer.toHexString(color.getRed());
      String g = Integer.toHexString(color.getGreen());
      String b = Integer.toHexString(color.getBlue());
             
      String hex = String.format("#%02X%02X%02X", color.getRed(), color.getGreen(), color.getBlue());
      tf.setText("The HTML Color Code is "+hex);

      fields10S.setBackground(new Color(getShade(color.getRed(), 0.1), getShade(color.getGreen(), 0.1), getShade(color.getBlue(), 0.1)));  // Setting the background colours to the shades
      fields20S.setBackground(new Color(getShade(color.getRed(), 0.2), getShade(color.getGreen(), 0.2), getShade(color.getBlue(), 0.2)));
      fields30S.setBackground(new Color(getShade(color.getRed(), 0.3), getShade(color.getGreen(), 0.3), getShade(color.getBlue(), 0.3)));
      fields40S.setBackground(new Color(getShade(color.getRed(), 0.4), getShade(color.getGreen(), 0.4), getShade(color.getBlue(), 0.4)));
      fields50S.setBackground(new Color(getShade(color.getRed(), 0.5), getShade(color.getGreen(), 0.5), getShade(color.getBlue(), 0.5)));
      fields60S.setBackground(new Color(getShade(color.getRed(), 0.6), getShade(color.getGreen(), 0.6), getShade(color.getBlue(), 0.6)));
      fields70S.setBackground(new Color(getShade(color.getRed(), 0.7), getShade(color.getGreen(), 0.7), getShade(color.getBlue(), 0.7)));
      fields80S.setBackground(new Color(getShade(color.getRed(), 0.8), getShade(color.getGreen(), 0.8), getShade(color.getBlue(), 0.8)));
      fields90S.setBackground(new Color(getShade(color.getRed(), 0.9), getShade(color.getGreen(), 0.9), getShade(color.getBlue(), 0.9)));
      fields100S.setBackground(new Color(getShade(color.getRed(), 1), getShade(color.getGreen(), 1), getShade(color.getBlue(), 1)));

      fields10T.setBackground(new Color(getTint(color.getRed(), 0.1), getTint(color.getGreen(), 0.1), getTint(color.getBlue(), 0.1)));   // Setting the background colours to the tints 
      fields20T.setBackground(new Color(getTint(color.getRed(), 0.2), getTint(color.getGreen(), 0.2), getTint(color.getBlue(), 0.2)));
      fields30T.setBackground(new Color(getTint(color.getRed(), 0.3), getTint(color.getGreen(), 0.3), getTint(color.getBlue(), 0.3)));
      fields40T.setBackground(new Color(getTint(color.getRed(), 0.4), getTint(color.getGreen(), 0.4), getTint(color.getBlue(), 0.4)));
      fields50T.setBackground(new Color(getTint(color.getRed(), 0.5), getTint(color.getGreen(), 0.5), getTint(color.getBlue(), 0.5)));
      fields60T.setBackground(new Color(getTint(color.getRed(), 0.6), getTint(color.getGreen(), 0.6), getTint(color.getBlue(), 0.6)));
      fields70T.setBackground(new Color(getTint(color.getRed(), 0.7), getTint(color.getGreen(), 0.7), getTint(color.getBlue(), 0.7)));
      fields80T.setBackground(new Color(getTint(color.getRed(), 0.8), getTint(color.getGreen(), 0.8), getTint(color.getBlue(), 0.8)));
      fields90T.setBackground(new Color(getTint(color.getRed(), 0.9), getTint(color.getGreen(), 0.9), getTint(color.getBlue(), 0.9)));
      fields100T.setBackground(new Color(getTint(color.getRed(), 1), getTint(color.getGreen(), 1), getTint(color.getBlue(), 1)));
      
      String sHex = "";
      
      sHex = String.format("#%02X%02X%02X", getShade(color.getRed(), 0.1), getShade(color.getGreen(), 0.1), getShade(color.getBlue(), 0.1));   // getting all the shades
      hex10S.setText(""+sHex);
      sHex = String.format("#%02X%02X%02X", getShade(color.getRed(), 0.2), getShade(color.getGreen(), 0.2), getShade(color.getBlue(), 0.2));
      hex20S.setText(""+sHex);
      sHex = String.format("#%02X%02X%02X", getShade(color.getRed(), 0.3), getShade(color.getGreen(), 0.3), getShade(color.getBlue(), 0.3));
      hex30S.setText(""+sHex);
      sHex = String.format("#%02X%02X%02X", getShade(color.getRed(), 0.4), getShade(color.getGreen(), 0.4), getShade(color.getBlue(), 0.4));
      hex40S.setText(""+sHex);
      sHex = String.format("#%02X%02X%02X", getShade(color.getRed(), 0.5), getShade(color.getGreen(), 0.5), getShade(color.getBlue(), 0.5));
      hex50S.setText(""+sHex);
      sHex = String.format("#%02X%02X%02X", getShade(color.getRed(), 0.6), getShade(color.getGreen(), 0.6), getShade(color.getBlue(), 0.6));
      hex60S.setText(""+sHex);
      sHex = String.format("#%02X%02X%02X", getShade(color.getRed(), 0.7), getShade(color.getGreen(), 0.7), getShade(color.getBlue(), 0.7));
      hex70S.setText(""+sHex);
      sHex = String.format("#%02X%02X%02X", getShade(color.getRed(), 0.8), getShade(color.getGreen(), 0.8), getShade(color.getBlue(), 0.8));
      hex80S.setText(""+sHex);
      sHex = String.format("#%02X%02X%02X", getShade(color.getRed(), 0.9), getShade(color.getGreen(), 0.9), getShade(color.getBlue(), 0.9));
      hex90S.setText(""+sHex);
      sHex = String.format("#%02X%02X%02X", getShade(color.getRed(), 1), getShade(color.getGreen(), 1), getShade(color.getBlue(), 1));
      hex100S.setText(""+sHex);
      
      sHex = String.format("#%02X%02X%02X", getTint(color.getRed(), 0.1), getTint(color.getGreen(), 0.1), getTint(color.getBlue(), 0.1));    // Getting all the tints
      hex10T.setText(""+sHex);
      sHex = String.format("#%02X%02X%02X", getTint(color.getRed(), 0.2), getTint(color.getGreen(), 0.2), getTint(color.getBlue(), 0.2));
      hex20T.setText(""+sHex);
      sHex = String.format("#%02X%02X%02X", getTint(color.getRed(), 0.3), getTint(color.getGreen(), 0.3), getTint(color.getBlue(), 0.3));
      hex30T.setText(""+sHex);
      sHex = String.format("#%02X%02X%02X", getTint(color.getRed(), 0.4), getTint(color.getGreen(), 0.4), getTint(color.getBlue(), 0.4));
      hex40T.setText(""+sHex);
      sHex = String.format("#%02X%02X%02X", getTint(color.getRed(), 0.5), getTint(color.getGreen(), 0.5), getTint(color.getBlue(), 0.5));
      hex50T.setText(""+sHex);
      sHex = String.format("#%02X%02X%02X", getTint(color.getRed(), 0.6), getTint(color.getGreen(), 0.6), getTint(color.getBlue(), 0.6));
      hex60T.setText(""+sHex);
      sHex = String.format("#%02X%02X%02X", getTint(color.getRed(), 0.7), getTint(color.getGreen(), 0.7), getTint(color.getBlue(), 0.7));
      hex70T.setText(""+sHex);
      sHex = String.format("#%02X%02X%02X", getTint(color.getRed(), 0.8), getTint(color.getGreen(), 0.8), getTint(color.getBlue(), 0.8));
      hex80T.setText(""+sHex);
      sHex = String.format("#%02X%02X%02X", getTint(color.getRed(), 0.9), getTint(color.getGreen(), 0.9), getTint(color.getBlue(), 0.9));
      hex90T.setText(""+sHex);
      sHex = String.format("#%02X%02X%02X", getTint(color.getRed(), 1), getTint(color.getGreen(), 1), getTint(color.getBlue(), 1));
      hex100T.setText(""+sHex);

      hex10S.setVisible(true);   // Setting all the JTextField's visibility to true;
      hex20S.setVisible(true);
      hex30S.setVisible(true);
      hex40S.setVisible(true);
      hex50S.setVisible(true);
      hex60S.setVisible(true);
      hex70S.setVisible(true);
      hex80S.setVisible(true);
      hex90S.setVisible(true);
      hex100S.setVisible(true);
            
      hex10T.setVisible(true);  //  See the eariler comments...
      hex20T.setVisible(true);
      hex30T.setVisible(true);
      hex40T.setVisible(true);
      hex50T.setVisible(true);
      hex60T.setVisible(true);
      hex70T.setVisible(true);
      hex80T.setVisible(true);
      hex90T.setVisible(true);
      hex100T.setVisible(true);
      
      fields10S.setVisible(true);   // These are for the shades   
      fields20S.setVisible(true);   // Visible now
      fields30S.setVisible(true);
      fields40S.setVisible(true);
      fields50S.setVisible(true);
      fields60S.setVisible(true);
      fields70S.setVisible(true);
      fields80S.setVisible(true);
      fields90S.setVisible(true);
      fields100S.setVisible(true);

      fields10T.setVisible(true);  // You now can see the tints.
      fields20T.setVisible(true);
      fields30T.setVisible(true);
      fields40T.setVisible(true);
      fields50T.setVisible(true);
      fields60T.setVisible(true);
      fields70T.setVisible(true);
      fields80T.setVisible(true);
      fields90T.setVisible(true);
      fields100T.setVisible(true); 
      
      percent10.setVisible(true);
      percent20.setVisible(true);
      percent30.setVisible(true);
      percent40.setVisible(true);
      percent50.setVisible(true);
      percent60.setVisible(true);
      percent70.setVisible(true);
      percent80.setVisible(true);
      percent90.setVisible(true);
      percent100.setVisible(true);
      
      shades.setVisible(true);
      tints.setVisible(true);
   
      tf.setVisible(true);
      fields50S.setVisible(true);
      fields50T.setVisible(true);
               
      originalColor.setBackground(color);
      originalColor.setVisible(true);
      original.setVisible(true);
                           
      }
      catch (ArrayIndexOutOfBoundsException exception) { }
   }
     
   });
   
   
     label.addMouseMotionListener(new MouseMotionListener() {
     
   @Override 
   public void mouseMoved(MouseEvent e)
   {      
      try {
         int packedInt = targetImg.getRGB(e.getX(), e.getY());
         Color color = new Color(packedInt, true);
         fields.setBackground(color);
         red.setText(Integer.toString(color.getRed()));
         green.setText(Integer.toString(color.getGreen()));
         blue.setText(Integer.toString(color.getBlue()));
         
         }
            
  


         catch (ArrayIndexOutOfBoundsException exception)  { }    
   } 
   
   @Override
   public void mouseDragged(MouseEvent e)  { } 
});                   
                     
   }           
      catch (IOException exception) {}
      JButton btnBrowse = new JButton("Browse");
      btnBrowse.setBounds(100, 100, 200, 200);
      btnBrowse.setVisible(true);         
      c.gridx = 6;
      c.gridy = 1;
      c.gridwidth = 2;  
      c.gridheight = 2;
             
      add(btnBrowse, c);
      btnBrowse.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
                browseButtonActionPerformed(e);
            }
        });
      }
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      Graphics2D g2d = (Graphics2D)g;
      g2d.setColor(Color.white);
      g2d.fillRect(0, 0, getWidth(), getHeight());
   }

    protected JComponent makeTextPanel(String text)   // COPYRIGHT, ORACLE :::  https://docs.oracle.com/javase/tutorial/uiswing/examples/components/TabbedPaneDemoProject/src/components/TabbedPaneDemo.java
    {
      JPanel panel = new JPanel(false);
      JLabel filler = new JLabel(text);
      filler.setHorizontalAlignment(JLabel.CENTER);
      panel.setLayout(new GridLayout(1, 1));
      panel.add(filler);
      return panel;
   }
    
   private void browseButtonActionPerformed(java.awt.event.ActionEvent evt) {   // Many thanks to https://stackoverflow.com/questions/13512612/browse-for-image-file-and-display-it-using-java-swing
        JFileChooser fc = new JFileChooser(basePath);
        fc.setFileFilter(new JPEGImageFileFilter());
        int res = fc.showOpenDialog(null);

        try {
            if (res == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                setTarget(file);
            } 
            else {
                JOptionPane.showMessageDialog(null,
                        "You must select one image to be the reference.", "Aborting...",
                        JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception iOException) {
        }
    
    }
    
    public void setTarget(File reference)  // Many thanks to  :: https://stackoverflow.com/questions/13512612/browse-for-image-file-and-display-it-using-java-swing
    {
        try {
            targetFile = reference;
            targetImg = rescale(ImageIO.read(reference));
        } catch (IOException ex) {
            logger.getLogger(Display.class.getName()).log(Level.SEVERE, null, ex);
        }
        label.setIcon(new ImageIcon(targetImg));
        
        repaint();
    }
    
    public BufferedImage rescale(BufferedImage originalImage)
    {
        BufferedImage resizedImage = new BufferedImage(300, 500, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, 300, 500, null);
        g.dispose();
        return resizedImage;
    }
    private int getShade(int value, double deg)
    {
       return (int)(Math.round(value*(1-deg)));  
    }
    private int getTint(int val, double deg)
    {
     return (int)(Math.round(val  +  (deg * (255 - val)))); 
    }
 
   
}
   
     

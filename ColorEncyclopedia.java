// ColorEncyclopedia.java
// This is for Project22stv110.java
// Janee Yeak
// This is one of the classes for the JTabbedPane; This class takes an entered color and gives
// Shades, Tints, and Complementory colors.

package Project22stv110;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;

@SuppressWarnings("unchecked")

public class ColorEncyclopedia extends JPanel implements ActionListener {
            
private String[] options;           // For ze tool bar.
private JComboBox myCBox;           // Also for ze toolbar.
private JToolBar toolbar;           // The aforementioned tool bar.
private JTextField htmlCode;        // HTML Code
private JTextField rgbRC, rgbGC, rgbBC;                              // RGB Red Code, RGB Green Code, RGB Blue Code
private JTextField cmykCC, cmykMC, cmykYC, cmykKC;                   // CMYK Cyan Code, CMYK Magneta Code, CMYK Yellow Code, CMYK Key Code....
private JLabel red, green, blue, cyan, magenta, yellow, key, html;   // Labels....
private String previousOption;
private GridBagConstraints c;
private JButton searchBn;              // Find out more about the colour, click on this button! :)
private JTextField colorInputted;      // the color that is inputted   Quick Fun Fact:: 'imput' is a mispelling of 'input' 
private JTextArea colorInfo;           // So that I can haeve multiple lines...
private JTextField shade20, shade40, shade60, shade80, shade100;  // For shades  (I got sick of getting 10, 20, 30... shades for the other one, so decided not to go crazy for this one.)
private JTextField tint20, tint40, tint60, tint80, tint100;       // For tints.
private JLabel tints, shades, compC;  // Labels, for tints and shades... 
private JTextField comColor;          // For complementary  colors
private JTextField original;          // For the shades and tints method, I need these to compare to complementary colours.
private JTextField textfield, whatThisIsAbout; // to contain text in the color entered, and a little thesis :)

    public ColorEncyclopedia() 
    {           
        setPreferredSize(new Dimension(600, 300));
        
        setLayout(new GridBagLayout());
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        
        whatThisIsAbout = new JTextField("Search up a color and press the 'Look Up' button to learn more about it; Please enter RGB values in the 0..255 range, and CMYK values in the 0..1 range.");
        whatThisIsAbout.setEditable(false);
        
        options = new String[3];
        options[0] = "HTML";
        options[1] = "RGB";
        options[2] = "CMYK";
        
        myCBox = new JComboBox(options);
        
        toolbar = new JToolBar();  
        toolbar.setRollover(true);  
         
        toolbar.add(myCBox);  
        
        htmlCode = new JTextField();
        rgbRC = new JTextField();
        rgbGC = new JTextField();
        rgbBC = new JTextField();
        cmykCC = new JTextField();
        cmykMC = new JTextField();
        cmykYC = new JTextField();
        cmykKC = new JTextField();
        
        shade20 = new JTextField();
        shade40 = new JTextField();
        shade60 = new JTextField();
        shade80 = new JTextField();
        shade100 = new JTextField();
        
        tint20 = new JTextField();
        tint40 = new JTextField();
        tint60 = new JTextField();
        tint80 = new JTextField();
        tint100 = new JTextField();
        
        tints = new JLabel("Tints: ");
        shades = new JLabel("Shades: ");
         
        red = new JLabel("Red:");
        blue = new JLabel("Blue:");
        green = new JLabel("Green:");
        cyan = new JLabel("Cyan:");
        magenta = new JLabel("Magenta:");
        yellow = new JLabel("Yellow:");
        key = new JLabel("Key:");
        html = new JLabel("HTML:");
        
        colorInputted = new JTextField();
        colorInfo = new JTextArea();
        
        comColor = new JTextField();
        textfield = new JTextField();
        
        compC = new JLabel("Complementary Colors: ");
        original = new JTextField();
        
        previousOption = "";
        
        searchBn = new JButton("Look Up");
        searchBn.addActionListener(this);
        
                
        myCBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
            
            if(ie.getStateChange() == ItemEvent.DESELECTED)        {
            previousOption = ie.getItem().toString();  }
   
            if(myCBox.getSelectedItem().equals("HTML"))
               htmlMethod(previousOption);
            else if(myCBox.getSelectedItem().equals("RGB"))
               rgbMethod(previousOption);
            else if(myCBox.getSelectedItem().equals("CMYK"))
               cmykMethod(previousOption);
            
            }
        });
        
                       
        c.weightx = 1;
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 1;
        c.gridwidth = 10;
        
        add(whatThisIsAbout, c);
        
        c.gridheight = 1;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 1;

        add(toolbar, c);
        
        if(myCBox.getSelectedItem().equals("HTML"))      {
            htmlMethod("");                                }       
        else if(myCBox.getSelectedItem().equals("RGB"))  {
            rgbMethod("");                                 }
        else if(myCBox.getSelectedItem().equals("CMYK")) {
            cmykMethod("");                                }

    }
    
    public void actionPerformed(ActionEvent e)
    {
         if(e.getActionCommand().equals("Look Up"))
         {
            if(myCBox.getSelectedItem().equals("HTML"))       {
                calculateHTML();                              }       
            else if(myCBox.getSelectedItem().equals("RGB"))   {
                calculateRGB();                               }
            else if(myCBox.getSelectedItem().equals("CMYK"))  {
                calculateCMYK();                              }
         }
    }
    
    private void calculateHTML()
    {
         String text = htmlCode.getText();
         String sixHex = "";
         boolean passed = false;
         
         if(text!=null)
         {
            if(text.length() == 6)        {   // For six letter hex codes like '35A0B4'
               sixHex = "#" + text;   passed = true;
            }
            else if(text.length() == 7)   { // For the nice person who includes a # hastag. #23F4A1
               sixHex = "" + text;    passed = true;
            }
            else if(text.length() == 3)   { // In case someone likes 3 letter hex codes... 'FFF'
               sixHex = "#" + text.substring(0, 1) + text.substring(0, 1) + text.substring(1, 2) + text.substring(1, 2) + text.substring(2, 3) + text.substring(2, 3);   passed = true;
            }
            else if(text.length() == 4)   { // in case someone inputted '#FFF' or something like that. 
               sixHex = "#" + text.substring(1, 2) + text.substring(1, 2) + text.substring(2, 3) + text.substring(2, 3) + text.substring(3, 4) + text.substring(3, 4);   passed = true;
            }
            else {  displayErrorMessage();  } 
            
            if(passed)  { 
               try { 
               
               Color myColor = Color.decode(""+sixHex);
               double redOne = (double)myColor.getRed() / 255.0;
               double greenOne = (double)myColor.getGreen() / 255.0;
               double blueOne = (double)myColor.getBlue() / 255.0;
               double kk = (double)1 - Math.max(Math.max(redOne, greenOne), blueOne);
               double cc = (double)(1-redOne-kk) / (1-kk);
               double mm = (double)(1-greenOne-kk) / (1-kk);
               double yy = (double)(1-blueOne-kk) / (1-kk);
               
               if(String.valueOf(kk).length() > 4)  {  
               kk = Double.parseDouble(String.valueOf(kk).substring(0, 4));   } 
               if(String.valueOf(cc).length() > 4)  {  
               cc = Double.parseDouble(String.valueOf(cc).substring(0, 4));   } 
               if(String.valueOf(mm).length() > 4)  {  
               mm = Double.parseDouble(String.valueOf(mm).substring(0, 4));   } 
               if(String.valueOf(yy).length() > 4)  {  
               yy = Double.parseDouble(String.valueOf(yy).substring(0, 4));   } 

               colorInputted.setBackground(myColor);
               colorInfo.setText("HTML:" + sixHex.toUpperCase() + "\nRGB:" + myColor.getRed() + ", " + myColor.getGreen() + ", " + myColor.getBlue() + ". \nCMYK:" + cc + ", " + mm + ", " + yy + ", " + kk + ".");
               colorInputted.setVisible(true);
               colorInfo.setVisible(true);
               
               c.gridx = 0;
               c.gridy = 2;
               c.gridheight = 1;
               c.gridwidth = 7;
                  
               add(colorInputted, c);
                     
               c.gridheight = 1;
               c.gridwidth = 1;
               c.gridx = 8;
               c.gridy = 2;
       
               add(colorInfo, c);
               
               createShadesEtTints(myColor.getRed(), myColor.getGreen(), myColor.getBlue());   // 'Et' means 'and' in Latin. :)
               
               revalidate();
               repaint();
               
               }
               catch (NumberFormatException exception) {  displayErrorMessage();  }
             }
         }
    }
    
    private void calculateRGB()
    {
         String valueR = rgbRC.getText();
         String valueG = rgbGC.getText();
         String valueB = rgbBC.getText();
         
         if (valueR!=null &&  valueG!=null  &&  valueB!=null)
         {
            try {
            Color myColor = new Color(Integer.parseInt(valueR), Integer.parseInt(valueG), Integer.parseInt(valueB));
            
            double redOne = (double)Integer.parseInt(valueR) / 255.0;
            double greenOne = (double)Integer.parseInt(valueG) / 255.0;
            double blueOne = (double)Integer.parseInt(valueB) / 255.0;
            double kk = (double)1 - Math.max(Math.max(redOne, greenOne), blueOne);
            double cc = (double)(1-redOne-kk) / (1-kk);
            double mm = (double)(1-greenOne-kk) / (1-kk);
            double yy = (double)(1-blueOne-kk) / (1-kk);
               
            if(String.valueOf(kk).length() > 4)  {  
            kk = Double.parseDouble(String.valueOf(kk).substring(0, 4));   } 
            if(String.valueOf(cc).length() > 4)  {  
            cc = Double.parseDouble(String.valueOf(cc).substring(0, 4));   } 
            if(String.valueOf(mm).length() > 4)  {  
            mm = Double.parseDouble(String.valueOf(mm).substring(0, 4));   } 
            if(String.valueOf(yy).length() > 4)  {  
            yy = Double.parseDouble(String.valueOf(yy).substring(0, 4));   } 
                           
            colorInputted.setBackground(myColor);
            colorInfo.setText("HTML:" + String.format("#%02X%02X%02X", Integer.parseInt(valueR), Integer.parseInt(valueG), Integer.parseInt(valueB))   + "\nRGB:" + valueR + ", " + valueG + ", " + valueB + ".\nCMYK:" + cc + ", " + mm + ", " + yy + ", " + kk + ".");
            colorInputted.setVisible(true);
            colorInfo.setVisible(true);
                   
            c.gridx = 0;
            c.gridy = 2;
            c.gridheight = 1;
            c.gridwidth = 7;
                  
            add(colorInputted, c);
                  
            c.gridheight = 1;
            c.gridwidth = 1;
            c.gridx = 8;
            c.gridy = 2;
       
            add(colorInfo, c);
            
            createShadesEtTints(Integer.parseInt(valueR), Integer.parseInt(valueG), Integer.parseInt(valueB));   // 'Et' means 'and' in Latin. :)
            
            revalidate();
            repaint();
            
            }
            catch (NumberFormatException exception) {  displayErrorMessage();  }
         }
         else  {  displayErrorMessage();  }
         
    }
    
    private void calculateCMYK()
    {
         String valueC = cmykCC.getText();
         String valueM = cmykMC.getText();
         String valueY = cmykYC.getText();
         String valueK = cmykKC.getText();
         
         if(valueC!=null  &&  valueM!=null  &&  valueY!=null  &&  valueK!=null)
         {
               try { 
               double ccc = Double.parseDouble(valueC);   // CCCyan
               double mmm = Double.parseDouble(valueM);   // MMMagenta
               double yyy = Double.parseDouble(valueY);   // YYYellow
               double kkk = Double.parseDouble(valueK);   // KKKey
               
               if(ccc>1.1  ||  mmm>1.1 || yyy>1.1 || kkk>1.1)   {
                  JOptionPane.showMessageDialog(new JOptionPane(), "Please enter CMYK values that are in the 0-1 range.", "Error", JOptionPane.ERROR_MESSAGE);
               }
               else
               {
                  int redV = (int)(Math.round(255*(1-ccc)*(1-kkk)));   // Formulas from https://www.rapidtables.com/convert/color/cmyk-to-rgb.html
                  int greenV = (int)(Math.round(255*(1-mmm)*(1-kkk)));
                  int blueV = (int)(Math.round(255*(1-yyy)*(1-kkk)));
                  Color myColor = new Color(redV, greenV, blueV);

                  double cc = ccc;
                  double mm = mmm;
                  double yy = yyy;
                  double kk = kkk;
                  
                  if(String.valueOf(kk).length() > 4)  {  
                  kk = Double.parseDouble(String.valueOf(kk).substring(0, 4));   } 
                  if(String.valueOf(cc).length() > 4)  {  
                  cc = Double.parseDouble(String.valueOf(cc).substring(0, 4));   } 
                  if(String.valueOf(mm).length() > 4)  {  
                  mm = Double.parseDouble(String.valueOf(mm).substring(0, 4));   } 
                  if(String.valueOf(yy).length() > 4)  {  
                  yy = Double.parseDouble(String.valueOf(yy).substring(0, 4));   } 
                     
                  colorInputted.setBackground(myColor);
                  colorInfo.setText("HTML:" + String.format("#%02X%02X%02X", redV, greenV, blueV)   + "\nRGB:" + redV + ", " + greenV + ", " + blueV + ".\nCMYK:" + cc + ", " + mm + ", " + yy + ", " + kk + ".");
                  colorInputted.setVisible(true);
                  colorInfo.setVisible(true);
                         
                  c.gridx = 0;
                  c.gridy = 2;
                  c.gridheight = 1;
                  c.gridwidth = 7;
                  
                  add(colorInputted, c);
                  
                  c.gridheight = 1;
                  c.gridwidth = 1;
                  c.gridx = 8;
                  c.gridy = 2;
       
                  add(colorInfo, c);
                  
                  createShadesEtTints(redV, greenV, blueV);   // 'Et' means 'and' in Latin. :)
                  
                  repaint();
                  revalidate();
                  
               }
               }
               catch (NumberFormatException exception)  {  displayErrorMessage();  } 

         }
    }
    
    private void cmykMethod(String s) 
    {       
       if(s.equals("HTML")) {  removeHtml();  removeOthers(); removeShadesTints();  }
       else if(s.equals("RGB"))  {
           removeRgb();  removeOthers();  removeShadesTints();
       }
       
       c.gridheight = 1;
       c.gridwidth = 1;
       c.gridx = 1;
       c.gridy = 1;
       
       add(cyan, c); 
                    
       c.gridx = 2;
       c.gridy = 1;
       
       add(cmykCC, c);
                    
       c.gridx = 3;
       c.gridy = 1;
        
       add(magenta, c);
        
       c.gridx = 4;
       c.gridy = 1;
       
       add(cmykMC, c);
       
       c.gridx = 5;
       c.gridy = 1;
       
       add(yellow, c);

       c.gridx = 6;
       c.gridy = 1;
       
       add(cmykYC, c);
       
       c.gridx = 7;
       c.gridy = 1;

       add(key, c);
       
       c.gridx = 8;
       c.gridy = 1;
       
       add(cmykKC, c);
       
       c.gridx = 9;
       c.gridy = 1;
       
       add(searchBn, c);
       
       revalidate();
       repaint(); 
    }
    
    private void rgbMethod(String s)
    {       
       if(s.equals("HTML")) {  removeHtml();  removeOthers(); removeShadesTints();  }
       else if(s.equals("CMYK"))  {
           removeCmyk();  removeOthers();  removeShadesTints();
       }
       
       c.gridheight = 1;
       c.gridwidth = 1;
       c.gridx = 1;
       c.gridy = 1;
       
       add(red, c);
       
       c.gridx = 2;
       c.gridy = 1;
        
       add(rgbRC, c);
        
       c.gridx = 3;
       c.gridy = 1;
       
       add(green, c);
       
       c.gridx = 4;
       c.gridy = 1;
        
       add(rgbGC, c);
            
       c.gridx = 5;
       c.gridy = 1;
       
       add(blue, c);
       
       c.gridx = 6;
       c.gridy = 1;
        
       add(rgbBC, c);
       
       c.gridx = 7;
       c.gridy = 1;
       
       add(searchBn, c);
       
       revalidate();
       repaint(); 
    }
    
    private void htmlMethod(String s)
    {       
       if(s.equals("RGB"))   {
           removeRgb();   removeOthers();  removeShadesTints();
       }
       else if(s.equals("CMYK"))  {
           removeCmyk();  removeOthers();  removeShadesTints();
       }
       
       c.gridheight = 1;
       c.gridwidth = 1;
       c.gridx = 1;
       c.gridy = 1;
        
       add(html, c); 
       
       c.gridx = 2;
       c.gridy = 1;
       
       add(htmlCode, c);
       
       c.gridx = 3;
       c.gridy = 1;
       
       add(searchBn, c);
       
       revalidate();
       repaint(); 
    }
    
    private void createShadesEtTints(int r, int g, int b)
    {         
         original.setBackground(new Color(r, g, b));
         
         Color shades20 = new Color(getShade(r, 0.2), getShade(g, 0.2), getShade(b, 0.2));  // not the same name as the JTextFields;
         Color shades40 = new Color(getShade(r, 0.4), getShade(g, 0.4), getShade(b, 0.4));  // this name is plural;  'shades', not 'shade'
         Color shades60 = new Color(getShade(r, 0.6), getShade(g, 0.6), getShade(b, 0.6));
         Color shades80 = new Color(getShade(r, 0.8), getShade(g, 0.8), getShade(b, 0.8));
         Color shades100 = new Color(getShade(r, 1), getShade(g, 1), getShade(b, 1));
         
         Color tints20 = new Color(getTint(r, 0.2), getTint(g, 0.2), getTint(b, 0.2));  // See the above comments
         Color tints40 = new Color(getTint(r, 0.4), getTint(g, 0.4), getTint(b, 0.4));
         Color tints60 = new Color(getTint(r, 0.6), getTint(g, 0.6), getTint(b, 0.6));
         Color tints80 = new Color(getTint(r, 0.8), getTint(g, 0.8), getTint(b, 0.8));
         Color tints100 = new Color(getTint(r, 1), getTint(g, 1), getTint(b, 1));
         
         shade20.setBackground(shades20);
         shade40.setBackground(shades40);
         shade60.setBackground(shades60);
         shade80.setBackground(shades80);
         shade100.setBackground(shades100);
         
         tint20.setBackground(tints20);
         tint40.setBackground(tints40);
         tint60.setBackground(tints60);
         tint80.setBackground(tints80);
         tint100.setBackground(tints100);
         
         Color ccoomm = getComp(new Color(r, g, b));
         comColor.setBackground(ccoomm);
         
         textfield.setText("This text is written in "+getHTML(new Color(r, g, b)) + " color.");
         textfield.setForeground(new Color(r, g, b));
         c.gridheight = 1;
         c.gridwidth = 1;
         c.gridx = 0;
         c.gridy = 13;
         
         add(shades, c);   // Label for shades
         
         c.gridx = 1;
         
         add(shade20, c);
         
         c.gridx = 2;
         
         add(shade40, c);
         
         c.gridx = 3;
         
         add(shade60, c);
         
         c.gridx = 4;
         
         add(shade80, c);
         
         c.gridx = 5;
         
         add(shade100, c);
         
         c.gridx = 0;
         c.gridy = 14;
         
         add(tints, c);   /// Now the tints
         
         c.gridx = 1;
         
         add(tint20, c);
         
         c.gridx = 2;
         
         add(tint40, c);
         
         c.gridx = 3;
         
         add(tint60, c);
         
         c.gridx = 4;
         
         add(tint80, c);
         
         c.gridx = 5;
         
         add(tint100, c);
         
         c.gridx = 0;
         c.gridy = 15;
         
         add(compC, c);
         
         c.gridx = 1;
         
         add(comColor, c);
         
         c.gridx = 2;
         
         add(original, c);
         
         c.gridx = 0;
         c.gridy = 16;
         
         add(textfield, c);
         
         revalidate();
         repaint();
         
         
    }
    
    private void displayErrorMessage()         {
      JOptionPane.showMessageDialog(new JOptionPane(), "One or more textfield values have not been entered, or have been entered wrongly. \n Please check the entered values and ensure that they are correct.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    private void removeOthers()   {
    remove(searchBn);  remove(colorInfo);  remove(colorInputted);  remove(compC); remove(comColor);  remove(original);  remove(textfield);
    }
    
    private void removeCmyk()     {
    remove(cmykCC);  remove(cmykMC);  remove(cmykYC);   remove(cmykKC);  remove(cyan);  remove(magenta);  remove(yellow);  remove(key);
    }
    
    private void removeRgb()      {
    remove(rgbRC);   remove(rgbGC);   remove(rgbBC);  remove(red);  remove(green);  remove(blue);
    }
    
    private void removeHtml()     {
    remove(htmlCode);  remove(html);
    }
    
    private void removeShadesTints()  {
    remove(shade20); remove(shade40); remove(shade60); remove(shade80); remove(shade100); remove(tint20); remove(tint40); remove(tint60); remove(tint80); remove(tint100);  remove(tints);  remove(shades);
    }
    
    private Color getComp(Color c)   {
    int aRed = c.getRed();
    int aGreen = c.getGreen();
    int aBlue = c.getBlue();
    
    int redTwo = max(aRed,aGreen,aBlue) + min(aRed,aGreen,aBlue) - aRed; 
    int blueTwo = max(aRed,aGreen,aBlue) + min(aRed,aGreen,aBlue) - aBlue;
    int greenTwo = max(aRed,aGreen,aBlue) + min(aRed,aGreen,aBlue) - aGreen;
    
    return (new Color(redTwo, blueTwo, greenTwo));
    
    }
    
    private String getHTML(Color c)  {
    
    int r123 = c.getRed();
    int g123 = c.getGreen();
    int b123 = c.getBlue();
    
    return String.format("#%02X%02X%02X", r123, g123, b123);
    }
    
    public void paintComponent(Graphics g)
    {
      super.paintComponent(g);
      Graphics2D g2d = (Graphics2D)g;
      g2d.setColor(Color.white);
      g2d.fillRect(0, 0, getWidth(), getHeight());
    }
    
    private int getShade(int value, double deg)  {
       return (int)(Math.round(value*(1-deg)));  
    }
    private int getTint(int val, double deg)  {
      return (int)(Math.round(val+(deg * (255 - val)))); 
    }
    
    private int max(int a, int b, int c)  {
    return Math.max(Math.max(a, b), c);
    }
    
    private int min(int a, int b, int c)  {
    return Math.min(Math.min(a, b), c); 
    }
}
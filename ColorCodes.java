// ColorCodes.java
// This is for Project22stv110.java
// Janee Yeak
// This is one of the JPanels for the JTabbedPane. This class creates a gradient based on the inputed color,
// the user can click the gradient and get the color name (HTML).

// Thanks to : https://stackoverflow.com/questions/49904132/creating-a-color-chooser-jslider-to-effect-the-fill-color-of-rectangle  

package Project22stv110;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;

public class ColorCodes extends JPanel {

private ImageIcon image123;
private JLabel label, originalColor;
private Color myColor, colorNoTwo;
private int rgb;
private JTextField textfield, whatThisIsAbout, textWrittenInColor;


private ColorSliderPanel[] sliders = { 
            new ColorSliderPanel(Color.RED, "Red"),
            new ColorSliderPanel(Color.GREEN, "Green"), 
            new ColorSliderPanel(Color.BLUE, "Blue") };
            
private JPanel colorPanel = new JPanel();
    
    public ColorCodes() 
    {
        label = new JLabel();
        textfield = new JTextField();
        originalColor = new JLabel();
        textWrittenInColor = new JTextField();
        whatThisIsAbout = new JTextField("Slide the color sliders to create over 1.6 million different gradients; click on a pixel to get the color's HTML code.");
        whatThisIsAbout.setEditable(false);
        
        JPanel sliderPanel = new JPanel(new GridLayout(0, 1));
        for (ColorSliderPanel colorSliderPanel : sliders) {
            sliderPanel.add(colorSliderPanel);
            colorSliderPanel.addListener(evt -> setColorPanelBackground());
        }

        colorPanel.setPreferredSize(new Dimension(600, 300));
        
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
                    
          label.addMouseListener(new MouseAdapter() { 
            @Override
            public void mouseClicked(final MouseEvent e) 
            {
               if(image123 != null)
               {
                  try {
                  
                     remove(textfield);
                     remove(originalColor);
                     remove(textWrittenInColor);
                     Icon myImage = label.getIcon();
                     
                     if(myImage!=null)    {
                        BufferedImage bf = new BufferedImage(myImage.getIconWidth(), myImage.getIconHeight(), BufferedImage.TYPE_INT_RGB);
                        Graphics g = bf.createGraphics();
                        myImage.paintIcon(null, g, 0,0);
                        
                        int myNo = bf.getRGB(e.getPoint().x, e.getPoint().y);
                        myColor = new Color(myNo, true);
                        textfield.setBackground(myColor);
                        
                        originalColor.setText("The Color is below, its HTML code is "+getHTML(myColor));
                        textWrittenInColor.setForeground(myColor);
                        textWrittenInColor.setText("This text is written in " + getHTML(myColor) +" color.");
                        
                        c.gridheight = 1;
                        c.gridwidth = 1;
                        c.gridx = 0;
                        c.gridy = 5;
                     
                        add(originalColor, c);
                        
                        c.gridx = 0;
                        c.gridy = 6;
                        
                        add(textfield, c);
                        
                        c.gridx = 0;
                        c.gridy = 7;
                        
                        add(textWrittenInColor, c);
                        
                        revalidate();
                        repaint();
                     }
                  }
                  catch(ArrayIndexOutOfBoundsException exception) { }
               }
            }
        });
        
        
        c.weightx = 1;
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 1;
        c.gridwidth = 4;
        
        add(whatThisIsAbout, c);
        
        c.gridx = 0;
        c.gridy = 1;
        c.gridheight = 4;
        c.gridwidth = 1;
                    
        add(colorPanel, c);
                     
        c.gridheight = 1;
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 1;
        
        add(sliderPanel, c);
        
        
        setColorPanelBackground();
    }

    private void setColorPanelBackground() 
    {
      rgb = 0;
        
        for (ColorSliderPanel colorSliderPanel : sliders) {
            Color c = colorSliderPanel.getColor();
            int value = colorSliderPanel.getValue();

            // numeric magic here:
            rgb |= value * (0x10101 & c.getRGB());
        }
        colorNoTwo = new Color(rgb);
         image123 = ThreeWayGradient.getGradient(400, Color.white, colorNoTwo, Color.black); 
         if (label != null) {    label.setIcon(null);    }
         label.setIcon(image123);
         colorPanel.add(label);     

    }
    
    public void paintComponent(Graphics g)
    {
      super.paintComponent(g);
      Graphics2D g2d = (Graphics2D)g;
      g2d.setColor(Color.white);
      g2d.fillRect(0, 0, getWidth(), getHeight());
    }
    
    private String getHTML(Color c)  {
    
    int r123 = c.getRed();
    int g123 = c.getGreen();
    int b123 = c.getBlue();
    
    return String.format("#%02X%02X%02X", r123, g123, b123);
    }
}
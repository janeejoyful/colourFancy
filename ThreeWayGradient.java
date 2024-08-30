// ThreeWayGradient.java
// This is for Project22stv110;
// Janee Yeak
// Composition :: This is used in the Color Codes class, as part of the display.

/////////   https://stackoverflow.com/questions/13771575/java-3-color-gradient      ////////////////////

package Project22stv110;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class ThreeWayGradient 
{

   public static BufferedImage getThreeWayGradient(int size,Color primaryLeft, Color primaryRight, Color shadeColor) 
   {
        BufferedImage image = new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);

        Graphics2D g = image.createGraphics();
        GradientPaint primary = new GradientPaint(0f, 0f, primaryLeft, size, 0f, primaryRight);
        int rC = shadeColor.getRed();
        int gC = shadeColor.getGreen();
        int bC = shadeColor.getBlue();
        GradientPaint shade = new GradientPaint(0f, 0f, new Color(rC, gC, bC, 0), 0f, size, shadeColor);
        g.setColor(new Color(255, 250, 252)); // # fffafc
        g.fillRect(0, 0, image.getWidth(), image.getHeight());
        g.setPaint(primary);
        g.fillRect(0, 0, size, size);
        g.setPaint(shade);
        g.fillRect(0, 0, size, size);
        g.dispose();
        return image;
    }

    /**
     * Presumed to have a layout that shows multiple components.
     */
    public static void addGradient(JPanel p, int s, Color pL, Color pR, Color sh) {

        JLabel l = new JLabel(new ImageIcon(getThreeWayGradient(s, pL, pR, sh)));
        p.add(l);
    }
    
    public static ImageIcon getGradient(int s, Color pL, Color pR, Color sh) {

        ImageIcon iImage = new ImageIcon(getThreeWayGradient(s, pL, pR, sh));
        return iImage;
    }
}
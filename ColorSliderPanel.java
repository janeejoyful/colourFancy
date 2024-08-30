// ColorSliderPanel.java
// This is for Project22stv110.java
// Janee Yeak
// This class is for the ColorCodes class 
// Thanks to :: https://stackoverflow.com/questions/49904132/creating-a-color-chooser-jslider-to-effect-the-fill-color-of-rectangle

package Project22stv110;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.event.ChangeListener;

public class ColorSliderPanel extends JPanel {
    private final static int MAX_VALUE = 255;
    private Color color;
    private String text;
    private JSlider slider = new JSlider(0, MAX_VALUE, MAX_VALUE / 2);

    public ColorSliderPanel(Color color, String text) {
        this.color = color;
        this.text = text;
        setBackground(color);

        // lighter color
        int colorInt = color.getRGB() | 0x7f7f7f;
        slider.setBackground(new Color(colorInt));
        slider.setMajorTickSpacing(50);
        slider.setMinorTickSpacing(5);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        setLayout(new BorderLayout());
        add(slider);
        setBorder(BorderFactory.createTitledBorder(text));
    }

    public Color getColor() {
        return color;
    }

    public String getText() {
        return text;
    }

    public int getValue() {
        return slider.getValue();
    }

    public void addListener(ChangeListener listener) {
        slider.addChangeListener(listener);
    }

}

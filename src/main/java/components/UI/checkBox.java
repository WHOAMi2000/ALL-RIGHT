package components.UI;

import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;


public class checkBox extends BasicComboBoxUI {

    private ImageIcon DOWN_ICON;
    private static Color DEFAULT_COLOR = new Color(150, 207, 254);
    public checkBox(String filename){
       DOWN_ICON = new ImageIcon("src/main/resources/"+filename);
    }

    @Override
    public void installUI(JComponent c) {
        super.installUI(c);
        JComboBox comboBox = (JComboBox) c;
        comboBox.setFocusable(true);
        comboBox.setOpaque(false);
    }

    @Override
    protected JButton createArrowButton() {
        JButton arrow = new JButton();
        arrow.setUI(new button());
        arrow.setIcon(DOWN_ICON);
        arrow.setFocusable(false);
        arrow.setOpaque(true);
        arrow.setMargin(new Insets(0, 24, 0, 0));
        return arrow;
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        JComboBox comboBox = (JComboBox) c;
        hasFocus = comboBox.hasFocus();
        Rectangle r = rectangleForCurrentValue();
        Graphics2D g2d = (Graphics2D) g;
        if (!comboBox.isEditable()) {
            paintCurrentValueBackground(g2d, r, hasFocus);
            paintCurrentValue(g2d, r, hasFocus);
        } else {
            paintCurrentValueBackground(g2d, r, hasFocus);
        }
        if (comboBox.hasFocus()) {
            g2d.setColor(DEFAULT_COLOR);
        } else {
            g2d.setColor(Color.GRAY);
        }
        g2d.drawRoundRect(0, 0, comboBox.getWidth() - 2, comboBox.getHeight() - 2, 10, 10);
    }

    @Override
    protected ComboPopup createPopup() {
        BasicComboPopup popup = (BasicComboPopup) super.createPopup();
        popup.setBorder(BorderFactory.createLineBorder(DEFAULT_COLOR));
        return popup;
    }

}

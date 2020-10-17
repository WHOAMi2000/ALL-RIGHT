package panels.basic;

import javax.swing.*;
import java.awt.*;

public class ColorPanel extends JPanel {

    ImageIcon icon;
    Image img;
    public ColorPanel() {
        super();
        this.setBackground(null);
        this.setOpaque(true);
        icon=new ImageIcon("src/main/resources/background.jpg");
        img=icon.getImage();
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0,this.getWidth(), this.getHeight(), this);
    }


}

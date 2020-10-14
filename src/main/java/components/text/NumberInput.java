package components.text;

import javax.swing.JTextField;
import java.awt.*;

public class NumberInput extends JTextField {

    public NumberInput(String name, int RorL){
        super();
        this.setText(name);
        this.setHorizontalAlignment(RorL);
        this.setEditable(false);
        this.setFont(new Font("ARIAL",Font.BOLD,22));
        this.setOpaque(false);
        this.setBackground(new Color(255,250,250));
    }

}

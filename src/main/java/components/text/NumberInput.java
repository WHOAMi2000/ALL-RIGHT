package components.text;

import javax.swing.*;
import java.awt.*;

public class NumberInput extends JTextField {

    public NumberInput(String content, int RorL){
        super();
        this.setText(content);
        this.setHorizontalAlignment(RorL);
        this.setEditable(false);
        this.setFont(new Font("ARIAL",Font.BOLD,22));
        this.setOpaque(false);
        this.setBorder(BorderFactory.createEmptyBorder(2, 10, 2,10));
    }

}

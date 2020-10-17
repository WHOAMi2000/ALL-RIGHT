package components.text;

import lombok.Getter;
import lombok.Setter;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import common.Constant;
import tools.UpdateRate;

@Getter
@Setter
public class UnitsText extends JLabel {
    private String formerText="";
    private String latterText="";
    private int no=0;
    private int row=0;
    private int col=0;
    private double rate;
    private UpdateRate changeRates;
    public UnitsText(){
        super();
        this.setForeground(Color.BLUE);
        this.setPreferredSize(new Dimension(340,30));
        changeRates =new UpdateRate();
    }
    public void updateText(){
        switch(no){
            case 0:{
                rate=Constant.LENGTH[row][col];
                try{this.removeMouseListener(this.getMouseListeners()[0]);}
                catch (IndexOutOfBoundsException ignored){}

                if(this.getMouseListeners().length==0){
                    this.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            UnitsText.super.removeMouseListener(UnitsText.super.getMouseListeners()[0]);
                            changeRates.start();
                            updateText();
                        }
                        @Override
                        public void mousePressed(MouseEvent e) { }
                        @Override
                        public void mouseReleased(MouseEvent e) { }
                        @Override
                        public void mouseEntered(MouseEvent e) { }
                        @Override
                        public void mouseExited(MouseEvent e) { }
                    });
                }
                return; }
            case 1:{rate=Constant.MASS[row][col];
                try{this.removeMouseListener(this.getMouseListeners()[0]);}
                catch (IndexOutOfBoundsException ignored){}break;}
            case 2:{rate=Constant.SPEED[row][col];
                try{this.removeMouseListener(this.getMouseListeners()[0]);}
                catch (IndexOutOfBoundsException ignored){}break;}
        }
    }
}


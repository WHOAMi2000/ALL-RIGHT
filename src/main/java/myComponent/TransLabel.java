package myComponent;

import lombok.Getter;
import lombok.Setter;
import utils.Constant;
import utils.UpdateRate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileReader;

@Getter
@Setter
public class TransLabel extends JLabel {
//    陈氢start
    private String formerText="";
    private String latterText="";
    private int no=0;
    private int row=0;
    private int col=0;
    private double rate;
    private UpdateRate updateRate;
    public TransLabel(){
        super();
        this.setForeground(Color.BLUE);
        this.setPreferredSize(new Dimension(340,30));
        updateRate=new UpdateRate();
    }
    public void updateText(){
        switch(no){
            case 0:{
                rate=Constant.CURRENCY[row][col];
                try (FileReader reader = new FileReader("src/main/resources/rate.txt");
                     BufferedReader br = new BufferedReader(reader)
                ) {
                    this.setText("<html><body><p>"+formerText+"="+rate+latterText+"<br/>"+br.readLine()+"  点击更新</p></body></html>");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if(this.getMouseListeners().length==0){
                    this.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            TransLabel.super.removeMouseListener(TransLabel.super.getMouseListeners()[0]);
                            updateRate.start();
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
            case 1:{rate=Constant.LENGTH[row][col];
                      try{this.removeMouseListener(this.getMouseListeners()[0]);}
                      catch (IndexOutOfBoundsException ignored){}break;}
            case 2:{rate=Constant.MASS[row][col];
                try{this.removeMouseListener(this.getMouseListeners()[0]);}
                catch (IndexOutOfBoundsException ignored){}break;}
            case 3:{rate=Constant.AREA[row][col];
                try{this.removeMouseListener(this.getMouseListeners()[0]);}
                catch (IndexOutOfBoundsException ignored){}break;}
            case 4:{rate=Constant.SPEED[row][col];
                try{this.removeMouseListener(this.getMouseListeners()[0]);}
                catch (IndexOutOfBoundsException ignored){}break;}
            }
            this.setText(formerText+"="+rate+latterText);
        }
//     陈氢end
    }


package view;
import utils.UpdateRate;
import utils.Weather;
import view.panels.*;
import javax.swing.*;
import java.awt.*;

public class BasePanel extends JFrame{
//    陈氢start
    public static void main(String[] args) {
        new BasePanel();
    }
    /** 计算结果文本框 */
    private Science science=new Science();
    private Programmer programmer=new Programmer();
    private Transformer transformer=new Transformer();
    private Navigator navigator=new Navigator();
    private Widget widget=new Widget();
    public BasePanel(){
        super();
        // 初始化计算器
        init();
        new Weather().start();
        // 设置计算器的背景颜色
        this.setTitle("Q宝");
        // 在屏幕(500, 300)坐标处显示计算器
        this.setLocation(500, 300);
        this.setSize(350,450);
        // 不许修改计算器的大小
        this.setResizable(false);
        this.setIconImage(new ImageIcon("src/main/resources/Q.png").getImage());
        //关闭退出
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        UpdateRate.readFile();
    }
    private void init(){
        Container container=getContentPane();
        container.setLayout(new BorderLayout(3, 5));
        container.add("North", navigator.init());
        container.add("Center",widget.init());
        container.add("South", science.init());
        navigator.getMenu().addActionListener(e -> {
            switch (navigator.getMenu().getSelectedIndex()){
                case 0:{
                    container.remove(2);
                    container.add("South", science.init());
                    container.revalidate();
                    break;
                }
                case 1:{
                    container.remove(2);
                    container.add("South", programmer.init());
                    container.revalidate();
                    break;
                }
                case 2:{
                    container.remove(2);
                    container.add("South", transformer.init());
                    container.revalidate();
                    break;
                }
            }
        });
    }
//    陈氢end
}

package demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Stack;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class panel extends JFrame {

    private JFrame jf = new JFrame("Calculator");
    private JPanel panel_show = new JPanel();//窗口载体
    private JLabel label_input = new JLabel(); // 输入显示标签
    private JLabel label_output = new JLabel();// 结果显示标签
    private JLabel label_error = new JLabel();// 错误信息显示标签
    private JPanel panel_button = new JPanel();// 计算器按键载体
    private String result = " ";
    private char ope = '@';


    private String[] str = {                  // 按键显示字符
            "7", "8", "9", "DEL", "AC",
            "4", "5", "6", "+", "-",
            "1", "2", "3", "*", "/",
            "0", "(", ")", "√", "n!",
            ".", "e", "π", "1/x", "="};

    private JButton[] jb = new JButton[str.length];  // 按键

    //界面初始化
    public void init() {

        label_output.setHorizontalAlignment(JLabel.RIGHT);//输出框右对齐
        label_input.setHorizontalAlignment(JLabel.RIGHT);//输入框右对齐
        label_error.setHorizontalAlignment(JLabel.RIGHT);//错误信息右对齐

        panel_show.setLayout(new BorderLayout());//显示框框布局

        //显示框标签加载到panel_show载体中
        panel_show.add(label_output, BorderLayout.SOUTH);
        panel_show.add(label_input, BorderLayout.CENTER);
        panel_show.add(label_error, BorderLayout.NORTH);

        //按键布局
        panel_button.setLayout(new GridLayout(5, 5, 3, 3));
        for (int i = 0; i < jb.length; i++) {
            jb[i] = new JButton(str[i]);
            jb[i].setFocusPainted(false);//除去焦点框
            jb[i].addActionListener(new ButtonListener());//注册监听器
            panel_button.add(jb[i]);//按键加载到panel_button载体中
        }

        //载体加载到jf主框架
        jf.add(panel_button, BorderLayout.CENTER);
        jf.add(panel_show, BorderLayout.NORTH);

        jf.setLocationRelativeTo(null);// 窗口位置，左上角为屏幕中央
        jf.pack();// 自适应大小
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 设置X关闭
        jf.setResizable(true);// 不放大窗体
        jf.setVisible(true);// 显示窗口
    }

    //监视器
    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            //System.out.println(action);
            String content = e.getActionCommand();
            //此处应该加点东西
        }
    }
}




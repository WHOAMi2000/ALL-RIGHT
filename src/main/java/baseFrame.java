import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class baseFrame extends JFrame {
    private JFrame jf = new JFrame("Calculator");
    // 显示窗口载体
    private JPanel panel_show = new JPanel();
    // 输入显示标签
    private JLabel label_input = new JLabel();
    // 结果显示标签
    private JLabel label_output = new JLabel();
    // 错误信息显示标签
    private JLabel label_error = new JLabel();
    // 计算器按键载体
    private JPanel panel_button = new JPanel();
    private String result = " ";
    // 按键显示字符
    private String[] str= {
            "sin", "arcsin", "x^2", "√", "DEL", "AC",
            "cos", "arccos", "x^3", "3√","1/x", "|x|",
            "tan", "arctan","x^y", "y√x", "M", "%",
            "n！", "7", "8", "9", "(", ")",
            "log", "4", "5", "6", "*", "/",
            "ln" , "1", "2", "3", "+", "-",
            "exp", "0", "π", "e", ".", "="};

    // 按键
    private JButton[] jb = new JButton[str.length];

    private void init() {
        // 设置显示框计算结果大字体, 设置字体右对齐

        label_output.setText("0");
        label_output.setHorizontalAlignment(JLabel.RIGHT);
        label_output.setFont(new Font("arial", Font.BOLD, 22));
        label_output.setForeground(Color.BLUE);
        label_output.setBackground(Color.BLUE);

        // 设置显示框输入显示的字体,设置字体右对齐
        label_input.setText(" ");
        label_input.setHorizontalAlignment(JLabel.RIGHT);
        label_input.setFont(new Font("", Font.ROMAN_BASELINE, 20));

        // 设置错误信息显示
        label_error.setText(" ");
        label_error.setHorizontalAlignment(JLabel.RIGHT);
        label_error.setFont(new Font("arial", Font.ROMAN_BASELINE, 10));
        label_error.setForeground(Color.RED);

        panel_show.setLayout(new BorderLayout());

        // 显示标签加载到显示窗口载体中
        panel_show.add(label_output, BorderLayout.SOUTH);
        panel_show.add(label_input, BorderLayout.CENTER);
        panel_show.add(label_error, BorderLayout.NORTH);

        panel_show.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(180, 180, 180), null, SystemColor.scrollbar, null));

        // 按键设置为网格布局
        panel_button.setLayout(new GridLayout(7, 6, 4, 4));
        panel_button.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(180, 180, 180), null, SystemColor.scrollbar, null));
        // 按键
        for (int i = 0; i < jb.length; i++) {
            jb[i] = new JButton(str[i]);
            jb[i].setContentAreaFilled(false);// 除去默认的背景填充
            jb[i].setFocusPainted(false);// 除去焦点的框
            jb[i].setForeground(Color.blue);
            // 按键注册监听器
            jb[i].addActionListener(new ButtonListener());
            // 按键添加到按键载体中
            panel_button.add(jb[i]);
        }
        // 按键载体添加到主框架
        jf.add(panel_button, BorderLayout.CENTER);
        // 显示框载体加载到主框架
        jf.add(panel_show, BorderLayout.NORTH);


        // 窗口位置，左上角为屏幕中央
        jf.setLocationRelativeTo(null);
        // 自适应大小
        jf.pack();
        // 设置X关闭
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 可以放大窗体
        jf.setResizable(true);
        // 显示窗口
        jf.setVisible(true);

    }
    private static class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String expression = e.getActionCommand();
            System.out.println(expression);
        }
    }

    public static void main(String[] args) {
        new baseFrame().init();
    }
}


package myComponent.decoration;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;
import java.awt.*;

public class MyComboBoxUI extends BasicComboBoxUI {
//    陈氢start
    private ImageIcon DOWN_ICON;
    private static Color DEFAULT_COLOR = new Color(150, 207, 254);
    public MyComboBoxUI(String filename){
       DOWN_ICON = new ImageIcon("src/main/resources/"+filename);

    }
    @Override
    public void installUI(JComponent c) {
        super.installUI(c);
        JComboBox comboBox = (JComboBox) c;
        comboBox.setFocusable(true);
        comboBox.setOpaque(false);
        comboBox.setRenderer(new MyListCellRenderer());
    }
    @Override
    protected JButton createArrowButton() {
        // 也可以使用BasicComboBoxUI里的arrowButton对象
        JButton arrow = new JButton();
        // 设置自己定义的UI
        arrow.setUI(new MyButtonUI());
        // 设置图标
        arrow.setIcon(DOWN_ICON);
        // 设置无法获得焦点
        arrow.setFocusable(false);
        // 设置边距，调整图标位置
        arrow.setMargin(new Insets(0, 20, 0, 0));
        return arrow;
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        // 也可以使用BasicComboBoxUI里的combobox对象
        JComboBox comboBox = (JComboBox) c;
        hasFocus = comboBox.hasFocus();
        Rectangle r = rectangleForCurrentValue();
        // JComboBox的textfield的绘制,并不是靠Renderer来控制

        // 它会通过paintCurrentValueBackground来绘制背景

        // 然后通过paintCurrentValue去绘制显示的值
        Graphics2D g2d = (Graphics2D) g;
        if (!comboBox.isEditable()) {
            paintCurrentValueBackground(g2d, r, hasFocus);
            paintCurrentValue(g2d, r, hasFocus);
        } else {
            paintCurrentValueBackground(g2d, r, hasFocus);
        }
        // 获取焦点时，用不同颜色来区分
        if (comboBox.hasFocus()) {
            g2d.setColor(DEFAULT_COLOR);
        } else {
            g2d.setColor(Color.GRAY);
        }
        // 边框透明度

        // 绘制边框，后两个参数控制圆角

        // 边框也有占位，所以宽高都需要减去2，否则会导致边框不全

        g2d.drawRoundRect(0, 0, comboBox.getWidth() - 2, comboBox.getHeight() - 2, 10, 10);

    }

    @Override
    protected ComboPopup createPopup() {
        BasicComboPopup popup = (BasicComboPopup) super.createPopup();
        // 获取到popup，为其设置边框，和combobox的颜色保持同步
        popup.setBorder(BorderFactory.createLineBorder(DEFAULT_COLOR));
        return popup;
    }
//    陈氢end
}

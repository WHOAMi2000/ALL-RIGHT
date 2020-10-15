package components.menu;

import tools.MyTimeTask;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Timer;

public class TimeMenu extends JComboBox<String> {
    private SimpleDateFormat df = new SimpleDateFormat("EEE d MMM yyyy HH:mm:ss 'GMT'");//设置日期格式
    Timer timer = new Timer();
    boolean isFirst = false;

    public TimeMenu(JLabel index_label,JLabel time_1,JLabel time_2){
        super();
        this.addItem("伦敦 +0");
        this.addItem("罗马 +1");
        this.addItem("莫斯科 +3");
        this.addItem("伊斯兰堡 +5");
        this.addItem("曼谷 +7");
        this.addItem("香港 +8");
        this.addItem("首尔 +9");
        this.addItem("所罗门群岛 +11");
        this.addItem("乌拉圭 -3");
        this.addItem("纽约 -5");
        this.addItem("洛杉矶 -8");
        this.addItem("夏威夷 -10");
        this.setOpaque(true);
        this.addActionListener(e -> {
            int index = this.getSelectedIndex();
            index_label.setText(String.valueOf(index));
            timer.schedule(new MyTimeTask(index,df,time_1,time_2),0,1000);
        });
        this.setSelectedIndex(0);
    }
}

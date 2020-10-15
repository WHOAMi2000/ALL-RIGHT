package tools;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

public class MyTimeTask extends TimerTask {
    private int[] timeZone =  {-8,-7,-5,-3,-1,0,1,3,-11,-13,-16,-18};
    private SimpleDateFormat format;
    private JLabel time1;
    private JLabel time2;
    private int index_arr;
    int count;

    public MyTimeTask(int index,SimpleDateFormat df,JLabel time_1,JLabel time_2){
        format = df;
        time1 = time_1;
        time2 = time_2;
        index_arr = index;
    }
    @Override
    public void run() {
        Date now = new Date();
        if(count++ == 5){
            cancel();
        }
        time1.setText(format.format(new Date(now.getTime() + timeZone[5]*60*60*1000)));
        time2.setText(format.format(new Date(now.getTime() + timeZone[index_arr]*60*60*1000)));
    }
}

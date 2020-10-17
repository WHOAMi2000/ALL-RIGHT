package tools;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import common.Constant;

import java.io.*;

public class UpdateRate implements Runnable{
    private Thread t;
    public static void readFile() {
        String pathname = "src/main/resources/rate.txt";
        try (FileReader reader = new FileReader(pathname);
             BufferedReader br = new BufferedReader(reader)
        ) {
            String line;
            int lineNo=1;
            int row=0;
            int col=0;
            while ((line = br.readLine()) != null) {
                if (lineNo==1){
                    lineNo++;
                    continue;
                }
                Constant.CURRENCY[row][col]=Double.parseDouble(line);
                col+=1;
                if(col==8){
                    if(row==7)
                        break;
                    col=0;
                    row+=1;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        try{
            File file = new File("src/main/resources/rate.txt");
            FileWriter writer = new FileWriter(file);
            String []FROM={"CNY","USD","GBP","EUR","KRW","JPY","TWD","MOP"};
            String []TO={"CNY","USD","GBP","EUR","KRW","JPY","TWD","MOP"};
            WebClient webClient = new WebClient(BrowserVersion.CHROME);
            webClient.getOptions().setCssEnabled(false); // 取消 CSS 支持
            webClient.getOptions().setJavaScriptEnabled(false); // 取消 JavaScript支持
            writer.flush();
            for (String from :FROM){
                for (String to:TO){
                    HtmlPage page = webClient.getPage(String.format("http://hl.anseo.cn/cal_%s_To_%s.aspx", from,to));
                    writer.write(page.getByXPath("//div[@id='result']/p[1]/text()").get(0) + "\n");
                    writer.flush();
                    Thread.sleep(100);
                }
            }
            writer.close();
            readFile();
        } catch (Exception ignored){
        }

    }
    public void start () {
        if(t==null)
        {
            t=new Thread(this);
            t.start();
        }
    }
}

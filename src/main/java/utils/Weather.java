package utils;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import myComponent.WeatherDialog;

import java.io.IOException;
import java.util.regex.*;

public class Weather extends Thread{
//    陈氢start
    private static final String IP="\"ip\":\"(.*?)\"";
    private static final String DISTRICT="\"city\":\"(.*?)\".*\"county\":\"(.*?)\".*\"lng\":(.*?),.*\"time\":\"(\\d{4}-\\d{2}-\\d{2}).*\"lat\":(.*?)}";
    private static final String WEATHER="\"comf\".*?txt\":\"(.*?)\".*\"sport\".*?txt\":\"(.*?)\".*\"uv\".*?txt\":\"(.*?)\"";
    public void run(){
        try{
            WebClient webClient = new WebClient(BrowserVersion.CHROME);
            webClient.getOptions().setCssEnabled(false); // 取消 CSS 支持
            webClient.getOptions().setJavaScriptEnabled(false); // 取消 JavaScript支持
            webClient.getOptions().setThrowExceptionOnScriptError(false);
            String content = webClient.getPage("http://vv.video.qq.com/checktime?otype=json").getWebResponse().getContentAsString();
            Matcher matcher = Pattern.compile(IP).matcher(content);
            if (matcher.find()){
                content=webClient.getPage(String.format("http://restapi.amap.com/v4/ip?ip=%s&key=0113a13c88697dcea6a445584d535837", matcher.group(1))).getWebResponse().getContentAsString();
//                System.out.println(content);
                matcher = Pattern.compile(DISTRICT).matcher(content);
                if(matcher.find()){
                    WeatherDialog.dateAndLocation=matcher.group(4)+" "+matcher.group(2)+" "+matcher.group(1);
                    content=webClient.getPage(String.format("https://free-api.heweather.net/s6/weather/lifestyle?location=%s,%s&key=2289d83e1f26405392712a2d136ce95b", matcher.group(3), matcher.group(5))).getWebResponse().getContentAsString();
//                    System.out.println(content);
                    matcher = Pattern.compile(WEATHER).matcher(content);
                    if (matcher.find()){
                        WeatherDialog.comf=matcher.group(1);
                        WeatherDialog.sport=matcher.group(2);
                        WeatherDialog.uv=matcher.group(3);
                    }
                    else{
                        WeatherDialog.comf="对不起，该地区暂无数据。";
                        WeatherDialog.sport="对不起，该地区暂无数据。";
                        WeatherDialog.uv="对不起，该地区暂无数据。";
                    }
                }
                else{
                    WeatherDialog.dateAndLocation="无法获取数据:(";
                }
            }

        }catch (IOException ignored){
            WeatherDialog.dateAndLocation="无法获取数据:(";
        }
    }
//    陈氢end
}
//https://restapi.amap.com/v4/ip?ip=112.36.235.55&key=0113a13c88697dcea6a445584d535837
//https://free-api.heweather.net/s6/weather/now?location=%E4%B9%8C%E9%B2%81%E6%9C%A8%E9%BD%90&key=2289d83e1f26405392712a2d136ce95b
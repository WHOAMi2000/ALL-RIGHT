package utils;

import javazoom.jl.player.Player;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

import java.io.File;
import java.io.FileInputStream;

@Getter
@Setter
public class Mp3Player implements Runnable {
//    陈氢start
    private boolean flag=true;
    private Thread t;
    private Player player;
    private File file;
    private FileInputStream stream;
    @SneakyThrows
    public Mp3Player(String pathname){
//        this.pathname=pathname;
        file=new File(pathname);
    }
    public void run(){
        loop();
    }
    @SneakyThrows
    public void start() {
            if(t==null)
            {
                t=new Thread(this);
                flag=true;

                t.start();
            }
    }
    @SneakyThrows
    private void loop() {
        if (flag){
            stream=new FileInputStream(file);
            player=new Player(stream);
            player.play();
        }
        else{

            return;
        }

        loop();
    }
    public void interrupt(){
        flag=false;
        player.close();
        t.interrupt();
        t=null;
    }
//    陈氢end
}

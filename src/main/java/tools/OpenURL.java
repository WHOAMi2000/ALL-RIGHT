package tools;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OpenURL extends JLabel {

    public OpenURL() {
        this.setSize(300, 150);
        this.setText("              Click here and direct you to the website!");
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.setVisible(true);
        goWebsite(this);
    }

    private void goWebsite(JLabel website) {
        website.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    URI uri = new URL("file:///Users/jiayili/Documents/SUFE/%E8%BD%AF%E4%BB%B6%E5%B7%A5%E7%A8%8B%E5%AE%9E%E8%B7%B5/ALL-RIGHT/src/main/java/sudoku/index.html").toURI();
                    Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
                    if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE))
                        desktop.browse(uri);
//                    File htmlFile = new File("src/main/java/sudoku/index.html");
//                    Desktop.getDesktop().browse(htmlFile.toURI());
//                        Desktop.getDesktop().browse(new URI("src/main/java/sudoku/index.html"));
                } catch (URISyntaxException ex) {
                    Logger.getLogger(OpenURL.class.getName()).log(Level.SEVERE, null, ex);
                }catch (IOException ex){
                    System.out.println("make sure your location is correct");
                    Logger.getLogger(OpenURL.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
}

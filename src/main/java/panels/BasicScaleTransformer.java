package panels;

import components.Button.*;
import components.text.NumberInput;
import panels.basic.GeneralPanel;
import tools.GenerateRandom;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class BasicScaleTransformer {
    private StringBuilder postfix = new StringBuilder();
    private clearBtn clearButton=new clearBtn();
    private deleteBtn deleteButton=new deleteBtn();
    private GenerateRandom generateRandomButton = new GenerateRandom("Generate");
    private final String[] NUMBERKEYS = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    private numBtn[] numberButtons=new numBtn[NUMBERKEYS.length];

    JLabel binaryLab = new JLabel("二进制",JLabel.CENTER) ;
    JLabel octonaryLab = new JLabel("八进制",JLabel.CENTER) ;
    JLabel hexadecimalLab = new JLabel("十六进制",JLabel.CENTER) ;
    JLabel decimalLab = new JLabel("十进制",JLabel.CENTER) ;
    private NumberInput decimalInput = new NumberInput("0",2);
    private NumberInput binaryResult = new NumberInput("0",2);
    private NumberInput octonaryResult = new NumberInput("0",2);
    private NumberInput hexadecimalResult = new NumberInput("0",2);

    JButton addBackBtn = new myBtn();
    ImageIcon icon;
    Image img;

    public JPanel init(){
        // 上传图片文件
        addBackBtn.setText("upload background");
        addBackBtn.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                JFileChooser chooser = new JFileChooser("D:\\图片\\");
                chooser.setMultiSelectionEnabled(true);
                // 过滤文件类型
                FileNameExtensionFilter filter = new FileNameExtensionFilter("图像文件(jpg/png)", "jpg", "png", "jpeg", "jfif");
                chooser.setFileFilter(filter);
                int returnVal = chooser.showOpenDialog(addBackBtn);
                if (returnVal == chooser.APPROVE_OPTION) {
                    //判断是否有文件为jpg, png, jpeg, jfif
                    File ff = chooser.getSelectedFile();
                    //创建一个fileName得到选择文件的名字
                    String fileName = ff.getName();
                    String prefix = fileName.substring(fileName.lastIndexOf(".") + 1);
                    //判断选择的文件是否是图片文件 必须排除不是的情况 不然后续操作会报错
                    if (!(prefix.equals("jpg") || prefix.equals("png") || prefix.equals("jpeg") || prefix.equals("jfif"))) {
                        JOptionPane.showMessageDialog(new JDialog(), ":请选择正确格式的图片");
                    } else {
                        icon = new ImageIcon(chooser.getSelectedFile().getAbsolutePath());
                        img = icon.getImage();
                    }
                }
            }
        });// 监听按钮事件

        // 画图
        JPanel generator = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(img, 0, 0,this.getWidth(), this.getHeight(), this);
            }
        };

        // 设置页面布局
        for (int i = 0; i < NUMBERKEYS.length; i++) {
            numberButtons[i] = new numBtn(NUMBERKEYS[i]);
        }

        for (int i = 0; i < NUMBERKEYS.length; i++) {
            numberButtons[i].ScaleTransListener(NUMBERKEYS[i],postfix,decimalInput,binaryResult,octonaryResult,hexadecimalResult);
        }

        clearButton.generalListener(postfix,decimalInput,binaryResult,octonaryResult,hexadecimalResult);
        deleteButton.generalListener(postfix,decimalInput,binaryResult,octonaryResult,hexadecimalResult);

        JPanel showPanel=new GeneralPanel();
        showPanel.setLayout(new GridLayout(5, 1, 3, 3));
        showPanel.add(decimalLab);
        showPanel.add(decimalInput);
        showPanel.add(binaryLab);
        showPanel.add(binaryResult);
        showPanel.add(octonaryLab);
        showPanel.add(octonaryResult);
        showPanel.add(hexadecimalLab);
        showPanel.add(hexadecimalResult);
        
        JPanel buttonPanel = new GeneralPanel();
        // 用网格布局器，3行，3列的网格，网格之间的水平方向间隔为3个象素，垂直方向间隔为3个象素
        buttonPanel.setLayout(new GridLayout(4, 3, 3, 3));
        buttonPanel.add(numberButtons[0]);buttonPanel.add(clearButton);buttonPanel.add(deleteButton);
        buttonPanel.add(numberButtons[1]);buttonPanel.add(numberButtons[2]);buttonPanel.add(numberButtons[3]);
        buttonPanel.add(numberButtons[4]);buttonPanel.add(numberButtons[5]);buttonPanel.add(numberButtons[6]);
        buttonPanel.add(numberButtons[7]);buttonPanel.add(numberButtons[8]);buttonPanel.add(numberButtons[9]);

        JPanel addbackPanel = new GeneralPanel();
        addbackPanel.add(addBackBtn);

        generator.setLayout(new BorderLayout(0,0));
        generator.add("North",showPanel);
        generator.add("Center", buttonPanel);
        generator.add("South",addbackPanel);

        return generator;
    }

}

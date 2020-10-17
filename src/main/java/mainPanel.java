import panels.*;
import tools.UpdateRate;

import javax.swing.*;
import java.awt.*;

public class mainPanel extends JFrame{

    public static void main(String[] args) {
        new mainPanel();
    }
    private Calculator calculator =new Calculator();
    private UnitTransformer unitTransformer =new UnitTransformer();
    private EquationSolver equationSolver =new EquationSolver();
    private BackgroundAdd backgroundAdd =new BackgroundAdd();
    private RandomGenerator randomGenerator =new RandomGenerator();
    private SudokuGame sudokuGame =new SudokuGame();
    private TimeZoneTrans timeZoneTrans =new TimeZoneTrans();
    private Navigator navigator=new Navigator();
    public mainPanel(){
        super();
        init();
        this.setTitle("啥都队-计算器");
        this.setSize(365,450);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        UpdateRate.readFile();
    }
    private void init(){
        Container container=getContentPane();
        container.setLayout(new BorderLayout(3, 5));
        container.add("North", navigator.init());
        container.add("South", calculator.init());
        navigator.getMenu().addActionListener(e -> {
            switch (navigator.getMenu().getSelectedIndex()){
                case 0: {
                    container.getComponent(1).setVisible(false);
                    container.remove(1);
                    container.add("South", calculator.init());
                    container.revalidate();
                    break;
                }
                case 1: {
                    container.getComponent(1).setVisible(false);
                    container.remove(1);
                    container.add("South", unitTransformer.init());
                    container.revalidate();
                    break;
                }
                case 2: {
                    container.getComponent(1).setVisible(false);
                    container.remove(1);
                    container.add("South", timeZoneTrans.init());
                    container.revalidate();
                    break;
                }
                case 3: {
                    container.getComponent(1).setVisible(false);
                    container.remove(1);
                    container.add("South", equationSolver.init());
                    container.revalidate();
                    break;
                }
                case 4: {
                    container.getComponent(1).setVisible(false);
                    container.remove(1);
                    container.add("South", randomGenerator.init());
                    container.revalidate();
                    break;
                }
                case 5: {
                    container.getComponent(1).setVisible(false);
                    container.remove(1);
                    container.add("South", sudokuGame.init());
                    container.revalidate();
                    break;
                }
                case 6: {
                    container.getComponent(1).setVisible(false);
                    container.remove(1);
                    container.add("South", backgroundAdd.init());
                    container.revalidate();
                    break;
                }
            }
        });
    }
}

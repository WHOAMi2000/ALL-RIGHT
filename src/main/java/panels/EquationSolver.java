package panels;

import components.Button.*;
import components.text.EquationSolutions;
import components.text.NumberInput;
import panels.basic.ColorPanel;
import panels.basic.GeneralPanel;
import tools.equationSolver;

import javax.swing.*;
import java.awt.*;

public class EquationSolver {
    private StringBuilder postfix_a = new StringBuilder();
    private StringBuilder postfix_b = new StringBuilder();
    private StringBuilder postfix_c = new StringBuilder();

    private NumberInput input_a = new NumberInput("0",2);
    private NumberInput input_b = new NumberInput("0",2);
    private NumberInput input_c = new NumberInput("0",2);

    private NumberInput result_1 = new NumberInput("0",2);
    private NumberInput result_2 = new NumberInput(null,2);

    private compoundBtn aBtn = new compoundBtn("a");
    private compoundBtn bBtn = new compoundBtn("b");
    private compoundBtn cBtn = new compoundBtn("c");

    private clearBtn clearButton=new clearBtn();
    private deleteBtn deleteButton=new deleteBtn();
    private pointBtn pointButton=new pointBtn();
    private negativeBtn negativeButton = new negativeBtn();

    private equationSolver equationSolver = new equationSolver("Solve");

    private final String[] NUMBERKEYS = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0","",""};
    private numBtn[] numberButtons=new numBtn[NUMBERKEYS.length];

    JLabel lab = new JLabel("方程的解为",JLabel.CENTER) ;   // 实例化标签对象
    JLabel lab2 = new JLabel("方程的解为",JLabel.CENTER) ;   // 实例化标签对象

    public JPanel init(){
        for (int i = 0; i < NUMBERKEYS.length; i++) {
            numberButtons[i] = new numBtn(NUMBERKEYS[i]);
        }
        numberButtons[10].setEnabled(false);
        numberButtons[11].setEnabled(false);

        for (int i = 0; i < NUMBERKEYS.length; i++) {
            numberButtons[i].generalListener(NUMBERKEYS[i],postfix_a,input_a);
        }
        clearButton.generalListener(postfix_a,input_a);
        deleteButton.generalListener(postfix_a,input_a);
        pointButton.generalListener(postfix_a,input_a);
        negativeButton.generalListener(postfix_a,input_a);
        equationSolver.generalListener(input_a,input_b,input_c,result_1,result_2);

        aBtn.equationSolverListener(0,numberButtons,clearButton,deleteButton,pointButton,negativeButton,NUMBERKEYS,postfix_a,input_a);
        bBtn.equationSolverListener(1,numberButtons,clearButton,deleteButton,pointButton,negativeButton,NUMBERKEYS,postfix_b,input_b);
        cBtn.equationSolverListener(2,numberButtons,clearButton,deleteButton,pointButton,negativeButton,NUMBERKEYS,postfix_c,input_c);


        JPanel showPanel=new GeneralPanel();
        showPanel.setLayout(new GridLayout(5, 1, 3, 3));
        showPanel.add(aBtn);
        showPanel.add(input_a);
        showPanel.add(bBtn);
        showPanel.add(input_b);
        showPanel.add(cBtn);
        showPanel.add(input_c);
        showPanel.add(lab);
        showPanel.add(lab2);
        showPanel.add(result_1);
        showPanel.add(result_2);

        JPanel padPanel = new ColorPanel();
        padPanel.setLayout(new GridLayout(5, 3, 3, 3));
        padPanel.add(negativeButton);padPanel.add(clearButton);padPanel.add(deleteButton);
        padPanel.add(numberButtons[0]);padPanel.add(numberButtons[1]);padPanel.add(numberButtons[2]);
        padPanel.add(numberButtons[3]);padPanel.add(numberButtons[4]);padPanel.add(numberButtons[5]);
        padPanel.add(numberButtons[6]);padPanel.add(numberButtons[7]);padPanel.add(numberButtons[8]);
        padPanel.add(pointButton);padPanel.add(numberButtons[9]);padPanel.add(equationSolver);

        JPanel solver=new GeneralPanel();
        solver.setLayout(new BorderLayout(3, 5));
        solver.add("North",showPanel);
        solver.add("South", padPanel);

        return solver;
    }

}

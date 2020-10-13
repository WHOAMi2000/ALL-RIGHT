package myComponent.button;


import myComponent.EXMDialog;

public class EXMButton extends MyButton {
//    陈氢start
    public EXMButton(NumberButton []numberButtons){
        super();
        this.setText("EXM");
        this.addActionListener(e -> {
             new EXMDialog().init(numberButtons);
        });
    }
//    陈氢end
}

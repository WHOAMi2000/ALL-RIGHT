package components.Button;

import lombok.Getter;
import lombok.Setter;
import components.myText;


@Getter
@Setter
public class numBtn extends myBtn {


    public numBtn(String content) {
        super();
        this.setText(content);
    }

    public void generalListener(String name, StringBuilder postfix, myText resultText) {
        try {
            this.removeActionListener(this.getActionListeners()[0]);
        } catch (IndexOutOfBoundsException ignored) {
        }
        this.addActionListener(e -> {
            postfix.append(name);
            resultText.setText(postfix.toString());
        });
    }


}
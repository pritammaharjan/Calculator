
package calculator.start;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class numberButtonActionListener implements ActionListener {

    public int number; 
    public CalculatorUI ui;

    public numberButtonActionListener(int number, CalculatorUI ui) {
        this.number = number;
        this.ui = ui;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       ui.rightNum += number;
       ui.updateGUI();
       
       
    }


    
}

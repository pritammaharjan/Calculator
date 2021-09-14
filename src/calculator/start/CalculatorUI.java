
package calculator.start;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class CalculatorUI {
    JFrame frame;
    JTextArea infoPanel;
    
    JButton btn1, btn2,  btn3, btn4, btn5, btn6, btn7, btn8 , btn9, btn0,   btnPoint, btnPlus, btnMinus, btnMultiply, btnDivision;
    JButton btnClear, btnEquals;
    
    JPanel middlePanel, bottomPanel, rightPanel;
    
    double total = 0;
    String leftNum = "", rightNum = "";
    String operator = "";
    private int Point;
    
    void setupUI(){
        frame = new JFrame("pritam's calculator");
        frame.setSize(400, 600);
        infoPanel = new JTextArea();
        infoPanel.setEditable(false);
        frame.add(infoPanel, BorderLayout.NORTH);
        
        setupButtons();
        
        setupPanels();
        
        frame.setVisible(true);
    }

    private void setupPanels() {
        middlePanel = new JPanel(new GridLayout(4,3));//5 rows, 3 columns
        bottomPanel = new JPanel(new GridLayout(1,2));
        rightPanel = new JPanel(new GridLayout(5,1));
        middlePanel.add(btn9);
        middlePanel.add(btn8);
        middlePanel.add(btn7);
        middlePanel.add(btn6);
        middlePanel.add(btn5);
        middlePanel.add(btn4);
        middlePanel.add(btn3);
        middlePanel.add(btn2);
        middlePanel.add(btn1);
        middlePanel.add(btnPoint);
        middlePanel.add(btn0);
        
        
        rightPanel.add(btnPlus);
        rightPanel.add(btnMinus);
        rightPanel.add(btnMultiply);
        rightPanel.add(btnDivision);
        middlePanel.add(btnClear);
        rightPanel.add(btnEquals);
        
        frame.add(middlePanel, BorderLayout.CENTER);
        frame.add(rightPanel, BorderLayout.EAST);
        frame.add(bottomPanel, BorderLayout.SOUTH);
    }

    private void setupButtons() {
        btn1 = new JButton("1");
        btn2 = new JButton("2");
        btn3 = new JButton("3");
        btn4 = new JButton("4");
        btn5 = new JButton("5");
        btn6 = new JButton("6");
        btn7 = new JButton("7");
        btn8 = new JButton("8");
        btn9 = new JButton("9");
        btnPoint = new JButton(".");
        btn0 = new JButton("0");
        btnPlus = new JButton("+");
        btnMinus = new JButton("-");
        btnMultiply = new JButton("*");
        btnDivision = new JButton("/");
        btnClear = new JButton("clear");
        btnEquals = new JButton("=");
        
        btn1.addActionListener(new numberButtonActionListener(1, this));
        btn2.addActionListener(new numberButtonActionListener(2, this));
        btn3.addActionListener(new numberButtonActionListener(3, this));
        btn4.addActionListener(new numberButtonActionListener(4, this));
        btn5.addActionListener(new numberButtonActionListener(5, this));
        btn6.addActionListener(new numberButtonActionListener(6, this));
        btn7.addActionListener(new numberButtonActionListener(7, this));
        btn8.addActionListener(new numberButtonActionListener(8, this));
        btn9.addActionListener(new numberButtonActionListener(9, this));
        btnPoint.addActionListener(new numberButtonActionListener(Point, this));
        btn0.addActionListener(new numberButtonActionListener(0, this));
        
        
        btnPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                leftNum = rightNum;
                rightNum = "";
                operator = "+";
                updateGUI();
            }
        });
        
        btnMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                leftNum = rightNum;
                rightNum = "";
                operator = "-";
                updateGUI();
            }
           
        });
        
         btnMultiply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                leftNum = rightNum;
                rightNum = "";
                operator = "*";
                updateGUI();
            }
        });
         
          btnDivision.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                leftNum = rightNum;
                rightNum = "";
                operator = "/";
                updateGUI();
            }
        });
        
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                leftNum = "";
                rightNum = "";
                operator = "";
                total = 0;
                updateGUI();
            }
        });
        
        btnEquals.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!leftNum.isEmpty()&&!rightNum.isEmpty()&&!operator.isEmpty()){
                    if(operator.equals("+")){
                        total = Double.parseDouble(leftNum)+Double.parseDouble(rightNum);
                        updateGUI();
                       
                        leftNum = ""+total;
                        
                        infoPanel.setText(infoPanel.getText()+"\n="+total);
                    }
                    else if(operator.equals("-")){
                        total = Double.parseDouble(leftNum)-Double.parseDouble(rightNum);
                        updateGUI();
                    
                        leftNum = ""+total;
                        
                        infoPanel.setText(infoPanel.getText()+"\n="+total);
                    } 
                    else if(operator.equals("*")){
                        total = Double.parseDouble(leftNum)*Double.parseDouble(rightNum);
                        updateGUI();
                       
                        leftNum = ""+total;
                        
                        infoPanel.setText(infoPanel.getText()+"\n="+total);
                    } 
                    else if(operator.equals("/")){
                        total = Double.parseDouble(leftNum)/Double.parseDouble(rightNum);
                        updateGUI();
                      
                        leftNum = ""+total;
                        
                        infoPanel.setText(infoPanel.getText()+"\n="+total);
                    } 
                    
                    
                }
            }
        });
    }
    public void updateGUI(){
        String output = leftNum +" "+ operator+" "+rightNum;
       
        infoPanel.setText(output);
    }
}

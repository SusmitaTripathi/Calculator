import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class SimpleCalculator implements ActionListener{

    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[8];
    JButton addButton, subButton, mulButton, divButton, decButton, equButton, delButton, clrButton;
    JPanel panel;
    Font font = new Font("Monospaced",Font.BOLD,30);
    double num1 = 0, num2 = 0;
    char operator;
    CalculatorOperations calculate ;

    SimpleCalculator(){
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);
        textField = new JTextField();
        textField.setBounds(50,25,300,50);
        textField.setFont(font);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("Clear");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;

        for (JButton funcButton: functionButtons){
            funcButton.addActionListener(this);
            funcButton.setFont(font);
            funcButton.setFocusable(false);
        }

        for (int i = 0; i < 10; i++){
            numberButtons[i]  = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(font);
            numberButtons[i].setFocusable(false);
        }

        delButton.setBounds(50,430,145,50);
        clrButton.setBounds(205,430,145,50);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField);
        textField.setEditable(false);

        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        frame.add(panel);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++){
            if (e.getSource() == numberButtons[i])
                textField.setText(textField.getText().concat(String.valueOf(i)));
        }
        if (e.getSource() == decButton)
            textField.setText(textField.getText().concat("."));
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(textField.getText());
            calculate = new CalculatorOperations();
            textField.setText(calculate.calculateResult(num1,num2,operator));
            if (num2 == 0)
                num1 = 0;
            else
                num1 = Double.parseDouble(calculate.calculateResult(num1,num2,operator));
        }
        if (e.getSource() == clrButton) {
            textField.setText("");
            num1 = 0;
            num2 = 0;
        }
        if (e.getSource() == delButton) {
            String string = textField.getText();
            String tempString = "";
            for(int i = 0; i < string.length() - 1; i++){
                tempString = tempString.concat(String.valueOf(string.charAt(i)));
            }
            textField.setText(tempString);
        }
    }
}

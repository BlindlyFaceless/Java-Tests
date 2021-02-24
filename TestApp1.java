import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.*;

public class TestApp1 extends JFrame implements ActionListener{
    
    /**
     * converts between fahrenheit and celsius
     */
    private static final long serialVersionUID = 1L;
    static String cString = "Celsius";
    static String fString = "Fahrenheit";
    
    JLabel output = new JLabel("{OUTPUT HERE}");
    JButton cButton;
    JButton fButton;
    JFormattedTextField inputField;
    NumberFormat format =  DecimalFormat.getInstance();

    public static void main(String[] args) {
        new TestApp1();
    }

    TestApp1()
    {
        format.setMinimumFractionDigits(2);
        format.setMaximumFractionDigits(2);

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(new FlowLayout());

        cButton = new JButton("Celsius to Fahrenheit");
        fButton = new JButton("Fahrenheit to Celsius");
        inputField = new JFormattedTextField(format);
        inputField.setValue(-40.00);
        

        ButtonGroup group = new ButtonGroup();
        group.add(cButton);
        group.add(fButton);

        cButton.addActionListener(this);
        fButton.addActionListener(this);

        window.add(cButton);
        window.add(fButton);
        window.add(inputField);
        window.add(output);
        window.pack();
        window.setVisible(true);
        window.setLocationRelativeTo(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == cButton)
        {
            var c = Double.parseDouble(inputField.getText());

            var finalOutputC = c * (9.0/5.0) + 32.0;

            finalOutputC = Math.round(finalOutputC * 100);
            finalOutputC = finalOutputC / 100;

            output.setText(String.valueOf(finalOutputC));
        }
        else if(e.getSource() == fButton)
        {
            var f = Double.parseDouble(inputField.getText());

            var finalOutputF = (f - 32.0) * (5.0/9.0);

            finalOutputF = Math.round(finalOutputF * 100);
            finalOutputF = finalOutputF / 100;

            output.setText(String.valueOf(finalOutputF));
        }
    }
}
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class TestApp2 extends JFrame implements ActionListener{
    
    /**
     * checks consonants and vowels
     */
    private static final long serialVersionUID = 1L;
    public String outStringVowels = "";
    public String outStringConsonants = "";
    
    JLabel output = new JLabel("{OUTPUT HERE}");
    JLabel text = new JLabel("Check for all vowels");
    JButton checkButton;
    JTextField inputField;

    public static void main(String[] args) {
        new TestApp2();
    }

    TestApp2()
    {

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(new FlowLayout());

        checkButton = new JButton("Check");

        inputField = new JTextField();
        inputField.setText("Some word");
        

        ButtonGroup group = new ButtonGroup();
        group.add(checkButton);

        checkButton.addActionListener(this);

        window.add(text);
        window.add(checkButton);
        window.add(inputField);
        window.add(output);
        window.pack();
        window.setVisible(true);
        window.setLocationRelativeTo(null); 
    }   
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        outStringVowels = "";
        outStringConsonants = "";
        if(e.getSource() == checkButton)
        {
            for(int i = 0; i < inputField.getText().length(); i++)
            {
                char checkChar = inputField.getText().charAt(i);
                if(checkChar == 'a'|| checkChar == 'e'|| checkChar == 'i' ||checkChar == 'o' ||checkChar == 'u'
                || checkChar == 'A'|| checkChar == 'E'|| checkChar == 'I' ||checkChar == 'O' ||checkChar == 'U')
                outStringVowels += checkChar;
                else if(checkChar != ' ')
                outStringConsonants += checkChar;   
            }
            output.setText("The vowel(s) are: " + outStringVowels + " The consonant(s) are: " + outStringConsonants);

        }
    }
}
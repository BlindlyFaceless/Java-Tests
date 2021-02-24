import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TestApp3 extends JFrame implements ActionListener{

    /**
     * converts between morsecode and written English
     */
    private static final long serialVersionUID = 1L;
    public String[] engAlphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
    public char[] engAlphabetChar = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    public String[] morseAlphabet = {
                                    "-/","/---","/-/-","/--","-",
                                    "--/-","//-","----","--","-///",
                                    "/-/","-/--","//","/-","///",
                                    "-//-","//-/","-/-","---","/",
                                    "--/","---/","-//","/--/","/-//","//--"
                                    };

    JLabel output = new JLabel("{OUTPUT HERE}");
    JLabel text = new JLabel("Morse code to English (- : dot, / : dash, _ : space)");
    JButton checkButton;
    JTextField inputField;

    public static void main(String[] args) {
        new TestApp3();
    }

    TestApp3()
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
        window.setSize(400, 300);
        window.setVisible(true);
        window.setLocationRelativeTo(null); 
    }   
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String outString = "";
        //english to morse
        if(e.getSource() == checkButton)
        {
            for(int i = 0; i < inputField.getText().length(); i++)
            {
                char getChar = inputField.getText().charAt(i);
                String currentChar = String.valueOf(getChar);
                currentChar = currentChar.toLowerCase();
                if(getChar == ' ')
                    outString += " _ ";
                else
                    for(var c = 0; c < engAlphabet.length; c++)
                        if(engAlphabet[c].contains(currentChar))
                            outString += morseAlphabet[c] + " ";
            }
            output.setText(outString);
        }
    }
}
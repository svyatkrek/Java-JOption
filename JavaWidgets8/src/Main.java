import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.SliderUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;

class Main{
    public static class WindowApp extends JFrame {
        private JFrame layout;
        private  JButton buttonNumberOne;
        private  JButton buttonNumberTwo;
        private  JButton buttonNumberThree;
        private  JButton buttonNumberFour;
        private  JButton buttonNumberFive;
        private  JButton buttonNumberSix;
        private JButton ButtonNumberSeven;
        private  JButton buttonNumberEight;
        private  JButton buttonNumberNine;
        private  JButton buttonNumberZero;
        private JButton buttonReset;
        private JButton buttonAmount;
        private JButton buttonDifference;
        private JButton buttonMultiply;
        private JButton buttonDivide;
        private JButton buttonResult;
        private JTextArea textOutput;


        private String calculation(String values){
            if (values == null || values.isEmpty())
                return "Empty";
            String[] str = values.split(" ");
            String result;
            int tmp = 0;
            int counter = 0;
            String[] array = new String[str.length];
            if ( str.length < 3)
                return str[0];
            try {
                for (int i = 0; i < str.length - 1; i += 2) {
                    int valuesOne = Integer.parseInt(str[i]);
                    int valuesTwo = Integer.parseInt(str[i+2]);
                    char sign = str[i+1].charAt(0);

                    if (sign == '*' || sign == '/' ){
                        if (sign == '*')
                            tmp = valuesOne * valuesTwo;
                        else {
                            if (valuesTwo == 0)
                                return "Division by zero";
                            tmp = valuesOne / valuesTwo;
                        }
                        str[i+2] = String.valueOf(tmp);
                        array[counter] = str[i+2];
                    }
                    else{
                        array[counter] = str[i];
                        ++counter;
                        array[counter] = str[i+1];
                        ++counter;
                        array[counter] = str[i+2];
                    }
                }

                for (int i = 0; i < counter - 1; i += 2){
                    int valuesOne = Integer.parseInt(array[i]);
                    int valuesTwo = Integer.parseInt(array[i+2]);
                    char sign = array[i+1].charAt(0);
                    if (sign == '+')
                        tmp = valuesOne + valuesTwo;
                    else
                        tmp = valuesOne - valuesTwo;
                    array[i+2] = String.valueOf(tmp);
                }
            }
            catch (Exception e) {
                return "Error";
            }
            result = String.valueOf(tmp);
            return result;
        }
        public WindowApp() {
            super("My First Window");
            //
            //
            layout = new JFrame();
            layout.setTitle("Calculator");
            layout.setSize(400,500);
            layout.setLocationRelativeTo(null);
            layout.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            layout.getContentPane().setLayout(null);
            //
            //
            textOutput = new JTextArea();
            layout.getContentPane().add(textOutput);
            textOutput.setBounds(20,20, 350,50);
            Font font = new Font("Helvetica", Font.BOLD, 20);
            textOutput.setFont(font);
            textOutput.setDisabledTextColor(Color.BLACK);
            textOutput.setEnabled(false);
            //
            //
            buttonNumberOne = new JButton();
            buttonNumberOne.setText("1");
            layout.getContentPane().add(buttonNumberOne);
            buttonNumberOne.setBounds(35,100, 60,60);
            buttonNumberOne.addActionListener(e -> textOutput.append("1"));
            buttonNumberOne.setFont(font);
            //
            //
            buttonNumberTwo = new JButton();
            buttonNumberTwo.setText("2");
            layout.getContentPane().add(buttonNumberTwo);
            buttonNumberTwo.setBounds(125,100, 60,60);
            buttonNumberTwo.addActionListener(e -> textOutput.append("2"));
            buttonNumberTwo.setFont(font);
            //
            //
            buttonNumberThree = new JButton();
            buttonNumberThree.setText("3");
            layout.getContentPane().add(buttonNumberThree);
            buttonNumberThree.setBounds(215,100, 60,60);
            buttonNumberThree.addActionListener(e -> textOutput.append("3"));
            buttonNumberThree.setFont(font);
            //
            //
            buttonAmount = new JButton();
            buttonAmount.setText("+");
            layout.getContentPane().add(buttonAmount);
            buttonAmount.setBounds(295,100, 60,60);
            buttonAmount.addActionListener(e -> textOutput.append(" + "));
            buttonAmount.setFont(font);
            //
            //
            buttonNumberFour = new JButton();
            buttonNumberFour.setText("4");
            layout.getContentPane().add(buttonNumberFour);
            buttonNumberFour.setBounds(35,190, 60,60);
            buttonNumberFour.addActionListener(e -> textOutput.append("4"));
            buttonNumberFour.setFont(font);
            //
            //
            buttonNumberFive = new JButton();
            buttonNumberFive.setText("5");
            layout.getContentPane().add(buttonNumberFive);
            buttonNumberFive.setBounds(125,190, 60,60);
            buttonNumberFive.addActionListener(e -> textOutput.append("5"));
            buttonNumberFive.setFont(font);
            //
            //
            buttonNumberSix = new JButton();
            buttonNumberSix.setText("6");
            layout.getContentPane().add(buttonNumberSix);
            buttonNumberSix.setBounds(215,190, 60,60);
            buttonNumberSix.addActionListener(e -> textOutput.append("6"));
            buttonNumberSix.setFont(font);
            //
            //
            buttonDifference = new JButton();
            buttonDifference.setText("-");
            layout.getContentPane().add(buttonDifference);
            buttonDifference.setBounds(295,190, 60,60);
            buttonDifference.addActionListener(e -> textOutput.append(" - "));
            buttonDifference.setFont(font);
            //
            //
            ButtonNumberSeven = new JButton();
            ButtonNumberSeven.setText("7");
            layout.getContentPane().add(ButtonNumberSeven);
            ButtonNumberSeven.setBounds(35,280, 60,60);
            ButtonNumberSeven.addActionListener(e -> textOutput.append("7"));
            ButtonNumberSeven.setFont(font);
            //
            //
            buttonNumberEight = new JButton();
            buttonNumberEight.setText("8");
            layout.getContentPane().add(buttonNumberEight);
            buttonNumberEight.setBounds(125,280, 60,60);
            buttonNumberEight.addActionListener(e -> textOutput.append("8"));
            buttonNumberEight.setFont(font);
            //
            //
            buttonNumberNine = new JButton();
            buttonNumberNine.setText("9");
            layout.getContentPane().add(buttonNumberNine);
            buttonNumberNine.setBounds(215,280, 60,60);
            buttonNumberNine.addActionListener(e -> textOutput.append("9"));
            buttonNumberNine.setFont(font);
            //
            //
            buttonMultiply = new JButton();
            buttonMultiply.setText("*");
            layout.getContentPane().add(buttonMultiply);
            buttonMultiply.setBounds(295,280, 60,60);
            buttonMultiply.addActionListener(e -> textOutput.append(" * "));
            buttonMultiply.setFont(font);
            //
            //
            buttonReset = new JButton();
            buttonReset.setText("С");
            layout.getContentPane().add(buttonReset);
            buttonReset.setBounds(35,370, 60,60);
            buttonReset.addActionListener(e -> textOutput.setText(""));
            buttonReset.setFont(font);
            //
            //
            buttonNumberZero = new JButton();
            buttonNumberZero.setText("0");
            layout.getContentPane().add(buttonNumberZero);
            buttonNumberZero.setBounds(125,370, 60,60);
            buttonNumberZero.addActionListener(e -> textOutput.append("0"));
            buttonNumberZero.setFont(font);
            //
            //
            buttonResult = new JButton();
            buttonResult.setText("=");
            layout.getContentPane().add(buttonResult);
            buttonResult.setBounds(215,370, 60,60);
            buttonResult.addActionListener(e -> textOutput.setText( calculation(textOutput.getText()) ));//////////
            buttonResult.setFont(font);
            //
            //
            buttonDivide = new JButton();
            buttonDivide.setText("/");
            layout.getContentPane().add(buttonDivide);
            buttonDivide.setBounds(295,370, 60,60);
            buttonDivide.addActionListener(e -> textOutput.append(" / "));
            buttonDivide.setFont(font);
        }
    }

    public static void main(String[] args){
        WindowApp app = new WindowApp();
        app.layout.setVisible(true);
    }
}
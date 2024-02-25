import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.SliderUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Locale;
import java.util.Objects;

class Main{
    public static class WindowApp extends JFrame {
        private JFrame layout;
        private JLabel message;
        private  JButton button;
        private JRadioButton radioButton1;
        private JRadioButton radioButton2;
        private JRadioButton radioButton3;
        private JRadioButton radioButton4;
        public WindowApp() {
            super("My First Window");
            //
            //
            layout = new JFrame();
            layout.setTitle("Window");
            layout.setSize(350,400);
            layout.setLocationRelativeTo(null);
            layout.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            layout.getContentPane().setLayout(null);
            //
            //
            radioButton1 = new JRadioButton("Зима");
            radioButton2 = new JRadioButton("Лето");
            radioButton3 = new JRadioButton("Весна");
            radioButton4 = new JRadioButton("Осень");
            ButtonGroup buttonGroup = new ButtonGroup();
            buttonGroup.add(radioButton1);
            buttonGroup.add(radioButton2);
            buttonGroup.add(radioButton3);
            buttonGroup.add(radioButton4);
            layout.getContentPane().add(radioButton1);
            layout.getContentPane().add(radioButton2);
            layout.getContentPane().add(radioButton3);
            layout.getContentPane().add(radioButton4);
            radioButton1.setBounds(layout.getWidth()/2 - 50, 0, 100, 50 );
            radioButton2.setBounds(layout.getWidth()/2 - 50, 30, 100, 50 );
            radioButton3.setBounds(layout.getWidth()/2 - 50, 60, 100, 50 );
            radioButton4.setBounds(layout.getWidth()/2 - 50, 90, 100, 50 );
            //
            //
            message = new JLabel();
            Font font = new Font("Verdana", Font.BOLD, 14);
            message.setFont(font);
            message.setForeground(Color.black);
            layout.getContentPane().add(message);
            message.setBounds(layout.getWidth()/2 - 50, 200, 200, 50 );
            //
            //
            button = new JButton();
            button.setText("Получить");
            layout.getContentPane().add(button);
            button.setBounds(layout.getWidth()/2  - 50,150, 100,50);
            button.addActionListener(e -> {
                if (radioButton1.isSelected())
                    message.setText(radioButton1.getText());
                else if (radioButton2.isSelected())
                    message.setText(radioButton2.getText());
                else if (radioButton3.isSelected())
                    message.setText(radioButton3.getText());
                else if (radioButton4.isSelected())
                    message.setText(radioButton4.getText());
                else
                    message.setText("Ничего не выбрано");
            });
        }
    }

    public static void main(String[] args){
        WindowApp app = new WindowApp();
        app.layout.setVisible(true);
    }
}
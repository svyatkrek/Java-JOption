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

class Main{
    public static class WindowApp extends JFrame {
        private JFrame layout;
        private JLabel message;
        private JComboBox selectBar;
        private  JButton button;
        private JCheckBox checkBox;
        private JTextField textField;
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
            String[] items = {"Желтый","Синий","Красный","Черный","Коричневый","Зеленый"};
            selectBar = new JComboBox<>(items);
            selectBar.setEditable(true);
            layout.getContentPane().add(selectBar);
            selectBar.setBounds(layout.getWidth()/2 - 50, 0,100, 50);
            //
            //
            checkBox = new JCheckBox();
            checkBox.setText("Свой вариант");
            layout.getContentPane().add(checkBox);
            checkBox.setBounds(layout.getWidth()/2 - 50, 50,120, 50);
            checkBox.addItemListener(e -> textField.setEnabled(e.getStateChange() == ItemEvent.SELECTED));
            //
            //
            textField = new JTextField("Свой вариант");
            layout.getContentPane().add(textField);
            textField.setBounds(layout.getWidth()/2 - 50, 100,120, 30);
            textField.setEnabled(false);
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
            button.setText("Ответить");
            layout.getContentPane().add(button);
            button.setBounds(layout.getWidth()/2  - 50,150, 100,50);
            button.addActionListener(e -> {
                if (checkBox.isSelected())
                    message.setText("Ответ: " + textField.getText());
                else
                    message.setText("Ответ: " + selectBar.getSelectedItem());
            });
        }
    }

    public static void main(String[] args){
        WindowApp app = new WindowApp();
        app.layout.setVisible(true);
    }
}
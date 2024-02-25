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
        private JTextArea textArea;
        private JTextField textField;

        public WindowApp() {
            super("My First Window");
            //
            //
            layout = new JFrame();
            layout.setTitle("Window");
            layout.setSize(400,400);
            layout.setLocationRelativeTo(null);
            layout.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            layout.getContentPane().setLayout(null);
            //
            //
            textField = new JTextField();
            layout.getContentPane().add(textField);
            textField.setBounds(layout.getWidth()/2 - 150, 0, 300, 30 );
            //
            //
            textArea = new JTextArea();
            layout.getContentPane().add(textArea);
            textArea.setBounds(layout.getWidth()/2  -150, 100, 300, 100 );
            JScrollPane scrollPane = new JScrollPane(textArea);
            layout.add(scrollPane, BorderLayout.CENTER);
            scrollPane.setBounds(layout.getWidth()/2  -150, 100, 300, 100 );

            //
            /*
            message = new JLabel();
            Font font = new Font("Verdana", Font.BOLD, 14);
            message.setFont(font);
            message.setForeground(Color.black);
            layout.getContentPane().add(message);
            message.setBounds(layout.getWidth()/2 - 50, 150, 200, 50 );
            */
            //
            button = new JButton();
            button.setText("Получить");
            layout.getContentPane().add(button);
            button.setBounds(layout.getWidth()/2  - 50,50, 100,30);
            button.addActionListener(e -> {
                String tmp = textField.getText();
                if (tmp != null)
                    textArea.append(tmp + "\n");
            });
        }
    }

    public static void main(String[] args){
        WindowApp app = new WindowApp();
        app.layout.setVisible(true);
    }
}
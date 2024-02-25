import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.SliderUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

class Main{
    public static class WindowApp extends JFrame {
        private JFrame layout;
        private JLabel message;
        private JSpinner spinner;
        private  JButton button;
        public WindowApp() {
            super("My Window");
            //
            //
            layout = new JFrame();
            layout.setTitle("Window");
            layout.setSize(600,480);
            layout.setLocationRelativeTo(null);
            layout.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            layout.getContentPane().setLayout(null);
            //
            //
            message = new JLabel();
            Font font = new Font("Verdana", Font.BOLD, 18);
            message.setFont(font);
            message.setForeground(Color.black);
            layout.getContentPane().add(message);
            message.setSize(100,40);
            message.setLocation(layout.getWidth()/2, layout.getHeight()/2 + 30);

            //
            //
            SpinnerModel numbers = new SpinnerNumberModel(1, 0, 160, 1);
            spinner = new JSpinner(numbers);
            spinner.setValue(0);
            layout.getContentPane().add(spinner);
            spinner.setLocation(layout.getWidth()/2 ,layout.getHeight()/2 - 50);
            spinner.setSize(40,50);
            //
            //
            button = new JButton();
            button.setLocation(layout.getWidth()/2 ,layout.getHeight()/2 );
            button.setSize(100, 20);
            button.setText("Ответить");
            layout.getContentPane().add(button);

            button.addActionListener(e -> {
                int tmp = (int) spinner.getValue();
                message.setText("Ответ: " + tmp);
            });
        }
    }

    public static void main(String[] args){
        WindowApp app = new WindowApp();
        app.layout.setVisible(true);
    }
}
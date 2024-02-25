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
        private JButton button;
        private int counter = 0;
        public WindowApp() {
            super("My First Window");
            //
            //
            layout = new JFrame();
            layout.setTitle("Window");
            layout.setSize(1200,650);
            layout.setLocationRelativeTo(null);
            layout.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            layout.getContentPane().setLayout(null);
            //
            //
            message = new JLabel();
            Font font = new Font("Verdana", Font.ITALIC, 18);
            message.setText( String.valueOf(counter));
            message.setFont(font);
            message.setForeground(Color.black);
            layout.getContentPane().add(message);
            message.setSize(layout.getWidth(),500);
            message.setHorizontalAlignment(JLabel.CENTER);
            message.setVerticalAlignment(JLabel.CENTER);
            //
            //
            button = new JButton("Нажми на меня мягко");
            layout.getContentPane().add(button);
            button.setSize(200,100);
            button.setLocation(layout.getX(),layout.getY());

            button.addActionListener(e -> {
                ++counter;
                message.setText( String.valueOf(counter));
            });
        }
    }

    public static void main(String[] args){
        WindowApp app = new WindowApp();
        app.layout.setVisible(true);
    }
}
import javax.swing.*;
import java.awt.*;

class Main{
    public static class WindowApp extends JFrame {
        private JFrame layout;
        private JLabel message;
        public WindowApp() {
            super("My First Window");
            //
            //
            layout = new JFrame();
            layout.setTitle("Window");
            layout.setSize(900,500);
            layout.setLocationRelativeTo(null);
            layout.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            layout.getContentPane().setLayout(null);
            //
            //
            message = new JLabel();
            message.setText("Моя почти первая надпись!");
            Font font = new Font("Verdana", Font.ITALIC, 50);
            message.setFont(font);
            message.setForeground(Color.black);
            layout.getContentPane().add(message);
            message.setSize(800,500);
            message.setHorizontalAlignment(JLabel.CENTER);
            message.setVerticalAlignment(JLabel.CENTER);
        }
    }

    public static void main(String[] args){
        WindowApp app = new WindowApp();
        app.layout.setVisible(true);
    }
}
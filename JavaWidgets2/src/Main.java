import javax.swing.*;
import java.awt.*;


class Main{
    public static class WindowApp extends JFrame {
        private JFrame layout;
        private JLabel message;
        private JSlider slider;
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
            message.setText("Моя почти первая надпись!");
            Font font = new Font("Verdana", Font.ITALIC, 50);
            message.setFont(font);
            message.setForeground(Color.black);
            layout.getContentPane().add(message);
            message.setSize(layout.getWidth(),500);
            message.setHorizontalAlignment(JLabel.CENTER);
            message.setVerticalAlignment(JLabel.CENTER);
            //
            //
            slider = new JSlider();
            slider.setMinimum(5);
            slider.setMaximum(100);
            slider.setOrientation(JSlider.HORIZONTAL);
            slider.setValue(50);
            layout.getContentPane().add(slider);
            slider.setLocation(layout.getX(),0);
            slider.setSize(500,100);

            slider.addChangeListener(e -> {
                int value = ((JSlider)e.getSource()).getValue();
                Font tmpFont = new Font("Verdana", Font.ITALIC, value);
                message.setFont(tmpFont);
            });
        }
    }

    public static void main(String[] args){
        WindowApp app = new WindowApp();
        app.layout.setVisible(true);
    }
}
import javax.swing.*;
import java.awt.*;

class Main{
    public static class WindowApp extends JFrame {
        private JButton displayMessage;
        private JFrame layout;
        private JPanel buttonsPanel;

        public WindowApp() {
            super("My First Window");
            //
            //
            layout = new JFrame();
            layout.setTitle("Window");
            layout.setBounds(100, 100, 800, 600);
            layout.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            layout.getContentPane().setLayout(null);
            //
            //
            displayMessage = new JButton("Изменить разрешение экрана");
            layout.getContentPane().add(displayMessage);
            //
            //
            buttonsPanel = new JPanel(new FlowLayout());
            buttonsPanel.setBounds(200, 200, 300, 100);
            layout.getContentPane().add(buttonsPanel);
            buttonsPanel.add(displayMessage);

            displayMessage.addActionListener(e -> {
                String message = "Выберите разрешение экрана";
                String title = "Разрешение экрана";
                String[] screenResolution = new String[]{
                        layout.getWidth() + "x" + layout.getHeight(),
                        "1024x768",
                        "1200x600",
                        "1280x1024",
                        "1680x1050"
                };
                String result = (String) JOptionPane.showInputDialog(layout, message, title, JOptionPane.QUESTION_MESSAGE, null ,screenResolution, screenResolution[0]);
                String[] tmp = result.split("x");
                layout.setBounds(layout.getX(),layout.getY(),Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]));
                JOptionPane.showMessageDialog(layout, result);
            });
        }
    }

    public static void main(String[] args){
        WindowApp app = new WindowApp();
        app.layout.setVisible(true);
    }
}
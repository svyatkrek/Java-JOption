import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
            displayMessage = new JButton("Ввести имя");
            layout.getContentPane().add(displayMessage);
            //
            //
            buttonsPanel = new JPanel(new FlowLayout());
            buttonsPanel.setBounds(200, 200, 300, 100);
            layout.getContentPane().add(buttonsPanel);
            buttonsPanel.add(displayMessage);

            displayMessage.addActionListener(e -> {
                String name = JOptionPane.showInputDialog(layout, "Введите имя:");
                if (name.isEmpty())
                    JOptionPane.showMessageDialog(layout, "Вы ничего не ввели :c");
                else
                    JOptionPane.showMessageDialog(layout, name);
            });
        }
    }

    public static void main(String[] args){
        WindowApp app = new WindowApp();
        app.layout.setVisible(true);
    }
}
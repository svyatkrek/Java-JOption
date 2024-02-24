import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Main{
    public static class WindowApp extends JFrame { //Наследуя от JFrame мы получаем всю функциональность окна
        private JButton displayMessage;
        private JFrame layout;
        private JPanel buttonsPanel;

        public WindowApp() {
            super("My First Window");
            //
            //
            layout = new JFrame();
            layout.setTitle("First exercise");
            layout.setBounds(100, 100, 800, 600);
            layout.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            layout.getContentPane().setLayout(null);
            //
            //
            displayMessage = new JButton("Открыть диалоговое окно");
            layout.getContentPane().add(displayMessage);
            //
            //
            buttonsPanel = new JPanel(new FlowLayout());
            buttonsPanel.setBounds(200, 200, 300, 100);
            layout.getContentPane().add(buttonsPanel);
            buttonsPanel.add(displayMessage);

            displayMessage.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    JOptionPane.showMessageDialog(layout, "Марк");
                }
            });
        }
    }

    public static void main(String[] args){
        WindowApp app = new WindowApp();
        app.layout.setVisible(true);
    }
}
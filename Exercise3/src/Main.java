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
            displayMessage = new JButton("Начать тест");
            layout.getContentPane().add(displayMessage);
            //
            //
            buttonsPanel = new JPanel(new FlowLayout());
            buttonsPanel.setBounds(200, 200, 300, 100);
            layout.getContentPane().add(buttonsPanel);
            buttonsPanel.add(displayMessage);

            displayMessage.addActionListener(e -> {
                String check = String.valueOf(JOptionPane.showConfirmDialog(layout,"Вам нравятся динамические ЯП?"));
                check += String.valueOf(JOptionPane.showConfirmDialog(layout,"Вам нравятся статические ЯП?"));
                String message = switch (check) {
                    case "00" -> "Вам стоит определиться, нельзя усидеть на двух стульях!";
                    case "11" -> "Ну, ладно..";
                    case "01" -> "Вам стоит еще раз подумать";
                    case "10" -> "Отлично! Вы молодец!";
                    default -> "Надо ответить на оба вопроса!";
                };
                JOptionPane.showMessageDialog(layout, message);
            });
        }
    }

    public static void main(String[] args){
        WindowApp app = new WindowApp();
        app.layout.setVisible(true);
    }
}
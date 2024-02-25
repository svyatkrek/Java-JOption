import javax.swing.*;
import java.awt.*;

class Main{
    public static class WindowApp extends JFrame {
        private JButton displayMessage;
        private JFrame layout;
        private JPanel buttonsPanel;

        private boolean verifyPassword(String password){
            boolean isContainsNumber = false;
            boolean isContainsLetter = false;
            for(int i = 0; i < password.length() && !isContainsNumber; ++i)
                if(Character.isDigit(password.charAt(i)))
                    isContainsNumber = true;

            for(int i = 0; i < password.length() && !isContainsLetter; ++i)
                if(Character.isLetter(password.charAt(i)))
                    isContainsLetter = true;

            if (password.length() < 9 || password.contains(" ") || !isContainsLetter || !isContainsNumber)
                return false;
            return true;
        }
        public WindowApp() {
            super("My First Window");
            //
            //
            layout = new JFrame();
            layout.setTitle("Window");
            layout.setSize(250,300);
            layout.setLocationRelativeTo(null);
            layout.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            layout.getContentPane().setLayout(null);
            //
            //
            displayMessage = new JButton("Начать");
            layout.getContentPane().add(displayMessage);
            //
            //
            buttonsPanel = new JPanel(new FlowLayout());
            layout.getContentPane().add(buttonsPanel);
            buttonsPanel.add(displayMessage);
            buttonsPanel.setBounds(30, 100, 160, 60);


            displayMessage.addActionListener(e -> {
                String name;
                String password;
                String passwordConfirm;
                String message = "Вы хотите начать регистрацию?";
                //
                //
                int check = JOptionPane.showConfirmDialog(layout,message);
                if ( check != 0)
                    System.exit(0);
                //
                //
                message = "Введите логин. Он должен содержать минимум 6 символов без пробелов";
                while (true) {
                    name = JOptionPane.showInputDialog(layout, message);
                    if (name == null)
                        System.exit(0);
                    if (name.length() > 5 && !name.contains(" "))
                        break;
                }
                //
                //
                message = "Введите пароль. Минимум 8 символов, из которых минимум 1 буква и 1 цифра";
                while (true){
                    password = JOptionPane.showInputDialog(layout,message);
                    if (password == null)
                        System.exit(0);
                    if (verifyPassword(password))
                        break;
                }
                //
                //
                message = "Повторите пароль";
                while (true){
                    passwordConfirm = JOptionPane.showInputDialog(layout,message) ;
                    if (passwordConfirm == null)
                        System.exit(0);
                    if (password.equals(passwordConfirm))
                        break;
                }
                JOptionPane.showMessageDialog(layout,"Поздравляем! Вы успешно закончили регистрацию!");
                System.exit(0);
                //System.out.println(check);
            });
        }
    }

    public static void main(String[] args){
        WindowApp app = new WindowApp();
        app.layout.setVisible(true);
    }
}
import javax.swing.*;
import java.awt.*;
import java.io.Serial;


class Main{
    public static class WindowApp extends JFrame {
        private final JFrame layout;

        public WindowApp(int wigth, int height) {
            super("My First Window");
            //
            //
            layout = new JFrame();
            layout.setTitle("Window");
            layout.setSize(wigth,height);
            layout.setLocationRelativeTo(null);
            layout.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            layout.getContentPane().setLayout(null);
            //
            //
            JLabel message = new JLabel();
            Font font = new Font("Verdana", Font.BOLD, 14);
            message.setFont(font);
            message.setForeground(Color.black);
            layout.getContentPane().add(message);
            message.setBounds(layout.getWidth()/2 - 50, 200, 200, 50 );
            message.setText("Ура, открылось!");

        }
    }

    public static class JDialogTest extends JFrame {
        @Serial
        private static final long serialVersionUID = 1L;
        public JDialogTest() {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            JPanel contents = new JPanel();
            setContentPane(contents);
            JRadioButton radioButton1 = new JRadioButton("800x600");
            JRadioButton radioButton2 = new JRadioButton("1024x768");
            JRadioButton radioButton3 = new JRadioButton("1200x600");
            JRadioButton radioButton4 = new JRadioButton("1280x1024");
            JRadioButton radioButton5 = new JRadioButton("1680x1050");
            JRadioButton radioButton6 = new JRadioButton("1920x1080");
            ButtonGroup bg = new ButtonGroup();
            bg.add(radioButton1);
            bg.add(radioButton2);
            bg.add(radioButton3);
            bg.add(radioButton4);
            bg.add(radioButton5);
            bg.add(radioButton6);
            contents.add(radioButton1);
            contents.add(radioButton2);
            contents.add(radioButton3);
            contents.add(radioButton4);
            contents.add(radioButton5);
            contents.add(radioButton6);
            contents.setLayout(new GridLayout(7, 0, 0, 0));
            radioButton1.setSelected(true);
            //
            //
            JButton button = new JButton("OK");
            contents.add(button);
            button.addActionListener(e -> {
                String result = null;
                if (radioButton1.isSelected())
                    result = radioButton1.getText();
                if (radioButton2.isSelected())
                    result = radioButton2.getText();
                if (radioButton3.isSelected())
                    result = radioButton3.getText();
                if (radioButton4.isSelected())
                    result = radioButton4.getText();
                if (radioButton5.isSelected())
                    result = radioButton5.getText();
                if (radioButton6.isSelected())
                    result = radioButton6.getText();
                int wigth = Integer.parseInt(result.split("x")[0]);
                int height = Integer.parseInt(result.split("x")[1]);
                WindowApp app = new WindowApp(wigth,height);
                app.layout.setVisible(true);
                setVisible(false);
            } );
            setSize(250, 280);
            getRootPane().setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 50));
            setLocationRelativeTo(null);
            setVisible(true);
        }
    }

    public static void main(String[] args) {
        JDialogTest dialogTest = new JDialogTest();
    }
}
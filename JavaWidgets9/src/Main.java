import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.SliderUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

class Main{
    public static class WindowApp extends JFrame {
        private JFrame layout;
        private  JButton answerNumberOne;
        private  JButton answerNumberTwo;
        private  JButton answerNumberThree;
        private JButton answerNumberFour;
        private JTextArea textOutput;
        private JLabel message;
        private int counterQuestion ;
        private int counterCorrectAnswer;
        private Root root = new Root();
        private class Root{ ArrayList<QuizzesDataBase> data = new ArrayList<>();}
        private class QuizzesDataBase implements Cloneable{
            public String question;
            public String[] answers;
            public int correctAnswer;
            @Override
            public QuizzesDataBase clone() throws CloneNotSupportedException {
                return (QuizzesDataBase) super.clone();
            }
        }

        private void outputResult(){
            answerNumberOne.setVisible(false);
            answerNumberTwo.setVisible(false);
            answerNumberThree.setVisible(false);
            answerNumberFour.setVisible(false);
            textOutput.setVisible(false);
            message.setBounds(150,175, 400,25);
            message.setText("Поздравляем! Вы набрали " + counterCorrectAnswer +" баллов.");
        }

        private void CheckingAnswer(int check){
            if (check == root.data.get(counterQuestion).correctAnswer)
                ++counterCorrectAnswer;
            ++counterQuestion;
            if ( counterQuestion + 1 <= root.data.size())
                conclusionQuestion();
            else
                outputResult();
        }

        private void conclusionQuestion() {
            textOutput.setText(root.data.get(counterQuestion).question);
            answerNumberOne.setText(root.data.get(counterQuestion).answers[0]);
            answerNumberTwo.setText(root.data.get(counterQuestion).answers[1]);
            answerNumberThree.setText(root.data.get(counterQuestion).answers[2]);
            answerNumberFour.setText(root.data.get(counterQuestion).answers[3]);
            message.setText( (counterQuestion + 1) + "/" + root.data.size() );
        }

        private void InitializingQuiz() throws CloneNotSupportedException {
            counterQuestion = 0;
            counterCorrectAnswer = 0;

            QuizzesDataBase db = new QuizzesDataBase();
            db.question = "Какое аниме самое длинное из перечисленных?";
            db.answers = new String[]{"Боец Баки", "Данганронпа", "Ван Пис", "Эксперименты лэйн"};
            db.correctAnswer = 3;
            root.data.add(db.clone());
            db.question = "Какая фамилия у Киллуа из аниме \"Хантер х Хантер\"";
            db.answers = new String[]{"Толдик", "Молдик", "Колдик", "Золдик"};
            db.correctAnswer = 4;
            root.data.add(db.clone());
            db.question = "Действия какого аниме происходят в нашу эпоху и в нашем мире?";
            db.answers = new String[]{"Иная", "Волчица и пряности", "Невеста чародея", "Берсерк"};
            db.correctAnswer = 1;
            root.data.add(db.clone());
            db.question = "Как зовут главного героя аниме \"Хантер х Хантер\"?";
            db.answers = new String[]{"Джорно Джованно", "Гон", "Харухи Судзумия", "Онидзука"};
            db.correctAnswer = 2;
            root.data.add(db.clone());
            db.question = "Из какого аниме Нагито Комаеда?";
            db.answers = new String[]{"Данганронпа", "Две звезды оммёдзи", "Внук мудреца", "Герои шести лепестков"};
            db.correctAnswer = 1;
            root.data.add(db.clone());
            db.question = "В каком из этих аниме нет эльфов?";
            db.answers = new String[]{"Врата: Там бьются наши воины", "Эльфийская песнь", "Re:Zero", "О моём перерождении в слизь"};
            db.correctAnswer = 2;
            root.data.add(db.clone());
            db.question = "Форма голоса это?";
            db.answers = new String[]{"Тайтл", "Полнометражка", "OVA", "ONA"};
            db.correctAnswer = 2;
            root.data.add(db.clone());
            //
            //
            conclusionQuestion();

        }
        public WindowApp() throws CloneNotSupportedException {
            super("My First Window");
            //
            //
            layout = new JFrame();
            layout.setTitle("Calculator");
            layout.setSize(600,450);
            layout.setLocationRelativeTo(null);
            layout.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            layout.getContentPane().setLayout(null);
            //
            //
            textOutput = new JTextArea();
            layout.getContentPane().add(textOutput);
            textOutput.setBounds(20,20, 550,100);
            Font font = new Font("Helvetica", Font.BOLD, 16);
            textOutput.setFont(font);
            textOutput.setDisabledTextColor(Color.BLACK);
            textOutput.setEnabled(false);
            //
            //
            message = new JLabel();
            layout.getContentPane().add(message);
            message.setBounds(550,5, 50,15);
            message.setFont(font);
            //
            //
            answerNumberOne = new JButton();
            layout.getContentPane().add(answerNumberOne);
            answerNumberOne.setBounds(35,150, 250,100);
            answerNumberOne.setFont(font);
            answerNumberOne.addActionListener(e -> CheckingAnswer(1));
            //
            //
            answerNumberTwo = new JButton();
            layout.getContentPane().add(answerNumberTwo);
            answerNumberTwo.setBounds(310,150, 250,100);
            answerNumberTwo.setFont(font);
            answerNumberTwo.addActionListener(e -> CheckingAnswer(2));
            //
            //
            answerNumberThree = new JButton();
            layout.getContentPane().add(answerNumberThree);
            answerNumberThree.setBounds(35,270, 250,100);
            answerNumberThree.setFont(font);
            answerNumberThree.addActionListener(e -> CheckingAnswer(3));
            //
            //
            answerNumberFour = new JButton();
            layout.getContentPane().add(answerNumberFour);
            answerNumberFour.setBounds(310,270, 250,100);
            answerNumberFour.addActionListener(e -> CheckingAnswer(4));
            answerNumberFour.setFont(font);
            //
            //
            InitializingQuiz();
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        WindowApp app = new WindowApp();
        app.layout.setVisible(true);
    }
}
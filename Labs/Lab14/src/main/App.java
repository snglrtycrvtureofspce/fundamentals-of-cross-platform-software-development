package main;

import javax.swing.*;
import java.awt.*;

public class App extends JFrame {

    private final JTextArea textArea;

    public App() {
        // Настройка окна
        setTitle("Lab14");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(300, 400));

        // Создание компонентов
        textArea = new JTextArea();
        JButton button1 = new JButton("Кнопка 1");
        JButton button2 = new JButton("Меню");
        JButton button3 = new JButton("Кнопка 3");
        JButton[] buttons = new JButton[12];
        buttons[0] = new JButton("<html><b><size=4>1</font></b></html>");
        buttons[1] = new JButton("<html><b><size=4>2 ABC</font></b></html>");
        buttons[2] = new JButton("<html><b><size=4>3 DEF</font></b></html>");
        buttons[3] = new JButton("<html><b><size=4>4 GHI</font></b></html>");
        buttons[4] = new JButton("<html><b><size=4>5 JKL</font></b></html>");
        buttons[5] = new JButton("<html><b><size=4>6 MNO</font></b></html>");
        buttons[6] = new JButton("<html><b><size=4>7 PQRS</font></b></html>");
        buttons[7] = new JButton("<html><b><size=4>8 TUV</font></b></html>");
        buttons[8] = new JButton("<html><b><size=4>9 WXYZ</font></b></html>");
        buttons[9] = new JButton("<html><b><size=4>*</font></b></html>");
        buttons[10] = new JButton("<html><b><size=4>0</font></b></html>");
        buttons[11] = new JButton("<html><b><size=4>#</font></b></html>");

        // Размещение компонентов на панели
        JPanel panel = new JPanel(new BorderLayout());
        JPanel topPanel = new JPanel(new BorderLayout()); // создание панели для текстбокса и 3 кнопок
        JPanel smallButtonPanel = new JPanel(new FlowLayout()); // создание панели для 3 маленьких кнопок
        smallButtonPanel.add(button1);
        smallButtonPanel.add(button2);
        smallButtonPanel.add(button3);
        topPanel.add(smallButtonPanel, BorderLayout.CENTER);
        panel.add(topPanel, BorderLayout.NORTH); // добавление панели в верхнюю часть панели
        panel.add(textArea, BorderLayout.CENTER);
        JPanel bigButtonPanel = new JPanel(new GridLayout(4, 3, 10, 10));
        for (JButton button : buttons) {
            bigButtonPanel.add(button);
        }
        panel.add(bigButtonPanel, BorderLayout.SOUTH); // добавление панели с 12 кнопками в нижнюю часть панели

        // Добавление панели на окно и отображение
        getContentPane().add(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        App app = new App();
    }
}
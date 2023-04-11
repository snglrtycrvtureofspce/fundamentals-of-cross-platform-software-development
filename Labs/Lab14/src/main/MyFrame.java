package main;
import java.awt.*;
import java.util.ArrayList; import javax.swing.*;
public class MyFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("FrameDemo");// создаем окно с заголовком FrameDemo
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // делаем базовым действием при закрытие окна выход из
        // приложения, иначе окно закроется,
        // а программа в памяти останется
        frame.setSize(500,400); // задаем размер окна
        JPanel myPanel1 = new JPanel(); // создаем панель
        myPanel1.setLayout(new FlowLayout()); // устанавливаем для нее компоновщик
        myPanel1.add(new JButton("Кнопка 1")); // добавляем кнопку
        //вторую кнопку делаем по-другому, отдельным объектом, причем оформляем ее через html-код
        JButton myButton2 = new JButton("<html><b><font color=\"red\" size=14>Кнопка 2</font></b></html>"); //создаем распорку, которая будет стоять между кнопками
        Component horizontalStrut = Box.createHorizontalStrut(40);// с расстоянием в 40 точек
        myPanel1.add(horizontalStrut);// добавляем распорку
        myPanel1.add(myButton2); // добавляем вторую кнопку
        Box myBox1 = new Box(BoxLayout.Y_AXIS);//создаем объект Box для компоновки BoxLayout с расположением объектов
        // по вертикали (BoxLayout.Y_AXIS)
        myBox1.add(Box.createVerticalStrut(20)); //добавляем распорку от верхнего края окна
        myBox1.add(new JLabel("Метка1"));
        // добавляем метку
        myBox1.add(Box.createVerticalGlue());
        // добавляем пружину – она будет увеличиваться с увеличением окна и уменьшаться с уменьшением окна,
        // тем самым изменяя расстояние между объектами
        myBox1.add(new JLabel("Метка2")); // добавляем еще одну метку
        myBox1.add(Box.createVerticalGlue());
        // добавляем еще одну пружину
        myBox1.add(new JCheckBox("Выбор"));// добавляем чекбокс
        myBox1.add(Box.createVerticalStrut(20));
        // добавляем распорку от нижнего края окна
        ButtonGroup myGroup = new ButtonGroup(); // создаем группу, в которой будут радиокнопки
        JPanel myPanel2 = new JPanel(); // создаем панель для радиокнопок
        // Создаем массив радиокнопок
        ArrayList<JRadioButton> masRB = new ArrayList<JRadioButton>();
        myPanel2.setLayout(new GridLayout(3, 2));// устанавливаем компоновщик для табличного
                                                            // размещения объектов в 3 строки и 2 столбца
                                                            //в цикле будем добавлять радиокнопки и в массив,
                                                            // и в группу, и на панель
        for (int i = 0; i < 6; i++) {
            masRB.add(new JRadioButton("Выбор " + i)); // добавляем радиокнопку в массив
            masRB.get(i); // возвращает i-ю радиокнопку
            myGroup.add(masRB.get(i));// вставляем ее в группу
            myPanel2.add(masRB.get(i));// и добавляем на панель
        }
        masRB.get(0).setSelected(true);// устанавливаем выбранной 0-ю радиокнопку
        // теперь можно добавить все на форму в нужные области компоновки
        frame.add(myPanel1, BorderLayout.NORTH);
        frame.add(myBox1, BorderLayout.WEST);
        frame.add(new JTextArea(), BorderLayout.CENTER);// создаем текстовую область и добавляем ее в центр окна
        frame.add(myPanel2, BorderLayout.EAST);
        frame.add(new JTextField(), BorderLayout.SOUTH); // создаем текстовое поле и добавляем его в нижнюю область окна
        frame.setVisible(true);// делаем окно видимым
        frame.pack(); // упаковываем окно, чтобы привести его к оптимальному размеру, при котором все элементы видны
        frame.setMinimumSize(frame.getSize());// и делаем этот размер
    }
}
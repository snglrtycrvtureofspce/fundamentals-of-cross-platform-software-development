import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main extends JFrame {
    JPanel panel = null;
    HashMap<String, Student> myHash = new HashMap<String, Student>();
    ArrayList<Student> students = new ArrayList<Student>();

    public Main(String str) throws IOException {
        super(str);
        load();
        final DefaultListModel<String> myListModel = new DefaultListModel<String>();
        for (Student student : students) {
            myListModel.addElement(student.name);
            myHash.put(student.name, student);
        }
        final JList<String> myList = new JList<>();
        JScrollPane myScroll = new JScrollPane(myList);
        myList.setModel(myListModel);

        Box myBox1 = new Box(BoxLayout.Y_AXIS);

        JLabel l1 = new JLabel("Имя:");
        Box b1 = new Box(FlowLayout.LEFT);
        b1.add(l1);

        final JTextField t1 = new JTextField();
        Box b2 = new Box(FlowLayout.LEFT);
        b2.add(t1);
        ;

        JLabel l2 = new JLabel("Возраст:");
        Box b3 = new Box(FlowLayout.LEFT);
        b3.add(l2);

        final JTextField t2 = new JTextField();
        Box b4 = new Box(FlowLayout.LEFT);
        b4.add(t2);
        ;

        JLabel l3 = new JLabel("Адрес:");
        Box b5 = new Box(FlowLayout.LEFT);
        b5.add(l3);

        final JTextField t3 = new JTextField();
        Box b6 = new Box(FlowLayout.LEFT);
        b6.add(t3);
        ;

        Box box1 = new Box(BoxLayout.X_AXIS);
        JButton button1 = new JButton("Добавить");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Student tmp = new Student(t2.getText(), t3.getText(), t1.getText());
                myListModel.addElement(tmp.name);
                myHash.put(tmp.name, tmp);
                try {
                    write(tmp);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                t1.setText("");
                t2.setText("");
                t3.setText("");
            }
        });

        JButton button2 = new JButton("Удалить");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Student tmp = myHash.get(myList.getSelectedValue().toString());
                myListModel.remove(myList.getSelectedIndex());
                myHash.remove(tmp.name);
            }
        });

        JButton button3 = new JButton("Очистить");
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myHash.clear();
                myListModel.clear();
            }
        });
        box1.add(button1);
        box1.add(button2);
        box1.add(button3);
        myBox1.add(b1);
        myBox1.add(b2);
        myBox1.add(b3);
        myBox1.add(b4);
        myBox1.add(b5);
        myBox1.add(b6);
        myBox1.add(box1);

        JTextArea text = new JTextArea();
        text.setEditable(false);
        text.setFont(new Font("Serif", Font.BOLD, 20));
        Box center = new Box(BoxLayout.X_AXIS);
        center.add(myScroll);
        center.add(text);
        add(center, BorderLayout.CENTER);
        add(myBox1, BorderLayout.NORTH);

        myList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                try {
                    text.setText("");
                    Student tmp = myHash.get(myList.getSelectedValue().toString());
                    text.append("Имя:" + tmp.name + "\n");
                    text.append("Возраст:" + tmp.age + "\n");
                    text.append("Адрес:" + tmp.address + "\n");
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

    }

    public static void main(String[] args) throws IOException {
        Main window = new Main("Студенты");
        window.setVisible(true);
        window.pack();
        window.setSize(500, 500);
    }

    public void load() throws IOException {
        FileReader fr = new FileReader("text.txt");
        BufferedReader reader = new BufferedReader(fr);
        String line = reader.readLine();
        while (line != null) {
            String name = line;
            line = reader.readLine();
            if (line == null)
                break;
            String[] words = line.split(" ");
            String age = words[0];
            String address = words[1];
            Student tmp = new Student(age, address, name);
            students.add(tmp);
            line = reader.readLine();
        }
    }

    public void write(Student tmp) throws IOException {
        FileWriter fr = new FileWriter("text.txt", true);
        fr.write(tmp.name);
        fr.write("\n");
        fr.write(tmp.age + " " + tmp.address);
        fr.close();
    }
}
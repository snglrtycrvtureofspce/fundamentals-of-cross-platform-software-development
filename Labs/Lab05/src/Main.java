import java.io.Console;
import java.util.*;
import com.example.domain.*;
import worker.worker_with_fix;
import worker.worker_with_time;
import worker.worker;



public class Main {
    public static void updateStudents(ArrayList<Student> students)
    {
        try {
            students.removeIf(i -> i.getAverageScore() < 3);
            for (var item: students)
            {
                if(item.getAverageScore() >= 3){
                    item.setCourseNumber(item.getCourseNumber() + 1);
                }
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static  void printStudentsByCourse(ArrayList<Student> students, int course)
    {
        try {
            for (var item: students)
            {
                if(item.getCourseNumber() == course)
                    System.out.println(item);
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    public static void printItem(HashMap <String, Product> hashMap)
    {
        try
        {
            for (var item : hashMap.entrySet()) {
                System.out.println(item);
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static  void printKey(HashMap <String, Product> hashMap)
    {
        try
        {
            for (String key : hashMap.keySet()) {
                System.out.println("Ключ: " + key);}
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void printZ(HashMap <String, Product> hashMap)
    {
        try
        {
            for (Product item: hashMap.values()) {
                System.out.println("Значение: " + item);
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

         while (true)
         {
             System.out.println("1. Задание №1");
             System.out.println("2. Задание №2");
             System.out.println("3. Задание №3");
             System.out.println("4. Задание №4");

             int select = scanner.nextInt();

             switch (select)
             {
                 case 1: {

                     HashMap<String, Product> hashMap = new HashMap<String, Product>();
                    /* Product ddd = new Product("cx", -2, 3);
                     ddd.setPrice(2);*/
                     hashMap.put("Игрушка", new Product("Мишка", -20, 5));
                     hashMap.put("Набор", new Product("Карточный", 300, 5));
                        /////методы
                     printItem(hashMap);
                     printKey(hashMap);
                     printZ(hashMap);


                     break;
                 }
                 case 2: {

                     var students = new ArrayList<Student>();

                     students.add(new Student("Петя", "Т-191", 3, new int [] {12, 40, 3, 9, 10}));
                     students.add(new Student("Богдан", "Т-094", 3, new int [] {8, 8, 6, 8, 9}));
                     students.add(new Student("Матвей", "Т-091", 3, new int [] {1, 5, 8, 1, 10}));
                     students.add(new Student("Григорий", "Т-091", 3, new int [] {0, 8, 5, 8, 9}));
                     students.add(new Student("Саша", "Т-091", 3, new int [] {5, 8, 3, 1, 2}));
                     students.add(new Student("Никита", "Т-091", 3, new int [] {1, 2, 1, 1, 10}));
                     System.out.println(" \n Список студентов: ");
                     printStudentsByCourse(students, 3);
                     updateStudents(students);
                     System.out.println(" \n Проверка студентов и перевод на следующий курс: ");
                     printStudentsByCourse(students, 4);
                     break;
                 }
                 case 3: {

                     Map<String, Pet> hashMap = new HashMap<>();

                     hashMap.put("Кот", new Cat("Рафферти"));
                     hashMap.put("Собака", new Dog("Елиза"));
                     hashMap.put("Попугай", new Parrot("Кеша"));
                     System.out.println(hashMap);

                     for (String key : hashMap.keySet())
                     {
                         System.out.println("Ключ: " + key);
                     }

                     break;
                 }
                 case 4: {

                     ArrayList<worker> workers = new ArrayList<worker>();
                         workers.add(new worker_with_fix("Кто", 1, 1800));
                     workers.add(new worker_with_fix("Богдан", 2, 1800));
                     workers.add(new worker_with_time("Арсений", 3, 1.3));
                     workers.add(new worker_with_time("Паша", 4, 1.3));
                     workers.add(new worker_with_fix("Каша", 5, 1800));
                     workers.add(new worker_with_time("Ваня", 6 , 1.3));
                     Collections.sort(workers, worker.ComparatorAverageSalary);
                     workers.forEach(i -> System.out.println(i));
                     System.out.println("Первые имена:");
                     for (int i = 0; i < 5; i++)
                     {
                         System.out.println(workers.get(i).getName());
                     }
                     System.out.println("Последние 3 id:");
                     for (int i = workers.size() - 1; i >= workers.size() - 3; i--){
                         System.out.println(workers.get(i).getId());
                     }
                     break;
                 }
                 default:
                 {
                     System.out.println("Такого пункта нет!");
                     break;
                 }
             }

         }
    }
}

import java.sql.*;
import java.util.Scanner;

import static java.lang.System.out;

public class Main {
    public static final Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }

    public void start() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
            Statement statement = connection.createStatement();
            out.print("1. Создать таблицу страны и заполнить её\n" +
                    "2. Создать таблицу ЧастиСвета и заполнить её\n" +
                    "3. Создать таблицу Языки и заполнить её\n" +
                    "4. Создать таблицу ЯзыковыеГруппы и заполнить её\n" +
                    "Введите задание: ");
            int p = in.nextInt();
            switch (p) {
                case 1 -> {
                    createCountriesTable(statement);
                    insertCountriesData(statement);
                }
                case 2 -> {
                    createContinentsTable(statement);
                    insertContinentsData(statement);
                }
                case 3 -> {
                    createLanguagesTable(statement);
                    insertLanguagesData(statement);
                }
                case 4 -> {
                    createLanguageGroupsTable(statement);
                    insertLanguageGroupsData(statement);
                } default -> {
                    out.println("Exit...");
                }
            }
            statement.close();
            connection.close();

            out.println("Все таблицы успешно созданы и заполнены данными.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createCountriesTable(Statement statement) throws SQLException {
        String createCountriesTable = "CREATE TABLE Страны (" +
                "Наименование VARCHAR(100), " +
                "Площадь INT, " +
                "Население INT, " +
                "ГосЯзык VARCHAR(100), " +
                "ДенежнаяЕдиница VARCHAR(100), " +
                "ЧастьСвета VARCHAR(100)" +
                ")";
        statement.executeUpdate(createCountriesTable);

        out.println("Таблица 'Страны' успешно создана.");
    }

    private void insertCountriesData(Statement statement) throws SQLException {
        String insertCountriesData = "INSERT INTO Страны VALUES " +
                "('Россия', 17098242, 144000000, 'Русский', 'Рубль', 'Евразия')," +
                "('США', 9629091, 328000000, 'Английский', 'Доллар', 'Северная Америка')";
        statement.executeUpdate(insertCountriesData);

        out.println("Данные успешно добавлены в таблицу 'Страны'.");

        String query = "SELECT * FROM Страны";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next())
        {
            String first = rs.getString("Наименование");
            Integer second = rs.getInt("Площадь");
            Integer third = rs.getInt("Население");
            String fourth = rs.getString("ГосЯзык");
            String fifth = rs.getString("ДенежнаяЕдиница");
            String sixth = rs.getString("ЧастьСвета");

            System.out.format("%s, %s, %s, %s, %s, %s\n", first, second, third, fourth, fifth, sixth);
        }
    }

    private void createContinentsTable(Statement statement) throws SQLException {
        String createContinentsTable = "CREATE TABLE ЧастиСвета (" +
                "КодЧастиСвета INT PRIMARY KEY, " +
                "НаименованиеЧастиСвета VARCHAR(100), " +
                "Полушарие VARCHAR(100), " +
                "ПлощадьСушиКвКм INT" +
                ")";
        statement.executeUpdate(createContinentsTable);

        out.println("Таблица 'ЧастиСвета' успешно создана.");
    }

    private void insertContinentsData(Statement statement) throws SQLException {
        String insertContinentsData = "INSERT INTO ЧастиСвета VALUES " +
                "(1, 'Евразия', 'Северное', 54273000)," +
                "(2, 'Северная Америка', 'Северное', 24419000)";
        statement.executeUpdate(insertContinentsData);

        out.println("Данные успешно добавлены в таблицу 'ЧастиСвета'.");

        String query = "SELECT * FROM ЧастиСвета";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next())
        {
            Integer first = rs.getInt("КодЧастиСвета");
            String second = rs.getString("НаименованиеЧастиСвета");
            String third = rs.getString("Полушарие");
            Integer fourth = rs.getInt("ПлощадьСушиКвКм");

            System.out.format("%s, %s, %s, %s\n", first, second, third, fourth);
        }
    }

    private void createLanguagesTable(Statement statement) throws SQLException {
        String createLanguagesTable = "CREATE TABLE Языки (" +
                "КодЯзыка INT PRIMARY KEY, " +
                "НаименованиеЯзыка VARCHAR(100), " +
                "ЯзыковаяГруппа VARCHAR(100)" +
                ")";
        statement.executeUpdate(createLanguagesTable);

        out.println("Таблица 'Языки' успешно создана.");
    }

    private void insertLanguagesData(Statement statement) throws SQLException {
        String insertLanguagesData = "INSERT INTO Языки VALUES " +
                "(1, 'Русский', 'Славянские')," +
                "(2, 'Английский', 'Германские')";
        statement.executeUpdate(insertLanguagesData);

        out.println("Данные успешно добавлены в таблицу 'Языки'.");

        String query = "SELECT * FROM Языки";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next())
        {
            Integer first = rs.getInt("КодЯзыка");
            String second = rs.getString("НаименованиеЯзыка");
            String third = rs.getString("ЯзыковаяГруппа");

            System.out.format("%s, %s, %s\n", first, second, third);
        }
    }

    private void createLanguageGroupsTable(Statement statement) throws SQLException {
        String createLanguageGroupsTable = "CREATE TABLE ЯзыковыеГруппы (" +
                "КодЯзГруппы INT PRIMARY KEY, " +
                "НаименованиеЯзГруппы VARCHAR(100)" +
                ")";
        statement.executeUpdate(createLanguageGroupsTable);

        out.println("Таблица 'ЯзыковыеГруппы' успешно создана.");
    }

    private void insertLanguageGroupsData(Statement statement) throws SQLException {
        String insertLanguageGroupsData = "INSERT INTO ЯзыковыеГруппы VALUES " +
                "(1, 'Славянские')," +
                "(2, 'Германские')";
        statement.executeUpdate(insertLanguageGroupsData);

        out.println("Данные успешно добавлены в таблицу 'ЯзыковыеГруппы'.");

        String query = "SELECT * FROM ЯзыковыеГруппы";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next())
        {
            Integer first = rs.getInt("КодЯзГруппы");
            String second = rs.getString("НаименованиеЯзГруппы");

            System.out.format("%s, %s\n", first, second);
        }
    }
}

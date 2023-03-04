package Core;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class FullReport {
    public static void Doing() {
        Locale locale = null;
        System.out.println("Chose locale: 1-rus, 2-eng");
        Scanner in = new Scanner(System.in);
        String chose = in.next();
        if (chose.equals("1")) {
            locale = new Locale("ru", "RU");
        } else if (chose.equals("2")) {
            locale = new Locale("en", "US");
        } else {
            System.out.println("Something wrong");
        }

        ResourceBundle rb = ResourceBundle.getBundle("text", locale);


        if (locale.toString().equals("en_US")) {
            System.out.println("Report on english: \n" + empsal(locale));
        } else {
            System.out.println("Репорт на русском: \n" + empsal(locale));
        }
        ReportZD2.doing();
        System.out.println(rb.keySet());
        System.out.println(locale);
    }

    public static String empsal(Locale locale) {
        ResourceBundle rb2 = ResourceBundle.getBundle("tex", locale);
        String str = "";
        for (String key : rb2.keySet()) {
            String value = rb2.getString(key);
            str += value;
            str += "\t";
        }
        return str;
    }
}

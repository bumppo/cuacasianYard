package util;

import model.User;

import java.text.DecimalFormat;

/**
 * Created by forza on 19.03.2016.
 */
public class Test {
    public static void main(String[] args) {
//        User user = new User(null, "Vaska");
//        System.out.println(user);

//        int lucky = -900;
//        int summ = 3100;
//        float discont = (float)(-lucky)/summ*100;
//        System.out.println(discont);
//        System.out.println((int)discont);

        DecimalFormat df = new DecimalFormat(".##");

        float a = 8.4123f;
        float b = 8.51231f;
        float c = 8.9252f;
        System.out.println(df.format(a));
        System.out.println(df.format(b));
        System.out.println(df.format(c));


        System.out.println(245/6);

    }
}

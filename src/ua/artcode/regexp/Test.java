package ua.artcode.regexp;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by serhii on 29.05.16.
 */
public class Test {

    public static void main(String[] args) {
        Pattern datePatt = Pattern.compile("([0-9]{2})/([0-9]{2})/([0-9]{4})");
        String dateStr = "11/02/1991, 03/04/1992";
        Matcher m = datePatt.matcher(dateStr);

        while (m.find()) {
            int day   = Integer.parseInt(m.group(1));
            int month = Integer.parseInt(m.group(2));
            int year  = Integer.parseInt(m.group(3));
            System.out.println(year + " " + month + " " + day);
        }
    }
}

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Main {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
        StringBuilder after = new StringBuilder();
        int time = 12;
        if(s.charAt(s.length() - 2) == 'P'){
            if(Integer.parseInt(s.substring(0, 2)) < 12){
                time += Integer.parseInt(s.substring(0, 2));
            }
        } else if(s.charAt(s.length() - 2) == 'A'){
            if(Integer.parseInt(s.substring(0, 2)) == 12){
                time = 0;
                after.append(0);
            }
            else if(Integer.parseInt(s.substring(0, 2)) < 12) {
                time = Integer.parseInt(s.substring(0,2));
                after.append(0);
            }
        }
        after.append(time);
        after.append(s.substring(2, s.length() - 2));
        return after.toString();
    }

}



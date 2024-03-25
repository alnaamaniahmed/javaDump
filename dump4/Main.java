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

class Result {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
        // Write your code here
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

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

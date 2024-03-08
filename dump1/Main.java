import java.io.*;
import java.util.HashMap;

public class Main {
    public static void main(String args[]) throws IOException {
        decode("./message_file.txt");
    }
    // Method to read the message from a file and decode it
    public static void decode(String messsage_file) throws IOException {
        // HashMap to store the mapping of integer keys to strings (sentence parts)
        HashMap<Integer, String> sentence = new HashMap<Integer, String>();

        // Creating a File object to open the file
        File myObj = new File(messsage_file);
        // BufferedReader to read the file
        BufferedReader bf = new BufferedReader(new FileReader(myObj));
        String line = null;
        // Reading the file line by line
        while((line = bf.readLine()) != null){
            // Splitting each line into parts based on spaces
            String[] parts = line.split(" ");
            // Adding the parts to the HashMap, converting the first part to integer (key) and second part is the value
            sentence.put(Integer.parseInt(parts[0].trim()), parts[1].trim());
        }
        bf.close();
        // Decoding the message
        String decode = decodeMessage(sentence);
        // Printing the decoded message
        System.out.println(decode);
    }

    // Method to decode the message based on the numerical pattern
    public static String decodeMessage(HashMap<Integer, String> sentence){
        // Calculate the size of the pyramid based on the number of elements
        int pyramidSize = sentence.size();
        // Calculate the number of elements in each line of the pyramid
        int totalElementInEachLine = (int)Math.ceil((Math.sqrt(8 * pyramidSize + 1) - 1)/2);
        // StringBuilder to build the decoded message
        StringBuilder decodeMessage = new StringBuilder();
        // Variable to keep track of the previous line's end position
        int previousLineEnd = 0;

        // Loop through each line of the pyramid
        for(int i = 1; i <= totalElementInEachLine; i++){
            // Calculate the end position of the current line
            int lineEnd = previousLineEnd + i;
            // If the current line's end position is a key in the map, append the corresponding word to the message
            if(sentence.containsKey(lineEnd)){
                decodeMessage.append(sentence.get(lineEnd)).append(" ");
            }
            // Update the previous line's end position for the next iteration
            previousLineEnd = lineEnd;
        }
        // Return the decoded message as a string, trimming trailing spaces
        return decodeMessage.toString().trim();
    }
}
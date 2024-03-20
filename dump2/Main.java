import java.util.Scanner;
import java.util.Stack;

class Parser {
    static String isBalanced(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(' || ch == '{') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return "false";
                }
            } else if (ch == '}') {
                if (stack.isEmpty() || stack.pop() != '{') {
                    return "false";
                }
            }
        }

        return stack.isEmpty() ? "true" : "false";
    }
}

class Solution {
    public static void main(String[] args) {
        Parser parser = new Parser();
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            String input = in.next();
            System.out.println(parser.isBalanced(input));
        }

        in.close();
    }
}
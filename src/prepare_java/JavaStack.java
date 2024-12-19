package prepare_java;

import java.util.*;

class JavaStack {

    public static void main(String[] argh) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input = sc.next();
            System.out.println("method1: " + isBalanced(input));
            System.out.println("method2: " + isBalanced2(input));
        }

        sc.close();
    }

    private static boolean isBalanced2(String input) {
        char[] chars = input.toCharArray();
        Stack<Character> brackets = new Stack<>();
        var counterparts = Map.of('(', ')', '{', '}', '[', ']');

        for (char bracket : chars) {
            if (brackets.isEmpty()) {
                brackets.push(bracket);
            } else {
                char peekElement = brackets.peek();
                if (counterparts.containsKey(peekElement)) {
                    if (counterparts.get(peekElement).equals(bracket)) {
                        brackets.pop();
                    } else if (counterparts.containsValue(bracket)) {
                        // already found a mistake
                        System.out.println("break");
                        return false;
                    } else {
                        brackets.push(bracket);
                    }
                } else {
                    brackets.push(bracket);
                }
            }
        }

        return brackets.isEmpty();
    }

    private static boolean isBalanced(String input) {
        char[] chars = input.toCharArray();

        Stack<Character> brackets = new Stack<>();

        for (char bracket : chars) {
            if (brackets.isEmpty()) {
                brackets.push(bracket);
            } else {
                switch (bracket) {
                    case ')' -> popOrPush(brackets, bracket, '(');
                    case '}' -> popOrPush(brackets, bracket, '{');
                    case ']' -> popOrPush(brackets, bracket, '[');
                    default -> brackets.push(bracket);
                }
            }
        }

        return brackets.isEmpty();
    }

    private static void popOrPush(Stack<Character> parenthesis, char bracket, char counterpart) {
        if (parenthesis.peek() == counterpart) {
            parenthesis.pop();
        } else {
            parenthesis.push(bracket);
        }
    }
}
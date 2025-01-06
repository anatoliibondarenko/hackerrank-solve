package prepare_java;

import java.io.*;
import java.util.*;

interface PerformOperation {
    boolean check(int a);
}

class MyMath {
    public static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }

    // Write your code here

    static public class Solution {

        public static void main(String[] args) throws IOException {
            MyMath ob = new MyMath();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(br.readLine());
            PerformOperation op;
            boolean ret;
            String ans = null;
            while (T-- > 0) {
                String s = br.readLine().trim();
                StringTokenizer st = new StringTokenizer(s);
                int ch = Integer.parseInt(st.nextToken());
                int num = Integer.parseInt(st.nextToken());
                if (ch == 1) {
                    op = ob.isOdd();
                    ret = checker(op, num);
                    ans = (ret) ? "ODD" : "EVEN";
                } else if (ch == 2) {
                    op = ob.isPrime();
                    ret = checker(op, num);
                    ans = (ret) ? "PRIME" : "COMPOSITE";
                } else if (ch == 3) {
                    op = ob.isPalindrome();
                    ret = checker(op, num);
                    ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

                }
                System.out.println(ans);
            }
        }
    }

    private PerformOperation isPalindrome() {
        return this::isPalindrome;
    }

    private boolean isPalindrome(int n) {
        String string = String.valueOf(n);
        char[] chars = string.toCharArray();
        int length = chars.length;
        for (int i = 0; i < length / 2; i++) {
            if (chars[i] != chars[length - (i + 1)]) {
                return false;
            }
        }
        return true;
    }

    private PerformOperation isPrime() {
        return MyMath::isPrime;
    }

    private PerformOperation isOdd() {
        return (n) -> n % 2 == 1;
    }

    private static boolean isPrime(int n) {
        if (n == 2 || n == 3) {
            return true;
        }

        if (n % 2 == 0 || n == 1) {
            return false;
        }

        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}

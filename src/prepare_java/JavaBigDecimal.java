package prepare_java;

import java.math.BigDecimal;
import java.util.*;

class JavaBigDecimal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] s = new String[n];

        for (int i = 0; i < n; i++) {
            s[i] = sc.next();
        }
        sc.close();

        Arrays.sort(s, (s1, s2) -> new BigDecimal(s2).compareTo(new BigDecimal(s1)));

        for (int i = 0; i < n; i++) {
            System.out.println(s[i]);
        }
    }
}
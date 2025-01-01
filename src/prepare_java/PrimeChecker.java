package prepare_java;

import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.in;

public class PrimeChecker {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(in);
        int[] ints = new int[5];

        for (int i = 0; i < ints.length; i++) {
            ints[i] = scan.nextInt();
        }

        Prime ob = new Prime();
        ob.checkPrime(ints[0]);
        ob.checkPrime(ints[0], ints[1]);
        ob.checkPrime(ints[0], ints[1], ints[2]);
        ob.checkPrime(ints[0], ints[1], ints[2], ints[3], ints[4]);
        scan.close();
    }

}

class Prime {
    public void checkPrime(int... ints) {
        for (int anInt : ints) {
            System.out.print(isPrime(anInt) ? anInt + " " : "");
        }
        System.out.println();
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
package algorithms;

import java.io.*;
import java.util.Scanner;

public class ViralAdvertising {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int result = viralAdvertising(n);
        System.out.println(result);
    }

    public static int viralAdvertising(int n) {
        int sumLikes = 0;
        int people = 5;

        for (int i = 0; i < n; i++) {
            people = people / 2;
            sumLikes += people;
            people *= 3;
        }

        return sumLikes;
    }
}

package algorithms;

import java.io.*;
import java.util.stream.IntStream;

public class BeautifulDays {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int i = Integer.parseInt(firstMultipleInput[0]);

        int j = Integer.parseInt(firstMultipleInput[1]);

        int k = Integer.parseInt(firstMultipleInput[2]);

        int result = beautifulDays(i, j, k);
        System.out.println(result);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

    public static int beautifulDays(int i, int j, int k) {
        return (int) IntStream.rangeClosed(i, j)
                .filter(n -> (reverse(n) - n) % k == 0)
                .count();
    }

    private static int reverse(int n) {
        int reverse = 0;
        while (n > 0) {
            reverse = reverse * 10 + n % 10;
            n /= 10;
        }
        return reverse;
    }
}


package algorithms;

import java.io.*;


public class TowerBricks {
    public static void main(String[] args) throws IOException {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")))) {

            int t = Integer.parseInt(bufferedReader.readLine().trim());

            for (int tItr = 0; tItr < t; tItr++) {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                int result = Result.towerBreakers(n, m);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            }
        }
    }

    static class Result {

        private Result() {}

        /*
         * Complete the 'towerBreakers' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts the following parameters:
         *  1. INTEGER n
         *  2. INTEGER m
         */

        public static int towerBreakers(int n, int m) {
            if (m > 1) {
                return n % 2 == 0 ? 2 : 1;
            } else {
                return 2;
            }
        }

    }
}

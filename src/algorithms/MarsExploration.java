package algorithms;

import java.io.*;

public class MarsExploration {

    static class Result {

        public static int marsExploration(String s) {

            int length = s.length();
            int changedLetter = 0;

            for (int i = 0; i < length; i++) {
                int remind = i % 3;
                char ch = s.charAt(i);

                if (remind == 1) {
                    if (ch != 'O') {
                        changedLetter++;
                    }
                } else if (ch != 'S') {
                    changedLetter++;
                }
            }

            return changedLetter;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        int result = Result.marsExploration(s);
        System.out.println(result);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}


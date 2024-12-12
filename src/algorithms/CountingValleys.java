package algorithms;

import java.io.*;

class Result {

    public static int countingValleys(int steps, String path) {
        int count = 0;
        int altitude = 0;

        for(char step: path.toCharArray()) {
            altitude += (step == 'U') ? 1 : -1;
            if (altitude == 0 && step == 'U') {
                count++;
            }
        }

        return count;
    }
}

public class CountingValleys {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int steps = Integer.parseInt(bufferedReader.readLine().trim());

        String path = bufferedReader.readLine();

        int result = Result.countingValleys(steps, path);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

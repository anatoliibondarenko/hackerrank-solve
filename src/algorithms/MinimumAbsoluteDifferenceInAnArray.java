package algorithms;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class MinimumAbsoluteDifferenceInAnArray {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int result = minimumAbsoluteDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

    public static int minimumAbsoluteDifference(List<Integer> arr) {
        List<Integer> sortetList = arr.stream()
                .sorted()
                .collect(Collectors.toList());

        int length = sortetList.size();

        //noinspection ReassignedVariable
        int difference = Integer.MAX_VALUE;

        for (int i = 1; i < length; i++) {
            int currentDiff = sortetList.get(i) - sortetList.get(i - 1);
            if (currentDiff < difference) {
                difference = currentDiff;
            }

        }
        return difference;
    }
}


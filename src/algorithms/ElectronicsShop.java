package algorithms;

import java.io.*;
import java.util.*;

public class ElectronicsShop {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        InputData result = getInputData();

        // My attempt binary search over two dimension matrix
        // int moneySpent = getSpent(keyboards, drives, b);

        long start = System.nanoTime();
        int moneySpent = getMoneySpentTwoPointers(result.keyboards(), result.drives(), result.b());
        System.out.println(System.nanoTime() - start);
        System.out.println(moneySpent);

        bufferedWriter.write(String.valueOf(moneySpent));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

    private record InputData(int b, int[] keyboards, int[] drives) {
    }

    private static InputData getInputData() {
        String[] bnm = scanner.nextLine().split(" ");

        int b = Integer.parseInt(bnm[0]);
        int n = Integer.parseInt(bnm[1]);
        int m = Integer.parseInt(bnm[2]);

        int[] keyboards = new int[n];
        String[] keyboardsItems = scanner.nextLine().split(" ");

        for (int keyboardsItr = 0; keyboardsItr < n; keyboardsItr++) {
            int keyboardsItem = Integer.parseInt(keyboardsItems[keyboardsItr]);
            keyboards[keyboardsItr] = keyboardsItem;
        }

        int[] drives = new int[m];
        String[] drivesItems = scanner.nextLine().split(" ");

        for (int drivesItr = 0; drivesItr < m; drivesItr++) {
            int drivesItem = Integer.parseInt(drivesItems[drivesItr]);
            drives[drivesItr] = drivesItem;
        }
        return new InputData(b, keyboards, drives);
    }

    private static int getMoneySpentTwoPointers(int[] keyboards, int[] drives, int b) {
        Arrays.sort(keyboards);
        Arrays.sort(drives);

        int kb_ptr = keyboards.length - 1;
        int d_ptr = 0;
        int m = drives.length - 1;

        int result = -1;
        while (kb_ptr >= 0 && d_ptr <= m) {                //O(n+m)
            if (keyboards[kb_ptr] + drives[d_ptr] <= b) {
                result = Math.max(result, keyboards[kb_ptr] + drives[d_ptr]);
                ++d_ptr;
            } else {
                --kb_ptr;
            }
        }
        return result;
    }

    static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        Arrays.sort(keyboards);
        Arrays.sort(drives);
        return keyboards[0] + drives[0] < b ? seekMaxSumWithLimit(keyboards, drives, b) : -1;
    }

    private static int seekMaxSumWithLimit(int[] rows, int[] cols, int limit) {
        return helperMethodSeekMaxSumWithLimit(rows, 0, rows.length - 1, cols, 0,
                cols.length - 1, limit, rows[0] + cols[0]);
    }

    private static int helperMethodSeekMaxSumWithLimit(int[] rows, int rowStart, int rowEnd, int[] cols,
                                                       int colStart, int colEnd, int limit, int prevPivot) {

        if (rowStart == rowEnd && colStart == colEnd) {
            int pivot = rows[rowStart] + cols[colStart];
            return pivot < limit ? pivot : prevPivot;
        }

        int rowPivot = (rowStart + rowEnd) / 2;
        int colPivot = (colStart + colEnd) / 2;

        int sumPivot = rows[rowPivot] + cols[colPivot];
        if (sumPivot == limit) {
            return limit;
        } else if (sumPivot > limit) {
            int rowEndChanged = (rowPivot != rowStart) ? rowPivot - 1 : rowStart;
            int colEndChanged = (colPivot != colStart) ? colPivot - 1 : colStart;

            int upSum;
            if (hasChanges(rowEnd, rowEndChanged)) {
                upSum = helperMethodSeekMaxSumWithLimit(rows, rowStart, rowEndChanged,
                        cols, colStart, colEnd, limit, prevPivot);
            } else {
                upSum = prevPivot;
            }

            int leftSum;
            if (hasChanges(colEnd, colEndChanged)) {
                leftSum = helperMethodSeekMaxSumWithLimit(rows, rowPivot, rowEnd,
                        cols, colStart, colEndChanged, limit, prevPivot);
            } else {
                leftSum = prevPivot;
            }

            return Math.max(upSum, leftSum);
        } else {

            int rowStartChanged = (rowPivot != rowEnd) ? rowPivot + 1 : rowEnd;
            int colStartChanged = (colPivot != colEnd) ? colPivot + 1 : colEnd;

            int down;
            if (hasChanges(rowStart, rowStartChanged)) {
                down = helperMethodSeekMaxSumWithLimit(rows, rowStartChanged, rowEnd,
                        cols, colStart, colEnd, limit, sumPivot);
            } else {
                down = sumPivot;
            }

            int right;
            if (hasChanges(colStart, colStartChanged)) {
                right = helperMethodSeekMaxSumWithLimit(rows, rowStart, rowPivot,
                        cols, colStartChanged, colEnd, limit, sumPivot);
            } else {
                right = sumPivot;
            }

            return Math.max(down, right);
        }

    }

    private static boolean hasChanges(int param1, int param2) {
        return param1 != param2;
    }

    private static int getSpent(int[] keyboards, int[] drives, int b) {
        long start = System.nanoTime();
        int moneySpent = getMoneySpent(keyboards, drives, b);
        System.out.println(System.nanoTime() - start);
        System.out.println(moneySpent);

        return moneySpent;
    }
}


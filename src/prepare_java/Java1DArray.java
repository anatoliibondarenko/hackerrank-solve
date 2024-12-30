package prepare_java;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Java1DArray {

    public static boolean canWin(int leap, int[] game) {
        return canWinHelper(leap, game, 0);
    }

    private static boolean canWinHelper(int leap, int[] game, int pos) {

        if (pos < 0 || game[pos] == 1) {
            return false;
        }

        if (pos >= game.length - 1 || pos + leap >= game.length) {
            return true;
        }

        game[pos] = 1;

        return canWinHelper(leap, game, pos + leap) ||
                canWinHelper(leap, game, pos + 1) ||
                canWinHelper(leap, game, pos - 1);
    }

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            boolean result = (canWin(leap, game));
            System.out.println(result ? "YES" : "NO");
            bufferedWriter.write(result ? "YES" : "NO");
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
        scan.close();
    }
}
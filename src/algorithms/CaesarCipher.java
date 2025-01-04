package algorithms;

import java.io.*;
import java.util.stream.Collector;

public class CaesarCipher {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = caesarCipher(s, k);
        System.out.println(result);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

    public static String caesarCipher(String s, int k) {

        return s.chars().map(ch -> shift(ch, k))
                .mapToObj(n -> (char) n)
                .collect(Collector.of(
                        StringBuilder::new,
                        StringBuilder::append,
                        StringBuilder::append,
                        StringBuilder::toString));
    }


    private static int shift(int ch, int shift) {
        int shiftChar;

        shift %= 'z' - 'a' + 1;

        if (ch >= 'a' && ch <= 'z') {
            int newChar = ch + shift;
            shiftChar = newChar <= 'z' ? newChar : newChar - 26;
        } else if (ch >= 'A' && ch <= 'Z'){
            int newChar = ch + shift;
            shiftChar = newChar <= 'Z' ? newChar : newChar - 26;
        } else {
            shiftChar = ch;
        }

        return shiftChar;
    }
}

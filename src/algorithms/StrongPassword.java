package algorithms;

import java.io.*;

public class StrongPassword {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String password = bufferedReader.readLine();

        int answer = minimumNumber(n, password);
        System.out.println(answer);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

    public static int minimumNumber(int n, String password) {
        int minLengthPassword = 6;
        int groups = 4;

        int countUnique = (int) password.replaceAll("[a-z]", "a")
                .replaceAll("[A-Z]", "A")
                .replaceAll("[0-9]", "0")
                .replaceAll("[-!@#$%^&*()+]", "!")
                .chars()
                .distinct()
                .count();

        int complement = groups - countUnique;

        return password.length() >= minLengthPassword ? complement :
                password.length() + complement >= minLengthPassword ? complement : minLengthPassword - password.length();
    }

}

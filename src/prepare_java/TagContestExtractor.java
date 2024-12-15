package prepare_java;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagContestExtractor {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());


        while (testCases > 0) {
            String line = in.nextLine();
            Pattern p = Pattern.compile("<(.+)>([^<]+)</\\1>");
            Matcher m = p.matcher(line);
            if (m.find()) {
                do {
                    System.out.println(m.group(2));
                }
                while (m.find());
            } else {
                System.out.println("None");
            }

//            myAwkwardAttempt(line);

            testCases--;
        }
    }

    private static void myAwkwardAttempt(String line) {
        Pattern pattern = Pattern.compile("<[^<>]*>");
        Matcher matcher = pattern.matcher(line);

        String prevTag = null;
        int prevPos = 0;
        int countValid = 0;

        while (matcher.find()) {
            String tag = matcher.group();
            int pos = tag.charAt(1) == '/' ? matcher.start() : matcher.end();

            if (tag.charAt(1) == '/' && tag.length() > 3 && prevTag.charAt(1) != '/') {
                if (tag.replaceAll("/", "").equals(prevTag) && pos > prevPos) {
                    System.out.println(line.substring(prevPos, pos));
                    countValid++;
                }
            }

            prevTag = tag;
            prevPos = pos;

        }

        if (countValid == 0) {
            System.out.println("None");
        }
    }
}




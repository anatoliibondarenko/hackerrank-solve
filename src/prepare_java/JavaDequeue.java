package prepare_java;

import java.util.*;

public class JavaDequeue {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        Map<Integer, Integer> uniques = new HashMap<>();

        int n = in.nextInt();
        int m = in.nextInt();

        int maxUnique = 0;

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();

            deque.add(num);
            uniques.put(num, uniques.getOrDefault(num, 0) + 1);

            maxUnique = Math.max(maxUnique, uniques.size());

            if (deque.size() == m) {
                Integer poll = deque.poll();
                uniques.put(poll, uniques.get(poll) - 1);

                if (uniques.get(poll) == 0) {
                    uniques.remove(poll);
                }
            }
        }

        System.out.println(maxUnique);
    }
}




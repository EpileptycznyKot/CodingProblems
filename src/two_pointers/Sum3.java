package two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Sum3 {
    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<Integer> sorted = Arrays.stream(nums)
                .boxed()
                .sorted()
                .collect(Collectors.toCollection(ArrayList::new));

        List<List<Integer>> matchingValues = new ArrayList<>();


        for (int i = 0; i < sorted.size() - 2; i++) {
            if (i > 0 && sorted.get(i).equals(sorted.get(i - 1))) continue;
            int l = i + 1;
            int p = sorted.size() - 1;
            while (l < p) {
                int currentSum = sorted.get(i) + sorted.get(l) + sorted.get(p);
                if (currentSum == 0) {
                    List<Integer> matching = new ArrayList<>(List.of(sorted.get(i), sorted.get(l), sorted.get(p)));
                    matchingValues.add(matching);
                    l++;
                    p--;
                    while (l < p && sorted.get(l).equals(sorted.get(l - 1))) l++;
                    while (l < p && sorted.get(p).equals(sorted.get(p + 1))) p--;
                } else if (currentSum < 0) {
                    l++;
                } else {
                    p--;
                }

            }
        }
        return matchingValues;
    }

    public static void runTests() {
        Sum3 t = new Sum3();

        int[][] inputs = {
                {-1, 0, 1, 2, -1, -4},
                {0, 1, 1},
                {0, 0, 0}
        };

        for (int i = 0; i < inputs.length; i++) {
            List<List<Integer>> listList = t.threeSum(inputs[i]);
            listList.forEach(System.out::println);
        }
    }
}

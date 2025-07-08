package arrays_hash;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.stream.Collectors;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numbersSet = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toSet());

        return numbersSet.stream()
                .filter(num -> !numbersSet.contains(num - 1))
                .map(num -> {
                    int count = 1;
                    int current = num;
                    while (numbersSet.contains(current + 1)) {
                        count++;
                        current++;
                    }
                    return count;
                }).max(Comparator.naturalOrder())
                .orElse(0);
    }


    public static void runTests() {
        LongestConsecutiveSequence t = new LongestConsecutiveSequence();

        int[][] inputs = {
                {2, 20, 4, 10, 3, 4, 5},
                {0, 3, 2, 5, 4, 6, 1, 1}
        };

        for (int i = 0; i < inputs.length; i++) {
            int result = t.longestConsecutive(inputs[i]);
            System.out.println(result);
        }
    }
}


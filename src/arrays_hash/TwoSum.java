package arrays_hash;

import java.util.*;
import java.util.stream.Collectors;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] out = new int[2];
        Map<Integer, Long> numsToCounts = Arrays.stream(nums)
                .mapToObj(num -> (Integer) num)
                .collect(Collectors.groupingBy(num -> num, Collectors.counting()));

        for (Map.Entry<Integer, Long> entry : numsToCounts.entrySet()) {
            int currentValue = entry.getKey();
            Integer left = target - currentValue;
            if (numsToCounts.containsKey(left)) {
                List<Integer> toFind = new ArrayList<>(Arrays.asList(currentValue, left));
                int counter = 0;
                for (int i = 0; i < nums.length; i++) {
                    if (toFind.contains(nums[i])) {
                        out[counter++] = i;
                        toFind.remove(Integer.valueOf(nums[i]));
                    }
                }
                return out;
            }
        }
        return out;
    }

    public int[] twoSumV2(int[] nums, int target) {
        int[] out = new int[2];
        Map<Integer, Integer> numsToIndex = new HashMap<>();

        for (int i=0; i < nums.length; i++) {
            int left = target - nums[i];
            if (numsToIndex.containsKey(left)) {
                int j = numsToIndex.get(left);
                return j < i ? new int[] {j, i} : new int[] {i, j};
            }
            numsToIndex.put(nums[i], i);
        }
        return out;
    }



    public static void runTests() {
        TwoSum t = new TwoSum();

        int[][] inputs = {
                {3, 4, 5, 6},
                {5, 5},
                {5, 75, 25}
        };
        int[] targets = {7, 10, 100};

        for (int i = 0; i < inputs.length; i++) {
            int[] result = t.twoSumV2(inputs[i], targets[i]);
            System.out.printf("result %d = {%d, %d}%n", i + 1, result[0], result[1]);
        }
    }
}

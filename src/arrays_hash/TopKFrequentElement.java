package arrays_hash;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class TopKFrequentElement {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Long> numToFrequrncy = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(
                        num -> num, Collectors.counting()
                ));

        return numToFrequrncy.entrySet().stream()
                .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
                .limit(k)
                .map(Map.Entry::getKey)
                .mapToInt(Integer::intValue)
                .toArray();
    }


    public static void runTests() {
        TopKFrequentElement t = new TopKFrequentElement();

        int[][] inputs = {
                {1, 2, 2, 3, 3,},
        };
        int[] targets = {2};

        for (int i = 0; i < inputs.length; i++) {
            int[] result = t.topKFrequent(inputs[i], targets[i]);
            for (Integer num : result) {
                System.out.print(num + " , ");
            }
        }
    }
}


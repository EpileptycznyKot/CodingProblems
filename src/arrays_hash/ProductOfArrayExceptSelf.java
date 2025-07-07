package arrays_hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        List<Integer> factors = Arrays.stream(nums).boxed().collect(Collectors.toCollection(ArrayList::new));

        return Arrays.stream(nums).boxed().map(num -> {
                    factors.remove(num);
                    Integer product = factors.stream().reduce(1, (a, b) -> a * b);
                    factors.add(num);
                    return product;
                }).mapToInt(Integer::intValue)
                .toArray();
    }


    public static void runTests() {
        ProductOfArrayExceptSelf t = new ProductOfArrayExceptSelf();

        int[][] inputs = {
                {1, 2, 4, 6,},
                {-1, 0, 1, 2,},
        };

        for (int i = 0; i < inputs.length; i++) {
            int[] result = t.productExceptSelf(inputs[i]);
            for (Integer num : result) {
                System.out.print(num + " , ");
            }
        }
    }
}

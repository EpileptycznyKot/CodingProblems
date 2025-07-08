package two_pointers;

public class TwoIntegerSum {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int p = numbers.length - 1;

        while (l < p) {
            int currentSum = numbers[l] + numbers[p];
            if (currentSum == target) {
                return new int[]{l + 1, p + 1};
            }else if (currentSum < target) {
                l++;
            }else {
                p--;
            }
        }
        return null;
    }

    public static void runTests() {
        TwoIntegerSum t = new TwoIntegerSum();

        int[][] inputs = {
                {1, 2, 3, 4},
        };
        int[] targets = {3};

        for (int i = 0; i < inputs.length; i++) {
            int[] result = t.twoSum(inputs[i], targets[i]);
            System.out.printf(result[0] + " " + result[1]);
        }
    }
}

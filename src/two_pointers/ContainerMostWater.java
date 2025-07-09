package two_pointers;

public class ContainerMostWater {

    public int maxArea(int[] heights) {
        int max = 0;
        int l = 0;
        int p = heights.length - 1;

        for (int i = 0; i < heights.length - 1; i++) {
            int maxWater = Math.min(heights[l], heights[p]) * (p - l);
            max = Math.max(maxWater, max);
            if (heights[l] < heights[p]) {
                l++;
            } else {
                p--;
            }
        }

        return max;
    }

    public static void runTests() {
        ContainerMostWater t = new ContainerMostWater();

        int[][] inputs = {
                {2, 2, 2},
                {1, 7, 2, 5, 4, 7, 3, 6}
        };

        for (int i = 0; i < inputs.length; i++) {
            int result = t.maxArea(inputs[i]);
            System.out.printf(result + "\n");
        }
    }
}

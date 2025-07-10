package two_pointers;

public class MostRainWater {
    public int trap(int[] height) {

        int n = height.length;
        if (n == 0) return 0;

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int total = 0;


        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        for (int i = 0; i < n; i++) {
            int trappedWater = Math.min(leftMax[i], rightMax[i]) - height[i];
            if (trappedWater > 0) {
                total += trappedWater;
            }
        }

        return total;
    }

    public static void runTests() {
        MostRainWater t = new MostRainWater();

        int[][] inputs = {
//                {0, 2, 0, 3, 1, 0, 1, 3, 2, 1},
                {0,1,2,2,3,0}
        };

        for (int i = 0; i < inputs.length; i++) {
            int result = t.trap(inputs[i]);
            System.out.printf(result + "\n");
        }
    }
}

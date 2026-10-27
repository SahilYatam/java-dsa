package TwoPointers.hard;

class TrappingRainWater {
    public static int trap(int[] height) {
        int n = height.length;

        // Store the tallest bar seen from the left at each index.
        int[] leftMax = new int[n];

        // Store the tallest bar seen from the right at each index.
        int[] rightMax = new int[n];

        // The first bar is the tallest bar seen from the left at index 0.
        leftMax[0] = height[0];

        // Build leftMax from left to right.
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        // The last bar is the tallest bar seen from the right at the last index.
        rightMax[n - 1] = height[n - 1];

        // Build rightMax from right to left.
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int ans = 0; // Total trapped water.

        // Calculate the trapped water above each bar.
        for (int i = 0; i < n; i++) {

            // Water level is limited by the shorter of the two boundaries.
            int water = Math.min(leftMax[i], rightMax[i]) - height[i];

            // Add the water only when the position can hold water.
            if (water > 0) {
                ans += water;
            }
        }

        // Return the total water trapped across all positions.
        return ans;
    }

    public static void main(String[] args) {
        // int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        // Output: 6

        int[] height = { 4, 2, 0, 3, 2, 5 };
        // Output: 9

        int ans = trap(height);
        System.out.println(ans);

    }
}

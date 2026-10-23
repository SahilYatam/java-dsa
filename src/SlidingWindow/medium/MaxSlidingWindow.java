// 239. Sliding Window Maximum

import java.util.*;

class MaxSlidingWindow {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] output = new int[nums.length - k + 1];
        int index = 0;

        Deque<Integer> q = new ArrayDeque<>();

        int left = 0, right = 0;

        while (right < nums.length) {
            // remove smaller values from the back
            while (!q.isEmpty() && nums[q.peekLast()] < nums[right]) {
                q.pollLast();
            }

            // store index
            q.addLast(right);

            // remove indices outside the current window
            if (q.peekFirst() < left) {
                q.pollFirst();
            }

            // record the maximum value
            if (right + 1 >= k) {
                output[index] = nums[q.peekFirst()];
                index++;
                left++;
            }

            right++;
        }

        return output;
    }

    public static void main(String[] args) {
        // int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
        // int k = 3;
        // Output: [3,3,5,5,6,7] 
        int[] nums = { 3,1,1,3 };
        int k = 3;
        // Output: [3,3]
        int[] result = maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(result));

    }
}

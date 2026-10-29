// 31. Next Permutation

import java.util.*;

class NextPermutation {
    private static void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }

    public static int[] nextPermutation(int[] nums) {
        int idx = -1;
        int n = nums.length;

        // Find the pivot
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                idx = i;
                break;
            }
        }

        // If no pivot exists, reverse the entire array
        if (idx == -1) {
            reverse(nums, 0, n - 1);
            return nums;
        }

        // Find the successor and swap it with the pivot
        for (int i = n - 1; i > idx; i--) {
            if (nums[i] > nums[idx]) {
                int temp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = temp;
                break;
            }
        }

        // Reverse the suffix
        reverse(nums, idx + 1, n - 1);

        return nums;
    }

    public static void main(String[] args) {
        // int[] nums = {1,2,3};
        // Output: [1,3,2]

        // int[] nums = { 3, 2, 1 };
        // Output: [1,2,3]

        int[] nums = { 4, 3, 2, 5, 4, 1, 3 };
        // Output: [4, 3, 2, 5, 4, 3, 1]
        int[] ans = nextPermutation(nums);
        System.out.println(Arrays.toString(ans));
    }
}

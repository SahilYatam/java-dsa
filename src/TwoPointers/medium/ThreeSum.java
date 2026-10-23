// 15. 3Sum

import java.util.*;

class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    List<Integer> sumResult = new ArrayList<>();

                    sumResult.add(nums[i]);
                    sumResult.add(nums[left]);
                    sumResult.add(nums[right]);

                    result.add(sumResult);

                    left++;
                    right--;

                    // Skip duplicates for left pointer
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }

                    // Skip duplicates for right pointer
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = { -1, 0, 1, 2, -1, -4 };
        // Output: [[-1,-1,2],[-1,0,1]]

        // int[] nums = {0,1,1};
        // // Output: []

        // int[] nums = {0,0,0};
        // Output: [[0,0,0]]

        List<List<Integer>> result = threeSum(nums);

        System.out.println(result);
    }
}

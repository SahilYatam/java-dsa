package contest;

import java.util.*;

class MaximizeSum {
    public static List<Long> getMaxRearrangements(int[] nums) {
        List<Long> reversedNums = new ArrayList<>();

        for (int num : nums) {
            char[] digits = String.valueOf(num).toCharArray();
            Arrays.sort(digits);

            long reversed = 0;

            for (int i = digits.length - 1; i >= 0; i--) {
                reversed = reversed * 10 + (digits[i] - '0');
            }

            reversedNums.add(reversed);
        }

        return reversedNums;
    }

    public static long maximizeSum(int[] nums, int k) {
        long sum = 0;

        List<Long> rearrangedNums = getMaxRearrangements(nums);
        List<Long> improvements = new ArrayList<>();

        for (int num : nums) {
            sum += num;
        }

        for (int i = 0; i < rearrangedNums.size(); i++) {
            long improvement = rearrangedNums.get(i) - nums[i];
            improvements.add(improvement);
        }

        improvements.sort(Collections.reverseOrder());

        int limit = Math.min(k, improvements.size());

        for (int i = 0; i < limit; i++) {
            long improvement = improvements.get(i);

            if (improvement <= 0) {
                break;
            }

            sum += improvement;
        }

        return sum;
    }

    public static void main(String[] args) {
        // int[] nums = { 123, 45 };
        // int k = 1;
        // Output: 366

        int[] nums = { 102, 90, 14 };
        int k = 2;
        // Output: 341

        System.out.println(maximizeSum(nums, k));

    }
}

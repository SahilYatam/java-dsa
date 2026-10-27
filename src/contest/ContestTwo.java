package contest;

import java.util.*;

// Q1. Binary Digit Score
// Q2. Maximize Sum After At Most K Digit Rearrangements

class ContestTwo {
    public static int calculateScore(int a, int b) {
        int s1 = Integer.bitCount(a);
        int s2 = Integer.bitCount(b);

        int score = 0;

        if (s1 >= s2) {
            score = s1 * s2;
        } else {
            score = s2 / s1;
        }
        return score;
    }

    public static long maximizeSum(int[] nums, int k) {
        long sum = 0;

        for (int num : nums) {
            sum += num;
        }

        int[] originalNums = nums;

        List<Long> improvements = new ArrayList<>();

        for (int i = 0; i < originalNums.length; i++) {
            String numStr = Integer.toString(originalNums[i]);
            char[] digits = numStr.toCharArray();

            Arrays.sort(digits);

            StringBuilder sb = new StringBuilder();

            for (int j = digits.length - 1; j >= 0; j--) {
                sb.append(digits[j]);
            }
            long rearranged = Long.parseLong(sb.toString());

            long improvement = rearranged - originalNums[i];
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
        // int a = 14, b = 6;
        // Output: 6

        // int a = 5, b = 15;
        // Output: 2

        // System.out.println(calculateScore(a, b));

        // int[] nums = { 123, 45 };
        // int k = 1;
        // Output: 366

        int[] nums = { 102, 90, 14 };
        int k = 2;
        // Output: 341

        System.out.println(maximizeSum(nums, k));

    }
}

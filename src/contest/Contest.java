package contest;

import java.util.*;

// Q1. Difference Between Peaks and Valleys; Easy, solve
// Q2. Count Subarrays With Loose Bounds; Medium, solve
// Q3. Count Magical Substring Pairs I; Medium

class Contest {
    public static int peakValleyDifference(int[] nums) {
        List<Integer> peakNum = new ArrayList<>();
        List<Integer> vallyNum = new ArrayList<>();

        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                peakNum.add(nums[i]);
            }

            else if (nums[i] < nums[i - 1] && nums[i] < nums[i + 1]) {
                vallyNum.add(nums[i]);
            }
        }
        int peakSum = 0;

        for (int num : peakNum) {
            peakSum += num;
        }

        int vallySum = 0;

        for (int num : vallyNum) {
            vallySum += num;
        }

        return peakSum - vallySum;
    }

    public static long countSubarrays(int[] nums, int minK, int maxK) {
        long total = 0;
        long validEndingHere = 0;

        int n = nums.length;

        for (int right = 0; right < n; right++) {
            if (nums[right] >= minK && nums[right] <= maxK) {
                validEndingHere++;
                total += validEndingHere;
            } else {
                validEndingHere = 0;
            }
        }

        return total;
    }

    public static void main(String[] args) {
        // int[] nums = { 1, 5, 2, 4, 1, 3, 0 };
        // Output: 9

        // int[] nums = {6,5,2,5,5,3,6};
        // Output: -5
        // System.out.println(peakValleyDifference(nums));

        int[] nums = { 1, 4, 7, 3 };
        int minK = 1, maxK = 5;
        // Output:

        // int[] nums = {1,1};
        // int minK = 1, maxK = 1;
        // Output: 3
        long ans = countSubarrays(nums, minK, maxK);
        System.out.println(ans);

    }
}

// 167. Two Sum II - Input Array Is Sorted

import java.util.*;;

class TwoSum {
    public static int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum > target) {
                right--;
            } 
            else if (sum < target) {
                left++;
            }
            else {
                return new int[] { left + 1, right + 1 };
            }
        }

        return new int[] {};
    }

    public static void main(String[] args) {
        int[] numbers = { 2, 7, 11, 15 };
        int target = 9;
        // Output: [1,2]

        int[] ans = twoSum(numbers, target);

        System.out.println(Arrays.toString(ans));

    }

}
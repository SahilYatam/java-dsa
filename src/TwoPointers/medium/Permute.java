import java.util.*;

class Permute {
    private static List<List<Integer>> permuteHelper(List<Integer> nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums.size() == 1) {
            List<Integer> base = new ArrayList<>(nums);
            result.add(base);
            return result;
        }

        for (int i = 0; i < nums.size(); i++) {
            // Remove first element
            int n = nums.remove(0);

            // Recursively generate permutations of the remaining elements
            List<List<Integer>> perms = permuteHelper(nums);

            // Append the removed number to every permutation
            for (List<Integer> perm : perms) {
                perm.add(n);
            }

            // Add the generated permutations to the result
            result.addAll(perms);

            // Restore the removed element at the end
            nums.add(n);
        }
        return result;
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        // base case
        if (nums.length == 1) {
            List<Integer> base = new ArrayList<>();
            base.add(nums[0]);
            result.add(base);

            return result;
        }

        // Convert the array into a list so we can remove and append elements
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        return permuteHelper(list);
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        // Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

        List<List<Integer>> ans = permute(nums);
        System.out.println(Arrays.asList(ans).toString());
    }
}

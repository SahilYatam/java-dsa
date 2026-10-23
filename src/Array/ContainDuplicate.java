package Array;

import java.util.HashSet;

class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int num : nums){
            if(set.contains(num)){
                return true;
            }
            set.add(num);
        }

        return false;
    }
}

public class ContainDuplicate {
    public static void main(String[] args){
        Solution sol = new Solution();

        int[] nums = {1, 2, 3, 3};
        boolean result = sol.hasDuplicate(nums);

        System.out.println(result);
    }
}
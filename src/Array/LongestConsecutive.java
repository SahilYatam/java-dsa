package Array;

import java.util.*;

public class LongestConsecutive {
    public static int longestConsecutive(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();

        int currNum = 0, len = 0, longest = 0;

        for(int num : nums){
            hashSet.add(num);
        }

        for(int num : hashSet){
            if(hashSet.contains(num -1)) {
                continue;
            } else {
                currNum = num;
                len = 1;

                while (hashSet.contains(currNum + 1)) {
                    currNum = currNum + 1;
                    len++;
                }
            }

            if(len > longest){
                longest = len;
            }
        }
        
        return  longest;
    }

    public static void main(String[] args){
        int[] nums = {100,4,200,1,3,2};
        // Output: 4
        // The longest consecutive elements sequence is [1, 2, 3, 4]

        int val = longestConsecutive(nums);
        System.out.println(val);
    }
}

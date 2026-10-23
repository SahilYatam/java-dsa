
package Strings;

import java.util.HashSet;
import java.util.Set;

class LengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();

        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);

            // Remove characters until the duplicate is gone.
            while (set.contains(rightChar)) {
                char leftChar = s.charAt(left);
                set.remove(leftChar);
                left++;
            }

            // Add the new character to the valid window.
            set.add(rightChar);

            // Update the maximum length found so far.
            int currentLen = right - left + 1;
            maxLen = Math.max(maxLen, currentLen);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println(lengthOfLongestSubstring("bbbbb"));   // 1
        System.out.println(lengthOfLongestSubstring("pwwkew"));   // 3
        System.out.println(lengthOfLongestSubstring("abba"));    // 2
        System.out.println(lengthOfLongestSubstring(""));        // 0
    }
}

// 424. Longest Repeating Character Replacement
package Strings;

import java.util.*;

class CharacterReplacement {
    public static  int characterReplacement(String s, int k) {
        Map<Character, Integer> count = new HashMap<>();
        int result = 0;
        int l = 0; // Left pointer
        // Maintain a maxFreq variable that tracks the highest character frequency seen as the window expands.
        int maxFreq = 0;

        for(int r = 0; r < s.length(); r++){
            char rightChar = s.charAt(r);
            count.put(rightChar, count.getOrDefault(rightChar, 0) + 1);

            maxFreq = Math.max(maxFreq, count.get(rightChar));

            while((r - l + 1) - maxFreq > k){
                char leftChar = s.charAt(l);
                count.put(leftChar, count.get(leftChar) - 1);
                l++;
            }
            
            result = Math.max(result, r - l + 1);
        }

        return result;
    }
    
    public static void main(String args[]){
        String s = "ABAB";
        int k = 2;
        // Output: 4

        // String s = "AABABBA";
        // int k = 1;
        // Output: 4

        int ans = characterReplacement(s, k);

        System.out.println(ans);
    }
}

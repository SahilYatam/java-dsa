package Array;
import java.util.*;

// 49. Group Anagrams

class Solution3 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();

        for(String word : strs){
            int[] count = new int[26];

            for(char ch : word.toCharArray()){
                count[ch - 'a']++;
            }

            String key = Arrays.toString(count);

            groups.putIfAbsent(key, new ArrayList<>());
            groups.get(key).add(word);
        }
        return new ArrayList<>(groups.values());
    }
}


public class GroupAnagrams {
    public static void main(String[] args){

        Solution3 sol = new Solution3();

         String[] strs = {"act","pots","tops","cat","stop","hat"};
//        Output: [["hat"],["act", "cat"],["stop", "pots", "tops"]]

        List<List<String>> result = sol.groupAnagrams(strs);

        System.out.println(result);

    }
}

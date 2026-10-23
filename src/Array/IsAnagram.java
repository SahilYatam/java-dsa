package Array;

class Solution2 {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        int[] charCounts = new int[26];

        for(int i = 0; i < s.length(); i++){
            charCounts[s.charAt(i) - 'a']++;
            charCounts[t.charAt(i) - 'a']--;
        }

        for(int count : charCounts){
            if(count != 0){
                return false;
            }
        }

        return true;
    }
}


public class IsAnagram {
    public static void main(String[] args){
        Solution2 sol = new Solution2();

        String s = "racecar";
        String t = "carrace";

//        Output: true
        boolean result = sol.isAnagram(s, t);

        System.out.println(result);
    }
}

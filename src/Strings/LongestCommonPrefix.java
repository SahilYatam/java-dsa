// 14. Longest Common Prefix

package Strings;

class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        String result = "";

        // 1. Loop over the first string
        for (int i = 0; i < strs[0].length(); i++) {

            // 2. Loop over all the strings in the array and compare
            for (String s : strs) {
                if (i >= s.length() || s.charAt(i) != strs[0].charAt(i)) {
                    return result;
                }
            }

            result += strs[0].charAt(i);
        }

        return result;
    }

    public static void main(String[] args) {
        String[] strs = { "flower", "flow", "flight" };
        // Output: "fl"

        // String[] strs = {"dog","racecar","car"};
        // Output: ""
        String ans = longestCommonPrefix(strs);
        System.out.println(ans);
    }
}

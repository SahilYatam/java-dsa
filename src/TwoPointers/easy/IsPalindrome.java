package TwoPointers.easy;

class IsPalindrome {
    // Brute force

    // public static  boolean isPalindrome(String s) {
    //     String newStr = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");

    //     String reverseStr = new StringBuilder(newStr).reverse().toString();

    //     if(!newStr.equals(reverseStr)){
    //         return false;
    //     }

    //     return true;
    // }

    // Two pointers

    public static  boolean isPalindrome(String s) {
        String newStr = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        int left = 0, right = newStr.length()-1;

        while(left < right){
            if(newStr.charAt(left) != newStr.charAt(right)){
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
    
    
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        // String s = "abba";
        // Output: true

        // String s = "race a car";
        // Output: false
        
        boolean ans = isPalindrome(s);
        System.out.println(ans);

    }
}

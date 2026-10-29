// 412. Fizz Buzz

package Strings;

import java.util.*;

class FizzBuzz {
    public static List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();

        for(int i = 1; i <= n; i++){
            if(i % 3 == 0 && i % 5 == 0){
                result.add("FizzBuzz");
            }
            else if(i % 3 == 0){
                result.add("Fizz");
            }
            else if(i % 5 == 0){
                result.add("Buzz");
            }
            else {
                result.add(Integer.toString(i));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // int n = 3;
        // Output: ["1","2","Fizz"]  

        int n = 5;
        // Output: ["1","2","Fizz","4","Buzz"]

        List<String> ans = fizzBuzz(n);
        System.out.println(ans);

    }
}

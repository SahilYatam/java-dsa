package Array;
import java.util.*;

class Solution5 {

    public String encode(List<String> strs) {
        StringBuilder fullStr = new StringBuilder();

        for(String word : strs){
            fullStr.append(word.length()).append("#").append(word);
        }

        return fullStr.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while(i < str.length()){
            // Read the length
            StringBuilder len = new StringBuilder();

            while(str.charAt(i) != '#'){
                len.append(str.charAt(i));
                i++;
            }

            // Convert the string into int
            int length = Integer.parseInt(len.toString());

            // Skip '#'
            i++;

            // Read the word
            result.add(str.substring(i, i+length));

            // Jump to the Next encoded string
            i+= length;
        }
        return  result;
    }
}


public class EncodeDecode {
    public static void main(String[] args) {
        String[] strs = {"Hello","World"};
//      Output: ["Hello","World"]

        Solution5 sol = new Solution5();
        String str = sol.encode(List.of(strs));

        List<String> strArr = sol.decode(str);

        System.out.print(strArr);
    }
}

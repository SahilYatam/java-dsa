package Stack.medium;
import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                int fEle = stack.pop();
                int sEle = stack.pop();

                stack.push(sEle + fEle);
            } else if (tokens[i].equals("-")) {
                int fEle = stack.pop();
                int sEle = stack.pop();

                stack.push(sEle - fEle);
            } else if (tokens[i].equals("*")) {
                int fEle = stack.pop();
                int sEle = stack.pop();

                stack.push(sEle * fEle);
            } else if (tokens[i].equals("/")) {
                int fEle = stack.pop();
                int sEle = stack.pop();

                stack.push(sEle / fEle);
            } else {
                int num = Integer.parseInt(tokens[i]);
                stack.push(num);
            }
        }

        return stack.peek();
    }
}

public class  EvalRPN {
    public static void main(String[] args){
        Solution solution = new Solution();
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        int ans = solution.evalRPN(tokens);

        System.out.println(ans);
    }
}
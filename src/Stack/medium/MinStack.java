package Stack.medium;

import java.util.List;
import java.util.ArrayList;

class MinStackSol {
    private List<Integer> valStack = new ArrayList<>();
    private List<Integer> minStack = new ArrayList<>();

    public MinStackSol() {
        
    }
    
    public void push(int val) {
        this.valStack.add(val);
        
        if(minStack.isEmpty()){
            this.minStack.add(val);
        }
        else if(val < minStack.getLast()){
            this.minStack.add(val);
        }
        else {
            int topVal = minStack.getLast();
            this.minStack.add(topVal);
        }
    }
    
    public void pop() {
        this.valStack.removeLast();
        this.minStack.removeLast();
    }
    
    public int top() {
        return this.valStack.getLast();
    }
    
    public int getMin() {
        return this.minStack.getLast();
    }
}


public class MinStack {
    public static void main(String[] agrs){
        MinStackSol minStack = new MinStackSol();

        minStack.push(1);
        minStack.push(2);
        minStack.push(-3);
        minStack.push(-10);
        minStack.push(10);

        minStack.pop();
        int top = minStack.top();
        System.out.println(top);

        int min = minStack.getMin();
        System.out.println(min);
    }
}


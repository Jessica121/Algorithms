import java.util.Stack;

public class MinStack {

    /** Use another stack, or additional DS to push the min and origin together.
    if main stack is empty or the current element smaller than top of min stack, push both on both stack.
    else just push into main stack, when the elements are equal, we push for both also.
    as we pop, if the cur element == top of min stack, pop both, else just pop main stack.
    size of main stack >= min stack
    */
    
    Stack<Integer> main, min;
    public MinStack() {
        main = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int x) {
        if(main.isEmpty() || min.peek() >= x) min.push(x);
        main.push(x);
    }
    
    public void pop() {
        if(main.isEmpty()) return;
        int top = main.pop();
        // size of main >= min
        if(top == min.peek()) min.pop();
    }
    
    public int top() {
        // if(main.isEmpty()) return -1;
        return main.peek();
    }
    
    public int getMin() {
        // if(min.isEmpty()) return -1;
        return min.peek();
    }

}

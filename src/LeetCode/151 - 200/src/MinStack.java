import java.util.*;
public class MinStack {
    /** 
    use another min stack to store the min so far
    if push an element, it <= cur min stack top or empty. push to both stack.
    if pop, and the value == the top of the min stack, pop both.
    get the min by peeking from the min stack.
    
    */
    
    Stack<Integer> min, normal;
    
    public MinStack() {
        min = new Stack<>();
        normal = new Stack<>();
    }
    
    public void push(int x) {
        normal.push(x);
        if(min.isEmpty() || min.peek() >= x) min.push(x); 
    }
    
    public void pop() {
        if(normal.isEmpty()) return;
        int top = normal.pop();
        if(top == min.peek()) min.pop();
    }
    
    public int top() {
        if(normal.isEmpty()) return Integer.MIN_VALUE;
        return normal.peek();
    }
    
    public int getMin() {
        if(min.isEmpty()) return Integer.MIN_VALUE;
        return min.peek();
    }
}

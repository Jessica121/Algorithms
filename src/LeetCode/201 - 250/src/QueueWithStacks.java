import java.util.Stack;

public class QueueWithStacks {
    /** use two stacks, 
    push into sta1 when adding, when polling, if the sta2 is empty, then shift everything into sta2. push sta1.poll()
    and pop. outside
    is empty means both of them are empty.
    */
    
    Stack<Integer> sta1, sta2;
    public QueueWithStacks() {
        sta1 = new Stack<>();
        sta2 = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        sta1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        peek();
        return sta2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if(empty()) return -1;
        shiftIfNeeded();
        return sta2.peek();
    }
    
    private void shiftIfNeeded() {
        if(sta2.isEmpty()) {
            while(!sta1.isEmpty()) sta2.push(sta1.pop());
        }
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return sta1.isEmpty() && sta2.isEmpty();
    }
}
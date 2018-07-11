import java.util.*;

public class StackUsingTwoQueues {
    /** 
    really is to use two queues.
    when want to pop things, poll everything from que1 into que2 untill there is one element left, poll that and that is the res.
    swap the two queues.
    meaning always adding into que1, when poll, always adding into que2. and get the one elemnt in que1.
    if poll something but que1 is empty, return error.
    when want to poll, check if que1 is empty and que2 is not empty, swap it and perform polling.
    else do it directly on there
    
    */
    
    Queue<Integer> que1, que2;
    public StackUsingTwoQueues() {
        que1 = new LinkedList<>();
        que2 = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        que1.offer(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        top();
        return que1.poll();
    }
    
    /** Get the top element. */
    public int top() {
        if(empty()) return -1;
        if(que1.isEmpty()) {
            Queue<Integer> t = que1;
            que1 = que2;
            que2 = t;
        } while(que1.size() > 1) {
            que2.offer(que1.poll());
        }

        return que1.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return que1.isEmpty() && que2.isEmpty();
    }
}

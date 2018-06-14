import java.util.*;
public class SortStack {
/*
 * Sort Stack: use quick sort
 * left stack sorted, put self, put right
 * 3 stacks in each recursion call
 * 
 * e.g. 6 3 5 2 4 1
 * top is the pivot
 * small ones in small stack, big ones in big stack, put pivot into small one, big ones into orignal to reverse, and put everything into small one
 * return small one
 * 
 * base case is stack size <= 1
 * 
 * */
	
	// nlogn space, nlogn time, lgn levels, each level takes n
	public static Stack<Integer> sortStack(Stack<Integer> sta) {
		if(sta.size() <= 1) return sta;
		Stack<Integer> small = new Stack<>(), big = new Stack<>();
		int pivot = sta.pop();
		while(!sta.isEmpty()) {
			int next = sta.pop();
			if(next <= pivot) small.push(next);
			else big.push(next);
		}
		small = sortStack(small);
		big = sortStack(big);
		small.push(pivot);
		while(!big.isEmpty()) sta.push(big.pop());
		while(!sta.isEmpty()) small.push(sta.pop());
		return small;
	}
	
	/* since stack and linked list are same as in one end to get the element, good structure to do recursion.
	 * 
	 * imagine rest is sorted after recursion calls, this element should be just insert into the correct place.
	 * by putting everything larger than that into another temp stack.
	 * 
	 * O(N^2) time O(n) space
	 * 
	 */
	
	public static void sortStackTwo(Stack<Integer> sta) {
		if(sta.size() <= 1) return;
		int top = sta.pop();
		sortStackTwo(sta);
		Stack<Integer> temp = new Stack<>();
		while(!sta.isEmpty() && sta.peek() > top) temp.push(sta.pop());
		sta.push(top);
		while(!temp.isEmpty()) sta.push(temp.pop());
	}
	
	public static void main(String[] args) {
		Stack<Integer> sta = new Stack<>();
		sta.push(6);sta.push(3);sta.push(5);sta.push(2);sta.push(4);sta.push(1);
		long startTime = System.nanoTime();
		sortStackTwo(sta);
		long endTime = System.nanoTime();
		System.out.println("Took "+(endTime - startTime) + " ns"); 
		System.out.println(sta);

		startTime = System.nanoTime();
		sortStack(sta);
		endTime = System.nanoTime();
		System.out.println("Took "+(endTime - startTime) + " ns"); 
//		System.out.println(sortStack(sta));
	}
}

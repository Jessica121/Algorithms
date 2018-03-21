package algorithms;
/*
 * 给两个char array，其中有一些char为backspace就是删除前面的字符，要求输出一个boolean判断两个char array是否相同，时间要求O(n) , 空间要求O(1)
	例如：
	[a,b,'\b',d,c] 和[a,d,c] true
	[a,b,'\b','\b','\b',d,c] 和 [d,c] true
	[a,b,d,'\b'] 和 [a,d] false.
 * */
public class parseCharArrayWithBackSpace {
	// the most native thinking is to use a stack. when meet a \b && sta is not empty(), pop;
	// Then check if everything in the stack is the same with the target. skip this sol; Time O(n), Space O(n)
	public static void main(String[] args) {
		char[] arr = {'a','b','\b'};
		char[] arr2 = {'a'};
		System.out.println(check(arr, arr2));
	}
	
	private static boolean check(char[] arr1, char[] arr2) {
		int cnt = 0;
		for(int i = arr1.length - 1; i >= 0; i--) {
			if(arr1[i] == '\b') cnt++;
			else {
				while(cnt > 0 && i >= 0) {
					arr1[i--] = '#';
					cnt--;
				}
			}
		}
//		System.out.println(Arrays.toString(arr1));
		int j = 0;
		for(int i = 0; i < arr1.length; i++) {
			if(arr1[i] == '#' || arr1[i] == '\b') continue;
			if(j >= arr2.length || arr1[i] != arr2[j]) return false;
			j++;
		}
		if(j != arr2.length) return false;
		return true;
	}

}

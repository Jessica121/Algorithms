import java.util.Arrays;

public class MergeSortArray {
	/*
	 * merge sort an array
	 * 5,3,6,2,5,4,2
	 * 
	 * 2 3 4 5 6 5 4
	 * 4 5 6
	 * 
	 * recursion calls return the index of the sorted subarray
	 * the right half need to return a new array and the left half need to know its end
	 * copy right half to a new array and merge the whole array into the left(original), return the left(original)
	 * if start >= end return
	 * */
	
	// O(NlogN) space and time.
	public static int[] mergeSort(int[] array, int start, int end) {
		if(start >= end) return array;
		int mid = start + (end - start) / 2;
		int[] right = new int[end - mid]; // right is end - mid not arr.length - 1, else not the subarray but starting from the index mid + 1
		copyArray(array, mid, end, right); // start from mid + 1
		mergeSort(array, start, mid);
		right = mergeSort(right, 0, right.length - 1);
		int ptr1 = mid, ptr2 = right.length - 1, ptr = end;
		while(ptr1 >= 0 && ptr2 >= 0) {
			if(array[ptr1] >= right[ptr2]) array[ptr--] = array[ptr1--];
			else array[ptr--] = right[ptr2--];
		}
		while(ptr2 >= 0) array[ptr--] = right[ptr2--];
		return array;
	}
	
	private static void copyArray(int[] array, int mid, int end, int[] newArr) {
		for(int i = mid + 1; i <= end; i++) newArr[i - mid - 1] = array[i];
	}

	public static void main(String[] args) {                                        
		int[] array = {3,4,3,3,33,2,3,5,5,3,3};
		array = mergeSort(array, 0, array.length - 1);
		System.out.println(Arrays.toString(array));
	}

}

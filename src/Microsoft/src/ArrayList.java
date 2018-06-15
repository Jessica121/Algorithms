
public class ArrayList<T> {
	/*
	 * a resizeable array with a ptr indicating the last element position. if reached last, create a new temp array with facter * original len
	 * new array and copy the elements over.
	 * remove requires shifting all left by one, also the last element.
	 * size can be indicated by the last element.
	 * set (index, element) can be dont directly on setting the array index 
	 * 
	 * */
	
	public int ptr;
	public final int RESIZE_FACTOR = 2, INITAL_LEN = 1;
	public Object[] array;
	
	public ArrayList() {
		this.ptr = 0;
		array = new Object[INITAL_LEN];
	}
	
	public void add(T element) {
		if(ptr == array.length - 1) createNew();
		array[ptr++] = element;
	}
	
	public void set(int index, T element) throws Exception {
		if(index > ptr) throw new Exception("Index out of bounds");
		array[index] = element;
	}
	
	public void remove(T element) throws Exception {
		for(int i = 0; i <= ptr; i++) {
			if(array[i] == element) remove(i);
		}
	}
	
	private void remove(int i) throws Exception {
		if(i > ptr) throw new Exception("Index out of bounds");
		// for cases when i == ptr
		array[i] = null;
		for(int j = i + 1; j <= ptr; j++) array[j - 1] = array[j];
		ptr = ptr - 1;
	}
	
	public int size() {
		return ptr;
	}
	
	public int arrayLen() {
		return array.length;
	}
	
	private void createNew() {
		Object[] temp = new Object[array.length * 2];
		for(int i = 0; i < array.length; i++) temp[i] = array[i];
		array = temp;
	}
	
	public void print() {
		for(int i = 0; i < ptr; i++) System.out.println(array[i]);
	}

	public static void main(String[] args) throws Exception {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.set(0, 5);
//		list.print();
		list.remove(Integer.valueOf(2));
		list.print();

		System.out.println(list.size() + ", " + list.arrayLen());
	}

}

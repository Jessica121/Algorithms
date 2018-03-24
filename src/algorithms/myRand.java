package algorithms;
import java.util.*;

public class myRand {
/*
 * 给一个rand()的方法，可以return [0,1)的double随机数.
 * 让你写一个int myRand(int x, int y)，return[x, y]（y inclusive）之间的随机整数. 
 * 
 * */
	public static void main(String[] args) {
		int[] map = new int[21];
		for(int i = 0; i < 2000; i++) {
			map[myRand(30,50) - 30]++;
		}
		System.out.println(Arrays.toString(map));
	}
	
	private static int myRand(int x, int y) {
		Random rand = new Random();
		double ran = rand.nextDouble();		
		//System.out.println("yo" + (int)(ran * 3));
		/*chosen (approximately) uniformly from the range 0.0d (inclusive) to 1.0d (exclusive)*/
		return x + (int)((y - x + 1) * ran);
	}

}

package algorithms;

public class numOfPointsInACircle {
/*
 * given an integer r，find how many integer points are located in a circle with radius r 
*/
	public static void main(String[] args) {
		System.out.println(safeWay(1.0));
		System.out.println(fastWay(1.0));
	}
	
	private static int safeWay(double radix) {
		int r = (int) radix;
		int cnt = 0;
		for(int x = -r; x <= r; x++) {
			for(int y = -r; y <= r; y++) {
				if(x * x + y * y <= radix * radix) cnt++;
			}
		}
		return cnt;
	}
	
	private static int fastWay(double radix) {
		double x = radix / Math.sqrt(2);
		int floor = (int) x, ceil = floor + 1;
		int margin = 0;
		for(int i = -floor; i <= floor; i++) {
			for(int j = ceil; j <= radix; j++) {
				if(i * i + j * j <= radix * radix) margin++;
			}
		}
		margin = margin * 4;
		int inside = floor * floor * 4 + floor * 4 + 1;
		return margin + inside;
	}

}

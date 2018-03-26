package algorithms;
import java.util.*;
public class candyCrush {
/*
 * 随机生成玛丽医生的地图, 在16x8的地图内，随机生成n个细菌。细菌一共有三种颜色。输入是n，返回一个二维数组.
 * 输入是n，输出随机生成的玛丽医生的地图（16x8，里面一共有三种颜色的细菌，横向或纵向连续三个格子不能是相同的颜色细菌），地图中有n个细菌。
 * 考有条件生成随机数的。
 * 
 * */
	private static final int w = 16;
	private static final int h = 8;
	private static final int numOfBac = 3;
	private static Random rand = new Random();
	private static int[][] map = new int[w][h];
	private static int[][] map2 = new int[w][w];

	public static void main(String[] args) {
//		generate(24);
		generateEasy();
		int cnt = 0;
		for(int i = 0; i < map2.length; i++) {
			for(int j = 0; j < map2[0].length; j++) {
//				if(map2[i][j] != 0) cnt++;
			}
			System.out.println(Arrays.toString(map2[i]));
		}
//		System.out.println(cnt);
	}
	
	private static List<Integer> initList() {
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < numOfBac + 1; i++) {
			list.add(i);
		}
		return list;
	}
	
	private static void initGrid() {
		for(int i = 0; i < map.length; i++) Arrays.fill(map[i], -1);
	}
	
	private static void initGrid2() {
		for(int i = 0; i < map2.length; i++) Arrays.fill(map2[i], -1);
	}
	
	private static void generate(int n) {
		if(n > w * h) return; // do nothing
		initGrid();
		int blankNum = w * h - n;
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[0].length; j++) {
				List<Integer> list = initList();
				while(!satisfy(map, i, j, blankNum, n)) {
					list.remove(new Integer(map[i][j]));
					// 别忘了加回来，如果删除的是0.
					if(map[i][j] == 0) blankNum++;
					int ind = rand.nextInt(list.size());
					map[i][j] = list.get(ind);
					if(map[i][j] == 0) blankNum--;
				}
			}
		}
		
		while(blankNum != 0) {
			int r = 0;
			int c = 0;
			while(map[r][c] == 0) {
				r = rand.nextInt(map.length);
				c = rand.nextInt(map[0].length);
			}
			map[r][c] = 0;
			blankNum--;
		}
	}
	
	private static boolean satisfy(int[][] map, int row, int col, int blankNum, int n) {
		if(map[row][col] == -1) return false;
		if(map[row][col] == 0) {
			if(blankNum < 0) return false;
		} else {
			if(row - 2 >= 0) {
				if(map[row - 1][col] == map[row][col] && map[row - 2][col] == map[row][col]) return false;
			}
			if(col - 2 >= 0) {
				if(map[row][col - 1] == map[row][col] && map[row][col - 2] == map[row][col]) return false;
			}
		}
		return true;
	}

	/*
	 *  规则类似 candy crush 游戏, 给你一个 table, n*n 的，然后 3 种 color，要求每排每列不能有连续三个一样颜色的。随机生成table。
	 * */
	private static void generateEasy() {
		initGrid2();
		for(int i = 0; i < map2.length; i++) {
			for(int j = 0; j < map2[0].length; j++) {
				List<Integer> list = initList();
				while(!satisfy(map2, i, j)) {
					list.remove(new Integer(map2[i][j]));
					int ind = rand.nextInt(list.size());
					map2[i][j] = list.get(ind);
				}
			}
		}
	}
	
	private static boolean satisfy(int[][] map, int row, int col) {
		if(map[row][col] == -1) return false;
			if(row - 2 >= 0) {
				if(map[row - 1][col] == map[row][col] && map[row - 2][col] == map[row][col]) return false;
			}
			if(col - 2 >= 0) {
				if(map[row][col - 1] == map[row][col] && map[row][col - 2] == map[row][col]) return false;
			}
		return true;
	}
	
}

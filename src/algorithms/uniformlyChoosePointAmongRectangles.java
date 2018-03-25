package algorithms;
import java.util.Random;
public class uniformlyChoosePointAmongRectangles {
	private static uniformlyChoosePointAmongRectangles instance = new uniformlyChoosePointAmongRectangles();
	private static Random rand = new Random();
	
	class Point {
		int x, y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public String toString() {
			return "(" + x + ", " + y + ")";
		}
	}
	
	class Rectan {
		Point p1, p2;
		public Rectan(Point p1, Point p2) {
			this.p1 = p1;
			this.p2 = p2;
		}
		
		public Rectan(int x, int y, int w, int h) {
			p1 = new Point(x, y);
			p2 = new Point(x + w, y - h);
		}
		
		private int width() {
			return p2.x - p1.x;
		}
		
		private int height() {
			return p1.y - p2.y;
		}
		
		private int area() {
			return width() * height();
		}
		
		@Override
		public String toString() {
			return "[" + p1.toString() + ", " + p2.toString() + "]";
		}
	}

	public static void main(String[] args) {
		Rectan[] rects = new Rectan[10];
		int prev = 0;
		for(int i = 0; i < rects.length; i++) {
			int x = rand.nextInt(5) + prev;
			int y = rand.nextInt(5);
			int w = 4;
			prev = x + w + 1;
			int h = 5;
			rects[i] = instance.new Rectan(x, y, w, h);
//			System.out.println(rects[i].toString());
		}
		for(int j = 0; j < 10; j++) {
//			System.out.println(randomInAll(rects));
			randomInAll(rects);
		}
	}
	
	private static Point randomInOneRect(Rectan rec) {
		int x = rec.p1.x + rand.nextInt(rec.width() + 1);
		int y = rec.p1.y - rand.nextInt(rec.height() + 1); 
		return instance.new Point(x, y);
	}
	
	private static Point randomInAll(Rectan[] recs) {
		// randomly choose a rectangle base on the area
		int prev = 0, res = 0;
		for(int i = 0; i < recs.length; i++) {
			if(rand.nextInt(prev + recs[i].area()) >= prev) res = i;
			prev += recs[i].area();
		}
		System.out.println(res);
		return randomInOneRect(recs[res]);
	}

}

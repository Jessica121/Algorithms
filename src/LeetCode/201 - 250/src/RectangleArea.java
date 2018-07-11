
public class RectangleArea {
    /*
    // First not include anything: E >= C || G <= A || B >= H || F >= D
    (Max of (A, E) - min of (G, C)) * (max(B, F) * min of (H, D))
    if one of them is neg, return 0.
    
    CORNER CASE: OVERFLOW :]]]]]]
    */
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        return (C - A) * (D - B) + (G - E) * (H - F) - (int) intersect(A, B, C, D, E, F, G, H);
    }
    
    private long intersect(int A, int B, int C, int D, int E, int F, int G, int H) {
    	// type casting needs to be done at element level.
        long width = (long) Math.min(G, C) - (long) Math.max(A, E);
        if(width <= 0) return 0;
        long height = (long) Math.min(H, D) - (long) Math.max(B, F);
        if(height <= 0) return 0;
        return width * height;
    }
}

import java.util.*;
public class Flatten2DVector {
    /*
    i am gonna go with the silly way:
    use a resizable array save everything first, then have an extra pointer take the next, opps..
    
    */
    List<Integer> res;
    int ptr;
    public Flatten2DVector(List<List<Integer>> vec2d) {
        this.res = new ArrayList<>();
        this.ptr = 0;
        init(res, vec2d);
    }
    
    private void init(List<Integer> res, List<List<Integer>> vec2d) {
        for(List<Integer> vec1d : vec2d) {
            for(int vec : vec1d) res.add(vec);
        }
    }

    public Integer next() {
        return res.get(ptr++);
    }

    public boolean hasNext() {
        return ptr < res.size();
    }
    
    /*
    two pointers, but has next checks when ptr >= current list size, reset it to 0, and ptr1++
    if ptr2 <= cur list, true.
    else reset it to 0 and ptr1++
    outter condition checks ptr1 <= totoal size
    out of loop return false.
    */
    
    List<List<Integer>> list;
    int ptr1, ptr2;
    public Vector2DBetter(List<List<Integer>> vec2d) {
        this.list = vec2d;
        this.ptr1 = 0;
        this.ptr2 = 0;
    }

    public Integer next() {
        return list.get(ptr1).get(ptr2++);
    }

    public boolean hasNext() {
        // may possible that consecutive [] lists.
        while(ptr1 < list.size()) {
            if(ptr2 < list.get(ptr1).size()) return true;
            else {
                ptr1++;
                ptr2 = 0;
            }
        }
        return false;
    }
    
    /*
    if using iterator, same logic, if second iterator does not have next, then second iterator points to the begin of the first iterator's next.
    outter condition is whether the ptr1 has next.
    while second iterator does not have next, do this. until the first iterator does not have next either.
    
    */
    
    Iterator<List<Integer>> ptr1;
    Iterator<Integer> ptr2;
    public Vector2DIterator(List<List<Integer>> vec2d) {
        ptr1 = vec2d.iterator();
        ptr2 = ptr1.hasNext() ? ptr1.next().iterator() : null;
    }

    @Override
    public Integer next() {
        return ptr2.next();
    }

    @Override
    public boolean hasNext() {
        while(ptr1.hasNext() && !ptr2.hasNext()) {
            ptr2 = ptr1.next().iterator();
        }
        if(ptr2 != null && ptr2.hasNext()) return true;
        return false;
    }
}

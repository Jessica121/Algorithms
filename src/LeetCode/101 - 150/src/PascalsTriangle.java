
public class PascalsTriangle {
    /*
    cur row, i = 0 .. row no
    row - 1, i - 1 + row - 1, i. out of bounds treated as 0.
    init as 1 in first row.
    
    */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if(numRows == 0) return res;
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        res.add(firstRow);
        for(int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for(int j = 0; j <= i; j++) {
            	// parenthese for triple conditions.
            	// both side check the bounds.
                row.add((j - 1 < 0 ? 0 : res.get(i - 1).get(j - 1)) + (j >= res.get(i - 1).size() ? 0 : res.get(i - 1).get(j)));
            }
            res.add(row);
        }
        return res;
    }
}

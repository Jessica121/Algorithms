
public class PascalTriangleII {
    /*
    really just a approach that replace the previous one.
    cannot modify on the curren one, as it will infect the later ones.
    in each level, create a new list, and pass it as the list next one will look into
    return the list
    */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        if(rowIndex == 0) return res;
        for(int i = 1; i <= rowIndex; i++) {
            List<Integer> temp = new ArrayList<>();
            for(int j = 0; j <= i; j++) {
                temp.add((j - 1 < 0 ? 0 : res.get(j - 1)) + (j >= res.size() ? 0 : res.get(j)));
            }
            res = temp;
        }
        return res;
    }
}

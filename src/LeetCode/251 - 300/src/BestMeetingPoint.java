    /*
    the idea is to calculate the middle in both x and y direction.
    iterate thru the matrix, oncee encounter 1, put x and y into arraylist
    sort x no need to sort y.
    use a helper funtion that takes the arraylist, and a boolean flag indicating if its x or y.
    sort if x, then take the middle: get the index of:
        the middle is if its odd, takes size / 2 + 1
        else size / 2
    then iteration thru to calculate the dist: abs of the middle and every value.
    return the sum
    main func adds up sum in two directions.
    
    */
    public int minTotalDistance(int[][] grid) {
        List<Integer> rows = new ArrayList<>(), cols = new ArrayList<>();
        iterateThru(grid, rows, cols);
        int rowSum = dist2D(rows, false), colSum = dist2D(cols, true);
        return rowSum + colSum;
    }
    
    private void iterateThru(int[][] grid, List<Integer> rows, List<Integer> cols) {
        // Confused x with y, y is horizontal, x is the other direction.
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
     } 
    
    private int dist2D(List<Integer> list, boolean needsToSort) {
        if(list == null || list.size() == 0) return 0;
        if(needsToSort) Collections.sort(list);
        int index = list.size() % 2 == 0 ? list.size() / 2 - 1: list.size() / 2;
        int middle = list.get(index);
        int sum = 0;
        for(int ele : list) {
            sum += Math.abs(ele - middle);
        }
        return sum;
    }
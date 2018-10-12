    /*
    no brianer for me?
    just check char by char i = 0 .. len - 1 if the substring of length 2 equals "++" substring(i, i + 2) 
    if so concat str(0, i) + "--" + str(i + 2) and add it to the res.
    
    corner case: s.length < 2, loop will not go thru.
    input string contains other chars other than - and + 
    
    time s.length ^ 2, one for iteration, for each iteration the string copy takes o(len) time.
    
    */
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<>();
        for(int i = 0; i < s.length() - 1; i++) {
            if(s.substring(i, i + 2).equals("++")) {
                res.add(s.substring(0, i) + "--" + s.substring(i + 2));
            }
        }
        return res;
    }
    /*
    dynamic programming.
    create a 2D array, with the same number of color, if one more pillar added, means 
    dp[n][k] = (n == 1 ? k : dp[n - 1][k] * k) - (n - 3 < 0 ? 0 : dp[n - 3][k] * (k - 1)          // last one is for last one posts of n - 1 posts have the same color as the one about to be painted.
    i = 0 .. n, j = 0 .. k
    if n = 0 || k = 0, return 0;
    
    --- this doesnt work ---
        // if(n == 0 || k == 0) return 0;
        // int[][] dp = new int[n + 1][k + 1];
        // for(int i = 0; i <= n; i++) {
        //     for(int j = 0; j <= k; j++) {
        //         dp[i][j] = (i == 1 ? j : dp[i - 1][j] * j) - (i - 3 < 0 ? 0 : dp[i - 3][j] * (j - 1));
        //     }
        // }
        // return dp[n][k];
        
    --- but could see the prev ones are not used much unless by the later ones --- 
    
    */
    
    /*
    the idea is diffrentiating the posts with same two color at the end and posts have different color at the end.
    same color transferred into diff color by * (k - 1) as each color can paint (k - 1) colors. -> part of diff color
    diff color old -> new same color, by dup the last color of each possibility. 
    the rest: diff * (k - 1) -> new diff color again.
    
    so save the old diff, as it is the new same.
    and (same + diff) * (k - 1) is new diff.
    return the sum of this two.
    
    */
    public int numWays(int n, int k) {
        if(n == 0 || k == 0) return 0;
        if(n == 1) return k;                // if have one post.
        int same = k, diff = k * (k - 1);   // if have two posts.
        int temp = -1;
        for(int i = 2; i < n; i++) {        // if have more than three posts.
            temp = diff;
            diff = (same + diff) * (k - 1);
            same = temp * 1;
        }
        return same + diff;
    }
class Solution {
    public int count(int n, int m) {

        int[][] dp = new int[n + 1][m + 1];

        
        for (int i = 1; i <= m; i++) {
            dp[1][i] = 1;
        }

    
        for (int len = 2; len <= n; len++) {

            for (int curr = 1; curr <= m; curr++) {

                for (int prev = 1; prev <= m; prev++) {

                    if (curr % prev == 0 || prev % curr == 0) {
                        dp[len][curr] += dp[len - 1][prev];
                    }
                }
            }
        }

        
        int ans = 0;
        for (int i = 1; i <= m; i++) {
            ans += dp[n][i];
        }

        return ans;
    }
}

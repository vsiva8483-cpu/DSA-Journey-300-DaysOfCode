class Solution {
    public String stoneGameIII(int[] stoneValue) {

        int n = stoneValue.length;
        int[] dp = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {

            int currentSum = 0;
            int best = Integer.MIN_VALUE;

            for (int take = 1; take <= 3 && i + take - 1 < n; take++) {

                currentSum += stoneValue[i + take - 1];

                int score = currentSum - dp[i + take];

                if (score > best) {
                    best = score;
                }
            }

            dp[i] = best;
        }

        if (dp[0] > 0) {
            return "Alice";
        }

        if (dp[0] < 0) {
            return "Bob";
        }

        return "Tie";
    }
}

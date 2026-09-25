class Solution {
    int[][] box;
    int[] dp;

    int solve(int i) {
        if (dp[i] != 0)
            return dp[i];

        int max = 0;

        for (int j = 0; j < box.length; j++) {
            if (box[i][0] > box[j][0] &&
                box[i][1] > box[j][1]) {

                max = Math.max(max, solve(j));
            }
        }

        dp[i] = box[i][2] + max;
        return dp[i];
    }

    public int maxHeight(int[] height, int[] width, int[] length) {

        int n = height.length;
        box = new int[3 * n][3];

        int k = 0;

        for (int i = 0; i < n; i++) {

            box[k++] = new int[]{
                Math.max(width[i], length[i]),
                Math.min(width[i], length[i]),
                height[i]
            };

            box[k++] = new int[]{
                Math.max(height[i], length[i]),
                Math.min(height[i], length[i]),
                width[i]
            };

            box[k++] = new int[]{
                Math.max(height[i], width[i]),
                Math.min(height[i], width[i]),
                length[i]
            };
        }

        dp = new int[3 * n];

        int ans = 0;

        for (int i = 0; i < 3 * n; i++) {
            ans = Math.max(ans, solve(i));
        }

        return ans;
    }
}

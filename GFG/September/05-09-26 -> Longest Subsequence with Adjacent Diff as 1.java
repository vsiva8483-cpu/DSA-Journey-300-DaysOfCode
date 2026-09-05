mport java.util.HashMap;

class Solution {
    public int longestSubseq(int[] arr) {

        HashMap<Integer, Integer> dp = new HashMap<>();

        int ans = 1;

        for (int x : arr) {

            int left = dp.getOrDefault(x - 1, 0);
            int right = dp.getOrDefault(x + 1, 0);

            int current = 1 + Math.max(left, right);

            // Keep the best subsequence ending with x
            dp.put(x, Math.max(dp.getOrDefault(x, 0), current));

            ans = Math.max(ans, dp.get(x));
        }

        return ans;
    }
}

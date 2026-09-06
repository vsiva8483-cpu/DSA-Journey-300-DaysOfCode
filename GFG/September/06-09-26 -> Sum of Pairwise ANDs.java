class Solution {
    public long pairAndSum(int[] arr) {
        long ans = 0;

        for (int bit = 0; bit < 31; bit++) {
            long count = 0;

            for (int x : arr)
                if ((x & (1 << bit)) != 0)
                    count++;

            ans += count * (count - 1) / 2 * (1L << bit);
        }

        return ans;
    }
}

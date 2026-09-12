class Solution {
    public long countCommas(long n) {
        long ans = 0;
        long start = 1000;
        long commas = 1;

        while (start <= n) {
            long end = start * 1000 - 1;

            if (end > n)
                end = n;

            ans += (end - start + 1) * commas;

            start *= 1000;
            commas++;
        }

        return ans;
    }
}

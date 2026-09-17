class Solution {
    public int minSumOfLengths(int[] arr, int target) {

        int n = arr.length;
        int[] minLen = new int[n];

        int INF = n + 1;

        for (int i = 0; i < n; i++) {
            minLen[i] = INF;
        }

        int left = 0;
        int sum = 0;
        int best = INF;

        for (int right = 0; right < n; right++) {

            sum += arr[right];

            while (sum > target) {
                sum -= arr[left];
                left++;
            }

            if (sum == target) {

                int len = right - left + 1;

                if (left > 0 && minLen[left - 1] != INF) {
                    best = Math.min(best, len + minLen[left - 1]);
                }

                minLen[right] = len;
            }

            if (right > 0) {
                minLen[right] = Math.min(minLen[right],
                                         minLen[right - 1]);
            }
        }

        return best == INF ? -1 : best;
    }
}

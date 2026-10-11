class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        long k = (long) k1 + k2;
        int[] freq = new int[100001];

        for (int i = 0; i < nums1.length; i++) {
            int d = Math.abs(nums1[i] - nums2[i]);
            freq[d]++;
        }

        for (int d = 100000; d > 0 && k > 0; d--) {
            if (freq[d] == 0) continue;

            long count = freq[d];
            long use = Math.min(k, count);

            // Reduce as many differences as possible by 1.
            long full = Math.min(count, k / count);
            if (full > 0) {
                freq[d] -= (int) count;
                freq[d - 1] += (int) count;
                k -= count;
            } else {
                long reduce = k / count;
                if (reduce > 0) {
                    freq[d] -= (int) count;
                    freq[d - (int) reduce] += (int) count;
                    k -= reduce * count;
                }

                if (k > 0) {
                    long remaining = k;
                    freq[d - (int) reduce] -= (int) remaining;
                    freq[d - (int) reduce - 1] += (int) remaining;
                    k = 0;
                }
            }
        }

        long ans = 0;

        for (int d = 0; d <= 100000; d++) {
            ans += (long) d * d * freq[d];
        }

        return ans;
    }
}

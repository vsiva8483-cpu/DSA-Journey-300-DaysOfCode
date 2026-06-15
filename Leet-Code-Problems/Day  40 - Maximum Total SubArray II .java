import java.util.*;

class Solution {

    static class Node {
        long val;
        int l, r;

        Node(long val, int l, int r) {
            this.val = val;
            this.l = l;
            this.r = r;
        }
    }

    int[][] maxSt;
    int[][] minSt;
    int[] log;

    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;

        buildSparseTables(nums);

        PriorityQueue<Node> pq =
                new PriorityQueue<>((a, b) -> Long.compare(b.val, a.val));

        for (int l = 0; l < n; l++) {
            pq.offer(new Node(getValue(l, n - 1), l, n - 1));
        }

        long ans = 0;

        while (k-- > 0) {
            Node cur = pq.poll();

            ans += cur.val;

            if (cur.r > cur.l) {
                int nr = cur.r - 1;
                pq.offer(new Node(getValue(cur.l, nr), cur.l, nr));
            }
        }

        return ans;
    }

    private void buildSparseTables(int[] nums) {
        int n = nums.length;

        log = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            log[i] = log[i / 2] + 1;
        }

        int K = log[n] + 1;

        maxSt = new int[K][n];
        minSt = new int[K][n];

        for (int i = 0; i < n; i++) {
            maxSt[0][i] = nums[i];
            minSt[0][i] = nums[i];
        }

        for (int j = 1; j < K; j++) {
            for (int i = 0; i + (1 << j) <= n; i++) {
                maxSt[j][i] =
                        Math.max(maxSt[j - 1][i],
                                maxSt[j - 1][i + (1 << (j - 1))]);

                minSt[j][i] =
                        Math.min(minSt[j - 1][i],
                                minSt[j - 1][i + (1 << (j - 1))]);
            }
        }
    }

    private long getValue(int l, int r) {
        int len = r - l + 1;
        int j = log[len];

        int mx = Math.max(
                maxSt[j][l],
                maxSt[j][r - (1 << j) + 1]
        );

        int mn = Math.min(
                minSt[j][l],
                minSt[j][r - (1 << j) + 1]
        );

        return (long) mx - mn;
    }
}

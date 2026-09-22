class Solution {
    int k, n;
    int[][] cnt;
    int[] prod;

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.k = k;
        n = nums.length;

        cnt = new int[4 * n][k];
        prod = new int[4 * n];

        build(1, 0, n - 1, nums);

        int[] ans = new int[queries.length];

        for (int q = 0; q < queries.length; q++) {
            int index = queries[q][0];
            int value = queries[q][1];
            int start = queries[q][2];
            int x = queries[q][3];

            update(1, 0, n - 1, index, value);

            Node res = query(1, 0, n - 1, start, n - 1);

            ans[q] = res.cnt[x];
        }

        return ans;
    }

    void build(int node, int l, int r, int[] nums) {
        if (l == r) {
            prod[node] = nums[l] % k;
            cnt[node][prod[node]] = 1;
            return;
        }

        int mid = (l + r) / 2;

        build(node * 2, l, mid, nums);
        build(node * 2 + 1, mid + 1, r, nums);

        merge(node, node * 2, node * 2 + 1);
    }

    void update(int node, int l, int r, int index, int value) {
        if (l == r) {
            prod[node] = value % k;

            for (int i = 0; i < k; i++)
                cnt[node][i] = 0;

            cnt[node][prod[node]] = 1;
            return;
        }

        int mid = (l + r) / 2;

        if (index <= mid)
            update(node * 2, l, mid, index, value);
        else
            update(node * 2 + 1, mid + 1, r, index, value);

        merge(node, node * 2, node * 2 + 1);
    }

    void merge(int node, int left, int right) {
        for (int i = 0; i < k; i++)
            cnt[node][i] = cnt[left][i];

        // Prefixes which continue into right part
        for (int i = 0; i < k; i++) {
            int rem = (prod[left] * i) % k;
            cnt[node][rem] += cnt[right][i];
        }

        prod[node] = (prod[left] * prod[right]) % k;
    }

    Node query(int node, int l, int r, int ql, int qr) {
        if (ql <= l && r <= qr) {
            return new Node(prod[node], cnt[node]);
        }

        int mid = (l + r) / 2;

        if (qr <= mid)
            return query(node * 2, l, mid, ql, qr);

        if (ql > mid)
            return query(node * 2 + 1, mid + 1, r, ql, qr);

        Node left = query(node * 2, l, mid, ql, qr);
        Node right = query(node * 2 + 1, mid + 1, r, ql, qr);

        return combine(left, right);
    }

    Node combine(Node left, Node right) {
        int[] c = new int[k];

        for (int i = 0; i < k; i++)
            c[i] = left.cnt[i];

        for (int i = 0; i < k; i++) {
            int rem = (left.prod * i) % k;
            c[rem] += right.cnt[i];
        }

        int p = (left.prod * right.prod) % k;

        return new Node(p, c);
    }

    class Node {
        int prod;
        int[] cnt;

        Node(int prod, int[] cnt) {
            this.prod = prod;
            this.cnt = cnt.clone();
        }
    }
}

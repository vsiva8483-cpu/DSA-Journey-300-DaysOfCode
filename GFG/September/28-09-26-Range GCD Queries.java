import java.util.*;

class Solution {

    int[] tree;

    int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    void build(int[] arr, int node, int l, int r) {
        if (l == r) {
            tree[node] = arr[l];
            return;
        }

        int mid = (l + r) / 2;

        build(arr, 2 * node, l, mid);
        build(arr, 2 * node + 1, mid + 1, r);

        tree[node] = gcd(tree[2 * node], tree[2 * node + 1]);
    }

    void update(int node, int l, int r, int index, int value) {
        if (l == r) {
            tree[node] = value;
            return;
        }

        int mid = (l + r) / 2;

        if (index <= mid)
            update(2 * node, l, mid, index, value);
        else
            update(2 * node + 1, mid + 1, r, index, value);

        tree[node] = gcd(tree[2 * node], tree[2 * node + 1]);
    }

    int query(int node, int l, int r, int ql, int qr) {
        if (qr < l || r < ql)
            return 0;

        if (ql <= l && r <= qr)
            return tree[node];

        int mid = (l + r) / 2;

        int left = query(2 * node, l, mid, ql, qr);
        int right = query(2 * node + 1, mid + 1, r, ql, qr);

        return gcd(left, right);
    }

    public ArrayList<Integer> processQueries(int[] arr, int[][] queries) {

        int n = arr.length;
        tree = new int[4 * n];

        build(arr, 1, 0, n - 1);

        ArrayList<Integer> ans = new ArrayList<>();

        for (int[] q : queries) {

            if (q[0] == 0) {
                ans.add(query(1, 0, n - 1, q[1], q[2]));
            } 
            else {
                update(1, 0, n - 1, q[1], q[2]);
            }
        }

        return ans;
    }
}

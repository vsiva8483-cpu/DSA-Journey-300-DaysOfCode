class Solution {
    public int findMax(int n, int[] a, int[] b, int[] k) {

        int[] arr = new int[n];
        for (int i = 0; i < a.length; i++) {
            arr[a[i]] += k[i];

            if (b[i] + 1 < n)
                arr[b[i] + 1] -= k[i];
        }

        int max = arr[0];

        for (int i = 1; i < n; i++) {
            arr[i] += arr[i - 1];
            max = Math.max(max, arr[i]);
        }

        return max;
    }
}

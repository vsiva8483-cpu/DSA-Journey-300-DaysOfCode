class Solution {
    public int formPyramid(int[] arr) {
        int n = arr.length, total = 0, max = 0;
        int[] l = new int[n], r = new int[n];

        for (int x : arr) total += x;

        l[0] = 1;
        for (int i = 1; i < n; i++)
            l[i] = Math.min(arr[i], l[i - 1] + 1);

        r[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--)
            r[i] = Math.min(arr[i], r[i + 1] + 1);

        for (int i = 0; i < n; i++)
            max = Math.max(max, Math.min(l[i], r[i]));

        return total - max * max;
    }
}

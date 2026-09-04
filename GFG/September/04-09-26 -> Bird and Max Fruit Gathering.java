class Solution {
    public int maxFruits(ArrayList<Integer> arr, int m) {
        int n = arr.size();

        if (m >= n) {
            int sum = 0;
            for (int fruit : arr) {
                sum += fruit;
            }
            return sum;
        }

        int sum = 0;

        for (int i = 0; i < m; i++) {
            sum += arr.get(i);
        }

        int maxSum = sum;

        for (int i = 1; i < n; i++) {
            sum -= arr.get(i - 1);
            sum += arr.get((i + m - 1) % n);
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
}

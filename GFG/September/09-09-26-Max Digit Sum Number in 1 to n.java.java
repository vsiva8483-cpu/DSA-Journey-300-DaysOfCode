class Solution {
    public int findMax(int n) {
        int ans = n;
        int max = sum(n);

        for (int p = 10; p <= n; p *= 10) {
            int x = n / p;

            if (x > 0) {
                int num = (x - 1) * p + (p - 1);
                int s = sum(num);

                if (s > max) {
                    max = s;
                    ans = num;
                }
            }
        }

        return ans;
    }

    int sum(int n) {
        int s = 0;

        while (n > 0) {
            s += n % 10;
            n /= 10;
        }

        return s;
    }
}

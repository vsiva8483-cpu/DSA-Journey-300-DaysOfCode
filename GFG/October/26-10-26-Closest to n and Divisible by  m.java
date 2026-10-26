
class Solution {
    static int closestNumber(int n, int m) {
        int d = Math.abs(m);

        int lower = Math.floorDiv(n, d) * d;
        int upper = lower + d;

        int diff1 = Math.abs(n - lower);
        int diff2 = Math.abs(n - upper);

        if (diff1 < diff2) {
            return lower;
        } else if (diff2 < diff1) {
            return upper;
        } else {
            return Math.abs(lower) > Math.abs(upper)
                    ? lower : upper;
        }
    }
}

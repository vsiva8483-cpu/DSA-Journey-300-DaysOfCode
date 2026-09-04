class Solution {
    public boolean uniformArray(int[] nums1) {
        int[] sorted = nums1.clone();
        Arrays.sort(sorted);
        return canAchieve(sorted, 0) || canAchieve(sorted, 1);
    }

    private boolean canAchieve(int[] sorted, int target) {
        int cntEven = 1, cntOdd = 0;
        for (int x : sorted) {
            int xp = x % 2;
            if (xp == target) {
            } else {
                int needed = (target + xp) % 2;
                if (needed == 0) {
                    if (cntEven == 0) return false;
                } else {
                    if (cntOdd == 0) return false;
                }
            }
            if (xp == 0) cntEven++;
            else cntOdd++;
        }
        return true;
    }
}

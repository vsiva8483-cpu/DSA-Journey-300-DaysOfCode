import java.util.*;

class Solution {
    public int dominantPairs(int[] arr) {
        int n = arr.length;
        int mid = n / 2;

        int[] first = Arrays.copyOfRange(arr, 0, mid);
        int[] second = Arrays.copyOfRange(arr, mid, n);

        Arrays.sort(first);
        Arrays.sort(second);

        int count = 0;
        int j = 0;

        for (int i = 0; i < mid; i++) {
            while (j < mid && (long) first[i] >= 5L * second[j]) {
                j++;
            }

            count += j;
        }

        return count;
    }
}

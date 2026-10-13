
import java.util.*;

class Solution {
    public ArrayList<Integer> update(int n, int[] updates) {
        int[] arr = new int[n];

        for (int i = 0; i < updates.length; i++) {
            arr[updates[i] - 1]++;
        }

        ArrayList<Integer> result = new ArrayList<>();
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
            result.add(sum);
        }

        return result;
    }
}

import java.util.Arrays;

class Solution {
    public static int countPairs(int arr[], int k) {

        Arrays.sort(arr);

        int count = 0;
        int i= 0;

        for (int j = 1; j < arr.length; j++) {

            while (arr[j] - arr[i] >= k) {
                i++;
            }

            count += (j - i);
        }

        return count;
    }
}

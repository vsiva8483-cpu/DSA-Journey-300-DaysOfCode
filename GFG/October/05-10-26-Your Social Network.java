import java.util.*;

class Solution {
    public ArrayList<ArrayList<Integer>> socialNetwork(int[] arr) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        int n = arr.length + 1;
        for (int i = 2; i <= n; i++) {

            int current = i;
            int links = 0;

            ArrayList<ArrayList<Integer>> temp = new ArrayList<>();
            while (current != 1) {

                current = arr[current - 2];
                links++;

                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(i);
                pair.add(current);
                pair.add(links);

                temp.add(pair);
            }
            for (int k = temp.size() - 1; k >= 0; k--) {
                result.add(temp.get(k));
            }
        }

        return result;
    }
}

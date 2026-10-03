
import java.util.ArrayList;

class Solution {
    public ArrayList<ArrayList<Integer>> formCoils(int n) {
        int size = 4 * n;
        int total = size * size;
        int[] coil = new int[total / 2];
        int k = 0;

        for (int ring = 0; ring < size / 2; ring++) {
            int lo = ring;
            int hi = size - 1 - ring;

            if (ring % 2 == 0) {
                // Move down the left column
                for (int r = lo; r <= hi; r++) {
                    coil[k++] = r * size + lo + 1;
                }

                // Move right along the bottom row
                for (int c = lo + 1; c < hi; c++) {
                    coil[k++] = hi * size + c + 1;
                }
            } else {
                // Move up the right column
                for (int r = hi; r >= lo; r--) {
                    coil[k++] = r * size + hi + 1;
                }

                // Move left along the top row
                for (int c = hi - 1; c > lo; c--) {
                    coil[k++] = lo * size + c + 1;
                }
            }
        }

        ArrayList<Integer> first = new ArrayList<>();
        ArrayList<Integer> second = new ArrayList<>();

        for (int v : coil) {
            first.add(v);
            second.add(total + 1 - v);
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        result.add(first);
        result.add(second);

        return result;
    }
}

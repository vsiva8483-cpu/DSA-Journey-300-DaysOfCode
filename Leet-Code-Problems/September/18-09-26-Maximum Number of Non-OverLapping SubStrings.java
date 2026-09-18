import java.util.*;

class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];

        Arrays.fill(first, -1);

        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            if (first[c] == -1) first[c] = i;
            last[c] = i;
        }

        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';

            if (first[c] != i) continue;

            int end = last[c];
            boolean ok = true;

            for (int j = i; j <= end; j++) {
                int x = s.charAt(j) - 'a';

                if (first[x] < i) {
                    ok = false;
                    break;
                }

                end = Math.max(end, last[x]);
            }

            if (ok) list.add(new int[]{i, end});
        }

        list.sort((a, b) -> a[1] - b[1]);

        List<String> ans = new ArrayList<>();
        int prev = -1;

        for (int[] x : list) {
            if (x[0] > prev) {
                ans.add(s.substring(x[0], x[1] + 1));
                prev = x[1];
            }
        }

        return ans;
    }
}

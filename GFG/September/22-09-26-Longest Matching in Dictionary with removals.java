class Solution {
    public String findLongestWord(String s, List<String> d) {
        int n = s.length();
        int[][] next = new int[n + 1][26];

        for (int c = 0; c < 26; c++)
            next[n][c] = -1;

        for (int i = n - 1; i >= 0; i--) {
            for (int c = 0; c < 26; c++)
                next[i][c] = next[i + 1][c];
            next[i][s.charAt(i) - 'a'] = i;
        }

        String ans = "";

        for (String w : d) {
            int pos = 0;
            boolean ok = true;

            for (char ch : w.toCharArray()) {
                if (pos > n - 1 || next[pos][ch - 'a'] == -1) {
                    ok = false;
                    break;
                }
                pos = next[pos][ch - 'a'] + 1;
            }

            if (ok && (w.length() > ans.length() ||
                    (w.length() == ans.length() && w.compareTo(ans) < 0))) {
                ans = w;
            }
        }

        return ans;
    }
}

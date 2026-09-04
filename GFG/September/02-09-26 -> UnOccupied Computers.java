class Solution {
    public int solve(int n, String s) {
        boolean[] present = new boolean[26];
        boolean[] usingComputer = new boolean[26];

        int occupied = 0;
        int rejected = 0;

        for (int i = 0; i < s.length(); i++) {
            int customer = s.charAt(i) - 'A';

            if (!present[customer]) {
                present[customer] = true;

                if (occupied < n) {
                    occupied++;
                    usingComputer[customer] = true;
                } else {
                    rejected++;
                }
            } else {
                present[customer] = false;

                if (usingComputer[customer]) {
                    occupied--;
                    usingComputer[customer] = false;
                }
            }
        }

        return rejected;
    }
}

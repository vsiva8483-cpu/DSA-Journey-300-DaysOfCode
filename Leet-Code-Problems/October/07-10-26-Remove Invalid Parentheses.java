class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        Set<String> set = new HashSet<>();
        q.add(s);
        set.add(s);

        boolean found = false;

        while (!q.isEmpty()) {
            String cur = q.poll();

            if (valid(cur)) {
                ans.add(cur);
                found = true;
            }

            if (found) continue;

            for (int i = 0; i < cur.length(); i++) {
                if (cur.charAt(i) != '(' && cur.charAt(i) != ')') continue;

                String next = cur.substring(0, i) + cur.substring(i + 1);

                if (set.add(next))
                    q.add(next);
            }
        }
        return ans;
    }

    boolean valid(String s) {
        int count = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') count++;
            else if (c == ')' && --count < 0) return false;
        }

        return count == 0;
    }
}

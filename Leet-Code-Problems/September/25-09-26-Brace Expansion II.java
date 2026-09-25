import java.util.*;

class Solution {
    public List<String> braceExpansionII(String s) {
        return new ArrayList<>(new TreeSet<>(f(s)));
    }

    Set<String> f(String s) {
        Set<String> res = new HashSet<>(), cur = new HashSet<>();
        cur.add("");

        for (int i = 0; i < s.length();) {
            if (s.charAt(i) == ',') {
                res.addAll(cur);
                cur = new HashSet<>();
                cur.add("");
                i++;
            } else if (s.charAt(i) == '{') {
                int j = i, c = 0;
                do {
                    if (s.charAt(j) == '{') c++;
                    if (s.charAt(j) == '}') c--;
                    j++;
                } while (c > 0);

                cur = join(cur, f(s.substring(i + 1, j - 1)));
                i = j;
            } else {
                cur = join(cur, Set.of("" + s.charAt(i++)));
            }
        }

        res.addAll(cur);
        return res;
    }

    Set<String> join(Set<String> a, Set<String> b) {
        Set<String> r = new HashSet<>();
        for (String x : a)
            for (String y : b)
                r.add(x + y);
        return r;
    }
}

class Solution {
    public int compress(char[] chars) {
        int i = 0, idx = 0;

        while (i < chars.length) {
            char ch = chars[i];
            int count = 0;

            while (i < chars.length && chars[i] == ch) {
                count++;
                i++;
            }

            chars[idx++] = ch;

            if (count > 1) {
                String s = String.valueOf(count);
                for (char c : s.toCharArray()) {
                    chars[idx++] = c;
                }
            }
        }

        return idx;
    }
}

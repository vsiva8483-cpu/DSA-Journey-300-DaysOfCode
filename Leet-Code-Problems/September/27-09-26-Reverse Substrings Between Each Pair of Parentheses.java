class Solution {
    public String reverseParentheses(String s) {
        StringBuilder st = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == ')') {
                StringBuilder temp = new StringBuilder();

                while (st.charAt(st.length() - 1) != '(') {
                    temp.append(st.charAt(st.length() - 1));
                    st.deleteCharAt(st.length() - 1);
                }

                st.deleteCharAt(st.length() - 1);
                st.append(temp);
            } else {
                st.append(c);
            }
        }

        return st.toString();
    }
}

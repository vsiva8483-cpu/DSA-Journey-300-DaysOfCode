  class Solution {
    public String processStr(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                sb.append(ch);
            }
            else if (ch == '*') {
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
            else if (ch == '#') {
                String curr = sb.toString();
                sb.append(curr);
            }
            else if (ch == '%') {
                sb.reverse();
            }
        }

        return sb.toString();

            
    }
}
    

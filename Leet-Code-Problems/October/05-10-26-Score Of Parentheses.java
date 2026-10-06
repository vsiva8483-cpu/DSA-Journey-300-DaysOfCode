import java.util.*;

class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (char c : s.toCharArray()) {

            if (c == '(') {
                stack.push(0);
            } else {
                int inside = stack.pop();
                int score;

                if (inside == 0) {
                    score = 1;
                } else {
                    score = 2 * inside;
                }

                stack.push(stack.pop() + score);
            }
        }

        return stack.pop();
    }
}

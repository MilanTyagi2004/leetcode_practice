import java.util.Stack;

class Solution {
    public static boolean handlesituation(Stack<Character> st, char corsoch) {
        if (st.isEmpty()) {
            return false;
        } else if (st.peek() != corsoch) {
            return false;
        } else {
            st.pop();
            return true;
        }
    }

    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else if (ch == ')') {
                if (!handlesituation(st, '(')) {
                    return false;
                }
            } else if (ch == '}') {
                if (!handlesituation(st, '{')) {
                    return false;
                }
            } else if (ch == ']') {
                if (!handlesituation(st, '[')) {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("(){}[]"));  // Example usage
    }
}

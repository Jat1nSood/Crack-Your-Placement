class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> st = new Stack<>();
        int n = s.length();
        // if(n == 1) return false;

        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '[')
                st.push(ch);
            else{
                if(st.isEmpty()) return false;
                else if(ch == ')' && st.peek() == '(') st.pop();
                else if(ch == ']' && st.peek() == '[') st.pop();
                else if(ch == '}' && st.peek() == '{') st.pop();
                else return false;
            }
        }
        if(st.isEmpty()) return true;
        return false;
    }
}
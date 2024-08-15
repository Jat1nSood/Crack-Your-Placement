class Solution {
    public int calculate(String s) {
        
        Stack<Integer> st = new Stack<>();
        int number = 0;
        char sign = '+';

        for(int i = 0; i < s.length(); i++){

            char ch = s.charAt(i);

            if(Character.isDigit(ch)){
                number = (number * 10) + (ch - '0');
            }
            if(!Character.isDigit(ch) && ch != ' ' || i == s.length() - 1){

                if(sign == '+'){
                    st.add(number);
                }
                else if(sign == '-'){
                    number = -1 * number;
                    st.add(number);
                }
                else if(sign == '*'){
                    number = (number * st.pop());
                    st.add(number);
                }
                else if(sign == '/'){
                    number = st.pop() /number ;
                    st.add(number);
                }
                number =0;
                sign = ch;
            } 
        }

        while(!st.isEmpty()){
            number += st.pop();
        }
        return number;
    }
}
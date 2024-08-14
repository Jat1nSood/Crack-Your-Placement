class Solution {
    public int calculate(String s) {
        
        char[] chars = s.toCharArray();
        int n = chars.length;
        Stack<Integer> st = new Stack<>();

        int number = 0;
        int result = 0;
        int sign = 1;

        for(int i = 0; i < n; i++){
            
            if('0' <= chars[i] && chars[i] <= '9'){

                number = (number * 10 ) + (chars[i] - '0');
            }
            else if(chars[i] == '+'){
                result = result + (number * sign);
                number = 0;
                sign = 1;
            }
            else if(chars[i] == '-' ){
                result = result + (number * sign);
                number = 0;
                sign = -1;
            }
            else if(chars[i] == '('){
                result = result + (number * sign);
                st.push(result);
                st.push(sign);

                result = 0;
                sign = 1;
                number = 0;
            }
            else if(chars[i] == ')'){

                result = result + (number * sign);
                number = 0;
                sign = 1;

                int stack_sign = st.pop();
                int stack_result = st.pop();

                result *= stack_sign;
                result += stack_result;
            }
        }

        result += (number * sign);
        return result;
    }
}
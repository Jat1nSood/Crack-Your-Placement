class Solution {
    String removeDuplicates(String s) {
        
        int n = s.length();
        Set<Character> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(set.contains(ch)) continue;
            sb.append(ch);
            set.add(ch);
        }
        
        return sb.toString();
    }
}

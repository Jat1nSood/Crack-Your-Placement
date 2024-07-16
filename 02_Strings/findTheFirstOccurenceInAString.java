lass Solution {
    
    // O(l)
    private boolean check(String text, String pat){
        
        int n = text.length();
        int m  = pat.length();
        int i = 0;
        int j = 0;
        
        while(i < n && j < m){
            
            if(text.charAt(i) != pat.charAt(j)) return false;
            i++;
            j++;
        }
        
        if(j == m) return true;
        return false;
    }
    
    public int strStr(String text, String pat) {
        // Code here
        int n = text.length();
        // O(n)
        for(int i = 0; i < n; i++){
            char ch = text.charAt(i);
            if(ch == pat.charAt(0)){
                if(check(text.substring(i, n), pat)){
                    return i;
                }
            }
        }
        return -1;
    }
}

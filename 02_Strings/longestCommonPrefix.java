class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        String prefix = strs[0];
        int n = strs.length;

        for(int i = 0; i < n; i++){
            String current = strs[i];
            int len = Math.min(prefix.length(), current.length());
            int j = 0;
            String newS = "";
            while(j < len){
                if(prefix.charAt(j) != current.charAt(j)) break;
                newS = newS + prefix.charAt(j);
                j++;
            }
            if(newS == "") return newS;
            else prefix = newS;
        }
        return prefix;
    }
}
class TrieNode{
    TrieNode[] children = new TrieNode[26];
    boolean isEnd = false;
}

class WordDictionary {

    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        
        TrieNode curr =  root;
        int i = 0;
        while(i < word.length()){
            char ch = word.charAt(i);
            if(curr.children[ch - 'a'] == null){
                curr.children[ch - 'a'] = new TrieNode();
            }
            curr = curr.children[ch - 'a'];
            i++;
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {

        return searchInNode(word, root);
    
    }

    public boolean searchInNode(String word, TrieNode node){

        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(ch == '.'){
                for(TrieNode child : node.children){
                    if(child != null && searchInNode(word.substring(i + 1, word.length()), child)) return true;
                }
                return false;
            }
            else{
                if(node.children[ch - 'a'] == null) return false;
                node = node.children[ch - 'a'];
            }
        }
        return node.isEnd;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
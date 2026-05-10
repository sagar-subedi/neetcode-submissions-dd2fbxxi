class WordDictionary {

    public class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public boolean isEnd;
    }

    TrieNode root;
    public WordDictionary() {
        this.root = new  TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;

        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            int index = c - 'a';
            if(node.children[index] == null) {
                node.children[index] =  new TrieNode();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode node = findNode(word,root);
        return node!=null && node.isEnd;
    }

    public TrieNode findNode(String word, TrieNode node){

        if(node == null) { return null;}

        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(c=='.') {
                for (int j = 0; j < 26; j++){
                    TrieNode node2 = node.children[j];
                    if(node2!=null){

                      TrieNode result =  findNode(word.substring(i+1), node2);
                      if( result!=null) return result;
                    }
                }
                return null;
            }else {
                int index = c - 'a';
                if ( node.children[index] == null) {
                    return null;
                }
                node = node.children[index];
            }
        }
        return node;

    }
}

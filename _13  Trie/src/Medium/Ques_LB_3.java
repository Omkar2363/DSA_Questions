package Medium;

public class Ques_LB_3 {

    //Ques : Word Break Problem | (Trie solution)............                                 (GFG Ques.)


    //Approach 1 :
    // A DP and Trie based program to test whether a given string can be segmented into
    // space separated words in dictionary
    class GFG {
        static final int ALPHABET_SIZE = 26;

        // trie node
        static class TrieNode {
            TrieNode children[];

            // isEndOfWord is true if the node represents end of a word
            boolean isEndOfWord;

            // Constructor of TrieNode
            TrieNode()
            {
                children = new TrieNode[ALPHABET_SIZE];
                for (int i = 0; i < ALPHABET_SIZE; i++)
                    children[i] = null;

                isEndOfWord = false;
            }
        }

        // If not present, inserts key into trie,
        // If the key is prefix of trie node, just marks leaf node
        static void insert(TrieNode root, String key)
        {
            TrieNode pCrawl = root;

            for (int i = 0; i < key.length(); i++)
            {
                int index = key.charAt(i) - 'a';
                if (pCrawl.children[index] == null)
                    pCrawl.children[index] = new TrieNode();

                pCrawl = pCrawl.children[index];
            }

            // Mark last node as leaf
            pCrawl.isEndOfWord = true;
        }

        // Returns true if key presents in trie, else false
        static boolean search(TrieNode root, String key)
        {
            TrieNode pCrawl = root;

            for (int i = 0; i < key.length(); i++) {
                int index = key.charAt(i) - 'a';
                if (pCrawl.children[index] == null)
                    return false;

                pCrawl = pCrawl.children[index];
            }
            return (pCrawl != null && pCrawl.isEndOfWord);
        }

        // Returns true if string can be segmented into space separated words, otherwise returns false
        static boolean wordBreak(String str, TrieNode root)
        {
            int size = str.length();

            // Base case
            if (size == 0)
                return true;

            // Try all prefixes of lengths from 1 to size
            for (int i = 1; i <= size; i++) {

                // The parameter for search is
                // str.substring(0, i)
                // str.substring(0, i) which is prefix (of input string) of length 'i'.
                // We first check whether current prefix is in dictionary.
                // Then we recursively check for remaining string str.substr(i, size) which
                // is suffix of length size-i.

                if (search(root, str.substring(0, i))
                        && wordBreak(str.substring(i, size), root))
                    return true;
            }

            // If we have tried all prefixes and none of them worked
            return false;
        }

        // Driver code
        public static void main_1(String[] args)
        {
            String dictionary[] = { "mobile", "samsung",  "sam",  "sung", "ma", "mango",  "icecream", "and",
                                    "go",   "i", "like",   "ice",      "cream" };

            int n = dictionary.length;
            TrieNode root = new TrieNode();

            // Construct trie
            for (int i = 0; i < n; i++)
                insert(root, dictionary[i]);

            System.out.print(wordBreak("ilikesamsung", root)  ?  "Yes\n"  :  "No\n");
            System.out.print(wordBreak("iiiiiiii", root)      ?  "Yes\n"  :  "No\n");
            System.out.print(wordBreak("", root)              ?  "Yes\n"  :  "No\n");
            System.out.print(wordBreak("ilikelikeimangoiii", root) ? "Yes\n"  : "No\n");
            System.out.print(wordBreak("samsungandmango", root) ? "Yes\n" : "No\n");
            System.out.print(wordBreak("samsungandmangok", root)? "Yes\n" : "No\n");

        }

    }




    public static void main(String[] args) {

        /*Ques : Given an input string and a dictionary of words, find out if the input string can be
                 segmented into a space-separated sequence of dictionary words.
                 See following examples for more details.

            This is a famous Google interview question, also being asked by many other companies now a days.

            * Consider the following dictionary
              { i, like, sam, sung, samsung, mobile, ice, cream, icecream, man, go, mango }


            Example : 1
            Input   :  ilike
            Output  : Yes
            Explanation : The string can be segmented as "i like".


            Example : 2
            Input   :  ilikesamsung
            Output  : Yes
            Explanation : The string can be segmented as "i like samsung" or "i like sam sung".
        *
        *
        * */
    }




}

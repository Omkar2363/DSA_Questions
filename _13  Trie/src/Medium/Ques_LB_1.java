package Medium;

public class Ques_LB_1 {

    //Ques : Trie | (Insert and Search)..............                                    (GFG Ques.)


    //Structure of Trie Node......
    // Trie node
    /*
    class TrieNode
    {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        // isEndOfWord is true if the node
        // represents end of a word
        boolean isEndOfWord;
    }
    */


    // Java implementation of search and insert operations on Trie
    public class Trie {

        // Alphabet size (# of symbols)
        static final int ALPHABET_SIZE = 26;

        // trie node
        static class TrieNode
        {
            TrieNode[] children = new TrieNode[ALPHABET_SIZE];

            // isEndOfWord is true if the node represents end of a word
            boolean isEndOfWord;

            TrieNode(){
                isEndOfWord = false;
                for (int i = 0; i < ALPHABET_SIZE; i++)
                    children[i] = null;
            }
        };

        static TrieNode root;

        // If not present, inserts key into trie
        // If the key is prefix of trie node, just marks leaf node
        static void insert(String key)
        {
            int level;
            int length = key.length();
            int index;

            TrieNode pCrawl = root;

            for (level = 0; level < length; level++)
            {
                index = key.charAt(level) - 'a';
                if (pCrawl.children[index] == null)
                    pCrawl.children[index] = new TrieNode();

                pCrawl = pCrawl.children[index];
            }

            // mark last node as leaf
            pCrawl.isEndOfWord = true;
        }

        // Returns true if key presents in trie, else false
        static boolean search(String key)
        {
            int level;
            int length = key.length();
            int index;
            TrieNode pCrawl = root;

            for (level = 0; level < length; level++)
            {
                index = key.charAt(level) - 'a';

                if (pCrawl.children[index] == null)
                    return false;

                pCrawl = pCrawl.children[index];
            }

            return (pCrawl.isEndOfWord);
        }

        // Driver
        public static void main_1(String args[])
        {
            // Input keys (use only 'a' through 'z' and lower case)
            String keys[] = {"the", "a", "there", "answer", "any", "by", "bye", "their"};

            String output[] = {"Not present in trie", "Present in trie"};


            root = new TrieNode();

            // Construct trie
            int i;
            for (i = 0; i < keys.length ; i++)
                insert(keys[i]);

            // Search for different keys
            if(search("the") == true)
                System.out.println("the --- " + output[1]);
            else
                System.out.println("the --- " + output[0]);

            if(search("these") == true)
                System.out.println("these --- " + output[1]);
            else
                System.out.println("these --- " + output[0]);

            if(search("their") == true)
                System.out.println("their --- " + output[1]);
            else
                System.out.println("their --- " + output[0]);

            if(search("thaw") == true)
                System.out.println("thaw --- " + output[1]);
            else
                System.out.println("thaw --- " + output[0]);

        }
    }




    public static void main(String[] args) {

        /*Ques : What is Trie ?
                  Trie is a type of k-ary search tree used for storing and searching a specific key from a set.
                  Using Trie, search complexities can be brought to optimal limit (key length).

                If we store keys in a binary search tree, a well balanced BST will need time proportional to M * log N,
                where M is the maximum string length and N is the number of keys in the tree.
                Using Trie, the key can be searched in O(M) time. However, the penalty is on Trie storage requirements
                (Please refer to Applications of Trie for more details).

                Trie is also known as digital tree or prefix tree. Refer to this article for more detailed information.

                Trie data structure
                Trie data structure

                Structure of Trie node :
                Every node of Trie consists of multiple branches. Each branch represents a possible character of keys.
                Mark the last node of every key as the end of the word node. A Trie node field isEndOfWord is used to
                distinguish the node as the end of the word node.


                A simple structure to represent nodes of the English alphabet can be as follows.


        *
                // Follow the link for Visual Representation of the Example....
                // Link : https://www.geeksforgeeks.org/trie-insert-and-search/
        *
        *
        * */



    }




}

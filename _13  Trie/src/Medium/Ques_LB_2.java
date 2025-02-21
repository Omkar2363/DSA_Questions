package Medium;

public class Ques_LB_2 {

    //Ques : Find shortest unique prefix for every word in a given list..........               (GFG Ques.)


    //Approach 1 : Simple Solution........
    /*  A Simple Solution is to consider every prefix of every word (starting from the shortest to largest),
        and if a prefix is not prefix of any other string, then print it.
    *
    * */


    //Approach 2 : Efficient Solution.........                                                 T.C. = O(n),  S.C. = O(n)
    /*  An Efficient Solution is to use Trie. The idea is to maintain a count in every node. Below are steps.
            1) Construct a Trie of all words. Also maintain frequency of every node (Here frequency is number of times node is visited during insertion). Time complexity of this step is O(N) where N is total number of characters in all words.
            2) Now, for every word, we find the character nearest to the root with frequency as 1. The prefix of the word is path from root to this character. To do this, we can traverse Trie starting from root. For every node being traversed, we check its frequency. If frequency is one, we print all characters from root to this node and don’t traverse down this node.

        Time complexity if this step also is O(N) where N is total number of characters in all words.


                        root
                        / \
                 (d, 3)/   \(z, 1)
                      /     \
                  Node1     Node2
                   / \          \
             (o,2)/   \(u,1)     \(e,1)
                 /     \          \
           Node1.1    Node1.2     Node2.1
              /  \         \            \
        (g,1)/    \ (t,1)   \(c,1)       \(b,1)
            /      \         \            \
          Leaf    Leaf       Node1.2.1     Node2.1.1
          dog)    (dot)        \               \
                                \(k, 1)         \(r, 1)
                                 \               \
                                 Leaf           Node2.1.1.1
                                (duck)              \
                                                     \(a,1)
                                                      \
                                                      Leaf
                                                     (zebra)

    *
    * */
    // Java program to print all prefixes that uniquely represent words.
    public class Unique_Prefix_Trie {
        static final int MAX  = 256;

        // Maximum length of an input word
        static final int MAX_WORD_LEN = 500;

        // Trie Node.
        static class TrieNode
        {
            TrieNode[] child = new TrieNode[MAX];
            int freq;                                   // To store frequency
            TrieNode()
            {
                freq =1;
                for (int i = 0; i < MAX; i++)
                    child[i] = null;
            }
        }
        static TrieNode root;

        // Method to insert a new string into Trie
        static void insert(String str)
        {
            // Length of the URL
            int len = str.length();
            TrieNode pCrawl = root;

            // Traversing over the length of given str.
            for (int level = 0; level<len; level++)
            {
                // Get index of child node from current character in str.
                int index = str.charAt(level);

                // Create a new child if not exist already
                if (pCrawl.child[index] == null)
                    pCrawl.child[index] = new TrieNode();
                else
                    (pCrawl.child[index].freq)++;

                // Move to the child
                pCrawl = pCrawl.child[index];
            }
        }

        // This function prints unique prefix for every word stored in Trie.
        // Prefixes one by one are stored in prefix[]. 'ind' is current index of prefix[]
        static void findPrefixesUtil(TrieNode root, char[] prefix, int ind)
        {
            // Corner case
            if (root == null)
                return;

            // Base case
            if (root.freq == 1)
            {
                prefix[ind] = '\0';
                int i = 0;
                while(prefix[i] != '\0')
                    System.out.print(prefix[i++]);
                System.out.print("  ");
                return;
            }

            for (int i=0; i<MAX; i++)
            {
                if (root.child[i] != null)
                {
                    prefix[ind] = (char) i;
                    findPrefixesUtil(root.child[i], prefix, ind+1);
                }
            }
        }

        // Function to print all prefixes that uniquely represent all words in arr[0...n-1]
        static void findPrefixes(String arr[], int n)
        {
            // Construct a Trie of all words
            root = new TrieNode();
            root.freq = 0;
            for (int i = 0; i<n; i++)
                insert(arr[i]);

            // Create an array to store all prefixes
            char[] prefix = new char[MAX_WORD_LEN];

            // Print all prefixes using Trie Traversal
            findPrefixesUtil(root, prefix, 0);
        }

        // Driver function.
        public static void main_2(String args[])
        {
            String arr[] = {"zebra", "dog", "duck", "dove"};
            int n = arr.length;
            findPrefixes(arr, n);
        }
    }









    public static void main(String[] args) {

        /*Ques : Given an array of words, find all shortest unique prefixes to represent each word in the given array.
                 Assume that no word is prefix of another.

            Example : 1
            Input   : arr[] = {"zebra", "dog", "duck", "dove"}
            Output  : dog, dov, du, z
            Explanation : dog   => dog
                          dove  => dov
                          duck  => du
                          zebra => z

            Example : 2
            Input   : arr[] =  {"geeksgeeks", "geeksquiz", "geeksforgeeks"};
            Output  : geeksf, geeksg, geeksq}

        *
        * */

    }





}

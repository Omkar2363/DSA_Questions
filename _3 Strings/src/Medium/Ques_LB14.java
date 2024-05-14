package Medium;

import java.util.LinkedList;
import java.util.Arrays;

public class Ques_LB14 {

    //Ques : Print Anagrams Together.......                                                   (GFG Ques.)
    //       (Print all groups of strings that are anagrams)
                                                                //  Related ques :
                                                                //  Group anagrams leet code ques no - Medium / Ques_3  of same package


    //Approach 1 : By making and using Tri........
    /*  Time Complexity : O(MN + N*Mlog(M)) time where -
                                                     N = Number of strings
                                                     M = Length of the largest string
                          Inserting all the words in the trie takes O(MN) time
                          and sorting the buffer takes O(N * Mlog(M)) time

        Auxiliary Space : O(26*M*N) ~ O(MN)
                          To store all the strings we need to allocate O(26*M*N) ~ O(MN) space for the Trie.

    * */
    public class GFG_1 {
        static final int NO_OF_CHARS = 26;

        // Class to represent a Trie Node
        static class TrieNode {
            boolean isEnd;                      // indicates end of word

            // 26 slots each for 'a' to 'z'
            TrieNode[] child = new TrieNode[NO_OF_CHARS];

            // head of the index list
            LinkedList<Integer> head;

            // constructor
            public TrieNode()
            {
                isEnd = false;
                head = new LinkedList<>();
                for (int i = 0; i < NO_OF_CHARS; ++i)
                    child[i] = null;
            }
        }

        // A utility function to insert a word to Trie
        static TrieNode insert(TrieNode root,String word, int index, int i)
        {
            // Base case
            if (root == null)
            {
                root = new TrieNode();
            }
            if (i < word.length() )
            {
                int index1 = word.charAt(i) - 'a';
                root.child[index1] = insert(root.child[index1], word, index, i+1 );
            }
            else                        // If end of the word reached
            {
                // Insert index of this word to the end of  index of inked list
                if (root.isEnd == true)
                {
                    root.head.add(index);
                }
                else                 // If Index list is empty
                {
                    root.isEnd = true;
                    root.head.add(index);
                }
            }
            return root;
        }

        /*
         This function traverses the built trie. When a leaf node is reached,
         all words connected at that leaf node are anagrams.
         So it traverses the list at leaf node and uses stored index to print original words
        */
        static void printAnagramsUtil(TrieNode root, String wordArr[])
        {
            if (root == null)
                return;

            // If a lead node is reached, print all anagrams
            // using the indexes stored in index of linked list
            if (root.isEnd)
            {
                // traverse the list
                for(Integer pCrawl: root.head)
                    System.out.println(wordArr[pCrawl]);
            }

            for (int i = 0; i < NO_OF_CHARS; ++i)
                printAnagramsUtil(root.child[i], wordArr);
        }

        // The main function that prints all anagrams together.
        // wordArr[] is input sequence of words.
        static void printAnagramsTogether(String wordArr[], int size)
        {
            // Create an empty Trie
            TrieNode root = null;

            // Iterate through all input words
            for (int i = 0; i < size; ++i)
            {
                // Create a buffer for this word and copy the word to buffer
                char[] buffer = wordArr[i].toCharArray();

                // Sort the buffer
                Arrays.sort(buffer);

                // Insert the sorted buffer and its original index to Trie
                root = insert(root, new String(buffer), i, 0);

            }

            // Traverse the built Trie and print all anagrams together
            printAnagramsUtil(root, wordArr);
        }

        // Driver program to test above functions
        public static void main_1(String args[])
        {
            String wordArr[] = {"cat", "dog", "tac", "god",
                    "act", "gdo"};
            int size = wordArr.length;
            printAnagramsTogether(wordArr, size);
        }
    }



    //Approach 2 : By using STL.....
    //In C++ :
    /*  // C++ program for finding all anagram
        // pairs in the given array
        #include <algorithm>
        #include <iostream>
        #include <unordered_map>
        #include <vector>
        using namespace std;

        // Utility function for
        // printing anagram list
        void printAnagram(unordered_map<string,vector<string> >& store)
        {
            for (auto it:store)
            {
                vector<string> temp_vec(it.second);
                int size = temp_vec.size();

                for (int i = 0; i < size; i++)
                cout << temp_vec[i] << " ";

                cout << "\n";
            }
        }

        // Utility function for storing
        // the vector of strings into HashMap
        void storeInMap(vector<string>& vec)
        {
            unordered_map<string,vector<string> > store;

            for (int i = 0; i < vec.size(); i++)
            {
                string tempString(vec[i]);

                  // sort the string
                sort(tempString.begin(),tempString.end());

                  // make hash of a sorted string
                store[tempString].push_back(vec[i]);
            }

            // print utility function for printing
            // all the anagrams
            printAnagram(store);
        }

        // Driver code
        int main()
        {
            // initialize vector of strings
            vector<string> arr;
            arr.push_back("geeksquiz");
            arr.push_back("geeksforgeeks");
            arr.push_back("abcd");
            arr.push_back("forgeeksgeeks");
            arr.push_back("zuiqkeegs");
            arr.push_back("cat");
            arr.push_back("act");
            arr.push_back("tca");

            // utility function for storing
            // strings into hashmap
            storeInMap(arr);
            return 0;
        }
    *
    * */

    //In Java :
    /*Do it again.....
    * */




    public static void main(String[] args) {

        /*Ques : Given an array of strings, return all groups of strings that are anagrams.
                 The groups must be created in order of their appearance in the original array.
                 Look at the sample case for clarification.

                 Note : The final output will be in lexicographic order.


            Example : 1
            Input   : N = 5
                      words[] = {act,god,cat,dog,tac}
            Output  : act cat tac god dog
            Explanation : There are 2 groups of anagrams - "god", "dog"            make group 1.
                                                         - "act", "cat", "tac"     make group 2.

            Example : 2
            Input   : N = 3
                      words[] = {no,on,is}
            Output  : is no on
            Explanation : There are 2 groups of anagrams - "is"                   makes group 1.
                                                         - "no", "on"              make group 2.

            Your Task :
            The task is to complete the function Anagrams() that takes a list of strings as input
            and returns a list of groups such that each group consists of all the strings that are anagrams.


            Expected Time Complexity  : O(N*|S|*log|S|),   where |S| is the length of the strings.
            Expected Auxiliary Space  : O(N*|S|),          where |S| is the length of the strings.
        *
        * */
    }


}

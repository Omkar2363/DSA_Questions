package Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class Ques_LB_5 {

    //Ques : Implement Phone Directory............                                          (GFG Ques.)


    //Approach 1 : Author's  Solution......
    class Solution {
        static ArrayList<ArrayList<String>> displayContacts(int n, String contact[], String s)
        {
            // code here
            trie root = new trie();
            build(contact,root);
            ArrayList<ArrayList<String>> A = new ArrayList<>();

            for(int i = 1; i <= s.length(); i++)
            {
                ArrayList<String> ar = new ArrayList<>();
                find(s.substring(0, i), root, ar, contact);
                Collections.sort(ar);
                A.add(ar);
            }
            return A;
        }
        public static void build(String a[], trie root)
        {
            trie temp = null;
            for(int i = 0; i < a.length; i++)
            {
                temp = root;
                for(int j = 0; j < a[i].length(); j++)
                {
                    if(temp.ch[a[i].charAt(j)-'a'] == null)
                        temp.ch[a[i].charAt(j)-'a'] = new trie();

                    temp = temp.ch[a[i].charAt(j)-'a'];
                    temp.arr.add(a[i]);
                }
            }
        }
        public static void find(String s, trie root, ArrayList<String> ar, String contact[])
        {
            int q = 0;
            for(int i = 0; i < s.length(); i++)
            {
                if(root.ch[s.charAt(i)-'a'] == null)
                {
                    q = 1;
                    break;
                }
                root = root.ch[s.charAt(i)-'a'];
            }
            if(q == 1)
            {
                ar.add("0");
            }else
                for(String i:root.arr)
                {
                    ar.add(i);
                }
        }
        public static class trie
        {
            HashSet<String> arr;
            trie ch[];
            public trie()
            {
                arr = new HashSet<>();
                ch = new trie[26];
                for(int i = 0; i < 26; i++)
                {
                    ch[i] = null;
                }
            }
        }
    }




    //Approach 2 :
    // Java Program to Implement a Phone Directory Using Trie Data Structure
    static class TrieNode {

        // Each Trie Node contains a Map 'child' where each alphabet points to a Trie Node.
        HashMap<Character,TrieNode> child;

        // 'isLast' is true if the node represents end of a contact
        boolean isLast;

        // Default Constructor
        public TrieNode()
        {
            child = new HashMap<Character,TrieNode>();

            // Initialize all the Trie nodes with NULL
            for (char i = 'a'; i <= 'z'; i++)
                child.put(i,null);

            isLast = false;
        }
    }

    static class Trie
    {
        TrieNode root;

        // Insert all the Contacts into the Trie
        public void insertIntoTrie(String contacts[])
        {
            root = new TrieNode();
            int n = contacts.length;
            for (int i = 0; i < n; i++)
            {
                insert(contacts[i]);
            }
        }

        // Insert a Contact into the Trie
        public void insert(String s)
        {
            int len = s.length();

            // 'itr' is used to iterate the Trie Nodes
            TrieNode itr = root;
            for (int i = 0; i < len; i++)
            {
                // Check if the s[i] is already present in Trie
                TrieNode nextNode = itr.child.get(s.charAt(i));
                if (nextNode == null)
                {
                    // If not found then create a new TrieNode
                    nextNode = new TrieNode();

                    // Insert into the HashMap
                    itr.child.put(s.charAt(i),nextNode);
                }

                // Move the iterator('itr') ,to point to next Trie Node
                itr = nextNode;

                // If it is the last character of the string 's' then mark 'isLast' as true
                if (i == len - 1)
                    itr.isLast = true;
            }
        }

        // This function simply displays all dictionary words going through current node.
        // String 'prefix' represents string corresponding to the path from root to curNode.
        public void displayContactsUtil(TrieNode curNode, String prefix)
        {

            // Check if the string 'prefix' ends at this Node,
            // If yes then display the string found so far
            if (curNode.isLast)
                System.out.println(prefix);

            // Find all the adjacent Nodes to the current Node and then call the function recursively
            // This is similar to performing DFS on a graph.
            for (char i = 'a'; i <= 'z'; i++)
            {
                TrieNode nextNode = curNode.child.get(i);
                if (nextNode != null)
                {
                    displayContactsUtil(nextNode, prefix + i);
                }
            }
        }

        // Display suggestions after every character enter by the user for a given string 'str'
        void displayContacts(String str)
        {
            TrieNode prevNode = root;

            // 'flag' denotes whether the string entered so far is present in the Contact List

            String prefix = "";
            int len = str.length();

            // Display the contact List for string formed after entering every character
            int i;
            for (i = 0; i < len; i++)
            {
                // 'str' stores the string entered so far
                prefix += str.charAt(i);

                // Get the last character entered
                char lastChar = prefix.charAt(i);

                // Find the Node corresponding to the last character of 'str'
                // which is pointed by prevNode of the Trie
                TrieNode curNode = prevNode.child.get(lastChar);

                // If nothing found, then break the loop as no more prefixes are going to be present.
                if (curNode == null)
                {
                    System.out.println("nNo Results Found for "   + prefix + " ");
                i++;
                break;
            }

            // If present in trie then display all the contacts with given prefix.
            System.out.println("nSuggestions based on " + prefix + " are");
            displayContactsUtil(curNode, prefix);

            // Change prevNode for next prefix
            prevNode = curNode;
        }

        for ( ; i < len; i++)
        {
            prefix += str.charAt(i);
            System.out.println("nNo Results Found for " + prefix + "");
                }
            }
        }

        // Driver code
        class Main
        {
            public static void main_2(String args[])
            {
                Trie trie = new Trie();

                String contacts [] = {"gforgeeks", "geeksquiz"};

                trie.insertIntoTrie(contacts);

                String query = "gekk";

                // Note that the user will enter 'g' then 'e' so first display
                // all the strings with prefix as 'g' and then all the strings with prefix as 'ge'
                trie.displayContacts(query);
            }
        }










    public static void main(String[] args) {

        /*Ques : Given a list of contacts contact[] of length n where each contact is a string which exist in
                 a phone directory and a query string s. The task is to implement a search query for
                 the phone directory. Run a search query for each prefix p of the query string s
                 (i.e. from  index 1 to |s|) that prints all the distinct contacts which have the same prefix as
                                              p in lexicographical increasing order.
                 Please refer the explanation part for better understanding.

            Note : If there is no match between query and contacts, print "0".

            Example : 1
            Input   : n = 3
                      contact[] = {"geeikistest", "geeksforgeeks", "geeksfortest"}
                              s = "geeips"
            Output :  geeikistest geeksforgeeks geeksfortest
                      geeikistest geeksforgeeks geeksfortest
                      geeikistest geeksforgeeks geeksfortest
                      geeikistest
                      0
                      0
            Explanation :  By running the search query on contact list for "g"
                           we get : "geeikistest", "geeksforgeeks" and "geeksfortest".

                           By running the search query on contact list for "ge"
                           we get : "geeikistest", "geeksforgeeks" and "geeksfortest".

                           By running the search query on contact list for "gee"
                           we get : "geeikistest", "geeksforgeeks" and "geeksfortest".

                           By running the search query on contact list for "geei"
                           we get : "geeikistest".

                           No results found for "geeip", so print "0".
                           No results found for "geeips", so print "0".

            Your Task :
            You do not need to read input or print anything. Your task is to complete the function displayContacts()
            which takes n, contact[ ] and s as input parameters and returns a list of strings for required prefixes.
            If some prefix has no matching contact return "0" on that list.


            Expected Time Complexity  :  O(|s| * n * max|contact[i]|)
            Expected Auxiliary Space  :  O(n * max|contact[i]|)
        *
        *
        */
    }




}

package Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Ques_Q_2 {

    //Ques : Check if all levels of two trees are anagrams or not...........                    (GFG Ques.)


    //Approach 1 : Naive Approach........                                                       T.C. = O(n^2),  S.C. = O()
    /*  Naive Approach :
        Below is the step by step explanation of the naive approach to do this :

          1. Write a recursive program for level order traversal of a tree.
          2. Traverse each level of both the trees one by one and store the result of traversals
             in 2 different vectors, one for each tree.
          3. Sort both the vectors and compare them iteratively for each level, if they are same
             for each level then return true else return false.

        Time Complexity : O(n^2), where n is the number of nodes.

    * */


    //Approach 2 : Efficient Approach......                                                    T.C. = O(nlog(n)),  S.C. = O()
    /*  Efficient Approach :
          1. The idea is based on below article.
          2. Print level order traversal line by line | Set 1
          3. We traverse both trees simultaneously level by level. We store each level both trees in vectors (or array).
             To check if two vectors are anagram or not, we sort both and then compare.

        Time Complexity : O(nlog(n)), where n is the number of nodes.

    * */
    /* Iterative program to check if two trees are level by level anagram. */
    public class GFG {
        // A Binary Tree Node
        static class Node
        {
            Node left, right;
            int data;
            Node(int data){
                this.data = data;
                left = null;
                right = null;
            }
        }

        // Returns true if trees with root1 and root2 are level by level anagram, else returns false.
        static boolean areAnagrams(Node root1, Node root2)
        {
            // Base Cases
            if (root1 == null && root2 == null)
                return true;
            if (root1 == null || root2 == null)
                return false;

            // start level order traversal of two trees using two queues.
            Queue<Node> q1 = new LinkedList<Node>();
            Queue<Node> q2 = new LinkedList<Node>();
            q1.add(root1);
            q2.add(root2);

            while (true)
            {
                // n1 (queue size) indicates number of Nodes at current level in first tree and
                // n2 indicates number of nodes in current level of second tree.
                int n1 = q1.size(), n2 = q2.size();

                // If n1 and n2 are different
                if (n1 != n2)
                    return false;

                // If level order traversal is over
                if (n1 == 0)
                    break;

                // Dequeue all Nodes of current level and
                // Enqueue all Nodes of next level
                ArrayList<Integer> curr_level1 = new ArrayList<>();
                ArrayList<Integer> curr_level2 = new ArrayList<>();
                while (n1 > 0)
                {
                    Node node1 = q1.peek();
                    q1.remove();
                    if (node1.left != null)
                        q1.add(node1.left);
                    if (node1.right != null)
                        q1.add(node1.right);
                    n1--;

                    Node node2 = q2.peek();
                    q2.remove();
                    if (node2.left != null)
                        q2.add(node2.left);
                    if (node2.right != null)
                        q2.add(node2.right);

                    curr_level1.add(node1.data);
                    curr_level2.add(node2.data);
                }

                // Check if nodes of current levels are anagrams or not.
                Collections.sort(curr_level1);
                Collections.sort(curr_level2);

                if (!curr_level1.equals(curr_level2))
                    return false;
            }

            return true;
        }

        // Driver program to test above functions
        public static void main_3(String args[])
        {
            // Constructing both the trees.
            Node root1  = new Node(1);
            root1.left  = new Node(3);
            root1.right = new Node(2);
            root1.right.left  = new Node(5);
            root1.right.right = new Node(4);

            Node root2  = new Node(1);
            root2.left  = new Node(2);
            root2.right = new Node(3);
            root2.left.left  = new Node(4);
            root2.left.right = new Node(5);


            System.out.println(areAnagrams(root1, root2)   ?   "Yes" : "No");
        }
    }



    //Approach 3 : Another Efficient Approach.......                                          T.C. = O(n),  S.C. = O()
    /*  Efficient Approach :
            We can solve the problem in O(n) time complexity by using Hash tables during level order traversal.
            The idea is to do a level order traversal and in each level check whether the level is an anagram
            with help of hash tables.
    * */
    //C++ Code......
    /*  Iterative program to check if two trees are level by level anagram.
            #include <bits/stdc++.h>
            using namespace std;

            //A Binary Tree Node
            struct Node {
                struct Node *left, *right;
                int data;
            };

            // Returns true if trees with root1 and root2 are level by level anagram, else returns false.
            bool areAnagrams(Node* root1, Node* root2)
            {
                // Base Cases
                if (root1 == NULL && root2 == NULL)
                    return true;
                if (root1 == NULL || root2 == NULL)
                    return false;

                // start level order traversal of two trees using two queues.
                queue<Node*> q1, q2;
                q1.push(root1);
                q2.push(root2);

                // Hashmap to store the elements that occur in each level.
                unordered_map<int, int> m;

                while (!q1.empty() && !q2.empty())
                {
                    // n1 (queue size) indicates number of Nodes at current level in first tree and
                    // n2 indicates number of nodes in current level of second tree.
                    int n1 = q1.size(), n2 = q2.size();

                    // If n1 and n2 are different
                    if (n1 != n2)
                        return false;

                    // If level order traversal is over
                    if (n1 == 0)
                        break;

                    // Dequeue all Nodes of current level and
                    // Enqueue all Nodes of next level
                    while (n1--)
                    {
                        Node* node1 = q1.front();
                        q1.pop();

                        // Insert element into hashmap
                        m[node1->data]++;

                        // Insert left and right nodes into queue if exists.
                        if (node1->left != NULL)
                            q1.push(node1->left);
                        if (node1->right != NULL)
                            q1.push(node1->right);
                    }

                    while (n2--) {
                        Node* node2 = q2.front();
                        q2.pop();

                        // if element from second tree isn't present in the first tree of same level then
                        // it can't be an anagram.
                        if (m.find(node2->data) == m.end())
                            return false;

                        // Reduce frequency of element if present else
                        // adds it element to hash map with negative frequency.
                        m[node2->data]--;

                        // If frequency of the element becomes zero then remove the element from hashmap.
                        if (m[node2->data] == 0)
                            m.erase(node2->data);

                        // Insert left and right nodes into queue if exists.
                        if (node2->left != NULL)
                            q2.push(node2->left);
                        if (node2->right != NULL)
                            q2.push(node2->right);
                    }

                    // If nodes of current levels are anagrams the
                    // hashmap wouldn't contain any elements.
                    if (m.size() > 0)
                        return false;
                }
                if(q1.empty() && q2.empty())
                    return true;

                return false;
            }

            // Utility function to create a new tree Node
            Node* newNode(int data)
            {
                Node* temp = new Node;
                temp->data = data;
                temp->left = temp->right = NULL;
                return temp;
            }

            // Driver program to test above functions
            int main()
            {
                // Constructing both the trees.
                struct Node* root1 = newNode(1);

                root1->left  = newNode(3);
                root1->right = newNode(2);
                root1->right->left  = newNode(5);
                root1->right->right = newNode(4);

                struct Node* root2 = newNode(1);

                root2->left  = newNode(2);
                root2->right = newNode(3);
                root2->left->left  = newNode(4);
                root2->left->right = newNode(5);

                areAnagrams(root1, root2)  ?  cout << "Yes" : cout << "No";
                return 0;
            }
    * */





    //Approach 4 : Efficient and Simple Recursive Approach.......                           T.C. = O(n),  S.C. = O(n)
    /*  Efficient And Simple Recursive Approach :
            We can also solve this by recursively traversing tree1 and tree2 and checking left of tree1 vs
            right of tree2 and vice versa.


    * */
    public class GFG_2 {
        // A Binary Tree Node
        static class Node
        {
            Node left, right;
            int data;
            Node(int data){
                this.data = data;
                left = null;
                right = null;
            }
        }
        public static boolean areAnagrams(Node node1, Node node2) {

            if(node1==null && node2==null)
                return true;

            if(node1==null || node2==null)
                return false;

            if(node1.data != node2.data)
                return false;

            return areAnagrams(node1.left, node2.right)  &&  areAnagrams(node1.right, node2.left);
        }

        // Driver program to test above functions
        public static void main_4(String args[])
        {
            // Constructing both the trees.
            Node root1  = new Node(1);
            root1.left  = new Node(3);
            root1.right = new Node(2);
            root1.right.left  = new Node(5);
            root1.right.right = new Node(4);

            Node root2  = new Node(1);
            root2.left  = new Node(2);
            root2.right = new Node(3);
            root2.left.left  = new Node(4);
            root2.left.right = new Node(5);


            System.out.println(areAnagrams(root1, root2)   ?   "Yes"  :  "No");
        }
    }






    public static void main(String[] args) {

        /*Ques : Given two binary trees, we have to check if each of their levels are anagrams of each other or not.


            Example :

            //Follow the link for visual representation.......
            // Link : https://www.geeksforgeeks.org/check-if-all-levels-of-two-trees-are-anagrams-or-not/




            Tree : 1
            Level 0 : 1
            Level 1 : 3, 2
            Level 2 : 5, 4

            Tree : 2
            Level 0 : 1
            Level 1 : 2, 3
            Level 2 : 4, 5

            As we can clearly see all the levels of above two binary trees are anagrams of each other, hence return true.

        *
        * */
    }

}

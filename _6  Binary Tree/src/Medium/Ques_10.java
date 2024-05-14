package Medium;

import java.util.Stack;

public class Ques_10 {

    //Ques : Construct Binary Tree from String with bracket representation........          (GFG Ques.)


    //Approach 1 : Naive Approach.......                                                    T.C. = O(n^2), S.C. = O(n)
    /*  We know first character in string is root. Substring inside the first adjacent pair of parenthesis
        is for left subtree and substring inside second pair of parenthesis is for right subtree as in the below diagram.


        We need to find the substring corresponding to left subtree and substring corresponding to right subtree and then
        recursively call on both of the substrings.

        For this first find the index of starting index and end index of each substring.
        To find the index of closing parenthesis of left subtree substring, use a stack. Let the found index be stored in
        index variable.

    *
    */
    /* Java program to construct a binary tree from the given String */
    class GFG_1 {

        /* A binary tree node has data, pointer to left child and a pointer to right child */
        static class Node
        {
            int data;
            Node left, right;
        }

        /* Helper function that allocates a new node */
        static Node newNode(int data)
        {
            Node node = new Node();
            node.data = data;
            node.left = node.right = null;
            return (node);
        }

        /* This function is here just to test  */
        static void preOrder(Node node)
        {
            if (node == null)
                return;
            System.out.printf("%d ", node.data);
            preOrder(node.left);
            preOrder(node.right);
        }

        // function to return the index of close parenthesis
        static int findIndex(String str, int si, int ei)
        {
            if (si > ei)
                return -1;

            // Inbuilt stack
            Stack<Character> s = new Stack<>();
            for (int i = si; i <= ei; i++)
            {
                // if open parenthesis, push it
                if (str.charAt(i) == '(')
                    s.add(str.charAt(i));

                    // if close parenthesis
                else if (str.charAt(i) == ')')
                {
                    if (s.peek() == '(')
                    {
                        s.pop();

                        // if stack is empty, this is the required index
                        if (s.isEmpty())
                            return i;
                    }
                }
            }

            // if not found return -1
            return -1;
        }

        // function to construct tree from String
        static Node treeFromString(String str, int si, int ei)
        {

            // Base case
            if (si > ei)
                return null;

            int num = 0;
            // In case the number is having more than 1 digit
            while(si <= ei && str.charAt(si) >= '0' && str.charAt(si) <= '9')
            {
                num *= 10;
                num += (str.charAt(si) - '0');
                si++;
            }
            si--;
            // new root
            Node root = newNode(num);
            int index = -1;

            // if next char is '(' find the index of its complement ')'
            if (si + 1 <= ei && str.charAt(si+1) == '(')
                index = findIndex(str, si + 1, ei);

            // if index found
            if (index != -1)
            {

                // call for left subtree
                root.left  = treeFromString(str, si + 2, index - 1);

                // call for right subtree
                root.right = treeFromString(str, index + 2, ei - 1);
            }
            return root;
        }

        // Driver Code
        public static void main_1(String[] args)
        {
            String str = "4(2(3)(1))(6(5))";
            Node root  = treeFromString(str, 0, str.length() - 1);
            preOrder(root);
        }
    }




    //Approach 2 : Another Recursive Approach
    /*  # Another recursive approach :
        * Algorithm :
           1. The very first element of the string is the root.
           2. If the next two consecutive elements are “(” and “)”, this means there is no left child otherwise
              we will create and add the left child to the parent node recursively.
           3. Once the left child is added recursively, we will look for consecutive “(” and add the right child
              to the parent node.
           4. Encountering “)” means the end of either left or right node and we will increment the start index
           5. The recursion ends when the start index is greater than equal to the end index

    *
    * */
    class GFG_2{

        // Node class for the Tree
        static class Node
        {
            int data;
            Node left,right;
            Node(int data)
            {
                this.data = data;
                this.left = this.right = null;
            }
        }

        // static variable to point to the starting index of the string.
        static int start = 0;

        // Construct Tree Function which accepts a string and return root of the tree;
        static Node constructTree(String s)
        {

            // Check for null or empty string and return null;
            if (s.length() == 0 || s == null)
            {
                return null;
            }

            if (start >= s.length())
                return null;

            // Boolean variable to check for negative numbers
            boolean neg = false;

            // Condition to check for negative number
            if (s.charAt(start) == '-')
            {
                neg = true;
                start++;
            }

            // This loop basically construct the number from the continuous digits
            int num = 0;
            while (start < s.length()   &&   Character.isDigit(s.charAt(start)))
            {
                int digit = Character.getNumericValue(s.charAt(start));
                num = num * 10 + digit;
                start++;
            }

            // If string contains - minus sign then append - to the number;
            if (neg)
                num = -num;

            // Create the node object
            // i.e. root of the tree with data = num;
            Node node = new Node(num);

            if (start >= s.length())
            {
                return node;
            }

            // Check for open bracket and add the data to the left subtree recursively
            if (start < s.length() && s.charAt(start) == '(' )
            {
                start++;
                node.left = constructTree(s);
            }

            if (start < s.length() && s.charAt(start) == ')')
            {
                start++;
                return node;
            }

            // Check for open bracket and add the data to the right subtree recursively
            if (start < s.length() && s.charAt(start) == '(')
            {
                start++;
                node.right = constructTree(s);
            }

            if (start < s.length() && s.charAt(start) == ')')
            {
                start++;
                return node;
            }
            return node;
        }

        // Print tree function
        public static void printTree(Node node)
        {
            if (node == null)
                return;

            System.out.println(node.data + " ");
            printTree(node.left);
            printTree(node.right);
        }

        // Driver Code
        public static void main_2(String[] args) {

            // Input
            String s = "4(2(3)(1))(6(5))";

            // Call the function construct tree to create the tree pass the string;
            Node root = constructTree(s);

            // Function to print preorder of the tree
            printTree(root);
        }
    }







    public static void main(String[] args) {

        /*Ques : Construct a binary tree from a string consisting of parenthesis and integers. The whole input
                 represents a binary tree. It contains an integer followed by zero, one or two pairs of parenthesis.
                 The integer represents the root’s value and a pair of parenthesis contains a child binary tree with
                 the same structure. Always start to construct the left child node of the parent first if it exists.


            Example : 1
            Input   : "1(2)(3)"
            Output  : 1 2 3
            Explanation :
                               1
                              / \
                             2   3

            Explanation : first pair, of parenthesis contains left subtree and second one contains the right
                          subtree. Preorder of above tree is "1 2 3".

            Example : 2
            Input   : "4(2(3)(1))(6(5))"
            Output  : 4 2 3 1 6 5
            Explanation :
                               4
                             /   \
                            2     6
                           / \   /
                          3   1 5
        *
        * */
    }




}

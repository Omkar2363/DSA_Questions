package Hard;

import java.util.HashSet;
import java.util.Set;

public class Ques_LB {


    //Ques : Word Break........                                                        (GFG Ques.)


    //Approach 1 : Recursive Implementation....
    /*Recursive implementation of word break problem in java   */
    public class WordBreakProblem {

        // set to hold dictionary values
        private static Set<String> dictionary = new HashSet<>();

        public static void main_1(String []args)
        {
            // array of strings to be added in dictionary set.
            String temp_dictionary[] = {"mobile","samsung","sam","sung", "man","mango","icecream","and",
                    "go","i","like","ice","cream"};

            // loop to add all strings in dictionary set
            for (String temp : temp_dictionary)
            {
                dictionary.add(temp);
            }

            // sample input cases
            System.out.println(wordBreak("ilikesamsung"));
            System.out.println(wordBreak("iiiiiiii"));
            System.out.println(wordBreak(""));
            System.out.println(wordBreak("ilikelikeimangoiii"));
            System.out.println(wordBreak("samsungandmango"));
            System.out.println(wordBreak("samsungandmangok"));

        }

        /*
         returns true if the word can be segmented into parts such
         that each part is contained in dictionary
        */
        public static boolean wordBreak(String word)
        {
            int size = word.length();

            // base case
            if (size == 0)
                return true;

            //else check for all words
            for (int i = 1; i <= size; i++)
            {
                /*
                 Now we will first divide the word into two parts ,
                 the prefix will have a length of i and check if it is
                 present in dictionary ,if yes then we will check for
                 suffix of length size-i recursively. if both prefix and
                 suffix are present the word is found in dictionary.
                */

                if (dictionary.contains(word.substring(0,i)) &&
                        wordBreak(word.substring(i,size)))
                    return true;
            }

            // if all cases failed then return false
            return false;
        }
    }



    //Approach 2 : Dynamic Programming.......


//                * Follow the link for compeleting the solution...........
//                  https://www.geeksforgeeks.org/word-break-problem-dp-32/




    public static void main(String[] args) {

        /*Ques : Given a string A and a dictionary of n words B, find out if A can be segmented
                 into a space-separated sequence of dictionary words.

            Note : From the dictionary B each word can be taken any number of times and in any order.


            Example : 1
            Input   : n = 12
                      B = { "i", "like", "sam", "sung", "samsung", "mobile", "ice","cream", "icecream",
                            "man", "go", "mango" }
                      A = "ilike"
            Output  : 1
            Explanation : The string can be segmented as "i like".


            Example : 2
            Input   : n = 12
                      B = { "i", "like", "sam", "sung", "samsung", "mobile", "ice","cream", "icecream",
                            "man", "go", "mango" }
                      A = "ilikesamsung"
            Output  : 1
            Explanation : The string can be segmented as "i like samsung" or "i like sam sung".


            Your Task :
            Complete wordBreak() function which takes a string and list of strings as a parameter
            and returns 1 if it is possible to break words, else return 0. You don't need to read
            any input or print any output, it is done by driver code.


            Expected time complexity : O(s2)
            Expected auxiliary space : O(s) , where s = length of string A


        * */
    }



}

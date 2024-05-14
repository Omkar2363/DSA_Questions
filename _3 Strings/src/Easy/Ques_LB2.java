package Easy;

import java.util.Stack;

public class Ques_LB2 {

    //Ques : Reverse String array.....                                                     (Leet code Ques no. = 344)

    //Approach 1 : Two pointer approach....                                                T.C. = O(n), S.C. = O(1)
    public void reverseString_1(char[] s) {
        int left = 0;
        int right = s.length-1;
        char  temp;
        while(left<right){

            temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }


    //Approach 2 : Using Recursion.....                                                    T.C. = O(n), S.C. = O(n)
    static void reverse(char[] str, int s, int e){
        if(s>e)
            return;

        char temp = str[s];
        str[s] = str[e];
        str[e] = temp;

        reverse(str,s+1,e-1);

    }
    public void reverseString_2(char[] s) {

        reverse(s,0,s.length-1);
    }


    //Approach 3 : By using stack.....not a efficient approach.                           T.C. = O(n), S.C. = O(n)
    public void reverseString(char[] s) {

        Stack<Character> st = new Stack<>();
        String str = new String(s);

        for(int i = 0; i < str.length(); i++){
            st.push(s[i]);
        }
        char ans[] = new char[s.length];
        int i = 0;

        while(st.size() > 0){
            s[i++] = st.pop();
        }
        for(int j = 0; j < str.length(); j++){
            ans[j] = str.charAt(j);
        }
    }



    public static void main(String[] args) {

        /*Ques : Write a function that reverses a string. The input string is given as an array of characters s.

                 You must do this by modifying the input array in-place with O(1) extra memory.


            Example : 1
            Input   : s = ["h","e","l","l","o"]
            Output  : ["o","l","l","e","h"]


            Example : 2
            Input   : s = ["H","a","n","n","a","h"]
            Output  : ["h","a","n","n","a","H"]


        * */
    }

}

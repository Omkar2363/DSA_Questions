package Easy;

public class Ques_LB9 {

    //Ques : Remove Consecutive Characters......                                     (GFG Ques.)


    //Approach 1 :
    /*Approach : Traverse given string from left to right if stack is empty push current letter
                 in the stack and if stack is not empty then check whether stack's  top element
                 is same as current element or not.
                 If they are same then don't push current element in your stack else push current
                 element in your stack.
    * */
    /*C++ code :
        string removeConsecutiveCharacter(string s)
        {
            //only entering those elements in stack which are unique consecutively.
    	    stack<char> st;
    	    for(int i=0;i<s.length();i++)
    		{
    			if( (st.empty()==0 && st.top()!=s[i] ) || st.empty() == 1  )
    				st.push(s[i]);
    		}
    	    // storing stack elements in string.
    	    string res;
    	    while(st.empty()==0)
    		{
    			res+=st.top();
    			st.pop();
    		}

    	// reversing the string because stack is a LIFO data structure.
    	reverse(res.begin(),res.end());
    	return res;
    }
    * */


    //Write code in java



    public static void main(String[] args) {

        /*Ques : Given a string S. For each index i(1<=i<=N-1), erase it if s[i] is equal to s[i-1] in the string.


            Example : 1
            Input   : S = aabb
            Output  :  ab
            Explanation : 'a' at 2nd position is appearing 2nd time consecutively.
                           Similar explanation for b at 4th position.


            Example : 2
            Input   : S = aabaa
            Output  : aba
            Explanation : 'a' at 2nd position is appearing 2nd time consecutively.
                          'a' at fifth position is appearing 2nd time consecutively.


            Your Task:
            You don't need to read input or print anything. Complete the function removeConsecutiveCharacter()
            which accepts a string as input parameter and returns modified string.

            Expected Time Complexity: O(|S|).
            Expected Auxiliary Space: O(|S|).


        * */
    }

}

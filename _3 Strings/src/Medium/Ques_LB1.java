package Medium;

public class Ques_LB1 {

    //Ques : Count and Say......                                                 (Leet code Ques no. - 38)

    //Approach 1 : Simple approach.....Iterative approach
    public String countAndSay_1(int n) {
        String res = "1";

        while(n>1)
        {
            StringBuilder s = new StringBuilder();
            for(int i=0,j=i ; i<res.length() ; i=j)
            {
                while(j< res.length() && res.charAt(i) == res.charAt(j))
                {
                    j++;
                }
                s.append(j-i).append(res.charAt(i));
            }
            res = s.toString();
            n--;
        }
        return res;
    }
    //Same approach as above but different code.......Efficient code
    public String countAndSay(int n) {
        if (n == 1)
            return "1";

        StringBuilder sb = new StringBuilder();
        String s = countAndSay(n-1);
        int cnt = 0;
        Character prev = null;

        for (int i = 0 ; i < s.length() ; i++) {
            if (prev == null) {
                prev = s.charAt(i);
            }
            else if (s.charAt(i-1) != s.charAt(i)) {
                sb.append(cnt);
                sb.append(prev);
                cnt = 0;
                prev = s.charAt(i);
            }
            cnt++;
        }

        sb.append(cnt);
        sb.append(prev);

        return sb.toString();
    }




    //Approach 2 : By using recursion ........Efficient solution
    public String countAndSay_2(int n) {
        // Conner case.
        if (n == 1)
            return "1";

        // Recursively obtain the count-and-say sequence of n - 1.
        String str = countAndSay_2(n - 1);

        StringBuilder newStr = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            // Count i-th character.
            int count = 1;
            // Check if i-th character have a following same character.
            while (i + 1 < str.length() && str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;
            }
            // Append count and then value.
            newStr.append(count);
            newStr.append(str.charAt(i));
        }

        return newStr.toString();
    }




    //Approach 3 : By using recursion........Not a efficient solution
    public String getString(String temp){
        String ans = "";                              //our answer
        char ch = temp.charAt(0);
        int count=0;

        //running a loop to store all the count of each digits
        for(int i=0 ; i<temp.length() ; i++){
            if(temp.charAt(i) == ch){
                count++;
            }else{
                ans += count;
                ans += ch;
                ch = temp.charAt(i);
                count = 1;
            }
        }

        //at last something is there at curr and count which can't be stored in str
        //as string length was exhausted
        ans += count;
        ans += ch;

        //at last return the str which contain the answer
        return ans;

    }
    public String countAndSay_3(int n) {
        //base condition
        if(n==1){
            return "1";
        }

        //recursion will bring the answer for n-1
        String temp = countAndSay_3(n-1);

        //we will calculate the answer for n
        return getString(temp);
    }







    public static void main(String[] args) {

        /*Ques : The count-and-say sequence is a sequence of digit strings defined by the recursive formula:

                 countAndSay(1) = "1"
                 countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1),
                 which is then converted into a different digit string.

                 To determine how you "say" a digit string, split it into the minimal number of substrings
                 such that each substring contains exactly one unique digit. Then for each substring, say
                 the number of digits, then say the digit. Finally, concatenate every said digit.

                 For example, the saying and conversion for digit string "3322251":


                Given a positive integer n, return the nth term of the count-and-say sequence.



            Example : 1
            Input   : n = 1
            Output  : "1"
            Explanation : This is the base case.


            Example : 2
            Input   : n = 4
            Output  : "1211"
            Explanation :
            countAndSay(1) = "1"
            countAndSay(2) = say "1" = one 1 = "11"
            countAndSay(3) = say "11" = two 1's = "21"
            countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"


            * Follow the link for more detail description of the problem.

                Link : https://www.includehelp.com/icp/count-and-say-sequence.aspx
        *
        * */
    }



}

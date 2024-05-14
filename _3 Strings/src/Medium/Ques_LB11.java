package Medium;

import java.util.List;
import java.util.ArrayList;

public class Ques_LB11 {

    //Ques : Restore IP Addresses..............                                     (Leet code Ques no.- 93)
    /*       (Generate all possible valid IP addresses that can be formed by inserting dots into Given String...)
    * */


    //Approach 1 : Brute force........                                              T.C. = O(1),  S.C. = O(1)
    //Code 1 :
    class Solution_11{
        public List<String> restoreIpAddresses(String s)
        {

            if(s == null)
                return new ArrayList<>();

            ArrayList<String> ans = new ArrayList<>();
            int n = s.length();

            for(int i=1 ; i<Math.min(n, 4) ; i++)
            {
                String[] currIPAdd_Parts = new String[] {"", "", "", ""};
                currIPAdd_Parts[0] = s.substring(0, i);

                if(!isValidPart(currIPAdd_Parts[0]))
                    continue;

                for(int j=i+1 ; j<(i + Math.min(n-i, 4)) ; j++)
                {
                    currIPAdd_Parts[1] = s.substring(i, j);

                    if(!isValidPart(currIPAdd_Parts[1]))
                        continue;

                    for(int k=j+1 ; k<(j + Math.min(n-j, 4)) ; k++)
                    {
                        currIPAdd_Parts[2] = s.substring(j, k);
                        currIPAdd_Parts[3] = s.substring(k);

                        if(isValidPart(currIPAdd_Parts[2]) && isValidPart(currIPAdd_Parts[3]))
                            ans.add(join(currIPAdd_Parts));
                    }
                }
            }
            return ans;
        }

        public boolean isValidPart(String str)
        {
            int n = str.length();

            if(n > 3)
                return false;

            return (str.charAt(0) != '0') ? (Integer.valueOf(str) <= 255) : (n == 1);
        }

        public String join(String[] strs)
        {
            StringBuilder sb = new StringBuilder();

            for(int i=0 ; i<strs.length ; i++)
            {
                sb.append(strs[i]);

                if(i != strs.length-1)
                    sb.append(".");
            }
            return sb.toString();
        }
    }
    //Code 2 :
    class Solution_12 {
        public List<String> restoreIpAddresses(String s)
        {
            List<String> result = new ArrayList<>();
            StringBuffer ip = new StringBuffer();

            for(int a=1 ; a<=3 ; a++){
                for(int b=1 ; b<=3 ; b++){
                    for(int c=1 ; c<=3 ; c++){

                        int d = s.length()-(a+b+c);
                        if (d>=1 && d<=3)
                        {
                            int A = Integer.parseInt(s.substring(0, a));
                            int B = Integer.parseInt(s.substring(a, a+b));
                            int C = Integer.parseInt(s.substring(a+b, a+b+c));
                            int D = Integer.parseInt(s.substring(a+b+c, a+b+c+d));

                            if(A<=255 && B<=255 && C<=255 && D<=255)
                            {
                                ip.append(A).append(".").append(B).append(".")
                                        .append(C).append(".").append(D);

                                if (ip.length() == s.length() + 3)
                                {
                                    result.add(ip.toString());
                                }
                                ip = new StringBuffer();
                            }
                        }
                    }
                }
            }
            return result;
        }
    }


    //Approach 2 : Recursion and BackTracking solution.......
    //Code 1 :
    class Solution_21{
        List<String> list = new ArrayList<>();

        public List<String> restoreIpAddresses(String s)
        {
            recursion(s, "", 0, 4);
            System.out.println(list);
            return list;
        }
        void recursion(String s, String str, int i, int k)
        {
            if(i == s.length() && k == 0)
            {
                list.add(str.substring(0,str.length()-1));
                return;
            }

            for(int x=i ; x<Math.min(s.length(),i+3) ; x++)
            {
                if(k < 0)
                    break;
                String sb = s.substring(i,x+1);
                int num = Integer.parseInt(sb);
                int size = sb.length();

                if(size == 2 && num < 10)
                    continue;
                if(size == 3 && num < 100)
                    continue;
                if(size == 3 && num > 255)
                    continue;

                recursion(s, str + sb + ".", x+1, k-1);
            }
        }
    }
    //Code 2 :
    class Solution_22{
        public List<String> restoreIpAddresses(String s)
        {
            List<String> ans = new ArrayList<>();

            // if the length of the string is longer than 12 which can not form a valid IP
            if (s.length() > 12 || s.length() == 0)
                return ans;

            backtrack(ans, new ArrayList<String>(), s, 0);
            return ans;
        }

        private void backtrack(List<String> ans, List<String> temp, String s, int start)
        {
            // once reach to end of the string and  have four num inside the list
            // then join these four nums and add to result list
            if (start == s.length() && temp.size() == 4)
            {
                ans.add(String.join(".", temp));
                return;
            }

            // each number is between 0 and 255 which is 1 digit to 3 digit
            // So we have three different choices for each number
            //      1. substring from start to start+1
            //      2. substring from start to start+2
            //      3. substring from start to start+3
            for (int i=1 ; i<=3 ; i++) {
                if (start + i > s.length())
                    return;
                String address = s.substring(start, start + i);
                // check the address validation
                if (validAddress(address)) {
                    // add valid num into List
                    // start a new backtracking
                    temp.add(address);
                    backtrack(ans, temp, s, start + i);
                    temp.remove(temp.size() - 1);

                }
            }
        }

        // To valid the given address each integer is between 0 and 255 and can not start with 0
        private boolean validAddress(String address) {
            return !((address.charAt(0) == '0' && address.length() > 1) || Integer.parseInt(address) > 255);
        }
    }



    public static void main(String[] args) {

        /*Ques : Given a string s containing only digits, return all possible valid IP addresses that
                 can be formed by inserting dots into s.
                 You are not allowed to reorder or remove any digits in s.
                 You may return the valid IP addresses in any order.

                 A valid IP address consists of exactly four integers separated by single dots.
                 Each integer is between 0 and 255 (inclusive) and cannot have leading zeros.

                 For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but
                              "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.



            Example : 1
            Input   : s = "25525511135"
            Output  : ["255.255.11.135","255.255.111.35"]


            Example : 2
            Input   : s = "0000"
            Output  : ["0.0.0.0"]


            Example : 3
            Input   : s = "101023"
            Output  : ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]

            */
    }


}

package Medium;

import java.util.HashMap;

public class Ques_2 {

    //Ques : Longest Repeating Character Replacement......                             (Leet code Ques no. = 424)


    //Approach 1 :
    public int characterReplacement_1(String s, int k) {
        int  max  = 0;
        char[] ss = s.toCharArray();
        for(int i=65 ; i<65+26 ; i++)
            max=Math.max(func((char)(i),ss,k),max);

        return max;
    }
    private int func(char c,char[] s, int k){
        int max = 0;
        int n = s.length;
        for(int i=0,j=0 ; i<n && j<n ; i++){

            if(i>0)
                if(s[i-1]!=c)
                    k++;
            while(j<n && k>=1)
                if(s[j++]!=c)
                    k--;
            while(j<n &&s[j]==c)
                j++;
            max = Math.max(j-i,max);
        }
        return max;
    }




    //Approach 2 : Using sliding window technique                                      T.C. = O(n), S.C. = O(1)
    public int characterReplacement_2(String s, int k) {
        int[] arr = new int[26];
        int result = 0;
        int maxF = 0;
        for(int r=0,l=0 ; r<s.length() ; r++) {
            arr[s.charAt(r)-'A'] += 1;

            maxF = Math.max(arr[s.charAt(r)-'A'], maxF);
            if((r-l+1)-maxF > k) {
                arr[s.charAt(l)-'A'] -= 1;
                l++;
            }
            result = Math.max(result, r-l+1);
        }
        return result;
    }

    //Same technique another code...................//Efficient code(6 ms)
    public int characterReplacement(String s, int k) {
        if(s.length() == 1)
            return 1;

        int[]  array = new int[26];
        int maxCount = 0;
        int start = 0;
        int ans = 0;
        for(int i=0 ; i<s.length() ; i++){
            array[s.charAt(i)-'A']++;

            maxCount = Math.max(array[s.charAt(i)-'A'], maxCount);
            if((i-start+1)-maxCount > k){
                array[s.charAt(start)-'A']--;
                start++;
            }
            ans = Math.max(ans,i-start+1);
        }
        return ans;
    }



    //Approach 3 : using HashMap....not a efficient approach (112 ms)                  T.C. = O(n), S.C. = O(n)
    public int characterReplacement_3(String s, int k) {
        int left = 0;
        int right = 0;
        int ans = 0;
        int max = 0;
        HashMap<Character,Integer> map = new HashMap<>();

        for(right=0 ; right<s.length() ; right++)
        {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c,0)+1);
            for(Character ch : map.keySet())
            {
                max = Math.max(max,map.get(c));
            }
            if((right-left-max+1) <= k)
                ans = right-left+1;
            else
            {
                char ch = s.charAt(left);
                map.put(ch, map.getOrDefault(ch,0)-1);
                left++;
            }
        }
        return ans;
    }


    public static void main(String[] args) {

        /*Ques : You are given a string s and an integer k. You can choose any character of the string
                 and change it to any other uppercase English character. You can perform this operation
                 at most k times.

                 Return the length of the longest substring containing the same letter you can get after
                 performing the above operations.


            Example : 1
            Input   : s = "ABAB", k = 2
            Output  : 4
            Explanation : Replace the two 'A's with two 'B's or vice versa.


            Example : 2
            Input   : s = "AABABBA", k = 1
            Output  : 4
            Explanation : Replace the one 'A' in the middle with 'B' and form "AABBBBA".
                          The substring "BBBB" has the longest repeating letters, which is 4.

         */

    }

}

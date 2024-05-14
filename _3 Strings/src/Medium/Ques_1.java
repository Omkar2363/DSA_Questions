package Medium;

import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


public class Ques_1 {

    //Ques : Longest Substring Without Repeating Characters.....                          (Leet code Ques no. = 3)


    //Approach 1 : Using Sliding window approach
    public int lengthOfLongestSubstring_11(String s) {
        if(s.length() == 0)
            return 0;

        int maxLength = 1;
        Map<Character, Integer> map = new HashMap<>();

        int ptr_l = 0;      // Create pointer to the left side of the string
        int ptr_r = 0;      // Create pointer to the right


        while(ptr_r < s.length())
        {
            if(!map.containsKey(s.charAt(ptr_r)))
                map.put(s.charAt(ptr_r), ptr_r);

            else{
                if(ptr_l <= map.get(s.charAt(ptr_r)))
                    ptr_l = map.get(s.charAt(ptr_r)) + 1;

                map.replace(s.charAt(ptr_r), ptr_r);
            }

            ptr_r++;

            if(ptr_r - ptr_l > maxLength)
                maxLength = ptr_r - ptr_l;

        }

        return maxLength;
    }
    /*  Visual Representation of sliding window...

        Link : https://leetcode.com/problems/longest-substring-without-repeating-characters/discuss/2133524/JavaC%2B%2B-A-reall-Detailed-Explanation
    * */
    //Same approach as above but different code :
    public int lengthOfLongestSubstring_12(String s) {
        if (s.length() == 0)
            return 0;
        Map<Character, Integer> map = new HashMap<>();

        int start = 0;
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                start = Math.max(map.get(s.charAt(i)) + 1, start);
            }

            map.put(s.charAt(i), i);
            max = Math.max(i - start + 1, max);
        }

        return max;
    }



    //Approach 2 : By using HashSet....
    public int lengthOfLongestSubstring_2(String s) {
        int i = 0;
        int j = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();

        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            }
            else {
                set.remove(s.charAt(i++));
            }
        }

        return max;
    }


    //Approach 3 : HashMap + Two pointer (upr bhi yhi hai sayad)
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int maxWindowSize = -1;
        if(s.length() == 0 || s.length() == 1){
            return s.length();
        }

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        while(left < s.length() && right < s.length()){

            if(!map.containsKey(s.charAt(right))){
                map.put(s.charAt(right), 1);
                right++;
                maxWindowSize = Math.max(maxWindowSize, right - left);
            }
            else{
                map.remove(s.charAt(left));
                left++;
            }
        }
        return maxWindowSize;
    }



    public static void main(String[] args) {

        /*Ques : Given a string s, find the length of the longest substring without repeating characters.


            Example : 1
            Input   : s = "abcabcbb"
            Output  : 3
            Explanation : The answer is "abc", with the length of 3.


            Example : 2
            Input   : s = "bbbbb"
            Output  : 1
            Explanation : The answer is "b", with the length of 1.


            Example : 3
            Input   : s = "pwwkew"
            Output  : 3
            Explanation : The answer is "wke", with the length of 3.
                          Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
        * */
    }
}

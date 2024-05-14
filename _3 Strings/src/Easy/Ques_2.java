package Easy;

import java.util.HashMap;
import java.util.Arrays;

public class Ques_2 {

    //Ques : Valid Anagram....                                                          (Leet code Ques no. = 242)
                                                                    // Related Ques :
                                                                    // Group Anagrams......Package...Medium / Ques_3


    //Approach 1 :
    public boolean isAnagram_1(String s, String t) {
        //If their lengths are not same they can not be anagrams
        if(s.length() != t.length()) {
            return false;
        }

        int[] alphabet = new int[26];

        for(int i=0; i<s.length(); i++) {
            alphabet[s.charAt(i) - 'a']++;
            alphabet[t.charAt(i) - 'a']--;
        }

        for(int i: alphabet) {
            if(i!=0) {
                return false;
            }
        }

        return true;
    }



    //Approach 2 :
    public boolean isAnagram_2(String s, String t) {
        return sortString(s).equals(sortString(t));
    }
    public String sortString(String input) {
        char[] array = input.toCharArray();
        Arrays.sort(array);
        return new String(array);
    }



    //Approach 3 :
    public boolean isAnagram_3(String s, String t) {
        if(s.length()!=t.length())
            return false;
        char[] sCopy=s.toCharArray();
        char[] tCopy=t.toCharArray();

        Arrays.sort(sCopy);
        Arrays.sort(tCopy);

        if(Arrays.compare(sCopy, tCopy)==0)
            return true;

        return false;
    }


    //Approach 4 :
    public boolean isAnagram_4(String s, String t) {

        //same as approach 3....

        char[] sCharArr = s.toCharArray();
        char[] tCharArr = t.toCharArray();

        Arrays.sort(sCharArr);
        Arrays.sort(tCharArr);
        return Arrays.equals(tCharArr, sCharArr);

    }


    //Approach 5 : Using Hashmap....Not  efficient
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map1=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            map1.put(ch, map1.getOrDefault(ch,0)+1);
        }

        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            if(map1.containsKey(ch)==false){
                return false;
            }
            map1.put(ch, map1.get(ch)-1);
            if(map1.get(ch)==0){
                map1.remove(ch);
            }
        }
        return map1.size() == 0;
    }



    public static void main(String[] args) {

        /*Ques : Given two strings s and t, return true if t is an anagram of s, and false otherwise.

                 An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
                 typically using all the original letters exactly once.


            Example : 1
            Input   : s = "anagram", t = "nagaram"
            Output  : true

            Example : 2
            Input   : s = "rat", t = "car"
            Output  : false

        *
        * */
    }

}

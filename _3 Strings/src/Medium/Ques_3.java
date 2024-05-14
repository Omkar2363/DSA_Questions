package Medium;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Ques_3 {

    //Ques : Group Anagrams......                                                       (Leet code ques no.- 49 )
                                                                // Related Ques :
                                                                // Valid Anagram.......Package : Easy / Ques_2


    //Approach 1 : By using HashMap.........                                            T.C. = O(n*mlog(m)), S.C. = O(n*m)
    public List<List<String>> groupAnagrams_11(String[] strs) {

        HashMap<String, List<String>> map = new HashMap();
        List<List<String>> result = new ArrayList();

        for (int i=0 ; i<strs.length ; i++)
        {
            char[] c = strs[i].toCharArray();

            Arrays.sort(c);
            String s = new String(c);
            if (map.containsKey(s)){
                List<String> item = map.get(s);
                item.add(strs[i]);
            }
            else{
                List<String> list = new ArrayList();
                list.add(strs[i]);
                map.put(s, list);
            }
        }

        for (String item : map.keySet()){
            result.add(map.get(item));
        }
        return result;

    }
    //Same approach different code...
    public List<List<String>> groupAnagrams_12(String[] strs) {

        HashMap<String,List<String>> map = new HashMap<>();

        for(int i=0 ; i<strs.length ; i++){
            String s1 = strs[i];
            char[] arr = s1.toCharArray();
            Arrays.sort(arr);

            String str = new String(arr);

            if(map.containsKey(str)){
                map.get(str).add(s1);
            }
            else{
                map.put(str, new ArrayList<>());
                map.get(str).add(s1);
            }
        }
        return new ArrayList<>(map.values());


    }



    //Approach 2 : By using  HashMap and without using sort function......             T.C. = O(n*m), S.C. = O(n*m)
    public List<List<String>> groupAnagrams(String[] strs) {

        if (strs == null || strs.length == 0)
            return new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs)
        {
            char[] chArr = new char[26];

            for (char ch : s.toCharArray())
                chArr[ch - 'a']++;

            String keyStr = String.valueOf(chArr);
            if (!map.containsKey(keyStr))
                map.put(keyStr, new ArrayList<>());

            map.get(keyStr).add(s);
        }
        return new ArrayList<>(map.values());
    }




    public static void main(String[] args) {

        /*Ques : Given an array of strings strs, group the anagrams together.
                 You can return the answer in any order.

                 An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
                 typically using all the original letters exactly once.


            Example : 1
            Input   : strs = ["eat","tea","tan","ate","nat","bat"]
            Output  : [["bat"],["nat","tan"],["ate","eat","tea"]]


            Example : 2
            Input   : strs = [""]
            Output  : [[""]]


            Example : 3
            Input   : strs = ["a"]
            Output  : [["a"]]
        * */
    }


}

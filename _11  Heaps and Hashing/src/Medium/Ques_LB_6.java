package Medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Ques_LB_6 {

    //Ques : Reorganize String...........                                                 (Leet Code Ques no.- 764)


    //Approach 1 :                                                                        T.C. = O(n),  S.C. = O(n)
    class Solution {
        public String reorganizeString(String s)
        {
            int n = s.length();
            int maxFreq = 0;
            int maxLetter = -1;
            int[] map = new int[26];

            for (int i = 0; i < n; i++)
            {
                int c = s.charAt(i) - 'a';
                map[c] += 1;
                if (map[c] > maxFreq)
                {
                    maxFreq = map[c];
                    maxLetter = c;
                }
            }

            if (maxFreq - 1 > n - maxFreq)
                return "";

            char[] res = new char[n];
            int index = 0;
            while (map[maxLetter] != 0)
            {
                res[index] = (char) ('a' + maxLetter);
                map[maxLetter] -= 1;
                index += 2;
            }

            for (int i = 0; i < 26; i++)
            {
                while (map[i] != 0) {
                    if (index >= n) index = 1;
                    res[index] = (char) ('a' + i);
                    map[i] -= 1;
                    index += 2;
                }
            }
            return new String(res);
        }
    }



    //Approach 2 : By using map.......Priority Queue....
    class Pair {

        int count ;
        char val ;

        public Pair(int count , char val){
            this.count = count ;
            this.val = val ;
        }
    }
    class Solution_2 {

        public String reorganizeString(String s) {

            PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a , b) -> (b.count - a.count));
            HashMap<Character, Integer> map = new HashMap() ;

            for(int i=0 ; i<s.length() ; i++)
            {
                map.put(s.charAt(i) , map.getOrDefault(s.charAt(i) , 0) + 1);
            }

            for(Map.Entry<Character, Integer> entry : map.entrySet())
            {
                pq.add(new Pair(entry.getValue() , entry.getKey()));
            }

            StringBuilder sb = new StringBuilder() ;
            Pair prev = null ;

            while(!pq.isEmpty()){

                Pair curr = pq.poll() ;
                sb.append(curr.val);

                if(prev != null){
                    pq.add(prev);
                    prev = null ;
                }

                int new_count = curr.count - 1 ;
                if(new_count > 0){
                    prev = new Pair(new_count , curr.val);
                }

            }

            return (sb.length() == s.length()) ? sb.toString() : "" ;

        }
    }





    public static void main(String[] args) {

        /*Ques : Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.
                 Return any possible rearrangement of s or return "" if not possible.


            Example : 1
            Input   : s = "aab"
            Output  : "aba"


            Example : 2
            Input   : s = "aaab"
            Output  : ""
        *
        * */
    }



}

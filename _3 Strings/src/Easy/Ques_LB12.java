package Easy;

import java.util.Map;
import java.util.HashMap;


public class Ques_LB12 {

    //Ques : Roman Number to Integer.........                                          (GFG Ques.)


    //Approach 1 :                                                                     T.C. = O(n),  S.C. = O(1)
    /*  Algorithm to convert Roman Numerals to Integer Number :

        * Split the Roman Numeral string into Roman Symbols (character).
        * Convert each symbol of Roman Numerals into the value it represents.
        * Take symbol one by one from starting from index 0 :
                1. If current value of symbol is greater than or equal to the value of next symbol,
                   then add this value to the running total.
                2. else subtract this value by adding the value of next symbol to the running total.

    * */
    // This function returns value of a Roman symbol
    int value(char r){

        if (r == 'I')
            return 1;
        if (r == 'V')
            return 5;
        if (r == 'X')
            return 10;
        if (r == 'L')
            return 50;
        if (r == 'C')
            return 100;
        if (r == 'D')
            return 500;
        if (r == 'M')
            return 1000;
        return -1;
    }
    // Finds decimal value of a given roman numeral
    int romanToDecimal(String str) {
        // Initialize result
        int res = 0;

        for (int i = 0; i < str.length(); i++) {
            // Getting value of symbol s[i]
            int s1 = value(str.charAt(i));

            // Getting value of symbol s[i+1]
            if (i + 1 < str.length()) {
                int s2 = value(str.charAt(i + 1));

                // Comparing both values
                if (s1 >= s2) {

                    // Value of current symbol is greater or equalto the next symbol
                    res = res + s1;
                } else {

                    // Value of current symbol is less than the next symbol
                    res = res + s2 - s1;
                    i++;
                }
            } else {
                res = res + s1;
            }
        }

        return res;


    /* Driver Code
    public static void main(String args[])
    {
        RomanToNumber ob = new RomanToNumber();

        // Considering inputs given are valid
        String str = "MCMIV";

        System.out.println("Integer form of Roman Numeral" + " is " + ob.romanToDecimal(str));
    }*/
    }



    //Approach 2 : By using HashMap..........                                         T.C. = O(n),  S.C. = O(1)
    // Program to convert Roman Numerals to Numbers
    class GFG_2{
        private static final Map<Character, Integer> roman = new HashMap<Character, Integer>()
        {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};

        // This function returns value of a Roman symbol
        private static int romanToInt(String s)
        {
            int sum = 0;
            int n = s.length();

            for(int i = 0; i < n; i++)
            {

                /*
                 If present value is less than next value, subtract present from next value and add the
                 resultant to the sum variable.
                */
                if (i != n - 1 && roman.get(s.charAt(i)) < roman.get(s.charAt(i + 1)))
                {
                    sum += roman.get(s.charAt(i + 1)) - roman.get(s.charAt(i));
                    i++;
                }
                else
                {
                    sum += roman.get(s.charAt(i));
                }
            }
            return sum;
        }

        // Driver Code
        public static void main_2(String[] args)
        {

            // Considering inputs given are valid
            String input = "MCMIV";

            System.out.print("Integer form of Roman Numeral is " + romanToInt(input));
        }
    }



    //Approach 3 : Short code.......                                                  T.C. = O(n),  S.C. = O(1)
    class GFG_3{
        public static void romanToInt(String s)
        {
            Map<Character,Integer> map = new HashMap<Character,Integer>();

            //Adding elements to map
            map.put('I',1);
            map.put('V',5);
            map.put('X',10);
            map.put('L',50);
            map.put('C',100);
            map.put('D',500);
            map.put('M',1000);

            s = s.replace("IV","IIII");
            s = s.replace("IX","VIIII");
            s = s.replace("XL","XXXX");
            s = s.replace("XC","LXXXX");
            s = s.replace("CD","CCCC");
            s = s.replace("CM","DCCCC");

            int number = 0;
            for (int i = 0; i < s.length(); i++)
            {
                number = number + (map.get(s.charAt(i)));
            }
            System.out.println(number);
        }
        public static void main_3(String[] args)
        {
            romanToInt("MCMIV");
        }
    }





    public static void main(String[] args) {

        /*Ques : Given a string in roman no format (s)  your task is to convert it to an integer .
                 Various symbols and their values are given below.
                    I 1
                    V 5
                    X 10
                    L 50
                    C 100
                    D 500
                    M 1000


                Example : 1
                Input   : s = V
                Output  : 5

                Example : 2
                Input   : s = III
                Output  : 3


                Your Task :
                Complete the function romanToDecimal() which takes a string as input parameter and
                returns the equivalent decimal number.

                Expected Time Complexity  : O(|S|), |S| = length of string S.
                Expected Auxiliary Space  : O(1)


        * */
    }


}

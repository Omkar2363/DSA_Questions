package Easy;

import java.util.Set;

public class Ques_1 {

    //Ques : Valid Palindrome....                                                           (Leet code Ques no. = 125)

    //Approach 1 :
    public boolean isPalindrome_1(String s) {
        s = s.toLowerCase();

        StringBuilder ab = new StringBuilder();
        for(int i = 0; i<s.length(); i++){
            if(Character.isDigit(s.charAt(i)) || Character.isLetter(s.charAt(i))){
                ab.append(s.charAt(i));
            }
        }
        int n = ab.length()-1;
        for(int i = 0; i<ab.length()/2; i++){
            if(ab.charAt(i)!= ab.charAt(n-i))return false;
        }
        return true;

    }


    //Approach 2 :
    public boolean isPalindrome_2(String s) {
        if(s==null)
            return false;
        String k=s.toLowerCase();
        k=k.replaceAll("[^a-z0-9]","");
        int i=0;
        int j=k.length()-1;
        while(i<j){
            if(k.charAt(i)==k.charAt(j)){
                i++;
                j--;
            }
            else{
                return false;
            }
        }
        return true;
    }


    //Approach 3 :
    public boolean isPalindrome_3(String s) {
        if(s==null)
            return false;

        // Take in lowercase character...
        s = s.toLowerCase();

        int left = 0;
        int right = s.length()-1;

        while(left<right){
            while(left<right && !((s.charAt(left)>='a' && s.charAt(left)<='z') || (s.charAt(left)>='0'&&s.charAt(left)<='9'))){

                left++;
            }

            while(left<right && !((s.charAt(right)>='a' && s.charAt(right)<='z') || (s.charAt(right)>='0'&&s.charAt(right)<='9'))){
                right--;
            }

            if(s.charAt(left) != s.charAt(right)){
                return false;
            }

            left++;
            right--;
        }

        return true;

    }


    //Approach 4 :
    public boolean isPalindrome_4(String s) {
        //Note the creation of Set...
        Set<String> alphabet = Set.of("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","0","1","2","3","4","5","6","7","8","9");

        StringBuilder sb = new StringBuilder();

        for (char c : s.toLowerCase().toCharArray()) {
            if (alphabet.contains(Character.toString(c))) {
                sb.append(c);
            }
        }

        for (int i = 0, j = sb.length() - 1; i < sb.length(); i++, j--) {
            if (sb.charAt(i) != sb.charAt(j)) {
                return false;
            }
        }

        return true;
    }


    //Approach 5 : not efficient  but short code
    public boolean isPalindrome(String s) {

        String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String rev = new StringBuffer(actual).reverse().toString();
        return actual.equals(rev);
    }




    public static void main(String[] args) {

        /*Ques : A phrase is a palindrome if, after converting all uppercase letters into lowercase letters
                 and removing all non-alphanumeric characters, it reads the same forward and backward.
                 Alphanumeric characters include letters and numbers.

                 Given a string s, return true if it is a palindrome, or false otherwise.


                Example : 1
                Input   : s = "A man, a plan, a canal: Panama"
                Output  : true
                Explanation : "amanaplanacanalpanama" is a palindrome.


                Example : 2
                Input   : s = "race a car"
                Output  : false
                Explanation : "raceacar" is not a palindrome.


                Example : 3
                Input   : s = " "
                Output  : true
                Explanation : s is an empty string "" after removing non-alphanumeric characters.
                              Since an empty string reads the same forward and backward, it is a palindrome.

        * */
    }

}

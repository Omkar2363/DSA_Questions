package Easy;

public class Ques_5 {

    //Ques : Longest Common Prefix.....                                                      (Leet code Ques no. = 14)


    //Approach 1 :
    public int mini(String[] arr){
        int min = Integer.MAX_VALUE;
        for(String i:arr){
            if(min>i.length()){
                min=i.length();
            }
        }
        return min;
    }
    public String longestCommonPrefix_1(String[] strs) {
        int Min = mini(strs);

        char[] arr = strs[0].toCharArray();

        int min=Integer.MAX_VALUE;
        int ans=0;

        for(String j:strs){
            for(int i=0;i<Min;i++){
                if(arr[i]==j.charAt(i)){
                    ans++;
                }else{
                    break;
                }
            }
            if(min>ans){
                min=ans;
            }
            ans=0;
        }
        return strs[0].substring(0,min);
    }



    //Approach 2 :
    public String longestCommonPrefix_2(String[] strs) {
        char ch;
        if (strs == null || strs.length == 0)
            return "";

        for(int i=0 ; i<strs[0].length() ; i++){
            ch = strs[0].charAt(i);

            for(int j=1 ; j<strs.length ; j++)
            {
                if(strs[j].length() == i || strs[j].charAt(i)!=ch) {

                    return strs[0].substring(0,i);

                }
            }
        }
        return strs[0];
    }



    //Approach 3 : not efficient
    public String lcp(String str1,String str2){

        int n1 = str1.length();
        int n2 = str2.length();
        String res="";

        for(int i=0,j=0 ; i<n1 && j<n2 ; i++,j++){
            if(str1.charAt(i) != str2.charAt(j)){
                break;
            }
            res += str1.charAt(i);
        }
        return res;
    }
    public String longestCommonPrefix_3(String[] strs) {
        String prefix = strs[0];

        for(int i=1 ; i<strs.length ; i++){
            prefix = lcp(prefix,strs[i]);
        }
        if(prefix.length()>0){
            return prefix;
        }
        else{
            return "";
        }
    }



    //Approach 4 :
    public String longestCommonPrefix_4(String[] strs) {
        String prefix = strs[0];

        for(int index=1 ; index<strs.length ; index++){

            while(strs[index].indexOf(prefix) != 0){
                prefix = prefix.substring(0, prefix.length()-1);
            }
        }
        return prefix;

    }



    //Approach 5 :
    //Write solution using trie concept.



    public static void main(String[] args) {

        /*Ques : Write a function to find the longest common prefix string amongst an array of strings.

                 If there is no common prefix, return an empty string "".


                Example : 1
                Input   : strs = ["flower","flow","flight"]
                Output  : "fl"


                Example : 2
                Input   : strs = ["dog","racecar","car"]
                Output  : ""
                Explanation : There is no common prefix among the input strings.
        * */
    }


}

package Medium;

public class Ques_10 {

    //Ques : Group Shifted String..........                                                   (GFG Ques.)


    //Approach 1 :
    //C++ Code.......
    /*  C/C++ program to print groups of shifted strings together.
        #include <bits/stdc++.h>
        using namespace std;
        const int ALPHA = 26;                          // Total lowercase letter

        // Method to a difference string for a given string.
        // If string is "adf" then difference string will be "cb" (first difference 3 then difference 2)
        string getDiffString(string str)
        {
            string shift = "";
            for (int i = 1; i < str.length(); i++)
            {
                int dif = str[i] - str[i-1];
                if (dif < 0)
                    dif += ALPHA;

                // Representing the difference as char
                shift += (dif + 'a');
            }

            // This string will be 1 less length than str
            return shift;
        }

        // Method for grouping shifted string
        void groupShiftedString(string str[], int n)
        {
            // map for storing indices of string which are in same group
            map< string, vector<int> > groupMap;
            for (int i = 0; i < n; i++)
            {
                string diffStr = getDiffString(str[i]);
                groupMap[diffStr].push_back(i);
            }

            // iterating through map to print group
            for (auto it=groupMap.begin(); it!=groupMap.end(); it++)
            {
                vector<int> v = it->second;
                for (int i = 0; i < v.size(); i++)
                    cout << str[v[i]] << " ";

                cout << endl;
            }
        }

        // Driver method to test above methods
        int main()
        {
            string str[] = { "acd", "dfg", "wyz", "yab", "mop", "bdfh", "a", "x", "moqs" };
            int n = sizeof(str)/sizeof(str[0]);
            groupShiftedString(str, n);
            return 0;
        }
    *
    * */





    public static void main(String[] args) {

        /*Ques : Given an array of strings (all lowercase letters), the task is to group them in such a way that
                 all strings in a group are shifted versions of each other.
                 Two string S and T are called shifted if,
                    S.length = T.length
                    and
                    S[i] = T[i] + K      for  1 <= i <= S.length  for a constant integer K


                For example : Strings {acd, dfg, wyz, yab, mop} are shifted versions of each other.


                Example : 1
                Input   : str[] = {"acd", "dfg", "wyz", "yab", "mop", "bdfh", "a", "x", "moqs"};

                Output  : a x
                         acd dfg wyz yab mop bdfh moqs
                         All shifted strings are grouped together.

                Recommended : Please try your approach on {IDE} first, before moving on to the solution.
                              We can see a pattern among the string of one group, the difference between consecutive
                              characters for all character of the string are equal.
                              As in the above example take acd, dfg and mop
                                a c d -> 2 1
                                d f g -> 2 1
                                m o p -> 2 1
                              Since the differences are the same, we can use this to identify strings that belong
                              to the same group. The idea is to form a string of differences as key.
                              If a string with the same difference string is found, then this string also belongs
                              to the same group. For example, the above three strings have the same difference string,
                              which is “21”.
        *
        *
        * */
    }




}

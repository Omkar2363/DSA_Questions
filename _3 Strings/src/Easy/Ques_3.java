package Easy;

import java.util.Stack;
import java.util.HashMap;
import java.util.Map;

public class Ques_3 {

    //Ques : Valid Parentheses.......                                                    (Leet code Ques no. = 20)


    //Approach 1 : By using stack.....
    public boolean isValid_11(String s) {
        if(s.length()%2!=0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(c=='(' || c=='{' || c=='[') {
                stack.push(c);
            }
            else {
                if(stack.isEmpty())
                    return false;
                if(c==')'&&stack.peek()=='(' ||
                        c=='}'&&stack.peek()=='{' ||
                        c==']'&&stack.peek()=='[')

                    stack.pop();
                else
                    return false;
            }

        }
        return stack.isEmpty();

    }
    //Approach 1 : same approach as above but different code
    public boolean isValid_12(String s) {
        if(s.length()%2!=0) return false;

        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray())
        {
            if(c=='(' || c=='{' || c=='[') stack.push(c);
            else if(c==')' && !stack.isEmpty() && stack.peek()=='(') stack.pop();
            else if(c=='}' && !stack.isEmpty() && stack.peek()=='{') stack.pop();
            else if(c==']' && !stack.isEmpty() && stack.peek()=='[') stack.pop();
            else return false;

        }
        return stack.isEmpty();
    }
    //Approach 1 : same approach as above but different code
    public boolean isValid_13(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }

            else {
                if (stack.isEmpty()) return false;

                char last = stack.pop();
                if (c == ']' && last == '[' ||
                        c == '}' && last == '{' ||
                        c == ')' && last == '(') {}    // do nothing

                else return false;
            }
        }

        return stack.isEmpty();
    }




    //Approach 2 : By using map and stack.....
    public boolean isValid_21(String s) {
        Stack<Character> stack = new Stack();
        Map<Character, Character> map = new HashMap();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        for (int i=0; i<s.length(); i++) {
            if (map.keySet().contains(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()) return false;

                if (map.get(stack.pop()) != s.charAt(i)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();

    }
    //Approach 2 : same approach as above but different code
    public boolean isValid_22(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for(char ch: chars){
            if(map.containsKey(ch)){
                stack.push(map.get(ch));
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                if(ch != stack.peek()){
                    return false;
                }else{
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();
    }



    //Approach 3 : By simple pattern matching.... Most efficient approach
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()) {
            switch (c) {
                case '('     -> stack.push(')');
                case '['     -> stack.push(']');
                case '{'     -> stack.push('}');
                default       -> {
                    if(stack.isEmpty() || stack.pop() != c) return false;
                }
            }
        }

        return stack.isEmpty();
    }



    public static void main(String[] args) {

        /*Ques : Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
                 determine if the input string is valid.

                 An input string is valid if:

                 Open brackets must be closed by the same type of brackets.
                 Open brackets must be closed in the correct order.
                 Every close bracket has a corresponding open bracket of the same type.


                Example : 1
                Input   : s = "()"
                Output  : true


                Example : 2
                Input   : s = "()[]{}"
                Output  : true


                Example : 3
                Input   : s = "(]"
                Output  : false

        * */
    }


}

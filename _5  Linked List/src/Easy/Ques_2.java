package Easy;

import java.util.HashSet;

public class Ques_2 {

    //Ques : Linked List Cycle..........                                                   (Leet code Ques no. - 141)


    //Approach 1 : Two Pointer Approach......(Floyd's Cycle Detection Algorithm)           T.C. = O(n),  S.C. = O(1)
    //Definition for singly-linked list.
    class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
      }
    public class Solution {
        public boolean hasCycle(ListNode head) {
            if(head == null){
                return false;
            }
            ListNode slow = head;
            ListNode fast = head.next;
            while(slow != fast){
                if(fast == null || fast.next == null){
                    return false;
                }
                slow = slow.next;
                fast = fast.next.next;
            }
            return true;
        }
    }



    //Approach 2 : Using HashSet Solution.......                                          T.C. = O(n),  S.C. = O(n)
    //Definition for singly-linked list.
    class ListNode_2 {
        int val;
        ListNode_2 next;
        ListNode_2 (int x) {
            val = x;
            next = null;
        }
    }
    public class Solution_2 {
        public boolean hasCycle(ListNode_2 head2) {
            HashSet<ListNode_2> set = new HashSet<>();

            while(head2 != null){
                if(set.contains(head2))
                {
                    return true;
                }

                set.add(head2);
                head2 = head2.next;
            }
            return false;
        }
    }





    //Follow the link for more approaches :
    //Link : https://practice.geeksforgeeks.org/problems/detect-loop-in-linked-list/1

    public static void main(String[] args) {

        /*Ques : Given head, the head of a linked list, determine if the linked list has a cycle in it.

                 There is a cycle in a linked list if there is some node in the list that can be reached
                 again by continuously following the next pointer. Internally, pos is used to denote the
                 index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

                 Return true if there is a cycle in the linked list. Otherwise, return false.

            Example : 1
            Input   : head = [3,2,0,-4], pos = 1
            Output  : true
            Explanation : There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).


            Example : 2
            Input   : head = [1,2], pos = 0
            Output  : true
            Explanation : There is a cycle in the linked list, where the tail connects to the 0th node.

            Example : 3
            Input   : head = [1], pos = -1
            Output  : false
            Explanation : There is no cycle in the linked list.

        *
        *
        *
        *
        * */
    }


}

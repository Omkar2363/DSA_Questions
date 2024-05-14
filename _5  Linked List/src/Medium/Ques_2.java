package Medium;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Ques_2 {

    //Ques : Reorder List......                                                         (GFG Ques.)

    //Approach 1 :                                                                      T.C. = O(n),   S.C. = O(1)
    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    class Solution {
        public void reorderList(ListNode head) {

            ListNode mid = getMidPointer(head);
            ListNode second = reverse(mid);
            ListNode first = head;

            //first and second denote first head and second head respectively
            merge(first, second);
        }

        private void merge(ListNode first, ListNode second)
        {
            while (first != null && second != null) {
                ListNode temp = first.next;
                first.next = second;
                first = temp;

                temp = second.next;
                second.next = first;
                second = temp;

            }
            if (first != null)
                first.next = null;
        }

        private ListNode reverse(ListNode head) {

            ListNode curr = head;
            ListNode prev = null;

            while (curr != null) {
                ListNode next = curr.next;
                curr.next = prev;

                prev = curr;
                curr = next;
            }
            return prev;
        }

        private ListNode getMidPointer(ListNode head) {

            ListNode slow = head;
            ListNode fast = head;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }
    }




    //Approach 2 : Efficient code......                                                T.C. = O(n),  S.C. = O(1)
    /* Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }*/
    class Solution_2 {
        public void reorderList(ListNode head) {

            if(head == null || head.next == null)
                return;

            ListNode mid = getMiddle(head);
            ListNode end = reverseList(mid);
            ListNode start = head;

            while(start != null && end != null){

                ListNode temp = start.next;
                start.next = end;
                start = temp;
                temp = end.next;
                end.next = start;
                end = temp;
            }

            if(start != null){
                start.next = null;
            }
        }

        public ListNode reverseList(ListNode head) {
            if(head == null){
                return head;
            }

            ListNode prev = null;
            ListNode curr = head;
            ListNode later = curr.next;

            while(curr != null){
                curr.next = prev;
                prev = curr;
                curr = later;
                if(later !=null){
                    later = later.next;
                }
            }

            return prev;
        }

        public ListNode getMiddle(ListNode head){
            ListNode first = head;
            ListNode second = head;
            while(first != null && first.next != null){
                first = first.next.next;
                second = second.next;
            }

            return second;
        }
    }



    //Approach 3 : Recursive approach......                                            T.C. = O(n),  S.C. = O(n)
    /* Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }*/
    class Solution_3 {
        ListNode help(ListNode head, int s, int e, Map<Integer,ListNode> map){
            //Base Case :
            if(s > e)
                return null;

            //Recursive relation
            ListNode slist = help(head.next,s+1,e-1,map);

            //Processing
            ListNode start = map.get(s);
            ListNode end = map.get(e);

            start.next = end;
            end.next = slist;

            return start;

        }
        public void reorderList(ListNode head) {

            Map<Integer,ListNode> map = new HashMap<>();           //index  maps to Node
            ListNode temp = head;
            int i=0;

            while(temp != null){
                map.put(i,temp);
                i++;
                temp = temp.next;
            }
            int length = i;                                      //length

            help(head,0,length-1,map);

        }
    }
    //Efficient Recursive code........                                                 T.C. = O(n),  S.C. = O(1)
    class Solution_32 {
        public static void reorderList(ListNode head) {

            if (head == null || head.next == null)
                return;

            //Find the middle of the list
            ListNode slow = head;
            ListNode fast = head;
            while (fast.next != null && fast.next.next != null)
            {
                slow = slow.next;
                fast = fast.next.next;
            }

            //Reverse the half after middle
            ListNode preMiddle = slow;
            ListNode preCurrent = slow.next;
            while (preCurrent.next != null)
            {
                ListNode current = preCurrent.next;
                preCurrent.next = current.next;
                current.next = preMiddle.next;
                preMiddle.next = current;
            }

            //Start reorder one by one
            slow = head;
            fast = preMiddle.next;
            while (slow != preMiddle)
            {
                preMiddle.next = fast.next;
                fast.next = slow.next;
                slow.next = fast;
                slow = fast.next;
                fast = preMiddle.next;
            }
        }

    }



    //Approach 4 : By using Deque...........                                           T.C. = O(n),  S.C. = O(1)
    /*
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution_4 {
        public  void reorderList(ListNode head) {                   // See the error by making it static
            Deque<ListNode> q = new LinkedList<>();
            ListNode temp = head;

            while (temp != null) {
                q.addLast(temp);
                temp = temp.next;
            }
            ListNode dummy = new ListNode(-1);
            ListNode newHead = dummy;

            while (!q.isEmpty()) {
                ListNode first = q.removeFirst();
                first.next = null;
                dummy.next = first;
                dummy = dummy.next;
                if (!q.isEmpty()) {
                    ListNode last = q.removeLast();
                    last.next = null;
                    dummy.next = last;
                    dummy = dummy.next;
                }
            }
            head = newHead.next;
        }
    }




    public static void main(String[] args) {

        /*Ques : You are given the head of a singly linked-list. The list can be represented as :

            L0 → L1 → … → Ln - 1 → Ln
            Reorder the list to be on the following form:

            L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
            You may not modify the values in the list's nodes. Only nodes themselves may be changed.


            Example : 1
            Input   : head = [1,2,3,4]
            Output  : [1,4,2,3]

            Example : 2
            Input   : head = [1,2,3,4,5]
            Output  : [1,5,2,4,3]

            //Follow the link for visual representation :
            //Link : https://leetcode.com/problems/reorder-list/
        * */
    }


}

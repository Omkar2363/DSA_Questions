package Easy;

public class Ques_1 {

    //Ques : Reverse Linked_List.........                                               (Leet code Ques no. - 206)

    //Approach 1 : Iterative Solution......                                             T.C. = O(n),  S.C. = O(1)
    //Definition for singly-linked list.
    public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode reverseList_1(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;

        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }



    //Approach 2 : Recursive Solution..........                                        T.C. = O(n),  S.C. = O(n)
    public ListNode reverseList_2(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode newHead = reverseList_2(head.next);

        head.next.next = head;
        head.next = null;

        return newHead;
    }




    public static void main(String[] args) {

        /*Ques : Given the head of a singly linked list, reverse the list, and return the reversed list.


            Example : 1
            Input   : head = [1,2,3,4,5]
            Output  : [5,4,3,2,1]

            Example : 2
            Input   : head = [1,2]
            Output  : [2,1]

            Example : 3
            Input   : head = []
            Output  : []
        *
        *
        * */
    }



}

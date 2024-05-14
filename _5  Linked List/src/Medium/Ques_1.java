package Medium;

public class Ques_1 {

    //Ques : Remove Nth Node From End of List......... Important                                (GFG Ques.)


    //Approach 1 :
    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode temp = head;
            ListNode first = head;
            ListNode second = first.next;
            int count=0;
            while(temp != null){
                count++;
                temp=temp.next;
            }
            count = count-n;

            while(count!=1 && second!=null){
                first=first.next;
                second=second.next;
                count--;
            }
            if(second == null){
                head=head.next;
            }else{
                first.next=second.next;
            }
            return head;
        }
    }


    //Approach 2 :
    /* Definition for singly-linked list.
    public class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }*/
    class Solution_2 {
        public ListNode removeNthFromEnd(ListNode head, int n) {

            int length = 0;
            ListNode temp = head;
            while(temp != null)
            {
                temp = temp.next;
                length++;
            }

            if(length == n)
                return head.next;

            // Reach to the previous node of the last node
            temp = head;
            length = length-n-1;
            while(temp.next != null && length != 0){
                temp = temp.next;
                length--;
            }

            // remove
            if(temp.next != null)
                temp.next = temp.next.next;

            return head;
        }
    }


    //Approach 3 : Recursive Solution......
    /* Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    */
    class Solution_3 {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if(head.next == null) {
                return null;
            }
            if(findAndRemove(head, head, n) == -1) {            // delete head node
                head = head.next;
            }
            return head;
        }

        public int findAndRemove(ListNode head, ListNode node, int n) {
            if(node.next == null) {
                return 1;
            }

            int length = findAndRemove(head, node.next, n) + 1;
            if(length == n+1) {
                node.next = node.next.next;                   //delete node
            }
            else if(head == node && length == n) {
                return -1;                                   // delete head node
            }

            return length;
        }
    }



    public static void main(String[] args) {

        /*Ques : Given the head of a linked list, remove the nth node from the end of the list and return its head.


            Example : 1
            Input   : head = [1,2,3,4,5], n = 2
            Output  : [1,2,3,5]

            Example : 2
            Input   : head = [1], n = 1
            Output  : []

            Example : 3
            Input   : head = [1,2], n = 1
            Output  : [1]

        *
        * */
    }


}

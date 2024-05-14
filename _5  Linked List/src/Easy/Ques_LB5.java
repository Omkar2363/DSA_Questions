package Easy;

public class Ques_LB5 {

    //Ques : Middle of the Linked List........                                           (Leet code Ques no. - 876)


    //Approach 1 : Iterative and count approach......                                    T.C. = O(n),  S.C. = O(1)
    //Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    class Solution {
        public ListNode middleNode(ListNode head) {
            int count = 0;
            ListNode temp = head;
            while(temp != null)
            {
                count++;
                temp = temp.next;
            }
            int middle = count/2;
            while(middle > 0)
            {
                head = head.next;
                middle--;
            }
            return head;
        }
    }



    //Approach 2 : Two-pointer Approach (slow and fast  pointer).......                T.C. = O(n),  S.C. = O(1)
    class ListNode_2 {
        int val;
        ListNode next;
        ListNode_2() {}
        ListNode_2(int val) { this.val = val; }
        ListNode_2(int val, ListNode next) { this.val = val; this.next = next; }
    }
    class Solution_2 {
        public ListNode middleNode(ListNode head) {
            if(head.next == null)
                return head;

            ListNode fast = head;
            ListNode slow = head;
            while(fast != null && fast.next != null)
            {
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }
    }




    public static void main(String[] args) {

        /*Ques : Given the head of a singly linked list, return the middle node of the linked list.

                 If there are two middle nodes, return the second middle node.


            Example : 1
            Input   : head = [1,2,3,4,5]
            Output  : [3,4,5]
            Explanation : The middle node of the list is node 3.


            Example : 2
            Input   : head = [1,2,3,4,5,6]
            Output  : [4,5,6]
            Explanation : Since the list has two middle nodes with values 3 and 4, we return the second one.

        */
    }


}

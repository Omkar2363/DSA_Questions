package Easy;

public class Ques_3 {

    //Ques : Merge Two Sorted Array........                                             (Leet code Ques no.- 21)


    //Approach 1 : Iterative Approach.....                                              T.C. = O(n+m),  S.C. = O(1)
    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if(list1 == null) {
                return list2;
            }

            if(list2 == null) {
                return list1;
            }

            ListNode head = new ListNode(0);
            ListNode curr = head;

            while(list1!= null && list2 != null) {
                if(list1.val < list2.val) {
                    curr.next = list1;
                    list1 = list1.next;
                }else {
                    curr.next = list2;
                    list2 = list2.next;
                }
                curr = curr.next;
            }

            if(list1 != null) {
                curr.next = list1;
            } else {
                curr.next = list2;
            }
            return head.next;

        }
    }



    //Approach 2 : Recursive Solution....                                              T.C. = O(n+m),  S.C. = O(1)
    //Definition for singly-linked list.
    public class ListNode_2 {
        int val;
        ListNode_2 next;
        ListNode_2() {}
        ListNode_2(int val) { this.val = val; }
        ListNode_2(int val, ListNode_2 next) { this.val = val; this.next = next; }
    }
    class Solution_2 {
        public ListNode_2 mergeTwoLists(ListNode_2 list1, ListNode_2 list2) {
            //Base Case
            if(list1 == null)
                return list2;
            if(list2 == null)
                return list1;

            //Recursive Relation
            if(list1.val < list2.val){
                list1.next = mergeTwoLists(list1.next, list2);
                return list1;
            }
            else{
                list2.next = mergeTwoLists(list1, list2.next);
                return list2;
            }
        }
    }




    public static void main(String[] args) {

        /*Ques : You are given the heads of two sorted linked lists list1 and list2.

                 Merge the two lists in a one sorted list. The list should be made by splicing together
                 the nodes of the first two lists.

                 Return the head of the merged linked list.


            Example : 1
            Input   : list1 = [1,2,4], list2 = [1,3,4]
            Output  : [1,1,2,3,4,4]

            Example : 2
            Input   : list1 = [], list2 = []
            Output  : []

            Example : 3
            Input   : list1 = [], list2 = [0]
            Output  : [0]

        *
        * */
    }
}

package Easy;

public class Ques_4 {

    //Ques : Delete without head pointer......                                              (GFG Ques.)
    //       (Given only a pointer/reference to a node to be deleted in a singly linked list, how do you delete it?


    //Approach 1 :
    /*  A simple solution is to traverse the linked list until you find the node you want to delete.
        But this solution requires a pointer to the head node, which contradicts the problem statement.

        The fast solution is to copy the data from the next node to the node to be deleted and delete the next node.
        Something like the following  :

        // Find next node using next pointer
        struct Node *temp  = node_ptr->next;

        // Copy data of next node to this node
        node_ptr->data  = temp->data;

        // Unlink next node
        node_ptr->next  = temp->next;

        // Delete next node
        free(temp);

    *
    * */
    static class LinkedList {
        Node head;                                              // head of the list
        class Node {
            int data;
            Node next;
            Node(int d)
            {
                data = d;
                next = null;
            }
        }

        /* Given a reference to the head of a list and an int,
            inserts a new Node on the front of the list. */
        public void push(int new_data)
        {
            /* 1. alloc the Node and put the data */
            Node new_Node = new Node(new_data);

            /* 2. Make next of new Node as head */
            new_Node.next = head;

            /* 3. Move the head to point to new Node */
            head = new_Node;
        }

        /* This function prints contents of linked list starting from the given Node */
        public void printList()
        {
            Node tNode = head;
            while (tNode != null) {
                System.out.print(tNode.data + " ");
                tNode = tNode.next;
            }
        }

        public void deleteNode(Node Node_ptr)
        {
            Node temp = Node_ptr.next;
            Node_ptr.data = temp.data;
            Node_ptr.next = temp.next;
            temp = null;
        }

        public static void main_1(String[] args)
        {
            LinkedList llist = new LinkedList();

        /* Use push() to construct below list  1->12->1->4->1  */
            llist.push(1);
            llist.push(4);
            llist.push(1);
            llist.push(12);
            llist.push(1);

            System.out.println("Before deleting");
            llist.printList();

        /* Deleting the head itself. You can check for more cases */
            llist.deleteNode(llist.head);

            System.out.println("\nAfter Deleting");
            llist.printList();
        }
    }
    /*  Time Complexity :
            For printing linked list : O(N)
            For inserting node       : O(1)
            For deleting node        : O(N)
            Auxiliary Space          : O(1)
    * */


    //Note : This solution does not work if the node to be deleted is the last node of the list.
    //       To make this solution work, we can mark the end node as a dummy node. But the programs/functions
    //       that are using this function should also be modified.



    //Follow the link  and complete it...
    //Link : https://www.geeksforgeeks.org/given-only-a-pointer-to-a-node-to-be-deleted-in-a-singly-linked-list-how-do-you-delete-it/


    public static void main(String[] args) {

        /*Ques : Given a pointer to a node to be deleted, delete the node.
                 Note that we don’t have a pointer to the head node.
        *
        * */
    }



}

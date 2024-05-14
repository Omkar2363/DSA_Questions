package Easy;

import java.util.ArrayList;

public class Ques_Q_LB3 {

    //Ques : Circular Queue (Introduction and Array Implementation)..........                (GFG Ques.)


    //Approach 1 :
    // Java program for insertion and deletion in Circular Queue
    static class CircularQueue{

        // Declaring the class variables.
        private int size, front, rear;

        // Declaring array list of integer type.
        private ArrayList<Integer> queue = new ArrayList<Integer>();

        // Constructor
        CircularQueue(int size)
        {
            this.size = size;
            this.front = this.rear = -1;
        }

        // Method to insert a new element in the queue.
        public void enQueue(int data)
        {

            // Condition if queue is full.
            if((front == 0 && rear == size - 1) || (rear == (front - 1) % (size - 1)))
            {
                System.out.print("Queue is Full");
            }

            // condition for empty queue.
            else if(front == -1)
            {
                front = 0;
                rear = 0;
                queue.add(rear, data);
            }

            else if(rear == size - 1 && front != 0)
            {
                rear = 0;
                queue.set(rear, data);
            }

            else
            {
                rear = (rear + 1);

                // Adding a new element if
                if(front <= rear)
                {
                    queue.add(rear, data);
                }

                // Else updating old value
                else
                {
                    queue.set(rear, data);
                }
            }
        }

        // Function to dequeue an element from nth queue.
        public int deQueue()
        {
            int temp;

            // Condition for empty queue.
            if(front == -1)
            {
                System.out.print("Queue is Empty");

                // Return -1 in case of empty queue
                return -1;
            }

            temp = queue.get(front);

            // Condition for only one element
            if(front == rear)
            {
                front = -1;
                rear = -1;
            }

            else if(front == size - 1)
            {
                front = 0;
            }
            else
            {
                front = front + 1;
            }

            // Returns the dequeued element
            return temp;
        }

        // Method to display the elements of queue
        public void displayQueue()
        {

            // Condition for empty queue.
            if(front == -1)
            {
                System.out.print("Queue is Empty");
                return;
            }

            // If rear has not crossed the max size or queue rear is still greater than front.
            System.out.print("Elements in the " + "circular queue are: ");

            if(rear >= front)
            {

                // Loop to print elements from front to rear.
                for(int i = front; i <= rear; i++)
                {
                    System.out.print(queue.get(i));
                    System.out.print(" ");
                }
                System.out.println();
            }

            // If rear crossed the max index and indexing has started in loop
            else
            {

                // Loop for printing elements from front to max size or last index
                for(int i = front; i < size; i++)
                {
                    System.out.print(queue.get(i));
                    System.out.print(" ");
                }

                // Loop for printing elements from 0th index till rear position
                for(int i = 0; i <= rear; i++)
                {
                    System.out.print(queue.get(i));
                    System.out.print(" ");
                }
                System.out.println();
            }
        }

        // Driver code
        public static void main_1(String[] args)
        {

            // Initialising new object of CircularQueue class.
            CircularQueue q = new CircularQueue(5);

            q.enQueue(14);
            q.enQueue(22);
            q.enQueue(13);
            q.enQueue(-6);

            q.displayQueue();

            int x = q.deQueue();

            // Checking for empty queue.
            if(x != -1)
            {
                System.out.print("Deleted value = ");
                System.out.println(x);
            }

            x = q.deQueue();

            // Checking for empty queue.
            if(x != -1)
            {
                System.out.print("Deleted value = ");
                System.out.println(x);
            }

            q.displayQueue();

            q.enQueue(9);
            q.enQueue(20);
            q.enQueue(5);

            q.displayQueue();

            q.enQueue(20);
        }
    }


    /*Time Complexity :
                Time complexity of enQueue(), deQueue() operation is O(1),
                as there is no loop in  any of the operation.

    */




    public static void main(String[] args) {

        /*Ques : What is a Circular Queue......?
                    A Circular Queue is a special version of queue where the last element of the queue is
                    connected to the first element of the queue forming a circle.

                    The operations are performed based on FIFO (First In First Out) principle.
                    It is also called ‘Ring Buffer’.


                 * Operations on Circular Queue :
                    1. Front : Get the front item from queue.
                    2. Rear  : Get the last item from queue.
                    3. enQueue(value) This function is used to insert an element into the circular queue.
                       In a circular queue, the new element is always inserted at Rear position.
                           - Check whether queue is Full :
                                Check ((rear == SIZE-1 && front == 0) || (rear == front-1)).
                           - If it is full then display Queue is full. If queue is not full then,
                                check if (rear == SIZE – 1 && front != 0) if it is true then set rear=0 and insert element.

                    4. deQueue() This function is used to delete an element from the circular queue.
                       In a circular queue, the element is always deleted from front position.
                           - Check whether queue is Empty means check (front==-1).
                           - If it is empty then display Queue is empty. If queue is not empty then step 3
                           - Check if (front==rear) if it is true then set front = rear = -1
                                else check if (front==size-1), if it is true then set front=0 and return the element.



*/
    }



}

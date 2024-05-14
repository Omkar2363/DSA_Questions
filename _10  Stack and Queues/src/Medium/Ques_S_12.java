package Medium;

public class Ques_S_12 {

    //Ques : Circular Tour........                                                         (GFG Ques.)


    //Approach 1 : Naive Approach......                                                    T.C. = O(n^2),  S.C. = O(1)
    /*Naive Approach :
        As the capacity of the truck is infinite it is feasible to fill the truck with all the amount
        of petrol available at each petrol pump.

        A Simple Solution is to consider every petrol pumps as a starting point and see if there is a possible tour.
        If we find a starting point with a feasible solution, we return that starting point.
    * */



    //Approach 2 : By using Queue......                                                    T.C. = O(n^2),  S.C. = O(1)
    /*  First Circular Tour Using Queue :
            Instead of checking the whole array for each starting point, we can store the current tour inside a queue.

            At the moment, the current amount of petrol becomes inefficient (i.e., negative) to reach the next petrol pump,
            remove the current starting point from the queue and consider the next point as the new starting point.

            Instead of building a separate queue, we can use the array itself as a queue with the help of start and end
            pointers.

            Note: Each petrol pump will be added in the queue at most twice and will be removed at most once.

        Illustration:

        Below image is a dry run of the above approach:
        //Follow the link for image :
        //Link : https://practice.geeksforgeeks.org/problems/circular-tour/1




        * Follow the below steps to implement the idea :
           - Set two pointers, start = 0 and end = 1 to use the array as a queue.
                -> If the amount of petrol is efficient to reach the next petrol pump then increment
                   the end pointer (circularly).
                -> Otherwise, remove the starting point of the current tour, i.e., increment the start pointer.
           - If the start pointer reaches N then such a tour is not possible. Otherwise, return the starting point
             of the tour.

    * */
    //Java program to find circular tour for a truck
    public class Petrol {
        // A petrol pump has petrol and distance to next petrol pump
        static class petrolPump
        {
            int petrol;
            int distance;

            // constructor
            public petrolPump(int petrol, int distance)
            {
                this.petrol = petrol;
                this.distance = distance;
            }
        }

        // The function returns starting point if there is a possible solution,
        // otherwise returns -1
        static int printTour(petrolPump arr[], int n)
        {
            int start = 0;
            int end = 1;
            int curr_petrol = arr[start].petrol - arr[start].distance;

            // If current amount of petrol in truck becomes less than 0,
            // then remove the starting petrol pump from tour
            while(end != start || curr_petrol < 0)
            {

                // If current amount of petrol in truck becomes less than 0,
                // then remove the starting petrol pump from tour
                while(curr_petrol < 0 && start != end)
                {
                    // Remove starting petrol pump. Change start
                    curr_petrol -= arr[start].petrol - arr[start].distance;
                    start = (start + 1) % n;

                    // If 0 is being considered as start again, then there is no possible solution
                    if(start == 0)
                        return -1;
                }
                // Add a petrol pump to current tour
                curr_petrol += arr[end].petrol - arr[end].distance;

                end = (end + 1)%n;
            }

            // Return starting point
            return start;
        }

        // Driver program to test above functions
        public static void main_2(String[] args)
        {

            petrolPump[] arr = {new petrolPump(6, 4), new petrolPump(3, 6),
                                new petrolPump(7, 3)};

            int start = printTour(arr, arr.length);

            System.out.println(start == -1 ? "No Solution" : "Start = " + start);

        }

    }



    //Approach 3 : Another Efficient Approach......                                       T.C. = O(n),   S.C. = O(1)
    // Java program to find circular tour for a truck
    public class Circular {
        // A petrol pump has petrol and distance to next petrol pump
        static class petrolPump {
            int petrol;
            int distance;
            public petrolPump(int petrol, int distance)
            {
                this.petrol = petrol;
                this.distance = distance;
            }
        }
        // The function returns starting point if there is a possible solution, otherwise returns -1
        static int printTour(petrolPump arr[], int n)
        {
            int start = 0;

            for (int i = 0; i < n; i++) {
                // Identify the first petrol pump from where we might get a full circular tour
                if (arr[i].petrol >= arr[i].distance) {
                    start = i;
                    break;
                }
            }

            // To store the excess petrol
            int curr_petrol = 0;
            int i;
            for (i = start; i < n;) {

                curr_petrol  += (arr[i].petrol - arr[i].distance);

                // If at any point remaining petrol is less than 0,
                // it means that we cannot start our journey from current start
                if (curr_petrol < 0)
                {
                    // We move to the next petrol pump
                    i++;

                    // We try to identify the next petrol pump from where we might get a full circular tour
                    for (; i < n; i++) {
                        if (arr[i].petrol >= arr[i].distance) {

                            start = i;

                            // Reset rem_petrol
                            curr_petrol = 0;

                            break;
                        }
                    }
                }

                else {
                    // Move to the next petrolpump if curr_petrol is >= 0
                    i++;
                }
            }

            // If remaining petrol is less than 0 while we reach the first petrol pump,
            // it means no circular tour is possible
            if (curr_petrol < 0) {
                return -1;
            }

            for (int j = 0; j < start; j++) {

                curr_petrol  += (arr[j].petrol - arr[j].distance);

                // If remaining petrol is less than 0 at any point before we reach initial start,
                // it means no circular tour is possible
                if (curr_petrol < 0) {
                    return -1;
                }
            }

            // If we have successfully reached intial_start, it  means can get a circular tour
            // from final_start, hence return it
            return start;
        }

        // Driver code
        public static void main_2(String[] args)
        {

            petrolPump arr[]  = { new petrolPump(6, 4), new petrolPump(3, 6),
                                  new petrolPump(7, 3) };

            int n = arr.length;
            int start = printTour(arr, n);

            System.out.println(start == -1   ?  "No solution"  : "Start = " + start);
        }
    }




    //Approach 4 : By using Single Loop....                                              T.C. = O(n),   S.C. = O(1)
    /* First Circular Tour by using Single Loop :
         The idea is similar to the above approach.

         Here we will use another variable to substitute the extra loop from start till the latest
         found start point. The variable will store the sum of utilized petrol from 0 till the latest start petrol pump.
    * */
    // Java program to find circular tour for a truck
    class GFG {

        // A petrol pump has petrol and distance to next petrol pump
        static class petrolPump {
            int petrol;
            int distance;
            petrolPump(int a, int b) {
                this.petrol = a;
                this.distance = b;
            }
        }

        // The function returns starting point if there is a possible solution, otherwise returns -1
        static int printTour(petrolPump p[], int n)
        {
            // deficit is used to store the value of the capacity as
            // soon as the value of capacity becomes negative so as
            // not to traverse the array twice in order to get the solution
            int start = 0, deficit = 0;
            int capacity = 0;
            for (int i = 0; i < n; i++) {
                capacity += p[i].petrol - p[i].distance;
                if (capacity < 0)
                {
                    // If this particular step is not done then the between steps would be redundant
                    start = i + 1;
                    deficit += capacity;
                    capacity = 0;
                }
            }
            return (capacity + deficit >= 0) ? start : -1;
        }

        // Driver code
        public static void main_4(String[] args) {
            petrolPump arr[] = { new petrolPump(6, 4), new petrolPump(3, 6),
                                 new petrolPump(7, 3) };

            int n = arr.length;
            int start = printTour(arr, n);

            if (start == -1)
                System.out.print("No solution");
            else
                System.out.print("Start = " + start);

        }
    }



    public static void main(String[] args) {

        /*Ques : Suppose there is a circle. There are N petrol pumps on that circle. You will be given two sets of data.
                    1. The amount of petrol that every petrol pump has.
                    2. Distance from that petrol pump to the next petrol pump.

                Find a starting point where the truck can start to get through the complete circle without exhausting
                its petrol in between.
                Note :  Assume for 1 litre petrol, the truck can go 1 unit of distance.


            Example : 1
            Input   : N = 4
                      Petrol = 4 6 7 4
                      Distance = 6 5 3 5
            Output  : 1
            Explanation : There are 4 petrol pumps with amount of petrol and distance to next
                          petrol pump value pairs as {4, 6}, {6, 5}, {7, 3} and {4, 5}.
                          The first point from where truck can make a circular tour is 2nd petrol pump.
                          Output in this case is 1 (index of 2nd petrol pump).


            Your Task :
            Your task is to complete the function tour() which takes the required data as inputs and returns an integer
            denoting a point from where a truck will be able to complete the circle (The truck will stop at each
            petrol pump, and it has infinite capacity). If there exists multiple such starting points, then the function
            must return the first one out of those. (return -1 otherwise)

            Expected Time Complexity : O(N)
            Expected Auxiliary Space : O(1)
        * */
    }




}

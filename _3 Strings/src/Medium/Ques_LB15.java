package Medium;

public class Ques_LB15 {

    //Ques : Function to find Number of customers who could not get a computer.........          (GFG Ques.)



    //Approach 1 :                                                                               T.C. = O(n)
    class GFG_1{
        static int MAX_CHAR = 26;

        // n is number of computers in cafe.
        // 'seq' is given sequence of customer entry, exit events
        static int runCustomerSimulation(int n, char []seq)
        {
            // seen[i] = 0, indicates that customer 'i' is not in cafe
            // seen[1] = 1, indicates that customer 'i' is in cafe but
            //              computer is not assigned yet.
            // seen[2] = 2, indicates that customer 'i' is in cafe and
            //              has occupied a computer.
            char []seen = new char[MAX_CHAR];

            // Initialize result which is number of customers who could not get any computer.
            int res = 0;

            int occupied = 0;                       // To keep track of occupied computers

            // Traverse the input sequence
            for (int i=0; i< seq.length; i++)
            {
                // Find index of current character in seen[0...25]
                int ind = seq[i] - 'A';

                // If First occurrence of 'seq[i]'
                if (seen[ind] == 0)
                {
                    // set the current character as seen
                    seen[ind] = 1;

                    // If number of occupied computers is less than n,
                    // then assign a computer to new customer
                    if (occupied < n)
                    {
                        occupied++;

                        // Set the current character as occupying a computer
                        seen[ind] = 2;
                    }

                    // Else this customer cannot get a computer, increment result
                    else
                        res++;
                }

                // If this is second occurrence of 'seq[i]'
                else
                {

                    // Decrement occupied only if this customer was using a computer
                    if (seen[ind] == 2)
                        occupied--;
                    seen[ind] = 0;
                }
            }
            return res;
        }

        // Driver program
        public static void main_1(String[] args)
        {
            System.out.println(runCustomerSimulation(2, "ABBAJJKZKZ".toCharArray()));
            System.out.println(runCustomerSimulation(3, "GACCBDDBAGEE".toCharArray()));
            System.out.println(runCustomerSimulation(3, "GACCBGDDBAEE".toCharArray()));
            System.out.println(runCustomerSimulation(1, "ABCBCA".toCharArray()));
            System.out.println(runCustomerSimulation(1, "ABCBCADEED".toCharArray()));
        }
    }



    public static void main(String[] args) {

        /*Ques : Write a function “runCustomerSimulation” that takes following two inputs :
                   1. An integer ‘n’ : total number of computers in a cafe and a string.
                   2. A sequence of uppercase letters ‘seq’: Letters in the sequence occur in pairs.
                      The first occurrence indicates the arrival of a customer; the second indicates the departure
                      of that same customer.

                      A customer will be serviced if there is an unoccupied computer. No letter will occur more than two times.
                      Customers who leave without using a computer always depart before customers
                      who are currently using the computers. There are at most 20 computers per cafe.

                   For each set of input the function should output a number telling how many customers,
                   if any walked away without using a computer. Return 0 if all the customers were able to use a computer.

                   runCustomerSimulation (2, “ABBAJJKZKZ”)   should return 0
                   runCustomerSimulation (3, “GACCBDDBAGEE”) should return 1  as ‘D’ was not able to get any computer
                   runCustomerSimulation (3, “GACCBGDDBAEE”) should return 0
                   runCustomerSimulation (1, “ABCBCA”)       should return 2 as ‘B’ and ‘C’ were not able to get any computer.
                   runCustomerSimulation(1, “ABCBCADEED”)    should return 3 as ‘B’, ‘C’ and ‘E’ were not able to get any computer.
        *
        *
        * */
    }

}

package Medium;

public class Ques_14 {

    //Ques : Space optimization using bit manipulations                                   (GFG Ques.)

    //Approach 1 : Simple approach                                                        S.C. = O(max(a, b))
    //             Hash the indices in an array from a to b and
    //             mark each of the indices as 1 or 0.
    //             See picture from GFG...Link :  https://www.geeksforgeeks.org/space-optimization-using-bit-manipulations/


    //Approach 2 : Better than simple                                                    S.C. = O(|b-a|).
    //             Save memory, by translating a to 0th index and b to (b-a)th index.
    //             Simply hash |b – a| positions of an array as 0 and 1.

    // Java program to mark numbers as multiple of 2 or 5
    // Driver code
    public static void main_2(String[] args) {
        int a = 2, b = 10;
        int size = Math.abs(b - a) + 1;
        int array[] = new int[size];

        // Iterate through a to b, If it is a multiple of 2 or 5. Mark index in array as 1
        for (int i = a; i <= b; i++)
            if (i % 2 == 0 || i % 5 == 0)
                array[i - a] = 1;

        System.out.println("MULTIPLES of 2" + " and 5:");
        for (int i = a; i <= b; i++)
            if (array[i - a] == 1)
                System.out.printf(i + " ");

        // Output : MULTIPLES of 2 and 5 : 2 4 5 6 8 10
    }



    //Approach 3 : Using Bit Manipulations.
    /*Here is a space optimized which uses bit manipulation technique that can be applied to problems mapping
      binary values in arrays.

      Size of int variable in 64-bit compiler is 4 bytes. 1 byte is represented by 8 bit positions in memory.
      So, an integer in memory is represented by 32 bit positions(4 Bytes) these 32 bit positions can be used
      instead of just one index to hash binary values.
    * */
    // index >> 5 corresponds to dividing index by 32 index & 31 corresponds to modulo operation of index by 32
    // Function to check value of bit position whether it is zero or one
    static boolean checkBit(int array[], int index) {
        int val = array[index >> 5] & (1 << (index & 31));
        if (val == 0)
            return false;
        return true;
    }

    // Sets value of bit for corresponding index
    static void setBit(int array[], int index) {
        array[index >> 5] |= (1 << (index & 31));
    }

    // Driver code
    public static void main_3(String args[]) {
        int a = 2, b = 10;
        int size = Math.abs(b - a);

        // Size that will be used is actual_size/32 ceil is used to initialize the array with positive number
        size = (int) Math.ceil((double) size / 32);

        // Array is dynamically initialized as we are calculating size at run time
        int[] array = new int[size];

        // Iterate through every index from a to b and call setBit() if it is a multiple of 2 or 5
        for (int i = a; i <= b; i++)
            if (i % 2 == 0 || i % 5 == 0)
                setBit(array, i - a);

        System.out.println("MULTIPLES of 2 and 5:");
        for (int i = a; i <= b; i++)
            if (checkBit(array, i - a))
                System.out.print(i + " ");

        //Output : MULTIPLES of 2 and 5 : 2 4 5 6 8 10
    }




    public static void main(String[] args) {

        /*Ques : There are many situations where we use integer values as index in array to see presence or absence,
                 we can use bit manipulations to optimize space in such problems.

                 Let us consider below problem as an example.
                 Given two numbers say a and b, mark the multiples of 2 and 5 between a and b using less than
                 O(|b – a|) space and output each of the multiples.

                 Note : We have to mark the multiples i.e. save (key, value) pairs in memory such that each key
                        either have value as 1 or 0 representing as multiple of 2 or 5 or not respectively.


                Example : 1
                Input   : 2 10
                Output  : 2 4 5 6 8 10

                Example : 2
                Input   : 60 95
                Output  : 60 62 64 65 66 68 70 72 74 75 76 78
                          80 82 84 85 86 88 90 92 94 95
        *
        * */
    }
}

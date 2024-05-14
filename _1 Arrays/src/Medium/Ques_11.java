package Medium;

import java.util.Stack;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;

public class Ques_11 {

    //Ques : Merge Intervals.....                                                       (Leet code Ques no. - 56)
    //       Merge Overlapping Intervals                                                (GFG Ques)

    //Approach 1 : Merge Overlapping Intervals Using Nested Loop                        T.C. = O(n^2),      S.C. = O(n)


    //Approach 2 : Merge Overlapping Intervals Using Stack...                           T.C. = O(N*log(N)), S.C. = O(n)
    static class Interval {
        int start,end;
        Interval(int start, int end)
        {
            this.start=start;
            this.end=end;
        }
    }

    // The main function that takes a set of intervals, merges overlapping intervals and prints the result
    public static void mergeIntervals(Interval arr[])
    {
        // Test if the given set has at least one interval
        if (arr.length <= 0)
            return;

        // Create an empty stack of intervals
        Stack<Interval> stack=new Stack<>();

        // sort the intervals in increasing order of start time             //NOTE HERE :
        Arrays.sort(arr,new Comparator<Interval>(){
            public int compare(Interval i1,Interval i2)
            {
                return i1.start-i2.start;
            }
        });

        // push the first interval to stack
        stack.push(arr[0]);

        // Start from the next interval and merge if necessary
        for (int i = 1 ; i < arr.length; i++)
        {
            // get interval from stack top
            Interval top = stack.peek();

            // if current interval is not overlapping with stack top,push it to the stack
            if (top.end < arr[i].start)
                stack.push(arr[i]);

                // Otherwise update the ending time of top if ending of current interval is more
            else if (top.end < arr[i].end)
            {
                top.end = arr[i].end;
                stack.pop();
                stack.push(top);
            }
        }

        // Print contents of stack
        System.out.print("The Merged Intervals are: ");
        while (!stack.isEmpty())
        {
            Interval t = stack.pop();
            System.out.print("["+t.start+","+t.end+"] ");
        }
    }

    /*public static void main(String args[]) {
        Interval arr[]=new Interval[4];
        arr[0]=new Interval(6,8);
        arr[1]=new Interval(1,9);
        arr[2]=new Interval(2,4);
        arr[3]=new Interval(4,7);
        mergeIntervals(arr);
    }*/



    //Approach 3 : Merge Overlapping Intervals Space Optimized Approach                 T.C. = O(N*log(N)), S.C. = O(1)
    // An Interval
    static class Interval2    {
        int start,end;

        Interval2(int start, int end)
        {
            this.start=start;
            this.end=end;
        }
    }

    // Function that takes a set of intervals, merges overlapping intervals and prints the result
    public static void mergeIntervals_2(Interval arr[])
    {
        // Sort Intervals in increasing order of start time
        Arrays.sort(arr,new Comparator<Interval>(){
            public int compare(Interval i1,Interval i2)
            {
                return i1.start - i2.start;
            }
        });

        int index = 0;         // Stores index of last element

        // in output array (modified arr[])

        // Traverse all input Intervals
        for (int i=1; i<arr.length; i++)
        {
            // If this is not first Interval and overlaps with the previous one
            if (arr[index].end >=  arr[i].start)
            {
                // Merge previous and current Intervals
                arr[index].end = Math.max(arr[index].end, arr[i].end);
            }
            else {
                index++;
                arr[index] = arr[i];
            }
        }

        // Now arr[0...index-1] stores the merged Intervals
        System.out.print("The Merged Intervals are: ");
        for (int i = 0; i <= index; i++)
        {
            System.out.print("[" + arr[i].start + "," + arr[i].end + "]");
        }
    }

    /* Driver Code
    public static void main(String args[]) {
        Interval arr[]=new Interval[4];
        arr[0]=new Interval(6,8);
        arr[1]=new Interval(1,9);
        arr[2]=new Interval(2,4);
        arr[3]=new Interval(4,7);
        mergeIntervals(arr);
    }*/


    //Approach 4 : Leet Code..... from Discussion section    (code : 1)                T.C. = O(N*log(N)), S.C. = O(n)
    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int[] curr : intervals) {
            if (curr[0] <= end) {
                end = Math.max(end, curr[1]);
            }
            else {
                ans.add(new int[] {start, end});
                start = curr[0];
                end = curr[1];
            }
        }

        ans.add(new int[] {start, end});
        return ans.toArray(new int[0][]);

    }

    public int[][] merge_2(int[][] intervals)              //(code : 2).....Logic is same as above
    {

        if(intervals.length == 1) return intervals;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> ans = new ArrayList<>();
        int[] curr_interval = intervals[0];
        ans.add(curr_interval);

        for (int[] interval : intervals) {
            int curr_end = curr_interval[1];

            int next_begin = interval[0];
            int next_end = interval[1];

            if (curr_end >= next_begin) {
                curr_interval[1] = Math.max(curr_end, next_end);

            } else {
                curr_interval = interval;
                ans.add(curr_interval);
            }
        }

        return ans.toArray(new int[ans.size()][]);

    }


    //Approach 5 : Greedy approach
    public int[][] merge_3(int[][] intervals) {

        // sort by start time
        Arrays.sort(intervals, new Comparator<int[]>(){                      //NOTE HERE.
            public int compare(int a[], int b[]){
                return (a[0] == b[0])? a[1] - b[1] : a[0] - b[0];
            }
        });

        // iterate
        ArrayList<int[]> result = new ArrayList<>();
        for(int interval[]: intervals){

            if(result.isEmpty()){
                result.add(interval);
            }else{

                // compare start of curr interval with end of prev interval
                int[] prevInterval = result.get(result.size() - 1);

                if(interval[0] <= prevInterval[1]){
                    // update the end time of merged interval
                    prevInterval[1] = Math.max(prevInterval[1], interval[1]);
                }else{
                    // add new interval
                    result.add(interval);
                }
            }
        }
        return result.toArray(int[][]::new);
    }

    //Approach 6 : via Sorting                                                          T.C. = O(N*log(N)), S.C. = O(n)
    public int[][] merge_4(int[][] intervals) {

        Arrays.sort(intervals,(a,b)->a[0]-b[0]);          //NOTE HERE.

        List<int[]> list=new ArrayList<>();
        list.add(intervals[0]);

        for(int i=1;i<intervals.length;i++)
        {
            int size=list.size();
            if(list.get(size-1)[1] >=intervals[i][0])
            {
                if(intervals[i][1]>list.get(size-1)[1])
                {
                    int b[]=list.get(size-1);
                    list.remove(size-1);
                    b[1]=intervals[i][1];
                    list.add(b);
                }
            }
            else
                list.add(intervals[i]);
        }
        int size=list.size();
        int ans[][]=new int[size][2];
        for(int i=0;i<size;i++)
        {
            ans[i][0]=list.get(i)[0];
            ans[i][1]=list.get(i)[1];
        }
        return ans;
    }



    public static void main(String[] args) {

        /* Ques : Given a set of time intervals in any order, merge all overlapping intervals into one
                  and output the result which should have only mutually exclusive intervals.


            Example : 1
            Input   : Intervals = {{1,3},{2,4},{6,8},{9,10}}
            Output  : {{1, 4}, {6, 8}, {9, 10}}
            Explanation : Given intervals : [1,3],[2,4],[6,8],[9,10], we have only two overlapping intervals
                          here,[1,3] and [2,4]. Therefore we will merge these two and return [1,4],[6,8], [9,10].

            Example : 2
            Input   : Intervals = {{6,8},{1,9},{2,4},{4,7}}
            Output  : {{1, 9}}

         *
         */

    }
}

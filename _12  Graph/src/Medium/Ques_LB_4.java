package Medium;

import java.util.ArrayList;

public class Ques_LB_4 {

    //Ques : Number of Operations to Make Network Connected............                     (Leet Code Ques no.- 1319)


    //Approach 1 : DFS Solution......(Efficient Solution.....)
    class Solution {
        public int makeConnected(int n, int[][] connections)                     //main Solution.....
        {
            int count = 0;
            boolean[] visited = new boolean[n];
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

            int m = connections.length;
            if(m < n-1)  // if there are n nodes we need atleast n-1 connections so that all of them are connected
            {
                return -1;
            }

            for(int i=0; i<n; i++)
            {
                adj.add(new ArrayList<>());
            }

            for(int[] i:connections)
            {
                adj.get(i[0]).add(i[1]);
                adj.get(i[1]).add(i[0]);
            }
            for(int i=0; i<n; i++)
            {
                if(!visited[i])
                {
                    count++;
                    dfs(i,adj,visited);

                }
            }
            return count-1;
        }
        public void dfs(int v, ArrayList<ArrayList<Integer>> adj, boolean[] visited)
        {
            visited[v] = true;
            //ans.add(v);
            for(int i=0; i<adj.get(v).size(); i++)
            {
                if(!visited[adj.get(v).get(i)])
                {
                    visited[adj.get(v).get(i)] = true;
                    dfs(adj.get(v).get(i), adj, visited);
                }
            }
        }
    }




    //Approach 2 : By Union Finding.....Disjoint Set.....(Not Effiient Solution...)
    class Solution_2 {
        public int makeConnected(int n, int[][] connections)
        {
            int[] parent = new int[n];
            for(int i = 0; i < n; i++)
                parent[i] = i;

            int cycles = 0;
            int unconnected_computers = 0;
            for(int[] link : connections)
            {
                int from = link[0];
                int to = link[1];

                if(find_parent(from, parent) == find_parent(to, parent))
                    cycles++;

                union(from, to, parent);

            }

            for(int i=0; i<n; i++)
            {
                if(parent[i] == i)
                    unconnected_computers++;
            }

            if(cycles >= unconnected_computers-1)
                return unconnected_computers-1;

            return -1;
        }

        // Method to find parent of every node.
        public int find_parent(int node, int[] parent)
        {
            if(parent[node] == node)
                return node;

            return find_parent(parent[node], parent);
        }

        // Method to create the union of two sets.
        public void union(int from, int to, int[] parent)
        {
            from = find_parent(from, parent);
            to = find_parent(to, parent);

            parent[to] = from;
        }
    }

    //Code 2 : Union....
    class Solution_3 {

        int findPar(int node, int parent[])
        {
            if(node == parent[node])
            {
                return node;
            }
            return parent[node] = findPar(parent[node], parent);
        }

        public int makeConnected(int n, int[][] connections)             //main function
        {
            int parent[] = new int[n];
            for(int i=0; i<n; i++)
            {
                parent[i]=i;
            }
            int leftWire = 0;
            int component = 0;
            int m = connections.length;
            for(int i=0; i < m; i++)
            {
                int p1 = findPar(connections[i][0], parent);
                int p2 = findPar(connections[i][1], parent);

                if(p1 != p2){
                    parent[p1] = p2;
                }
                else{
                    leftWire++;
                }
            }
            for(int i=0; i<n; i++)
            {
                if(parent[i] == i){
                    component++;
                }
            }
            return (component-1) <= leftWire   ?   component-1  :  -1;
        }
    }








    public static void main(String[] args) {

        /*Ques : There are n computers numbered from 0 to n - 1 connected by ethernet cables connections forming
                 a network where connections[i] = [ai, bi] represents a connection between computers ai and bi.
                 Any computer can reach any other computer directly or indirectly through the network.

            You are given an initial computer network connections. You can extract certain cables between two directly
            connected computers, and place them between any pair of disconnected computers to make them directly connected.

            Return the minimum number of times you need to do this in order to make all the computers connected. If it is
            not possible, return -1.


            Example : 1
            Input   : n = 4, connections = [[0,1],[0,2],[1,2]]
            Output  : 1
            Explanation : Remove cable between computer 1 and 2 and place between computers 1 and 3.



            Example : 2
            Input   : n = 6, connections = [[0,1],[0,2],[0,3],[1,2],[1,3]]
            Output  : 2


            Example : 3
            Input   : n = 6, connections = [[0,1],[0,2],[0,3],[1,2]]
            Output  : -1
            Explanation : There are not enough cables.


            // Follow the link for visual representation of the example.....
            // Link : https://leetcode.com/problems/number-of-operations-to-make-network-connected/


        *
        *
        * */
    }




}

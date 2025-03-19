package com.company;

import java.util.ArrayList;

public class NumberOfProvinces {
    public static void main(String[] args) {

    }

    public static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited){
        visited[node] = true;
        for(Integer i:adj.get(node)){
            if(!visited[i]){
                dfs(i,adj,visited);
            }
        }
    }
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();

        for(int i = 0;i<V;i++){
            adjList.add(new ArrayList<Integer>());
        }

        for(int i = 0;i<V;i++){
            for(int j =0;j<V;j++){
                if(adj.get(i).get(j) ==1 && i!=j){
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }
        // code here
        boolean[] visited = new boolean[V]; //Space Complexity -- O(N);
        int count=0;
        for(int i =0;i<V;i++){
            if(!visited[i]){
                count++;
                dfs(i,adjList,visited);
            }
        } //Time complexity --- O(N)+O(V+2E)

        return count;
    }
}

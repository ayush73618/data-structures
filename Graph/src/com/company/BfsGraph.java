package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BfsGraph {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                // adj.get(v).add(u);
            }

            ArrayList<Integer> ans = bfsOfGraph(V, adj);
            for (int i = 0; i < ans.size(); i++)
                System.out.print(ans.get(i) + " ");
            System.out.println();
        }


    }

    public static ArrayList<Integer> bfsOfGraph(int v, ArrayList<ArrayList<Integer>> adj){
     ArrayList<Integer> bfs = new ArrayList<>();
     boolean[] visited = new boolean[v+1];
        Queue<Integer> queue = new LinkedList<>();  // Space compelxity O(3N)--->>> O(N)

        queue.add(0);
        visited[0] = true;
        while(!queue.isEmpty()){
            Integer node = queue.poll();
            bfs.add(node);
      //      System.out.println(bfs);
            for(Integer i:adj.get(node)){
                if(!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }

        //Time Complexity ---- O(N) + O(2E) -- E--- Edges

        return bfs;
    }
}

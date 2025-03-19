package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DfsGraph {
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

            ArrayList<Integer> ans = dfsOfGraph(V, adj);
            for (int i = 0; i < ans.size(); i++)
                System.out.print(ans.get(i) + " ");
            System.out.println();
        }

    }

    public static ArrayList<Integer> dfsOfGraph(int v , ArrayList<ArrayList<Integer>> adj){  /// ---- Space Complexitiy (O(N));;
        boolean[] visited = new boolean[v+1];
        visited[0] = true;
        ArrayList<Integer> list = new ArrayList<>();
        dfs(0,visited,adj,list);
        return list;
    }

    public static void dfs(int node,boolean[] visited,ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> list){  /// Time Complexit -- O(N) + (2XE); E - Edges.
        visited[node] = true;
        list.add(node);
        for(Integer i:adj.get(node)){
            if(!visited[i]){
                dfs(i,visited,adj,list);
            }
        }
    }
}

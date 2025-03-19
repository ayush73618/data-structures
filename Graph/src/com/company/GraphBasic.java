package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GraphBasic {
    public static void main(String[] args) {
        int n = 5;
        ArrayList<HashMap<Integer,Integer>> graph = new ArrayList<>();

        for(int i =0;i<=n;i++){
            graph.add(new HashMap<>());
        }
        graph.get(0).put(0,0);
        graph.get(1).put(3,4);

        graph.get(1).put(4,4);


        for(int i =1;i<graph.size();i++){
                Map m = graph.get(i);
                m.forEach((key, value) -> {
                    System.out.println(key+" "+value);
                });

            }


    }
}

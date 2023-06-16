package AdvBitManipulation;

// A->0
// B->1
// C->2
// D->3


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class travellingSalesman {

    static int minCost(int dist[][] , int n , int currentCity, int visited, List<Integer> path){
        //base case
        if(visited == (1<<n)-1){

            path.add(0); // Add the starting city to the path

            return dist[currentCity][0];
            // this will return the last city where pointer is and then dist of this from 1st city
        }


        // rec case
        int cost = Integer.MAX_VALUE;
        for(int city=0; city<n; city++){

            //this means this city is not visited
            if((visited & (1<<city)) == 0){
                int currentPathCost = dist[currentCity][city] + minCost(dist,n,city,visited | (1<<city), path);

//                System.out.println( (1<<city));

                if(currentPathCost < cost){
                    cost = currentPathCost;
                    //update first element in the path
                    path.add(city);
                }
            }
        }
        return cost;
    }
    public static void main(String[] args) {

        // 2d array
        int dist[][] = {
                {0,20,42,25},
                {20,0,30,34},
                {42,30,0,10},
                {25,34,10,0},
        };

        List<Integer> path = new ArrayList<>();
        System.out.println(minCost(dist,4,0,1,path));
        System.out.println("Path is : " + Arrays.toString(path.toArray()));

    }
}

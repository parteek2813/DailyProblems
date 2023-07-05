package advHashing.java;

import java.util.HashMap;
import java.util.Scanner;

// question

//Count of Right-Angled Triangle formed from given N points whose
// base or perpendicular are parallel to X or Y axis. Given x and y coordinates
// in the form of 2D array
public class rightTriangleCount {

    static int getTriangleCount(int arr[][], int n ){
        HashMap<Integer, Integer> xpoints = new HashMap<>();
        HashMap<Integer, Integer> ypoints = new HashMap<>();

        // storing the number of points having same x or y
        for(int i =0; i<n; i++){
//            if(xpoints.containsKey(arr[i][0])){
//                xpoints.put(arr[i][0], xpoints.get(arr[i][0]) + 1);
//            }else{
//                xpoints.put(arr[i][0], 1);
//            }
            xpoints.put(arr[i][0], xpoints.getOrDefault(arr[i][0],0) + 1);
            ypoints.put(arr[i][1], ypoints.getOrDefault(arr[i][1],0) + 1);
//            if(ypoints.containsKey(arr[i][1])){
//                ypoints.put(arr[i][0], ypoints.get(arr[i][1]) + 1);
//            }else{
//                ypoints.put(arr[i][1], 1);
//            }
        }

        int count =0;

        // counting
        for(int i =0; i<n; i++){
            if((xpoints.get(arr[i][0]) >= 1) && (ypoints.get(arr[i][1]) >= 1)){
                count = count + (xpoints.get(arr[i][0]) - 1)* (ypoints.get(arr[i][1]) - 1);
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int n=5;
        int[][] arr = { { 1, 2 }, { 2, 1 },
                { 2, 2 }, { 2, 3 },
                { 3, 2 } };

        System.out.println(getTriangleCount(arr,n));
    }
}

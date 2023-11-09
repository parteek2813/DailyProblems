package codeForces906;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class twoOutOfthreeB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

       while (t-- > 0){

           int n = sc.nextInt();
           HashMap<Integer, Integer> hm = new HashMap<>();

           int[] arr = new int[n];

           for(int i =0; i<n; i++){
                arr[i] = sc.nextInt();



           }

           for( int num : arr){
               hm.put(num, hm.getOrDefault(num, 0)+1);
           }

           int[] b = new int[n]; // Array b


           boolean found = false;
           int count = 0;

           for(int value : hm.values()){
               if(value >= 2){
                   count++;
               }
           }

           if(count < 2){
               System.out.println("-1");
               break;
           }


          


       }
    }
}


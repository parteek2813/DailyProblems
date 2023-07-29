package codeForces888;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class TilesComebackC {



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int i =1; i<=t; i++){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int count = 0;
            int eq = 1;
            
            int temp =n;
            int flag = 0;


            Vector<Integer> v = new Vector<>();
            for(int j =0; j<n; j++){
                v.add(sc.nextInt());
            }


            if(v.get(0).equals(v.get(n-1))){
                for (int j = 0; j < n; j++) {
                    if (v.get(j).equals(v.get(0)))
                        count++;
                    if (count == k)
                        break;
                }

              if(count == k){
                  System.out.println("YES");
              }
              else{
                  System.out.println("NO");
              }


            }else{
                for(int j=0; j<n; j++){
                    if(v.get(j).equals(v.get(0))){
                        count++;
                    }
                    if (count == k) {
                        temp = j;
                        count = 0;
                        break;
                    }
                }

                for(int j = temp+1; j<n; j++){
                    if(v.get(j).equals((v.get(n-1)))){
                        count++;
                    }
                    if (count == k) {
                        flag = 1;
                        break;
                    }
                }

                if(flag == 1){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }

        }
    }
}

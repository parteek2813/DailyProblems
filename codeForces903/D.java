package codeForces903;

import java.util.HashMap;
import java.util.Scanner;

public class D {

    public static void solveDivide(){

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- >0) {

            int n = sc.nextInt();

            int[] arr = new int[n];


            HashMap<Integer, Integer> hs = new HashMap<>();


            // store in array
            for (int i = 0; i < n; i++) {

                int x;
                x = sc.nextInt();

                int temp = x;
                for (int j = 2; j * j < temp; j++) {
                    while (x % j == 0) {
                        hs.put(j, hs.getOrDefault(j, 0) + 1);
                        x /= j;
                    }
                }

                if (x != 1) {
                    hs.put(x, hs.getOrDefault(x, 0) + 1);
                }
            }
            boolean check = true;
            for(int i : hs.values()){
                if(i%n != 0){
                    check = false;
                    break;
                }
            }

            if(check){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }
    public static void main(String[] args) {
            solveDivide();
    }
}


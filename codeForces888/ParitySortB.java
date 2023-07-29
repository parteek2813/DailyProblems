package codeForces888;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ParitySortB {


    // BRUTEFORCE:

    static boolean solveParityBrute(int n, int[] arr) {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((arr[i] % 2 == 0 && arr[j] % 2 == 0) || (arr[i] % 2 != 0 && arr[j] % 2 != 0)) {
                    if (arr[i] > arr[j]) {
                        // Swap
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
        }

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    static void solveParityOpti(int n, ArrayList<Integer> v) {
        ArrayList<Integer> odd = new ArrayList<>();
        ArrayList<Integer> even = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int num = v.get(i);
            if (num % 2 == 1) {
                odd.add(num);
            } else {
                even.add(num);
            }
        }

        Collections.sort(odd, Collections.reverseOrder());
        Collections.sort(even, Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            if (v.get(i) % 2 == 1) {
                v.set(i, odd.get(odd.size() - 1));
                odd.remove(odd.size() - 1);
            } else {
                v.set(i, even.get(even.size() - 1));
                even.remove(even.size() - 1);
            }
        }

        // check here if sorted or not .... if yes return true otherwise false and break!
       boolean sorted = true;
        for(int i =1; i<n; i++){
            if(v.get(i) < v.get(i-1)){
                sorted = false;
                break;

            }
        }

        System.out.println(sorted ? "YES" : "NO");
    }




    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            ArrayList<Integer> v = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                v.add(sc.nextInt());
            }
            solveParityOpti(n, v);

            // Store the elements in the array
//            int[] arr = new int[n];
//            for (int i = 0; i < n; i++) {
//                arr[i] = sc.nextInt();
//            }
//            boolean res = solveParityOpti(n, arr);
//            System.out.println(res ? "YES" : "NO");
        }
    }
}

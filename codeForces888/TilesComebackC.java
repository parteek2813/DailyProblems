package codeForces888;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;



 // NOT ACCEPTED ON CODEFORCES: RUNTIME ERROR IN THIS CODE...... Otherwise working for the given test case

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


            // case if the first and the last index are same then just iterate over the array and if the next elem index in arr,
            // increment the count and if count == k break and return "YES"

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
                        temp = j;  // store the current pointer in the temp to get the group of k
                        count = 0;
                        break;
                    }
                }

                for(int j = temp+1; j<n; j++){ // from the pointer stored , start from that point and then get another set of k and if count==k , break the loop.. with flag ==1;
                    if(v.get(j).equals((v.get(n-1)))){ // we have to get the v.get to be equal to last index, to  give back "YES" !!
                        count++;
                    }
                    if (count == k) {
                        flag = 1;
                        break;
                    }
                }

                if(flag == 1){  // it means we got the same elements of k size and then also stopped at the last index too....
                    System.out.println("YES");
                }else{
                    System.out.println("NO");  // if not found
                }
            }

        }

    }
}



//import java.util.Scanner;
//
//public class TilesComebackC {
//    static long mod = 1000000007;
//
//    static void solve() {
//        Scanner scanner = new Scanner(System.in);
//        int n, k;
//        n = scanner.nextInt();
//        k = scanner.nextInt();
//
//        int[] v = new int[n];
//        int id1 = -1, id2 = -1;
//
//        for (int i = 0; i < n; i++) {
//            v[i] = scanner.nextInt();
//        }
//
//        int d = k - 1; // Corrected the value of d
//        for (int i = 0; i < n; i++) {
//            if (v[i] == v[0]) { // Corrected the comparison of vector elements
//                d--;
//            }
//            if (d == 0) {
//                id1 = i;
//                break;
//            }
//        }
//        d = k - 1; // Corrected the value of d
//        for (int i = n - 1; i > id1; i--) {
//            if (v[i] == v[n - 1]) { // Corrected the comparison of vector elements
//                d--;
//            }
//            if (d == 0) {
//                id2 = i;
//                break;
//            }
//        }
//
//        if ((v[0] == v[n - 1] && id1 != -1) || (id1 != -1 && id2 != -1)) {
//            System.out.println("YES");
//            return;
//        }
//        System.out.println("NO");
//    }
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int t = scanner.nextInt();
//        while (t-- > 0) {
//            solve();
//        }
//    }
//}

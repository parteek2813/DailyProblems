package codeForces903;

import java.util.Scanner;

public class A {

    public static int findMinimumOperations(String x, String s) {
        int n = x.length();
        int m = s.length();
        int minOperations = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int operations = 0;
            StringBuilder temp = new StringBuilder(x);
            while (!temp.toString().contains(s)) {
                temp.append(temp);
                operations++;
                if (temp.length() > n * m) {
                    operations = -1; // s cannot be obtained within the limit
                    break;
                }
            }
            if (operations != -1) {
                minOperations = Math.min(minOperations, operations);
            }
            x = x.substring(1) + x.charAt(0); // rotate x for the next iteration
        }

        return (minOperations == Integer.MAX_VALUE) ? -1 : minOperations;
    }




    public static long findMinimumOperationsNew(String x, String s, int n , int m ){
        long ans =0;
        while(true){
            // if found
            if(x.contains(s)){
                break;
            }

            if(ans != 0 && x.length() > 2 * m){
                ans = -1;
                break;
            }

            ans++;
            x+=x;
        }
        return ans;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {

            int n = scanner.nextInt();
            int m = scanner.nextInt();
            scanner.nextLine(); // consume the newline character
            String x = scanner.nextLine();
            String s = scanner.nextLine();



            long minOperations = findMinimumOperationsNew(x, s, n, m);
            System.out.println(minOperations);
        }
    }
}

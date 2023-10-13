package codeForces903;

import java.util.Scanner;

public class A {

    public static int findMinimumOperations(String x, String s) {
        int n = x.length();
        int m = s.length();
        int minOperations = Integer.MAX_VALUE;

            int operations = 0;
            StringBuilder temp = new StringBuilder(x);
            while (!temp.toString().contains(s)) {
                temp.append(temp);
                operations++;
                if (temp.length() > n * m && !temp.toString().contains(s)) {
                    operations = -1; // s cannot be obtained within the limit
                    break;
                }
            }
            if (operations != -1) {
                minOperations = Math.min(minOperations, operations);
            }


        return (minOperations == Integer.MAX_VALUE) ? -1 : minOperations;
    }


    // The main appraoch is that is we find out the string x in the string s
    // then we break the loop
    // else if ans != 0 aur x ki length > 2*m it means humne sare char consider kar liye
    // and we are not able to find string s ... so just break the loop and ans becomes -1;

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


            int minOperations = findMinimumOperations(x,s);
//            long minOperations = findMinimumOperationsNew(x, s, n, m);
            System.out.println(minOperations);
        }
    }
}

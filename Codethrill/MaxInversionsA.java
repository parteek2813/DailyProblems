package Codethrill;

/*
Geek has A number of "1" strings, B number of "10" strings and C number of "0" strings. Geek wants to concatenate these strings in any arbitrarily
order such that the inversion count in the final string is maximum.
For any binary string S, inversion count is defined as the number of pairs (i, j) such that 0 ≤ i < j ≤ N-1 and S[i] = '1' and S[j] = '0'.
So your task is to return the maximum inversion count possible in the final string.
 */

import java.util.Scanner;


public class MaxInversionsA {

    public static int solve(int A, int B, int C){
        long MOD=1000_000_000+7;
        // code here
        long max=0L;
        long a=(long)(A);
        long b=(long)(B);
        long c=(long)(C);

        //for A and B
        if(a>0 && b>0)
            max=(max+((a*b)%MOD+(((b*(b+1))/2)%MOD)%MOD)%MOD)%MOD;

        // In this case, only multiplication is done, no need of doing the +1 at the end

        if(a>0 && c>0)
        {
            max=(max+(a*c)%MOD)%MOD;
        }


        if(b>0 && c>0)
        {
            max=(max+(b*c)%MOD)%MOD+((b*(b+1)%MOD)/2)%MOD;
        }



        if(a>0 && b>0 && c>0)
            max=max-((b*(b+1)%MOD)/2)%MOD;




        if(b>0 && c==0 && a==0)
            max=((b*(b+1)%MOD)/2)%MOD;

        return (int)(max%MOD);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        int result = solve(A, B, C);
        System.out.println(result);
    }
}

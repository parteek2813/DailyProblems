package AdvBitManipulation;

// Question find the power of given a ^^ n

// Approaches

// 1) Loop multiply a,n times - [O(N) time and O(1) space]
// 2) Recursion a^^n --> (a^^n/2)^2 - [O(logN) time and O(logN space)]
// 3) Bitmasking approach


// DRYRUN:

public class findPower {
    public static void main(String[] args) {

        int n =10;
        int a =2;

        int ans=1;
        while (n>0){
            if ((n & 1) == 1) {
              ans = ans*a;
            }
            a=a*a;
            n= n>>1;
        }
        System.out.println(ans);

    }
}

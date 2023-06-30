package AdvSorting;

// question

// given a number N , find the number of trailing zeros in N! (N factorial)

public class trailingZeros {
    static int findZerosSimple(int n){
        int cnt =0;
        while(n%10 == 0){
            n= n/10;
            cnt++;
        }
        return cnt;
    }

    static double findZerosbetter(int n ){

        double num = 5;
        double k=1;


        double ans =0;
       while (n/ Math.pow(num,k) > 0){
           ans = n/Math.pow(num,k);
           k=k+1;
       }
       return ans;
    }
    public static void main(String[] args) {

        int n = 152302000;
        int res = findZerosSimple(n);
        double result = findZerosbetter(n);
        System.out.println(result);

    }
}

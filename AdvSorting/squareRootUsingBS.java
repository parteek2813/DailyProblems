package AdvSorting;

public class squareRootUsingBS {

    static double SqaureRoot(int num){
        // base case
        if(num ==0 || num ==1){
            return num;
        }

        // binary search
        double s =1;
        double e = num;
        double precision = 0.00001;
        double mid = (s+e)/2;

        while (Math.abs(mid * mid - num) > precision){

            if (mid * mid < num){
                s = mid;
            } else {
                e = mid;
                // here we don't updates the value of ans;
            }
            mid = s + (e - s) / 2;

        }

        return mid;
    }
    public static void main(String[] args) {
        int num = 99;
        System.out.println("square root of "+ num +" is: " + SqaureRoot(num));
    }
}

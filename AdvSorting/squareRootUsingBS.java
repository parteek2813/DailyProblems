package AdvSorting;

public class squareRootUsingBS {

    static  int SqaureRoot(int num){
        // base case
        if(num ==0 || num ==1){
            return num;
        }

        // binary search
        int s =1;
        int e = num;
        int ans =-1;

        while (s <= e){
            int mid = (s+e)/2;
            if (mid * mid < num){
                s = mid+1;
                ans = mid;
            } else if (mid*mid > num) {
                e = mid-1;
                // here we don't updates the value of ans;
            }else{
                return mid;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int num = 100;
        System.out.println("square root of "+ num +" is: " + SqaureRoot(num));
    }
}

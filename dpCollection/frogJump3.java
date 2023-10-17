package dpCollection;

/*
Technique to solve in 3 steps

1. Index
2. Do all stuffs on that index
3. Take the minimum(on all stuffs)

 */
public class frogJump3 {

    static int right;
    public static int frogJumpRec(int[] arr, int n){


        // base case
        if(n==0) return 0;

        // rec case
        int left = frogJumpRec(arr, n-1) +  Math.abs(arr[n] - arr[n-1]);

        if(n>1){
            right = frogJumpRec(arr, n-2) + Math.abs(arr[n] - arr[n-2]);
        }

        return Math.min(left, right);

    }
    public static void main(String[] args) {

        int[] arr = {10,20,30,10};
        int n = arr.length;


        int result = frogJumpRec(arr, n-1);
        System.out.println(result);
    }
}

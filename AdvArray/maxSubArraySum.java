package AdvArray;


// Given a 1d array , find the sum of the subarray which would be maximum among all the subarrays.
public class maxSubArraySum {

    static int MaxSum(int[] arr){
        int Csum =0;
        int Msum =0;
        int n = arr.length;
        for(int i=0; i<n; i++){
            Csum= Csum + arr[i];
            if(Csum<0){
                Csum =0;
            }
            Msum= Math.max(Csum, Msum);

        }
        return Msum;

    }
    public static void main(String[] args) {

        int[] arr = {3,5,-10,2,6,4,-1,5,-3,7,-12,4};

        int res = MaxSum(arr);
        System.out.println(res);
    }
}

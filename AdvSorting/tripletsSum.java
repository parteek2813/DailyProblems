package AdvSorting;

// question

// google interview question
// given an array count the triplets whose a(i) + a(j) + a(k) <= T where T is a target number

import java.util.Arrays;

public class tripletsSum {
    static int countBrute(int[] arr, int target){
        int n = arr.length;

        int count=0;
        for(int i =0; i<=n-3; i++){
            for(int j=i+1; j<=n-2; j++){
                for(int k=j+1; j<=n-1; j++){
                    if(arr[i] + arr[j] + arr[k] <=target){
                        count++;
                    }
                }
            }
        }
        return  count;
    }

    static int countBetter(int[] arr, int target){
        Arrays.sort(arr);
        int n = arr.length;
        int count = 0;
        for(int i=0; i<=n-3; i++ ){
            int j =i+1;
            int k = n-1;
            while (j<k){
                if(arr[j] + arr[k] > target - arr[i]){
                    k--;
                }else {
                    count = count + (k-j); // main step for reducing calc and implementing logic
                    j++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {

        int[] arr = {1,3,2,0,5,7,11};
        int target = 8;
//        int res = countBrute(arr, target);
        int res = countBetter(arr, target);
        System.out.println(res);

    }
}

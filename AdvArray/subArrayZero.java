package AdvArray;

// Subarray with Zero Sum
// Given an array of Size N , return whether the array contains a subarray with Sum==0;
// Approach - 1) Bruteforce - Time O(n^3)
// 2) PrefixSum array - Time O(n^2)


import java.util.HashMap;
import java.util.HashSet;

// Largest Continous Sequence With zero sum
// Find the largest continuous sequence in the array which sums to zero.
public class subArrayZero {

    static boolean hasZeroSum(int[] arr){
        HashSet<Integer> hs = new HashSet<>();
        int cumSum = arr[0];
        hs.add(cumSum);

        for(int i=1; i<arr.length-1; i++){
            cumSum = cumSum + arr[i];
            if(hs.contains(cumSum) || cumSum ==0){
                return true;
            }
            hs.add(cumSum);
        }
        return  false;
    }

    static void LarSum(int[] arr){
        HashMap<Integer, Integer> hm = new HashMap<>();
        int csum =0;
        int len=-1;
        int left =-1;
        int right = -1;

        hm.put(csum, -1); // At the -1 index put csum as 0

        int n = arr.length;


        for(int i=0; i<= n-1; i++){
            csum = csum + arr[i];
            if(!hm.containsKey(csum)){
                hm.put(csum, i);
            }else{

                Integer prevIndex = hm.get(csum);
                if (prevIndex != null && i - prevIndex > len) {
                    len = i - prevIndex;
                    right = i;
                    left = hm.get(csum) ;
//                    System.out.println(prevIndex);
//                    System.out.println(i);
                }
            }
        }

        System.out.println(len);
        System.out.println(left);
        System.out.println(right);


    }
    public static void main(String[] args) {
//    int arr[] = {1,4,9,-11,2,-10,6,5};
        int arr[] = {6,1,2,-3,-4,4,8};
        LarSum(arr);
    }
}

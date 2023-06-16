package AdvArray;

// Question:
//
// Given a list of numbers containing every number from 1 to N except one number which
// is Missing. Find out the Missing Number. Assume no duplicates and unordered Data set


import java.util.HashMap;

public class funChallenge {


    static int findMissingWithHashmaps(int[] arr){
        int n = arr.length;
        int sum =0;

        //create a hashmap

        HashMap<Integer, Integer> map = new HashMap<>();

        // calculate the sum of all elements in the array and store freq

        for(int i =0; i<n; i++){
            sum = sum + arr[i];
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }

        for(int i=1; i<=n+1;i++){
            if(!map.containsKey(i)){
                return i;
            }
        }

        return -1;

    }
    static int findTheMissingNumber(int[] arr){
        int n = arr.length;
        int sum =0;
        for(int i =0; i<n; i++){
            sum = sum + arr[i];
        }
        int missing = ((n+1)*(n+2))/2 -sum;
        return missing;
    }
    public static void main(String[] args) {
        int[] arr = {5,3,1,2};

        int res = findTheMissingNumber(arr);
        int hres = findMissingWithHashmaps(arr);


//        System.out.println(res);
        System.out.println(hres);
    }
}

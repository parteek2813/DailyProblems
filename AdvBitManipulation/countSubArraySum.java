package AdvBitManipulation;

import java.util.HashMap;

public class countSubArraySum {

    static int calSubArraySum(int[] arr){
        HashMap<Integer, Integer> hm = new HashMap<>();
        int hm1=0;
        hm.put(hm1, hm.getOrDefault(hm1,0));

        int m = arr.length;
        int n = arr.length;
        int count =0;

        int[] ps = new int[n];

        // update count for first prefix sum
        hm.put(ps[0] , hm.getOrDefault(ps[0] ,0) + 1);
        count = count + hm.get(ps[0]) -1;

        // Build the prefix sum
        ps[0] = arr[0] % m;

        // Array store the numbers
        // Ps[prefixSum] store the reminders
        // Hashmap store the frequency of same number

        for(int i =1; i<n; i++){

            //calculate the prefix sum array
            ps[i] = (ps[i-1] + arr[i]) % m; // this will store the reminder


            hm.put(ps[i] , hm.getOrDefault(ps[i],0) +1 );
            count += hm.get(ps[i]) - 1;

//            if(hm.get(ps[i]) ==2){
//                return true;
//            }
        }
        return count;

    }

    public static void main(String[] args) {

        int[] arr = {3,2,4,7,6,1,8};

        int res = calSubArraySum(arr);
        System.out.println(res);


    }
}

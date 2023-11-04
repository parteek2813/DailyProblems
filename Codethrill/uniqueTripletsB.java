package Codethrill;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class uniqueTripletsB {

    public static int countGeometricTriplets(int n, int r, int arr[]){
        HashMap<Integer,Integer> hash=new HashMap<>();
        for(int i=0;i<n;i++){
            hash.put(arr[i],hash.getOrDefault(arr[i],0)+1);
        }
        int count=0;
        for(Map.Entry<Integer,Integer>e:hash.entrySet()){
            // The main logic is that , get the middle element for triplets & find the prev and next in the hashset and
            // making sure anyone from prev & next is not equal to current element only, By chance.
            int x=e.getKey();
            int prev=-2;
            if(x%r==0){
                prev=x/r;
            }
            int next=x*r;
            if(next!=x&& prev!=x && hash.containsKey(prev) && hash.containsKey(next)){
                count+=(hash.get(x)*hash.get(next)*hash.get(prev));
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = 5;
        int r = 3;

        int[] arr = {81,1,9,27,3};

        int result = countGeometricTriplets(n, r, arr);
        System.out.println(result);
    }
}

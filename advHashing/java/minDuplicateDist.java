package advHashing.java;

import java.util.HashMap;

public class minDuplicateDist {

    static int findMin(int[] arr){
        HashMap<Integer, Integer> hm = new HashMap<>();

        int min = Integer.MAX_VALUE;
        for(int i=0; i<arr.length; i++){
            if(!hm.containsKey(arr[i])){
                hm.put(arr[i], i);
            }else{
                int s = hm.get(arr[i]);
                int diff= Math.abs(i-s);
                min = Math.min(min, diff);
                hm.put(arr[i], i);
            }
        }
        return min;
    }
    public static void main(String[] args) {

        int[] arr = {1,2,3,2,1,2,1,3,2};
        int res = findMin(arr);
        System.out.println(res);
    }
}

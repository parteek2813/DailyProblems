package advHashing.java;
// question

import java.util.HashMap;

// given an array , count the number of duplicate pairs , i.e
// A[i] == A[j] where i!=j
public class duplicateElem {

    static int findPairs(int[] arr){
        HashMap<Integer, Integer> hm = new HashMap<>();

        // storing the freq in the hashmap
        int ans =0;
        for( int x: arr){
            if(hm.containsKey(x)){
                ans = ans + hm.get(x);
                hm.put(x, hm.get(x) + 1);
            }else{
                hm.put(x,1);
            }
        }


        return ans;

        // counting the pairs
//        int ans =0;
//        for(Integer key: hm.keySet()){
//            if(hm.get(key) > 1){
//                int f = hm.get(key);
//                ans = ans + (f*(f-1))/2;
//            }
//        }
//        return ans;
    }




    public static void main(String[] args) {
        int[] arr = {1,3,3,1,4,5,1};
        int res = findPairs(arr);
        System.out.println(res);

    }
}


// question

import java.util.HashMap;

// given an array , count the number of duplicate pairs , i.e
// A[i] == A[j] where i!=j
public class AdvHashing {

    static int findPairs(int[] arr){
        HashMap<Integer, Integer> hm = new HashMap<>();

        // storing the freq in the hashmap
        for( int x: arr){
            hm.put(x, hm.getOrDefault(x, 0) + 1);
        }



        // counting the pairs
        int ans =0;
        for(Integer key: hm.keySet()){
            if(hm.get(key) > 1){
                int f = hm.get(key);
                ans = ans + (f*(f-1))/2;
            }
        }
        return ans;
    }




    public static void main(String[] args) {
        int[] arr = {1,3,3,1,4,5,1};
        int res = findPairs(arr);
        System.out.println(res);

    }
}

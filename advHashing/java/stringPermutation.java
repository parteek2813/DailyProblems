package advHashing.java;

// question

import java.util.HashMap;
import java.util.Map;

// given two string S1 and S2 , check whether S2 is a permutation of S1 or not.
public class stringPermutation {

    static boolean isEqualHashing(String s1, String s2){
        int len1 = s1.length();
        int len2 = s2.length();

        // Count frequency of characters in s1
        HashMap<Character, Integer> hm1 = new HashMap<>();
        for(int i =0 ; i<len1; i++){
            hm1.put(s1.charAt(i), hm1.getOrDefault(s1.charAt(i),0) + 1);
        }

        // Count frequency of characters in s2
        HashMap<Character, Integer> hm2 = new HashMap<>();
        for(int i =0 ; i<len2; i++){
            hm2.put(s2.charAt(i), hm2.getOrDefault(s2.charAt(i),0) + 1);
        }


        if(len1 != len2) {
            return false;
        } else {
            for(Map.Entry<Character, Integer> entry: hm1.entrySet()){
                Character key = entry.getKey();
                Integer value = entry.getValue();

                if(value == null){
                    if(!(hm1.get(key) == null && hm1.containsKey(key))){
                        return false;
                    }else{
                        if(!value.equals(hm2.get(key))){
                            return false;
                        }
                    }
                }

            }
        }

        return true;
    }
    public static void main(String[] args) {
        String s1= "abcdaaa";
        String s2 = "aadcb";
        boolean res = isEqualHashing(s1,s2);
        System.out.println(res);

    }
}

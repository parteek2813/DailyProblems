package gcdAdv;

import java.util.ArrayList;
import java.util.List;

public class factorialStr {

    static List<String> generatePerm(String input){
        List<String> permuation = new ArrayList<>();
        generatePermHelper("" , input, permuation);
        return permuation;
    }

    static void generatePermHelper(String prefix, String suffix, List<String> permuation){
        int n = suffix.length();

        // if suffix/String ends
        if(n ==0){
            permuation.add(prefix);
        }else{
            for(int i =0; i<n; i++){
                String newPrefix = prefix + suffix.charAt(i);
                String newSuffix = suffix.substring(0, i) + suffix.substring(i + 1);
                generatePermHelper(newPrefix, newSuffix, permuation);
            }
        }
    }
    public static void main(String[] args) {
        String input = "abc";
        List<String> permutations = generatePerm(input);
        System.out.println("Permutations of input is " + input);

        // Output the permutation
        for( String permutation: permutations){
            System.out.println(permutation);
        }
    }
}

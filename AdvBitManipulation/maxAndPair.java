package AdvBitManipulation;

// Question

// There are n elements , find a pair of elements that generates a maximum AND value.

// Two loops (Bruteforce)
public class maxAndPair {

    static int CountNumbers(int[] arr, int pattern){
        int cnt=0;
       for(int x:arr){
           if((x & pattern) == pattern){
               cnt +=1;
           }
       }
       return cnt;
    }
    public static void main(String[] args) {
        int[] arr = {21,18,25,17,16};

        int pattern =0;
        int n = arr.length;

        for(int i=31; i>=0; i--){
            // count the no of numbers having given pattern
            int count = CountNumbers(arr, pattern | (1 << i));

            if(count >= 2){
                // actually update the pattern
                pattern = (pattern | (1<<i));
            }
        }
        System.out.println(pattern);

    }
}

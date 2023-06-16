package AdvBitManipulation;

// Question

// Given an array , you find out the sum of XOR of all pairs in the array.
// Assuming that all the numbers are the non negative integers

// Example- arr{5,9,6,7};
// then find the sum like
// sum = [5^9] +[5^6] +[5^7] +[9^6] +[9^7] +[6^7]
// print sum


public class XorSum {

    static void  countXorSum(){
        int[] arr = {5,9,6,7};

        int sum =0;
        for(int i=0; i<=30; i++){
            //iterate

            int A =0;
            int B=0;
            for(int x : arr){
                if((x&(1<<i)) > 0){
                    A++;
                }else{
                    B++;
                }
            }
            int contrib = A*B*(1<<i);
            sum = sum + contrib;

        }

        System.out.println(sum);
    }
    public static void main(String[] args) {
        countXorSum();

    }
}

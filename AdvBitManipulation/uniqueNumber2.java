package AdvBitManipulation;

// Question

// Given an array containing 2N + 2 no's every elements repeats twice except 2 unique
// number . find the unique Numbers

public class uniqueNumber2 {

    static void uniqueNumber2(){
        int[] arr = {7,6,4,5,4,5,7,8};

        //step-1
        int xor=0;
        for(int x  : arr){
            xor = xor^x;
        }

        //step-2 find out the position of rightmost set bit
        int pos=0;
        int temp=xor;

        while((temp&1)!=1){
            temp = temp>>1;
            pos++;
        }

        //step-3 filter out numbers from the array which have 1 at pos

        int setA=0;
        int setB=0;
        for(int x : arr){

            //doing bitmasking to find the setbit present or not
            if((x&(1<<pos)) > 0){
                setA = setA^x;
            }else{
                setB = setB^x;
            }
        }

        // print the result
        System.out.println(setA);
//      System.out.println(setB);

        System.out.println(xor^setA);
    }
    public static void main(String[] args) {
        uniqueNumber2();
    }
}

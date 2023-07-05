package AdvLinkedList;

import java.util.Scanner;

public class recursion {

    static boolean isSorted(int[] arr, int i){
        // base case
        int n = arr.length;

        if(i == n-1){
            return true;
        }

        //rec case
        return arr[i]<arr[i+1] && isSorted(arr,i+1);
    }

    static int sumOfDigits(int N){
        int sum =0;
        for(int i=0; N>0; i++ ){
            int lastD = N%10; //reminder
            sum = sum + lastD;
            N=N/10;
        }
        return sum;

    }
    static boolean isMagic(int N){

        //base case

        if(N<10){
            if(N==1) return true;
            else return false;
        }

        //recursive case
        int finalSum = sumOfDigits(N);
        return isMagic(finalSum);

    }

    public static String modifyString(String s){

        //0 --> 01
        //1 --> 10
        StringBuilder sb = new StringBuilder();
        for(int i =0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '0'){
                sb.append("01");

            }else {
                sb.append("10");
            }
        }
        return sb.toString();
    }


    public static int generate(String s , int i, int A, int B){
    //base case
        if(i ==A){
            return (int)(s.charAt(B)- '0');
        }

        //rec case
        System.out.println(s);
        String s_dash = modifyString(s);
        return generate(s_dash, i+1,A,B);

    }

    public static int getDigit( int A, int B){
        // base case
        if(A==1){
            return 0;
        }

        // rec case
        int len = 1<<(A-1);
        int mid = len/2;

        if(B<mid){ //in first half
        return getDigit(A-1, B);
        }else{
            int digit =  getDigit(A-1, B-mid);
            return flipBit(digit); //flip the result using XOR
        }
    }

    private static  int flipBit(int bit){
        return bit ==0 ? 1: 0;
    }

    public static void main(String[] args) {

//        int[] arr = new int[5];
//        arr[0] = 1;
//        arr[1]= 3;
//        arr[2]= 7;
//        arr[3]= 5;
//        arr[4]= 9;
//
//        boolean result = isSorted(arr, 0);
//        System.out.println(result);
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter the target number");
//        boolean result = isMagic(415);
//        System.out.println(result);

//        System.out.println(modifyString("0110"));

//        System.out.println( generate("0",0,5,3));

        System.out.println(getDigit(5,4));

    }
}

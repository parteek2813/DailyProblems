package codeForces903;

import java.util.Arrays;
import java.util.Scanner;

public class B {

    public static boolean canMakeEqual(int a, int b, int c){
       
        int x = Math.abs(a-b);
        int y = Math.abs(b-c);
        int z = Math.abs(c-a);
        
        if(a==b && b==c){
            return true;
        } else if ( (a==b && c%2 == 0 && (a%c==0 || c%a == 0) || (a==c && b%2==0 && (a%b==0 || b%a==0)) || (b==c && a%2==0 && (b%a ==0 || a%b ==0)))) {
            return true;
        } else if(x==c || y==a || z == b) {
            return true;
        }

        return false;

    }

    public static boolean canMakeEqualAgain(int a, int b, int c){
        Scanner sc = new Scanner(System.in);


        int[] arr = new int[3];
        for(int i =0; i<3; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        // time in ms reduced from 6ms to 4ms after this below if condition
        if(a==b && b==c){
            return true;
        }

        int op=0;
        if(arr[1]%arr[0]==0 && arr[2]%arr[0]==0){
            op+=(arr[1]/arr[0] -1);
            op+=(arr[2]/arr[0] -1);
        }else {
            return false;
        }

        if(op<=3){
            return true;
        }

        return false;
    }

   


    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int t = scanner.nextInt();
//
//        long startTime = System.currentTimeMillis();
//
//        while (t-- > 0) {
//            int a = scanner.nextInt();
//            int b = scanner.nextInt();
//            int c = scanner.nextInt();
//
//            if(canMakeEqual(a, b, c)) {
//                System.out.println("YES");
//            }
//            else {
//                System.out.println("NO");
//            }
//        }
//
//
//        long endTime = System.currentTimeMillis();
//        long elapsedTime = endTime - startTime;
//
//        System.out.println("Elapsed time: " + elapsedTime + " milliseconds");

        String s1 = "Telusko"+"iNeuron";
        System.out.println(s1);

        String s2 = "Telusko"+99;
        System.out.println(s2);

        String s3 = "hello"+99+19+10;
        System.out.println(s3);

        String s4 = 10 + 4 + "ineuron";
        System.out.println(s4);
    }
}

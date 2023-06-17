package gcdAdv;

public class gcdDemo {

    static int getGcd(int a , int b){
        //base case

        if(a==0){
            return b;
        }

        return getGcd(b%a,a);
    }

    static  int getGcdIterative(int a , int b){
        while(a!=0){

//            int a_ = b%a;
//            int b_ = a;
//            a = a_;
//            b = b_;

            int temp = a;
            a = b%a;
            b=temp;

        }
        return b;
    }

    static int GETgcd(int a , int b){

        while(a!=0){

            int temp = a;
            a = b%a;
            b=temp;
        }
        return b;
    }
    static  int findGcdArray(int[] arr){
       int gcd = arr[0];

        for(int i=1 ; i<arr.length; i++){

        gcd =GETgcd(gcd, arr[i]);

        }
        return gcd;
    }
    public static void main(String[] args) {

        System.out.println(getGcd(12,20));
        System.out.println(getGcd(32,10));
        System.out.println(getGcd(25,212));

        int lcm = 12*20/ getGcd(12,20);
        System.out.println("lcm: " + lcm);
        System.out.println();

        System.out.println(getGcdIterative(12,20));


        int[] arr = {10,20,30,42,64};
        int res = findGcdArray(arr);
        System.out.println("Gcd of whole array is: " + res);

    }
}

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
    public static void main(String[] args) {

        System.out.println(getGcd(12,20));
        System.out.println(getGcd(32,10));
        System.out.println(getGcd(25,212));

        int lcm = 12*20/ getGcd(12,20);
        System.out.println("lcm: " + lcm);
        System.out.println();

        System.out.println(getGcdIterative(12,20));

    }
}

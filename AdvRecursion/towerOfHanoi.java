package AdvRecursion;

public class towerOfHanoi {

    // O(2^n)
    static  int steps(int n){
      if(n==0){
          return 0;
      }

      return steps(n-1) + 1 +steps(n-1);
    }

    // O(n)
    static  int stepsFaster(int n){
        if(n==0){
            return 0;
        }

        return 2*steps(n-1) + 1;
    }

    // O(1)
    static  int stepFastest(int n){

        return (1<<n) - 1;
    }
    public static void main(String[] args) {
        int n =4;

//        System.out.println(steps(20));
        System.out.println(stepsFaster(n));
        System.out.println(stepFastest(n));
    }
}

package AdvRecursion;

public class towerOfHanoiPrint {

    static void toh(int n , char src, char helper, char dest){
        if(n==0){
            return;
        }

        // from src to helper
        toh(n-1,src,dest,helper);
        System.out.println("Disk " + n + " moved from " + src + " to " + dest );

        // from helper to des
        toh(n-1,helper,src,dest);
    }
    public static void main(String[] args) {
        toh(3,'A','B','C');

    }
}

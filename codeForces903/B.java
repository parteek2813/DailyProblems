package codeForces903;

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

   


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();

            if(canMakeEqual(a, b, c)) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }
    }
}

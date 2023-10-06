package codeForces901Div3;

import java.util.Scanner;

public class aleskaAndStackB {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0){

            int n = sc.nextInt();

            int x = 1;
            for(int i =1; i<=n; i++){
                System.out.println(x+ " ");
                x = x + 2;
            }
        }
    }
}
